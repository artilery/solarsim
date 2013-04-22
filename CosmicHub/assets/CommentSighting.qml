import bb.cascades 1.0
import bb.system 1.0
import takealot.lib 1.0

Sheet {
    //property variant sightingInfo
    content: PageTemplate {
        id: page
    	titleText: "Comment"
    
	    actions: [
	        ActionItem {
                ActionBar.placement: ActionBarPlacement.OnBar
                title: "Cancel"
	            onTriggered: {
	                close();
	            }
	            imageSource: "images/cancel.png"
	        }
	    ]
	    
	    attachedObjects: [
            ServerInterface {
                id: server_interface

                onRequestDone: {
                    page.stopLoading();
                    if (con_error == "") 
                    {
                    	var json = eval('(' + data + ')');
                    	if (json.success == true)
                    	{
                    	    dialog.title = "Success";
                    	    dialog.body = "Comment successfully sent";
                    	    dialog.show();
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
            }
        ]
	    
	    pageContent: Container {
	        topPadding: 20
	        leftPadding: 20
	        rightPadding: 20

            TextArea {
                id: txt_comment
                hintText: "Comment"
                minHeight: 400
            }
            
            Button {
                text: "Submit"
                onClicked: {
                    console.debug("userID: " + Qt.userID + " sightingid" + Qt.sightingInfo.id)
                    page.startLoading();
                    server_interface.addParam("userId", Qt.userID);
                    server_interface.addParam("sightingId", Qt.sightingInfo.id);
                    server_interface.addParam("comment", txt_comment.text);
                    //server_interface.requestFunctionPost("comment.php");
                }
            }
            
            ListView {
                id: list_view
                dataModel: ArrayDataModel {
                    id: array_model
                }
                
                listItemComponents: [
                    ListItemComponent {
                        Container {
                            bottomPadding: 20
                            preferredWidth: 720
                            Label {
                                text: ListItemData.comment
                                bottomMargin: 0
                            }
                            
                            Container {
                                horizontalAlignment: HorizontalAlignment.Fill
                                layout: DockLayout {
                                    
                                }
                                
                                Label {
                                    text: ListItemData.author
                                    topMargin: 0
                                    bottomMargin: 0
                                    textStyle.fontWeight: FontWeight.Bold
                                }
                                Label {
                                    text: ListItemData.date
                                    horizontalAlignment: HorizontalAlignment.Right
                                    textStyle.color: Color.create("#808080")
                                }
                            }
                        }
                    }
                ]
                
                onCreationCompleted: {
                    //var comments = new Array();
                    var comment;
                    /*for (var i = 0; i < 10; i++)
                    {
                        comment = new Object();
                        comment.comment = "Wow, I saw that too";
                        comment.author = "Melvin";
                        comment.date = "20/08/2012"
                        array_model.append(comment);
                        //comments.push(comment);
                    }*/
                    comment = new Object();
                    comment.comment = "Wow, I saw that too";
                    comment.author = "Melvin";
                    comment.date = "20/08/2012"
                    array_model.append(comment);

                    comment = new Object();
                    comment.comment = "we still exploring that here at SANSA cool";
                    comment.author = "Dr Z.Zulu";
                    comment.date = "22/08/2012"
                    array_model.append(comment);

                    comment = new Object();
                    comment.comment = "cant wait to here from u!";
                    comment.author = "Melvin";
                    comment.date = "23/08/2012"
                    array_model.append(comment);

                    comment = new Object();
                    comment.comment = "soon";
                    comment.author = "Dr Z.Zulu";
                    comment.date = "24/08/2012"
                    array_model.append(comment);
                }
            }
        }
    }
}