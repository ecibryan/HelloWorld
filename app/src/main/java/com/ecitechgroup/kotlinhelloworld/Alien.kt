package com.ecitechgroup.kotlinhelloworld

import java.util.*
import kotlin.concurrent.schedule

/**
 * Created by brong on 2017-06-21.
 */

class Alien {
  
  var name = ""   // initialize

  fun name(str: String) = str

  companion object {
    var t1Started : Boolean = false
    
    var counter = 0
    var t1 = Timer()
    
    fun runT1(){t1.schedule(0, 1000){ counter++ }}
    var runT2 = t1.schedule(0, 1000){ counter++ }

  }
  
  
  
}

class Empty

