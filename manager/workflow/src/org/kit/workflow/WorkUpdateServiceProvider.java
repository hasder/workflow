package org.kit.workflow;

import java.util.Observable;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.coap.CoAP.Type;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class WorkUpdateServiceProvider extends Observable {
	CoapServer server;
	ProviderResource providerResource;
	
	
	public WorkUpdateServiceProvider () {
		server = new CoapServer(5688);
		providerResource = new ProviderResource("InstructionProvider");
		
		server.add( providerResource );
		
		server.start();
	}
	
	public void setWorkResource(String work) {
		providerResource.setWorkResource(work);
	}
	
	public class ProviderResource extends CoapResource {
		String work = "hello there!";

		public ProviderResource(String name) {
			super(name);
			
			setObservable(true);
			getAttributes().setObservable();
			setObserveType(Type.NON);
			
		}
		
		public void setWorkResource(String work) {
			this.work = work;
			changed();
		}
		
		
		@Override
		public void handleGET(CoapExchange exchange) {
			
			exchange.respond(work);
			//exchange.respond(this.data.toString());
		}
	}

}
