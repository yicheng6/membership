DROP TABLE students IF EXISTS;

CREATE TABLE students (
  id         INTEGER IDENTITY PRIMARY KEY,
  number 	 VARCHAR(100),
  name   	 VARCHAR(30),
  sex    	 VARCHAR(10),
  grade  	 VARCHAR(30),
  major  	 VARCHAR(50),
  class_name  	 VARCHAR(50),
  id_card	 VARCHAR(50),
  moblie	 VARCHAR(20),
  remark	 VARCHAR(500),
);
