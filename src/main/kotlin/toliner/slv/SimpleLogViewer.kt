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
    private lateinit var scene: Scene

    override fun start(primaryStage: Stage) {
        val fxmlLoader = FXMLLoader()
        val root = fxmlLoader.load<Parent>(ClassLoader.getSystemResourceAsStream("toliner/slv/SimpleLogViewer.fxml"))
        val controller = fxmlLoader.getController<SLVController>()
        primaryStage.title = "Simple Log Viewer"
        scene = Scene(root)
        scene.stylesheets.add(ClassLoader.getSystemResource("toliner/slv/SimpleLogViewer.css").toExternalForm())
        primaryStage.scene = scene
        scene.widthProperty().addListener(controller.listener)
        primaryStage.show()
    }
}
