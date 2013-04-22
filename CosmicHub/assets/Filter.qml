import bb.cascades 1.0

Sheet {
    content: PageTemplate {
        titleText: "Filter"
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
            
            Container {
                
                layout: StackLayout {
                    orientation: LayoutOrientation.LeftToRight
                }
                
                DateTitle {
                    date_title: "From"
                }
                
                Label {
                    text: "-"
                }
                
                DateTitle {
                    date_title: "To"
                }
            }
            
            DropDown {
                title: "Location"
                options: [
                    Option {
                        text: "All locations"
                    }
                ]
            }
            
            TextField {
                hintText: "Author"
            }
            
            Button {
                text: "Filter"
            }
        }
    }
}