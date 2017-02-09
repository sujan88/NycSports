INSERT INTO credentials(username,password,verifyPassword, enabled) VALUES ('guest','guest','guest', TRUE);
INSERT INTO credentials(username,password,verifyPassword, enabled) VALUES ('admin','admin','guest', TRUE);
 
INSERT INTO authority (username, authority) VALUES ('guest', 'ROLE_USER');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authority (username, authority) VALUES ('admin', 'ROLE_USER');

INSERT INTO  category VALUES ('smartphone','mobile phones');
INSERT INTO category VALUES ('Tablet','portable medium size device');
INSERT INTO category VALUES ('Laptop','portable computers');
INSERT INTO category VALUES ('Shoes','shoes');
INSERT INTO category VALUES ('Weights','weights');
INSERT INTO category VALUES ('Cloths','portable computers');
INSERT INTO category VALUES ('Guard','Guard');
INSERT INTO category VALUES ('Suppliment','Suppliment');

INSERT INTO product VALUES ('P1','2014-11-10','USA imported Helmats. Manufactured by china',false, 'Apple','IHF Helmat','New',500,1,1000,'Guard')
INSERT INTO product VALUES ('P2','2014-11-10','One of our specialties at Sports Product Review is training aids',false, 'Google','Hand Gloves','New',800,1,1000,'Guard')
INSERT INTO product VALUES ('P3','2014-11-10','Dell Inspiron 14-inch Laptop (Black) with 3rd Generation Intel Core processors',false, 'Google','Sneaker','New',800,1,1000,'Shoes')
	
INSERT INTO product VALUES ('P4','2014-11-10','Apple iPhone 5s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera',false, 'Apple','Sprots Bag','New',500,1,1000,'Cloths')
INSERT INTO product VALUES ('P5','2014-11-10','Google Nexus 7 is the lightest 7 inch tablet With a quad-core Qualcomm Snapdragon',false, 'Google','NY T-Shit','New',800,1,1000,'Cloths')
INSERT INTO product VALUES ('P6','2014-11-10','Dell Inspiron 14-inch Laptop (Black) with 3rd Generation Intel Core processors',false, 'Google','Eliko Weight','New',800,1,1000,'Weights')
INSERT INTO product VALUES ('P7','2014-11-10','Dell Inspiron 14-inch Laptop (Black) with 3rd Generation Intel Core processors',false, 'Google','Bumbel 10kg','New',800,1,1000,'Weights')
INSERT INTO product VALUES ('P8','2014-11-10','Enhanced muscle growth, extended endurance, and increased muscle pumps',false, 'Google','NO2 maximize','New',600,1,1000,'Suppliment')


INSERT INTO creditcard VALUES (null,null,123,'2020-10-10', 'Sujan','1111222233334444')

INSERT INTO address VALUES (null,'StatenIsland','USA','NY', 'Bord cord st','10302')

INSERT INTO users VALUES (null,'1988-11-10','sujan@gmail.com', 'sujan','duminda', '122332233','Mr',1122,1,'guest')


