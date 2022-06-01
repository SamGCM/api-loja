CREATE TABLE IF NOT EXISTS produto (
    id SERIAL NOT NULL,
    code CHARACTER VARYING(255),
    name VARCHAR(255),
    price BIGINT,
    units INTEGER,
    PRIMARY KEY (id)
);