CREATE TABLE Examination_Project.Major (
       Major_ID VARCHAR(50) NOT NULL
     , Major VARCHAR(50)
     , PRIMARY KEY (Major_ID)
);

CREATE TABLE Examination_Project.user (
       userID VARCHAR(10) NOT NULL
     , username VARCHAR(50)
     , password NATIONAL VARCHAR(30)
     , userlevel VARCHAR(10)
     , PRIMARY KEY (userID)
);

CREATE TABLE Examination_Project.Academic (
       Academic_ID VARCHAR(50) NOT NULL
     , Academic VARCHAR(50)
     , PRIMARY KEY (Academic_ID)
);

CREATE TABLE Examination_Project.Student (
       Student_ID VARCHAR(10) NOT NULL
     , Student_Name VARCHAR(50)
     , Major_ID VARCHAR(50) NOT NULL
     , PRIMARY KEY (Student_ID)
     , INDEX (Major_ID)
     , CONSTRAINT FK_Student_1 FOREIGN KEY (Major_ID)
                  REFERENCES Examination_Project.Major (Major_ID) ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE Examination_Project.Student_RollNo (
       Roll_No VARCHAR(50) NOT NULL
     , Student_ID VARCHAR(10) NOT NULL
     , Academic_ID VARCHAR(50) NOT NULL
     , PRIMARY KEY (Academic_ID, Roll_No)
     , INDEX (Student_ID)
     , CONSTRAINT FK_Student_RollNo_1 FOREIGN KEY (Student_ID)
                  REFERENCES Examination_Project.Student (Student_ID) ON DELETE CASCADE ON UPDATE CASCADE
     , INDEX (Academic_ID)
     , CONSTRAINT FK_Student_RollNo_2 FOREIGN KEY (Academic_ID)
                  REFERENCES Examination_Project.Academic (Academic_ID) ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE Examination_Project.Subject (
       Subject_Code VARCHAR(50) NOT NULL
     , Subject_Name VARCHAR(50)
     , Course VARCHAR(50)
     , Semester VARCHAR(50)
     , Major_ID VARCHAR(50) NOT NULL
     , PRIMARY KEY (Subject_Code, Major_ID)
     , INDEX (Major_ID)
     , CONSTRAINT FK_Subject_1 FOREIGN KEY (Major_ID)
                  REFERENCES Examination_Project.Major (Major_ID) ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE Examination_Project.Marks (
       Tutorial INT
     , Exam INT
     , Practical INT
     , Total INT
     , ReExam INT
     , Subject_Code VARCHAR(50) NOT NULL
     , Academic_ID VARCHAR(50) NOT NULL
     , Roll_No VARCHAR(50) NOT NULL
     , Major_ID VARCHAR(50) NOT NULL
     , PRIMARY KEY (Subject_Code, Academic_ID, Roll_No)
     , INDEX (Academic_ID)
     , CONSTRAINT FK_Marks_2 FOREIGN KEY (Academic_ID)
                  REFERENCES Examination_Project.Academic (Academic_ID) ON DELETE NO ACTION ON UPDATE CASCADE
     , INDEX (Academic_ID, Roll_No)
     , CONSTRAINT FK_Marks_3 FOREIGN KEY (Academic_ID, Roll_No)
                  REFERENCES Examination_Project.Student_RollNo (Academic_ID, Roll_No) ON DELETE NO ACTION ON UPDATE CASCADE
     , INDEX (Subject_Code, Major_ID)
     , CONSTRAINT FK_Marks_4 FOREIGN KEY (Subject_Code, Major_ID)
                  REFERENCES Examination_Project.Subject (Subject_Code, Major_ID) ON DELETE NO ACTION ON UPDATE CASCADE
);

