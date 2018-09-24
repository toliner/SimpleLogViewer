package toliner.slv

import com.jfoenix.controls.JFXComboBox
import com.jfoenix.controls.JFXTextField
import com.jfoenix.controls.JFXToggleNode
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
    @FXML
    private lateinit var filterText: JFXTextField
    // toggle nodes
    @FXML
    private lateinit var toggleFetal: JFXToggleNode
    @FXML
    private lateinit var toggleError: JFXToggleNode
    @FXML
    private lateinit var toggleWarning: JFXToggleNode
    @FXML
    private lateinit var toggleInfo: JFXToggleNode
    @FXML
    private lateinit var toggleDebug: JFXToggleNode
    // count labels
    @FXML
    private lateinit var countFetal: Label
    @FXML
    private lateinit var countError: Label
    @FXML
    private lateinit var countWarning: Label
    @FXML
    private lateinit var countInfo: Label
    @FXML
    private lateinit var countDebug: Label

    override fun start(primaryStage: Stage) {
        val root = FXMLLoader.load<Parent>(ClassLoader.getSystemResource("toliner/slv/SimpleLogViewer.fxml"))
        primaryStage.title = "Simple Log Viewer"
        val scene = Scene(root)
        scene.stylesheets.add(ClassLoader.getSystemResource("toliner/slv/SimpleLogViewer.css").toExternalForm())
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
