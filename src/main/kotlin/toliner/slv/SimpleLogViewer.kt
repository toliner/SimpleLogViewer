package toliner.slv

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

fun main(args: Array<String>) {
    Application.launch(SimpleLogViewer::class.java)
}

class SimpleLogViewer : Application() {

    override fun start(primaryStage: Stage) {
        val root = FXMLLoader.load<Parent>(ClassLoader.getSystemResource("toliner/slv/SimpleLogViewer.fxml"))
        primaryStage.title = "Simple Log Viewer"
        val scene = Scene(root)
        primaryStage.scene = scene
        primaryStage.show()
    }


}
