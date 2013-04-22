import bb.cascades 1.0

Page {
    property alias titleText: lbl_title.text
    property variant pageContent
    
    function startLoading()
    {
        activity_indicator.visible = true;
        activity_indicator.running = true;
        container_content.visible = false;
    }
    
    function stopLoading()
    {
        activity_indicator.visible = false;
        activity_indicator.running = false;
        container_content.visible = true;
    }
    
    onPageContentChanged: {
        container_content.add(pageContent);
    }

	Container {
    	layout: DockLayout {
        
        }
    	
    	ActivityIndicator {
        	id: activity_indicator 
        	preferredWidth: 200
        	preferredHeight: 200
        	visible: false
        	horizontalAlignment: HorizontalAlignment.Center
        	verticalAlignment: VerticalAlignment.Center
        }
    Container {
        id: container
        horizontalAlignment: HorizontalAlignment.Fill
        verticalAlignment: VerticalAlignment.Fill
        Container {
            horizontalAlignment: HorizontalAlignment.Fill
	        preferredHeight: 110
	        maxHeight: 110
	        layout: DockLayout {
	            
	        }
	        
	        ImageView {
	            horizontalAlignment: HorizontalAlignment.Fill
	            verticalAlignment: VerticalAlignment.Fill
	            scalingMethod: ScalingMethod.Fill
	            imageSource: "images/titlebar.png"
	        }
	        
	        Container {
                horizontalAlignment: HorizontalAlignment.Center
                verticalAlignment: VerticalAlignment.Center
                layout: StackLayout {
                    orientation: LayoutOrientation.LeftToRight
                }
                
                ImageView {
                    imageSource: "images/titlebarlogo.png"
                }
                
                Label {
		            id: lbl_title
		            verticalAlignment: VerticalAlignment.Center
		            textStyle.color: Color.create("#FFFFFF")
		        }
	        }
	    }

        Container {
            id: container_content
            horizontalAlignment: HorizontalAlignment.Fill
            verticalAlignment: VerticalAlignment.Fill
        }
    }
}
}