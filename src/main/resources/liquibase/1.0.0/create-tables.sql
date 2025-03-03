CREATE TABLE notes
(
  id      UUID PRIMARY KEY,
  title   VARCHAR NOT NULL,
  message VARCHAR NOT NULL,
  date    DATE    NOT NULL
);
