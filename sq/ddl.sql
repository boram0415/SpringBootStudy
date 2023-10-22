
// 깃 코드 관리를 통해 sql문을 별도로 관리하면 사후 관리 및 유지보수가 편이함
create table member
(
    id bigint generated by default as identity,
    name varchar(255),
    primary key (id)
);