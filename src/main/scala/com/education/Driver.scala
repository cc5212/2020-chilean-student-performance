package com.education

import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions.{col, lit}
import org.apache.spark.sql.types.StringType

object Driver {
  def main(args: Array[String]) {
    val sparkConf: SparkConf = new SparkConf().set("spark.app.name", "Epic lab5")

    val spark = SparkSession
      .builder()
      .master("local[*]")
      .config("spark.executor.memory", "4g")
      .config("spark.driver.memory", "8g")
      .config(sparkConf)
      .getOrCreate()

    //EvaluationYearlyAverage().run(spark, "out/evaluationyearly")
    //EvaluationYearlyAverageRegion().run(spark, "out/evaluationyearlyreg")
    EvaluationAndPerformanceYearlyAverage().run(spark, "out/alumnosvsdocentes")
    //Reprobation().run(spark,"out/reprobation")
    //YearlyAverage().run(spark, "out/yearly")
  }
}
