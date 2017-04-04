CREATE TABLE IF NOT EXISTS PRODUTO (
	IDPROD  INT         AUTO_INCREMENT PRIMARY KEY,
	DESPROD VARCHAR(30)                NOT NULL,
	STATUS  CHAR(1)                    NOT NULL,
	VALUNIT DECIMAL(15,5)              NOT NULL
);

CREATE TABLE IF NOT EXISTS CARRINHO (
	IDCAR     INT           AUTO_INCREMENT PRIMARY KEY,
	VALTOTCAR DECIMAL(15,5)                NOT NULL,
	IDCLI     INT                          NOT NULL,
	TIPPAGTO  CHAR(1)
);

CREATE TABLE IF NOT EXISTS ITEMCAR (
	IDCAR   INT                   ,
	NUMITEM INT                   ,
	IDPROD  INT           NOT NULL,
	QTDITEM INT           NOT NULL,
	VALITEM DECIMAL(15,5) NOT NULL,
	PRIMARY KEY (IDCAR, NUMITEM)
);

CREATE TABLE IF NOT EXISTS USUARIO (
	IDUSR     INT         AUTO_INCREMENT PRIMARY KEY, 
	NICKUSR   VARCHAR(10) UNIQUE         NOT NULL,
	CPFCNPJ   VARCHAR(14) 				 NOT NULL,
	CEPUSR    VARCHAR(10)  				 NOT NULL,
	ENDUSR    VARCHAR(70)  				 NOT NULL,
	NUMENDUSR VARCHAR(8)  				 NOT NULL,
	EMAILUSR  VARCHAR(50) 				 NOT NULL,
	TELUSR    VARCHAR(20) 				 NOT NULL,
	SENHA     VARCHAR(20)  				 NOT NULL,
	NOME      VARCHAR(70)  				 NOT NULL,
	ULTACESSO DATETIME					         ,
	TIPUSR    CHAR(1)    --DEFAULT VALUE 'U'
);