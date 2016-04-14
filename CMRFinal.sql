drop database CMR
go
create database CMR
go
use CMR

select * from cmr
select *
create table AccountRole(
	arId int identity(1,1) primary key,
	arName nvarchar(100),
)
go
insert into AccountRole values('Provice Chanceler')
insert into AccountRole values('Director Of Learning Quality')
insert into AccountRole values('Course Leader')
insert into AccountRole values('Course Moderator')
insert into AccountRole values('Admin')
go
select * from AccountRole
go

create table Account(
	aId int identity(1,1) primary key,
	arId int foreign key references AccountRole(arId),
	aFirstName nvarchar(100),
	aLastName nvarchar(100),
	aUsername nvarchar(100),
	aPassword nvarchar(100),
	aEmail nvarchar(100),
	aAddress nvarchar(100)
)
go
insert into Account values(1,'Khoa','Bui','DangKhoa','password','buiKhoa@gmail.com','Xa la street,Hanoi')
insert into Account values(2,'Thanh','Nguyen','TrungThanh','password','trungThanh@gmail.com','Cau giay street,Hanoi')
insert into Account values(3,'An','Nguyen','TrongAn','password','anntgc00492@gmail.com','Tam trinh street,Hanoi')
insert into Account values(4,'Dung','Nguyen','Dung','password','dung@gmail.com','Tam trinh street,Hanoi')
insert into Account values(1,'Khoa2','Bui','DangKhoa2','password','buiKhoa@gmail.com','Xa la street,Hanoi')
insert into Account values(2,'Thanh2','Nguyen','TrungThanh2','password','trungThanh@gmail.com','Cau giay street,Hanoi')
insert into Account values(3,'An2','Nguyen','TrongAn2','password','trongan@gmail.com','Tam trinh street,Hanoi')
insert into Account values(4,'Dung2','Nguyen','Dung2','password','dung@gmail.com','Tam trinh street,Hanoi')
insert into Account values(5,'admin','admin','admin','password','admin@gmail.com','admin')
insert into Account values(1,'Khoa hell','Bui','DangKhoa1','password','buiKhoa@gmail.com','Xa la street,Hanoi')
insert into Account values(2,'Thanh2','Nguyen','TrungThanh1','password','trungThanh@gmail.com','Cau giay street,Hanoi')
select * from Account
go

create table Faculty(
	fId int identity(1,1) primary key,
	fName nvarchar(100),
	aIdDLT int foreign key references Account(aId),
	aIdPVC int foreign key references Account(aId),
)
go
insert into Faculty values('Software engineering',2,1)
insert into Faculty values('Computer science',6,5)
select * from Faculty
go

create table Course(
	cId int identity(1,1) primary key,
	fId int foreign key references Faculty(fId),
	cCode nvarchar(50) unique,
	cName nvarchar(50),
	cDescription nvarchar(200),
	cPostOn date default GetDate(),
	cStart int,
	cEnd int
)
go
insert into Course values(1,'db1','Datebase engineering 1','Course about designing database on basic level',default,2015,2016);
insert into Course values(1,'db2','Datebase engineering 2','Course about designing database on advanced level',default,2015,2015);
insert into Course values(1,'pf1','Programming framework 1','Course about framework development 1',default,2014,2015);
insert into Course values(1,'pf2','Programming framework 2','Course about framework development 2',default,2013,2020);
insert into Course values(2,'ca`','Computer architecture 1','Computer architecture',default,2013,2020);
go 
select * from Course
go

create table CourseAssigned(
	caId int identity(1,1) primary key,
	cId int foreign key references Course(cId),
	aIdCL int foreign key references Account(aId),
	aIdCM int foreign key references Account(aId),
	caAcademicYear nvarchar(100),	
)
go
insert into CourseAssigned values(1,3,4,'')
insert into CourseAssigned values(2,3,4,'')
insert into CourseAssigned values(3,7,8,'')
insert into CourseAssigned values(4,7,4,'')
insert into CourseAssigned values(5,3,8,'')
select * from CourseAssigned
go
select cId from CourseAssigned where aIdCL=3
go


create table CMR(
	id int identity(1,1) primary key,
	cid int foreign key references Course(cId),
	studentCount int,
	meancw1 float,
	meancw2 float,
	meanexam float,
	mediancw1 float,
	mediancw2 float,
	medianexam float,
	distributioncw1type1 int,
	distributioncw2type1 int,
	distributionexamtype1 int,
	distributionexamtype2 int,
	status nvarchar(50),
	comment nvarchar(225),
	createDate date default GetDate(),
)
insert into  CMR values(1,50,80,90,70,80,90,70,80,90,50,50,'processing','not yet',default)
select * from CMR
insert into  CMR values(4,50,80,90,70,80,90,70,80,90,50,50,'done','not yet','2016-03-01')
go
select * from CMR
go