import okio.FileSystem
import okio.Path.Companion.toPath
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val path = args[0].toPath()


    FileSystem.SYSTEM.read(path) {
        val message = readUtf8Line() ?: return

        val runtime = measureTimeMillis {
            var startPosition = 0
            val markerLength = 14
            val offset = markerLength - 1

            generateSequence {
                val chunk = message.substring(startPosition..startPosition + offset)
                ++startPosition
                chunk
            }.map { chunk ->
                val chunkSet = chunk.toSet()
                chunkSet.size == markerLength
            }.takeWhile { found -> !found }.forEach { _ -> }

            val markerPosition = startPosition + offset
            println("Marker position: $markerPosition")
        }
        println("Runtime: $runtime ms")
    }
}