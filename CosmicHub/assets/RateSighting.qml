import bb.cascades 1.0

Sheet {
    content: PageTemplate {
        titleText: "Rate"
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
            leftPadding: 20
            rightPadding: 20
            topPadding: 20
            
            RateField {
                
            }
            
            TextArea {
                hintText: "Description"
                minHeight: 400
            }
            
            Button {
                text: "Rate"
            }
        }
    }
}