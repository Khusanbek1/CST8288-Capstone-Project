import java.sql.Timestamp;
import java.time.Instant;

public class Message {

	private String sender;
	private String content;
	private Timestamp timeStamp;
	
	public Message(String sender, String content) {
		this.sender = sender;
		this.content = content;
		//sets timestamp when message was created
		this.timeStamp = Timestamp.from(Instant.now());
	}
	
	public String getSender() {
		return sender;
	}
	
	public String getContent() {
		return content;
	}
	
	public Timestamp getTimestamp() {
		return timeStamp;
	}
	
}
