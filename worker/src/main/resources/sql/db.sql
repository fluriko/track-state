CREATE TABLE WEB_RESOURCES(
RESOURCE_ID BIGINT PRIMARY KEY AUTO_INCREMENT,
RESOURCE_NAME VARCHAR(30) NOT NULL,
RESOURCE_URL VARCHAR(2083) NOT NULL,
RESOURCE_STATUS VARCHAR(MAX)
);