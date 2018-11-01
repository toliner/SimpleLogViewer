package toliner.slv

import com.jfoenix.controls.*
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import javafx.beans.value.ChangeListener
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Label
import javafx.util.StringConverter
import java.net.URL
import java.util.*
import kotlin.math.max

class SLVController: Initializable {

    val listener = ChangeListener<Number> { _, _, newValue ->
        contentColumn.prefWidth = max(0.0, newValue.toDouble() - timeColumn.width - ownerColumn.width - threadColumn.width)
    }

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
    // tree table
    @FXML
    private lateinit var logTableView: JFXTreeTableView<Log>
    @FXML
    private lateinit var timeColumn: JFXTreeTableColumn<Log, String>
    @FXML
    private lateinit var ownerColumn: JFXTreeTableColumn<Log, String>
    @FXML
    private lateinit var threadColumn: JFXTreeTableColumn<Log, String>
    @FXML
    private lateinit var contentColumn: JFXTreeTableColumn<Log, String>

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

    class Log(time: String, owner: String, thread: String?, content: String) : RecursiveTreeObject<Log>() {
        val time: StringProperty = SimpleStringProperty(time)
        val owner: StringProperty = SimpleStringProperty(owner)
        val thread: StringProperty = SimpleStringProperty(thread ?: "")
        val content: StringProperty = SimpleStringProperty(content)
    }
}