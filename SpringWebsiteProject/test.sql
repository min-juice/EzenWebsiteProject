CREATE TABLE FLOWER_MEMBER(
memId VARCHAR2(50) PRIMARY KEY,
memPw VARCHAR2(100) NOT NULL,
memName VARCHAR2(30) NOT NULL,
memMail VARCHAR2(100) NOT NULL,
memAd1 VARCHAR2(100) NOT NULL,
memAd2 VARCHAR2(100) NOT NULL,
memAd3 VARCHAR2(100) NOT NULL,
adminCK NUMBER NOT NULL,
regDate DATE NOT NULL,
updatedate DATE NOT NULL,
money NUMBER NOT NULL,alsw
point NUMBER NOT NULL
)
SELECT * FROM F_MEMBER order by MemId desc
COMMIT
INSERT INTO FLOWER_MEMBER values ('admin','admin','admin','admin','admin','admin','admin', 1, sysdate, sysdate, 100000, 100000)

SELECT MEMID, MEMNAME, ADMINCK, MONEY, POINT FROM f_member where MEMID = 'test1' AND MEMPW = 'test1';

select * from f_member


UPDATE f_member SET adminck = 1 where memid = 'admin1'
UPDATE f_member SET point = 500000 where memid = 'admin'
DELETE f_member where memid = 'admin1'

CREATE table goods_category (
cateName VARCHAR2(20) not null,
cateCode VARCHAR2(30) not null,
cateCodeRef VARCHAR2(30) null,
primary key(cateCode),
foreign key(cateCodeRef) references goods_category(cateCode)
)

select * from goods_category
drop table goods_category

INSERT INTO goods_category (cateName, cateCode) values ('shop', '100')
INSERT INTO goods_category (cateName, cateCode) values ('화병', '200')
INSERT INTO goods_category (cateName, cateCode) values ('소품', '300')
INSERT INTO goods_category (cateName, cateCode) values ('Q&A', '400')
INSERT INTO goods_category (cateName, cateCode) values ('NOTICE', '500')

INSERT INTO goods_category (cateName, cateCode, cateCodeRef) values ('생화', '101', '100')
INSERT INTO goods_category (cateName, cateCode, cateCodeRef) values ('장미', '102', '100')
INSERT INTO goods_category (cateName, cateCode, cateCodeRef) values ('조화', '103', '100')
INSERT INTO goods_category (cateName, cateCode, cateCodeRef) values ('카네이션', '104', '100')
INSERT INTO goods_category (cateName, cateCode, cateCodeRef) values ('소재', '105', '100')


INSERT INTO goods_category (cateName, cateCode) values ('생화', '100')
INSERT INTO goods_category (cateName, cateCode, cateCodeRef) values ('국화', '101', '100')
INSERT INTO goods_category (cateName, cateCode, cateCodeRef) values ('글라디올러스', '102', '100')
INSERT INTO goods_category (cateName, cateCode, cateCodeRef) values ('디디스커스', '103', '100')
INSERT INTO goods_category (cateName, cateCode, cateCodeRef) values ('맨드라미', '104', '100')

INSERT INTO goods_category (cateName, cateCode) values ('장미', '200')
INSERT INTO goods_category (cateName, cateCode, cateCodeRef) values ('국산장미', '201', '200')
INSERT INTO goods_category (cateName, cateCode, cateCodeRef) values ('수입장미', '202', '200')
INSERT INTO goods_category (cateName, cateCode, cateCodeRef) values ('스프레이장미', '203', '200')

INSERT INTO goods_category (cateName, cateCode) values ('조화', '300')
INSERT INTO goods_category (cateName, cateCode, cateCodeRef) values ('라그라스', '301', '300')
INSERT INTO goods_category (cateName, cateCode, cateCodeRef) values ('루나리아', '302', '300')
INSERT INTO goods_category (cateName, cateCode, cateCodeRef) values ('수국', '303', '300')
INSERT INTO goods_category (cateName, cateCode, cateCodeRef) values ('미스터블루', '304', '300')

INSERT INTO goods_category (cateName, cateCode) values ('카네이션', '400')
INSERT INTO goods_category (cateName, cateCode, cateCodeRef) values ('대륜', '401', '400')
INSERT INTO goods_category (cateName, cateCode, cateCodeRef) values ('미니', '402', '400')
INSERT INTO goods_category (cateName, cateCode, cateCodeRef) values ('스프레이', '403', '400')

INSERT INTO goods_category (cateName, cateCode) values ('소재', '500')
INSERT INTO goods_category (cateName, cateCode, cateCodeRef) values ('레몬트리', '501', '500')
INSERT INTO goods_category (cateName, cateCode, cateCodeRef) values ('몬스테라', '502', '500')
INSERT INTO goods_category (cateName, cateCode, cateCodeRef) values ('아카시아', '503', '500')
INSERT INTO goods_category (cateName, cateCode, cateCodeRef) values ('기타', '504', '500')
COMMIT

delete tbl_goods where gdsNum = 51

select g.gdsNum, g.gdsName, g.cateCode, c.cateCodeRef, c.cateName, gdsPrice, gdsStock,
		gdsDes, gdsImg, gdsDate, g.gdsImg, g.gdsThumbImg
		from tbl_goods g
		inner join goods_category c
		on g.cateCode = c.cateCode
		where g.cateCode = 101
		
select level, cateName,
		cateCode, cateCodeRef from goods_category
		start with cateCodeRef is null connect by prior cateCode = cateCodeRef
		
		alter table tbl_goods add (gdsThumbImg varchar(200));
		
select * from tbl_goods
drop table tbl_goods
COMMIT
select
        
        select * from tbl_goods
        
create table tbl_goods (
    gdsNum       number          not null,
    gdsName      varchar2(50)    not null,
    cateCode     varchar2(30)    not null,
    gdsPrice     number          not null,
    gdsStock     number          null,
    gdsDes       varchar(500)    null,
    gdsImg       varchar(200)    null,
    gdsDate      date            default sysdate,
    primary key(gdsNum)  
)

alter table tbl_goods add
    constraint fk_goods_category
    foreign key (cateCode)
        references goods_category(cateCode);

        alter table tbl_goods add (gdsThumbImg varchar(200))
        
CREATE SEQUENCE tbl_goods_Seq
    INCREMENT BY 1
    MAXVALUE 100000 
    NOCYCLE 
    CACHE 50; 

    select gdsImg, gdsThumbImg from tbl_goods

SELECT * FROM USER_SEQUENCES;

INSERT INTO goods (fNum, fName, fCode, fPrice, fStock, fDes)
values (goodsSeq.nextval, '상품이름', 100, 1000, 30, '상품설명')

SELECT * FROM goods

SELECT level, fName, fCode, fCodeRef from goods_category
start with fCodeRef is null connect by prior fCode = fCodeRef


drop table tbl_reply

create table tbl_reply (
    gdsNum      number          not null,
    memId      varchar2(50)    not null,
    repNum      number          not null,
    repCon      varchar2(2000)  not null,
    repDate     date            default sysdate,
    primary key(gdsNum, repNum) 
)

alter table tbl_reply
    add constraint tbl_reply_gdsNum foreign key(gdsNum)
    references tbl_goods(gdsNum);
   
alter table tbl_reply
    add constraint tbl_reply_memId foreign key(memId)
    references f_member(memId);
    
create sequence tbl_reply_seq

select * from tbl_reply

delete tbl_reply where repNum = 23 and memId = 'test5'


select gdsNum, memId, repNum, repCon, repDate
from tbl_reply where gdsNum = 151

select r.gdsNum, r.memId, r.repNum, r.repCon, r.repDate, m.memName
from tbl_reply r
	inner join f_member m
	on r.memId = m.memId
	where gdsNum = 151
	
	update tbl_reply set repCon = '수정한 내용11' where repNum = 24 and memId = 'test5'

COMMIT

create table tbl_cart (
cartNum number not null,
memId varchar2(50) not null,
gdsNum number not null,
cartStock number not null,
addDate date default sysdate,
primary key(cartNum, memId)
)

create sequence tbl_cart_seq

alter table tbl_cart
    add constraint tbl_cart_userId foreign key(memId)
    references f_member(memId);

alter table tbl_cart
    add constraint tbl_cart_gdsNum foreign key(gdsNum)
    references tbl_goods(gdsNum);
    
    insert into tbl_cart (cartNum, memId, gdsNum, cartStock)
    values (tbl_cart_seq.nextval, 'test5', 151, 12);
    
    select * from tbl_cart

    COMMIT
    
select row_number() over(order by c.cartNum desc) as num,
c.cartNum, c.memId, c.gdsNum, c.cartStock, c.addDate,
g.gdsName, g.gdsPrice, g.gdsthumbimg
from tbl_cart c
inner join tbl_goods g
on c.gdsNum = g.gdsNum
where c.memId = 'test5'
