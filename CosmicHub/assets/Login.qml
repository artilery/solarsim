import bb.cascades 1.0
import bb.system 1.0
import takealot.lib 1.0

Sheet {
    signal isLoggedIn();
    
	content: NavigationPane {
	    id: nav_pane
	    PageTemplate {
	        id: page
	    titleText: "Login"
	    
	    actions: [
	        ActionItem {
	            onTriggered: {
	            	close();
	            }
	            
	            title: "Cancel"
	            ActionBar.placement: ActionBarPlacement.OnBar
	            imageSource: "images/cancel.png"
	        },
	        ActionItem {
	            title: "Register"
                ActionBar.placement: ActionBarPlacement.OnBar
                    imageSource: "images/register.png"

                    onTriggered: {
                    var s_register = register.createObject();
                    nav_pane.push(s_register);
                }
            }
	    ]
	    
	    attachedObjects: [
	        SystemDialog {
            	id: dialog
            	cancelButton.label: undefined
            },
	        ComponentDefinition {
         		id: register
         		source: "register.qml"
         	},
	        ServerInterface {
	            id: server_interface
	            
	            onRequestDone: {
	                page.stopLoading();
	                if (con_error == "")
	                {
	                    var json = eval('(' + data + ')');
	                    if (json.success == true)
	                    {
	                        Qt.userID = json.userid;
	                        dialog.title = "Success";
	                        dialog.body = "You have been logged in successfully";
	                        dialog.show();
	                        close();
	                        Qt.logged_in = true;
	                        isLoggedIn();
	                    }
	                    else
	                    {
	                        dialog.title = "Oops";
	                        dialog.body = json.message;
	                        dialog.show();
	                    }
	                }
	                else
	                {
	                    dialog.title = "Oops";
	                    dialog.body = con_error;
	                    dialog.show();
	                }
	            }
	        }
	    ]
	    
	    pageContent: Container {
	        leftPadding: 20
	        rightPadding: 20
	        topPadding: 20
	        
	        TextField {
	            id: txt_username
	            hintText: "Username"
	        }
	        
	        TextField {
	            id: txt_password
	            hintText: "Password"
	            inputMode: TextFieldInputMode.Password
	        }
	        
	        Button {
	            text: "Login"
	            onClicked: {
	                page.startLoading();
	                var error = "";
	                if (txt_username.text.length == 0)
	                {
	                    error = "Please enter a username\n";
	                }
	                
	                if (txt_password.text.length == 0)
	                {
	                    error += "Please enter a password\n";
	                }
	                
	                if (error.length > 0)
	                {
	                    dialog.title = "Oops";
	                    dialog.body = error;
	                    dialog.show();
	                }
	                else
	                {
	                    server_interface.addParam("username", txt_username.text);
	                    server_interface.addParam("password", txt_password.text);
	                    server_interface.requestFunction("login.php");
	                    /*dialog.title = "Success";
	                    dialog.body = "You have logged in successfully";
	                    dialog.show();
	                    isLoggedIn();
	                    Qt.logged_in = true;
	                    close();*/
	                }
	            }
	        }
	    }
	}
}
}