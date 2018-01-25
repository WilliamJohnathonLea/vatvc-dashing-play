val appName = "vatvc-dashing-play"

version := "0.1.0"

val appDependencies: Seq[ModuleID] = Seq.empty

lazy val dashing = Project(appName, file("."))
    .enablePlugins(PlayScala, DockerPlugin)
    .settings(resolvers ++= Seq(
      Resolver.bintrayRepo("hmrc", "releases"),
      Resolver.jcenterRepo
    ))
    .settings(
      scalaVersion := "2.11.11",
      libraryDependencies ++= appDependencies
    )
    .settings( // Docker settings
      dockerRepository := Some("wjlea93"),
      dockerBaseImage := "openjdk:8-jre-slim",
      dockerExposedPorts := Seq(9000),
      dockerUpdateLatest := false
    )
