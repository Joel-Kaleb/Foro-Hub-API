alter table topics
ADD CONSTRAINT uc_topics_title UNIQUE (title);