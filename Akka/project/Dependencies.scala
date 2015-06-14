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
trait Dependencies {
  object Library extends Library {
    override protected[this] def useSnapshot = false
  }
  import Library._

  lazy val project = akka ++ slf4j ++ logback ++ Seq(
    javassit,
    camelMqtt
  )
  lazy val akka = Seq(
    akkaSlf4j,
    akkaActor,
    akkaCluster,
    akkaCamel
  )
  lazy val slf4j = Seq(
    slf4jApi,
    jclOverSlf4j,
    julToSlf4j
  )
  lazy val logback = Seq(
    logbackCore,
    logbackClassic
  )
}


object Dependencies extends Dependencies
