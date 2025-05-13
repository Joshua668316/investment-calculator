CREATE EXTENSION IF NOT EXISTS timescaledb;

CREATE TABLE IF NOT EXISTS price (
    time        TIMESTAMPTZ NOT NULL,
    value       DOUBLE PRECISION     Null
);

SELECT create_hypertable('price', 'time', if_not_exists => TRUE);