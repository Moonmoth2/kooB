/* 
 * [Book 테이블]
 * 
 * API 데이터 -> JSON -> XLS 변환을 통해 생성한 엑셀 파일을 가지고
 * SQL Developer의 임포트 기능을 통해 테이블을 생성하기 때문에
 * 별도의 CREATE TABLE문 및 초기 데이터 삽입을 위한 INSERT문이 존재하지 않음.
 */

/* 제약조건 추가 */
ALTER TABLE BOOK ADD CONSTRAINT PK_BOOK PRIMARY KEY(ITEMID, CATEGORYNAME);