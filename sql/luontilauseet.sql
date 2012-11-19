CREATE TABLE Users
(
userKey serial NOT NULL PRIMARY KEY,
userName varchar NOT NULL UNIQUE,
password varchar NOT NULL,
name varchar NOT NULL,
joinDate date NOT NULL
);

CREATE TABLE Events
(
eventKey serial NOT NULL PRIMARY KEY,
createdBy int references Users(userKey),
createdDate date NOT NULL,
name varchar NOT NULL,
information text
);

CREATE TABLE Attendees
(
attends int references Users(userKey),
event int references Events(eventKey),
joinDate date
);

CREATE TABLE Comments
(
commentKey serial NOT NULL,
commentedBy int references Users(userKey),
event int references Events(eventKey),
commentedDate date,
text varchar NOT NULL
);

