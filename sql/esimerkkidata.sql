INSERT INTO UserData VALUES
(1, 'Topias', 'uliuli', 'Topias Rusanen', NOW()),
(2, 'Ege', 'uliuli', 'Erkki Esimerkki', NOW());

INSERT INTO Event VALUES
(1, 1, NOW(), 'Pussikaljottelu', 'Juodaan kaljaa, ollaan hiljaa');

INSERT INTO Comments VALUES
(1, 2, 1, NOW(), 'Jee, mukana ollaan!');

INSERT INTO Attendees VALUES
(1, 1, NOW()),
(2, 1, NOW());
