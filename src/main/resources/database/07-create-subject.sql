--liquibase formatted sql
--changeset skot:7
CREATE TABLE IF NOT EXISTS public.subject
(
    id integer NOT NULL,
    name character varying(45) COLLATE pg_catalog."default" NOT NULL,
    short_name character varying(7) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT subject_pkey PRIMARY KEY (id)
    )
    WITH (
        OIDS = FALSE
        )
    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.subject
    OWNER to zastuser;

CREATE SEQUENCE IF NOT EXISTS public.subject_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY subject.id;

ALTER SEQUENCE public.subject_id_seq
    OWNER TO zastuser;

ALTER TABLE IF EXISTS public.subject
ALTER id SET DEFAULT nextval('subject_id_seq'::regclass);