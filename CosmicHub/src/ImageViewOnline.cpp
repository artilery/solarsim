/*
 * ImageViewOnline.cpp
 *
 *  Created on: Mar 26, 2013
 *      Author: melvinmusehani
 */

#include "ImageViewOnline.h"

using namespace bb::cascades;

ImageViewOnline::ImageViewOnline()
{
	// TODO Auto-generated constructor stub
	setScalingMethod(ScalingMethod::AspectFit);
	setHorizontalAlignment(HorizontalAlignment::Fill);
	setVerticalAlignment(VerticalAlignment::Fill);

	r = NULL;
	manager = new QNetworkAccessManager(this);
	request = new QNetworkRequest();
	connect(manager, SIGNAL(finished(QNetworkReply*)), this, SLOT(readData(QNetworkReply*)));
}

ImageViewOnline::~ImageViewOnline()
{

}

void ImageViewOnline::setExternalSource(QString src)
{
	imageStatus(1);
	if (r != NULL)
	{
		r->abort();
	}
	request->setUrl(QUrl(src));
	r = manager->get(*request);
}

QString ImageViewOnline::externalSource()
{
	return "";
}

void ImageViewOnline::readData(QNetworkReply* reply)
{
	if (reply->error() != QNetworkReply::NoError)
	{
		imageStatus(2);
	}
	else
	{
		imageStatus(3);
		Image image(reply->readAll());
		setImage(image);
	}
}

