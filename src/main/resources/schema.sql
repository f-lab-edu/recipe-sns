drop table if exists FOOD CASCADE;
drop table if exists MEMBER CASCADE;
drop table if exists POST CASCADE;
drop table if exists POST_LIKE CASCADE;

create table FOOD (
    id bigint auto_increment primary key,
    food_name varchar(255) not null,
    food_code varchar(255) not null,
    food_size int not null,
    carbohydrate double not null,
    protein double not null,
    fat double not null,
    calorie double not null,
    created_at timestamp not null,
    updated_at timestamp
);

create table MEMBER (
    id bigint auto_increment primary key,
    username varchar(255) not null,
    password varchar(255) not null,
    nickname varchar(255) not null,
    created_at timestamp not null,
    updated_at timestamp,
    withdrawal_at timestamp
);

create table POST (
    id bigint auto_increment primary key,
    member_id bigint not null,
    like_count bigint not null,
    content varchar(255) not null,
    images json not null,
    created_at timestamp not null,
    updated_at timestamp,
    foreign key (member_id) references MEMBER(id)
);

create table POST_FOOD (
    id bigint auto_increment primary key,
    post_id bigint not null,
    food_id bigint not null,
    created_at timestamp not null,
    foreign key (post_id) references POST(id),
    foreign key (food_id) references FOOD(id)
);

create table POST_LIKE (
    id bigint auto_increment primary key,
    member_id bigint not null,
    post_id bigint not null,
    created_at timestamp not null,
    foreign key (member_id) references MEMBER(id),
    foreign key (post_id) references POST(id)
);