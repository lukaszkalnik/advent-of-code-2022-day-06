import okio.FileSystem
import okio.Path.Companion.toPath
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val path = args[0].toPath()


    FileSystem.SYSTEM.read(path) {
        val message = readUtf8Line() ?: return

        val runtime = measureTimeMillis {
            val windowLength = 14

            val startPosition = message.windowedSequence(windowLength)
                .indexOfFirst { window -> window.toSet().size == windowLength }

            val markerPosition = startPosition + windowLength
            println("Marker position: $markerPosition")
        }
        println("Runtime: $runtime ms")
    }
}