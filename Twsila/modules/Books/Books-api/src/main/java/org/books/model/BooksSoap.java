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
 * This class is used by SOAP remote services, specifically {@link org.books.service.http.BooksServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class BooksSoap implements Serializable {

	public static BooksSoap toSoapModel(Books model) {
		BooksSoap soapModel = new BooksSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setBookId(model.getBookId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setTitle(model.getTitle());
		soapModel.setAuthorId(model.getAuthorId());
		soapModel.setConte_rendu(model.getConte_rendu());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setDatePublication(model.getDatePublication());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPrixAchat(model.getPrixAchat());
		soapModel.setPrixVente(model.getPrixVente());

		return soapModel;
	}

	public static BooksSoap[] toSoapModels(Books[] models) {
		BooksSoap[] soapModels = new BooksSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BooksSoap[][] toSoapModels(Books[][] models) {
		BooksSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BooksSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BooksSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BooksSoap[] toSoapModels(List<Books> models) {
		List<BooksSoap> soapModels = new ArrayList<BooksSoap>(models.size());

		for (Books model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BooksSoap[soapModels.size()]);
	}

	public BooksSoap() {
	}

	public long getPrimaryKey() {
		return _bookId;
	}

	public void setPrimaryKey(long pk) {
		setBookId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getBookId() {
		return _bookId;
	}

	public void setBookId(long bookId) {
		_bookId = bookId;
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getAuthorId() {
		return _authorId;
	}

	public void setAuthorId(String authorId) {
		_authorId = authorId;
	}

	public String getConte_rendu() {
		return _conte_rendu;
	}

	public void setConte_rendu(String conte_rendu) {
		_conte_rendu = conte_rendu;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getDatePublication() {
		return _datePublication;
	}

	public void setDatePublication(Date datePublication) {
		_datePublication = datePublication;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public double getPrixAchat() {
		return _prixAchat;
	}

	public void setPrixAchat(double prixAchat) {
		_prixAchat = prixAchat;
	}

	public double getPrixVente() {
		return _prixVente;
	}

	public void setPrixVente(double prixVente) {
		_prixVente = prixVente;
	}

	private String _uuid;
	private long _bookId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _title;
	private String _authorId;
	private String _conte_rendu;
	private Date _createDate;
	private Date _datePublication;
	private Date _modifiedDate;
	private double _prixAchat;
	private double _prixVente;

}