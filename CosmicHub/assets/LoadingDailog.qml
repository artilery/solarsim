import bb.cascades 1.0
import bb.system 1.0

Dialog {
    Container {
        horizontalAlignment: HorizontalAlignment.Fill
        verticalAlignment: VerticalAlignment.Fill
        background: Color.create(0, 0, 0, 0.5)
        leftPadding: 20
        rightPadding: 20
        layout: DockLayout {

        }

        Container {
            id: txt_container
            layout: DockLayout {

            }

            ImageView {
                imageSource: "asset:///images/bg.png"
                preferredHeight: 450
                preferredWidth: 450
            }

            horizontalAlignment: HorizontalAlignment.Center
            verticalAlignment: VerticalAlignment.Center

            Container {
                leftPadding: 40
                rightPadding: 40
                bottomPadding: 40
                topPadding: 40
                horizontalAlignment: HorizontalAlignment.Center
                verticalAlignment: VerticalAlignment.Center
                //background: Color.create("#FFFFFF")

                ImageView {
                    imageSource: "asset:///images/thumbnail.png"
                    horizontalAlignment: HorizontalAlignment.Center
                    bottomMargin: 20
                    preferredWidth: 84
                    scalingMethod: ScalingMethod.AspectFit
                }

                Label {
                    id: txt_label
                    horizontalAlignment: HorizontalAlignment.Center
                    text: "Loading... Please wait"
                }

                ActivityIndicator {
                    id: activity_indicator
                    horizontalAlignment: HorizontalAlignment.Center
                }
            }
        }
    }

    onOpened: {
        activity_indicator.start();
    }

    onClosed: {
        activity_indicator.stop();
    }
}