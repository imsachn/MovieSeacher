package com.beans
case class Movies(imdbTitleTd: String,title: String, originalTitle: String, year: Int, datePublished: String, genre: String, duration: Int, country: String, language: String, director: String, writer: String, productionCompany: String, actors: String, description: String, avgVote: Double, votes: Int, budget: Any, usaGrossIncome: Any, worldWideGrossIncome: Any, metaScore: String, reviewsFromUsers: Int, reviewsFromCritics: Int) {


  override def toString: String = {
    "imdbTitleTd = " + imdbTitleTd + " , title = " + title + " ,director = " + director + " ,originalTitle = " + originalTitle +
      " ,year = " + year + " ,reviewsFromUsers = " + reviewsFromUsers + " , country = " + country + " , votes = " + votes + " ,budget = " +
      budget + " , duration " + duration + " ,language = " + language
  }
}