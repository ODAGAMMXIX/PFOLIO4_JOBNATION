DROP SEQUENCE SQ_USERJN_ID;
CREATE SEQUENCE SQ_USERJN_ID START WITH 1;

INSERT INTO USERJN VALUES(
    SQ_USERJN_ID.nextval, /*ID*/
    'teste@teste.com',/*email*/
    'Rafael Estevam'/*name*/
);