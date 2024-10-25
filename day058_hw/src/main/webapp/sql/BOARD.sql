-- 실습
CREATE TABLE BOARD (
	BID INT PRIMARY KEY AUTO_INCREMENT ,
	CONTENT VARCHAR(1000) NOT NULL,
	WRITER VARCHAR(50) NOT NULL
);

INSERT INTO BOARD (CONTENT, WRITER) VALUES('내용','예나');

SELECT BID,CONTENT,WRITER FROM BOARD WHERE CONTENT LIKE CONCAT('%','1','%')


-- 새로운 게시글 추가
INSERT INTO BOARD (CONTENT, WRITER) VALUES ('내용이다', '예나');
INSERT INTO BOARD (CONTENT, WRITER) VALUES ('내용1', 'YN');

-- 모든 게시글 조회
SELECT * FROM BOARD;

-- 특정 게시글 조회
SELECT * FROM BOARD WHERE BOARD_NUM = 1;

-- 특정 게시글의 내용 수정
UPDATE BOARD SET CONTENT = 'Update' WHERE BID = 1;

-- 특정 게시글 삭제
DELETE FROM BOARD WHERE BID = 2;


DROP TABLE BOARD;