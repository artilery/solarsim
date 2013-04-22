APP_NAME = CosmicHub

CONFIG += qt warn_on cascades10

include(config.pri)

LIBS += -lbbsystem 
QT += network

device {
    CONFIG(debug, debug|release) {
        # Device-Debug custom configuration
    }

    CONFIG(release, debug|release) {
        # Device-Release custom configuration
    }
}

simulator {
    CONFIG(debug, debug|release) {
        # Simulator-Debug custom configuration
    }
}
