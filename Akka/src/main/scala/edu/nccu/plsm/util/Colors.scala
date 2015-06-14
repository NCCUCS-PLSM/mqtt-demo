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
package edu.nccu.plsm.util

import scala.Console._

trait Colors {
  lazy val isANSISupported = {
    Option(System.getProperty("sbt.log.noformat")).map(_ != "true").orElse {
      Option(System.getProperty("os.name"))
        .map(_.toLowerCase)
        .filter(_.contains("windows"))
        .map(_ => false)
    }.getOrElse(true)
  }

  def red(str: String): String = if (isANSISupported) RED + str + RESET else str

  def blue(str: String): String = if (isANSISupported) BLUE + str + RESET else str

  def cyan(str: String): String = if (isANSISupported) CYAN + str + RESET else str

  def green(str: String): String = if (isANSISupported) GREEN + str + RESET else str

  def magenta(str: String): String = if (isANSISupported) MAGENTA + str + RESET else str

  def white(str: String): String = if (isANSISupported) WHITE + str + RESET else str

  def black(str: String): String = if (isANSISupported) BLACK + str + RESET else str

  def yellow(str: String): String = if (isANSISupported) YELLOW + str + RESET else str

  def redBackground(str: String): String = if (isANSISupported) RED_B + str + RESET else str

  def blueBackground(str: String): String = if (isANSISupported) BLUE_B + str + RESET else str

  def cyanBackground(str: String): String = if (isANSISupported) CYAN_B + str + RESET else str

  def greenBackground(str: String): String = if (isANSISupported) GREEN_B + str + RESET else str

  def magentaBackground(str: String): String = if (isANSISupported) MAGENTA_B + str + RESET else str

  def whiteBackground(str: String): String = if (isANSISupported) WHITE_B + str + RESET else str

  def blackBackground(str: String): String = if (isANSISupported) BLACK_B + str + RESET else str

  def yellowBackground(str: String): String = if (isANSISupported) YELLOW_B + str + RESET else str
}

object Colors extends Colors