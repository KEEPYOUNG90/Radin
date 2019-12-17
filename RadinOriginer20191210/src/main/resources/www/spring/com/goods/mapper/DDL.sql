DROP table t_Goods;
DROP table t_Party;
DROP table t_ContactPointType;
DROP table t_ContactPoint;
DROP table t_PartyGoodsRelType;
DROP table t_PartyGoodsRel;
DROP table t_Pay;
DROP table t_g2KRel;
DROP table t_P2KRel;
DROP table t_KeywordRelationType;
DROP table t_Keyword;
DROP table t_KeywordRelation;
DROP table t_Category;  

create sequence seq_KeywordRelationType;
create sequence seq_Keyword;
create sequence seq_Pay;
create sequence seq_PartyGoodsRel;
create sequence seq_PartyGoodsRelType;
create sequence seq_ContactPointType;
create sequence seq_Party;
create sequence seq_Category;
create sequence seq_Goods;



create table t_Goods(
	id int primary key,
	name varchar2(50) not null,
	price int not null,
	ISBN varchar2(50) not null,
	publish varchar2(20) not null,
	subject varchar2(50) not null,
	content varchar2(2000) not null,
	bookindex varchar2(2000) not null,
	pages int not null,
	weight  varchar2(50) not null,
	booktype varchar2(50) not null,
	intro varchar2(2000) not null,
	inside varchar2(2000) not null,
	Category_id int references t_Category(id)
);

create table t_Party(
	id int primary key,
	partyType CHAR,   --  {custom, author, company}
	name      varchar2(100), --회사이름 작가이름 고객이름
	pwd       varchar2(256), --해쉬값  
	descript  varchar2(100) --소개글
);

create table t_ContactPointType(
			contactType int primary key,
			descript varchar2(100) --메일 /핸드폰 /카카오 /메인 어드레스 /서브 어드레스
);

create table t_ContactPoint(
	Party_id int references t_Party(id),
	contactType int references t_ContactPointType(contactType), --{5개 중 하나}
	contract   varchar2(100),
	CONSTRAINT PK_ContactPoint PRIMARY KEY(Party_id,contactType)
);

create table t_PartyGoodsRelType (
    PartyGoodsRelType int primary key,
    descript  varchar2(100)
);
    
create table t_PartyGoodsRel (
    id              int    primary key,
    PartyGoodsRel_type          int references t_PartyGoodsRelType(PARTYGOODSRELTYPE),  --descriminator 역할로 쓰세요
    Party_id    int   references t_Party(id),
    Goods_id  int  references t_Goods(id),
    sale_record_id int  references t_PartyGoodsRel(id),    -- 이 값의 주인의 type 정보는 필히 SaleRecord이고 자기 자신의 type은 buy_detail 이어야 합니다.
    trade_date   date,
    amount    int,
    Pay_id int references t_Pay(id)
);

create table t_Pay(
id int primary key,
pg_id int,
method char, --카드:0/현금:1/
state_msg varchar2(100),
company    varchar2(20),
cardNum    varchar2(16),
dateTime   DATE,
cvs        varchar2(3),
approveNum  varchar2(100)
);


create table t_g2KRel (
	goods_id		int references t_Goods(id),
	keyword_id		int references t_Keyword(id),
	constraint PK_t_g2KRel primary key(keyword_id, goods_id)
);


create table t_P2KRel (
	party_id		int references	t_Party(id),
	keyword_id		int references	t_Keyword(id),
	constraint PK_t_P2KRel primary key(party_id,keyword_id)
);

create table t_KeywordRelationType (
    KeywordRelationType_type   int primary key,
    descript  varchar2(100)
);

create table t_Keyword (
	id			int primary key,
	word		varchar2(100)
);
    
create table t_KeywordRelation (
    KeywordRelation_type    int     references t_KeywordRelationType(KeywordRelationType_type),  --descriminator 역할로 쓰세요
    keyword_id    int   references t_Keyword(id),
    constraint PK_t_KeywordRelation primary key(keyword_id, KeywordRelation_type)
);

create table t_Category (
    id int primary key,
    name varchar2(100),
    childId int references t_Category(id)
);


create table t_Category (
    id int primary key,
    name varchar2(100),
    childId int references t_Category(id)
);


create table t_Category (
    id int primary key,
    name varchar2(100),
    childId int references t_Category(id)
);


create index idx_KW_word on t_keyword(word);