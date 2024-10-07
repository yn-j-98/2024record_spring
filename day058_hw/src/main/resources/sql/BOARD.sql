CREATE TABLE BOARD (
    BOARD_NUM INT PRIMARY KEY AUTO_INCREMENT, -- 게시물 번호 (기본 키, 자동 증가)
    BOARD_TITLE VARCHAR(255) NOT NULL,        -- 게시물 제목 (NULL 불가)
    BOARD_CONTENT TEXT NOT NULL,               -- 게시물 내용 (NULL 불가)
    BOARD_WRITER VARCHAR(50) NOT NULL          -- 게시물 작성자 (NULL 불가)
);
-- 새로운 게시글 추가
INSERT INTO BOARD (BOARD_TITLE, BOARD_CONTENT, BOARD_WRITER) VALUES ('First Post', 'This is the content of the first post.', 'author1');

-- 모든 게시글 조회
SELECT * FROM BOARD;

-- 특정 게시글 조회
SELECT * FROM BOARD WHERE BOARD_NUM = 1;

-- 특정 게시글의 내용 수정
UPDATE BOARD SET BOARD_CONTENT = 'Updated content for the first post.' WHERE BOARD_NUM = 1;

-- 특정 게시글 삭제
DELETE FROM BOARD WHERE BOARD_NUM = 1;
-- 샘플 데이터 삽입
INSERT INTO BOARD (BOARD_TITLE, BOARD_CONTENT, BOARD_WRITER) VALUES ('First Post', 'This is the content of the first post.', 'author1');
INSERT INTO BOARD (BOARD_TITLE, BOARD_CONTENT, BOARD_WRITER) VALUES ('Second Post', 'Content for the second post goes here.', 'author2');
INSERT INTO BOARD (BOARD_TITLE, BOARD_CONTENT, BOARD_WRITER) VALUES ('Third Post', 'Here is some content for the third post.', 'author3');

DROP TABLE BOARD;