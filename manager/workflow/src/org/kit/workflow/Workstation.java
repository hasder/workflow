package org.kit.workflow;

public class Workstation {

	// Machine machine;
	// WorkServiceProvider workProvider;
	// PresenterServiceConsumer presenterConsumer;

	public static void main(String[] args) throws Exception {

		ServiceRegistration sr = new ServiceRegistration();
		sr.doPeriodicRegistration();

		WorkService workProvider = new WorkService();
		ProductionorderService productionorderServiceConsumer = new ProductionorderService("www.google.com");
		WorkpieceArrivalService workpieceArrivalProvider = new WorkpieceArrivalService(productionorderServiceConsumer);
		TheBusiness thebusiness = new TheBusiness();
		
		
		productionorderServiceConsumer.setTheBusiness(thebusiness);
		thebusiness.setWorkServiceProvider(workProvider);

		

		workProvider.startServiceProvider();
		productionorderServiceConsumer.startServiceConsumer();
		workpieceArrivalProvider.startServiceProvider();
		thebusiness.startTheBusiness();
		// String srurl =
		// "http://130.240.234.222:1100/servicediscovery/service/";
		// String ip;
		// int port;
		// String path = "";
		// try {
		//
		// HttpClient httpClient = new DefaultHttpClient();
		// HttpGet getRequest = new HttpGet( srurl + "pal");
		// getRequest.addHeader("accept", "application/json");
		//
		// HttpResponse response = httpClient.execute(getRequest);
		//
		// if (response.getStatusLine().getStatusCode() != 200) {
		// throw new RuntimeException("Failed : HTTP error code : "
		// + response.getStatusLine().getStatusCode());
		// }
		//
		// StringWriter writer = new StringWriter();
		// IOUtils.copy(response.getEntity().getContent(), writer, "UTF-8" );
		// String theString = writer.toString();
		//
		// Service[] serviceListResponse = new Gson().fromJson(theString,
		// Service[].class);
		//
		// Service serviceResponse = serviceListResponse[0];
		//
		// System.out.println("sevice name: " + serviceResponse.getName());
		// System.out.println("sevice host: " + serviceResponse.getHost());
		// ip = serviceResponse.getHost();
		// System.out.println("sevice port: " + serviceResponse.getPort());
		// port = serviceResponse.getPort();
		// for (Property property :
		// serviceResponse.getProperties().getProperty()) {
		// if(property.getName().toLowerCase().equals("path")) {
		// path = property.getValue();
		// }
		// }
		// System.out.println("sevice path: " + path);
		//
		// //https://gto-productunit-hub-test.azurewebsites.net/api/GetProcessStepRouting?code=IZ3ByNNi1hi49487SQUB2VIO9z54EIs0PTbeTXuIem36AvY5an5R4Q==&chassisid=A819631&component=CAB&subcomponent=TCAB
		//
		//// String url = "https://"+ip+":"+port+"/"+path;
		// String url =
		// "https://gto-productunit-hub-test.azurewebsites.net/api/GetProcessStepRouting";
		//// //?code=D6Z1wsx0wH6xsQ/1b6S/VKgRFVvU9yDbcaLicNHpxV7pL7DQdjoDlw==&chassisid=A819631&component=CAB&subcomponent=TCAB
		////
		// HttpGet getProcessStepRoute = new HttpGet( url +
		// "?code=IZ3ByNNi1hi49487SQUB2VIO9z54EIs0PTbeTXuIem36AvY5an5R4Q==&chassisid=A819631&component=CAB&subcomponent=TCAB");
		//
		// getProcessStepRoute.addHeader("accept", "application/json");
		//
		//
		// HttpResponse response2 = httpClient.execute(getProcessStepRoute);
		//
		// writer = new StringWriter();
		// IOUtils.copy(response2.getEntity().getContent(), writer, "UTF-8" );
		// theString = writer.toString();
		//
		// GetProcessStepRouting processStepRouting = new
		// Gson().fromJson(theString, GetProcessStepRouting.class);
		//
		//
		//
		// for(OrderProcessStep orderProcessStep :
		// processStepRouting.getOrderProcessSteps())
		// {
		// System.out.println("id = " + orderProcessStep.getId());
		// }
		//
		//
		// httpClient.getConnectionManager().shutdown();
		//
		// } catch (ClientProtocolException e) {
		//
		// e.printStackTrace();
		//
		// } catch (IOException e) {
		//
		// e.printStackTrace();
		// }

		// try {
		//
		// HttpResponse<Service> response2 = Unirest.get(srurl)
		// .routeParam("name", "pal")
		// .asObject(Service.class);
		// Service service = response2.getBody();
		//
		// System.out.println("sevice name: " + service.getName());
		// System.out.println("sevice host: " + service.getHost());
		// ip = service.getHost();
		// System.out.println("sevice port: " + service.getPort());
		// port = service.getPort();
		// for (Property property : service.getProperties().getProperty()) {
		// if(property.getName().toLowerCase().equals("path")) {
		// path = property.getValue();
		// }
		// }
		// System.out.println("sevice path: " + path);
		//
		// String url = "https://"+ip+":"+port+"/"+path;
		// //String url =
		// "https://gto-productunit-hub-test.azurewebsites.net/api/GetRouting";
		// //?code=D6Z1wsx0wH6xsQ/1b6S/VKgRFVvU9yDbcaLicNHpxV7pL7DQdjoDlw==&chassisid=A819631&component=CAB&subcomponent=TCAB
		//
		// HttpResponse<GetProcessStepRouting> response = Unirest.get(url)
		// .queryString("code",
		// "D6Z1wsx0wH6xsQ/1b6S/VKgRFVvU9yDbcaLicNHpxV7pL7DQdjoDlw")
		// .queryString("chassisid","A819631")
		// .queryString("component","CAB")
		// .queryString("subcomponent","TCAB")
		// .asObject(GetProcessStepRouting.class);
		// GetProcessStepRouting getProcessStepRouting = response.getBody();
		// for(OrderProcessStep orderProcessStep :
		// getProcessStepRouting.getOrderProcessSteps())
		// {
		// System.out.println("id = " + orderProcessStep.getId());
		// }
		// } catch (UnirestException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		//
		// //Workstation workstation = new Workstation();
		//
		// //Thread stateMachineThread = new Thread (workstation.machine);
		//
		// //stateMachineThread.start();
		// try {
		// Thread.sleep(200000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// try {
		// Unirest.shutdown();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	public Workstation() {

		// machine = new Machine();
		// workProvider = new WorkServiceProvider();
		// presenterConsumer = new
		// PresenterServiceConsumer("coap://127.0.0.1:8888/.well-known/core");
		//
		// workProvider.addObserver(machine);
		// machine.addWorkProvider(workProvider);
		// machine.addPresenterConsumer(presenterConsumer);
		//

	}

}
