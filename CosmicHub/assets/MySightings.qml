import bb.cascades 1.0
import bb.system 1.0

PageTemplate {
    titleText: "My Sightings"
    
    function loadSightings()
    {
        if (Qt.logged_in == false)
        {   
            action_add.enabled = false;
            var f = function()
            {
                if (dialog_login.result == 2)
                {
                    callLogin();
                }
                dialog_login.finished.disconnect(f);
            };
            dialog_login.finished.connect(f);
            dialog_login.show();
        }
    }
    
    function callLogin()
    {
        var fIsLoggedIn = function() {
            action_add.enabled = true;
            container_no_items.visible = false;
            
            if (array_model.size() == 0)
            {
                lbl_no_items.text = "You have not recorded any sightings yet";
                //btn_login.visible = false;
                container_no_items.visible = true;
            }
        };

        var sheet_login = login.createObject();
        sheet_login.isLoggedIn.connect(fIsLoggedIn);
        sheet_login.open();
    }
    
    actions: [
        ActionItem {
            id: action_add
            title: "Add"
            ActionBar.placement: ActionBarPlacement.OnBar
            imageSource: "images/icons/add_icon.png"
            onTriggered: {
                var s_add = add_sighting.createObject();
                s_add.open();
            }
        }
    ]

    pageContent: Container {
        layout: DockLayout {
            
        }
        onCreationCompleted: {
            var sighting;

            /*for (var i = 0; i < 5; i ++) {
                sighting = new Object();
                sighting.name = "Cerberus";
                sighting.date = "20 August 2012"
                sighting.au = 1.34;

                array_model.append(sighting);
            }*/
        }
        
        Container {
            id: container_no_items
            horizontalAlignment: HorizontalAlignment.Center
            verticalAlignment: VerticalAlignment.Center
            Label {
	            id: lbl_no_items
	            textStyle.color: Color.create("#808080")
	            textStyle.fontStyle: FontStyle.Italic
	            text: "To view your sighting you need to login"
	        }
            
            /*Button {
                id: btn_login
                horizontalAlignment: HorizontalAlignment.Center
                text: "Login"
                
                onClicked: {
                    callLogin();
                }
            }*/
        }

        ListView {
            id: list_view

            dataModel: ArrayDataModel {
                id: array_model
            }

            listItemComponents: [
                SightingItem {
                	
                }
            ]
            
            onTriggered: {
                var s_sighting = sighting.createObject();
            }
        }
    }
    
    attachedObjects: [
        ComponentDefinition {
            id: sighting
            source: "sighting.qml"
        },
        SystemDialog {
            id: dialog_login
            cancelButton.label: "Cancel"
            confirmButton.label: "Login"
            body: "To view your sightings, you need to login"
            title: "Oops"
        },
        ComponentDefinition {
            id: login
            content: Login {
                
            }
        },
        ComponentDefinition {
            id: add_sighting
            content: AddSighting {
                
            }
        }
    ]
}