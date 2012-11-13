CREATE TABLE Kayttaja
(
kayttajaKey serial NOT NULL PRIMARY KEY,
kayttajaNimi varchar NOT NULL UNIQUE,
salasana varchar NOT NULL,
nimi varchar NOT NULL,
liittynytPVM date NOT NULL
);

CREATE TABLE Tapahtuma
(
tapahtumaKey serial NOT NULL PRIMARY KEY,
luonut int references Kayttaja(kayttajaKey),
luotuPVM date NOT NULL,
nimi varchar NOT NULL,
tiedot text
);

CREATE TABLE Ilmoittautumiset
(
ilmoittautunut int references Kayttaja(kayttajaKey),
tapahtuma int references Tapahtuma(tapahtumaKey),
ilmoittautumisPVM date
);

CREATE TABLE Kommentti
(
kommenttiKey serial NOT NULL,
kommentoija int references Kayttaja(kayttajaKey),
tapahtuma int references Tapahtuma(tapahtumaKey),
kommenttiPVM date,
teksti varchar NOT NULL
);

