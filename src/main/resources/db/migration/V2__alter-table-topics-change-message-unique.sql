alter table topics
ADD CONSTRAINT uc_topics_message UNIQUE (message);