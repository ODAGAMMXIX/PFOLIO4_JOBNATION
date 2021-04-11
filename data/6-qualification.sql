DROP SEQUENCE SQ_QUALIFICATION_ID;
CREATE SEQUENCE SQ_QUALIFICATION_ID START WITH 1;

INSERT INTO QUALIFICATION VALUES(
    SQ_QUALIFICATION_ID.nextval, /*ID*/
	'', /*CORSE*/
    '', /*END*/
    'Fatec São José dos Campos', /*INSTITUTION*/
    'Superior',/*LEVEL*/
    'Banco de dados',/*NAME*/
    TO_DATE('2018/08/03 12:00:00', 'yyyy/mm/dd hh:mi:ss'),/*START*/
    'Cursando'/*STATUS*/
);

INSERT INTO QUALIFICATION VALUES(
    SQ_QUALIFICATION_ID.nextval, /*ID*/
	'', /*CORSE*/
    TO_DATE('2020/07/03 12:00:00', 'yyyy/mm/dd hh:mi:ss'), /*END*/
    'Saga Art São José dos Campos', /*INSTITUTION*/
    'Profissionalizante',/*LEVEL*/
    'START',/*NAME*/
    TO_DATE('2017/08/03 12:00:00', 'yyyy/mm/dd hh:mi:ss'),/*START*/
    'Concluido'/*STATUS*/
);