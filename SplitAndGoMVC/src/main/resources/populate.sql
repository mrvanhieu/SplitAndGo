INSERT INTO credential(username,password,enabled) VALUES ('guest','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE);
INSERT INTO credential(username,password,enabled) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);
 
INSERT INTO authority (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_USER');

INSERT INTO `MEMBER` (firstname, lastname, nickname, email, gender, credential_id) VALUES ('Tuyen', 'Lam', 'Tien' ,'tuyenrg@gmail.com', 0 ,'admin');
INSERT INTO `MEMBER` (firstname, lastname, nickname, email, gender, credential_id) VALUES ('Guest', 'Guest', 'Guest' ,'guest@gmail.com', 0, 'guest');

INSERT INTO Payment (`id`, `amount`, `date`, `description`) VALUES ('2', '100', '2017-10-10', 'Second payment');
INSERT INTO Payment (`id`, `amount`, `date`, `description`) VALUES ('1', '200', '2017-09-09', 'First payment')
