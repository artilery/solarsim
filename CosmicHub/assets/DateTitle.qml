import bb.cascades 1.0

Container {
    property alias date_title: lbl_title.text
    Label {
        id: lbl_title
        bottomMargin: 2
    }
    
    DateTimePicker {
        
    }
}