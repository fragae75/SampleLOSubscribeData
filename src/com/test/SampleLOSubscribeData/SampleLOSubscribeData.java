package com.test.SampleLOSubscribeData;


public class SampleLOSubscribeData {


	/*
	 * doSubscribeElements() : create a thread that subscribe to data topics as an application : mode "json+bridge"
	 */
	public static void doSubscribeDataElements(String sTopicName, String sAPIKey, String sServerAddress)
	{
		Thread t;
		RunConsumeQueue consumeQueue = new RunConsumeQueue(sTopicName, sAPIKey, sServerAddress);

		t = new Thread(consumeQueue);
		t.start();
        System.out.println("Thread : consume Queue");
	}
	
	/*
	 * 
	 * Subscribe as an application (mode json+bridge) to the topic : "~event/v1/data/new/#"
	 * 
	 */
	public static void main(String[] args) {
//        Random rand = new Random();
        String API_KEY = MyKey.key; // <-- REPLACE by your API key !
        
        String SERVER = "tcp://liveobjects.orange-business.com:1883";
//        String DEVICE_URN = "urn:lo:nsid:sensor:SampleLO001";

        // Subscribe to the router : "router/~event/v1/data/new/#"
        // To subscribe a fifo : "fifo/myfifo"
        doSubscribeDataElements("router/~event/v1/data/new/#", API_KEY, SERVER);
//      doSubscribeDataElements("fifo/myfifo", API_KEY, SERVER);

	}

}
