--liquibase formatted sql
--changeset skot:5
CREATE TABLE IF NOT EXISTS public.person
(
    id bigint NOT NULL,
    last_name character varying(30) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(15) COLLATE pg_catalog."default" NOT NULL,
    second_name character varying(15) COLLATE pg_catalog."default",
    short_name character varying(7) COLLATE pg_catalog."default",
    CONSTRAINT person_pkey PRIMARY KEY (id)
    )
    WITH (
        OIDS = FALSE
        )
    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.person
    OWNER to zastuser;

CREATE SEQUENCE IF NOT EXISTS public.person_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY person.id;

ALTER SEQUENCE public.person_id_seq
    OWNER TO zastuser;

ALTER TABLE IF EXISTS public.person
ALTER id SET DEFAULT nextval('person_id_seq'::regclass);