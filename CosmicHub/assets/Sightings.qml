import bb.cascades 1.0
import takealot.lib 1.0
import bb.system 1.0

NavigationPane {
    id: nav_pane

    function loadSightings() {
        page.startLoading();
        //loading_dialog.show();
        server_interface.requestFunction("getobjects.php");
    }
    
    PageTemplate {
        id: page
    titleText: "Sightings"
    
    actions: [
        ActionItem {
            title: "Filter"
            ActionBar.placement: ActionBarPlacement.OnBar
            imageSource: "images/icons/filter_icon.png"
            onTriggered: {
                var f = filter.createObject();
                f.open();
            }
        },
        
        ActionItem {
            title: "Sort"
            ActionBar.placement: ActionBarPlacement.OnBar
            imageSource: "images/icons/sort_icon.png"
            onTriggered: {
                var s = sort.createObject();
                s.open();
            }
        }
    ]
    
    attachedObjects: [
        ComponentDefinition {
            id: sighting
            source: "sighting.qml"
        },
        ComponentDefinition {
            id: sort
            content: Sort {
                
            }
        },
        ComponentDefinition {
            id: filter
            content: Filter {
                
            }
        },
        SystemDialog {
            id: dialog
            cancelButton.label: undefined
        },
        LoadingDailog {
            id: loading_dialog
            body: "Loading sightings"
        },
        ServerInterface {
            id: server_interface
            
            onRequestDone: {
                page.stopLoading();
                //loading_dialog.cancel();
                if (con_error == "")
                {
                    var json = eval('(' + data + ')');
                    
                    var count = 1;
                    var objects = new Array();
                    var object;
                    for (var i = 0; i < json.objects.length; i++)
                    {
                        //json.objects[count].image = "http://54.214.8.16/cosmic_hub/images/pic" + count + ".png";
                        object = json.objects[count];
                        object.image = "http://54.214.8.16/cosmic_hub/images/pic" + count + ".png";
                        
                        objects.push(object);
                        if (count == 8)
                        {
                            count = 1;
                        }
                        else
                        {
                            count += 1;
                        }
                    }
                    
                    array_model.clear();
                    array_model.append(objects);
                    lbl_no_items.visible = false;
                }
                else
                {
                    dialog.title = "Oops";
                    dialog.body = con_error;
                    dialog.show();
                    
                    lbl_no_items.text = "Could not connect to the server";
                    lbl_no_items.visible = true;
                }
            }
        }
    ]
    
    pageContent:
        Container {
        layout: DockLayout {
            
        }
        onCreationCompleted: {

        }
        
        Label {
            id: lbl_no_items
            textStyle.color: Color.create("#808080")
            horizontalAlignment: HorizontalAlignment.Center
            verticalAlignment: VerticalAlignment.Center
            visible: false
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
                var s = sighting.createObject();
                s.sightingInfo = array_model.data(indexPath);
                nav_pane.push(s);
            }
        }
    }
}
}