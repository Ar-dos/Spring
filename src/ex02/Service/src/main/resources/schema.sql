create table if not exists users (
    id serial primary key,
    email varchar not null,
    password varchar
);

insert into users values ( default, 'firstUser@email.com', 'firstpass');