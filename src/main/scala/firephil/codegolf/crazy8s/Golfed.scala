package firephil.codegolf.crazy8s

import scala.collection.mutable.ListBuffer
import scala.util.Random

class Golfed {

  //golfed versions
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

}
