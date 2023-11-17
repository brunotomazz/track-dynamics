-- criação de usuários
insert into users (id, name, last_name, password, email) values (1, 'Leonardo', 'Costa', '123456', 'leonardo@gmail.com');
insert into users (id, name, last_name, password, email) values (2, 'Bruno', 'Tomaz', '123456', 'bruno@gmail.com');
insert into users (id, name, last_name, password, email) values (3, 'Felipe', 'Neves', '123456', 'felipe@gmail.com');
insert into users values (4, 'Agnaldo', 'Timóteo', '123456', 'agnaldo@gmail.com');

-- criação de tarefas
insert into tasks (title, description, deadline, date_creation, id_user, id, priority, overdue) values ('Estudar','Estudar comandos SQL', '2022-06-03','2022-05-31 10:24:00', 1, 1, 'high', 'false');
insert into tasks (title, description, deadline, date_creation, id_user, id, priority, overdue) values ('Correr','', '2022-06-03','2022-05-31 10:31:00', 1, 2, 'medium', 'false');
insert into tasks (title, description, deadline, date_creation, id_user, id, priority, overdue) values ('Pedalar','', '2022-06-03','2022-05-31 10:36:00', 2, 3, 'low', 'false');
