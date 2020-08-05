

#角色配置
#系统管理员
INSERT INTO si_role (role_id,role_name,role_desc,create_by,create_date,update_by,update_date)
VALUES ('001', '系统管理员', '系统管理员', 'system', sysdate(), 'system', sysdate());

#教师
INSERT INTO si_role (role_id,role_name,role_desc,create_by,create_date,update_by,update_date)
VALUES ('002', '教师', '教师', 'system', sysdate(), 'system', sysdate());

#学生
INSERT INTO si_role (role_id,role_name,role_desc,create_by,create_date,update_by,update_date)
VALUES ('003', '学生', '学生', 'system', sysdate(), 'system', sysdate());