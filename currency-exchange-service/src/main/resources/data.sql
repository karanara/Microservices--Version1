drop table currency_exchange if exists;
CREATE TABLE currency_exchange (
    id INT PRIMARY KEY,
    currency_from VARCHAR(3),
    currency_to VARCHAR(3),
    conversion_multiple DECIMAL(10, 2),
    port INT
);

-- Insert your data
INSERT INTO currency_exchange (id, currency_from, currency_to, conversion_multiple, port) VALUES (1001, 'USD', 'INR', 68.00, 0);
INSERT INTO currency_exchange (id, currency_from, currency_to, conversion_multiple, port) VALUES (1002, 'EUR', 'INR', 78.00, 0);
INSERT INTO currency_exchange (id, currency_from, currency_to, conversion_multiple, port) VALUES (1003, 'AED', 'INR', 88.00, 0);
