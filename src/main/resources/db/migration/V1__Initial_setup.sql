CREATE SEQUENCE user_id_sequence start with 1 increment by 1;
CREATE TABLE user_details
(
    id bigint not null default nextval('user_id_sequence'),
    first_name varchar(30) not null,
    last_name varchar (50),
    email varchar (50) not null,
    phone_number varchar(20) not null,
    password varchar not null,
    user_permission varchar(10) not null,
    created_at timestamp not null default NOW(),
    primary key (id)
);