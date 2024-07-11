CREATE TABLE public.product (
                                id int8 NOT NULL,
                                description varchar(255) NULL,
                                "name" varchar(255) NULL,
                                price float4 NULL,
                                CONSTRAINT product_pkey PRIMARY KEY (id)
);
CREATE TABLE public.purchase_order (
                                       id int8 NOT NULL,
                                       last_updated timestamptz(6) NULL,
                                       status int2 NULL,
                                       CONSTRAINT purchase_order_pkey PRIMARY KEY (id),
                                       CONSTRAINT purchase_order_status_check CHECK (((status >= 0) AND (status <= 2)))
);
CREATE TABLE public.order_item (
                                   id int8 NOT NULL,
                                   price float4 NULL,
                                   product_id int8 NULL,
                                   quantity int4 NULL,
                                   purchase_order_id int8 NULL,
                                   CONSTRAINT order_item_pkey PRIMARY KEY (id)
);
-- Foreign key constraint to reference purchase_order
ALTER TABLE public.order_item
    ADD CONSTRAINT order_item_references_purchase_order
        FOREIGN KEY (purchase_order_id) REFERENCES public.purchase_order(id);

-- Foreign key constraint to reference product
ALTER TABLE public.order_item
    ADD CONSTRAINT order_item_references_product
        FOREIGN KEY (product_id) REFERENCES public.product(id);