package www.spring.com.pay.model;

import lombok.Data;
@Data
public class Pay{
	private int id;
	private char method; 
	private String state_msg;
}
