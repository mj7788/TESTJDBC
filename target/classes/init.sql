create table t_cluster_info(
 id integer identity(1,1) primary key,
 name varchar(24) not null,
 "comment" varchar(64),
 status tinyint not null comment '0为开启监控，1为关闭监控'
);
create table t_connect_node(
 id integer identity(1,1) primary key,
 ip varchar(15) not null,
 port integer not null,
 cluster_id integer not null
);
create table t_ignore_node(
 id integerd identity(1,1) primary key,
 node_id integer not null,
 cluster_id integer not null
);
create uinique index cluster_node_index1 on cluster_node(ip,cluster_id);
create table t_user(
 id varchar(32) primary key,
 account varchar(32) not null,
 passwd varchar(32) not null defalut '123456',
 status boolean default true,
 create_time datetime not null,
 update_time datetime not null
);
create table t_role(
 id varchar(32) primary key,
 role_name varchar(12) not null
);
create table t_sessions(
 node_id short,
 session_id integer,
 login_ip char(15),
 login_user char(128),
 db_name char(128),
 start_t datetime,
 visit_t datetime,
 status integer,
 curr_tid bigint,
 curr_cid integer,
 auto_commit boolean,
 trans_start_t datetime,
 cmd_start_t datetime,
 cursor_num integer,
 sql char(-1),
 cluster_id integer not null
);
create table t_warning_rules(
 id integer identity(1,1) primary key,
 type varchar()
);
create table t_warning(
 id integer identity(1,1) primary key,
 node_id integer not null,
 warn_type varchar(24) not null,
 detail varchar not null,
 key_word varchar(20) not null comment '归并警告',
 resolved tinyint not null default false comment '0为已解决，1为未解决',
 resolved_type tinyint not null '0为自动恢复，1为手动恢复'，
 suggestion varchar not null,
 create_time datetime not null,
 update_time datetime not null,
 cluster_id integer not null
);
