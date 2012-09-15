CREATE TABLE kayttaja
(
kayttajaKey int NOT NULL PRIMARY KEY,
nimi varchar(255) NOT NULL,
liittynytPVM date NOT NULL,
)
CREATE TABLE tapahtuma
(
tapahtumaKey int NOT NULL PRIMARY KEY,
nimi varchar(255) NOT NULL,
luotuPVM date NOT NULL,
luonut FOREIGN KEY REFERENCES kayttaja(kayttajaKey)
)
CREATE TABLE ilmoittaumiset
(
kayttajaKey FOREIGN KEY REFERENCES kayttaja(kayttajaKey),
tapahtumaKey FOREIGN KEY REFERENCES tapahtuma(tapahtumaKey)
)
CREATE TABLE kommentti
(
kommenttiKey int NOT NULL PRIMARY KEY,
teksti varchar(255) NOT NULL,
kommentoinut FOREIGN KEY REFERENCES kayttaja(kayttajaKey),
tapahtumaKey FOREIGN KEY REFERENCES tapahtuma(tapahtumaKey)
)

