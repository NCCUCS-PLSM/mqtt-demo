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

import akka.actor.{Actor, ActorRef, DiagnosticActorLogging, Terminated}
import edu.nccu.plsm.examples.actor.Terminator.WatchActor

class Terminator extends Actor with DiagnosticActorLogging {

  override def preStart() = {
    super.preStart()
    log info "System terminator started."
  }

  override def postStop() = {
    super.postStop()
    log info "System terminator stopped."
  }

  def receive = {
    case Terminated(ref) =>
      log info("{} has terminated, shutting down system", ref.path)
      context.system.terminate()
    case WatchActor(ref) =>
      log info("Watching on actor {}", ref.path)
      context watch ref
    case any =>
      log error("Received unknown message [{}]", any)
  }
}

object Terminator {

  case class WatchActor(ref: ActorRef)

}