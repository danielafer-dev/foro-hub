CREATE TABLE topics (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    date DATETIME NOT NULL,
    status VARCHAR(100) NOT NULL,
    author_id BIGINT NOT NULL,
    course VARCHAR(255) NOT NULL,
    CONSTRAINT fk_topic_author FOREIGN KEY (author_id) REFERENCES users(id)
);