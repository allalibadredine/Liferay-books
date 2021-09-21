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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.books.exception.NoSuchBooksException;
import org.books.model.Books;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the books service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BooksUtil
 * @generated
 */
@ProviderType
public interface BooksPersistence extends BasePersistence<Books> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BooksUtil} to access the books persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the bookses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching bookses
	 */
	public java.util.List<Books> findByUuid(String uuid);

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
	public java.util.List<Books> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Books> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Books>
			orderByComparator);

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
	public java.util.List<Books> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Books>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first books in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books
	 * @throws NoSuchBooksException if a matching books could not be found
	 */
	public Books findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Books>
				orderByComparator)
		throws NoSuchBooksException;

	/**
	 * Returns the first books in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books, or <code>null</code> if a matching books could not be found
	 */
	public Books fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Books>
			orderByComparator);

	/**
	 * Returns the last books in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books
	 * @throws NoSuchBooksException if a matching books could not be found
	 */
	public Books findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Books>
				orderByComparator)
		throws NoSuchBooksException;

	/**
	 * Returns the last books in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books, or <code>null</code> if a matching books could not be found
	 */
	public Books fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Books>
			orderByComparator);

	/**
	 * Returns the bookses before and after the current books in the ordered set where uuid = &#63;.
	 *
	 * @param bookId the primary key of the current books
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next books
	 * @throws NoSuchBooksException if a books with the primary key could not be found
	 */
	public Books[] findByUuid_PrevAndNext(
			long bookId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Books>
				orderByComparator)
		throws NoSuchBooksException;

	/**
	 * Removes all the bookses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of bookses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching bookses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the books where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBooksException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching books
	 * @throws NoSuchBooksException if a matching books could not be found
	 */
	public Books findByUUID_G(String uuid, long groupId)
		throws NoSuchBooksException;

	/**
	 * Returns the books where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching books, or <code>null</code> if a matching books could not be found
	 */
	public Books fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the books where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching books, or <code>null</code> if a matching books could not be found
	 */
	public Books fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the books where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the books that was removed
	 */
	public Books removeByUUID_G(String uuid, long groupId)
		throws NoSuchBooksException;

	/**
	 * Returns the number of bookses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching bookses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the bookses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching bookses
	 */
	public java.util.List<Books> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Books> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Books> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Books>
			orderByComparator);

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
	public java.util.List<Books> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Books>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first books in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books
	 * @throws NoSuchBooksException if a matching books could not be found
	 */
	public Books findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Books>
				orderByComparator)
		throws NoSuchBooksException;

	/**
	 * Returns the first books in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books, or <code>null</code> if a matching books could not be found
	 */
	public Books fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Books>
			orderByComparator);

	/**
	 * Returns the last books in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books
	 * @throws NoSuchBooksException if a matching books could not be found
	 */
	public Books findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Books>
				orderByComparator)
		throws NoSuchBooksException;

	/**
	 * Returns the last books in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books, or <code>null</code> if a matching books could not be found
	 */
	public Books fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Books>
			orderByComparator);

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
	public Books[] findByUuid_C_PrevAndNext(
			long bookId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Books>
				orderByComparator)
		throws NoSuchBooksException;

	/**
	 * Removes all the bookses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of bookses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching bookses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the bookses where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching bookses
	 */
	public java.util.List<Books> findBytitle(String title);

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
	public java.util.List<Books> findBytitle(String title, int start, int end);

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
	public java.util.List<Books> findBytitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Books>
			orderByComparator);

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
	public java.util.List<Books> findBytitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Books>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first books in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books
	 * @throws NoSuchBooksException if a matching books could not be found
	 */
	public Books findBytitle_First(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<Books>
				orderByComparator)
		throws NoSuchBooksException;

	/**
	 * Returns the first books in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books, or <code>null</code> if a matching books could not be found
	 */
	public Books fetchBytitle_First(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<Books>
			orderByComparator);

	/**
	 * Returns the last books in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books
	 * @throws NoSuchBooksException if a matching books could not be found
	 */
	public Books findBytitle_Last(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<Books>
				orderByComparator)
		throws NoSuchBooksException;

	/**
	 * Returns the last books in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books, or <code>null</code> if a matching books could not be found
	 */
	public Books fetchBytitle_Last(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<Books>
			orderByComparator);

	/**
	 * Returns the bookses before and after the current books in the ordered set where title = &#63;.
	 *
	 * @param bookId the primary key of the current books
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next books
	 * @throws NoSuchBooksException if a books with the primary key could not be found
	 */
	public Books[] findBytitle_PrevAndNext(
			long bookId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<Books>
				orderByComparator)
		throws NoSuchBooksException;

	/**
	 * Removes all the bookses where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	public void removeBytitle(String title);

	/**
	 * Returns the number of bookses where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching bookses
	 */
	public int countBytitle(String title);

	/**
	 * Returns all the bookses where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @return the matching bookses
	 */
	public java.util.List<Books> findByauthorId(String authorId);

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
	public java.util.List<Books> findByauthorId(
		String authorId, int start, int end);

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
	public java.util.List<Books> findByauthorId(
		String authorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Books>
			orderByComparator);

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
	public java.util.List<Books> findByauthorId(
		String authorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Books>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first books in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books
	 * @throws NoSuchBooksException if a matching books could not be found
	 */
	public Books findByauthorId_First(
			String authorId,
			com.liferay.portal.kernel.util.OrderByComparator<Books>
				orderByComparator)
		throws NoSuchBooksException;

	/**
	 * Returns the first books in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books, or <code>null</code> if a matching books could not be found
	 */
	public Books fetchByauthorId_First(
		String authorId,
		com.liferay.portal.kernel.util.OrderByComparator<Books>
			orderByComparator);

	/**
	 * Returns the last books in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books
	 * @throws NoSuchBooksException if a matching books could not be found
	 */
	public Books findByauthorId_Last(
			String authorId,
			com.liferay.portal.kernel.util.OrderByComparator<Books>
				orderByComparator)
		throws NoSuchBooksException;

	/**
	 * Returns the last books in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books, or <code>null</code> if a matching books could not be found
	 */
	public Books fetchByauthorId_Last(
		String authorId,
		com.liferay.portal.kernel.util.OrderByComparator<Books>
			orderByComparator);

	/**
	 * Returns the bookses before and after the current books in the ordered set where authorId = &#63;.
	 *
	 * @param bookId the primary key of the current books
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next books
	 * @throws NoSuchBooksException if a books with the primary key could not be found
	 */
	public Books[] findByauthorId_PrevAndNext(
			long bookId, String authorId,
			com.liferay.portal.kernel.util.OrderByComparator<Books>
				orderByComparator)
		throws NoSuchBooksException;

	/**
	 * Removes all the bookses where authorId = &#63; from the database.
	 *
	 * @param authorId the author ID
	 */
	public void removeByauthorId(String authorId);

	/**
	 * Returns the number of bookses where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @return the number of matching bookses
	 */
	public int countByauthorId(String authorId);

	/**
	 * Returns all the bookses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching bookses
	 */
	public java.util.List<Books> findByuserId(long userId);

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
	public java.util.List<Books> findByuserId(long userId, int start, int end);

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
	public java.util.List<Books> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Books>
			orderByComparator);

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
	public java.util.List<Books> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Books>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first books in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books
	 * @throws NoSuchBooksException if a matching books could not be found
	 */
	public Books findByuserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Books>
				orderByComparator)
		throws NoSuchBooksException;

	/**
	 * Returns the first books in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching books, or <code>null</code> if a matching books could not be found
	 */
	public Books fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Books>
			orderByComparator);

	/**
	 * Returns the last books in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books
	 * @throws NoSuchBooksException if a matching books could not be found
	 */
	public Books findByuserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Books>
				orderByComparator)
		throws NoSuchBooksException;

	/**
	 * Returns the last books in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching books, or <code>null</code> if a matching books could not be found
	 */
	public Books fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Books>
			orderByComparator);

	/**
	 * Returns the bookses before and after the current books in the ordered set where userId = &#63;.
	 *
	 * @param bookId the primary key of the current books
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next books
	 * @throws NoSuchBooksException if a books with the primary key could not be found
	 */
	public Books[] findByuserId_PrevAndNext(
			long bookId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Books>
				orderByComparator)
		throws NoSuchBooksException;

	/**
	 * Removes all the bookses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByuserId(long userId);

	/**
	 * Returns the number of bookses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching bookses
	 */
	public int countByuserId(long userId);

	/**
	 * Caches the books in the entity cache if it is enabled.
	 *
	 * @param books the books
	 */
	public void cacheResult(Books books);

	/**
	 * Caches the bookses in the entity cache if it is enabled.
	 *
	 * @param bookses the bookses
	 */
	public void cacheResult(java.util.List<Books> bookses);

	/**
	 * Creates a new books with the primary key. Does not add the books to the database.
	 *
	 * @param bookId the primary key for the new books
	 * @return the new books
	 */
	public Books create(long bookId);

	/**
	 * Removes the books with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookId the primary key of the books
	 * @return the books that was removed
	 * @throws NoSuchBooksException if a books with the primary key could not be found
	 */
	public Books remove(long bookId) throws NoSuchBooksException;

	public Books updateImpl(Books books);

	/**
	 * Returns the books with the primary key or throws a <code>NoSuchBooksException</code> if it could not be found.
	 *
	 * @param bookId the primary key of the books
	 * @return the books
	 * @throws NoSuchBooksException if a books with the primary key could not be found
	 */
	public Books findByPrimaryKey(long bookId) throws NoSuchBooksException;

	/**
	 * Returns the books with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookId the primary key of the books
	 * @return the books, or <code>null</code> if a books with the primary key could not be found
	 */
	public Books fetchByPrimaryKey(long bookId);

	/**
	 * Returns all the bookses.
	 *
	 * @return the bookses
	 */
	public java.util.List<Books> findAll();

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
	public java.util.List<Books> findAll(int start, int end);

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
	public java.util.List<Books> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Books>
			orderByComparator);

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
	public java.util.List<Books> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Books>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the bookses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of bookses.
	 *
	 * @return the number of bookses
	 */
	public int countAll();

}