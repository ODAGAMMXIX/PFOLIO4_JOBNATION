DROP SEQUENCE SQ_SKILL_ID;
CREATE SEQUENCE SQ_SKILL_ID START WITH 1;

INSERT INTO SKILL VALUES(
    SQ_SKILL_ID.nextval, /*ID*/
	'10',/*LEVEL*/
    'HTML',/*NAME*/
    ''/*OTHERS*/
);

INSERT INTO SKILL VALUES(
    SQ_SKILL_ID.nextval, /*ID*/
	'10',/*LEVEL*/
    'CSS',/*NAME*/
    ''/*OTHERS*/
);

INSERT INTO SKILL VALUES(
    SQ_SKILL_ID.nextval, /*ID*/
	'8',/*LEVEL*/
    'JAVASCRIPT',/*NAME*/
    ''/*OTHERS*/
);

INSERT INTO SKILL VALUES(
    SQ_SKILL_ID.nextval, /*ID*/
	'6',/*LEVEL*/
    'PHP',/*NAME*/
    ''/*OTHERS*/
);

INSERT INTO SKILL VALUES(
    SQ_SKILL_ID.nextval, /*ID*/
	'8',/*LEVEL*/
    'REACT',/*NAME*/
    ''/*OTHERS*/
);

INSERT INTO SKILL VALUES(
    SQ_SKILL_ID.nextval, /*ID*/
	'8',/*LEVEL*/
    'Wordpress',/*NAME*/
    ''/*OTHERS*/
);

