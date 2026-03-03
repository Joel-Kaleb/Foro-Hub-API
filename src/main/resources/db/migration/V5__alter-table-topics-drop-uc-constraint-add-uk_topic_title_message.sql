ALTER TABLE topics DROP CONSTRAINT IF EXISTS uc_topics_title;
ALTER TABLE topics DROP CONSTRAINT IF EXISTS uc_topics_message;

ALTER TABLE topics ADD CONSTRAINT uk_topic_title_message UNIQUE (title, message);