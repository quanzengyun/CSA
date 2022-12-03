create database csa;

use csa;

# 题目一

create table cqupt_student
(
    studentid varchar(10),
    name      varchar(20),
    sex       varchar(2),
    age       integer,
    Fee       DECIMAL(10, 2),
    address   varchar(50),
    memo      varchar(300)
);

# 题目二
create table courseas
(
    Aa1 varchar(20),
    Aa2 Integer,
    Aa3 DECIMAL(10)
);
# 题目三
create table choosebb
(
    Bb1 varchar(30),
    Bb2 Integer,
    Bb3 DECIMAL(6)
);
# 题目四
alter table choosebb
    add Bb4 varchar(20) not null default '系统测试值';

# 题目5
alter table choosebb
    add Bb5 varchar(10) PRIMARY KEY;
#题目6
create view choosebb1(View_bb1, View_bb2, view_bb3) AS
SELECT Bb1, Bb4, Bb5
from choosebb;
#7
drop view choosebb1;
#8
create index Index_bb2 on choosebb (Bb2 ASC);
create index Index_bb4 on choosebb (Bb4 DESC);
#题目9
drop index Index_bb2 on choosebb;
#题目10
create table test
(
    Name    varchar(20),
    Age     Integer,
    Score   NUMERIC(10, 2), #总长为10位,小数为2位
    Address varchar(60)
);
#11
INSERT INTO test
values ('赵一', 20, 580.00, '重邮宿舍 12-3-5'),
       ('钱二', 19, 540.00, '南福苑 5-2-9'),
       ('孙三', 21, 555.50, '学生新区21-5-15'),
       ('李四', 22, 505.00, '重邮宿舍8-6-22'),
       ('周五', 20, 495.50, '学生新区23-4-8'),
       ('吴六', 19, 435.00, '南福苑2-5-12');

#12
create table test_temp
(
    Name    varchar(20),
    Age     Integer,
    Score   NUMERIC(10, 2), #总长为10位,小数为2位
    Address varchar(60)
);
#13
INSERT INTO test_temp
values ('郑七', 21, 490.50, '重邮宿舍 11-2-1'),
       ('张八', 20, 560.00, '南福苑 3-3-3'),
       ('王九', 10, 515.00, '学生新区 19-7-1');
#14
INSERT INTO test
select *
from test_temp;
#15
update test
set Score = Score + 5
where Age <= 20;
#16
update test
set Age = Age - 1
where Address like '南福苑%';
#17
delete
from test
where Age >= 21
  and Score >= 500;
#18
delete
from test
where Score <= 550
  and Address like '重邮宿舍%';
#19
create table student
(
    SN0     varchar(20),
    Name    varchar(10),
    Age     INTEGER,
    College varchar(30)
);
#20
create table course
(
    CourseID       varchar(15),
    CourseName     varchar(30),
    CourseBeforeID varchar(15)

);
#21
create table choose
(
    SN0      varchar(20),
    CourseID varchar(30),
    Score    DECIMAL(5, 2)
);
#22
insert into student
values ('S00001', '张三', 20, '计算机学院'),
       ('S00002', '李四', 19, '通信学院'),
       ('S00003', '王五', 21, '计算机学院');
#23
insert into course
values ('C1', '计算机引论', NULL),
       ('C2', 'C语言', 'C1'),
       ('C3', '数据结构', 'C2');
#24
INSERT INTO choose
VALUES ('S00001', 'C1', 95),
       ('S00001', 'C2', 80),
       ('S00001', 'C3', 84),
       ('S00002', 'C1', 80),
       ('S00002', 'C2', 85),
       ('S00003', 'C1', 78),
       ('S00003', 'C3', 70);
#25
SELECT SN0, Name
from student;
#26
select *
from student
where Age between 20 and 23;
#27
select count(*)
from student;
#28
select max(Score), min(Score), sum(Score), avg(Score)
from choose
where CourseID = 'C1';
#29
select CourseID, CourseName
from course
where CourseBeforeID is null;
#30
select choose.SN0, Name, CourseName, Score
from student,
     choose,
     course
where student.SN0 = choose.SN0
  and choose.CourseID = course.CourseID;
#31
select *
from student a
where exists(select 1 from student b where b.Name = '张三' and b.College = a.College);
#32
select s.SN0, Score
from student s
         right join choose c on s.SN0 = c.SN0
where Score <
      (select Score from student,choose where student.SN0 = choose.SN0 && student.Name = '张三' && CourseID = 'c1') #张三的C1成绩
          && CourseID = 'c1';
#33
SELECT SN0 from choose WHERE CourseID = 'C1' union ALL select SN0 from choose where  CourseID = 'C2';
#34
SELECT  SN0 from choose WHERE CourseID = 'C1' union DISTINCT select SN0 from choose where  CourseID = 'C2';