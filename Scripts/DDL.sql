--database: SIA.sqlite
DROP TABLE IF EXISTS DatoRiego;
DROP TABLE IF EXISTS TipodeRiego;

CREATE TABLE TipodeRiego(
    IdTipodeRiego INTEGER PRIMARY KEY AUTOINCREMENT,
    Descripcion TEXT NOT NULL 
);

CREATE TABLE  DatoRiego(
    IdDato INTEGER PRIMARY KEY AUTOINCREMENT,
    Humedad INTEGER NOT NULL,
    IdTipoRiego INTEGER NOT NULL REFERENCES TipodeRiego(IdTipodeRiego),
    FechaCrea datetime default current_timestamp,
    FechaModificacion datetime 
);