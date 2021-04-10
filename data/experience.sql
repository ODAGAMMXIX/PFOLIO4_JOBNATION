DROP SEQUENCE SQ_EXPERIENCE_ID;
CREATE SEQUENCE SQ_EXPERIENCE_ID START WITH 1;

INSERT INTO EXPERIENCE VALUES(
    SQ_EXPERIENCE_ID.nextval, /*ID*/
	'', /*ARCHIEV*/
    'São José dos Campos', /*City*/
    'Gauge', /*Company*/
    TO_DATE('2021/02/05 12:00:00', 'yyyy/mm/dd hh:mi:ss'), /*End*/
    TO_DATE('2019/02/11 12:00:00', 'yyyy/mm/dd hh:mi:ss'), /*Start*/
    'Desenvolvedor Front End Pleno'/*Title*/
);

INSERT INTO EXPERIENCE VALUES(
    SQ_EXPERIENCE_ID.nextval, /*ID*/
	'', /*ARCHIEV*/
    'São José dos Campos', /*City*/
    'Univalle Sistemas', /*Company*/
    TO_DATE('2017/01/04 12:00:00', 'yyyy/mm/dd hh:mi:ss'), /*End*/
    TO_DATE('2019/01/31 12:00:00', 'yyyy/mm/dd hh:mi:ss'), /*Start*/
    'Desenvolvedor Web'/*Title*/
);