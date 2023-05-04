SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS student_science_subject;

FLUSH TABLES;

INSERT INTO student_table(student_id,average_grade,first_name, last_name,total_marks, total_points)VALUES
(45,"A-","John", "Doe", 90,11.0);
INSERT INTO student_table(student_id,average_grade,first_name, last_name,total_marks, total_points)VALUES
(46,"B+","Johnnie", "Walker", 83,10.0);
INSERT INTO student_table(student_id,average_grade,first_name, last_name,total_marks, total_points)VALUES
(47,"C","Notjane", "Doe", 56,7.0);
INSERT INTO student_table(student_id,average_grade,first_name, last_name,total_marks, total_points)VALUES
(48,"C+","Test", "Name", 66,8.0);

INSERT INTO subject_table(subject_id, subject_category, subject_name)VALUES
(1,"COMPULSORY","MATHS");
INSERT INTO subject_table(subject_id, subject_category, subject_name)VALUES
(2,"COMPULSORY","ENG");
INSERT INTO subject_table(subject_id,subject_category, subject_name)VALUES
(3,"COMPULSORY","KIS");
INSERT INTO subject_table(subject_id, subject_category, subject_name)VALUES
(4,"SCIENCES","BIO");
INSERT INTO subject_table(subject_id, subject_category, subject_name)VALUES
(5,"SCIENCES","PHY");
INSERT INTO subject_table(subject_id, subject_category, subject_name)VALUES
(6,"SCIENCES","CHEM");
INSERT INTO subject_table(subject_id,  subject_category, subject_name)VALUES
(7,"HUMANITIES","GEOG");
INSERT INTO subject_table(subject_id, subject_category, subject_name)VALUES
(8,"HUMANITIES","CRE");
INSERT INTO subject_table(subject_id, subject_category, subject_name)VALUES
(9,"HUMANITIES","HIST");
INSERT INTO subject_table(subject_id, subject_category, subject_name)VALUES
(10,"TECHNICAL","AGRI");
INSERT INTO subject_table(subject_id, subject_category, subject_name)VALUES
(11,"TECHNICAL","COMP");
INSERT INTO subject_table(subject_id,subject_category, subject_name)VALUES
(12,"TECHNICAL","BED");


SET FOREIGN_KEY_CHECKS = 1;