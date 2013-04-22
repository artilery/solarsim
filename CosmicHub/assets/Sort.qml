import bb.cascades 1.0

Sheet {
    content: PageTemplate {
        titleText: "Sort"
        actions: [
            ActionItem {
                title: "Cancel"
                ActionBar.placement: ActionBarPlacement.OnBar
                onTriggered: {
                    close();
                }
                imageSource: "images/cancel.png"
            }
        ]

        pageContent: Container {
        
	        ListView {
	            id: list_view
	            dataModel: ArrayDataModel {
	                id: array_model
	            }
	            
	            onCreationCompleted: {
	                array_model.append("Ascending name");
	                array_model.append("Descending name");
	                array_model.append("Ascending date");
	                array_model.append("Descending date");
	                array_model.append("Ascending rating");
	                array_model.append("Descending rating");
	            }
	            
	            onTriggered: {
                	close();
                }
	        }
	    }
    }
}