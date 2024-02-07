SELECT role.short_name
FROM account
         left join person_role on person_role.id_person = account.id_person
         left join role on id_role = role.id
WHERE account.email = 'sebastian.kot@lokw.pl'
;