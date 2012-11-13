INSERT INTO Kayttaja VALUES
(1, 'Topias', 'uliuli', 'Topias Rusanen', NOW()),
(2, 'Ege', 'uliuli', 'Erkki Esimerkki', NOW());

INSERT INTO Tapahtuma VALUES
(1, 1, NOW(), 'Pussikaljottelu', 'Juodaan kaljaa, ollaan hiljaa');

INSERT INTO Kommentti VALUES
(1, 2, 1, NOW(), 'Jee, mukana ollaan!');

INSERT INTO Ilmoittautumiset VALUES
(1, 1, NOW()),
(2, 1, NOW());
