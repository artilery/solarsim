/*
 * ImageViewOnline.h
 *
 *  Created on: Mar 26, 2013
 *      Author: melvinmusehani
 */

#ifndef IMAGEVIEWONLINE_H_
#define IMAGEVIEWONLINE_H_

#include <bb/cascades/controls/imageview.h>
#include <bb/cascades/controls/customcontrol.h>
#include <QtNetwork/qnetworkreply.h>
#include <QtNetwork/qnetworkrequest.h>
#include <QtNetwork/qnetworkaccessmanager.h>

class ImageViewOnline : public bb::cascades::ImageView
{
	Q_OBJECT
	Q_PROPERTY(QString externalSource READ externalSource WRITE setExternalSource NOTIFY externalSourceChanged)
public:
	ImageViewOnline();
	virtual ~ImageViewOnline();

	void setExternalSource(QString externalSource);
	QString externalSource();

private:
	bb::cascades::Image *image;
	QByteArray *data;
	QNetworkAccessManager *manager;
	QNetworkRequest *request;
	QNetworkReply *r;

signals:
	void externalSourceChanged();
	void imageStatus(int status); //1 loading 2 failed 3 success

public slots:
	void readData(QNetworkReply*);
};

#endif /* IMAGEVIEWONLINE_H_ */
