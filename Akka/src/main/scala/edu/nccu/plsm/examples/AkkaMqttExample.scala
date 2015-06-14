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

import akka.actor.{ActorSystem, Props}
import edu.nccu.plsm.examples.actor.Terminator.WatchActor
import edu.nccu.plsm.examples.actor.{MessageCreator, MqttConsumer, MqttEndpoint, Terminator}

import scala.concurrent.duration.FiniteDuration
import scala.language.postfixOps

trait AkkaMqttExample {
  def message: Any

  def duration: FiniteDuration

  def runAkkaMqttExample = {
    lazy val system = ActorSystem("akka-mqtt-example")
    lazy val terminator = system.actorOf(Props(classOf[Terminator]), "Terminator")
    lazy val consumer = system.actorOf(Props(classOf[MqttConsumer]), "MqttConsumer")
    lazy val producer = system.actorOf(Props(classOf[MqttEndpoint]), "MqttEndpoint")
    lazy val messageSender = system.actorOf(Props(classOf[MessageCreator], message, duration, producer), "MessageCreator")
    // watch all actor
    Seq(consumer, producer, messageSender) map WatchActor foreach (terminator !)
    system
  }
}