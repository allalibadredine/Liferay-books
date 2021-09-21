create index IX_EDD584F6 on Books_Author (nom[$COLUMN_LENGTH:75$]);
create index IX_672FAD43 on Books_Author (prenom[$COLUMN_LENGTH:75$]);
create index IX_683AA93A on Books_Author (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_1CF0363C on Books_Author (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_E94AAD5 on Books_Books (authorId[$COLUMN_LENGTH:75$]);
create index IX_EE38738D on Books_Books (title[$COLUMN_LENGTH:75$]);
create index IX_38657855 on Books_Books (userId);
create index IX_27997C4F on Books_Books (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_7EA2CA91 on Books_Books (uuid_[$COLUMN_LENGTH:75$], groupId);