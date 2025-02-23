create table member(
	id varchar2(30) not null, -- id
	pw varchar2(10) not null, -- pw
	name varchar2(30) not null, -- name
	num varchar2(30) not null, -- 전화번호
	sex varchar2(5) not null,
	email varchar2(30) not null,
	agree1 varchar2(10) not null,
	agree2 varchar2(10) not null,
	regidate date default sysdate not null, -- 생성일
	primary key(id) -- 기본키 생성
) -- 회원용 테이블


insert into MEMBER(id, pw, name, num, sex, email, agree1, agree2, regidate) values('admin', '1234', '관리자', 
'010-0101-1010', 'man', 'asdf@ghj.com', 'no', 'no', '1100/01/01');
insert into MEMBER(id, pw, name, num, sex, email, agree1, agree2, regidate) values('asdf', 'asdf', 'asdf', 
'010-0101-1010', 'man', 'asdf@gdj.com', 'no', 'no', '1100/01/01');

select * from MEMBER;

drop table member;

select * from member where id='admin' and pw='1234';