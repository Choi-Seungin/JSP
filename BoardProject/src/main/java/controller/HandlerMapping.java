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
		case "loginView":
			controller = new LoginViewController();
			break;
		case "login":
			controller = new LoginController();
			break;
		case "boardMain":
			controller = new BoardMainController();
			break;
		case "boardWriteView":
			controller = new BoardWriteViewController();
			break;
		case "boardWrite":
			controller = new BoardWriteController();
			break;
		case "boardView":
			controller = new BoardViewController();
			break;
		case "commentWrite":
			controller = new BoardCommentInsertController();
			break;
		case "boardDelete":
			controller = new BoardDeleteController();
			break;
		case "boardCommentDelete":
			controller = new BoardCommentDeleteController();
			break;
		}
			
		return controller;
	}
	
	
}