lazy val root = (project in file("."))
  .settings(Settings.default: _*)
  .settings(Settings.plugin: _*)
  .settings(
    name := "mqtt-akka",
    libraryDependencies ++= Dependencies.project
  )