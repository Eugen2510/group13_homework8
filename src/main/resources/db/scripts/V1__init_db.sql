CREATE TABLE IF NOT EXISTS building (
id INT AUTO_INCREMENT PRIMARY KEY,
num_of_flat SMALLiNT(2) NOT NULL DEFAULT 100,
adress VARCHAR(100)
);


CREATE TABLE IF NOT EXISTS flat(
id INT AUTO_INCREMENT PRIMARY KEY,
building_id INT NOT NULL,
apartment_number SMALLINT NOT NULL,
area SMALLINT(2) NOT NULL DEFAULT 60,
floor TINYINT(1) NOT NULL,
num_of_rooms TINYINT(1) DEFAULT 1,
FOREIGN KEY flat_building_fk (building_id) REFERENCES building(id)
);

CREATE TABLE IF NOT EXISTS resident
(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
email VARCHAR (150) DEFAULT 'none',
building_id INT NOT NULL,
flat_id INT NOT NULL,
parking_right SMALLINT DEFAULT 0,
	CHECK (parking_right IN (0,1)),
ownership SMALLINT DEFAULT 0,
	CHECK (ownership IN (0,1)),
FOREIGN KEY building_id_fk (building_id) REFERENCES building(id),
FOREIGN KEY flat_id_fk (flat_id) REFERENCES flat(id)
);

CREATE TABLE IF NOT EXISTS flat_owner (
resident_id INT NOT NULL,
flat_id INT NOT NULL,
PRIMARY KEY (flat_id, resident_id),
FOREIGN KEY (flat_id) REFERENCES flat(id),
FOREIGN KEY (resident_id) REFERENCES resident(id)
);
