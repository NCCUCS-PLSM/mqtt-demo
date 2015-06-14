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
package edu.nccu.plsm.examples

import org.slf4j.LoggerFactory

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Main extends App with AkkaMqttExample with AppConfig {
  val system = runAkkaMqttExample
  private[this] val logger = LoggerFactory.getLogger(getClass)

  sys addShutdownHook {
    logger.info("Terminating akka system...")
    Await.ready(system.terminate(), Duration.Inf)
    logger.info("Shutdown hook finished.")
  }
}