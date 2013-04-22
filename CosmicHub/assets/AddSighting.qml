import bb.cascades 1.0

Sheet {
	PageTemplate {
	    actions: [
	        ActionItem {
	            title: "Cancel"
	            ActionBar.placement: ActionBarPlacement.OnBar
	            onTriggered: {
	                close();
             	}
	        }
	    ]
	    
	    titleText: "Add Sighting"
	    pageContent: Container {
	        leftPadding: 20
	        rightPadding: 20
	        topPadding: 20
	        
	        TextField {
	            hintText: "Perihelion distance"
	            inputMode: TextFieldInputMode.NumbersAndPunctuation
	        }
	
	        DateTimePicker {
	            title: "Perihelion date"
	            maximum: new Date();
	        }
	        
	        TextField {
	            hintText: "Eccentricity"
	            inputMode: TextFieldInputMode.NumbersAndPunctuation
	        }
	        
	        DropDown {
	            title: "Orbit Type"
	            options: [
	                Option {
	                    text: "Amor"
	                    value: "Amor"
	                },
	                Option {
	                    text: "Apollo"
	                    value: "Apollo"
	                },
	                Option {
	                    text: "Aten"
	                    value: "Aten"
	                },
	                Option {
	                    text: "Libration"
	                    value: "Libration"
	                }
	            ]
	        }
	        
	        TextArea {
	            hintText: "Description"
	        }
	        
	        Button {
	            text: "Submit"
	        }
	    }
	}
}