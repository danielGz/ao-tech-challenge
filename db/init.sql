-- init.sql
CREATE TABLE IF NOT EXISTS Product (
        id SERIAL PRIMARY KEY,
        name VARCHAR(255),
        price FLOAT,
        description TEXT);

CREATE TABLE IF NOT EXISTS "Order" (
    id SERIAL PRIMARY KEY,
    product_id INT,
    quantity INT,
    status VARCHAR(50) CHECK (status IN ('pending', 'completed', 'cancelled')),
    last_updated TIMESTAMP,
    FOREIGN KEY (product_id) REFERENCES Product(id));

CREATE TABLE IF NOT EXISTS OrderItem (
     id SERIAL PRIMARY KEY,
     order_id INT,
     product_id INT,
     quantity INT,
     price FLOAT,
     FOREIGN KEY (order_id) REFERENCES "Order"(id),
    FOREIGN KEY (product_id) REFERENCES Product(id));
