package com.example.app

import com.example.app.java.Runner

class MyScalatraServlet extends MyScalatraWebAppStack {

  get("/towerOfHanoi/:disks"){
    val disks: String = params("disks")

    if (disks.nonEmpty  && isAllDigits(disks)){
      new Runner().getResponse(disks.toInt)
    }
    else{
      "Please specify an integer for the number of disks."
    }
  }

  def isAllDigits(x: String) = x forall Character.isDigit
}
