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
package edu.nccu.plsm.examples.actor

import java.util.concurrent.atomic.AtomicLong

import akka.actor.DiagnosticActorLogging
import akka.camel.{CamelMessage, Consumer}
import edu.nccu.plsm.examples.AppConfig

class MqttConsumer extends Consumer with AppConfig with DiagnosticActorLogging {
  private[this] val counter = new AtomicLong

  override def preStart() = {
    super.preStart()
    log info "Mqtt consumer started."
  }

  override def postStop() = {
    super.postStop()
    log info "Mqtt consumer stopped."
  }

  def receive = {
    case msg: CamelMessage =>
      log info("Message received. [count={}, body={}]", counter.incrementAndGet(), msg.bodyAs[String])
    case any =>
      log error("Received unknown message [{}]", any)
  }
}