package com.example.app

import com.example.app.java.Runner

class MyScalatraServlet extends MyScalatraWebAppStack {

  get("/towerOfHanoi"){
    new Runner().getResponse(4)

  }


}
