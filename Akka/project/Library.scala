// Copyright (C) 2011-2012 the original author or authors.
// See the LICENCE file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
import sbt._
/**
 * @version
 * @since
 */
trait BasicLibrary {
  protected[this] def javaLibrary(group: String, version: String) = {
    (module: String) => group % module % version
  }
  protected[this] def scalaLibrary(group: String, version: String) = {
    (module: String) => group %% module % version
  }
  protected[this] def useSnapshot: Boolean
  protected[this] def v(version: String)  = {
    useSnapshot match {
      case true => Version.integration
      case _ => version
    }
  }
}

trait Slf4jLibrary extends BasicLibrary {
  private[this] def module = javaLibrary("org.slf4j", v(Version.slf4j))

  lazy val slf4jApi       = module("slf4j-api")
  lazy val osgiOverSlf4j = module("osgi-over-slf4j")
  lazy val log4jOverSlf4j = module("log4j-over-slf4j")
  lazy val jclOverSlf4j = module("jcl-over-slf4j")
  lazy val julToSlf4j = module("jul-to-slf4j")
}

trait AkkaLibrary extends BasicLibrary {
  private[this] def module = scalaLibrary("com.typesafe.akka", v(Version.akka))

  lazy val akkaClusterSharding = module("akka-cluster-sharding")
  lazy val akkaContrib = module("akka-contrib")
  lazy val akkaClusterMetrics = module("akka-cluster-metrics")
  lazy val akkaClusterTools = module("akka-cluster-tools")
  lazy val akkaPersistenceExperimentalTck = module("akka-persistence-experimental-tck")
  lazy val akkaCluster = module("akka-cluster")
  lazy val akkaMultiNodeTestkit = module("akka-multi-node-testkit") % Test
  lazy val akkaCamel = module("akka-camel")
  lazy val akkaTypedExperimental = module("akka-typed-experimental")
  lazy val akkaPersistenceExperimental = module("akka-persistence-experimental")
  lazy val akkaRemote = module("akka-remote")
  lazy val akkaSlf4j = module("akka-slf4j")
  lazy val akkaOsgi = module("akka-osgi")
  lazy val akkaTestkit = module("akka-testkit") % Test
  lazy val akkaKernel = module("akka-kernel")
  lazy val akkaRemoteTests = module("akka-remote-tests")
  lazy val akkaActor = module("akka-actor")
  lazy val akkaActorTests = module("akka-actor-tests")
}

trait TestLibrary extends BasicLibrary {
  lazy val mockitoAll     = "org.mockito"    %  "mockito-all"     % Version.mockito
  lazy val scalaTest      = "org.scalatest"  %% "scalatest"       % Version.scalaTest
}

trait PlayLibrary extends BasicLibrary {
  lazy val playSlick        = "com.typesafe.play"      %% "play-slick"            %  v("1.0.0")
  lazy val slickExtensions  = "com.typesafe.slick"     %% "slick-extensions"      %  v("3.0.0")

  lazy val oracleConnector  = "com.oracle"             %  "ojdbc7dms_g"           %  v("12.1.0.2")
  lazy val hikariCP         = "com.zaxxer"             %  "HikariCP"              %  v("2.3.8")
}

trait Library extends TestLibrary with Slf4jLibrary with AkkaLibrary with PlayLibrary {
  lazy val scalaReflect   = "org.scala-lang" %  "scala-reflect"   % Version.scala
  lazy val logbackCore    = "ch.qos.logback" %  "logback-core" % Version.logback
  lazy val logbackClassic = "ch.qos.logback" %  "logback-classic" % Version.logback
  lazy val camelMqtt      = "org.apache.camel" % "camel-mqtt" % "2.15.2"
  lazy val javassit       = "org.javassist"  %  "javassist"       % "3.19.0-GA"
  lazy val camelPaho      = "org.apache.camel" % "camel-paho" % "2.15.2"
  lazy val paho           = "org.eclipse.paho" % "mqtt-client" % "0.4.0"
}
