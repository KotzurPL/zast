--liquibase formatted sql
--changeset skot:13
CREATE TABLE IF NOT EXISTS public.person_role
(
    id_person integer NOT NULL,
    id_role integer NOT NULL,
    CONSTRAINT person_role_pkey PRIMARY KEY (id_person, id_role),
    CONSTRAINT fk_person_role_person
        FOREIGN KEY(id_person)
            REFERENCES person(id),
    CONSTRAINT fk_person_role_role
        FOREIGN KEY(id_role)
            REFERENCES role(id)
)
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.person_role
    OWNER to zastuser;