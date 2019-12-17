package www.spring.com.customer.model;

import lombok.Data;
import www.spring.com.buy.model.Buy;
import www.spring.com.party.model.Party;

@Data
public class Customer extends Party{
	private String pwd;
	private int creditId;
}
