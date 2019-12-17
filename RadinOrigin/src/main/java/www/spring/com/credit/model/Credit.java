package www.spring.com.credit.model;

import java.util.Date;

import lombok.Data;
import www.spring.com.buy.model.Buy;
import www.spring.com.pay.model.Pay;

@Data
public class Credit extends Pay {

	private String company;
	private String cardNum;
	private Date dateTime;
	private String cvs;
	private String approveNum;

}
