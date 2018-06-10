package org.kit.workflow;

import java.util.Observable;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.coap.CoAP.Type;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class WorkServiceProvider extends Observable {
	CoapServer server;
	WorkProviderResource workProviderResource;
	WorkProgressProviderResource workProgressProviderResource;
	
	
	public WorkServiceProvider () {
		server = new CoapServer(5688);
		workProviderResource = new WorkProviderResource("InstructionProvider");
		workProgressProviderResource = new WorkProgressProviderResource("ProgressProvider");
		
		
		server.add( workProviderResource );
		server.add( workProgressProviderResource );
		
		server.start();
	}
	String progress = "";
	public void watermelon(String progress) {
		this.progress = progress;
		setChanged();
		notifyObservers(this);
	}
	
	public void setWorkResource(String work) {
		workProviderResource.setWorkResource(work);
	}
	
	public class WorkProviderResource extends CoapResource {
		String work = "clear";

		public WorkProviderResource(String name) {
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
	
	public class WorkProgressProviderResource extends CoapResource {
		String work = "hello there!";

		public WorkProgressProviderResource(String name) {
			super(name);
			
		}		
		
		@Override
		public void handlePOST(CoapExchange exchange) {
			watermelon(exchange.getRequestText());
			exchange.respond(ResponseCode.VALID);
			//exchange.respond(this.data.toString());
		}
	}

}
