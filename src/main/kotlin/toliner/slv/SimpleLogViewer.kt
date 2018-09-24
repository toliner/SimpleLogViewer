package toliner.slv

import com.jfoenix.controls.JFXComboBox
import javafx.application.Application
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.stage.Stage
import javafx.util.StringConverter
import java.net.URL
import java.util.*

fun main(args: Array<String>) {
    Application.launch(SimpleLogViewer::class.java)
}

class SimpleLogViewer : Application(), Initializable {

    @FXML
    private lateinit var lineCountSelector: JFXComboBox<Label>

    override fun start(primaryStage: Stage) {
        val root = FXMLLoader.load<Parent>(ClassLoader.getSystemResource("toliner/slv/SimpleLogViewer.fxml"))
        primaryStage.title = "Simple Log Viewer"
        val scene = Scene(root)
        primaryStage.scene = scene
        primaryStage.show()
    }

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        lineCountSelector.apply {
            items.addAll(listOf(
                    "100",
                    "1000",
                    "5000",
                    "All"
            ).map { Label(it) })
            //promptText = "Select"
            converter = object : StringConverter<Label>() {
                override fun toString(`object`: Label?): String {
                    return `object`?.text ?: ""
                }

                override fun fromString(string: String?): Label {
                    return Label(string)
                }
            }
        }
    }
}
