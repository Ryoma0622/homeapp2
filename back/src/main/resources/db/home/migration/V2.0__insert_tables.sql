INSERT INTO user(user_id, password, name)
VALUES ('Noritan1007', '$2a$10$//BXeh2Bn3xKxadqMWY12ewOBaSfHOmBpEat7PnKgDTyf/1Sm.yj6'/*noritan0622*/, 'のりたん'),
       ('Ryomatan1007', '$2a$10$1Nu3FfJAI.REznPel./ydeFKhz6L8YdEB2kZZI1B4v6oFqXenOM.W'/*ryomatan0103*/, 'りょまたん');

INSERT INTO user_role(user_id, role_id) VALUES ('Noritan1007', 0), ('Ryomatan1007', 1);

INSERT INTO role(id, name) VALUES (0, 'ROLE_ADMIN'), (1, 'ROLE_USER');