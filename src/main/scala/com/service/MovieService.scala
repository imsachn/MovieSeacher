package com.service

import com.beans.Movies
import com.utils.FileReader

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class MovieService {

  private var moviesDetails: ListBuffer[Movies] = _

  def movieData(fileName: String) {
    val reader= new FileReader()
    moviesDetails = reader.read(fileName)
  }

  def generateReportTitles(directorName: String, fromYear: Int, toYear: Int) {
    val movie = moviesDetails.filter(movie => { movie.director.equalsIgnoreCase(directorName) &&
      movie.year >= fromYear && movie.year <= toYear
    })
    if (movie == null || movie.isEmpty) {
      println("No match data found")
    } else {
      movie.foreach(println)
    }
  }

  def generateReportOfEnglishMoviesWithUserReview(userReview: Int) {
    val movieReviewList = moviesDetails.filter(movie => {
      movie.language.toString.toLowerCase().contains("english") && movie.reviewsFromUsers > userReview
    }).sortBy(_.reviewsFromUsers).reverse
    //val sortedMovieListBaseOnReview = movieReviewList sortWith (_.reviewsFromUsers > _.reviewsFromUsers)
    if (movieReviewList == null || movieReviewList.isEmpty) {
      println("No match data found")
    } else {
      movieReviewList.foreach(println)
    }
  }

  def generateHighestBudgetTitlesForGivenYear(country: String, year: Int) {
    val budgetMovie = moviesDetails.filter(movie => {
      country.equalsIgnoreCase(movie.country) && movie.year == year
    })
    if (budgetMovie.isEmpty) {
      println("No match data found")
    } else {

      println(budgetMovie.reduceLeft(maxBudget))
    }
  }

  def generateReportOfLongestMovieDuration(country: String, vote: Int) {
    val movieList = moviesDetails.filter(movie => {
      movie.country.toLowerCase().contains(country.toLowerCase()) && movie.votes >= vote
    })

    if (movieList == null || movieList.isEmpty) {
      println("No match data found")
    } else {
      movieList.sortBy(_.duration).reverse
        .foreach(println)
    }
  }

  def generateLanguageWiseReportToCountForBudgetRange(startBudgetRange: Long, endBudgetRange: Long,country:String) {
    var budgetMovieMap = mutable.Map[String, Int]()
    for (movie <- moviesDetails) {
      if ( movie.country.equalsIgnoreCase(country) && movie.budget.toString.toLong  >= startBudgetRange && movie.budget.toString.toLong  <= endBudgetRange ) {
        if (budgetMovieMap.contains(movie.language)) {
          budgetMovieMap += (movie.language -> (budgetMovieMap(movie.language) + 1))
        } else {
          budgetMovieMap += (movie.language -> 1)
        }
      }
    }
    val sortLanguageBasedOnCount = mutable.ListMap(budgetMovieMap.toSeq.sortWith(_._2 > _._2): _*)
    if (sortLanguageBasedOnCount == null || sortLanguageBasedOnCount.isEmpty) {
      println("No match data found")
    }else{
      for (e <- sortLanguageBasedOnCount) {
        println("Language:- " + e._1 + " || count:- " + e._2)
      }
    }
  }

  def maxBudget(movie1: Movies, movie2: Movies): Movies = if (movie1.budget.toString.toInt > movie2.budget.toString.toInt) movie1 else movie2
}
