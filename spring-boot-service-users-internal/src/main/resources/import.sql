INSERT INTO users (username, password, enabled, name, lastname, email) VALUES ('admin','12345',1, 'Admin', '','admin@gmail.com');
INSERT INTO users (username, password, enabled, name, lastname, email) VALUES ('janedoe','12345',1, 'Jane', 'Doe','jane.doe@gmail.com');
INSERT INTO users (username, password, enabled, name, lastname, email) VALUES ('jhonsmith','12345',1, 'John', 'Smith','jhon.smith@gmail.com');

INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (name) VALUES ('ROLE_USER');

INSERT INTO users_to_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_to_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO users_to_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO users_to_roles (user_id, role_id) VALUES (3, 2);