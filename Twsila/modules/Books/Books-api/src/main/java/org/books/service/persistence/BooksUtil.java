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

package org.books.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.books.model.Books;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the books service. This utility wraps <code>org.books.service.persistence.impl.BooksPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BooksPersistence
 * @generated
 */
public class BooksUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Books books) {
		getPersistence().clearCache(books);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Books> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Books> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Books> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Books> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Books> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Books update(Books books) {
		return getPersistence().update(books);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Books update(Books books, ServiceContext serviceContext) {
		return getPersistence().update(books, serviceContext);
	}

	/**
	 * Returns all the bookses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bookses
	 */
	public static List<Books> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the bookses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BooksModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bookses
	 * @param end the upper bound of the range of bookses (not inclusive)
	 * @return the range of matching bookses
	 */
	public static List<Books> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the bookses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BooksModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bookses
	 * @param end the upper bound of the range of bookses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bookses
	 */
	public static List<Books> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Books> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bookses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BooksModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of bookses
	 * @param end the upper bound of the range of bookses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bookses
	 */
	public static List<Books> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Books> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first books in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books
	 * @throws NoSuchBooksException if a matching books could not be found
	 */
	public static Books findByUuid_First(
			String uuid, OrderByComparator<Books> orderByComparator)
		throws org.books.exception.NoSuchBooksException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first books in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books, or <code>null</code> if a matching books could not be found
	 */
	public static Books fetchByUuid_First(
		String uuid, OrderByComparator<Books> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last books in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books
	 * @throws NoSuchBooksException if a matching books could not be found
	 */
	public static Books findByUuid_Last(
			String uuid, OrderByComparator<Books> orderByComparator)
		throws org.books.exception.NoSuchBooksException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last books in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books, or <code>null</code> if a matching books could not be found
	 */
	public static Books fetchByUuid_Last(
		String uuid, OrderByComparator<Books> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the bookses before and after the current books in the ordered set where uuid = &#63;.
	 *
	 * @param bookId the primary key of the current books
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next books
	 * @throws NoSuchBooksException if a books with the primary key could not be found
	 */
	public static Books[] findByUuid_PrevAndNext(
			long bookId, String uuid,
			OrderByComparator<Books> orderByComparator)
		throws org.books.exception.NoSuchBooksException {

		return getPersistence().findByUuid_PrevAndNext(
			bookId, uuid, orderByComparator);
	}

	/**
	 * Removes all the bookses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of bookses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bookses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the books where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBooksException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching books
	 * @throws NoSuchBooksException if a matching books could not be found
	 */
	public static Books findByUUID_G(String uuid, long groupId)
		throws org.books.exception.NoSuchBooksException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the books where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching books, or <code>null</code> if a matching books could not be found
	 */
	public static Books fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the books where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching books, or <code>null</code> if a matching books could not be found
	 */
	public static Books fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the books where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the books that was removed
	 */
	public static Books removeByUUID_G(String uuid, long groupId)
		throws org.books.exception.NoSuchBooksException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of bookses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching bookses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the bookses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching bookses
	 */
	public static List<Books> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the bookses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BooksModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of bookses
	 * @param end the upper bound of the range of bookses (not inclusive)
	 * @return the range of matching bookses
	 */
	public static List<Books> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the bookses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BooksModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of bookses
	 * @param end the upper bound of the range of bookses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bookses
	 */
	public static List<Books> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Books> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bookses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BooksModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of bookses
	 * @param end the upper bound of the range of bookses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bookses
	 */
	public static List<Books> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Books> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first books in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books
	 * @throws NoSuchBooksException if a matching books could not be found
	 */
	public static Books findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Books> orderByComparator)
		throws org.books.exception.NoSuchBooksException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first books in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books, or <code>null</code> if a matching books could not be found
	 */
	public static Books fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Books> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last books in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books
	 * @throws NoSuchBooksException if a matching books could not be found
	 */
	public static Books findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Books> orderByComparator)
		throws org.books.exception.NoSuchBooksException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last books in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books, or <code>null</code> if a matching books could not be found
	 */
	public static Books fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Books> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the bookses before and after the current books in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param bookId the primary key of the current books
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next books
	 * @throws NoSuchBooksException if a books with the primary key could not be found
	 */
	public static Books[] findByUuid_C_PrevAndNext(
			long bookId, String uuid, long companyId,
			OrderByComparator<Books> orderByComparator)
		throws org.books.exception.NoSuchBooksException {

		return getPersistence().findByUuid_C_PrevAndNext(
			bookId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the bookses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of bookses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching bookses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the bookses where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching bookses
	 */
	public static List<Books> findBytitle(String title) {
		return getPersistence().findBytitle(title);
	}

	/**
	 * Returns a range of all the bookses where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BooksModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of bookses
	 * @param end the upper bound of the range of bookses (not inclusive)
	 * @return the range of matching bookses
	 */
	public static List<Books> findBytitle(String title, int start, int end) {
		return getPersistence().findBytitle(title, start, end);
	}

	/**
	 * Returns an ordered range of all the bookses where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BooksModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of bookses
	 * @param end the upper bound of the range of bookses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bookses
	 */
	public static List<Books> findBytitle(
		String title, int start, int end,
		OrderByComparator<Books> orderByComparator) {

		return getPersistence().findBytitle(
			title, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bookses where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BooksModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of bookses
	 * @param end the upper bound of the range of bookses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bookses
	 */
	public static List<Books> findBytitle(
		String title, int start, int end,
		OrderByComparator<Books> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBytitle(
			title, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first books in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books
	 * @throws NoSuchBooksException if a matching books could not be found
	 */
	public static Books findBytitle_First(
			String title, OrderByComparator<Books> orderByComparator)
		throws org.books.exception.NoSuchBooksException {

		return getPersistence().findBytitle_First(title, orderByComparator);
	}

	/**
	 * Returns the first books in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books, or <code>null</code> if a matching books could not be found
	 */
	public static Books fetchBytitle_First(
		String title, OrderByComparator<Books> orderByComparator) {

		return getPersistence().fetchBytitle_First(title, orderByComparator);
	}

	/**
	 * Returns the last books in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books
	 * @throws NoSuchBooksException if a matching books could not be found
	 */
	public static Books findBytitle_Last(
			String title, OrderByComparator<Books> orderByComparator)
		throws org.books.exception.NoSuchBooksException {

		return getPersistence().findBytitle_Last(title, orderByComparator);
	}

	/**
	 * Returns the last books in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books, or <code>null</code> if a matching books could not be found
	 */
	public static Books fetchBytitle_Last(
		String title, OrderByComparator<Books> orderByComparator) {

		return getPersistence().fetchBytitle_Last(title, orderByComparator);
	}

	/**
	 * Returns the bookses before and after the current books in the ordered set where title = &#63;.
	 *
	 * @param bookId the primary key of the current books
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next books
	 * @throws NoSuchBooksException if a books with the primary key could not be found
	 */
	public static Books[] findBytitle_PrevAndNext(
			long bookId, String title,
			OrderByComparator<Books> orderByComparator)
		throws org.books.exception.NoSuchBooksException {

		return getPersistence().findBytitle_PrevAndNext(
			bookId, title, orderByComparator);
	}

	/**
	 * Removes all the bookses where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	public static void removeBytitle(String title) {
		getPersistence().removeBytitle(title);
	}

	/**
	 * Returns the number of bookses where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching bookses
	 */
	public static int countBytitle(String title) {
		return getPersistence().countBytitle(title);
	}

	/**
	 * Returns all the bookses where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @return the matching bookses
	 */
	public static List<Books> findByauthorId(String authorId) {
		return getPersistence().findByauthorId(authorId);
	}

	/**
	 * Returns a range of all the bookses where authorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BooksModelImpl</code>.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param start the lower bound of the range of bookses
	 * @param end the upper bound of the range of bookses (not inclusive)
	 * @return the range of matching bookses
	 */
	public static List<Books> findByauthorId(
		String authorId, int start, int end) {

		return getPersistence().findByauthorId(authorId, start, end);
	}

	/**
	 * Returns an ordered range of all the bookses where authorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BooksModelImpl</code>.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param start the lower bound of the range of bookses
	 * @param end the upper bound of the range of bookses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bookses
	 */
	public static List<Books> findByauthorId(
		String authorId, int start, int end,
		OrderByComparator<Books> orderByComparator) {

		return getPersistence().findByauthorId(
			authorId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bookses where authorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BooksModelImpl</code>.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param start the lower bound of the range of bookses
	 * @param end the upper bound of the range of bookses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bookses
	 */
	public static List<Books> findByauthorId(
		String authorId, int start, int end,
		OrderByComparator<Books> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByauthorId(
			authorId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first books in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books
	 * @throws NoSuchBooksException if a matching books could not be found
	 */
	public static Books findByauthorId_First(
			String authorId, OrderByComparator<Books> orderByComparator)
		throws org.books.exception.NoSuchBooksException {

		return getPersistence().findByauthorId_First(
			authorId, orderByComparator);
	}

	/**
	 * Returns the first books in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books, or <code>null</code> if a matching books could not be found
	 */
	public static Books fetchByauthorId_First(
		String authorId, OrderByComparator<Books> orderByComparator) {

		return getPersistence().fetchByauthorId_First(
			authorId, orderByComparator);
	}

	/**
	 * Returns the last books in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books
	 * @throws NoSuchBooksException if a matching books could not be found
	 */
	public static Books findByauthorId_Last(
			String authorId, OrderByComparator<Books> orderByComparator)
		throws org.books.exception.NoSuchBooksException {

		return getPersistence().findByauthorId_Last(
			authorId, orderByComparator);
	}

	/**
	 * Returns the last books in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books, or <code>null</code> if a matching books could not be found
	 */
	public static Books fetchByauthorId_Last(
		String authorId, OrderByComparator<Books> orderByComparator) {

		return getPersistence().fetchByauthorId_Last(
			authorId, orderByComparator);
	}

	/**
	 * Returns the bookses before and after the current books in the ordered set where authorId = &#63;.
	 *
	 * @param bookId the primary key of the current books
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next books
	 * @throws NoSuchBooksException if a books with the primary key could not be found
	 */
	public static Books[] findByauthorId_PrevAndNext(
			long bookId, String authorId,
			OrderByComparator<Books> orderByComparator)
		throws org.books.exception.NoSuchBooksException {

		return getPersistence().findByauthorId_PrevAndNext(
			bookId, authorId, orderByComparator);
	}

	/**
	 * Removes all the bookses where authorId = &#63; from the database.
	 *
	 * @param authorId the author ID
	 */
	public static void removeByauthorId(String authorId) {
		getPersistence().removeByauthorId(authorId);
	}

	/**
	 * Returns the number of bookses where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @return the number of matching bookses
	 */
	public static int countByauthorId(String authorId) {
		return getPersistence().countByauthorId(authorId);
	}

	/**
	 * Returns all the bookses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching bookses
	 */
	public static List<Books> findByuserId(long userId) {
		return getPersistence().findByuserId(userId);
	}

	/**
	 * Returns a range of all the bookses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BooksModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of bookses
	 * @param end the upper bound of the range of bookses (not inclusive)
	 * @return the range of matching bookses
	 */
	public static List<Books> findByuserId(long userId, int start, int end) {
		return getPersistence().findByuserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the bookses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BooksModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of bookses
	 * @param end the upper bound of the range of bookses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bookses
	 */
	public static List<Books> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Books> orderByComparator) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bookses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BooksModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of bookses
	 * @param end the upper bound of the range of bookses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching bookses
	 */
	public static List<Books> findByuserId(
		long userId, int start, int end,
		OrderByComparator<Books> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first books in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books
	 * @throws NoSuchBooksException if a matching books could not be found
	 */
	public static Books findByuserId_First(
			long userId, OrderByComparator<Books> orderByComparator)
		throws org.books.exception.NoSuchBooksException {

		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first books in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books, or <code>null</code> if a matching books could not be found
	 */
	public static Books fetchByuserId_First(
		long userId, OrderByComparator<Books> orderByComparator) {

		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last books in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books
	 * @throws NoSuchBooksException if a matching books could not be found
	 */
	public static Books findByuserId_Last(
			long userId, OrderByComparator<Books> orderByComparator)
		throws org.books.exception.NoSuchBooksException {

		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last books in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books, or <code>null</code> if a matching books could not be found
	 */
	public static Books fetchByuserId_Last(
		long userId, OrderByComparator<Books> orderByComparator) {

		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the bookses before and after the current books in the ordered set where userId = &#63;.
	 *
	 * @param bookId the primary key of the current books
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next books
	 * @throws NoSuchBooksException if a books with the primary key could not be found
	 */
	public static Books[] findByuserId_PrevAndNext(
			long bookId, long userId,
			OrderByComparator<Books> orderByComparator)
		throws org.books.exception.NoSuchBooksException {

		return getPersistence().findByuserId_PrevAndNext(
			bookId, userId, orderByComparator);
	}

	/**
	 * Removes all the bookses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByuserId(long userId) {
		getPersistence().removeByuserId(userId);
	}

	/**
	 * Returns the number of bookses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching bookses
	 */
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	 * Caches the books in the entity cache if it is enabled.
	 *
	 * @param books the books
	 */
	public static void cacheResult(Books books) {
		getPersistence().cacheResult(books);
	}

	/**
	 * Caches the bookses in the entity cache if it is enabled.
	 *
	 * @param bookses the bookses
	 */
	public static void cacheResult(List<Books> bookses) {
		getPersistence().cacheResult(bookses);
	}

	/**
	 * Creates a new books with the primary key. Does not add the books to the database.
	 *
	 * @param bookId the primary key for the new books
	 * @return the new books
	 */
	public static Books create(long bookId) {
		return getPersistence().create(bookId);
	}

	/**
	 * Removes the books with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookId the primary key of the books
	 * @return the books that was removed
	 * @throws NoSuchBooksException if a books with the primary key could not be found
	 */
	public static Books remove(long bookId)
		throws org.books.exception.NoSuchBooksException {

		return getPersistence().remove(bookId);
	}

	public static Books updateImpl(Books books) {
		return getPersistence().updateImpl(books);
	}

	/**
	 * Returns the books with the primary key or throws a <code>NoSuchBooksException</code> if it could not be found.
	 *
	 * @param bookId the primary key of the books
	 * @return the books
	 * @throws NoSuchBooksException if a books with the primary key could not be found
	 */
	public static Books findByPrimaryKey(long bookId)
		throws org.books.exception.NoSuchBooksException {

		return getPersistence().findByPrimaryKey(bookId);
	}

	/**
	 * Returns the books with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookId the primary key of the books
	 * @return the books, or <code>null</code> if a books with the primary key could not be found
	 */
	public static Books fetchByPrimaryKey(long bookId) {
		return getPersistence().fetchByPrimaryKey(bookId);
	}

	/**
	 * Returns all the bookses.
	 *
	 * @return the bookses
	 */
	public static List<Books> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the bookses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BooksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bookses
	 * @param end the upper bound of the range of bookses (not inclusive)
	 * @return the range of bookses
	 */
	public static List<Books> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the bookses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BooksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bookses
	 * @param end the upper bound of the range of bookses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bookses
	 */
	public static List<Books> findAll(
		int start, int end, OrderByComparator<Books> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the bookses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BooksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bookses
	 * @param end the upper bound of the range of bookses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of bookses
	 */
	public static List<Books> findAll(
		int start, int end, OrderByComparator<Books> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the bookses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of bookses.
	 *
	 * @return the number of bookses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BooksPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BooksPersistence, BooksPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(BooksPersistence.class);

		ServiceTracker<BooksPersistence, BooksPersistence> serviceTracker =
			new ServiceTracker<BooksPersistence, BooksPersistence>(
				bundle.getBundleContext(), BooksPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}