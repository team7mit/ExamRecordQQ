CREATE TABLE DEFAULT_SCHEMA.subject (
       name VARCHAR(30) NOT NULL
     , subjectid NUMERIC NOT NULL
     , id NUMERIC NOT NULL
     , PRIMARY KEY (name, subjectid)
     , INDEX (id)
     , CONSTRAINT FK_subject_1 FOREIGN KEY (id)
                  REFERENCES DEFAULT_SCHEMA.student (id)
);

