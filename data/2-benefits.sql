DROP SEQUENCE SQ_BENEFITS_ID;
CREATE SEQUENCE SQ_BENEFITS_ID START WITH 1;

INSERT INTO BENEFITS VALUES(
    SQ_BENEFITS_ID.nextval, /*ID*/
	'Vale refei��o'/*benefits*/
);

INSERT INTO BENEFITS VALUES(
    SQ_BENEFITS_ID.nextval, /*ID*/
	'Vale transporte'/*benefits*/
);

INSERT INTO BENEFITS VALUES(
    SQ_BENEFITS_ID.nextval, /*ID*/
	'Conv�nio m�dico'/*benefits*/
);

INSERT INTO BENEFITS VALUES(
    SQ_BENEFITS_ID.nextval, /*ID*/
	'Seguro de vida'/*benefits*/
);

INSERT INTO BENEFITS VALUES(
    SQ_BENEFITS_ID.nextval, /*ID*/
	'Conv�nio odontol�gico'/*benefits*/
);

