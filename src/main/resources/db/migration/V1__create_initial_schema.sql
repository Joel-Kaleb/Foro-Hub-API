-- =========================
-- USERS
-- =========================
CREATE TABLE users (
    id bigserial PRIMARY KEY,
    name varchar(50) NOT NULL UNIQUE,
    email varchar(100) NOT NULL UNIQUE,
    password varchar(255) NOT NULL,
    active boolean NOT NULL DEFAULT true,
    created_at timestamptz NOT NULL DEFAULT now(),
    updated_at timestamptz
);

-- =========================
-- COURSES
-- =========================
CREATE TABLE courses (
    id bigserial PRIMARY KEY,
    name varchar(70) NOT NULL,
    category varchar(50) NOT NULL
);

-- =========================
-- TOPICS
-- =========================
CREATE TABLE topics (
    id bigserial PRIMARY KEY,
    title varchar(100) NOT NULL,
    message text NOT NULL,
    created_at timestamptz NOT NULL DEFAULT now(),
    updated_at timestamptz,
    active boolean NOT NULL DEFAULT true,
    author_id bigint NOT NULL,
    course_id bigint NOT NULL,

    CONSTRAINT fk_topics_author
        FOREIGN KEY (author_id)
        REFERENCES users(id)
        ON DELETE RESTRICT,

    CONSTRAINT fk_topics_course
        FOREIGN KEY (course_id)
        REFERENCES courses(id)
        ON DELETE RESTRICT
);

-- =========================
-- ANSWERS
-- =========================
CREATE TABLE answers (
    id bigserial PRIMARY KEY,
    message text NOT NULL,
    topic_id bigint NOT NULL,
    created_at timestamptz NOT NULL DEFAULT now(),
    updated_at timestamptz,
    active boolean NOT NULL DEFAULT true,
    author_id bigint NOT NULL,
    is_solution boolean NOT NULL DEFAULT false,

    CONSTRAINT fk_answers_topic
        FOREIGN KEY (topic_id)
        REFERENCES topics(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_answers_author
        FOREIGN KEY (author_id)
        REFERENCES users(id)
        ON DELETE RESTRICT
);

-- =========================
-- INDEXES (Performance)
-- =========================
CREATE INDEX idx_topics_author_id ON topics(author_id);
CREATE INDEX idx_topics_course_id ON topics(course_id);

CREATE INDEX idx_answers_topic_id ON answers(topic_id);
CREATE INDEX idx_answers_author_id ON answers(author_id);