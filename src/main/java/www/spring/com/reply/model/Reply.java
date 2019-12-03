package www.spring.com.reply.model;

import java.util.Date;

import lombok.Data;
import www.spring.com.p2grel.model.P2GRel;
import www.spring.com.p2gtype.model.PGRelType;
@Data
public class Reply extends P2GRel {
	private String contents;
	private float rate;
	private Date regDate;
	private int childId;
}
