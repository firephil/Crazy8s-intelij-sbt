package firephil.codegolf.crazy8s

import scala.collection.mutable.ListBuffer
import scala.util.Random

object Main extends App{
  //
  def r(a:Int, b:Int)={
    var l=(33 to 47).toList:::(58 to 126).toList
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

  print(r(10,40))
}
