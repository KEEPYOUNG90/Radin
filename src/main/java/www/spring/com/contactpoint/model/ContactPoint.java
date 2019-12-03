package www.spring.com.contactpoint.model;

import lombok.Data;
import www.spring.com.buy.model.Buy;
import www.spring.com.party.model.Party;

@Data

public class ContactPoint {

	private String contract;
	private int contactType;
	private int partyId;
}
