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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Author}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Author
 * @generated
 */
public class AuthorWrapper
	extends BaseModelWrapper<Author> implements Author, ModelWrapper<Author> {

	public AuthorWrapper(Author author) {
		super(author);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("authorId", getAuthorId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("nom", getNom());
		attributes.put("prenom", getPrenom());
		attributes.put("email", getEmail());
		attributes.put("DateNaissance", getDateNaissance());
		attributes.put("dateDeces", getDateDeces());
		attributes.put("autobiographie", getAutobiographie());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String nom = (String)attributes.get("nom");

		if (nom != null) {
			setNom(nom);
		}

		String prenom = (String)attributes.get("prenom");

		if (prenom != null) {
			setPrenom(prenom);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Date DateNaissance = (Date)attributes.get("DateNaissance");

		if (DateNaissance != null) {
			setDateNaissance(DateNaissance);
		}

		Date dateDeces = (Date)attributes.get("dateDeces");

		if (dateDeces != null) {
			setDateDeces(dateDeces);
		}

		String autobiographie = (String)attributes.get("autobiographie");

		if (autobiographie != null) {
			setAutobiographie(autobiographie);
		}
	}

	/**
	 * Returns the author ID of this author.
	 *
	 * @return the author ID of this author
	 */
	@Override
	public long getAuthorId() {
		return model.getAuthorId();
	}

	/**
	 * Returns the autobiographie of this author.
	 *
	 * @return the autobiographie of this author
	 */
	@Override
	public String getAutobiographie() {
		return model.getAutobiographie();
	}

	/**
	 * Returns the company ID of this author.
	 *
	 * @return the company ID of this author
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the date deces of this author.
	 *
	 * @return the date deces of this author
	 */
	@Override
	public Date getDateDeces() {
		return model.getDateDeces();
	}

	/**
	 * Returns the date naissance of this author.
	 *
	 * @return the date naissance of this author
	 */
	@Override
	public Date getDateNaissance() {
		return model.getDateNaissance();
	}

	/**
	 * Returns the email of this author.
	 *
	 * @return the email of this author
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the group ID of this author.
	 *
	 * @return the group ID of this author
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the nom of this author.
	 *
	 * @return the nom of this author
	 */
	@Override
	public String getNom() {
		return model.getNom();
	}

	/**
	 * Returns the prenom of this author.
	 *
	 * @return the prenom of this author
	 */
	@Override
	public String getPrenom() {
		return model.getPrenom();
	}

	/**
	 * Returns the primary key of this author.
	 *
	 * @return the primary key of this author
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this author.
	 *
	 * @return the uuid of this author
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
	 * Sets the author ID of this author.
	 *
	 * @param authorId the author ID of this author
	 */
	@Override
	public void setAuthorId(long authorId) {
		model.setAuthorId(authorId);
	}

	/**
	 * Sets the autobiographie of this author.
	 *
	 * @param autobiographie the autobiographie of this author
	 */
	@Override
	public void setAutobiographie(String autobiographie) {
		model.setAutobiographie(autobiographie);
	}

	/**
	 * Sets the company ID of this author.
	 *
	 * @param companyId the company ID of this author
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the date deces of this author.
	 *
	 * @param dateDeces the date deces of this author
	 */
	@Override
	public void setDateDeces(Date dateDeces) {
		model.setDateDeces(dateDeces);
	}

	/**
	 * Sets the date naissance of this author.
	 *
	 * @param DateNaissance the date naissance of this author
	 */
	@Override
	public void setDateNaissance(Date DateNaissance) {
		model.setDateNaissance(DateNaissance);
	}

	/**
	 * Sets the email of this author.
	 *
	 * @param email the email of this author
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the group ID of this author.
	 *
	 * @param groupId the group ID of this author
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the nom of this author.
	 *
	 * @param nom the nom of this author
	 */
	@Override
	public void setNom(String nom) {
		model.setNom(nom);
	}

	/**
	 * Sets the prenom of this author.
	 *
	 * @param prenom the prenom of this author
	 */
	@Override
	public void setPrenom(String prenom) {
		model.setPrenom(prenom);
	}

	/**
	 * Sets the primary key of this author.
	 *
	 * @param primaryKey the primary key of this author
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this author.
	 *
	 * @param uuid the uuid of this author
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected AuthorWrapper wrap(Author author) {
		return new AuthorWrapper(author);
	}

}