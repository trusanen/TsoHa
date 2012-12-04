CREATE TABLE Users
(
userKey serial NOT NULL PRIMARY KEY,
userName varchar NOT NULL UNIQUE,
password varchar NOT NULL,
name varchar NOT NULL,
joinDate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Events
(
eventKey serial NOT NULL PRIMARY KEY,
createdBy int references Users(userKey),
createdDate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
name varchar NOT NULL,
information text
);

CREATE TABLE Attendees
(
attendKey serial NOT NULL PRIMARY KEY,
attends int references Users(userKey),
event int references Events(eventKey),
joinDate timestamp DEFAULT CURRENT_TIMESTAMP,
UNIQUE (attends, event)
);

CREATE TABLE Comments
(
commentKey serial NOT NULL PRIMARY KEY,
commentedBy int references Users(userKey),
event int references Events(eventKey),
commentedDate timestamp DEFAULT CURRENT_TIMESTAMP,
text varchar NOT NULL
);

