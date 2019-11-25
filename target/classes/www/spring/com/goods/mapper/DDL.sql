drop table Goods;
drop sequence seq_Goods;

create sequence seq_Goods;

create table Goods(
	id int primary key,
	name varchar2(50) not null,
	price int not null,
	ISBN varchar2(50) not null,
	publish varchar2(2000) not null,
	subject varchar2(50) not null,
	content varchar2(2000) not null,
	bookindex varchar2(2000) not null,
	pages int not null,
	weight  varchar2(50) not null,
	booktype varchar2(50) not null,
	intro varchar2(2000) not null,
	inside varchar2(2000) not null
);

--sample data
insert into tbl_board(bno, title, content, writer)
values(seq_board.nextval, '제목을 적어주세요', '내용을 적어주세요', '홍길동');

insert into tbl_board(bno, title, content, writer)
values(seq_board.nextval, '다음 제목을 적어주세요', '다음 내용을 적어주세요', '홍도동');
