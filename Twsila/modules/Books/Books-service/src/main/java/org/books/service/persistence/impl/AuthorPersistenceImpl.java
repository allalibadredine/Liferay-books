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

package org.books.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.books.exception.NoSuchAuthorException;
import org.books.model.Author;
import org.books.model.impl.AuthorImpl;
import org.books.model.impl.AuthorModelImpl;
import org.books.service.persistence.AuthorPersistence;
import org.books.service.persistence.impl.constants.BooksPersistenceConstants;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the author service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AuthorPersistence.class)
public class AuthorPersistenceImpl
	extends BasePersistenceImpl<Author> implements AuthorPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AuthorUtil</code> to access the author persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AuthorImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the authors where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching authors
	 */
	@Override
	public List<Author> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the authors where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of authors
	 * @param end the upper bound of the range of authors (not inclusive)
	 * @return the range of matching authors
	 */
	@Override
	public List<Author> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the authors where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of authors
	 * @param end the upper bound of the range of authors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching authors
	 */
	@Override
	public List<Author> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Author> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the authors where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of authors
	 * @param end the upper bound of the range of authors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching authors
	 */
	@Override
	public List<Author> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Author> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Author> list = null;

		if (useFinderCache) {
			list = (List<Author>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Author author : list) {
					if (!uuid.equals(author.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_AUTHOR_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AuthorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Author>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first author in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching author
	 * @throws NoSuchAuthorException if a matching author could not be found
	 */
	@Override
	public Author findByUuid_First(
			String uuid, OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException {

		Author author = fetchByUuid_First(uuid, orderByComparator);

		if (author != null) {
			return author;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAuthorException(sb.toString());
	}

	/**
	 * Returns the first author in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching author, or <code>null</code> if a matching author could not be found
	 */
	@Override
	public Author fetchByUuid_First(
		String uuid, OrderByComparator<Author> orderByComparator) {

		List<Author> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last author in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching author
	 * @throws NoSuchAuthorException if a matching author could not be found
	 */
	@Override
	public Author findByUuid_Last(
			String uuid, OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException {

		Author author = fetchByUuid_Last(uuid, orderByComparator);

		if (author != null) {
			return author;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAuthorException(sb.toString());
	}

	/**
	 * Returns the last author in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching author, or <code>null</code> if a matching author could not be found
	 */
	@Override
	public Author fetchByUuid_Last(
		String uuid, OrderByComparator<Author> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Author> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the authors before and after the current author in the ordered set where uuid = &#63;.
	 *
	 * @param authorId the primary key of the current author
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next author
	 * @throws NoSuchAuthorException if a author with the primary key could not be found
	 */
	@Override
	public Author[] findByUuid_PrevAndNext(
			long authorId, String uuid,
			OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException {

		uuid = Objects.toString(uuid, "");

		Author author = findByPrimaryKey(authorId);

		Session session = null;

		try {
			session = openSession();

			Author[] array = new AuthorImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, author, uuid, orderByComparator, true);

			array[1] = author;

			array[2] = getByUuid_PrevAndNext(
				session, author, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Author getByUuid_PrevAndNext(
		Session session, Author author, String uuid,
		OrderByComparator<Author> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AUTHOR_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AuthorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(author)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Author> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the authors where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Author author :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(author);
		}
	}

	/**
	 * Returns the number of authors where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching authors
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AUTHOR_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "author.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(author.uuid IS NULL OR author.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the author where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAuthorException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching author
	 * @throws NoSuchAuthorException if a matching author could not be found
	 */
	@Override
	public Author findByUUID_G(String uuid, long groupId)
		throws NoSuchAuthorException {

		Author author = fetchByUUID_G(uuid, groupId);

		if (author == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAuthorException(sb.toString());
		}

		return author;
	}

	/**
	 * Returns the author where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching author, or <code>null</code> if a matching author could not be found
	 */
	@Override
	public Author fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the author where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching author, or <code>null</code> if a matching author could not be found
	 */
	@Override
	public Author fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Author) {
			Author author = (Author)result;

			if (!Objects.equals(uuid, author.getUuid()) ||
				(groupId != author.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_AUTHOR_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<Author> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Author author = list.get(0);

					result = author;

					cacheResult(author);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Author)result;
		}
	}

	/**
	 * Removes the author where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the author that was removed
	 */
	@Override
	public Author removeByUUID_G(String uuid, long groupId)
		throws NoSuchAuthorException {

		Author author = findByUUID_G(uuid, groupId);

		return remove(author);
	}

	/**
	 * Returns the number of authors where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching authors
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AUTHOR_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"author.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(author.uuid IS NULL OR author.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"author.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the authors where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching authors
	 */
	@Override
	public List<Author> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the authors where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of authors
	 * @param end the upper bound of the range of authors (not inclusive)
	 * @return the range of matching authors
	 */
	@Override
	public List<Author> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the authors where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of authors
	 * @param end the upper bound of the range of authors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching authors
	 */
	@Override
	public List<Author> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Author> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the authors where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of authors
	 * @param end the upper bound of the range of authors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching authors
	 */
	@Override
	public List<Author> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Author> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Author> list = null;

		if (useFinderCache) {
			list = (List<Author>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Author author : list) {
					if (!uuid.equals(author.getUuid()) ||
						(companyId != author.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_AUTHOR_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AuthorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<Author>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first author in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching author
	 * @throws NoSuchAuthorException if a matching author could not be found
	 */
	@Override
	public Author findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException {

		Author author = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (author != null) {
			return author;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAuthorException(sb.toString());
	}

	/**
	 * Returns the first author in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching author, or <code>null</code> if a matching author could not be found
	 */
	@Override
	public Author fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Author> orderByComparator) {

		List<Author> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last author in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching author
	 * @throws NoSuchAuthorException if a matching author could not be found
	 */
	@Override
	public Author findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException {

		Author author = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (author != null) {
			return author;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAuthorException(sb.toString());
	}

	/**
	 * Returns the last author in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching author, or <code>null</code> if a matching author could not be found
	 */
	@Override
	public Author fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Author> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Author> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the authors before and after the current author in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param authorId the primary key of the current author
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next author
	 * @throws NoSuchAuthorException if a author with the primary key could not be found
	 */
	@Override
	public Author[] findByUuid_C_PrevAndNext(
			long authorId, String uuid, long companyId,
			OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException {

		uuid = Objects.toString(uuid, "");

		Author author = findByPrimaryKey(authorId);

		Session session = null;

		try {
			session = openSession();

			Author[] array = new AuthorImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, author, uuid, companyId, orderByComparator, true);

			array[1] = author;

			array[2] = getByUuid_C_PrevAndNext(
				session, author, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Author getByUuid_C_PrevAndNext(
		Session session, Author author, String uuid, long companyId,
		OrderByComparator<Author> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_AUTHOR_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AuthorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(author)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Author> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the authors where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Author author :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(author);
		}
	}

	/**
	 * Returns the number of authors where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching authors
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AUTHOR_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"author.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(author.uuid IS NULL OR author.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"author.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBynom;
	private FinderPath _finderPathWithoutPaginationFindBynom;
	private FinderPath _finderPathCountBynom;

	/**
	 * Returns all the authors where nom = &#63;.
	 *
	 * @param nom the nom
	 * @return the matching authors
	 */
	@Override
	public List<Author> findBynom(String nom) {
		return findBynom(nom, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the authors where nom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorModelImpl</code>.
	 * </p>
	 *
	 * @param nom the nom
	 * @param start the lower bound of the range of authors
	 * @param end the upper bound of the range of authors (not inclusive)
	 * @return the range of matching authors
	 */
	@Override
	public List<Author> findBynom(String nom, int start, int end) {
		return findBynom(nom, start, end, null);
	}

	/**
	 * Returns an ordered range of all the authors where nom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorModelImpl</code>.
	 * </p>
	 *
	 * @param nom the nom
	 * @param start the lower bound of the range of authors
	 * @param end the upper bound of the range of authors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching authors
	 */
	@Override
	public List<Author> findBynom(
		String nom, int start, int end,
		OrderByComparator<Author> orderByComparator) {

		return findBynom(nom, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the authors where nom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorModelImpl</code>.
	 * </p>
	 *
	 * @param nom the nom
	 * @param start the lower bound of the range of authors
	 * @param end the upper bound of the range of authors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching authors
	 */
	@Override
	public List<Author> findBynom(
		String nom, int start, int end,
		OrderByComparator<Author> orderByComparator, boolean useFinderCache) {

		nom = Objects.toString(nom, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBynom;
				finderArgs = new Object[] {nom};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBynom;
			finderArgs = new Object[] {nom, start, end, orderByComparator};
		}

		List<Author> list = null;

		if (useFinderCache) {
			list = (List<Author>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Author author : list) {
					if (!nom.equals(author.getNom())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_AUTHOR_WHERE);

			boolean bindNom = false;

			if (nom.isEmpty()) {
				sb.append(_FINDER_COLUMN_NOM_NOM_3);
			}
			else {
				bindNom = true;

				sb.append(_FINDER_COLUMN_NOM_NOM_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AuthorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNom) {
					queryPos.add(nom);
				}

				list = (List<Author>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first author in the ordered set where nom = &#63;.
	 *
	 * @param nom the nom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching author
	 * @throws NoSuchAuthorException if a matching author could not be found
	 */
	@Override
	public Author findBynom_First(
			String nom, OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException {

		Author author = fetchBynom_First(nom, orderByComparator);

		if (author != null) {
			return author;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nom=");
		sb.append(nom);

		sb.append("}");

		throw new NoSuchAuthorException(sb.toString());
	}

	/**
	 * Returns the first author in the ordered set where nom = &#63;.
	 *
	 * @param nom the nom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching author, or <code>null</code> if a matching author could not be found
	 */
	@Override
	public Author fetchBynom_First(
		String nom, OrderByComparator<Author> orderByComparator) {

		List<Author> list = findBynom(nom, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last author in the ordered set where nom = &#63;.
	 *
	 * @param nom the nom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching author
	 * @throws NoSuchAuthorException if a matching author could not be found
	 */
	@Override
	public Author findBynom_Last(
			String nom, OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException {

		Author author = fetchBynom_Last(nom, orderByComparator);

		if (author != null) {
			return author;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nom=");
		sb.append(nom);

		sb.append("}");

		throw new NoSuchAuthorException(sb.toString());
	}

	/**
	 * Returns the last author in the ordered set where nom = &#63;.
	 *
	 * @param nom the nom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching author, or <code>null</code> if a matching author could not be found
	 */
	@Override
	public Author fetchBynom_Last(
		String nom, OrderByComparator<Author> orderByComparator) {

		int count = countBynom(nom);

		if (count == 0) {
			return null;
		}

		List<Author> list = findBynom(nom, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the authors before and after the current author in the ordered set where nom = &#63;.
	 *
	 * @param authorId the primary key of the current author
	 * @param nom the nom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next author
	 * @throws NoSuchAuthorException if a author with the primary key could not be found
	 */
	@Override
	public Author[] findBynom_PrevAndNext(
			long authorId, String nom,
			OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException {

		nom = Objects.toString(nom, "");

		Author author = findByPrimaryKey(authorId);

		Session session = null;

		try {
			session = openSession();

			Author[] array = new AuthorImpl[3];

			array[0] = getBynom_PrevAndNext(
				session, author, nom, orderByComparator, true);

			array[1] = author;

			array[2] = getBynom_PrevAndNext(
				session, author, nom, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Author getBynom_PrevAndNext(
		Session session, Author author, String nom,
		OrderByComparator<Author> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AUTHOR_WHERE);

		boolean bindNom = false;

		if (nom.isEmpty()) {
			sb.append(_FINDER_COLUMN_NOM_NOM_3);
		}
		else {
			bindNom = true;

			sb.append(_FINDER_COLUMN_NOM_NOM_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AuthorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindNom) {
			queryPos.add(nom);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(author)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Author> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the authors where nom = &#63; from the database.
	 *
	 * @param nom the nom
	 */
	@Override
	public void removeBynom(String nom) {
		for (Author author :
				findBynom(nom, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(author);
		}
	}

	/**
	 * Returns the number of authors where nom = &#63;.
	 *
	 * @param nom the nom
	 * @return the number of matching authors
	 */
	@Override
	public int countBynom(String nom) {
		nom = Objects.toString(nom, "");

		FinderPath finderPath = _finderPathCountBynom;

		Object[] finderArgs = new Object[] {nom};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AUTHOR_WHERE);

			boolean bindNom = false;

			if (nom.isEmpty()) {
				sb.append(_FINDER_COLUMN_NOM_NOM_3);
			}
			else {
				bindNom = true;

				sb.append(_FINDER_COLUMN_NOM_NOM_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNom) {
					queryPos.add(nom);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NOM_NOM_2 = "author.nom = ?";

	private static final String _FINDER_COLUMN_NOM_NOM_3 =
		"(author.nom IS NULL OR author.nom = '')";

	private FinderPath _finderPathWithPaginationFindByauthorId;
	private FinderPath _finderPathWithoutPaginationFindByauthorId;
	private FinderPath _finderPathCountByauthorId;

	/**
	 * Returns all the authors where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @return the matching authors
	 */
	@Override
	public List<Author> findByauthorId(long authorId) {
		return findByauthorId(
			authorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the authors where authorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorModelImpl</code>.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param start the lower bound of the range of authors
	 * @param end the upper bound of the range of authors (not inclusive)
	 * @return the range of matching authors
	 */
	@Override
	public List<Author> findByauthorId(long authorId, int start, int end) {
		return findByauthorId(authorId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the authors where authorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorModelImpl</code>.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param start the lower bound of the range of authors
	 * @param end the upper bound of the range of authors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching authors
	 */
	@Override
	public List<Author> findByauthorId(
		long authorId, int start, int end,
		OrderByComparator<Author> orderByComparator) {

		return findByauthorId(authorId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the authors where authorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorModelImpl</code>.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param start the lower bound of the range of authors
	 * @param end the upper bound of the range of authors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching authors
	 */
	@Override
	public List<Author> findByauthorId(
		long authorId, int start, int end,
		OrderByComparator<Author> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByauthorId;
				finderArgs = new Object[] {authorId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByauthorId;
			finderArgs = new Object[] {authorId, start, end, orderByComparator};
		}

		List<Author> list = null;

		if (useFinderCache) {
			list = (List<Author>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Author author : list) {
					if (authorId != author.getAuthorId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_AUTHOR_WHERE);

			sb.append(_FINDER_COLUMN_AUTHORID_AUTHORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AuthorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(authorId);

				list = (List<Author>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first author in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching author
	 * @throws NoSuchAuthorException if a matching author could not be found
	 */
	@Override
	public Author findByauthorId_First(
			long authorId, OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException {

		Author author = fetchByauthorId_First(authorId, orderByComparator);

		if (author != null) {
			return author;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("authorId=");
		sb.append(authorId);

		sb.append("}");

		throw new NoSuchAuthorException(sb.toString());
	}

	/**
	 * Returns the first author in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching author, or <code>null</code> if a matching author could not be found
	 */
	@Override
	public Author fetchByauthorId_First(
		long authorId, OrderByComparator<Author> orderByComparator) {

		List<Author> list = findByauthorId(authorId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last author in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching author
	 * @throws NoSuchAuthorException if a matching author could not be found
	 */
	@Override
	public Author findByauthorId_Last(
			long authorId, OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException {

		Author author = fetchByauthorId_Last(authorId, orderByComparator);

		if (author != null) {
			return author;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("authorId=");
		sb.append(authorId);

		sb.append("}");

		throw new NoSuchAuthorException(sb.toString());
	}

	/**
	 * Returns the last author in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching author, or <code>null</code> if a matching author could not be found
	 */
	@Override
	public Author fetchByauthorId_Last(
		long authorId, OrderByComparator<Author> orderByComparator) {

		int count = countByauthorId(authorId);

		if (count == 0) {
			return null;
		}

		List<Author> list = findByauthorId(
			authorId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the authors where authorId = &#63; from the database.
	 *
	 * @param authorId the author ID
	 */
	@Override
	public void removeByauthorId(long authorId) {
		for (Author author :
				findByauthorId(
					authorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(author);
		}
	}

	/**
	 * Returns the number of authors where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @return the number of matching authors
	 */
	@Override
	public int countByauthorId(long authorId) {
		FinderPath finderPath = _finderPathCountByauthorId;

		Object[] finderArgs = new Object[] {authorId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AUTHOR_WHERE);

			sb.append(_FINDER_COLUMN_AUTHORID_AUTHORID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(authorId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_AUTHORID_AUTHORID_2 =
		"author.authorId = ?";

	private FinderPath _finderPathWithPaginationFindByprenom;
	private FinderPath _finderPathWithoutPaginationFindByprenom;
	private FinderPath _finderPathCountByprenom;

	/**
	 * Returns all the authors where prenom = &#63;.
	 *
	 * @param prenom the prenom
	 * @return the matching authors
	 */
	@Override
	public List<Author> findByprenom(String prenom) {
		return findByprenom(prenom, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the authors where prenom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorModelImpl</code>.
	 * </p>
	 *
	 * @param prenom the prenom
	 * @param start the lower bound of the range of authors
	 * @param end the upper bound of the range of authors (not inclusive)
	 * @return the range of matching authors
	 */
	@Override
	public List<Author> findByprenom(String prenom, int start, int end) {
		return findByprenom(prenom, start, end, null);
	}

	/**
	 * Returns an ordered range of all the authors where prenom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorModelImpl</code>.
	 * </p>
	 *
	 * @param prenom the prenom
	 * @param start the lower bound of the range of authors
	 * @param end the upper bound of the range of authors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching authors
	 */
	@Override
	public List<Author> findByprenom(
		String prenom, int start, int end,
		OrderByComparator<Author> orderByComparator) {

		return findByprenom(prenom, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the authors where prenom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorModelImpl</code>.
	 * </p>
	 *
	 * @param prenom the prenom
	 * @param start the lower bound of the range of authors
	 * @param end the upper bound of the range of authors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching authors
	 */
	@Override
	public List<Author> findByprenom(
		String prenom, int start, int end,
		OrderByComparator<Author> orderByComparator, boolean useFinderCache) {

		prenom = Objects.toString(prenom, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByprenom;
				finderArgs = new Object[] {prenom};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByprenom;
			finderArgs = new Object[] {prenom, start, end, orderByComparator};
		}

		List<Author> list = null;

		if (useFinderCache) {
			list = (List<Author>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Author author : list) {
					if (!prenom.equals(author.getPrenom())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_AUTHOR_WHERE);

			boolean bindPrenom = false;

			if (prenom.isEmpty()) {
				sb.append(_FINDER_COLUMN_PRENOM_PRENOM_3);
			}
			else {
				bindPrenom = true;

				sb.append(_FINDER_COLUMN_PRENOM_PRENOM_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AuthorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPrenom) {
					queryPos.add(prenom);
				}

				list = (List<Author>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first author in the ordered set where prenom = &#63;.
	 *
	 * @param prenom the prenom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching author
	 * @throws NoSuchAuthorException if a matching author could not be found
	 */
	@Override
	public Author findByprenom_First(
			String prenom, OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException {

		Author author = fetchByprenom_First(prenom, orderByComparator);

		if (author != null) {
			return author;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("prenom=");
		sb.append(prenom);

		sb.append("}");

		throw new NoSuchAuthorException(sb.toString());
	}

	/**
	 * Returns the first author in the ordered set where prenom = &#63;.
	 *
	 * @param prenom the prenom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching author, or <code>null</code> if a matching author could not be found
	 */
	@Override
	public Author fetchByprenom_First(
		String prenom, OrderByComparator<Author> orderByComparator) {

		List<Author> list = findByprenom(prenom, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last author in the ordered set where prenom = &#63;.
	 *
	 * @param prenom the prenom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching author
	 * @throws NoSuchAuthorException if a matching author could not be found
	 */
	@Override
	public Author findByprenom_Last(
			String prenom, OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException {

		Author author = fetchByprenom_Last(prenom, orderByComparator);

		if (author != null) {
			return author;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("prenom=");
		sb.append(prenom);

		sb.append("}");

		throw new NoSuchAuthorException(sb.toString());
	}

	/**
	 * Returns the last author in the ordered set where prenom = &#63;.
	 *
	 * @param prenom the prenom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching author, or <code>null</code> if a matching author could not be found
	 */
	@Override
	public Author fetchByprenom_Last(
		String prenom, OrderByComparator<Author> orderByComparator) {

		int count = countByprenom(prenom);

		if (count == 0) {
			return null;
		}

		List<Author> list = findByprenom(
			prenom, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the authors before and after the current author in the ordered set where prenom = &#63;.
	 *
	 * @param authorId the primary key of the current author
	 * @param prenom the prenom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next author
	 * @throws NoSuchAuthorException if a author with the primary key could not be found
	 */
	@Override
	public Author[] findByprenom_PrevAndNext(
			long authorId, String prenom,
			OrderByComparator<Author> orderByComparator)
		throws NoSuchAuthorException {

		prenom = Objects.toString(prenom, "");

		Author author = findByPrimaryKey(authorId);

		Session session = null;

		try {
			session = openSession();

			Author[] array = new AuthorImpl[3];

			array[0] = getByprenom_PrevAndNext(
				session, author, prenom, orderByComparator, true);

			array[1] = author;

			array[2] = getByprenom_PrevAndNext(
				session, author, prenom, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Author getByprenom_PrevAndNext(
		Session session, Author author, String prenom,
		OrderByComparator<Author> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AUTHOR_WHERE);

		boolean bindPrenom = false;

		if (prenom.isEmpty()) {
			sb.append(_FINDER_COLUMN_PRENOM_PRENOM_3);
		}
		else {
			bindPrenom = true;

			sb.append(_FINDER_COLUMN_PRENOM_PRENOM_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AuthorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPrenom) {
			queryPos.add(prenom);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(author)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Author> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the authors where prenom = &#63; from the database.
	 *
	 * @param prenom the prenom
	 */
	@Override
	public void removeByprenom(String prenom) {
		for (Author author :
				findByprenom(
					prenom, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(author);
		}
	}

	/**
	 * Returns the number of authors where prenom = &#63;.
	 *
	 * @param prenom the prenom
	 * @return the number of matching authors
	 */
	@Override
	public int countByprenom(String prenom) {
		prenom = Objects.toString(prenom, "");

		FinderPath finderPath = _finderPathCountByprenom;

		Object[] finderArgs = new Object[] {prenom};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AUTHOR_WHERE);

			boolean bindPrenom = false;

			if (prenom.isEmpty()) {
				sb.append(_FINDER_COLUMN_PRENOM_PRENOM_3);
			}
			else {
				bindPrenom = true;

				sb.append(_FINDER_COLUMN_PRENOM_PRENOM_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPrenom) {
					queryPos.add(prenom);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PRENOM_PRENOM_2 =
		"author.prenom = ?";

	private static final String _FINDER_COLUMN_PRENOM_PRENOM_3 =
		"(author.prenom IS NULL OR author.prenom = '')";

	public AuthorPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Author.class);

		setModelImplClass(AuthorImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the author in the entity cache if it is enabled.
	 *
	 * @param author the author
	 */
	@Override
	public void cacheResult(Author author) {
		entityCache.putResult(AuthorImpl.class, author.getPrimaryKey(), author);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {author.getUuid(), author.getGroupId()}, author);
	}

	/**
	 * Caches the authors in the entity cache if it is enabled.
	 *
	 * @param authors the authors
	 */
	@Override
	public void cacheResult(List<Author> authors) {
		for (Author author : authors) {
			if (entityCache.getResult(
					AuthorImpl.class, author.getPrimaryKey()) == null) {

				cacheResult(author);
			}
		}
	}

	/**
	 * Clears the cache for all authors.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AuthorImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the author.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Author author) {
		entityCache.removeResult(AuthorImpl.class, author);
	}

	@Override
	public void clearCache(List<Author> authors) {
		for (Author author : authors) {
			entityCache.removeResult(AuthorImpl.class, author);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AuthorImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(AuthorModelImpl authorModelImpl) {
		Object[] args = new Object[] {
			authorModelImpl.getUuid(), authorModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, authorModelImpl, false);
	}

	/**
	 * Creates a new author with the primary key. Does not add the author to the database.
	 *
	 * @param authorId the primary key for the new author
	 * @return the new author
	 */
	@Override
	public Author create(long authorId) {
		Author author = new AuthorImpl();

		author.setNew(true);
		author.setPrimaryKey(authorId);

		String uuid = PortalUUIDUtil.generate();

		author.setUuid(uuid);

		author.setCompanyId(CompanyThreadLocal.getCompanyId());

		return author;
	}

	/**
	 * Removes the author with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param authorId the primary key of the author
	 * @return the author that was removed
	 * @throws NoSuchAuthorException if a author with the primary key could not be found
	 */
	@Override
	public Author remove(long authorId) throws NoSuchAuthorException {
		return remove((Serializable)authorId);
	}

	/**
	 * Removes the author with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the author
	 * @return the author that was removed
	 * @throws NoSuchAuthorException if a author with the primary key could not be found
	 */
	@Override
	public Author remove(Serializable primaryKey) throws NoSuchAuthorException {
		Session session = null;

		try {
			session = openSession();

			Author author = (Author)session.get(AuthorImpl.class, primaryKey);

			if (author == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAuthorException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(author);
		}
		catch (NoSuchAuthorException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Author removeImpl(Author author) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(author)) {
				author = (Author)session.get(
					AuthorImpl.class, author.getPrimaryKeyObj());
			}

			if (author != null) {
				session.delete(author);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (author != null) {
			clearCache(author);
		}

		return author;
	}

	@Override
	public Author updateImpl(Author author) {
		boolean isNew = author.isNew();

		if (!(author instanceof AuthorModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(author.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(author);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in author proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Author implementation " +
					author.getClass());
		}

		AuthorModelImpl authorModelImpl = (AuthorModelImpl)author;

		if (Validator.isNull(author.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			author.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(author);
			}
			else {
				author = (Author)session.merge(author);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(AuthorImpl.class, authorModelImpl, false, true);

		cacheUniqueFindersCache(authorModelImpl);

		if (isNew) {
			author.setNew(false);
		}

		author.resetOriginalValues();

		return author;
	}

	/**
	 * Returns the author with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the author
	 * @return the author
	 * @throws NoSuchAuthorException if a author with the primary key could not be found
	 */
	@Override
	public Author findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAuthorException {

		Author author = fetchByPrimaryKey(primaryKey);

		if (author == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAuthorException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return author;
	}

	/**
	 * Returns the author with the primary key or throws a <code>NoSuchAuthorException</code> if it could not be found.
	 *
	 * @param authorId the primary key of the author
	 * @return the author
	 * @throws NoSuchAuthorException if a author with the primary key could not be found
	 */
	@Override
	public Author findByPrimaryKey(long authorId) throws NoSuchAuthorException {
		return findByPrimaryKey((Serializable)authorId);
	}

	/**
	 * Returns the author with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param authorId the primary key of the author
	 * @return the author, or <code>null</code> if a author with the primary key could not be found
	 */
	@Override
	public Author fetchByPrimaryKey(long authorId) {
		return fetchByPrimaryKey((Serializable)authorId);
	}

	/**
	 * Returns all the authors.
	 *
	 * @return the authors
	 */
	@Override
	public List<Author> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the authors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of authors
	 * @param end the upper bound of the range of authors (not inclusive)
	 * @return the range of authors
	 */
	@Override
	public List<Author> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the authors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of authors
	 * @param end the upper bound of the range of authors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of authors
	 */
	@Override
	public List<Author> findAll(
		int start, int end, OrderByComparator<Author> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the authors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of authors
	 * @param end the upper bound of the range of authors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of authors
	 */
	@Override
	public List<Author> findAll(
		int start, int end, OrderByComparator<Author> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Author> list = null;

		if (useFinderCache) {
			list = (List<Author>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AUTHOR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AUTHOR;

				sql = sql.concat(AuthorModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Author>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the authors from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Author author : findAll()) {
			remove(author);
		}
	}

	/**
	 * Returns the number of authors.
	 *
	 * @return the number of authors
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AUTHOR);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "authorId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AUTHOR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AuthorModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the author persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new AuthorModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Author.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindBynom = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBynom",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"nom"}, true);

		_finderPathWithoutPaginationFindBynom = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBynom",
			new String[] {String.class.getName()}, new String[] {"nom"}, true);

		_finderPathCountBynom = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBynom",
			new String[] {String.class.getName()}, new String[] {"nom"}, false);

		_finderPathWithPaginationFindByauthorId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByauthorId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"authorId"}, true);

		_finderPathWithoutPaginationFindByauthorId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByauthorId",
			new String[] {Long.class.getName()}, new String[] {"authorId"},
			true);

		_finderPathCountByauthorId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByauthorId",
			new String[] {Long.class.getName()}, new String[] {"authorId"},
			false);

		_finderPathWithPaginationFindByprenom = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByprenom",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"prenom"}, true);

		_finderPathWithoutPaginationFindByprenom = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByprenom",
			new String[] {String.class.getName()}, new String[] {"prenom"},
			true);

		_finderPathCountByprenom = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByprenom",
			new String[] {String.class.getName()}, new String[] {"prenom"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(AuthorImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = BooksPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = BooksPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = BooksPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_AUTHOR =
		"SELECT author FROM Author author";

	private static final String _SQL_SELECT_AUTHOR_WHERE =
		"SELECT author FROM Author author WHERE ";

	private static final String _SQL_COUNT_AUTHOR =
		"SELECT COUNT(author) FROM Author author";

	private static final String _SQL_COUNT_AUTHOR_WHERE =
		"SELECT COUNT(author) FROM Author author WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "author.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Author exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Author exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AuthorPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class AuthorModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			AuthorModelImpl authorModelImpl = (AuthorModelImpl)baseModel;

			long columnBitmask = authorModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(authorModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |= authorModelImpl.getColumnBitmask(
						columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(authorModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			AuthorModelImpl authorModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = authorModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = authorModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

		private static final long _ORDER_BY_COLUMNS_BITMASK;

		static {
			long orderByColumnsBitmask = 0;

			orderByColumnsBitmask |= AuthorModelImpl.getColumnBitmask("nom");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}