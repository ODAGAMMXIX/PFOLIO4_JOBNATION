DROP SEQUENCE SQ_LANGUAGE_ID;
CREATE SEQUENCE SQ_LANGUAGE_ID START WITH 1;

INSERT INTO LANGUAGE VALUES(
    SQ_LANGUAGE_ID.nextval, /*ID*/
	'Fluente', /*LEVEL*/
    'Ingl�s' /*NAME*/
);

INSERT INTO LANGUAGE VALUES(
    SQ_LANGUAGE_ID.nextval, /*ID*/
	'B�sico', /*LEVEL*/
    'Espanhol' /*NAME*/
);

INSERT INTO LANGUAGE VALUES(
    SQ_LANGUAGE_ID.nextval, /*ID*/
	'Intermedi�rio', /*LEVEL*/
    'Alem�o' /*NAME*/
);

INSERT INTO LANGUAGE VALUES(
    SQ_LANGUAGE_ID.nextval, /*ID*/
	'Avan�ado', /*LEVEL*/
    'Italiano' /*NAME*/
);