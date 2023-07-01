import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chatsServlet")
public class ChatsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//collect message
		String message = req.getParameter("message");
		String sender = "Person1";
		
		//instantiate message
		Message aMessage = new Message(sender, message);
		
		//send message to dialog container and display it
		String page = getHTMLString(req.getServletContext().getRealPath("index.html"),
				aMessage);
		resp.getWriter().write(page);
		
		
	}
	
	/**
	 * method to read HTML as string and replace placeholders
	 * with appropriate values, return page as a string
	 * @throws IOException 
	 */
	public String getHTMLString(String filePath, Message message) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line = "";
		StringBuffer buffer = new StringBuffer();
		while ( (line=reader.readLine())!=null ) {
			buffer.append(line);
		}
		
		reader.close();
		String page = buffer.toString();
		
		page = MessageFormat.format(page, message.getContent());
		
		return page;
	}
	
}
