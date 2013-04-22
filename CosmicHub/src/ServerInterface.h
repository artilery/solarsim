/*
 * ServerInterface.h
 *
 *  Created on: Dec 11, 2012
 *      Author: melvinmusehani
 */

#ifndef SERVERINTERFACE_H_
#define SERVERINTERFACE_H_

#include <QtNetwork/qnetworkreply.h>
#include <QtNetwork/qnetworkrequest.h>
#include <QtNetwork/qnetworkaccessmanager.h>
#include <QtNetwork/qsslconfiguration.h>
#include <QtNetwork/qssl.h>
#include <QtNetwork/qsslsocket.h>
#include <QtNetwork/qnetworksession.h>
#include <qhash.h>
#include <qdatetime.h>
#include <qtimer.h>

class ServerInterface : public QObject
{
	Q_OBJECT

public:
	ServerInterface();
	virtual ~ServerInterface();

	Q_INVOKABLE void requestFunction(QString function_name);
	Q_INVOKABLE void requestFunctionPost(QString function_name);
	Q_INVOKABLE void requestFunctionDelete(QString function_name);
	Q_INVOKABLE void addParam(QString key, QString value);
	Q_INVOKABLE QString urlEncode(QString value);
	Q_INVOKABLE QString timestamp();
	Q_INVOKABLE QString toBase64(QString s);
	Q_INVOKABLE void invokeURL(QString url);
	Q_INVOKABLE void onInvokeResult();

	void startTimeout();

	static QString APP_KEY_ID;
	static QString APP_KEY_PASSWORD;
	static QString USERNAME;
	static QString PASSWORD;
	static QString URL;

private:
	QHash<QString, QString> params;
	QNetworkSession* session;
	QTimer *timer;
	QNetworkReply *reply;
	bool connected;

signals:
	void requestDone(QString data, QString con_error, int error_code);
	void invokeDone(QString data, QString con_error, int error_code);

public slots:
	void readData(QNetworkReply*);
	void timeout();
};

#endif /* SERVERINTERFACE_H_ */
