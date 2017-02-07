INSERT INTO credentials(username,password,enabled) VALUES ('guest','$2a$10$0.ESlGysrPaiW5HaapKwoehzWt5AibgbPPOvMhDv8D6H26QQ/CwhS', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('admin','$2a$10$S/wlXEo/APzf.Sn1cO2p4.V12EJmaw.uzrHelMvkpuahjmHWnSafe', TRUE);
 
INSERT INTO authority (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_USER');

INSERT INTO  category VALUES ('smartphone','mobile phones');
INSERT INTO category VALUES ('Tablet','portable medium size device');
INSERT INTO category VALUES ('Laptop','portable computers');
 
INSERT INTO product VALUES ('P1234','2014-11-10','Apple iPhone 5s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera',false, 'Apple','iPhone 5s',500,1,1000,'SmartPhone')
INSERT INTO product VALUES ('P1235','2014-11-10','Google Nexus 7 is the lightest 7 inch tablet With a quad-core Qualcomm Snapdragon',false, 'Google','iPhone 5s',800,1,1000,'Tablet')
INSERT INTO product VALUES ('P1236','2014-11-10','Dell Inspiron 14-inch Laptop (Black) with 3rd Generation Intel Core processors',false, 'Google','iPhone 5s',800,1,1000,'Laptop')
	
