import bb.cascades 1.0
import takealot.lib 1.0
import bb.system 1.0

Container {
    id: container
    property alias imageSource: img.externalSource
    property string imagePath
    property bool loaded
    signal click()
    
    onTouch: {
        if (event.isUp())
        {
            click();
        }
    }
    
    /*onCreationCompleted: {
        img.visible = false;
        activity_indicator.visible = true;
        activity_indicator.start();
    }*/
    
    /*onImageSourceChanged: {
        img.image = undefined
        image_loader.loadImage(imageSource);
        activity_indicator.start();
        loaded = true;
    }*/
    
    layout: DockLayout {
                
            }
     
     ActivityIndicator {
        id: activity_indicator
        horizontalAlignment: HorizontalAlignment.Center
        verticalAlignment: VerticalAlignment.Center
        preferredWidth: 30
        preferredHeight: 30
    }
    
     ImageViewOnline {
         id: img
         visible: false
         horizontalAlignment: HorizontalAlignment.Fill
         verticalAlignment: VerticalAlignment.Fill
         
         onImageStatus: {
             if (status == 1)
             {
                 img.visible = false;
                 activity_indicator.visible = true;
                 activity_indicator.start();
             }
             else if (status == 3)
             {
	             activity_indicator.visible = false;
	             activity_indicator.stop();
	             img.visible = true;
	         }
         }
     }
     
    /*ImageView {
        id: img
        horizontalAlignment: HorizontalAlignment.Fill
        verticalAlignment: VerticalAlignment.Fill
        scalingMethod: ScalingMethod.AspectFit
        
        attachedObjects: [
            ImageTracker {
                onStateChanged: {
                    if (state == ResourceState.Loaded)
                    {
                        image_loader.deleteImage(imagePath);
                    }
                }
            }
        ]
    }*/ 
    
    /*attachedObjects: [
        ImageLoader {
            id: image_loader
            onLoadComplete: {
                activity_indicator.stop();
                img.imageSource = "file://" + image_path;
                container.imagePath = image_path;
                Qt.image_path = image_path;
            }
        },
        
        TempFile {
            id: temp_file
        },
        SystemDialog {
            id: dialog
        },
        ImageTracker {
            id: img_tracker
            imageSource: "file://" + Qt.image_path;
            
            onStateChanged: {
                //if (state == ResourceState.ErrorInvalidFormat || state == ResourceState.ErrorNotFound)
                //{
                    if (img.image == null && loaded == false)
                    {
                        //img.imageSource = "asset:///images/noimage.jpg";    
                    }
                //}
            }
        }
    ]*/
}