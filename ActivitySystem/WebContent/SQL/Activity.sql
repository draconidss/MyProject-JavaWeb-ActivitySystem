drop database if exists activity;
create database activity;
use activity;


/*用户表*/
create table User(
uid varchar(10) primary key,
uname varchar(20) unique,
password varchar(20) not null,
sSuper int not null,
deletemark int DEFAULT 1

);
ALTER TABLE activity.User ADD UNIQUE (uname);

/*活动表*/
create table Activity(
aid varchar(10) primary key,
aname varchar(50) not null,
level enum("部门","院级","校级"),
place varchar(20) not null,
duration char(100) not null,
pname varchar(10) not null,
email varchar(20) not null,
inf text not null,
con varchar(3) not null,
deletemark int DEFAULT 1
);


/*审核人表*/
create table Examiner(
eid varchar(10) primary key,
ename varchar(10),
name varchar(10) ,
level enum("部门","院级","校级"),
phonenumber varchar(11) not null,
deletemark int DEFAULT 1
);

/*审核状态表*/
create table Con(
aid varchar(10),
aname varchar(50) unique,
pname varchar(10) not null,
name varchar(10) ,
primary key(aid),
level enum("部门","院级","校级"),
con varchar(3) not null,
nreason text,
deletemark int DEFAULT 1,
foreign key (aid) references Activity(aid) on delete restrict on update restrict
);


insert into User values("u01","自由","a1138312802","1","1");
insert into User values("u02","哲学家","a1138312802","1","1");
insert into User values("u03","香蕉君","a1138312802","1","1");

insert into User values("u04","Godzilla","a1138312802","2","1");
insert into User values("u05","kiki","a1138312802","2","1");
insert into User values("u06","神","a1138312802","2","1");
insert into User values("u07","佩恩","a1138312802","2","1");
insert into User values("u08","黑凤凰","a1138312802","2","1");
insert into User values("u09","爱你三千遍","a1138312802","2","1");
insert into User values("u10","GG","a1138312802","2","1");
insert into User values("u11","琦玉","a1138312802","2","1");

insert into User values("u12","希斯特利亚","a1138312802","3","1");
insert into User values("u13","艾伦","a1138312802","3","1");
insert into User values("u14","三笠","a1138312802","3","1");
insert into User values("u15","死兆星","a1138312802","3","1");

insert into Activity values("a01","计算机博士演讲","院级","教三207","2019-06-30 00:00:00～2019-11-05 00:00:00","喜羊羊","1138312802@qq.com","来自清华大学","已通过","1");
insert into Activity values("a02","17级外包1班班会","院级","综B901","2019-06-30 00:00:00～2019-11-05 00:00:00","美羊羊","1138312802@qq.com","来自清华大学","未通过","1");
insert into Activity values("a03","信息院学生会会议","部门","综B107","2019-06-30 00:00:00～2019-11-05 00:00:00","沸羊羊","1138312802@qq.com","来自清华大学","审核中","1");
insert into Activity values("a04","校级辩论赛决赛","校级","教四506","2019-06-30 00:00:00～2019-11-05 00:00:00","村长","1138312802@qq.com","来自清华大学","审核中","1");
insert into Activity values("a05","It科技文化节决赛","校级","教四407","2019-06-30 00:00:00～2019-11-05 00:00:00","懒羊羊","1138312802@qq.com","来自清华大学","审核中","1");
insert into Activity values("a06","17级外包2班班会","院级","综B901","2019-06-30 00:00:00～2019-11-05 00:00:00","灰太狼","1138312802@qq.com","来自清华大学","未通过","1");
insert into Activity values("a07","Lol全校联赛","校级","电竞社","2019-06-30 00:00:00～2019-11-05 00:00:00","蕉太狼","1138312802@qq.com","来自清华大学","审核中","1");
insert into Activity values("a08","三下乡调研论文大赛","校级","教四407","2019-06-30 00:00:00～2019-11-05 00:00:00","懒羊羊","1138312802@qq.com","来自清华大学","审核中","1");
insert into Activity values("a09","外包欢送会","院级","综B901","2019-06-30 00:00:00～2019-11-05 00:00:00","灰太狼","1138312802@qq.com","来自清华大学","未通过","1");


insert into Examiner values("e01","Godzilla","马云","院级","111111","1");
insert into Examiner values("e02","kiki","任正非","院级","222222","1");
insert into Examiner values("e03","神","马化腾","校级","333333","1");
insert into Examiner values("e04","佩恩","乔布斯","部门","444444","1");
insert into Examiner values("e05","黑凤凰","马云","校级","111111","1");
insert into Examiner values("e06","爱你三千遍","任正非","院级","222222","1");
insert into Examiner values("e07","GG","马化腾","校级","333333","1");
insert into Examiner values("e08","琦玉","乔布斯","部门","444444","1");


insert into Con values("a01","计算机博士演讲","喜羊羊","Godzilla","院级","已通过","","1");
insert into Con values("a02","17级外包1班班会","美羊羊","kiki","院级","未通过","场地已被预订，时间冲突","1");
insert into Con values("a03","信息院学生会会议","沸羊羊","佩恩","部门","审核中","","1");
insert into Con values("a04","校级辩论赛决赛","村长","神","校级","审核中","","1");
insert into Con values("a05","It科技文化节决赛","懒羊羊","神","校级","审核中","","1");
insert into Con values("a06","17级外包2班班会","灰太狼","Godzilla","院级","未通过","场地已被预订，时间冲突","1");
insert into Con values("a07","Lol全校联赛","蕉太狼","GG","校级","审核中","","1");
insert into Con values("a08","三下乡调研论文大赛","懒羊羊","黑凤凰","校级","审核中","","1");
insert into Con values("a09","外包欢送会","灰太狼","爱你三千遍","院级","未通过","场地已被预订，时间冲突","1");

drop trigger Activity_insert_Con;
drop trigger Activity_update_Con;
drop trigger Con_update_Activity;
drop trigger Examiner_update_Condition;




DELIMITER$
create trigger Activity_insert_Con After insert on Activity for each row
begin
insert into Con values(New.aid,New.aname,New.pname,"",New.level,"待审核","","1");
end$
DELIMITER;



DELIMITER$
create trigger Activity_update_Con After update on Activity for each row
begin
	if New.level != Old.level then
		update Con set level = New.level,name="",con="待审核",nreason="" where aid = New.aid;
	end if;
	if New.aname != Old.aname or New.deletemark != Old.deletemark or New.pname != Old.pname then
		update Con set aname = New.aname,pname = New.pname, deletemark = New.deletemark where aid = New.aid;
	end if;
end$
DELIMITER;

/*审核情况表更新引起活动表审核情况更新*/

DELIMITER$
create trigger Con_update_Activity After update on Con for each row
begin
	if New.con != Old.con then
		update Activity set con = New.con where aid = New.aid;
	end if;
end$
DELIMITER;

/*审核人表更新后，重置审核表关于审核人的信息*/



DELIMITER$
create trigger Examiner_update_Condition After update on Examiner for each row
begin
	if New.level!=Old.level or New.deletemark!=Old.deletemark then
		update Con set name=" ",con ="待审核" where name=Old.ename and con!="已通过" and con!="未通过";
			update Con set name=" " where name=Old.ename and (con="已通过" or con="未通过");
	end if;
	if New.ename!=old.ename then
		update Con set name=New.ename where name=old.ename ;
	end if;
end$
DELIMITER;

