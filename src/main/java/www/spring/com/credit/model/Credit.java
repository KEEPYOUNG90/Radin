package www.spring.com.credit.model;

import java.util.Date;

import www.spring.com.pay.model.Pay;

public class Credit extends Pay {

	private int pg_id;
	private String company;
	private String cardNum;
	private Date dateTime;
	private String cvs;
	private String approveNum;
}
