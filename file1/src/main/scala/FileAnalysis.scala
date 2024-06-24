import scala.io.StdIn, scala.io.Source

object FileAnalysis {
  def main(args: Array[String]): Unit = {

    val filepath = "C:\\Users\\Administrator\\IdeaProjects\\file1\\src\\main\\scala\\file.txt"
    val source = Source.fromFile(filepath)

    val lines = source.getLines().toList  // read all the files
    source.close()                        // closing read

    val words = lines.flatMap(_.split("\\s+")).map(_.toLowerCase())
    //words.foreach(println)

    val groupedWords = words.groupBy(identity)
    val wordCount = groupedWords.mapValues(_.size).toSeq.sortBy(-_._2)

    wordCount.take(10).foreach{case (word,count) => println(s"$word: $count")}


  }
}