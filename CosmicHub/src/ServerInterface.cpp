/*
 * ServerInterface.cpp
 *
 *  Created on: Dec 11, 2012
 *      Author: melvinmusehani
 */

#include "ServerInterface.h"
#include <qdebug.h>
#include <qcryptographichash.h>
#include <bb/system/InvokeAction>
#include <bb/system/InvokeQueryTargetsReply>
#include <bb/system/InvokeQueryTargetsRequest>
#include <bb/system/InvokeReply>
#include <bb/system/InvokeRequest>
#include <bb/system/InvokeTarget>
#include <bb/system/InvokeTargetReply>
#include <bb/system/InvokeManager>
//#include "qskeinhash.h"

QString ServerInterface::APP_KEY_ID = "179771808";
QString ServerInterface::APP_KEY_PASSWORD = "blackberrySosPassw0rd";
QString ServerInterface::USERNAME = "marion_1@4isoft.co.za";
QString ServerInterface::PASSWORD = "Password123no1";
QString ServerInterface::URL = "http://54.214.8.16/cosmic_hub/";

using namespace bb::system;

ServerInterface::ServerInterface()
{
	timer = new QTimer(this);
	connected = false;
}

ServerInterface::~ServerInterface() {
	// TODO Auto-generated destructor stub
}

void ServerInterface::requestFunction(QString function_name)
{
	QString url = URL + function_name;

	QList<QString> keys = params.keys();
	int size = keys.length();
	QString key;
	QString value;
	for (int i = 0; i < size; i++)
	{
		key = keys[i];
		value = params.value(key);

		if (i == 0)
		{
			url += "?";
		}
		else
		{
			url += "&";
		}

		url += key + "=" + value;
	}

	qDebug() << url;
	params.clear();

	QNetworkRequest request;
	request.setRawHeader("X-Tal-Platform","bb");
	request.setUrl(QUrl::fromEncoded(url.toAscii()));
	//QSslSocket::setProtocol(QSsl:SslV3);

	QSslConfiguration cfg(request.sslConfiguration());
	cfg.setPeerVerifyMode(QSslSocket::VerifyNone);
	cfg.setPeerVerifyDepth(1);
	cfg.setSslOption(QSsl::SslOptionDisableSessionTickets, true);
	cfg.setProtocol(QSsl::TlsV1);
	request.setSslConfiguration(cfg);

	QNetworkAccessManager *manager = new QNetworkAccessManager(this);
	connect(manager, SIGNAL(finished(QNetworkReply*)), this, SLOT(readData(QNetworkReply*)));
	reply = manager->get(request);
	startTimeout();
}

void ServerInterface::requestFunctionPost(QString function_name)
{
	QString url = URL + function_name;

	QList<QString> keys = params.keys();
	int size = keys.length();
	QString key;
	QString value;
	QString post_params;

	for (int i = 0; i < size; i++)
	{
		key = keys[i];
		value = params.value(key);

		if (i == 0)
		{
			post_params += "";
		}
		else
		{
			post_params += "&";
		}

		post_params += key + "=" + value;
	}
	qDebug() << "dEBU: " + post_params;
	//QByteArray data;
	//data = post_params.encodedQuery();

	QNetworkRequest request;
	request.setUrl(QUrl(url));
	request.setRawHeader("X-Tal-Platform","bb");
	QSslConfiguration cfg(request.sslConfiguration());
	cfg.setPeerVerifyMode(QSslSocket::VerifyNone);
	cfg.setPeerVerifyDepth(1);
	cfg.setProtocol(QSsl::TlsV1);
	cfg.setSslOption(QSsl::SslOptionDisableSessionTickets, true);
	request.setSslConfiguration(cfg);

	params.clear();
	qDebug() << url;

	QNetworkAccessManager *manager = new QNetworkAccessManager;
	connect(manager, SIGNAL(finished(QNetworkReply*)), this, SLOT(readData(QNetworkReply*)));
	reply = manager->post(request, post_params.toAscii());
	startTimeout();
}

void ServerInterface::requestFunctionDelete(QString function_name)
{
	QString url = URL + function_name;

	QList<QString> keys = params.keys();
	int size = keys.length();
	QString key;
	QString value;
	for (int i = 0; i < size; i++)
	{
		key = keys[i];
		value = params.value(key);

		if (i == 0)
		{
			url += "?";
		}
		else
		{
			url += "&";
		}

		url += key + "=" + value;
	}

	qDebug() << url;
	params.clear();

	QNetworkRequest request;
	request.setRawHeader("X-Tal-Platform","bb");
	request.setUrl(QUrl::fromEncoded(url.toAscii()));
	//QSslSocket::setProtocol(QSsl:SslV3);

	QSslConfiguration cfg(request.sslConfiguration());
	cfg.setPeerVerifyMode(QSslSocket::VerifyNone);
	cfg.setPeerVerifyDepth(1);
	cfg.setSslOption(QSsl::SslOptionDisableSessionTickets, true);
	cfg.setProtocol(QSsl::TlsV1);
	request.setSslConfiguration(cfg);

	QNetworkAccessManager *manager = new QNetworkAccessManager(this);
	connect(manager, SIGNAL(finished(QNetworkReply*)), this, SLOT(readData(QNetworkReply*)));
	reply = manager->deleteResource(request);
	startTimeout();
}

void ServerInterface::startTimeout()
{
	//QTimer::singleShot(30000, this, SLOT(timeout()));
	timer->setSingleShot(true);
	timer->start(30000);
	connect(timer, SIGNAL(timeout()), this, SLOT(timeout()));
}

void ServerInterface::timeout()
{
	qDebug() << "Close connection";
	reply->abort();
	//emit requestDone("", "Connection to Takealot's server was timed out. Please try again later");
}

void ServerInterface::readData(QNetworkReply* reply)
{
	timer->stop();
	if (reply->error() == QNetworkReply::NoError)
	{
		QString s = QString(reply->readAll());
		qDebug() << s;
		emit requestDone(s, "", reply->error());
	}
	else
	{
		emit requestDone("", "Connecting to Cosmic Hub's server timed out. Please make sure you have a working Internet connection and try again", reply->error());
	}
}

QString ServerInterface::urlEncode(QString value)
{
	return QUrl::toPercentEncoding(value);
}

void ServerInterface::addParam(QString key, QString value)
{
	params.insert(key, value);
}

QString ServerInterface::timestamp()
{
	uint time = QDateTime::currentMSecsSinceEpoch();

	return QString::number(time);
}

QString ServerInterface::toBase64(QString s)
{
	return QString(s.toAscii().toBase64());
}

void ServerInterface::invokeURL(QString uri)
{
	qDebug() << "Starting invoke url : "+uri;
	//QString uri = "http://www.google.co.za/";
	InvokeManager invokeManager;
	InvokeRequest request;
	// Who do we want to send the invoke request to?
	request.setTarget("sys.browser");
	request.setAction("bb.action.VIEW");
	//request.setMimeType("text");
	request.setUri(uri);

	/*InvokeRequest cardRequest;
	cardRequest.setTarget("sys.browser");
	cardRequest.setAction("bb.action.VIEW");
	cardRequest.setMimeType("text");
	cardRequest.setUri(uri);*/

	InvokeTargetReply *reply = invokeManager.invoke(request);

	    if (reply) {
	    	qDebug() << "Reply created.";
	    	reply->setParent(this);

	        // Ensure that processInvokeReply() is called when the invocation has finished
	        QObject::connect(reply, SIGNAL(finished()), this, SLOT(onInvokeResult()));
	    } else {
	    	QString s = "";
	    	qDebug() << "Invoke Failed! InvokeReply is empty.";
	    	emit invokeDone(s, "Invoke Failed! InvokeReply is empty.", 3);
	        //m_errorMessage = tr("Invoke Failed! InvokeReply is empty.");
	       // emit errorMessageChanged();
	        return;
	    }


	//InvokeTargetReply *reply = invokeManager.invoke(request);
	//_invokeTargetReply = invokeManager.invoke(request);
	/**/
}

void ServerInterface::onInvokeResult()
{
	InvokeReply *_invokeTargetReply = qobject_cast<InvokeReply*>(sender());
	QString s = "";
    // Check for errors
    switch(_invokeTargetReply->error()) {
        // Invocation could not find the target
        // did we use the right target ID?
    case InvokeReplyError::NoTarget: {
    	qDebug() << "invokeFinished(): Error: no target";
    	emit invokeDone(s, "invokeFinished(): Error: no target", 1);
            break;
        }
        // There was a problem with the invoke request
        // did we set all the values correctly?
    case InvokeReplyError::BadRequest: {
    	qDebug() << "invokeFinished(): Error: bad request";
    	emit invokeDone(s, "invokeFinished(): Error: bad request", 2);
            break;
        }
        // Something went completely
        // wrong inside the invocation request
        // Find an alternate route :(
    case InvokeReplyError::Internal: {
    	qDebug() << "invokeFinished(): Error: internal";
            emit invokeDone(s, "invokeFinished(): Error: internal", 3);
            break;
        }
        // Woohoo! The invoke request was successful
    default:
    	qDebug() << "invokeFinished(): Invoke Succeeded";
        emit invokeDone(s, "", 0);

        break;
    }

    // A little house keeping never hurts...
    //delete _invokeTargetReply;

    _invokeTargetReply->deleteLater();

    /**/
}
