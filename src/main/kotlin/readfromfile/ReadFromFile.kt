package readfromfile

import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {
    val inputStream: InputStream = File("src\\main\\kotlin\\readfromfile\\firstNames.txt").inputStream()
    val firstNames = mutableListOf<String>()
    inputStream.bufferedReader().forEachLine { firstNames.add(it) }
    println("First names unsorted:")
    firstNames.forEach{println(it)}
    firstNames.sort()
    println("\n\n\nFirst names sorted:")
    firstNames.forEach{println(it)}
}