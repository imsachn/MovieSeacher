package com.utils

import com.beans.Movies

import java.io.FileNotFoundException
import scala.collection.mutable.ListBuffer
import scala.io.Source

class FileReader {

  def read(fileName: String):  ListBuffer[Movies] = {
    var moviesDetails = new ListBuffer[Movies]()
    try {
      val fileSource = Source.fromFile(fileName)
      for (line <- fileSource.getLines.drop(1)) {
        val row = line.split("\t").map(_.trim)

        try {
         moviesDetails += Movies(row(0), row(1), row(2), row(3).toInt, row(4), row(5), row(6).toInt, row(7), row(8), row(9)
           , row(10), row(11), row(12), row(13), row(14).toDouble,
           if (row.length >= 16) row(15).toInt else 0,
           if (row.length >= 17 && !row(16).isBlank) row(16).replaceAll("\\D+", "") else 0,
           if (row.length >= 18) row(17) else 0,
           if (row.length >= 19) row(18) else 0,
           if (row.length >= 20) row(19) else ""
           , if (row.length >= 21 && !row(20).isBlank) row(20).toInt else 0,
           if (row.length >= 22 && !row(20).isBlank) row(21).toInt else 0)
        } catch {
          case e: NumberFormatException =>

            println(e)
          case f: Exception =>
            println(f)
        }

      }
      fileSource.close()
    } catch {
      case _: FileNotFoundException =>
        throw new FileNotFoundException()
    }
    moviesDetails
  }
}