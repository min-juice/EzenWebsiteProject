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
SELECT * FROM F_MEMBER
COMMIT
INSERT INTO FLOWER_MEMBER values ('admin','admin','admin','admin','admin','admin','admin', 1, sysdate, sysdate, 100000, 100000)

SELECT MEMID, MEMNAME, ADMINCK, MONEY, POINT FROM f_member where MEMID = 'test1' AND MEMPW = 'test1';

select * from f_member

UPDATE f_member SET adminck = 1 where memid = 'admin1'
UPDATE f_member SET point = 500000 where memid = 'admin'
DELETE f_member where memid = 'admin1'

CREATE table goods_category (
fcName VARCHAR2(20) not null,
fCode VARCHAR2(30) not null,
fcCodeRef VARCHAR2(30) null,
primary key(fCode),
foreign key(fcCodeRef) references goods_category(fCode)
)

select g.fNum, g.fName, g.fCode, c.fcCodeRef, c.fcName, fPrice, fStock, fDes, fImg, fDate
			from goods g
				inner join goods_category c
					on g.fCode = c.fCode
						where g.fNum = #{fNum}

drop table goods_category

INSERT INTO goods_category (fName, fCode) values ('생화', '100')
INSERT INTO goods_category (fName, fCode, fCodeRef) values ('국화', '101', '100')
INSERT INTO goods_category (fName, fCode, fCodeRef) values ('글라디올러스', '102', '100')
INSERT INTO goods_category (fName, fCode, fCodeRef) values ('디디스커스', '103', '100')
INSERT INTO goods_category (fName, fCode, fCodeRef) values ('맨드라미', '104', '100')

INSERT INTO goods_category (fName, fCode) values ('장미', '200')
INSERT INTO goods_category (fName, fCode, fCodeRef) values ('국산장미', '201', '200')
INSERT INTO goods_category (fName, fCode, fCodeRef) values ('수입장미', '202', '200')
INSERT INTO goods_category (fName, fCode, fCodeRef) values ('스프레이장미', '203', '200')

INSERT INTO goods_category (fName, fCode) values ('조화', '300')
INSERT INTO goods_category (fName, fCode, fCodeRef) values ('라그라스', '301', '300')
INSERT INTO goods_category (fName, fCode, fCodeRef) values ('루나리아', '302', '300')
INSERT INTO goods_category (fName, fCode, fCodeRef) values ('수국', '303', '300')
INSERT INTO goods_category (fName, fCode, fCodeRef) values ('미스터블루', '304', '300')
COMMIT

CREATE table goods(
fNum number not null,
fName VARCHAR2(40) not null,
fCode VARCHAR2(20) not null,
fPrice number null,
fStock number null,
fDes VARCHAR2(500) null,
fImg VARCHAR2(500) null,
fDate date default sysdate,
primary key(fNum)
)

CREATE SEQUENCE goodsSeq
    INCREMENT BY 1
    MAXVALUE 100000 
    NOCYCLE 
    CACHE 50; 


SELECT * FROM USER_SEQUENCES;

INSERT INTO goods (fNum, fName, fCode, fPrice, fStock, fDes)
values (goodsSeq.nextval, '상품이름', 100, 1000, 30, '상품설명')

SELECT * FROM goods

SELECT level, fName, fCode, fCodeRef from goods_category
start with fCodeRef is null connect by prior fCode = fCodeRef

CREATE TABLE attach(
id NUMBER(8) PRIMARY KEY,
fullName VARCHAR2(200) NOT NULL,
bno NUMBER(6),
regdate DATE DEFAULT SYSDATE,
CONSTRAINT fk_attach_bno FOREIGN KEY(bno) REFERENCES board(bno) 
ON DELETE CASCADE
)

select * from attach














SELECT * FROM reply

CREATE TABLE reply(
rno NUMBER PRIMARY KEY,
bno NUMBER NOT NULL,
replytext VARCHAR2(1000) NOT NULL,
replyer VARCHAR2(30) NOT NULL,
regDate DATE DEFAULT SYSDATE,
updateDate DATE DEFAULT SYSDATE,
CONSTRAINT reply_fk_bno FOREIGN KEY(bno) REFERENCES board(bno)
)














DROP TABLE REPLY

CREATE TABLE reply(
rno NUMBER PRIMARY KEY,
bno NUMBER NOT NULL,
replytext VARCHAR2(1000) NOT NULL,
replyer VARCHAR2(30) NOT NULL,
regDate DATE DEFAULT SYSDATE,
updateDate DATE DEFAULT SYSDATE,
CONSTRAINT reply_fk_bno FOREIGN KEY(bno) REFERENCES board(bno) 
ON DELETE CASCADE
)








delete from reply















DROP TABLE BOARD

CREATE TABLE  board (
	bno NUMBER(6) PRIMARY KEY,
	title VARCHAR2(100) NOT NULL,
	content VARCHAR2(3000) NOT NULL,
	writer VARCHAR2(30) NOT NULL,
	regDate DATE DEFAULT SYSDATE,
	updateDate DATE DEFAULT SYSDATE,
	viewCnt NUMBER DEFAULT 0

)

ALTER TABLE board ADD replyCnt NUMBER(4) DEFAULT 0

SELECT * FROM board ORDER BY bno DESC

UPDATE board 
SET 
replyCnt = (SELECT COUNT(rno) FROM reply WHERE bno = board.bno) 

COMMIT









INSERT INTO board (bno, title, content, writer)
VALUES (1, 'HELLO', 'HELLO IS ANNYEON', 'KIM')




SELECT NVL2(MAX(bno), MAX(bno)+1, 1) FROM board


INSERT INTO board (bno, title, content, writer)
VALUES ((SELECT NVL2(MAX(bno), MAX(bno)+1, 1) FROM board), 
        '안녕', 
        '안녕은 hello입니다.', 
        '홍길동')


















CREATE TABLE member(
userid VARCHAR2(6) PRIMARY KEY,
userpw 	VARCHAR2(6) NOT NULL,
username VARCHAR2(18) NOT NULL,
email VARCHAR2(100),
regdate DATE DEFAULT SYSDATE,
updatedate DATE DEFAULT SYSDATE
)

SELECT * FROM member
DELETE FROM member
COMMIT
INSERT INTO member (userid, userpw, username) values ('m001', 'm001', 'm001')