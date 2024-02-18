--liquibase formatted sql
--changeset skot:15
CREATE TABLE IF NOT EXISTS public.substitution
(
    id bigint NOT NULL,
    substitution_date date NOT NULL,
    id_absent_teacher integer NOT NULL,
    id_hour integer NOT NULL,
    id_class integer NOT NULL,
    id_original_subject integer NOT NULL,
    id_substitute_teacher integer NOT NULL,
    id_target_subject integer NOT NULL,
    CONSTRAINT substitution_pkey
        PRIMARY KEY (id),
    CONSTRAINT fk_ih
        FOREIGN KEY (id_hour)
        REFERENCES public.hour (id),
    CONSTRAINT fk_ic
        FOREIGN KEY (id_class)
        REFERENCES public.class (id),
    CONSTRAINT fk_iat
        FOREIGN KEY (id_absent_teacher)
        REFERENCES public.person (id),
    CONSTRAINT fk_ist
        FOREIGN KEY (id_substitute_teacher)
        REFERENCES public.person (id),
    CONSTRAINT fk_its
        FOREIGN KEY (id_target_subject)
        REFERENCES public.subject (id),
    CONSTRAINT fk_ios
        FOREIGN KEY (id_original_subject)
        REFERENCES public.subject (id)
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.substitution
    OWNER to zastuser;

CREATE SEQUENCE IF NOT EXISTS public.substitution_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY substitution.id;

ALTER SEQUENCE public.substitution_id_seq
    OWNER TO zastuser;

ALTER TABLE IF EXISTS public.substitution
    ALTER id SET DEFAULT nextval('substitution_id_seq'::regclass);