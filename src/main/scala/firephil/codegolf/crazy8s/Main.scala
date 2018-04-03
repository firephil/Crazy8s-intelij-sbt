package firephil.codegolf.crazy8s


import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Mode
import org.openjdk.jmh.annotations.OutputTimeUnit
//import pl.project13.scala.sbt.JmhPlugin

import java.util.concurrent.TimeUnit

import scala.collection.mutable.ListBuffer
import scala.util.Random


@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Array(Mode.Throughput))
class Main {

  @Benchmark
  def randomize8Stream(a: Int, b: Int) = {
    val chars = (33 to 47) ++ (58 to 126)

    var stream :Stream[String] = (a to b).toStream.map {
      case x@multiple if x % 8 == 0 => chars(Random.nextInt(chars.length)).toChar.toString
      case x => String.valueOf(x)
    }
    stream
  }


  @Benchmark
  def randomize8ParStream(a:Int, b:Int) = randomize8Stream(a,b).par

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


  def main(args: Array[String]): Unit = {
    println(randomize8ParStream(10,20).toList)
  }

}