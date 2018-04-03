[![Build Status](https://travis-ci.org/firephil/Crazy8s-intelij-sbt.svg?branch=master)](https://travis-ci.org/firephil/Crazy8s-intelij-sbt)

## Crazy 8s Code Golf Challenge

https://codegolf.stackexchange.com/questions/104356/crazy-8s-code-golf/104482#104482

**Create a program that prints all whole numbers inclusively between an interval (a, b), and replaces multiples of 8** 
in the sequence with random (uniformly distributed, independent of other characters), non-numeric, 
non-whitespace, printable ASCII characters.

*Assume 0 < a < b in all cases.*

*If the number has more than 1 digit, make sure the amount of characters in the replacement matches!*

**Examples:**

`(1, 16) -> 1 2 3 4 5 6 7 $ 9 10 11 12 13 14 15 n@`

`(115, 123) -> 115, 116, 117, 118, 119, :F<, 121, 122, 123`

`(1, 3) -> 1 2 3`

**Non-Examples:**

`(1, 16) -> 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16`

`(115, 123) -> 115 116 117 118 119 $ 121 122 123`

## Runnable Code Online
# [Scala], 334 bytes

<!-- language-all: lang-scala -->

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

[Try it online!][TIO-jfjhl5fc]

[Scala]: http://www.scala-lang.org/
[TIO-jfjhl5fc]: https://tio.run/##dZBNS8QwEIbv/RVzERK6hK7rxyJEUE@CXvQoHtJ2uo2dTUqalULpb69Nq3aFNZeZMM@TeUmTKVKD3tfWeWjCRWSWCDOvrRH7g1cpoXjSjb8/FAW66A968JrEizK53UdRZNOP0YNnpQ1g69HkDdzVdRcBDAA5FuCYunk0fgVpKFyGEcCnckCSbTbgLVxc8zhml9vQr8@v@ESQnJeIphxTEDLiv2Yrl3Rvr95ps3tny7iSydQzFV5MufA28KKwDlVWdihv5xTT0QWrpCRBaHa@5N2PDf@k6I9VYHi2lTLhXRtLYlXY9VAqN5Y51wIDVLFcH9lIDQYNT8LfeD8LbT9@Zz0ynjm2TlabhPOoH74A "Scala – Try It Online"

## Improved Functional style code
# [Scala], 202 bytes

<!-- language-all: lang-scala -->

      def S(a: Int, b: Int)={
        val c=(33 to 47)++(58 to 126)
        val r = (a to b).toStream.map {case x if x % 8 == 0=>c(Random.nextInt(c.length)).toChar.toString
          case x => String.valueOf(x)}
        r}

[Try it online!][TIO-jfjnkfpe]

[Scala]: http://www.scala-lang.org/
[TIO-jfjnkfpe]: https://tio.run/##VVBdS8MwFH3PrzgvQsJG6Ky6IWSgPgmK4H5BmqZbJE1Kmkph9LfXpBXBl/t57jn33l5JK2fTdj5E9DnhylurVTTe8XaIsrKav5k@Pg9NowP5Bx2isfxTutq3hBBffaU5vEvjoMeoXd3jqeuuBJiBWjc4UfmIVxe3qBbPRG4C39JCCVqWiB53e7bZ0PtDjne3D@wPESBAZS5XjEd/ikHLlreyw1XJXmOEaZK5wQFCoBBHRdfduEvrJDmquNXuHC8sz79cZFhpjDsvIsAvjzhiLfOkO@iPho5sWiBhSqd0qRXpie6KbVlkqvwfRqb5Bw "Scala – Try It Online"
