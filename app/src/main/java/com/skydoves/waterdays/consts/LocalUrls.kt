package com.skydoves.waterdays.consts

/**
 * Developed by skydoves on 2017-08-18.
 * Copyright (c) 2017 skydoves rights reserved.
 */

object LocalUrls {
  fun getLocalUrl(index: Int): String {
    when (index) {
      1 -> return "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4182025000"
      2 -> return "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4282025000"
      3 -> return "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4817074000"
      4 -> return "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4729053000"
      5 -> return "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2920054000"
      6 -> return "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2720065000"
      7 -> return "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=3023052000"
      8 -> return "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2644058000"
      9 -> return "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=3114056000"
      10 -> return "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2871025000"
      11 -> return "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4681025000"
      12 -> return "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4579031000"
      13 -> return "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4376031000"
      14 -> return "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4376031000"
      15 -> return "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=5013025300"
      else -> return "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1159068000"
    }
  }
}
