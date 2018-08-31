package com.ecitechgroup.kotlinhelloworld

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.IllegalArgumentException
import java.math.BigDecimal
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

  val mLog = "mlog"
  var counter = 0
  
  override fun onCreate(savedInstanceState : Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    button.setOnClickListener{
      startActivity(Intent(applicationContext, Main2Activity::class.java))
    }
  
    button3.setOnClickListener {
//      Alien.runT1()
//      textView.text = Alien.counter.toString()

      Alien.t1.schedule(0, 1000){
        runOnUiThread{
        Alien.counter++
        textView.text = Alien.counter.toString()
        }
      }
    }
  }
  
  
  

  override fun onResume() {
    super.onResume()
//    textView.text = Alien.counter.toString()
  
  
  
    //    Toast.makeText(this, sumStr("I am", " super!"), Toast.LENGTH_LONG).show()
//    Toast.makeText(this, "" + maxOf(4, 8), Toast.LENGTH_LONG).show()

//    Toast.makeText(this, describe(1), Toast.LENGTH_LONG).show()
//    Toast.makeText(this, describe("Hello"), Toast.LENGTH_LONG).show()
//    Toast.makeText(this, describe(1000L), Toast.LENGTH_LONG).show()
//    Toast.makeText(this, describe(2), Toast.LENGTH_LONG).show()
//    Toast.makeText(this, describe("other"), Toast.LENGTH_LONG).show()


//    Toast.makeText(this, rangeChk(4, 8), Toast.LENGTH_LONG).show()
//    Toast.makeText(this, rangeChk(4, 3), Toast.LENGTH_LONG).show()

//    forLoop()
//    whileLoop()
//    whenInCollection()
//    filterAndMapCollections()
//    lambdasExp()

//    whenOr(1)
//    whenOr(3)

    var alien = Alien()
    alien.name = "Harsh"
    Log.v(mLog, alien.name)

    Log.v(mLog, alien.name("Bryan"))

    var empty = Empty()








/** extends properties ***/
    val bd1 = BigDecimal(100)
//    |
//    v
    val bd2 = 100.bd


//    val tickets = Money(BigDecimal(100), "$")
    val tickets = Money(100.bd, "$")

    val popcorn = tickets.copy(BigDecimal(100), "EUR")






    Log.v(mLog, " " + bd1.percent(7))

    Log.v(mLog, " " + bd2.percent(7))

// any extension function has single parameter can be quoted in infix
    Log.v(mLog, " " +  7.percentOf(popcorn))
//    |
//    v
    Log.v(mLog, " " +  (7 percentOf popcorn))


    sendPayment(message = "Good luck!", money = tickets)

    if(tickets != popcorn){
      Log.v(mLog, "They are different!")
    }


  }


  fun sendPayment(money: Money, message: String = ""){
    Log.v(mLog  , "Sending ${money.amount}")
  }

  fun convertToDollars(money : Money) =
    when(money.currency){
      "$" -> money
      "EUR" -> Money(money.amount * BigDecimal(1.10), "$")
       else -> throw IllegalArgumentException("not the currency you're interested in!")
    }


  fun sum(x: Int, y: Int ) = x + y


/**  extend percent ***/
fun BigDecimal.percent(percentage: Int)
    = this.multiply(BigDecimal(percentage)).divide( BigDecimal(100))

infix fun Int.percentOf(money: Money)
    = money.amount.multiply(BigDecimal(this)).divide(BigDecimal(100))

/**extends properties**/
  private val  Int.bd : BigDecimal
    get() = BigDecimal(this)

  /** higher order function
   *  - a function that takes a function or returns a function
   *  @predicate: a function take String param and return a Boolean
   *  - this function filtering a list of users
   *
   */

  fun findEmails(users: List<User>, predicate: (String) -> (Boolean)) : List<User> {
    TODO("LATER!")

  }







  /*** class ***/
  data class Money(val amount: BigDecimal, val currency: String)


  class User {

  }


















  /**
   *  String operation
   *  combination of two strings
   *    intput: "I am ", "super."
   *    return: "I am super."
   *
   * **/
  fun sumStr(str1 : String, str2 : String) = str1 + str2



  /***
   * when in expression, replacement of switch operator
   * return: specific string according to object value,
   *        it will match all at the beginning
   * exp:
   *  input: 1 --> output: "One"
   *  input: 2 --> output: "Not a string"
   * **/
  fun describe( obj : Any) : String = when (obj){

    1           -> "One"
    "Hello"     -> "Greeting"
    is Long     -> "Long"
    !is String  -> "Not a string"
    else        -> "Unknown"
  }


  /****
   *  Or operator in when statement
   *    input: 1, output: "x == 0 or x == 1"
   *    input: 3, output: "otherwise"
   *
   * */
  fun whenOr(x : Int){
    when(x){
      0, 1  -> toastLn("x == 0 or x == 1")
      else  ->  toastLn("otherwise")
    }
  }

  /**
   * when in collection
   * output: "apple is fine too"
   * (juicy will not shown because "orange" is not on the list
   *
   * **/
  fun whenInCollection(){
    val items = setOf("apple", "banana", "kiwi")
    when{
      "orange" in items ->        // is "orange" on the list?
        toastLn("no")

      "apple" in items ->         // is "apple" on the list?
        toastLn("yes")
    }
  }


  /**
   * filter and
   * map collection
   *    output: "APPLE" "AVOCADO"
   * **/
  fun filterAndMapCollections(){
    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    fruits
        .filter {it.startsWith("a")}  // select only fruits starts with "a"
        .sortedBy {it}                // sort
        .map {it.toUpperCase()}       // to upper case
        .forEach {toastLn(it)}  // print out each content start with "a"
  }



  /**
   *  lambdas expression
   *   output: 10 12 14
   *
   * */
  fun lambdasExp(){
    val items = listOf(1, 2, 3, 4, 5, 6, 7)
    items
        .filter { it > 4}                 // filter elements only > 4
        .map { elememt -> elememt * 2}    // multiply by 2 for every element
        .forEach {toastLn(it.toString())} // output each
  }


  /**
   *  Find max of two integers and return the max
   *    intput: 3, 5  output: 5
   *
   * ***/
  fun maxOf(a : Int, b : Int) = if (a > b) a else b



  /**
   * ranges
   *  range check: is value of a in between 1 to b?
   *  input: a = 4, b = 5
   *  output: "yes"
   *
   * **/
  fun rangeChk(a : Int, b : Int) =
    if( a in 1..b) toastLn("yes")
    else toastLn("no")


  /**
   * for loop
   *
   * **/
  fun forLoop(){

    // for loop general
    // output: apple banana kiwi
    val items = listOf("apple", "banana", "kiwi")
    for(item in items)
      toastLn(item)

    // for loop in range
    // output: 1, 2, 3, 4, 5
    for(x in 1..5)
      toastLn(x.toString())

    // for loop step
    // output: 1, 3, 5
    for(x in 1..5 step 2)
      toastLn(x.toString())

    // for loop downTo
    // output: 9, 6, 3, 0
    for(x in 9 downTo 0 step 3)
      toastLn(x.toString())
  }


  /**
   * while loop
   *  output: 0 1 2 3 4
   * **/
  fun whileLoop(){
    var index = 0
    while ( index < 5){
      toastLn(index.toString())
      index++
    }
  }




  fun toastLn(str : String){
    Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
  }

}



