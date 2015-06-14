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
trait Version {
  lazy val logback = "1.1.4-PLSM-SNAPSHOT"
  lazy val mockito = "2.0.2-beta"
  //lazy val netty     = "5.0.0.Alpha2"
  //lazy val tcnative  = "1.1.33.Fork2"
  lazy val scala = "2.12.0-M1"
  lazy val scalaTest = "2.2.5-M1"
  lazy val slf4j = "1.7.12"
  lazy val akka = "2.4-M1"

  lazy val scalaVersion11 = "2.11.6"
  lazy val scalaVersion12 = "2.12.0-M1"
  lazy val integration = "latest.integration"
  lazy val milestone = "latest.milestone"
  lazy val release = "latest.release"
}

object Version extends Version