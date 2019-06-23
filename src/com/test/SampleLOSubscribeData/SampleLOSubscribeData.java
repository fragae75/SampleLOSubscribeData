package com.test.SampleLOSubscribeData;


public class SampleLOSubscribeData {


	/*
	 * doSubscribeElements() : create a thread that subscribe to data topics as an application : mode "json+bridge"
	 */
	public static void doSubscribeDataElements(String sTopicName, String sAPIKey, String sServerAddress, String sUserName)
	{
		Thread t;
		RunConsumeQueue consumeQueue = new RunConsumeQueue(sTopicName, sAPIKey, sServerAddress, sUserName);

		t = new Thread(consumeQueue);
		t.start();
        System.out.println("Thread : consume Queue");
	}
	
	/*
	 * 
	 * Subscribe to the MQTT broker as an application 
	 * 
	 * Reminder:
	 * 1) create a Fifo (here testFifo) which will collect and buffer the data, use the portal (or the API) : https://liveobjects.orange-business.com/#/datastore/fifo
	 * 2) create a route that will bind your source with the Fifo, use the portal (or the API) : https://liveobjects.orange-business.com/#/datastore/routing
	 * 3) connect your MQTT client to Live Objects with 'application' user name (see RunConsumeQueue.java)
	 * 
	 * Note : The 'bridge' user name ('json+bridge' and 'payload+bridge') will be deprecated end 2019. Therefore 
	 *  the topic : '~event/v1/data/new/#' will no longer be supported
	 * 
	 */
	public static void main(String[] args) {
        String API_KEY = MyKey.key; // <-- REPLACE by your API key !
        String MY_FIFO = "testFifo";
        String SERVER = "tcp://liveobjects.orange-business.com:1883";
        String MQTT_USER_NAME = "application";

		/*
		 * the 'bridge' mode will be deprecated end 2019 !!!
         * Subscribe to the router : "router/~event/v1/data/new/#"
         * doSubscribeDataElements("router/~event/v1/data/new/#", API_KEY, SERVER, "payload+bridge");
        */
        
        // To subscribe a fifo : "fifo/" + fifo name
        doSubscribeDataElements("fifo/" + MY_FIFO, API_KEY, SERVER, MQTT_USER_NAME);

	}

}
