/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.books.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.books.model.Books;

/**
 * The cache model class for representing Books in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BooksCacheModel implements CacheModel<Books>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BooksCacheModel)) {
			return false;
		}

		BooksCacheModel booksCacheModel = (BooksCacheModel)object;

		if (bookId == booksCacheModel.bookId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bookId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", bookId=");
		sb.append(bookId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", authorId=");
		sb.append(authorId);
		sb.append(", conte_rendu=");
		sb.append(conte_rendu);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", datePublication=");
		sb.append(datePublication);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", prixAchat=");
		sb.append(prixAchat);
		sb.append(", prixVente=");
		sb.append(prixVente);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Books toEntityModel() {
		BooksImpl booksImpl = new BooksImpl();

		if (uuid == null) {
			booksImpl.setUuid("");
		}
		else {
			booksImpl.setUuid(uuid);
		}

		booksImpl.setBookId(bookId);
		booksImpl.setGroupId(groupId);
		booksImpl.setCompanyId(companyId);
		booksImpl.setUserId(userId);

		if (title == null) {
			booksImpl.setTitle("");
		}
		else {
			booksImpl.setTitle(title);
		}

		if (authorId == null) {
			booksImpl.setAuthorId("");
		}
		else {
			booksImpl.setAuthorId(authorId);
		}

		if (conte_rendu == null) {
			booksImpl.setConte_rendu("");
		}
		else {
			booksImpl.setConte_rendu(conte_rendu);
		}

		if (createDate == Long.MIN_VALUE) {
			booksImpl.setCreateDate(null);
		}
		else {
			booksImpl.setCreateDate(new Date(createDate));
		}

		if (datePublication == Long.MIN_VALUE) {
			booksImpl.setDatePublication(null);
		}
		else {
			booksImpl.setDatePublication(new Date(datePublication));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			booksImpl.setModifiedDate(null);
		}
		else {
			booksImpl.setModifiedDate(new Date(modifiedDate));
		}

		booksImpl.setPrixAchat(prixAchat);
		booksImpl.setPrixVente(prixVente);

		booksImpl.resetOriginalValues();

		return booksImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		bookId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		title = objectInput.readUTF();
		authorId = objectInput.readUTF();
		conte_rendu = objectInput.readUTF();
		createDate = objectInput.readLong();
		datePublication = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		prixAchat = objectInput.readDouble();

		prixVente = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(bookId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (authorId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(authorId);
		}

		if (conte_rendu == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(conte_rendu);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(datePublication);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeDouble(prixAchat);

		objectOutput.writeDouble(prixVente);
	}

	public String uuid;
	public long bookId;
	public long groupId;
	public long companyId;
	public long userId;
	public String title;
	public String authorId;
	public String conte_rendu;
	public long createDate;
	public long datePublication;
	public long modifiedDate;
	public double prixAchat;
	public double prixVente;

}