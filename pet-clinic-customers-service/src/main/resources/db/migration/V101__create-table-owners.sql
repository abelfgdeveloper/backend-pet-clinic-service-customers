CREATE TABLE IF NOT EXISTS owners(
  id VARCHAR(50) NOT NULL,
  identification_document VARCHAR(9) NOT NULL,
  first_name VARCHAR(25) NOT NULL,
  last_name VARCHAR(25) NOT NULL,
  telephone VARCHAR(9) NULL,
  email VARCHAR(30) NOT NULL,
  audit_create_at TIMESTAMP NOT NULL,
  audit_update_at TIMESTAMP NULL,
  is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
  CONSTRAINT owners_id_pk PRIMARY KEY (id),
  CONSTRAINT owners_identification_document_u UNIQUE (identification_document)
);