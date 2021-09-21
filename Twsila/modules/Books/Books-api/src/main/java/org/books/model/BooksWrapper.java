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

package org.books.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Books}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Books
 * @generated
 */
public class BooksWrapper
	extends BaseModelWrapper<Books> implements Books, ModelWrapper<Books> {

	public BooksWrapper(Books books) {
		super(books);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("bookId", getBookId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("title", getTitle());
		attributes.put("authorId", getAuthorId());
		attributes.put("conte_rendu", getConte_rendu());
		attributes.put("createDate", getCreateDate());
		attributes.put("datePublication", getDatePublication());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("prixAchat", getPrixAchat());
		attributes.put("prixVente", getPrixVente());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long bookId = (Long)attributes.get("bookId");

		if (bookId != null) {
			setBookId(bookId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String authorId = (String)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
		}

		String conte_rendu = (String)attributes.get("conte_rendu");

		if (conte_rendu != null) {
			setConte_rendu(conte_rendu);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date datePublication = (Date)attributes.get("datePublication");

		if (datePublication != null) {
			setDatePublication(datePublication);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Double prixAchat = (Double)attributes.get("prixAchat");

		if (prixAchat != null) {
			setPrixAchat(prixAchat);
		}

		Double prixVente = (Double)attributes.get("prixVente");

		if (prixVente != null) {
			setPrixVente(prixVente);
		}
	}

	/**
	 * Returns the author ID of this books.
	 *
	 * @return the author ID of this books
	 */
	@Override
	public String getAuthorId() {
		return model.getAuthorId();
	}

	/**
	 * Returns the book ID of this books.
	 *
	 * @return the book ID of this books
	 */
	@Override
	public long getBookId() {
		return model.getBookId();
	}

	/**
	 * Returns the company ID of this books.
	 *
	 * @return the company ID of this books
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the conte_rendu of this books.
	 *
	 * @return the conte_rendu of this books
	 */
	@Override
	public String getConte_rendu() {
		return model.getConte_rendu();
	}

	/**
	 * Returns the create date of this books.
	 *
	 * @return the create date of this books
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the date publication of this books.
	 *
	 * @return the date publication of this books
	 */
	@Override
	public Date getDatePublication() {
		return model.getDatePublication();
	}

	/**
	 * Returns the group ID of this books.
	 *
	 * @return the group ID of this books
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this books.
	 *
	 * @return the modified date of this books
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this books.
	 *
	 * @return the primary key of this books
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the prix achat of this books.
	 *
	 * @return the prix achat of this books
	 */
	@Override
	public double getPrixAchat() {
		return model.getPrixAchat();
	}

	/**
	 * Returns the prix vente of this books.
	 *
	 * @return the prix vente of this books
	 */
	@Override
	public double getPrixVente() {
		return model.getPrixVente();
	}

	/**
	 * Returns the title of this books.
	 *
	 * @return the title of this books
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this books.
	 *
	 * @return the user ID of this books
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this books.
	 *
	 * @return the user uuid of this books
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this books.
	 *
	 * @return the uuid of this books
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the author ID of this books.
	 *
	 * @param authorId the author ID of this books
	 */
	@Override
	public void setAuthorId(String authorId) {
		model.setAuthorId(authorId);
	}

	/**
	 * Sets the book ID of this books.
	 *
	 * @param bookId the book ID of this books
	 */
	@Override
	public void setBookId(long bookId) {
		model.setBookId(bookId);
	}

	/**
	 * Sets the company ID of this books.
	 *
	 * @param companyId the company ID of this books
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the conte_rendu of this books.
	 *
	 * @param conte_rendu the conte_rendu of this books
	 */
	@Override
	public void setConte_rendu(String conte_rendu) {
		model.setConte_rendu(conte_rendu);
	}

	/**
	 * Sets the create date of this books.
	 *
	 * @param createDate the create date of this books
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the date publication of this books.
	 *
	 * @param datePublication the date publication of this books
	 */
	@Override
	public void setDatePublication(Date datePublication) {
		model.setDatePublication(datePublication);
	}

	/**
	 * Sets the group ID of this books.
	 *
	 * @param groupId the group ID of this books
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this books.
	 *
	 * @param modifiedDate the modified date of this books
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this books.
	 *
	 * @param primaryKey the primary key of this books
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the prix achat of this books.
	 *
	 * @param prixAchat the prix achat of this books
	 */
	@Override
	public void setPrixAchat(double prixAchat) {
		model.setPrixAchat(prixAchat);
	}

	/**
	 * Sets the prix vente of this books.
	 *
	 * @param prixVente the prix vente of this books
	 */
	@Override
	public void setPrixVente(double prixVente) {
		model.setPrixVente(prixVente);
	}

	/**
	 * Sets the title of this books.
	 *
	 * @param title the title of this books
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this books.
	 *
	 * @param userId the user ID of this books
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this books.
	 *
	 * @param userUuid the user uuid of this books
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this books.
	 *
	 * @param uuid the uuid of this books
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected BooksWrapper wrap(Books books) {
		return new BooksWrapper(books);
	}

}