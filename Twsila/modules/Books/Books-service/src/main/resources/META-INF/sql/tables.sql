create table Books_Author (
	uuid_ VARCHAR(75) null,
	authorId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	nom VARCHAR(75) null,
	prenom VARCHAR(75) null,
	email VARCHAR(75) null,
	DateNaissance DATE null,
	dateDeces DATE null,
	autobiographie VARCHAR(75) null
);

create table Books_Books (
	uuid_ VARCHAR(75) null,
	bookId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	title VARCHAR(75) null,
	authorId VARCHAR(75) null,
	conte_rendu VARCHAR(75) null,
	createDate DATE null,
	datePublication DATE null,
	modifiedDate DATE null,
	prixAchat DOUBLE,
	prixVente DOUBLE
);