
__author__ = "Veck Hsiao"

import paho.mqtt.publish as publish

publish.single("$SYS", "xpayload", hostname="localhost", port=1883)
