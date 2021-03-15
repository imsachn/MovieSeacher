import com.service.MovieService

import java.util.Scanner
import scala.io.StdIn.readLine

object Main {

  def main(args: Array[String]) {
    val fileName = "/home/hasher/IdeaProjects/MovieSeacher/imdb_movies - imdb_movies.tsv"
    val movieService = new MovieService()
    movieService.movieData(fileName)
    println("1 Generate Report titles directed by given director in the given year range")
    println("2 Generate report of English titles which have user reviews more than given user review")
    println("3 Generate highest budget titles for the given years")
    println("4 Generate report of longest title duration for the given country")
    println("5 Generate language wise report to count the titles for the given budget range and sort with count descending")
    val scanner = new Scanner(System.in)
    val option = scanner.nextInt()
    option match {
      case 1 =>
        try {
          println("Enter the director name:-")
          val directorName = readLine()
          println("enter the from year:-")
          val fromYear = scanner.nextInt()
          println("enter the to year:-")
          val toYear = scanner.nextInt()
          if (fromYear <= toYear)
            movieService.generateReportTitles(directorName, fromYear, toYear)
          else
            println("Please enter correct year range order")
        } catch {
          case e: Exception => println(e)
        }
      case 2 =>
        try {
          println("Enter review:-")
          val userReview = scanner.nextInt()
          movieService.generateReportOfEnglishMoviesWithUserReview(userReview)
        } catch {
          case e: Exception => println(e)
        }
      case 3 =>

        try {
          println("Enter the country")
          val country = readLine()
          println("Enter the year")
          val year = scanner.nextInt()
          movieService.generateHighestBudgetTitlesForGivenYear(country, year)
        } catch {
          case e: Exception => println(e)
        }
      case 4 =>
        try {
          println("Enter the country")
          val country = readLine()
          println("Enter the minimum vote")
          val vote = scanner.nextInt()
          movieService.generateReportOfLongestMovieDuration(country, vote)
        } catch {
          case e: Exception => println(e)
        }
      case 5 =>
        try {
          println("Enter start budget range:-")
          val startBudgetRange = scanner.nextLong()
          println("Enter end budget range:-")
          val endBudgetRange = scanner.nextLong()
          println("Enter country:-")
          val country = scanner.next()
          if (startBudgetRange <= endBudgetRange)
            movieService.generateLanguageWiseReportToCountForBudgetRange(startBudgetRange, endBudgetRange,country)
          else
            println("Please enter budget range in correct order")
        } catch {
          case e: Exception => println(e)
        }
      case _ => println("selected the wrong option")
    }
  }

}
