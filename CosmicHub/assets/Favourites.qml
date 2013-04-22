import bb.cascades 1.0

PageTemplate {
    titleText: "Favourites"
    pageContent: Container {
        layout: DockLayout {
            
        }
        
        Label {
            id: lbl_no_favourites
            text: "You have not added any favourites yet"
            horizontalAlignment: HorizontalAlignment.Center
            verticalAlignment: VerticalAlignment.Center
            textStyle.color: Color.create("#808080")
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
        }
    }
}