-- ------------------------------------------------------------------------------
-- - Reconstruction de la base de données                                     ---
-- ------------------------------------------------------------------------------
DROP DATABASE IF EXISTS BookStore;
CREATE DATABASE BookStore;
USE BookStore;

-- -----------------------------------------------------------------------------
-- - Création table books				                    			     ---
-- -----------------------------------------------------------------------------
CREATE TABLE books (
	id					int(4)		PRIMARY KEY AUTO_INCREMENT,
	title				varchar(30)	NOT NULL,
	description			varchar(200)NOT NULL,
	author				varchar(30)	NOT NULL,
	price 				float	 	NOT NULL,
	usedBook			boolean		NOT NULL
) ENGINE = InnoDB;

-- -----------------------------------------------------------------------------
-- - Création table roles				                    			     ---
-- -----------------------------------------------------------------------------
CREATE TABLE roles (
	id					int(4)		PRIMARY KEY AUTO_INCREMENT,
	type 				varchar(20)	NOT NULL
) ENGINE = InnoDB;

-- -----------------------------------------------------------------------------
-- - Création table customers				                    		     ---
-- -----------------------------------------------------------------------------
CREATE TABLE customers (
	id					int(4)		PRIMARY KEY AUTO_INCREMENT,
	name				varchar(30)	NOT NULL,
	lastname			varchar(30)	NOT NULL,
	email				varchar(30)	NOT NULL,
	password			varchar(20) NOT NULL,
	phone 				varchar(10)	NOT NULL,
	address				varchar(60)	NOT NULL,
	roles				int(4)		DEFAULT 1,
	FOREIGN KEY (roles) REFERENCES roles(id)
) ENGINE = InnoDB;

-- -----------------------------------------------------------------------------
-- - Création table themes				                    			     ---
-- -----------------------------------------------------------------------------
CREATE TABLE themes (
	id					int(4)		PRIMARY KEY AUTO_INCREMENT,
	name				varchar(30)	NOT NULL
) ENGINE = InnoDB;

-- -----------------------------------------------------------------------------
-- - Création table book_themes			                    			     ---
-- -----------------------------------------------------------------------------
CREATE TABLE book_themes (
	idBook				int(4)		NOT NULL,
	idTheme				int(4)		NOT NULL,
	FOREIGN KEY (idBook) REFERENCES books(id) ON DELETE CASCADE,
	FOREIGN KEY (idTheme) REFERENCES themes(id) ON DELETE CASCADE
) ENGINE = InnoDB;

-- -----------------------------------------------------------------------------
-- - Création table orders				                    			     ---
-- -----------------------------------------------------------------------------
CREATE TABLE orders (
	id 					int(4) 		PRIMARY KEY AUTO_INCREMENT,
	idUser				int(4)		NOT NULL,
	totalAmount			float		NOT NULL,
	createdAt			DATE		NOT NULL,
	FOREIGN KEY (idUser) REFERENCES customers(id)
) ENGINE = InnoDB;

-- -----------------------------------------------------------------------------
-- - Création table order_detail				               			     ---
-- -----------------------------------------------------------------------------
CREATE TABLE order_detail (
	id					int(4) 		PRIMARY KEY AUTO_INCREMENT,
	idOrder				int(4)		NOT NULL,
	idBook				int(4)		NOT NULL,
	price				float		NOT NULL,
	quantity 			int(4)		NOT NULL,
	FOREIGN KEY (idOrder) REFERENCES orders(id),
	FOREIGN KEY (idBook) REFERENCES books(id)
) ENGINE = InnoDB;

-- -----------------------------------------------------------------------------
-- - Remplissage des tables					                   			     ---
-- -----------------------------------------------------------------------------
INSERT INTO books (title, description, author, price, usedBook) VALUES ('Les misérables', 'On sait depuis longtemps que travailler avec du texte lisible et contenant du sens est source de distractions, et empêche de se concentrer sur la mise en page elle-même.', 'Victor Hugo', 14.99, true);
INSERT INTO books (title, description, author, price, usedBook) VALUES ('Le Petit Princes', 'On sait depuis longtemps que travailler avec du texte lisible et contenant du sens est source de distractions, et empêche de se concentrer sur la mise en page elle-même.', 'Antoine de Saint-Exupéry', 19.99, false);
INSERT INTO books (title, description, author, price, usedBook) VALUES ('Le Rouge et le Noir', 'On sait depuis longtemps que travailler avec du texte lisible et contenant du sens est source de distractions, et empêche de se concentrer sur la mise en page elle-même.', 'Stendhal', 8.99, true);
INSERT INTO books (title, description, author, price, usedBook) VALUES ('Le Grand Meaulnes', 'On sait depuis longtemps que travailler avec du texte lisible et contenant du sens est source de distractions, et empêche de se concentrer sur la mise en page elle-même.', 'Alain-Fournier', 16.99, true);
INSERT INTO books (title, description, author, price, usedBook) VALUES ('Jamais sans ma fille', 'On sait depuis longtemps que travailler avec du texte lisible et contenant du sens est source de distractions, et empêche de se concentrer sur la mise en page elle-même.', 'Betty Mahmoody', 14.99, false);
INSERT INTO books (title, description, author, price, usedBook) VALUES ('Les trois mousquetaires', 'On sait depuis longtemps que travailler avec du texte lisible et contenant du sens est source de distractions, et empêche de se concentrer sur la mise en page elle-même.', 'Alexandre Dumas', 29.99, true);
INSERT INTO books (title, description, author, price, usedBook) VALUES ("Journal d'Anne Frank", 'On sait depuis longtemps que travailler avec du texte lisible et contenant du sens est source de distractions, et empêche de se concentrer sur la mise en page elle-même.', 'Anne Frank', 39.99, false);
INSERT INTO books (title, description, author, price, usedBook) VALUES ('La nuit des temps', 'On sait depuis longtemps que travailler avec du texte lisible et contenant du sens est source de distractions, et empêche de se concentrer sur la mise en page elle-même.', 'René Barjavel', 12.99, true);
INSERT INTO books (title, description, author, price, usedBook) VALUES ('Ils étaient dix', 'On sait depuis longtemps que travailler avec du texte lisible et contenant du sens est source de distractions, et empêche de se concentrer sur la mise en page elle-même.', 'Agatha Christie', 18.99, true);
INSERT INTO books (title, description, author, price, usedBook) VALUES ('Jane Eyre', 'On sait depuis longtemps que travailler avec du texte lisible et contenant du sens est source de distractions, et empêche de se concentrer sur la mise en page elle-même.', 'Charlotte Brontë', 19.99, false);

INSERT INTO themes (name) VALUES ('voyage');
INSERT INTO themes (name) VALUES ('jeunesse');
INSERT INTO themes (name) VALUES ('cuisine');
INSERT INTO themes (name) VALUES ('poésie');
INSERT INTO themes (name) VALUES ('science-fiction');
INSERT INTO themes (name) VALUES ('polar');
INSERT INTO themes (name) VALUES ('roman');
INSERT INTO themes (name) VALUES ('petit-prix');
INSERT INTO themes (name) VALUES ('meilleurs ventes');
INSERT INTO themes (name) VALUES ('langues étrangères');
INSERT INTO themes (name) VALUES ('numériques');

INSERT INTO book_themes (idBook, idTheme) VALUES (1, 7);
INSERT INTO book_themes (idBook, idTheme) VALUES (2, 2);
INSERT INTO book_themes (idBook, idTheme) VALUES (3, 4);
INSERT INTO book_themes (idBook, idTheme) VALUES (4, 4);
INSERT INTO book_themes (idBook, idTheme) VALUES (5, 2);
INSERT INTO book_themes (idBook, idTheme) VALUES (6, 1);
INSERT INTO book_themes (idBook, idTheme) VALUES (7, 3);
INSERT INTO book_themes (idBook, idTheme) VALUES (8, 5);
INSERT INTO book_themes (idBook, idTheme) VALUES (9, 7);
INSERT INTO book_themes (idBook, idTheme) VALUES (10, 8);

INSERT INTO roles (type) VALUES ('CUSTOMER');
INSERT INTO roles (type) VALUES ('MANAGER');


