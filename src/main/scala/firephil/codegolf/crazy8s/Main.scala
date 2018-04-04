package firephil.codegolf.crazy8s

/*import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Mode
import org.openjdk.jmh.annotations.OutputTimeUnit
import pl.project13.scala.sbt.JmhPlugin
*/

import java.util.concurrent.TimeUnit

import scala.collection.parallel.immutable.ParSeq
import scala.util.Random

//@OutputTimeUnit(TimeUnit.MILLISECONDS)
object Main {

  //@Benchmark
  def randomize8Stream(a: Int, b: Int): Stream[String] = {
    val chars = (33 to 47) ++ (58 to 126)

    var stream :Stream[String] = (a to b).toStream.map {
      case x@multiple if x % 8 == 0 => chars(Random.nextInt(chars.length)).toChar.toString
      case x => String.valueOf(x)
    }
    stream
  }

  //@Benchmark
  def randomize8ParStream(a:Int, b:Int): ParSeq[String] = randomize8Stream(a,b).par

  def main(args: Array[String]): Unit = {
    println(randomize8ParStream(10,20).toList)
  }
}