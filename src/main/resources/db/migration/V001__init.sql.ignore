
CREATE TABLE admins (
    id integer NOT NULL,
    email character varying(255),
    password_hash character varying(255),
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    receive_emails boolean DEFAULT true NOT NULL
);

CREATE SEQUENCE admins_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

