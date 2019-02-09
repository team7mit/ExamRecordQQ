CREATE TABLE DEFAULT_SCHEMA.You (
       y_id INT(10) NOT NULL
     , y_name VARCHAR(50)
     , id INT(10) NOT NULL
     , PRIMARY KEY (y_id)
     , INDEX (id)
     , CONSTRAINT FK_You_1 FOREIGN KEY (id)
                  REFERENCES DEFAULT_SCHEMA.Me (id)
);

