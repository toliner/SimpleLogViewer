package toliner.slv

import java.io.FileInputStream
import java.nio.file.Paths


fun stream() {
    val stream = FileInputStream(Paths.get("./test/foo.txt").toFile()).reader()
    while (true) {
        if (stream.ready()) {
            println(stream.readText())
        }
    }
}