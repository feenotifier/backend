CREATE SEQUENCE user_id_sequence start with 1 increment by 1;
CREATE TABLE user_details
(
    id bigint not null default nextval('user_id_sequence'),
    user_id UUID NOT NULL UNIQUE,
    first_name varchar(30) not null,
    last_name varchar (50),
    email varchar (50) not null UNIQUE,
    phone_number varchar(20) not null,
    password varchar(50) not null,
    user_permission varchar(10) not null,
    created_at timestamp not null default NOW(),
    is_active boolean,
    primary key (id)
);