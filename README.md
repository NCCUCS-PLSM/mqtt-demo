# MQTT Python Demo

This is a Python demostration of MQTT protocol. 

For Java version you can visit [this](https://github.com/cfliao/2015-mqtt-java-client) project.

# Prerequisite

* MQTT broker: Mosquitto (yap, an additional 't' there)
	* Ubuntu: `sudo apt-get install mosquitto`
	* OS X: `brew install mosquitto`
	
* The Mosquitto Python Module 
	* `pip install paho-mqtt` 
	* For Java version, you should download Java libraries [org.eclipse.paho.client.mqttv3](https://repo.eclipse.org/content/repositories/paho-releases/org/eclipse/paho/org.eclipse.paho.client.mqttv3/) and [org.eclipse.paho.mqtt.utility](https://repo.eclipse.org/content/repositories/paho-releases/org/eclipse/paho/org.eclipse.paho.mqtt.utility/)

# Usage
1. You should first launch an MQTT broker server. With instanlling mosquitto, you can launch a server with purely type `mosquitto`.
![](img/broker_server.png)

2. Then use `python  mqtt_subscriber.py` and `python mqtt_publisher.py` respectively.

* Subscriber
![subscriber](img/sub.png)

* Publisher
![publisher](img/pub.png)

3. The publisher will automatically terminate after send a message to broker. To terminate subscriber and broker server, use `ctrl + C` or `control + C` for times.
