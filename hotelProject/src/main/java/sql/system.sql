create tablespace hotel datafile 'd:\hotel.dbf' size 20m autoextend on next 5m maxsize 50m;

select username from dba_users;

select * from all_users; -- 접속중인 계정 확인

SELECT * FROM DBA_USERS; -- 접속중인 계정 확인

SELECT * FROM V$SQLAREA; -- SQL 실행 기록 조회

-- 우혁님계정

create user woo identified by woo;

grant dba, resource to woo;

alter user woo default tablespace hotel;

alter user woo temporary tablespace temp;

-- 태희님계정

create user tae identified by hee;

grant dba, resource to tae;

alter user tae default tablespace hotel;

alter user tae temporary tablespace temp;


-- 내꺼

create user hyun identified by hyun;

grant dba, resource to hyun;

alter user hyun default tablespace hotel;

alter user hyun temporary tablespace temp;