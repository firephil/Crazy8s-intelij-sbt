package firephil.codegolf.crazy8s

import scala.collection.mutable.ListBuffer
import scala.util.Random

object Main extends App {

  def randomize8(a: Int, b: Int): ListBuffer[String] = {
    var characters: IndexedSeq[Int] = (33 to 47) ++ (58 to 126)
    //shuffle the character set
    characters = Random.shuffle(characters)

    var result = ListBuffer[String]()
    var k = 0
    (a to b).toList.foreach { e => {
      if (k == characters.length) {
        k = 0
        characters = Random.shuffle(characters)
      }
      if (e % 8 == 0) {
        result += characters(k).toChar.toString
        k += 1
      }
      else {
        result += e.toString
        k += 1
        println(k)
      }
    }
    }
    result
  }

  def randomizeStream(a: Int, b: Int) = {
    val chars = (33 to 47) ++ (58 to 126)

    var stream :Stream[String] = (a to b).toStream.map {
      case x@multiple if x % 8 == 0 => chars(Random.nextInt(chars.length)).toChar.toString
      case x => String.valueOf(x)
    }
    stream
  }
  //golfed version
  def r(a:Int, b:Int)={
    var l=(33 to 47)++(58 to 126)
    l=Random.shuffle(l)
    var x=ListBuffer[String]()
    var k=0
    (a to b).toList.foreach{e=>{
      if(k==l.length){k=0
        l=Random.shuffle(l)}
      if (e%8==0){x+=l(k).toChar.toString
        k+=1}
      else{x+=e.toString
        k+=1}}}
    x}
  def S(a: Int, b: Int)={
    val c=(33 to 47)++(58 to 126)
    val r = (a to b).toStream.map {case x if x % 8 == 0=>c(Random.nextInt(c.length)).toChar.toString
      case x => String.valueOf(x)}
    r}


  println(S(10,20).toList)
}