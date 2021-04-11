DROP SEQUENCE SQ_LANGUAGE_ID;
CREATE SEQUENCE SQ_LANGUAGE_ID START WITH 1;

INSERT INTO LANGUAGE VALUES(
    SQ_LANGUAGE_ID.nextval, /*ID*/
	'Fluente', /*LEVEL*/
    'Inglês' /*NAME*/
);

INSERT INTO LANGUAGE VALUES(
    SQ_LANGUAGE_ID.nextval, /*ID*/
	'Básico', /*LEVEL*/
    'Espanhol' /*NAME*/
);

INSERT INTO LANGUAGE VALUES(
    SQ_LANGUAGE_ID.nextval, /*ID*/
	'Intermediário', /*LEVEL*/
    'Alemão' /*NAME*/
);

INSERT INTO LANGUAGE VALUES(
    SQ_LANGUAGE_ID.nextval, /*ID*/
	'Avançado', /*LEVEL*/
    'Italiano' /*NAME*/
);