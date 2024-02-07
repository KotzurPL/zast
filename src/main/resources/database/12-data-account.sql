--liquibase formatted sql
--changeset skot:12
INSERT INTO public.account(email, password, active, id_person) VALUES ('sebastian.kot@lokw.pl', '', true, 57);