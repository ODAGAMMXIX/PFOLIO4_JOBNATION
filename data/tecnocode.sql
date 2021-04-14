/*SELECT SIN(37) FROM DUAL;

SELECT 
id, 
(
   3959 *
   acos(cos((37 * 3.14)/ 180) * 
   cos((lat * 3.14)/ 180) * 
   cos((lng * 3.14)/ 180 - 
   (-122 * 3.14)/ 180) + 
   sin((37 * 3.14)/ 180) * 
   sin((lat * 3.14)/ 180))
) AS distance 
FROM markers 
HAVING distance < 28 
ORDER BY distance LIMIT 0, 20;

SELECT 
id, 
(
   3959 *
   acos(cos(radians(37)) * 
   cos(radians(lat)) * 
   cos(radians(lng) - 
   radians(-122)) + 
   sin(radians(37)) * 
   sin(radians(lat )))
) AS distance 
FROM markers 
HAVING distance < 28 
ORDER BY distance LIMIT 0, 20;

SELECT
*,
(
   6371 *
   acos(cos(sin(37)) *
   cos(sin(adr_lat)) *
   cos(sin(adr_long) -
   sin(-122)) +
   sin(sin(37)) *
   sin(sin(adr_lat)))
) AS distance 
FROM address 
HAVING distance < 28 
ORDER BY distance;

select *
from
(
  SELECT
    *, 
    (
		6371 *
		acos(cos(sin(37)) *
		cos(sin(adr_lat)) *
		cos(sin(adr_long) -
		sin(-122)) +
		sin(sin(37)) *
		sin(sin(adr_lat)))
	) as distance 
  FROM address
)
where distance <= 100;

select *
from
(
  SELECT adr_id, 
    adr_city, 
    (
		6371 *
		acos(cos((-23.1622 * 3.141592) / 180 ) *
		cos(sin(adr_lat)) *
		cos(sin(adr_long) -
		sin((-45.7953 * 3.141592) / 180)) + 
		sin((-23.1622 * 3.141592) / 180 ) *
		sin(sin(adr_lat)))
	) as distance 
  FROM address
) x
where distance <= 27;

SELECT radians(-23.1622) as radio, sin(-23.1622) as sinn from dual;
-0.4042566520054306  ||  0.9211603039028685

select *
from
(
  SELECT adr_id, 
    adr_city, 
    (
	   3959 *
	   acos(cos((37 * 3.14)/ 180) * 
	   cos((lat * 3.14)/ 180) * 
	   cos((lng * 3.14)/ 180 - 
	   (-122 * 3.14)/ 180) + 
	   sin((37 * 3.14)/ 180) * 
	   sin((lat * 3.14)/ 180))
	) AS distance 
  FROM address
) x
where distance <= 27;

/*
	SELECT 
	id,
	name,
	address,
	(
	   6371 *
	   acos(cos(radians(-23.162199)) * 
	   cos(radians(lat)) * 
	   cos(radians(lng) - 
	   radians(-45.795300)) + 
	   sin(radians(-23.162199)) * 
	   sin(radians(lat )))
	) AS distance 
	FROM markers 
	HAVING distance < 28 
	ORDER BY distance LIMIT 0, 20;
*/

/*INSERT INTO `markers` (`name`, `address`, `lat`, `lng`)
VALUES ('Rafael Estevam de Oliveira','Rua Professora Maria José de Oliveira, 136, Nova Michigan, São José dos Campos - SP','-23.20051','-45.78417');

INSERT INTO `markers` (`name`, `address`, `lat`, `lng`)
VALUES ('Michelle Estevam de Oliveira','Rua José Castrioto, 127, Nova Esperança, São José dos Campos - SP','-23.1986661','-45.7892607');

INSERT INTO `markers` (`name`, `address`, `lat`, `lng`)
VALUES ('Júlia dos Santos Pereira','Av. Paulista, Bela Vista, São Paulo - SP','-23.5628312','-46.6552963');

INSERT INTO `markers` (`name`, `address`, `lat`, `lng`)
VALUES ('FATEC','Avenida Cesare Monsueto Giulio Lattes, Jardim Santa Ines I, São José dos Campos - SP','-23.1621987','-45.7952995');*/

-- SELECT * FROM (SELECT (6371 * acos(cos(sin(37)) * cos(sin(adr_lat)) * cos(sin(adr_long) - sin(-122)) + sin(sin(37)) * sin(sin(adr_lat)) )

/*SELECT 
id, 
(
   3959 * //earth radians in miles (6371 em quilómetros)
   acos(cos(radians(37)) * 
   cos(radians(lat)) * 
   cos(radians(lng) - 
   radians(-122)) + 
   sin(radians(37)) * 
   sin(radians(lat )))
) AS distance 
FROM markers 
HAVING distance < 28 
ORDER BY distance LIMIT 0, 20;*/

/* SET @Lat1Radians = -23,1622 * PI() / 180 Coords da empresa
    SET @Long1Radians = -45,7953 * PI() / 180 Coords da empresa
    SET @Lat2Radians = -23,20051 * PI() / 180
    SET @Long2Radians = -45,78417 * PI() / 180*/

/*SELECT 
id, 
(
   ACOS(COS(-23,1622 * PI() / 180) * COS(-45,7953 * PI() / 180) *
			COS(-23,20051 * PI() / 180) * COS(-45,78417 * PI() / 180) +
			COS(-23,1622 * PI() / 180) * SIN(-45,7953 * PI() / 180) *
			COS(-23,20051 * PI() / 180) * SIN(-45,78417 * PI() / 180) +
			SIN(-23,1622 * PI() / 180) * SIN(-23,20051 * PI() / 180)) *
		6371
) AS distance 
FROM markers 
HAVING distance < 28 
ORDER BY distance LIMIT 0, 20;*/

/*ALTER FUNCTION [dbo].[fn_GetZipDistanceMiles](
    @ZipFrom VARCHAR(20),
    @ZipTo VARCHAR(20)
)
RETURNS FLOAT 
AS  
BEGIN 

    DECLARE @Latitude1 FLOAT
    DECLARE @Longitude1 FLOAT
    DECLARE @Latitude2 FLOAT
    DECLARE @Longitude2 FLOAT

    SELECT  @Latitude1 = Latitude,
            @Longitude1 = Longitude
    FROM    ZipCode
    WHERE   ZipCode = @ZipFrom


    SELECT  @Latitude2 = Latitude,
            @Longitude2 = Longitude
    FROM    ZipCode
    WHERE   ZipCode = @ZipTo

    -- CONSTANTS
    DECLARE @EarthRadiusInMiles FLOAT
    SET @EarthRadiusInMiles = 3963.1

    -- RADIANS conversion
    DECLARE @Lat1Radians FLOAT
    DECLARE @Long1Radians FLOAT
    DECLARE @Lat2Radians FLOAT
    DECLARE @Long2Radians FLOAT

    SET @Lat1Radians = @Latitude1 * PI() / 180
    SET @Long1Radians = @Longitude1 * PI() / 180
    SET @Lat2Radians = @Latitude2 * PI() / 180
    SET @Long2Radians = @Longitude2 * PI() / 180

    RETURN 
		ACOS(COS(@Lat1Radians) * COS(@Long1Radians) *
			COS(@Lat2Radians) * COS(@Long2Radians) +
			COS(@Lat1Radians) * SIN(@Long1Radians) *
			COS(@Lat2Radians) * SIN(@Long2Radians) + 
			SIN(@Lat1Radians) * SIN(@Lat2Radians)) *
		@EarthRadiusInMiles

END*/

select *
from
(
  SELECT
    adr_id,
    adr_lat,
    adr_long,
    adr_cep_pczc,
    adr_detail,
    adr_num,
    adr_hood,
    adr_city,
    adr_state,
    (
	   6371 *  -- em quilómetros
	   acos(cos((-23.1622 * 3.14)/ 180) * --latitude da vaga -23.1622
	   cos((adr_lat * 3.14)/ 180) * 
	   cos((adr_long * 3.14)/ 180 - 
	   (-45.7953 * 3.14)/ 180) + --longitude da vaga -23.1622
	   sin((-23.1622 * 3.14)/ 180) * 
	   sin((adr_lat * 3.14)/ 180))
	) AS distance 
  FROM address
) x
where distance <= 100;