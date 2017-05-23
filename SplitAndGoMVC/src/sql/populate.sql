INSERT INTO credential(username,password,enabled) VALUES ('guest','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE);
INSERT INTO credential(username,password,enabled) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);
 
INSERT INTO authority (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_USER');

INSERT INTO `MEMBER` (firstname, lastname, nickname, email, gender, credential_id) VALUES ('Tuyen', 'Lam', 'Tien' ,'tuyenrg@gmail.com', 0 ,'admin');
INSERT INTO `MEMBER` (firstname, lastname, nickname, email, gender, credential_id) VALUES ('Guest', 'Guest', 'Guest' ,'guest@gmail.com', 0, 'guest');

INSERT INTO `TRIP` (name, description, startDate, endDate) VALUES ('Trip 1', 'Trip 1', '2017-05-22', '2017-05-30');
INSERT INTO `TRIP` (name, description, startDate, endDate) VALUES ('Trip 2', 'Trip 2', '2017-06-22', '2017-06-28');