create table reservation(
	rno			varchar2(30) not null,
	id			varchar2(30) not null,
	name		varchar2(30) not null,
	num			varchar2(30) not null,
	people		varchar2(30) not null,
	checkIn		varchar2(30) not null,
	checkOut	varchar2(30) not null,
	roomType	varchar2(30) not null,
	amount		varchar2(30) not null,
	regidate	date default sysdate not null
)

insert into RESERVATION (rno, id, name, num, people, checkIn, checkOut, roomType, amount, regidate)
	values('50308FnbAsOvVqt','kth', '김태희', '01012345678', '4', '20240815', '20240817', 'Laxaries Rooms','100000', sysdate);
insert into RESERVATION (rno, id, name, num, people, checkIn, checkOut, roomType, amount, regidate)
	values('58907fvabSktIZA','lhu', '이현우', '01023456789', '2', '20240814', '20240816', 'Deluxe Room', '100000', sysdate);
insert into RESERVATION (rno, id, name, num, people, checkIn, checkOut, roomType, amount, regidate)
	values('15224PtXpfgQBTT','kwh', '김우혁', '01034567890', '2', '20240816', '20240818', 'Signature Room', '100000', sysdate);

	 68085gauoqruSsz ㅁㄴㅇㅁㄴㅇ ㅈㅂㄷㅂㅈㄷ 4564        3      08/20/2024 08/22/2024 Laxaries Rooms 100000 2024-08-07 13:25:49.0

select * from reservation;
drop table reservation;

select * from reservation where id ='kth' or num = '01012345678';