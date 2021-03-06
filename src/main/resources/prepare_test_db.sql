CREATE SCHEMA IF NOT EXISTS IRBIS;

DROP TABLE IF EXISTS IRBIS.SL_NP;

CREATE TABLE IRBIS.SL_NP
(
  ID NUMBER(18,0) NOT NULL,
  RECORD_ID VARCHAR2(15),
  CLI_ID VARCHAR2(15),
  INN VARCHAR2(24),
  SLTYPE NUMBER(5,0),
  ISTER NUMBER(5,0),
  SLCODE NUMBER(5,0),
  DOC_ID VARCHAR2(15),
  FAMILY VARCHAR2(1024),
  NAME VARCHAR2(50),
  SNAME VARCHAR2(50),
  ENGFAMILY VARCHAR2(1024),
  ENGNAME VARCHAR2(50),
  ENGSNAME VARCHAR2(50),
  TYPE_DOC NUMBER(5,0),
  SNAM VARCHAR2(120),
  ORGAN_DOC VARCHAR2(256),
  SERIES VARCHAR2(20),
  NUMBER_ VARCHAR2(25),
  NUMBER_END VARCHAR2(25),
  STATUS_DOC NUMBER(5,0),
  BIRTHDATE DATE,
  MR VARCHAR2(254),
  ADDINF VARCHAR2(512),
  AMODIFYTIME TIMESTAMP (6)
);

DROP TABLE IF EXISTS IRBIS.PB_DOCUMENT;

CREATE TABLE IRBIS.PB_DOCUMENT
(
  ID NUMBER(9,0) NOT NULL,
  CODE NUMBER(10,0),
  DOCUMENT VARCHAR2(80),
  KODNALOG NUMBER(4,0),
  LUSER NUMBER(10,0),
  LNUM NUMBER(10,0),
  SHABLON VARCHAR2(40),
  BEG DATE,
  END_ DATE,
  END_D DATE,
  CODE_BR NUMBER(10,0),
  AMODIFYTIME TIMESTAMP (6)
);