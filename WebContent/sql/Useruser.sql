/* [Useruser 테이블] */

CREATE TABLE USERUSER(
	NAME VARCHAR2(30),
	USERID VARCHAR2(30),
	PWD VARCHAR2(30),
	GENDER VARCHAR2(10),
	AGE NUMBER(3),
	PHONE VARCHAR2(13),
	EMAIL VARCHAR2(30),
	BOOKS VARCHAR2(128),
	
	PRIMARY KEY(USERID)
);

INSERT INTO USERUSER VALUES('박평식', 'goodmovie', '1234', '남자', 70, '010-1234-1234', 'goodmovie@naver.com', '118');
INSERT INTO USERUSER VALUES('이동진', 'reader', '4321', '남자', 52, '010-4321-4321', 'reader@naver.com', '101');
INSERT INTO USERUSER VALUES('황교익', 'hatepjw', '1212', '남자', 58, '010-1212-1212', 'hatepjw@naver.com', '101, 103, 118, 128');
INSERT INTO USERUSER VALUES('이다혜', 'writer', '2121', '여자', 43, '010-2121-2121', 'writer@naver.com', '103');
