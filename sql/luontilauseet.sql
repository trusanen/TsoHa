CREATE TABLE Users
(
userKey serial NOT NULL PRIMARY KEY,
userName varchar NOT NULL UNIQUE,
password varchar NOT NULL,
name varchar NOT NULL,
joinDate date NOT NULL DEFAULT NOW()
);

CREATE TABLE Events
(
eventKey serial NOT NULL PRIMARY KEY,
createdBy int references Users(userKey),
createdDate date NOT NULL DEFAULT NOW(),
name varchar NOT NULL,
information text
);

CREATE TABLE Attendees
(
attendKey serial NOT NULL PRIMARY KEY,
attends int references Users(userKey),
event int references Events(eventKey),
joinDate date DEFAULT NOW(),
UNIQUE (attends, event)
);

CREATE TABLE Comments
(
commentKey serial NOT NULL PRIMARY KEY,
commentedBy int references Users(userKey),
event int references Events(eventKey),
commentedDate date DEFAULT NOW(),
text varchar NOT NULL
);

