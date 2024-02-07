--liquibase formatted sql
--changeset skot:11
CREATE TABLE IF NOT EXISTS public.account
(
    id integer NOT NULL,
    email character varying(50) COLLATE pg_catalog."default" NOT NULL,
    password character varying(100) COLLATE pg_catalog."default" NOT NULL,
    active boolean NOT NULL DEFAULT false,
    id_person integer NOT NULL,
    CONSTRAINT account_pkey PRIMARY KEY (id),
    CONSTRAINT fk_account_person
        FOREIGN KEY(id_person)
            REFERENCES person(id)
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.account
    OWNER to zastuser;

CREATE SEQUENCE IF NOT EXISTS public.account_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY account.id;

ALTER SEQUENCE public.account_id_seq
    OWNER TO zastuser;

ALTER TABLE IF EXISTS public.account
    ALTER id SET DEFAULT nextval('account_id_seq'::regclass);