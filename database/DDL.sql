--database: SIA.db
DROP TABLE IF EXISTS DatosRiego;

CREATE TABLE  DatosRiego(
    IdDatosRiego INTEGER PRIMARY KEY AUTOINCREMENT,
    FechaRiego datetime default current_timestamp,
    NumRiego TEXT NOT NULL,
    Humedad INTEGER NOT NULL,
    TipodeRiego TEXT NOT NULL
);
