package namerandomizer

import java.io.File
import java.io.InputStream
import kotlin.random.Random

fun main(args: Array<String>) {
    val firstNames = getNamesFromFile("src\\main\\kotlin\\namerandomizer\\files\\firstNames.txt")
    val lastNames = getNamesFromFile("src\\main\\kotlin\\namerandomizer\\files\\lastNames.txt")
    val randomNames = ArrayList<String>()

   for(i in 1..10){
       randomNames.add(firstNames[Random.nextInt(firstNames.size)] + " " + lastNames[Random.nextInt(lastNames.size)])
   }

    randomNames.forEach{println(it)}
    var namesAsOneString = ""
    randomNames.forEach{namesAsOneString += it + "\n"}
    writeNewNamesToFile("src\\main\\kotlin\\namerandomizer\\files\\newNames.txt", namesAsOneString)
}


    fun getNamesFromFile(filePath: String): MutableList<String> {
        val inputStream: InputStream = File(filePath).inputStream()
        val firstNames = mutableListOf<String>()
        inputStream.bufferedReader().forEachLine { firstNames.add(it) }
        return firstNames
    }

fun writeNewNamesToFile(filePath:String, text:String){
    File(filePath).writeText(text)
}