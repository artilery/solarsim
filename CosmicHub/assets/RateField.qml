import bb.cascades 1.0

Container {
    property int rating: 0
    property bool active
    property int starSize: 60
    maxHeight: starSize + 10
    
    active: true
    onRatingChanged: {
        switch (rating)
        {
            case 1:
            {
                btn1.defaultImage = img_selected.image;
                break;  
            }
            case 2:
            {
                btn1.defaultImage = img_selected.image;
                btn2.defaultImage = img_selected.image;
                break;  
            }
            case 3:
            {
                btn1.defaultImage = img_selected.image;
                btn2.defaultImage = img_selected.image;
                btn3.defaultImage = img_selected.image;
                break;  
            }
            case 4:
            {
                btn1.defaultImage = img_selected.image;
                btn2.defaultImage = img_selected.image;
                btn3.defaultImage = img_selected.image;
                btn4.defaultImage = img_selected.image;
                break;  
            }
            case 5:
            {
                btn1.defaultImage = img_selected.image;
                btn2.defaultImage = img_selected.image;
                btn3.defaultImage = img_selected.image;
                btn4.defaultImage = img_selected.image;
                btn5.defaultImage = img_selected.image;
                break;  
            }
                  
        }
    }
    
    layout: StackLayout {
        orientation: LayoutOrientation.LeftToRight            
    }
    
    layoutProperties: StackLayoutProperties {
        spaceQuota: 2
    }
    
    attachedObjects: [
        ImageView {
            id: img_selected
            imageSource: "asset:///images/rating_star_selected_small.png"
            minWidth: starSize
            minHeight: starSize
            scalingMethod: ScalingMethod.AspectFit
        },
        
        ImageView {
            id: img_unselected
            imageSource: "asset:///images/rating_star_unselected_small.png"
            minWidth: starSize
            minHeight: starSize
            scalingMethod: ScalingMethod.AspectFit
        }
    ]
    
    ImageButton {
        id: btn1
        defaultImage: img_unselected.image
        minWidth: starSize
        minHeight: starSize
        onClicked: {
            if (active)
            {
	            btn1.defaultImage = img_selected.image
	            btn2.defaultImage = img_unselected.image
	            btn3.defaultImage = img_unselected.image
	            btn4.defaultImage = img_unselected.image
	            btn5.defaultImage = img_unselected.image
	            rating = 1;
	        }
        }
    }   
    
    ImageButton {
        id: btn2
        defaultImage: img_unselected.image
        minWidth: starSize
        minHeight: starSize
        onClicked: {
            if (active)
            {
	            btn1.defaultImage = img_selected.image
	            btn2.defaultImage = img_selected.image
	            btn3.defaultImage = img_unselected.image
	            btn4.defaultImage = img_unselected.image
	            btn5.defaultImage = img_unselected.image
	            rating = 2;
	        }
        }
    }  
    
    ImageButton {
        id: btn3
        defaultImage: img_unselected.image
        minWidth: starSize
        minHeight: starSize
        onClicked: {
            if (active)
            {
	            btn1.defaultImage = img_selected.image
	            btn2.defaultImage = img_selected.image
	            btn3.defaultImage = img_selected.image
	            btn4.defaultImage = img_unselected.image
	            btn5.defaultImage = img_unselected.image
	            rating = 3;
            }
        }
    }  
    
    ImageButton {
        id: btn4
        defaultImage: img_unselected.image
        minWidth: starSize
        minHeight: starSize
        onClicked: {
            if (active)
            {
	            btn1.defaultImage = img_selected.image
	            btn2.defaultImage = img_selected.image
	            btn3.defaultImage = img_selected.image
	            btn4.defaultImage = img_selected.image
	            btn5.defaultImage = img_unselected.image
	            rating = 4;
	        }
        }
    }  
    
    ImageButton {
        id: btn5
        defaultImage: img_unselected.image
        minWidth: starSize
        minHeight: starSize
        onClicked: {
            if (active)
            {
	            btn1.defaultImage = img_selected.image
	            btn2.defaultImage = img_selected.image
	            btn3.defaultImage = img_selected.image
	            btn4.defaultImage = img_selected.image
	            btn5.defaultImage = img_selected.image
	            rating = 5;
	        }
        }
    }  
}