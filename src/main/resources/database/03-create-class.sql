--liquibase formatted sql
--changeset skot:3
CREATE TABLE public.class
(
    id integer NOT NULL,
    level smallint NOT NULL,
    symbol character varying(10) COLLATE pg_catalog."default" NOT NULL,
    type character varying(1) COLLATE pg_catalog."default" NOT NULL,
    active boolean NOT NULL DEFAULT true,
    duration smallint NOT NULL,
    CONSTRAINT class_pkey PRIMARY KEY (id)
    )
    WITH (
        OIDS = FALSE
        )
    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.class
    OWNER to zastuser;

CREATE SEQUENCE IF NOT EXISTS public.class_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY class.id;

ALTER SEQUENCE public.class_id_seq
    OWNER TO zastuser;

ALTER TABLE IF EXISTS public.class
ALTER id SET DEFAULT nextval('class_id_seq'::regclass);