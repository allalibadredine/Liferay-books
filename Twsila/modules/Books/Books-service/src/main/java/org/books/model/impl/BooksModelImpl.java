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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.books.model.Books;
import org.books.model.BooksModel;
import org.books.model.BooksSoap;

/**
 * The base model implementation for the Books service. Represents a row in the &quot;Books_Books&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>BooksModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BooksImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BooksImpl
 * @generated
 */
@JSON(strict = true)
public class BooksModelImpl extends BaseModelImpl<Books> implements BooksModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a books model instance should use the <code>Books</code> interface instead.
	 */
	public static final String TABLE_NAME = "Books_Books";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"bookId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"title", Types.VARCHAR},
		{"authorId", Types.VARCHAR}, {"conte_rendu", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"datePublication", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"prixAchat", Types.DOUBLE},
		{"prixVente", Types.DOUBLE}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("bookId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("authorId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("conte_rendu", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("datePublication", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("prixAchat", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("prixVente", Types.DOUBLE);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Books_Books (uuid_ VARCHAR(75) null,bookId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,title VARCHAR(75) null,authorId VARCHAR(75) null,conte_rendu VARCHAR(75) null,createDate DATE null,datePublication DATE null,modifiedDate DATE null,prixAchat DOUBLE,prixVente DOUBLE)";

	public static final String TABLE_SQL_DROP = "drop table Books_Books";

	public static final String ORDER_BY_JPQL = " ORDER BY books.title ASC";

	public static final String ORDER_BY_SQL = " ORDER BY Books_Books.title ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long AUTHORID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TITLE_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long USERID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static Books toModel(BooksSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Books model = new BooksImpl();

		model.setUuid(soapModel.getUuid());
		model.setBookId(soapModel.getBookId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setTitle(soapModel.getTitle());
		model.setAuthorId(soapModel.getAuthorId());
		model.setConte_rendu(soapModel.getConte_rendu());
		model.setCreateDate(soapModel.getCreateDate());
		model.setDatePublication(soapModel.getDatePublication());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setPrixAchat(soapModel.getPrixAchat());
		model.setPrixVente(soapModel.getPrixVente());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<Books> toModels(BooksSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Books> models = new ArrayList<Books>(soapModels.length);

		for (BooksSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public BooksModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _bookId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBookId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bookId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Books.class;
	}

	@Override
	public String getModelClassName() {
		return Books.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Books, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Books, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Books, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Books)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Books, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Books, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Books)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Books, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Books, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Books>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Books.class.getClassLoader(), Books.class, ModelWrapper.class);

		try {
			Constructor<Books> constructor =
				(Constructor<Books>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<Books, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Books, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Books, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Books, Object>>();
		Map<String, BiConsumer<Books, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Books, ?>>();

		attributeGetterFunctions.put("uuid", Books::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Books, String>)Books::setUuid);
		attributeGetterFunctions.put("bookId", Books::getBookId);
		attributeSetterBiConsumers.put(
			"bookId", (BiConsumer<Books, Long>)Books::setBookId);
		attributeGetterFunctions.put("groupId", Books::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Books, Long>)Books::setGroupId);
		attributeGetterFunctions.put("companyId", Books::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Books, Long>)Books::setCompanyId);
		attributeGetterFunctions.put("userId", Books::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Books, Long>)Books::setUserId);
		attributeGetterFunctions.put("title", Books::getTitle);
		attributeSetterBiConsumers.put(
			"title", (BiConsumer<Books, String>)Books::setTitle);
		attributeGetterFunctions.put("authorId", Books::getAuthorId);
		attributeSetterBiConsumers.put(
			"authorId", (BiConsumer<Books, String>)Books::setAuthorId);
		attributeGetterFunctions.put("conte_rendu", Books::getConte_rendu);
		attributeSetterBiConsumers.put(
			"conte_rendu", (BiConsumer<Books, String>)Books::setConte_rendu);
		attributeGetterFunctions.put("createDate", Books::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Books, Date>)Books::setCreateDate);
		attributeGetterFunctions.put(
			"datePublication", Books::getDatePublication);
		attributeSetterBiConsumers.put(
			"datePublication",
			(BiConsumer<Books, Date>)Books::setDatePublication);
		attributeGetterFunctions.put("modifiedDate", Books::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate", (BiConsumer<Books, Date>)Books::setModifiedDate);
		attributeGetterFunctions.put("prixAchat", Books::getPrixAchat);
		attributeSetterBiConsumers.put(
			"prixAchat", (BiConsumer<Books, Double>)Books::setPrixAchat);
		attributeGetterFunctions.put("prixVente", Books::getPrixVente);
		attributeSetterBiConsumers.put(
			"prixVente", (BiConsumer<Books, Double>)Books::setPrixVente);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getBookId() {
		return _bookId;
	}

	@Override
	public void setBookId(long bookId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_bookId = bookId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalUserId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("userId"));
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_title = title;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalTitle() {
		return getColumnOriginalValue("title");
	}

	@JSON
	@Override
	public String getAuthorId() {
		if (_authorId == null) {
			return "";
		}
		else {
			return _authorId;
		}
	}

	@Override
	public void setAuthorId(String authorId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_authorId = authorId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalAuthorId() {
		return getColumnOriginalValue("authorId");
	}

	@JSON
	@Override
	public String getConte_rendu() {
		if (_conte_rendu == null) {
			return "";
		}
		else {
			return _conte_rendu;
		}
	}

	@Override
	public void setConte_rendu(String conte_rendu) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_conte_rendu = conte_rendu;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getDatePublication() {
		return _datePublication;
	}

	@Override
	public void setDatePublication(Date datePublication) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_datePublication = datePublication;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public double getPrixAchat() {
		return _prixAchat;
	}

	@Override
	public void setPrixAchat(double prixAchat) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_prixAchat = prixAchat;
	}

	@JSON
	@Override
	public double getPrixVente() {
		return _prixVente;
	}

	@Override
	public void setPrixVente(double prixVente) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_prixVente = prixVente;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Books.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Books.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Books toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Books>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BooksImpl booksImpl = new BooksImpl();

		booksImpl.setUuid(getUuid());
		booksImpl.setBookId(getBookId());
		booksImpl.setGroupId(getGroupId());
		booksImpl.setCompanyId(getCompanyId());
		booksImpl.setUserId(getUserId());
		booksImpl.setTitle(getTitle());
		booksImpl.setAuthorId(getAuthorId());
		booksImpl.setConte_rendu(getConte_rendu());
		booksImpl.setCreateDate(getCreateDate());
		booksImpl.setDatePublication(getDatePublication());
		booksImpl.setModifiedDate(getModifiedDate());
		booksImpl.setPrixAchat(getPrixAchat());
		booksImpl.setPrixVente(getPrixVente());

		booksImpl.resetOriginalValues();

		return booksImpl;
	}

	@Override
	public int compareTo(Books books) {
		int value = 0;

		value = getTitle().compareTo(books.getTitle());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Books)) {
			return false;
		}

		Books books = (Books)object;

		long primaryKey = books.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Books> toCacheModel() {
		BooksCacheModel booksCacheModel = new BooksCacheModel();

		booksCacheModel.uuid = getUuid();

		String uuid = booksCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			booksCacheModel.uuid = null;
		}

		booksCacheModel.bookId = getBookId();

		booksCacheModel.groupId = getGroupId();

		booksCacheModel.companyId = getCompanyId();

		booksCacheModel.userId = getUserId();

		booksCacheModel.title = getTitle();

		String title = booksCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			booksCacheModel.title = null;
		}

		booksCacheModel.authorId = getAuthorId();

		String authorId = booksCacheModel.authorId;

		if ((authorId != null) && (authorId.length() == 0)) {
			booksCacheModel.authorId = null;
		}

		booksCacheModel.conte_rendu = getConte_rendu();

		String conte_rendu = booksCacheModel.conte_rendu;

		if ((conte_rendu != null) && (conte_rendu.length() == 0)) {
			booksCacheModel.conte_rendu = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			booksCacheModel.createDate = createDate.getTime();
		}
		else {
			booksCacheModel.createDate = Long.MIN_VALUE;
		}

		Date datePublication = getDatePublication();

		if (datePublication != null) {
			booksCacheModel.datePublication = datePublication.getTime();
		}
		else {
			booksCacheModel.datePublication = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			booksCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			booksCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		booksCacheModel.prixAchat = getPrixAchat();

		booksCacheModel.prixVente = getPrixVente();

		return booksCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Books, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Books, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Books, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Books)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Books, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Books, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Books, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Books)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Books>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

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
	private boolean _setModifiedDate;
	private double _prixAchat;
	private double _prixVente;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Books, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Books)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("bookId", _bookId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("title", _title);
		_columnOriginalValues.put("authorId", _authorId);
		_columnOriginalValues.put("conte_rendu", _conte_rendu);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("datePublication", _datePublication);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("prixAchat", _prixAchat);
		_columnOriginalValues.put("prixVente", _prixVente);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("bookId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("title", 32L);

		columnBitmasks.put("authorId", 64L);

		columnBitmasks.put("conte_rendu", 128L);

		columnBitmasks.put("createDate", 256L);

		columnBitmasks.put("datePublication", 512L);

		columnBitmasks.put("modifiedDate", 1024L);

		columnBitmasks.put("prixAchat", 2048L);

		columnBitmasks.put("prixVente", 4096L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Books _escapedModel;

}