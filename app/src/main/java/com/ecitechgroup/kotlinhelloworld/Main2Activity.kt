package com.ecitechgroup.kotlinhelloworld

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity: AppCompatActivity() {
  
  var counter = 0
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main2)
  
  
    button2.setOnClickListener{
      startActivity(Intent(applicationContext, MainActivity::class.java))
    }
  
    textView2.text = Alien.counter.toString()

    btnStopT1.setOnClickListener{
      Alien.t1.cancel()
      Alien.t1.purge()
    }
  }
}
