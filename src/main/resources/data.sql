DROP TABLE IF EXISTS events;

CREATE TABLE events(
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  description VARCHAR(250),
  location VARCHAR(50)
);

INSERT INTO events(id, name, description, location) VALUES
(1, 'Angular Connect', 'Angular Conference',  'San Francisco');
INSERT INTO events(id, name, description,  location) VALUES
 (2, 'Java One', 'Java Conference',  'Miami');
INSERT INTO events(id, name, description,  location) VALUES
(3, 'MongoDB World', 'MongoDB Conference', 'New York');