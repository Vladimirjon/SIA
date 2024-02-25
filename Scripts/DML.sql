-- database: SIA.sqlite
INSERT INTO TipodeRiego(Descripcion)
    VALUES('Automatico'),('Manual');

SELECT * FROM  TipodeRiego;
DELETE FROM TipodeRiego WHERE IdTipodeRiego>2;

INSERT INTO DatoRiego(Humedad,IdTipoRiego)
VALUES(12,1)
-- SELECT * FROM DatosRiego;