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
createdBy int references UserData(userKey),
createdDate date NOT NULL,
name varchar NOT NULL,
information text
);

CREATE TABLE Attendees
(
attends int references UserData(userKey),
event int references Event(eventKey),
joinDate date
);

CREATE TABLE Comments
(
commentKey serial NOT NULL,
commentedBy int references UserData(userKey),
event int references Event(eventKey),
commentedDate date,
text varchar NOT NULL
);

