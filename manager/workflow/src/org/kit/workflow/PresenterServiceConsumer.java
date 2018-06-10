package org.kit.workflow;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;

public class PresenterServiceConsumer {
	CoapClient client = null;
	String instruction = "";
	
	public PresenterServiceConsumer(String addressURI) {
		this.client = new CoapClient(addressURI);
		
	}
	
	public void sendNewInstructionList(String jobText) {
		CoapResponse response = this.client.put(jobText, 0);
		if(response != null) {
			if(response.getCode() == ResponseCode.CREATED) {
				System.out.println("Job was created");
			} else {
				System.err.println("Job was not created");
			}
		}
	}
}
