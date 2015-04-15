var mqtt = require('mqtt');
var client = mqtt.connect('*://localhost');	//needless to assign port, protocol can be anyone, "://" is needed at least

client.on('connect', function(){
	client.subscribe('here is topic');
	client.publish('here is topic', 'here is message');
});

client.on('message', function(topic, message){
	console.log(topic.toString());
	console.log(message.toString());
	client.end();
});