package www.spring.com.p2grel.model;

import java.util.Date;

import lombok.Data;
import www.spring.com.p2gtype.model.PGRelType;

@Data
public abstract class P2GRel {
	protected int id;
	protected int amount;
	protected int saleRecordId;
	protected int partyId;
	protected int goodsId;
	protected PGRelType relType;
	private int payId;
	private Date regdate;

	
}
