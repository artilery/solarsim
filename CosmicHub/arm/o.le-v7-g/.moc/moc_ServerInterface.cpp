/****************************************************************************
** Meta object code from reading C++ file 'ServerInterface.h'
**
** Created by: The Qt Meta Object Compiler version 63 (Qt 4.8.5)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../../../src/ServerInterface.h"
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'ServerInterface.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 63
#error "This file was generated using the moc from 4.8.5. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
static const uint qt_meta_data_ServerInterface[] = {

 // content:
       6,       // revision
       0,       // classname
       0,    0, // classinfo
      13,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       2,       // signalCount

 // signals: signature, parameters, type, tag, flags
      43,   17,   16,   16, 0x05,
      76,   17,   16,   16, 0x05,

 // slots: signature, parameters, type, tag, flags
     108,   16,   16,   16, 0x0a,
     133,   16,   16,   16, 0x0a,

 // methods: signature, parameters, type, tag, flags
     157,  143,   16,   16, 0x02,
     182,  143,   16,   16, 0x02,
     211,  143,   16,   16, 0x02,
     252,  242,   16,   16, 0x02,
     292,  286,  278,   16, 0x02,
     311,   16,  278,   16, 0x02,
     325,  323,  278,   16, 0x02,
     347,  343,   16,   16, 0x02,
     366,   16,   16,   16, 0x02,

       0        // eod
};

static const char qt_meta_stringdata_ServerInterface[] = {
    "ServerInterface\0\0data,con_error,error_code\0"
    "requestDone(QString,QString,int)\0"
    "invokeDone(QString,QString,int)\0"
    "readData(QNetworkReply*)\0timeout()\0"
    "function_name\0requestFunction(QString)\0"
    "requestFunctionPost(QString)\0"
    "requestFunctionDelete(QString)\0key,value\0"
    "addParam(QString,QString)\0QString\0"
    "value\0urlEncode(QString)\0timestamp()\0"
    "s\0toBase64(QString)\0url\0invokeURL(QString)\0"
    "onInvokeResult()\0"
};

void ServerInterface::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        Q_ASSERT(staticMetaObject.cast(_o));
        ServerInterface *_t = static_cast<ServerInterface *>(_o);
        switch (_id) {
        case 0: _t->requestDone((*reinterpret_cast< QString(*)>(_a[1])),(*reinterpret_cast< QString(*)>(_a[2])),(*reinterpret_cast< int(*)>(_a[3]))); break;
        case 1: _t->invokeDone((*reinterpret_cast< QString(*)>(_a[1])),(*reinterpret_cast< QString(*)>(_a[2])),(*reinterpret_cast< int(*)>(_a[3]))); break;
        case 2: _t->readData((*reinterpret_cast< QNetworkReply*(*)>(_a[1]))); break;
        case 3: _t->timeout(); break;
        case 4: _t->requestFunction((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 5: _t->requestFunctionPost((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 6: _t->requestFunctionDelete((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 7: _t->addParam((*reinterpret_cast< QString(*)>(_a[1])),(*reinterpret_cast< QString(*)>(_a[2]))); break;
        case 8: { QString _r = _t->urlEncode((*reinterpret_cast< QString(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< QString*>(_a[0]) = _r; }  break;
        case 9: { QString _r = _t->timestamp();
            if (_a[0]) *reinterpret_cast< QString*>(_a[0]) = _r; }  break;
        case 10: { QString _r = _t->toBase64((*reinterpret_cast< QString(*)>(_a[1])));
            if (_a[0]) *reinterpret_cast< QString*>(_a[0]) = _r; }  break;
        case 11: _t->invokeURL((*reinterpret_cast< QString(*)>(_a[1]))); break;
        case 12: _t->onInvokeResult(); break;
        default: ;
        }
    }
}

const QMetaObjectExtraData ServerInterface::staticMetaObjectExtraData = {
    0,  qt_static_metacall 
};

const QMetaObject ServerInterface::staticMetaObject = {
    { &QObject::staticMetaObject, qt_meta_stringdata_ServerInterface,
      qt_meta_data_ServerInterface, &staticMetaObjectExtraData }
};

#ifdef Q_NO_DATA_RELOCATION
const QMetaObject &ServerInterface::getStaticMetaObject() { return staticMetaObject; }
#endif //Q_NO_DATA_RELOCATION

const QMetaObject *ServerInterface::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->metaObject : &staticMetaObject;
}

void *ServerInterface::qt_metacast(const char *_clname)
{
    if (!_clname) return 0;
    if (!strcmp(_clname, qt_meta_stringdata_ServerInterface))
        return static_cast<void*>(const_cast< ServerInterface*>(this));
    return QObject::qt_metacast(_clname);
}

int ServerInterface::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QObject::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 13)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 13;
    }
    return _id;
}

// SIGNAL 0
void ServerInterface::requestDone(QString _t1, QString _t2, int _t3)
{
    void *_a[] = { 0, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)), const_cast<void*>(reinterpret_cast<const void*>(&_t3)) };
    QMetaObject::activate(this, &staticMetaObject, 0, _a);
}

// SIGNAL 1
void ServerInterface::invokeDone(QString _t1, QString _t2, int _t3)
{
    void *_a[] = { 0, const_cast<void*>(reinterpret_cast<const void*>(&_t1)), const_cast<void*>(reinterpret_cast<const void*>(&_t2)), const_cast<void*>(reinterpret_cast<const void*>(&_t3)) };
    QMetaObject::activate(this, &staticMetaObject, 1, _a);
}
QT_END_MOC_NAMESPACE
