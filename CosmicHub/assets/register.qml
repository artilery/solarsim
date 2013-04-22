import bb.cascades 1.0
import bb.system 1.0
import takealot.lib 1.0

PageTemplate {
    titleText: "Register"
    pageContent: Container {
        leftPadding: 20
        rightPadding: 20
        topPadding: 20
        
        TextField {
            id: edt_username
            hintText: "Username"
        }
        
        TextField {
            id: edt_password
            hintText: "Password"
            inputMode: TextFieldInputMode.Password
        }
        
        TextField {
            id: edt_confirm
            hintText: "Confirm password"
            inputMode: TextFieldInputMode.Password
        }
        
        DropDown {
            title: "Country"
            options: [
                Option {
                    text: "South Africa"
                    value: "South Africa"
                }
            ]
        }
        
        Button {
            text: "Register"
            onClicked: {
                var error = "";
                if (edt_username.text.length == 0)
                {
                    error = "Please enter a username\n";
                }
                if (edt_password.text.length == 0)
                {
                    error += "Please enter a password\n";
                }
                else
                {
                    if (edt_password.text != edt_confirm.text)
                    {
                        error += "Password do not match\n";
                    }
                }
                
                if (error.length > 0)
                {
                    dialog.title = "Oops";
                    dialog.body = error;
                    dialog.show();
                    return;
                }

                startLoading();
                server_interface.addParam("username", edt_username.text);
                server_interface.addParam("password", edt_password.text);
                server_interface.requestFunctionPost("adduser.php");
            }
        }

        attachedObjects: [
            ServerInterface {
                id: server_interface

                onRequestDone: {
                	stopLoading();
                	
                	if (con_error == "")
                	{
                	    var json = eval('(' + data + ')');
                	    if (json.success == true)
                	    {
                	        dialog.title = "Success";
                	        dialog.body = "You have registered successfully";
                	        dialog.show();
                	        nav_pane.pop();
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
            },
            SystemDialog {
                id: dialog
                cancelButton.label: undefined
            }
        ]
    }
}