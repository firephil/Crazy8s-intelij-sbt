name := "Crazy8s"
version := "1.11"
scalaVersion := "2.12.5"
enablePlugins(JmhPlugin)

mainClass in (Compile, run) := Some("firephil.codegolf.crazy8s.Main")
mainClass in (Compile, packageBin) := Some("firephil.codegolf.crazy8s.Main")