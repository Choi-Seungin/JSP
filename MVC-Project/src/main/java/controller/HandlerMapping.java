package controller;

public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();

	public HandlerMapping() {
	}

	public static HandlerMapping getInstance() {
		if(instance == null)
			instance = new HandlerMapping();
		return instance;
	}

	public Controller createController(String command) {
		Controller controller = null;
		switch (command) {
		case "allMember":
			controller = new SelectAllMemberController();
			break;
		case "main":
			controller = new MainController();
			break;
		case "allMember2":
			controller = new SelectAllMember2Controller();
			break;
		case "searchNameMember":
			controller = new SelectMemberNameController();
			break;
			
		}
			
		return controller;
	}
	
	
}
