# SampleLOSubscribeData

Sample application for Datavenue Live Objects : https://liveobjects.orange-business.com/#/liveobjects

It is a simple sample that collect a MQTT data from Live Objects as an application ("payload+bridge")

1) Create an account on Live Objects. You can get a free account (10 MQTT devices for 1 year) at : https://liveobjects.orange-business.com/#/request_account <br>
Don't check "Lora" otherwise the account will not be instantly created.

2) Generate your API key : menu Configuration/API Keys click on "Add"

3) Create a MyKey class : 

package com.test.SampleLOSendData; <br>

public final class MyKey { <br>
	static String key = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"; <br>
}<br>

4) You will find into the repository 4 jar files into the /lib. Add them as "external JARs" into you IDE (eg Eclipse).

If you need to generate data, use the SampleLOSendData sample or the Android app at : https://play.google.com/store/apps/details?id=com.orange.lo.assetdemo

