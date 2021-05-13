DROP SEQUENCE SQ_ADDRESS_ID;
CREATE SEQUENCE SQ_ADDRESS_ID START WITH 1;

/*ALTERAR TIPO DE DADO LAT, LONG para FLOAT*/
ALTER TABLE ADDRESS MODIFY(
    ADR_LAT FLOAT(22),
	ADR_LONG FLOAT(22)
);

INSERT INTO ADDRESS VALUES(
    SQ_ADDRESS_ID.nextval, /*ID*/
    12225430,/*CEP*/
    'S�o Jos� dos Campos',/*CITY*/
    'Brasil',/*COUNTRY*/
    'Rua Professora Maria Jos� de Oliveira',/*DETAIL*/
    /*Faltou tabela complemento*/
    'Nova Michigan',/*HOOD*/
    -23.20051 ,/*LAT*/
    -45.78417,/*LONG*/
    '136',/*NUM*/
    'SP',/*STATE*/
    'S�o Paulo'/*ST_NAME*/
);

INSERT INTO ADDRESS VALUES(
    SQ_ADDRESS_ID.nextval, /*ID*/
    12226160,/*CEP*/
    'S�o Jos� dos Campos',/*CITY*/
    'Brasil',/*COUNTRY*/
    'Rua Jos� Castrioto',/*DETAIL*/
    /*Faltou tabela complemento*/
    'Parque Nova Esperan�a',/*HOOD*/
    -23.1986661 ,/*LAT*/
    -45.7892607,/*LONG*/
    '127',/*NUM*/
    'SP',/*STATE*/
    'S�o Paulo'/*ST_NAME*/
);

INSERT INTO ADDRESS VALUES(
    SQ_ADDRESS_ID.nextval, /*ID*/
    12230001,/*CEP*/
    'S�o Jos� dos Campos',/*CITY*/
    'Brasil',/*COUNTRY*/
    'Av. Andr�meda',/*DETAIL*/
    /*Faltou tabela complemento*/
    'Jardim Sat�lite',/*HOOD*/
    -23.2237623 ,/*LAT*/
    -45.8876979,/*LONG*/
    '1162',/*NUM*/
    'SP',/*STATE*/
    'S�o Paulo'/*ST_NAME*/
);

INSERT INTO ADDRESS VALUES(
    SQ_ADDRESS_ID.nextval, /*ID*/
    05425070,/*CEP*/
    'S�o Paulo',/*CITY*/
    'Brasil',/*COUNTRY*/
    'Av. das Na��es Unidas',/*DETAIL*/
    /*Faltou tabela complemento*/
    'Ch�cara Itaim',/*HOOD*/
    -23.5872576 ,/*LAT*/
    -46.6905922,/*LONG*/
    '2500',/*NUM*/
    'SP',/*STATE*/
    'S�o Paulo'/*ST_NAME*/
);

INSERT INTO ADDRESS VALUES(
    SQ_ADDRESS_ID.nextval, /*ID*/
    01311925,/*CEP*/
    'S�o Paulo',/*CITY*/
    'Brasil',/*COUNTRY*/
    'Av. Paulista',/*DETAIL*/
    /*Faltou tabela complemento*/
    'Bela Vista',/*HOOD*/
    -23.5628312,/*LAT*/
    -46.6552963,/*LONG*/
    '1415',/*NUM*/
    'SP',/*STATE*/
    'S�o Paulo'/*ST_NAME*/
);

INSERT INTO ADDRESS VALUES(
    SQ_ADDRESS_ID.nextval, /*ID*/
    12247014,/*CEP*/
    'S�o Jos� dos Campos',/*CITY*/
    'Brasil',/*COUNTRY*/
    'Avenida Cesare Monsueto Giulio Lattes',/*DETAIL*/
    /*Faltou tabela complemento*/
    'Jardim Santa Ines I',/*HOOD*/
    -23.1621987,/*LAT*/
    -45.7952995,/*LONG*/
    '1350',/*NUM*/
    'SP',/*STATE*/
    'S�o Paulo'/*ST_NAME*/
);