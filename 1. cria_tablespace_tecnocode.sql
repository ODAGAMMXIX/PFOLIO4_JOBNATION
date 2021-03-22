
CREATE TABLESPACE  tecnocode
DATAFILE  'C:\BD\tecnocode.dbf' SIZE 1M
AUTOEXTEND ON;
------------------
-- CRIA USU�RIO --
------------------
CREATE USER tecnocode
IDENTIFIED BY tecnocode
DEFAULT TABLESPACE tecnocode
TEMPORARY TABLESPACE TEMP
QUOTA UNLIMITED ON tecnocode;
-----------------
-- PRIVIL�GIOS --
-----------------
GRANT DBA TO tecnocode WITH ADMIN OPTION;

 


