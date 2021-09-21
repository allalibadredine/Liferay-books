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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.books.service.http.AuthorServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class AuthorSoap implements Serializable {

	public static AuthorSoap toSoapModel(Author model) {
		AuthorSoap soapModel = new AuthorSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAuthorId(model.getAuthorId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setNom(model.getNom());
		soapModel.setPrenom(model.getPrenom());
		soapModel.setEmail(model.getEmail());
		soapModel.setDateNaissance(model.getDateNaissance());
		soapModel.setDateDeces(model.getDateDeces());
		soapModel.setAutobiographie(model.getAutobiographie());

		return soapModel;
	}

	public static AuthorSoap[] toSoapModels(Author[] models) {
		AuthorSoap[] soapModels = new AuthorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AuthorSoap[][] toSoapModels(Author[][] models) {
		AuthorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AuthorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AuthorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AuthorSoap[] toSoapModels(List<Author> models) {
		List<AuthorSoap> soapModels = new ArrayList<AuthorSoap>(models.size());

		for (Author model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AuthorSoap[soapModels.size()]);
	}

	public AuthorSoap() {
	}

	public long getPrimaryKey() {
		return _authorId;
	}

	public void setPrimaryKey(long pk) {
		setAuthorId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAuthorId() {
		return _authorId;
	}

	public void setAuthorId(long authorId) {
		_authorId = authorId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getNom() {
		return _nom;
	}

	public void setNom(String nom) {
		_nom = nom;
	}

	public String getPrenom() {
		return _prenom;
	}

	public void setPrenom(String prenom) {
		_prenom = prenom;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public Date getDateNaissance() {
		return _DateNaissance;
	}

	public void setDateNaissance(Date DateNaissance) {
		_DateNaissance = DateNaissance;
	}

	public Date getDateDeces() {
		return _dateDeces;
	}

	public void setDateDeces(Date dateDeces) {
		_dateDeces = dateDeces;
	}

	public String getAutobiographie() {
		return _autobiographie;
	}

	public void setAutobiographie(String autobiographie) {
		_autobiographie = autobiographie;
	}

	private String _uuid;
	private long _authorId;
	private long _groupId;
	private long _companyId;
	private String _nom;
	private String _prenom;
	private String _email;
	private Date _DateNaissance;
	private Date _dateDeces;
	private String _autobiographie;

}