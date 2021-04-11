DROP SEQUENCE SQ_CANDIDATE_PROFILE_ID;
CREATE SEQUENCE SQ_CANDIDATE_PROFILE_ID START WITH 1;

ALTER TABLE CANDIDATE_PROFILE MODIFY(
    CDT_MOBILE NUMBER(15),
	CDT_PHONE NUMBER(15)
);

INSERT INTO CANDIDATE_PROFILE VALUES(
    SQ_CANDIDATE_PROFILE_ID.nextval, /*ID*/
	TO_DATE('1992/06/20 12:00:00', 'yyyy/mm/dd hh:mi:ss'),/*BIRTHDAY*/
    '66237847057',/*CPF*/
    'rafael@teste.com', /*email*/
    'Rafael',/*Name*/
    'masculino',/*gender*/
    '',/*Joined*/
    'Solteiro', /*MARITAL*/
    'Estevam de Oliveira',/*MIDDLE*/
    12999999999,/*mobile*/
    1288888888,/*Phone*/
    '',/*surname*/
    1 /*Address ID*/
);

INSERT INTO CANDIDATE_PROFILE VALUES(
    SQ_CANDIDATE_PROFILE_ID.nextval, /*ID*/
	TO_DATE('1994/12/08 12:00:00', 'yyyy/mm/dd hh:mi:ss'),/*BIRTHDAY*/
    '05967499024',/*CPF*/
    'michelle@teste.com', /*email*/
    'Michelle',/*Name*/
    'feminino',/*gender*/
    '',/*Joined*/
    'Solteiro', /*MARITAL*/
    'Estevam de Oliveira',/*MIDDLE*/
    12777777777,/*mobile*/
    1266666666,/*Phone*/
    '',/*surname*/
    2 /*Address ID*/ 
);

INSERT INTO CANDIDATE_PROFILE VALUES(
    SQ_CANDIDATE_PROFILE_ID.nextval, /*ID*/
	TO_DATE('1994/12/14 12:00:00', 'yyyy/mm/dd hh:mi:ss'),/*BIRTHDAY*/
    '74383434053',/*CPF*/
    'julia@teste.com', /*email*/
    'Júlia',/*Name*/
    'feminino',/*gender*/
    '',/*Joined*/
    'Solteiro', /*MARITAL*/
    'Santos Pereira',/*MIDDLE*/
    12555555555,/*mobile*/
    1244444444,/*Phone*/
    '',/*surname*/
    5 /*Address ID*/
);

