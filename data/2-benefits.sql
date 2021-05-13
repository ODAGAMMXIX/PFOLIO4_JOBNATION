DROP SEQUENCE SQ_BENEFITS_ID;
CREATE SEQUENCE SQ_BENEFITS_ID START WITH 1;

INSERT INTO BENEFITS VALUES(
    SQ_BENEFITS_ID.nextval, /*ID*/
	'Vale refeição'/*benefits*/
);

INSERT INTO BENEFITS VALUES(
    SQ_BENEFITS_ID.nextval, /*ID*/
	'Vale transporte'/*benefits*/
);

INSERT INTO BENEFITS VALUES(
    SQ_BENEFITS_ID.nextval, /*ID*/
	'Convênio médico'/*benefits*/
);

INSERT INTO BENEFITS VALUES(
    SQ_BENEFITS_ID.nextval, /*ID*/
	'Seguro de vida'/*benefits*/
);

INSERT INTO BENEFITS VALUES(
    SQ_BENEFITS_ID.nextval, /*ID*/
	'Convênio odontológico'/*benefits*/
);

