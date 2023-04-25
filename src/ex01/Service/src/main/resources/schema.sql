create table if not exists users (
    id serial primary key,
    email varchar not null
);

insert into users values ( default, 'firstUser@email.com'),
       (default,'secondUser@email.com'),
       (default,'thirdUser@email.com'),
       (default,'fourUser@email.com'),
       (default,'moooreUser@email.eu');
