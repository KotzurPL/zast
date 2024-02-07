--liquibase formatted sql
--changeset skot:10
INSERT INTO public.role(name, short_name) VALUES ('administrator', 'ADM');
INSERT INTO public.role(name, short_name) VALUES ('sekretariat', 'SEK');
INSERT INTO public.role(name, short_name) VALUES ('dyrektor', 'DYR');
INSERT INTO public.role(name, short_name) VALUES ('nauczyciel', 'NAU');
INSERT INTO public.role(name, short_name) VALUES ('uczeń', 'UCZ');