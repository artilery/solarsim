import bb.cascades 1.0

ListItemComponent {
    Container {
        layout: DockLayout {
            
        }
        
        ImageView {
            imageSource: "images/gradiantbar.png"
            horizontalAlignment: HorizontalAlignment.Fill
            verticalAlignment: VerticalAlignment.Fill
            scalingMethod: ScalingMethod.Fill
        }
    
		Container {
		    leftPadding: 20
		    rightPadding: 20
		    topPadding: 20
		    bottomPadding: 20
		    layout: StackLayout {
		        orientation: LayoutOrientation.LeftToRight
		    }
		    
		    OnlineImageView {
          		preferredWidth: 200
          		preferredHeight: 200
          		imageSource: ListItemData.image
          	}
		    
		    Container {
		        leftPadding: 20
		        preferredWidth: 520
		        
		        Label {
		            id: lbl_name
		            text: ListItemData.name + " (" + ListItemData.id + ")"
		            topMargin: 2
		            bottomMargin: 2
		        }
		        
		        Label {
		            id: lbl_date
		            text: "20 August 2012"
		            textStyle.color: Color.create("#808080")
		            bottomMargin: 2
		            topMargin: 2
		            textStyle.fontSize: FontSize.Small
		        }
		        
		        Label {
		            id: lbl_saw
		            text: "Anonymous"
		        }
		        
		        Label {
		            id: lbl_au
		            horizontalAlignment: HorizontalAlignment.Fill
		            text: ListItemData.a + " AU"
		            textStyle.textAlign: TextAlign.Right
		            textStyle.fontSize: FontSize.XXSmall
		        }
		    }
		    
		    Divider {
		        horizontalAlignment: HorizontalAlignment.Fill
		    }
		}
	}
}