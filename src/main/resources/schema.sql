drop table if exists FOOD CASCADE;
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