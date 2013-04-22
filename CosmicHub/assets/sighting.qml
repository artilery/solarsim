import bb.cascades 1.0

PageTemplate {
    titleText: "Sighting"
    property variant sightingInfo
    
    onSightingInfoChanged: {
        img_sighting.imageSource = sightingInfo.image;

        var v = new Array();
        v["a"] = "Semi major axis";
        v["e"] = "Eccentricity";
        v["h"] = "Absolute Magnitude";
        v["i"] = "Inclination";
        v["m"] = "Mean Anomaly";
        v["n"] = "Mean daily motion";
        v["nn"] = "Ascending node";
        v["p"] = "period";
        v["q"] = "Arhelion distance";
        v["w"] = "Argument of Perhelion";

        for (var i in sightingInfo) {
            if (i == "name" || i == "id") 
            	continue;

            if (i != "image") 
            {
                var l = line.createObject();
                l.key = v[i];
                l.value = sightingInfo[i];
                container_values.add(l);
            }
        }
    }
    
    actions: [
        ActionItem {
            title: "Comment"
            ActionBar.placement: ActionBarPlacement.OnBar
            onTriggered: {
                var c = comment.createObject();
                Qt.sightingInfo = sightingInfo;
                //comment.sightingInfo = sightingInfo;
                c.open();
            }
            imageSource: "images/comment.png"
        },
        
        ActionItem {
            title: "Rate"
            ActionBar.placement: ActionBarPlacement.OnBar
            onTriggered: {
                var r = rate.createObject();
                r.open();
            }
            imageSource: "images/rate.png"
        },
        
        ActionItem {
            title: "Add to favourites"
            imageSource: "images/favorites.png"
            onTriggered: {
                
            }
        },

        InvokeActionItem {
            query {
                mimeType: "text/plain"
                invokeActionId: "bb.action.SHARE"
            }
            onTriggered: {
                data = "The object \"" + sightingInfo.name + "(" + sightingInfo.id + ")" + "\" shared using Cosmic Hub";
                
                var v = new Array();
                v["a"] = "Semi major axis";
                v["e"] = "Eccentricity";
                v["h"] = "Absolute Magnitude";
                v["i"] = "Inclination";
                v["m"] = "Mean Anomaly";
                v["n"] = "Mean daily motion";
                v["nn"] = "Ascending node";
                v["p"] = "period";
                v["q"] = "Arhelion distance";
                v["w"] = "Argument of Perhelion";
                
                for (var i in sightingInfo)
                {
                    if (i == "name" || i == "id")
                    	continue;
                    	
                    if (i != "image")
                    	data += "\n" + v[i] + ": " + sightingInfo[i];
                }
            }
        }

    ]
    
    attachedObjects: [
        ComponentDefinition {
            id: line
            content: Container {
                property alias boxColor: container1.background
                property alias key: lbl_key.text
                property alias value: lbl_value.text
                
                layout: StackLayout {
                    orientation: LayoutOrientation.LeftToRight
                }
                bottomMargin: 2
                
                Container {
                    id: container1
                    preferredWidth: 460
                    leftPadding: 20
                    topPadding: 20
                    bottomPadding: 20
                    rightPadding: 20
                    rightMargin: 2
                    background: Color.create("#E0E0E0")
                    
                    Label {
                        id: lbl_key
                        text: "Key"
                    }
                }
                
                Container {
                    id: container2
                    preferredWidth: 260
                    leftPadding: 20
                    topPadding: 20
                    bottomPadding: 20
                    rightPadding: 20
                    background: Color.create("#E0E0E0")

                    Label {
                        id: lbl_value
                        text: "Value"
                    }
                }
            }
        },
        ComponentDefinition {
            id: rate
            content: RateSighting {
                
            }
        },
        ComponentDefinition {
            id: comment
            content: CommentSighting {
                
            }
        }
    ]
    
    pageContent: Container {
        horizontalAlignment: HorizontalAlignment.Fill
        leftPadding: 20
        topPadding: 20
        rightPadding: 20
        
        OnlineImageView {
            id: img_sighting
            preferredWidth: 400
            preferredHeight: 400
            horizontalAlignment: HorizontalAlignment.Center
        }
        
        Container {
        	rightPadding: 6
            layout: DockLayout {
                
            }
            ImageView {
                horizontalAlignment: HorizontalAlignment.Fill
                verticalAlignment: VerticalAlignment.Fill
                imageSource: "images/ratingsbar.png"
            }
        Container {
            leftPadding: 20
            topPadding: 20
            bottomPadding: 20
            rightPadding: 20
            layout: StackLayout {
                orientation: LayoutOrientation.LeftToRight
            }
	        Container {
	            preferredWidth: 360
		        Label {
		            id: lbl_name
		            text: "Cerberus"
		        }
		        
		        Label {
		            id: lbl_by
		            text: "by Anonymous"
		            textStyle.fontSize: FontSize.XSmall
		            textStyle.color: Color.create("#808080")
		        }
	        }
	        
	        Container {
            	preferredWidth: 360
            	verticalAlignment: VerticalAlignment.Center
            	RateField {
            	    active: false
                }
            }
        }
        }
        
        ScrollView {
	        Container {
	            id: container_values
	        }
        }
    }
}