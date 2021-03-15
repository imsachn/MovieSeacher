import com.utils.FileReader
import org.scalatest.flatspec.AnyFlatSpec

import java.io.FileNotFoundException

class Test extends AnyFlatSpec {

  it should "fileReadingTest" in {
    val fileName = "/home/hasher/IdeaProjects/MovieSeacher/imdb_movies - imdb_movies.tsv"
    val fileReader = new FileReader()
    assert(20019 == fileReader.read(fileName).length)
  }

  it should "fileNotFoundTest" in {
    val fileName = ""
    val fileReader = new FileReader()
    assertThrows[FileNotFoundException] {
      fileReader.read(fileName)
    }
  }
}