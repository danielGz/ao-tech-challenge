
CREATE TABLE Product (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(255),
                         price FLOAT,
                         description TEXT
);
CREATE TABLE OrderItem (
                           id BIGSERIAL PRIMARY KEY,
                           purchase_order_id BIGINT,
                           product_id BIGINT,
                           quantity INTEGER,
                           price FLOAT,
                           FOREIGN KEY (purchase_order_id) REFERENCES PurchaseOrder(id),
                           FOREIGN KEY (product_id) REFERENCES Product(id)
);
CREATE TABLE PurchaseOrder (
                               id BIGSERIAL PRIMARY KEY,
                               status VARCHAR(50),
                               last_updated TIMESTAMP WITH TIME ZONE,
);
CREATE TABLE PurchaseOrderItems (
                                    purchase_order_id BIGINT,
                                    order_item_id BIGINT,
                                    PRIMARY KEY (purchase_order_id, order_item_id),
                                    FOREIGN KEY (purchase_order_id) REFERENCES PurchaseOrder(id),
                                    FOREIGN KEY (order_item_id) REFERENCES OrderItem(id)
);
