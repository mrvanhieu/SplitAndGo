INSERT INTO credential(username,password,enabled) VALUES ('guest','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE);
INSERT INTO credential(username,password,enabled) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);
 
INSERT INTO authority (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_USER');

INSERT INTO `MEMBER` (firstname, lastname, nickname, email, gender, credential_id) VALUES ('Tuyen', 'Lam', 'Tien' ,'tuyenrg@gmail.com', 0 ,'admin');
INSERT INTO `MEMBER` (firstname, lastname, nickname, email, gender, credential_id) VALUES ('Guest', 'Guest', 'Guest' ,'guest@gmail.com', 0, 'guest');

INSERT INTO Trip (`id`, `description`, `duration`, `endDate`, `name`, `startDate`) VALUES ('1', 'First Trip', '30', '2017-10-10', 'First Trip', '2017-09-09');
INSERT INTO Trip (`id`, `description`, `duration`, `endDate`, `name`, `startDate`) VALUES ('2', 'Second Trip', '30', '2017-07-07', 'Second Trip', '2017-08-08');
INSERT INTO Fund (totalAmount, remainingAmount, trip_id) VALUES (200, 200, 1);

INSERT INTO Payment (`id`, `amount`, `date`, `description`, trip_id) VALUES ('2', '100', '2017-10-10', 'Second payment', '1');
INSERT INTO Payment (`id`, `amount`, `date`, `description`, trip_id) VALUES ('1', '200', '2017-10-10', 'First payment', '1')
INSERT INTO Payment (`id`, `amount`, `date`, `description`, trip_id) VALUES ('3', '100', '2017-09-09', 'Third payment', '1');
INSERT INTO Payment (`id`, `amount`, `date`, `description`, trip_id) VALUES ('4', '200', '2017-09-09', 'Fourth payment', '1')

INSERT INTO Payment (`id`, `amount`, `date`, `description`, trip_id) VALUES ('5', '100', '2017-07-07', 'Second payment', '2');
INSERT INTO Payment (`id`, `amount`, `date`, `description`, trip_id) VALUES ('6', '200', '2017-07-07', 'First payment', '2')
INSERT INTO Payment (`id`, `amount`, `date`, `description`, trip_id) VALUES ('7', '100', '2017-08-08', 'Third payment', '2');
INSERT INTO Payment (`id`, `amount`, `date`, `description`, trip_id) VALUES ('8', '200', '2017-08-08', 'Fourth payment', '2')

INSERT INTO Notification (`id`, `action`, `date`, `description`, `userName`) VALUES ('1', 'Add', '2017-05-24', 'A payment', 'guest');
INSERT INTO Notification (`id`, `action`, `date`, `description`, `userName`) VALUES ('2', 'Edit', '2017-05-24', 'A payment change', 'admin');
