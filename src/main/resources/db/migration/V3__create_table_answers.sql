CREATE TABLE answers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    message TEXT NOT NULL,
    topic_id BIGINT NOT NULL,
    date DATETIME NOT NULL,
    author_id BIGINT NOT NULL,
    solution BOOLEAN DEFAULT FALSE,
    CONSTRAINT fk_answer_topic FOREIGN KEY (topic_id) REFERENCES topics(id),
    CONSTRAINT fk_answer_author FOREIGN KEY (author_id) REFERENCES users(id)
);