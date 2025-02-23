create table roomTBL(
roomno varchar2(30) primary key, -- 객실 번호
roomtype varchar2(30) not null, -- 객실 타입
amount varchar2(30) not null, -- 가격
roomstatus varchar2(30) not null, -- 잔여객실 (빈방, 예약중)
roomcheckindate varchar2(30), -- 체크인 날짜
roomcheckoutdate varchar2(30) -- 체크아웃 날짜
);


select * from roomTBL;

drop table roomTBL;


--더미데이터
insert into roomTBL (roomno, roomtype, amount, roomstatus, roomcheckindate, roomcheckoutdate)
	values ('201', 'Superior Room', '100000', '빈방', '', '');
insert into roomTBL (roomno, roomtype, amount, roomstatus, roomcheckindate, roomcheckoutdate)
	values ('202', 'Superior Room', '100000', '투숙중', '2024-08-06', '2024-08-08');
insert into roomTBL (roomno, roomtype, amount, roomstatus, roomcheckindate, roomcheckoutdate)
	values ('203', 'Superior Room', '100000', '빈방', '', '');
	
insert into roomTBL (roomno, roomtype, amount, roomstatus, roomcheckindate, roomcheckoutdate)
	values ('301', 'Deluxe Room', '200000', '빈방', '', '');
insert into roomTBL (roomno, roomtype, amount, roomstatus, roomcheckindate, roomcheckoutdate)
	values ('302', 'Deluxe Room', '200000', '빈방', '', '');
insert into roomTBL (roomno, roomtype, amount, roomstatus, roomcheckindate, roomcheckoutdate)
	values ('303', 'Deluxe Room', '200000', '빈방', '', '');
	
insert into roomTBL (roomno, roomtype, amount, roomstatus, roomcheckindate, roomcheckoutdate)
	values ('401', 'Signature Room', '300000', '빈방', '', '');
insert into roomTBL (roomno, roomtype, amount, roomstatus, roomcheckindate, roomcheckoutdate)
	values ('402', 'Signature Room', '300000', '빈방', '', '');
insert into roomTBL (roomno, roomtype, amount, roomstatus, roomcheckindate, roomcheckoutdate)
	values ('403', 'Signature Room', '300000', '빈방', '', '');
	
insert into roomTBL (roomno, roomtype, amount, roomstatus, roomcheckindate, roomcheckoutdate)
	values ('501', 'Couple Room', '400000', '빈방', '', '');
insert into roomTBL (roomno, roomtype, amount, roomstatus, roomcheckindate, roomcheckoutdate)
	values ('502', 'Couple Room', '400000', '빈방', '', '');
insert into roomTBL (roomno, roomtype, amount, roomstatus, roomcheckindate, roomcheckoutdate)
	values ('503', 'Couple Room', '400000', '빈방', '', '');