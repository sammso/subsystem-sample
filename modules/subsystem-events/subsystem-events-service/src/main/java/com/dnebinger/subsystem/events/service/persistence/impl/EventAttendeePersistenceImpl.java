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

package com.dnebinger.subsystem.events.service.persistence.impl;

import com.dnebinger.subsystem.events.exception.NoSuchEventAttendeeException;
import com.dnebinger.subsystem.events.model.EventAttendee;
import com.dnebinger.subsystem.events.model.impl.EventAttendeeImpl;
import com.dnebinger.subsystem.events.model.impl.EventAttendeeModelImpl;
import com.dnebinger.subsystem.events.service.persistence.EventAttendeePersistence;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceRegistration;

/**
 * The persistence implementation for the event attendee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EventAttendeePersistenceImpl
	extends BasePersistenceImpl<EventAttendee>
	implements EventAttendeePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EventAttendeeUtil</code> to access the event attendee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EventAttendeeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByEventId;
	private FinderPath _finderPathWithoutPaginationFindByEventId;
	private FinderPath _finderPathCountByEventId;

	/**
	 * Returns all the event attendees where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the matching event attendees
	 */
	@Override
	public List<EventAttendee> findByEventId(long eventId) {
		return findByEventId(
			eventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event attendees where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventAttendeeModelImpl</code>.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of event attendees
	 * @param end the upper bound of the range of event attendees (not inclusive)
	 * @return the range of matching event attendees
	 */
	@Override
	public List<EventAttendee> findByEventId(long eventId, int start, int end) {
		return findByEventId(eventId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the event attendees where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventAttendeeModelImpl</code>.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of event attendees
	 * @param end the upper bound of the range of event attendees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event attendees
	 */
	@Override
	public List<EventAttendee> findByEventId(
		long eventId, int start, int end,
		OrderByComparator<EventAttendee> orderByComparator) {

		return findByEventId(eventId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the event attendees where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventAttendeeModelImpl</code>.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of event attendees
	 * @param end the upper bound of the range of event attendees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event attendees
	 */
	@Override
	public List<EventAttendee> findByEventId(
		long eventId, int start, int end,
		OrderByComparator<EventAttendee> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEventId;
				finderArgs = new Object[] {eventId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEventId;
			finderArgs = new Object[] {eventId, start, end, orderByComparator};
		}

		List<EventAttendee> list = null;

		if (useFinderCache) {
			list = (List<EventAttendee>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EventAttendee eventAttendee : list) {
					if (eventId != eventAttendee.getEventId()) {
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

			sb.append(_SQL_SELECT_EVENTATTENDEE_WHERE);

			sb.append(_FINDER_COLUMN_EVENTID_EVENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EventAttendeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(eventId);

				list = (List<EventAttendee>)QueryUtil.list(
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
	 * Returns the first event attendee in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event attendee
	 * @throws NoSuchEventAttendeeException if a matching event attendee could not be found
	 */
	@Override
	public EventAttendee findByEventId_First(
			long eventId, OrderByComparator<EventAttendee> orderByComparator)
		throws NoSuchEventAttendeeException {

		EventAttendee eventAttendee = fetchByEventId_First(
			eventId, orderByComparator);

		if (eventAttendee != null) {
			return eventAttendee;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("eventId=");
		sb.append(eventId);

		sb.append("}");

		throw new NoSuchEventAttendeeException(sb.toString());
	}

	/**
	 * Returns the first event attendee in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event attendee, or <code>null</code> if a matching event attendee could not be found
	 */
	@Override
	public EventAttendee fetchByEventId_First(
		long eventId, OrderByComparator<EventAttendee> orderByComparator) {

		List<EventAttendee> list = findByEventId(
			eventId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last event attendee in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event attendee
	 * @throws NoSuchEventAttendeeException if a matching event attendee could not be found
	 */
	@Override
	public EventAttendee findByEventId_Last(
			long eventId, OrderByComparator<EventAttendee> orderByComparator)
		throws NoSuchEventAttendeeException {

		EventAttendee eventAttendee = fetchByEventId_Last(
			eventId, orderByComparator);

		if (eventAttendee != null) {
			return eventAttendee;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("eventId=");
		sb.append(eventId);

		sb.append("}");

		throw new NoSuchEventAttendeeException(sb.toString());
	}

	/**
	 * Returns the last event attendee in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event attendee, or <code>null</code> if a matching event attendee could not be found
	 */
	@Override
	public EventAttendee fetchByEventId_Last(
		long eventId, OrderByComparator<EventAttendee> orderByComparator) {

		int count = countByEventId(eventId);

		if (count == 0) {
			return null;
		}

		List<EventAttendee> list = findByEventId(
			eventId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the event attendees before and after the current event attendee in the ordered set where eventId = &#63;.
	 *
	 * @param surrogateId the primary key of the current event attendee
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event attendee
	 * @throws NoSuchEventAttendeeException if a event attendee with the primary key could not be found
	 */
	@Override
	public EventAttendee[] findByEventId_PrevAndNext(
			long surrogateId, long eventId,
			OrderByComparator<EventAttendee> orderByComparator)
		throws NoSuchEventAttendeeException {

		EventAttendee eventAttendee = findByPrimaryKey(surrogateId);

		Session session = null;

		try {
			session = openSession();

			EventAttendee[] array = new EventAttendeeImpl[3];

			array[0] = getByEventId_PrevAndNext(
				session, eventAttendee, eventId, orderByComparator, true);

			array[1] = eventAttendee;

			array[2] = getByEventId_PrevAndNext(
				session, eventAttendee, eventId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventAttendee getByEventId_PrevAndNext(
		Session session, EventAttendee eventAttendee, long eventId,
		OrderByComparator<EventAttendee> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EVENTATTENDEE_WHERE);

		sb.append(_FINDER_COLUMN_EVENTID_EVENTID_2);

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
			sb.append(EventAttendeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(eventId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						eventAttendee)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EventAttendee> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the event attendees where eventId = &#63; from the database.
	 *
	 * @param eventId the event ID
	 */
	@Override
	public void removeByEventId(long eventId) {
		for (EventAttendee eventAttendee :
				findByEventId(
					eventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(eventAttendee);
		}
	}

	/**
	 * Returns the number of event attendees where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the number of matching event attendees
	 */
	@Override
	public int countByEventId(long eventId) {
		FinderPath finderPath = _finderPathCountByEventId;

		Object[] finderArgs = new Object[] {eventId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EVENTATTENDEE_WHERE);

			sb.append(_FINDER_COLUMN_EVENTID_EVENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(eventId);

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

	private static final String _FINDER_COLUMN_EVENTID_EVENTID_2 =
		"eventAttendee.eventId = ?";

	public EventAttendeePersistenceImpl() {
		setModelClass(EventAttendee.class);

		setModelImplClass(EventAttendeeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the event attendee in the entity cache if it is enabled.
	 *
	 * @param eventAttendee the event attendee
	 */
	@Override
	public void cacheResult(EventAttendee eventAttendee) {
		entityCache.putResult(
			EventAttendeeImpl.class, eventAttendee.getPrimaryKey(),
			eventAttendee);
	}

	/**
	 * Caches the event attendees in the entity cache if it is enabled.
	 *
	 * @param eventAttendees the event attendees
	 */
	@Override
	public void cacheResult(List<EventAttendee> eventAttendees) {
		for (EventAttendee eventAttendee : eventAttendees) {
			if (entityCache.getResult(
					EventAttendeeImpl.class, eventAttendee.getPrimaryKey()) ==
						null) {

				cacheResult(eventAttendee);
			}
		}
	}

	/**
	 * Clears the cache for all event attendees.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EventAttendeeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the event attendee.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EventAttendee eventAttendee) {
		entityCache.removeResult(EventAttendeeImpl.class, eventAttendee);
	}

	@Override
	public void clearCache(List<EventAttendee> eventAttendees) {
		for (EventAttendee eventAttendee : eventAttendees) {
			entityCache.removeResult(EventAttendeeImpl.class, eventAttendee);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EventAttendeeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new event attendee with the primary key. Does not add the event attendee to the database.
	 *
	 * @param surrogateId the primary key for the new event attendee
	 * @return the new event attendee
	 */
	@Override
	public EventAttendee create(long surrogateId) {
		EventAttendee eventAttendee = new EventAttendeeImpl();

		eventAttendee.setNew(true);
		eventAttendee.setPrimaryKey(surrogateId);

		return eventAttendee;
	}

	/**
	 * Removes the event attendee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param surrogateId the primary key of the event attendee
	 * @return the event attendee that was removed
	 * @throws NoSuchEventAttendeeException if a event attendee with the primary key could not be found
	 */
	@Override
	public EventAttendee remove(long surrogateId)
		throws NoSuchEventAttendeeException {

		return remove((Serializable)surrogateId);
	}

	/**
	 * Removes the event attendee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the event attendee
	 * @return the event attendee that was removed
	 * @throws NoSuchEventAttendeeException if a event attendee with the primary key could not be found
	 */
	@Override
	public EventAttendee remove(Serializable primaryKey)
		throws NoSuchEventAttendeeException {

		Session session = null;

		try {
			session = openSession();

			EventAttendee eventAttendee = (EventAttendee)session.get(
				EventAttendeeImpl.class, primaryKey);

			if (eventAttendee == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventAttendeeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(eventAttendee);
		}
		catch (NoSuchEventAttendeeException noSuchEntityException) {
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
	protected EventAttendee removeImpl(EventAttendee eventAttendee) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eventAttendee)) {
				eventAttendee = (EventAttendee)session.get(
					EventAttendeeImpl.class, eventAttendee.getPrimaryKeyObj());
			}

			if (eventAttendee != null) {
				session.delete(eventAttendee);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (eventAttendee != null) {
			clearCache(eventAttendee);
		}

		return eventAttendee;
	}

	@Override
	public EventAttendee updateImpl(EventAttendee eventAttendee) {
		boolean isNew = eventAttendee.isNew();

		if (!(eventAttendee instanceof EventAttendeeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(eventAttendee.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					eventAttendee);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in eventAttendee proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EventAttendee implementation " +
					eventAttendee.getClass());
		}

		EventAttendeeModelImpl eventAttendeeModelImpl =
			(EventAttendeeModelImpl)eventAttendee;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(eventAttendee);
			}
			else {
				eventAttendee = (EventAttendee)session.merge(eventAttendee);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EventAttendeeImpl.class, eventAttendeeModelImpl, false, true);

		if (isNew) {
			eventAttendee.setNew(false);
		}

		eventAttendee.resetOriginalValues();

		return eventAttendee;
	}

	/**
	 * Returns the event attendee with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the event attendee
	 * @return the event attendee
	 * @throws NoSuchEventAttendeeException if a event attendee with the primary key could not be found
	 */
	@Override
	public EventAttendee findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEventAttendeeException {

		EventAttendee eventAttendee = fetchByPrimaryKey(primaryKey);

		if (eventAttendee == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEventAttendeeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return eventAttendee;
	}

	/**
	 * Returns the event attendee with the primary key or throws a <code>NoSuchEventAttendeeException</code> if it could not be found.
	 *
	 * @param surrogateId the primary key of the event attendee
	 * @return the event attendee
	 * @throws NoSuchEventAttendeeException if a event attendee with the primary key could not be found
	 */
	@Override
	public EventAttendee findByPrimaryKey(long surrogateId)
		throws NoSuchEventAttendeeException {

		return findByPrimaryKey((Serializable)surrogateId);
	}

	/**
	 * Returns the event attendee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param surrogateId the primary key of the event attendee
	 * @return the event attendee, or <code>null</code> if a event attendee with the primary key could not be found
	 */
	@Override
	public EventAttendee fetchByPrimaryKey(long surrogateId) {
		return fetchByPrimaryKey((Serializable)surrogateId);
	}

	/**
	 * Returns all the event attendees.
	 *
	 * @return the event attendees
	 */
	@Override
	public List<EventAttendee> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event attendees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventAttendeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event attendees
	 * @param end the upper bound of the range of event attendees (not inclusive)
	 * @return the range of event attendees
	 */
	@Override
	public List<EventAttendee> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the event attendees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventAttendeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event attendees
	 * @param end the upper bound of the range of event attendees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of event attendees
	 */
	@Override
	public List<EventAttendee> findAll(
		int start, int end,
		OrderByComparator<EventAttendee> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the event attendees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventAttendeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event attendees
	 * @param end the upper bound of the range of event attendees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of event attendees
	 */
	@Override
	public List<EventAttendee> findAll(
		int start, int end, OrderByComparator<EventAttendee> orderByComparator,
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

		List<EventAttendee> list = null;

		if (useFinderCache) {
			list = (List<EventAttendee>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EVENTATTENDEE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EVENTATTENDEE;

				sql = sql.concat(EventAttendeeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EventAttendee>)QueryUtil.list(
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
	 * Removes all the event attendees from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EventAttendee eventAttendee : findAll()) {
			remove(eventAttendee);
		}
	}

	/**
	 * Returns the number of event attendees.
	 *
	 * @return the number of event attendees
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EVENTATTENDEE);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "surrogateId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EVENTATTENDEE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EventAttendeeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the event attendee persistence.
	 */
	public void afterPropertiesSet() {
		Bundle bundle = FrameworkUtil.getBundle(
			EventAttendeePersistenceImpl.class);

		_bundleContext = bundle.getBundleContext();

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new EventAttendeeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", EventAttendee.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByEventId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEventId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"eventId"}, true);

		_finderPathWithoutPaginationFindByEventId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEventId",
			new String[] {Long.class.getName()}, new String[] {"eventId"},
			true);

		_finderPathCountByEventId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEventId",
			new String[] {Long.class.getName()}, new String[] {"eventId"},
			false);
	}

	public void destroy() {
		entityCache.removeCache(EventAttendeeImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private BundleContext _bundleContext;

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_EVENTATTENDEE =
		"SELECT eventAttendee FROM EventAttendee eventAttendee";

	private static final String _SQL_SELECT_EVENTATTENDEE_WHERE =
		"SELECT eventAttendee FROM EventAttendee eventAttendee WHERE ";

	private static final String _SQL_COUNT_EVENTATTENDEE =
		"SELECT COUNT(eventAttendee) FROM EventAttendee eventAttendee";

	private static final String _SQL_COUNT_EVENTATTENDEE_WHERE =
		"SELECT COUNT(eventAttendee) FROM EventAttendee eventAttendee WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "eventAttendee.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EventAttendee exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EventAttendee exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EventAttendeePersistenceImpl.class);

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

	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;
	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();

	private static class EventAttendeeModelArgumentsResolver
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

			EventAttendeeModelImpl eventAttendeeModelImpl =
				(EventAttendeeModelImpl)baseModel;

			long columnBitmask = eventAttendeeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(eventAttendeeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						eventAttendeeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(eventAttendeeModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			EventAttendeeModelImpl eventAttendeeModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						eventAttendeeModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = eventAttendeeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}