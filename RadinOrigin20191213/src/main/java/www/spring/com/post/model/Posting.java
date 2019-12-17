package www.spring.com.post.model;

import lombok.Data;
import www.spring.com.reply.model.Reply;

@Data
public class Posting extends Reply{
	private String title;
}
