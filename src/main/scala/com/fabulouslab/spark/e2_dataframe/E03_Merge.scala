package com.fabulouslab.spark.e2_dataframe

import org.apache.spark.sql.{SaveMode, SparkSession}

object E03_Merge {

  def main(args: Array[String]) {

    /**
      *  Notre startup est mytube connait une augmentation exponentielle du trafic,
      *  l'equipe marketing, nous as chargé d'étudier le dataset des filliales Us et GB.
      *  Mais avant de commencer l'étude, on doit fusioner les deux datasets:
      *  - Chargez le fichier USvideos.csv
      *  - Faire un show sur ce Dataset pour explorer les données
      *  - C'est quoi son schema ?
      *  - Essayez de forcer Spark à déduire le bon schéma
      *  - Chargez le fichier GBvideos.csv avec avec les mêmes paramètres que le USvideos.csv
      *  - Fussionez les deux datasets dans un fichier videos.parquet au format parquet ?
      *  - À quoi ressemble le fichier videos.parquet ?
      *  - Lancez ce job plusieurs fois en jouant  avec le SaveMode, pour écrasez le fichier à chaque lancement
      *
      * */
    val sparkSession = SparkSession.builder
      .master("local[1]")
      .appName("exo-3")
      .getOrCreate()


    val usVideos = sparkSession.read
      .option("header","true")
      .csv("src/main/resources/USvideos.csv")

    /**
      * Faire de meme pour le dataset comments.csv
      * */

    sparkSession.close()

  }

}
