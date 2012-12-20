INSERT INTO Users (userName, password, name) VALUES
('Topias', 'uliuli', 'Topias Rusanen'),
('Erkki', 'uliuli', 'Erkki Esimerkki');

INSERT INTO Events (createdBy, name, information) VALUES
(1, 'Pussikaljottelu', 'Juodaan kaljaa, ollaan hiljaa'),
(1, 'Kulttuuri-ilta', 'Juodaan viiniä, ollaan hiljaa');

INSERT INTO Comments (commentedBy, event, text) VALUES
(2, 1, 'Jee, mukana ollaan!');

INSERT INTO Attendees (attends, event) VALUES
(1, 1),
(2, 1),
(1, 2);
