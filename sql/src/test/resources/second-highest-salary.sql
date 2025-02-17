create table Employee(
    id int not null AUTO_INCREMENT,
    salary int not null,
    PRIMARY KEY ( id )
);

INSERT INTO Employee (salary) VALUES (100);
INSERT INTO Employee (salary) VALUES (200);
INSERT INTO Employee (salary) VALUES (300);
