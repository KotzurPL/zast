--liquibase formatted sql
--changeset skot:9
CREATE TABLE IF NOT EXISTS public.role
(
    id integer NOT NULL,
    name character varying(45) COLLATE pg_catalog."default" NOT NULL,
    short_name character varying(5) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT role_pkey PRIMARY KEY (id)
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.role
    OWNER to zastuser;

CREATE SEQUENCE IF NOT EXISTS public.role_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY role.id;

ALTER SEQUENCE public.role_id_seq
    OWNER TO zastuser;

ALTER TABLE IF EXISTS public.role
    ALTER id SET DEFAULT nextval('role_id_seq'::regclass);