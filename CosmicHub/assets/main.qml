// Default empty project template
import bb.cascades 1.0

TabbedPane {
    onCreationCompleted: {
        Qt.logged_in = false;
        sightings.loadSightings();
    }
    
    tabs: [
        Tab {
            title: "Sighting"
            content: Sightings {
            	id: sightings
            }
            imageSource: "images/icons/sighting_icon.png"
            onTriggered: {
                sightings.loadSightings();
            }
        },
        
        Tab {
            title: "My Sightings"
            imageSource: "images/icons/mysightings_icon.png"
            content: MySightings {
                id: my_sightings
            }
            
            onTriggered: {
                console.debug("asfd");
                my_sightings.loadSightings();
            }
        },
        Tab {
            title: "Favourites"
            imageSource: "images/favorites.png"
            content: Favourites {

            }
        },
        Tab {
            title: "Cosmic View"
            content: CosmicView {
                
            }
        }
    ]
}

