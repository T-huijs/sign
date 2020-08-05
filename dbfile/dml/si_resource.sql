

#资源配置
INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000000','sign','签到系统', '','','','0','system',sysdate(),'system',sysdate());
#用户相关
INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000100','UserRest','用户相关rest', '','','000000','1','system',sysdate(),'system',sysdate());

INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000101','registerToPost','用户注册', '/user/register','','000100','1','system',sysdate(),'system',sysdate());

INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000102','loginToPost','账号密码登录', '/user/login','','000100','2','system',sysdate(),'system',sysdate());

INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000103','quitToPost','用户退出', '/user/quit','','000100','3','system',sysdate(),'system',sysdate());

#教师相关
INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000200','TeacherRest','教师相关', '','','000000','2','system',sysdate(),'system',sysdate());

INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000201','addTeacherToPost','录入教师详细信息', '/teacher/add','','000200','1','system',sysdate(),'system',sysdate());

INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000202','deleteTeacherToPost','删除教师信息', '/teacher/delete','','000200','2','system',sysdate(),'system',sysdate());

INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000203','updateTeacherToPost','修改教师信息', '/teacher/update','','000200','3','system',sysdate(),'system',sysdate());

INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000204','queryTeacherToPost','查询教师信息', '/teacher/query','','000200','4','system',sysdate(),'system',sysdate());

#学生相关
INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000300','StudentRest','学生相关', '','','000000','3','system',sysdate(),'system',sysdate());

INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000301','addStudentToPost','录入教师详细信息', '/student/add','','000300','1','system',sysdate(),'system',sysdate());

INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000302','deleteStudentToPost','删除学生信息', '/student/delete','','000300','2','system',sysdate(),'system',sysdate());

INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000303','updateStudentToPost','修改学生信息', '/student/update','','000300','3','system',sysdate(),'system',sysdate());

INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000304','queryStudentToPost','查询学生信息', '/student/query','','000300','4','system',sysdate(),'system',sysdate());

#班级相关
INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000004','ClassRest','班级相关', '','','000000','4','system',sysdate(),'system',sysdate());

INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000401','addClassToPost','添加班级信息', '/class/add','','000400','1','system',sysdate(),'system',sysdate());

INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000402','deleteClassToPost','删除班级信息', '/class/delete','','000400','2','system',sysdate(),'system',sysdate());

INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000403','updateClassToPost','修改班级信息', '/class/update','','000400','3','system',sysdate(),'system',sysdate());

INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000404','queryClassToPost','查询班级信息', '/class/query','','000400','4','system',sysdate(),'system',sysdate());

#课程相关
INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000500','CourseRest','课程相关', '','','000000','5','system',sysdate(),'system',sysdate());

INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000501','addCourseToPost','添加课程信息', '/course/add','','000500','1','system',sysdate(),'system',sysdate());

INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000502','deleteCourseToPost','删除课程信息', '/course/delete','','000500','2','system',sysdate(),'system',sysdate());

INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000503','updateCourseToPost','修改课程信息', '/course/update','','000500','3','system',sysdate(),'system',sysdate());

INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000504','queryCourseToPost','查询课程信息', '/course/query','','000500','4','system',sysdate(),'system',sysdate());

INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000505','bindCourseToPost','学生选修课程', '/course/bind_student','','000500','5','system',sysdate(),'system',sysdate());

INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000506','queryOwnCourseToPost','老师/学生查看自己名下课程', '/course/query_own','','000500','6','system',sysdate(),'system',sysdate());

#签到相关
INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000600','SignRest','签到相关功能', '','','000000','6','system',sysdate(),'system',sysdate());

INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000601','signWithStudentToPost','学生签到', '/sign/sign_student','','000600','1','system',sysdate(),'system',sysdate());

INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000602','querySignWithStudentToPost','学生-查看自己签到情况', '/sign/query_sign_student','','000600','2','system',sysdate(),'system',sysdate());

INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000603','querySignForTeacherToPost','老师-查看学生签到情况', '/sign/query_sign_teacher','','000600','3','system',sysdate(),'system',sysdate());

INSERT INTO si_resource (resource_id,resource_name,resource_desc,url,type,parent_id,sort,create_by,create_time,update_by,update_time)
VALUES ('000604','updateSignForTeacherToPost','老师-修改学生签到情况', '/sign/update_sign_teacher','','000600','4','system',sysdate(),'system',sysdate());
