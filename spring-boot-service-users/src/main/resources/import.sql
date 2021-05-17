INSERT INTO users (username, password, enabled, name, lastname, email) VALUES ('admin','$2a$10$w4naGkV2HH9UHBog98JXaepQXv.9OOrITl3kjSArMPSWDvO3sNz9S',1, 'Admin', '','admin@gmail.com');
INSERT INTO users (username, password, enabled, name, lastname, email) VALUES ('janedoe','$2a$10$w4naGkV2HH9UHBog98JXaepQXv.9OOrITl3kjSArMPSWDvO3sNz9S',1, 'Jane', 'Doe','jane.doe@gmail.com');
INSERT INTO users (username, password, enabled, name, lastname, email) VALUES ('jhonsmith','$2a$10$w4naGkV2HH9UHBog98JXaepQXv.9OOrITl3kjSArMPSWDvO3sNz9S',1, 'John', 'Smith','jhon.smith@gmail.com');

INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (name) VALUES ('ROLE_USER');

INSERT INTO users_to_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_to_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO users_to_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO users_to_roles (user_id, role_id) VALUES (3, 2);