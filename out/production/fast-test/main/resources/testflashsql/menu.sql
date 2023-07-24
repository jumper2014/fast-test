/*
-- Query: SELECT * FROM webflash.t_sys_menu
LIMIT 0, 1000

-- Date: 2022-01-12 11:17
*/
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (1,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','system','layout',0,'system',1,1,1,'系统管理',1,'0','[0],',NULL,'/system');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (2,1,'2019-07-31 22:04:30',1,'2019-03-11 22:25:38','cms','layout',0,'documentation',1,NULL,1,'CMS管理',3,'0','[0],',NULL,'/cms');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (3,1,'2019-07-31 22:04:30',1,'2020-07-25 18:12:57','operationMgr','layout',0,'operation',1,NULL,1,'运维管理',2,'0','[0],',NULL,'/optionMgr');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (4,1,'2019-07-31 22:04:30',1,'2019-04-16 18:59:15','mgr','views/system/user/index',0,'user',1,NULL,2,'用户管理',1,'system','[0],[system],',NULL,'/mgr');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (5,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','mgrAdd',NULL,0,NULL,0,NULL,3,'添加用户',1,'mgr','[0],[system],[mgr],',NULL,'/mgr/add');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (6,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','mgrEdit',NULL,0,NULL,0,NULL,3,'修改用户',2,'mgr','[0],[system],[mgr],',NULL,'/mgr/edit');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (7,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','mgrDelete',NULL,0,NULL,0,0,3,'删除用户',3,'mgr','[0],[system],[mgr],',NULL,'/mgr/delete');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (8,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','mgrReset',NULL,0,NULL,0,0,3,'重置密码',4,'mgr','[0],[system],[mgr],',NULL,'/mgr/reset');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (9,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','setRole',NULL,0,NULL,0,0,3,'分配角色',5,'mgr','[0],[system],[mgr],',NULL,'/mgr/setRole');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (10,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','mgrUnfreeze',NULL,0,NULL,0,0,3,'解除冻结用户',6,'mgr','[0],[system],[mgr],',NULL,'/mgr/unfreeze');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (11,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','mgrSetRole',NULL,0,NULL,0,0,3,'分配角色',7,'mgr','[0],[system],[mgr],',NULL,'/mgr/setRole');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (12,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','role','views/system/role/index',0,'peoples',1,0,2,'角色管理',2,'system','[0],[system],',NULL,'/role');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (13,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','roleAdd',NULL,0,NULL,0,0,3,'添加角色',1,'role','[0],[system],[role],',NULL,'/role/add');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (14,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','roleEdit',NULL,0,NULL,0,0,3,'修改角色',2,'role','[0],[system],[role],',NULL,'/role/edit');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (15,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','roleDelete',NULL,0,NULL,0,0,3,'删除角色',3,'role','[0],[system],[role],',NULL,'/role/remove');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (16,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','roleSetAuthority',NULL,0,NULL,0,0,3,'配置权限',4,'role','[0],[system],[role],',NULL,'/role/setAuthority');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (17,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','menu','views/system/menu/index',0,'menu',1,0,2,'菜单管理',4,'system','[0],[system],',NULL,'/menu');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (18,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','menuAdd',NULL,0,NULL,0,0,3,'添加菜单',1,'menu','[0],[system],[menu],',NULL,'/menu/add');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (19,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','menuEdit',NULL,0,NULL,0,0,3,'修改菜单',2,'menu','[0],[system],[menu],',NULL,'/menu/edit');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (20,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','menuDelete',NULL,0,NULL,0,0,3,'删除菜单',3,'menu','[0],[system],[menu],',NULL,'/menu/remove');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (21,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','dept','views/system/dept/index',0,'dept',1,NULL,2,'部门管理',3,'system','[0],[system],',NULL,'/dept');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (22,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','dict','views/system/dict/index',0,'dict',1,NULL,2,'字典管理',4,'system','[0],[system],',NULL,'/dict');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (23,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','deptEdit',NULL,0,NULL,0,NULL,3,'修改部门',1,'dept','[0],[system],[dept],',NULL,'/dept/update');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (24,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','deptDelete',NULL,0,NULL,0,NULL,3,'删除部门',1,'dept','[0],[system],[dept],',NULL,'/dept/delete');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (25,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','dictAdd',NULL,0,NULL,0,NULL,3,'添加字典',1,'dict','[0],[system],[dict],',NULL,'/dict/add');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (26,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','dictEdit',NULL,0,NULL,0,NULL,3,'修改字典',1,'dict','[0],[system],[dict],',NULL,'/dict/update');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (27,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','dictDelete',NULL,0,NULL,0,NULL,3,'删除字典',1,'dict','[0],[system],[dict],',NULL,'/dict/delete');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (28,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','deptList',NULL,0,NULL,0,NULL,3,'部门列表',5,'dept','[0],[system],[dept],',NULL,'/dept/list');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (29,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','deptDetail',NULL,0,NULL,0,NULL,3,'部门详情',6,'dept','[0],[system],[dept],',NULL,'/dept/detail');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (30,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','dictList',NULL,0,NULL,0,NULL,3,'字典列表',5,'dict','[0],[system],[dict],',NULL,'/dict/list');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (31,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','dictDetail',NULL,0,NULL,0,NULL,3,'字典详情',6,'dict','[0],[system],[dict],',NULL,'/dict/detail');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (32,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','deptAdd',NULL,0,NULL,0,NULL,3,'添加部门',1,'dept','[0],[system],[dept],',NULL,'/dept/add');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (33,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','cfg','views/system/cfg/index',0,'cfg',1,NULL,2,'参数管理',10,'system','[0],[system],',NULL,'/cfg');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (34,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','cfgAdd',NULL,0,NULL,0,NULL,3,'添加参数',1,'cfg','[0],[system],[cfg],',NULL,'/cfg/add');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (35,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','cfgEdit',NULL,0,NULL,0,NULL,3,'修改参数',2,'cfg','[0],[system],[cfg],',NULL,'/cfg/update');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (36,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','cfgDelete',NULL,0,NULL,0,NULL,3,'删除参数',3,'cfg','[0],[system],[cfg],',NULL,'/cfg/delete');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (37,1,'2019-07-31 22:04:30',1,'2020-07-25 18:08:05','task','views/system/task/index',0,'task',1,NULL,2,'任务管理',11,'system','[0],[system],',NULL,'/task');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (38,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','taskAdd',NULL,0,NULL,0,NULL,3,'添加任务',1,'task','[0],[system],[task],',NULL,'/task/add');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (39,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','taskEdit',NULL,0,NULL,0,NULL,3,'修改任务',2,'task','[0],[system],[task],',NULL,'/task/update');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (40,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','taskDelete',NULL,0,NULL,0,NULL,3,'删除任务',3,'task','[0],[system],[task],',NULL,'/task/delete');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (41,1,'2019-03-11 22:29:54',1,'2019-03-11 22:29:54','channel','views/cms/channel/index',0,'channel',1,NULL,2,'栏目管理',1,'cms','[0],[cms],',NULL,'/channel');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (42,1,'2019-03-11 22:30:17',1,'2019-03-11 22:30:17','article','views/cms/article/index',0,'documentation',1,NULL,2,'文章管理',2,'cms','[0],[cms],',NULL,'/article');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (43,1,'2019-03-11 22:30:52',1,'2019-03-11 22:30:52','banner','views/cms/banner/index',0,'banner',1,NULL,2,'banner管理',3,'cms','[0],[cms],',NULL,'/banner');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (44,1,'2019-03-18 19:45:37',1,'2019-03-18 19:45:37','contacts','views/cms/contacts/index',0,'contacts',1,NULL,2,'邀约管理',4,'cms','[0],[cms],',NULL,'/contacts');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (45,1,'2019-03-19 10:25:05',1,'2019-03-19 10:25:05','file','views/cms/file/index',0,'file',1,NULL,2,'文件管理',5,'cms','[0],[cms],',NULL,'/fileMgr');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (46,1,'2019-03-11 22:30:17',1,'2019-03-11 22:30:17','editArticle','views/cms/article/edit.vue',0,'articleEdit',1,NULL,2,'新建文章',1,'cms','[0],[cms],',NULL,'/cms/articleEdit');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (47,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','taskLog','views/system/task/taskLog',1,'task',1,NULL,2,'任务日志',4,'system','[0],[system],',NULL,'/taskLog');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (48,1,'2019-07-31 22:04:30',1,'2019-06-02 10:25:31','log','views/operation/log/index',0,'log',1,NULL,2,'业务日志',6,'operationMgr','[0],[operationMgr],',NULL,'/log');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (49,1,'2019-07-31 22:04:30',1,'2019-06-02 10:25:36','loginLog','views/operation/loginLog/index',0,'logininfor',1,NULL,2,'登录日志',6,'operationMgr','[0],[operationMgr],',NULL,'/loginLog');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (50,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','logClear',NULL,0,NULL,0,NULL,3,'清空日志',3,'log','[0],[system],[log],',NULL,'/log/delLog');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (51,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','logDetail',NULL,0,NULL,0,NULL,3,'日志详情',3,'log','[0],[system],[log],',NULL,'/log/detail');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (52,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','loginLogClear',NULL,0,NULL,0,NULL,3,'清空登录日志',1,'loginLog','[0],[system],[loginLog],',NULL,'/loginLog/delLoginLog');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (53,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','loginLogList',NULL,0,NULL,0,NULL,3,'登录日志列表',2,'loginLog','[0],[system],[loginLog],',NULL,'/loginLog/list');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (54,1,'2019-06-02 10:10:20',1,'2019-06-02 10:10:20','druid','views/operation/druid/index',0,'monitor',1,NULL,2,'数据库管理',1,'operationMgr','[0],[operationMgr],',NULL,'/druid');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (55,1,'2019-06-02 10:10:20',1,'2019-06-02 10:10:20','swagger','views/operation/api/index',0,'swagger',1,NULL,2,'接口文档',2,'operationMgr','[0],[operationMgr],',NULL,'/swagger');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (56,1,'2019-06-10 21:26:52',1,'2019-06-10 21:26:52','messageMgr','layout',0,'message',1,NULL,1,'消息管理',4,'0','[0],',NULL,'/message');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (57,1,'2019-06-10 21:27:34',1,'2019-06-10 21:27:34','msg','views/message/message/index',0,'message',1,NULL,2,'历史消息',1,'messageMgr','[0],[messageMgr],',NULL,'/history');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (58,1,'2019-06-10 21:27:56',1,'2019-06-10 21:27:56','msgTpl','views/message/template/index',0,'template',1,NULL,2,'消息模板',2,'messageMgr','[0],[messageMgr],',NULL,'/template');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (59,1,'2019-06-10 21:28:21',1,'2019-06-10 21:28:21','msgSender','views/message/sender/index',0,'sender',1,NULL,2,'消息发送者',3,'messageMgr','[0],[messageMgr],',NULL,'/sender');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (60,1,'2019-06-10 21:28:21',1,'2019-06-10 21:28:21','msgClear',NULL,0,NULL,1,NULL,2,'清空历史消息',3,'messageMgr','[0],[messageMgr],',NULL,'/message/clear');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (61,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','msgTplEdit',NULL,0,NULL,0,NULL,3,'编辑模板',1,'msgTpl','[0],[messageMgr],[msgTpl]',NULL,'/template/edit');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (62,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','msgTplDelete',NULL,0,NULL,0,NULL,3,'删除模板',2,'msgTpl','[0],[messageMgr],[msgTpl]',NULL,'/template/remove');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (63,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','msgSenderEdit',NULL,0,NULL,0,NULL,3,'编辑发送器',1,'msgSender','[0],[messageMgr],[msgSender]',NULL,'/sender/edit');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (64,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','msgSenderDelete',NULL,0,NULL,0,NULL,3,'删除发送器',2,'msgSender','[0],[messageMgr],[msgSender]',NULL,'/sender/remove');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (65,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','fileUpload',NULL,0,NULL,0,NULL,3,'上传文件',1,'file','[0],[cms],[file],',NULL,'/file/upload');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (66,1,'2019-07-31 21:51:33',1,'2019-07-31 21:51:33','bannerEdit',NULL,0,NULL,0,NULL,3,'编辑banner',1,'banner','[0],[cms],[banner],',NULL,'/banner/edit');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (67,1,'2019-07-31 21:51:33',1,'2019-07-31 21:51:33','bannerDelete',NULL,0,NULL,0,NULL,3,'删除banner',2,'banner','[0],[cms],[banner],',NULL,'/banner/remove');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (68,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','channelEdit',NULL,0,NULL,0,NULL,3,'编辑栏目',1,'channel','[0],[cms],[channel],',NULL,'/channel/edit');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (69,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','channelDelete',NULL,0,NULL,0,NULL,3,'删除栏目',2,'channel','[0],[cms],[channel],',NULL,'/channel/remove');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (70,1,'2019-07-31 22:04:30',1,'2019-07-31 22:04:30','deleteArticle',NULL,0,NULL,0,NULL,3,'删除文章',2,'article','[0],[cms],[article]',NULL,'/article/remove');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (71,1,'2020-12-24 22:16:41',1,'2020-12-24 22:18:50','documentp','layout',0,'documentation',1,NULL,1,'在线文档',6,'0','[0],',NULL,'/documentdp');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (72,1,'2020-12-24 22:18:32',1,'2020-12-24 22:26:39','document','views/document/index',0,'documentation',1,NULL,2,'在线文档',1,'documentp','[0],[documentp],',NULL,'/document');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (73,1,'2021-07-21 19:46:59',NULL,NULL,'workFlow','layout',0,'workflow',1,NULL,1,'工作流',5,'0','[0],',NULL,'/workflow');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (74,1,'2021-07-21 19:46:59',NULL,NULL,'processDefinition','views/workflow/processDefinition/index',0,'processDefine',1,NULL,2,'流程定义',1,'workFlow','[0],[workFlow],',NULL,'/workflow/processDefinition');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (75,1,'2021-07-21 19:46:59',NULL,NULL,'workFlowRequest','views/workflow/workFlowRequest/index',0,'skill',1,NULL,2,'流程列表',2,'workFlow','[0],[workFlow],',NULL,'/workflow/request');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (76,1,'2021-07-21 19:46:59',NULL,NULL,'processDefinitionEdit',NULL,0,NULL,0,NULL,1,'编辑流程',3,'processDefinition','[0],[workFlow],[processDefinition],',NULL,'/workflow/process/definition/edit');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (77,1,'2021-07-24 21:53:56',NULL,NULL,'workFlowRequestAdd',NULL,0,NULL,0,NULL,3,'发起流程',1,'workFlowRequest','[0],[workFlow],[workFlowRequest],',NULL,'/workflow/request/add');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (78,1,'2021-07-24 21:53:56',NULL,NULL,'workFlowTask','views/workflow/task/index',0,'workFlowTask',1,NULL,2,'代办任务',3,'workFlow','[0],[workFlow],',NULL,'/workflow/request/task');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (81,1,'2021-12-30 17:11:58',1,'2021-12-30 17:11:58','tool','layout',0,'tool',1,NULL,1,'测试工具',1,'0','[0],',NULL,'/tool');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (82,1,'2021-12-30 17:15:15',1,'2021-12-30 17:54:47','createfile','views/tool/createfile/index',0,'tab',1,NULL,2,'生成文件',1,'tool','[0],[tool],',NULL,'/createfile');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (83,1,'2021-12-30 17:17:27',1,'2022-01-06 14:15:53','curd','views/tool/crud/index',0,'articleEdit',1,NULL,2,'增删改查',2,'tool','[0],[tool],',NULL,'/curd');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (84,1,'2021-12-30 17:19:04',1,'2021-12-30 17:55:56','uploadfile','views/tool/uploadfile/index',0,'file',1,NULL,2,'上传文件',3,'tool','[0],[tool],',NULL,'/uploadfile');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (85,1,'2021-12-31 14:24:11',1,'2022-01-12 10:34:56','jsondiff','views/tool/jsondiff/index',0,'code',1,NULL,2,'JSON对比',4,'tool','[0],[tool],',NULL,'/jsondiff');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (86,1,'2022-01-05 15:35:37',1,'2022-01-05 15:35:51','downloadfile','views/tool/downloadfile/index',0,'download',1,NULL,2,'下载文件',3,'tool','[0],[tool],',NULL,'/downloadfile');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (87,1,'2022-01-06 14:15:35',1,'2022-01-06 14:17:53','dbop','views/tool/dbop/index',0,'table',1,NULL,2,'DB操作',2,'tool','[0],[tool],',NULL,'/dbop');
INSERT INTO `` (`id`,`create_by`,`create_time`,`modify_by`,`modify_time`,`code`,`component`,`hidden`,`icon`,`ismenu`,`isopen`,`levels`,`name`,`num`,`pcode`,`pcodes`,`tips`,`url`) VALUES (88,1,'2022-01-12 10:34:39',1,'2022-01-12 11:16:04','link','views/tool/link/index',0,'link',1,NULL,2,'常用链接',10,'tool','[0],[tool],',NULL,'/link');
