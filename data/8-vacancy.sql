DROP SEQUENCE SQ_VACANCY_ID;
CREATE SEQUENCE SQ_VACANCY_ID START WITH 1;

ALTER TABLE VACANCY MODIFY(
    VCY_DESCRIPTION VARCHAR(400),
	VCY_TITLE VARCHAR(200)
);

INSERT INTO VACANCY VALUES(
    SQ_VACANCY_ID.nextval, /*ID*/
	TO_DATE('2021/05/01 12:00:00', 'yyyy/mm/dd hh:mi:ss'),/*close in date*/
    0,/*contract*/
    'Desenvolvimento de frontend, desenvolvimento de backend', /*description*/
    10000.00,
    3000.00,
    TO_DATE('2021/04/01 12:00:00', 'yyyy/mm/dd hh:mi:ss'),/*open in date*/
    'Desenvolvedor Full-stack', /*Title*/
    6,/*Address*/
    1,/*Company*/
    1/*User*/
);

