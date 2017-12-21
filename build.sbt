import sbtprotoc.ProtocPlugin.ProtobufConfig

lazy val ProtoTest = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "darkDesire",
      scalaVersion := "2.12.3",
      version      := "0.0.1"
    )),
    name := "ProtoTest",
    libraryDependencies ++= Seq(
      "com.typesafe" % "config" % "1.3.1",
      "com.trueaccord.scalapb" %% "scalapb-runtime" % com.trueaccord.scalapb.compiler.Version.scalapbVersion % "protobuf"
    )
  )

PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value
)