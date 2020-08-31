enablePlugins(ScalaJSPlugin)

name := "githubpages"
scalaVersion := "2.13.1" // or any other Scala version >= 2.11.12
libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "1.0.0"

// This is an application with a main method
scalaJSUseMainModuleInitializer := true
