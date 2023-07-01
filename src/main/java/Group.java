import java.util.ArrayList;

public class Group {

	private String name;
	private ArrayList<String> messages;
	
	public Group(String name) {
		this.name = name;
	}
	
	public void addMessage(String message) {
		messages.add(message);
	}
	
	public String getName() {
		return name;
	}
	
	//returns array of messages starting at oldest message
	public ArrayList<String> getMessages() {
		return messages;
	}
	
}
