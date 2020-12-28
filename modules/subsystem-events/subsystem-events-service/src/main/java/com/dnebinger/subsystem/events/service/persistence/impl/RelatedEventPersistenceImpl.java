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

import com.dnebinger.subsystem.events.exception.NoSuchRelatedEventException;
import com.dnebinger.subsystem.events.model.RelatedEvent;
import com.dnebinger.subsystem.events.model.impl.RelatedEventImpl;
import com.dnebinger.subsystem.events.model.impl.RelatedEventModelImpl;
import com.dnebinger.subsystem.events.service.persistence.RelatedEventPersistence;

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
 * The persistence implementation for the related event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RelatedEventPersistenceImpl
	extends BasePersistenceImpl<RelatedEvent>
	implements RelatedEventPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RelatedEventUtil</code> to access the related event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RelatedEventImpl.class.getName();

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
	 * Returns all the related events where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the matching related events
	 */
	@Override
	public List<RelatedEvent> findByEventId(long eventId) {
		return findByEventId(
			eventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the related events where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RelatedEventModelImpl</code>.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of related events
	 * @param end the upper bound of the range of related events (not inclusive)
	 * @return the range of matching related events
	 */
	@Override
	public List<RelatedEvent> findByEventId(long eventId, int start, int end) {
		return findByEventId(eventId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the related events where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RelatedEventModelImpl</code>.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of related events
	 * @param end the upper bound of the range of related events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching related events
	 */
	@Override
	public List<RelatedEvent> findByEventId(
		long eventId, int start, int end,
		OrderByComparator<RelatedEvent> orderByComparator) {

		return findByEventId(eventId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the related events where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RelatedEventModelImpl</code>.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of related events
	 * @param end the upper bound of the range of related events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching related events
	 */
	@Override
	public List<RelatedEvent> findByEventId(
		long eventId, int start, int end,
		OrderByComparator<RelatedEvent> orderByComparator,
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

		List<RelatedEvent> list = null;

		if (useFinderCache) {
			list = (List<RelatedEvent>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RelatedEvent relatedEvent : list) {
					if (eventId != relatedEvent.getEventId()) {
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

			sb.append(_SQL_SELECT_RELATEDEVENT_WHERE);

			sb.append(_FINDER_COLUMN_EVENTID_EVENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RelatedEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(eventId);

				list = (List<RelatedEvent>)QueryUtil.list(
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
	 * Returns the first related event in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching related event
	 * @throws NoSuchRelatedEventException if a matching related event could not be found
	 */
	@Override
	public RelatedEvent findByEventId_First(
			long eventId, OrderByComparator<RelatedEvent> orderByComparator)
		throws NoSuchRelatedEventException {

		RelatedEvent relatedEvent = fetchByEventId_First(
			eventId, orderByComparator);

		if (relatedEvent != null) {
			return relatedEvent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("eventId=");
		sb.append(eventId);

		sb.append("}");

		throw new NoSuchRelatedEventException(sb.toString());
	}

	/**
	 * Returns the first related event in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching related event, or <code>null</code> if a matching related event could not be found
	 */
	@Override
	public RelatedEvent fetchByEventId_First(
		long eventId, OrderByComparator<RelatedEvent> orderByComparator) {

		List<RelatedEvent> list = findByEventId(
			eventId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last related event in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching related event
	 * @throws NoSuchRelatedEventException if a matching related event could not be found
	 */
	@Override
	public RelatedEvent findByEventId_Last(
			long eventId, OrderByComparator<RelatedEvent> orderByComparator)
		throws NoSuchRelatedEventException {

		RelatedEvent relatedEvent = fetchByEventId_Last(
			eventId, orderByComparator);

		if (relatedEvent != null) {
			return relatedEvent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("eventId=");
		sb.append(eventId);

		sb.append("}");

		throw new NoSuchRelatedEventException(sb.toString());
	}

	/**
	 * Returns the last related event in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching related event, or <code>null</code> if a matching related event could not be found
	 */
	@Override
	public RelatedEvent fetchByEventId_Last(
		long eventId, OrderByComparator<RelatedEvent> orderByComparator) {

		int count = countByEventId(eventId);

		if (count == 0) {
			return null;
		}

		List<RelatedEvent> list = findByEventId(
			eventId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the related events before and after the current related event in the ordered set where eventId = &#63;.
	 *
	 * @param surrogateId the primary key of the current related event
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next related event
	 * @throws NoSuchRelatedEventException if a related event with the primary key could not be found
	 */
	@Override
	public RelatedEvent[] findByEventId_PrevAndNext(
			long surrogateId, long eventId,
			OrderByComparator<RelatedEvent> orderByComparator)
		throws NoSuchRelatedEventException {

		RelatedEvent relatedEvent = findByPrimaryKey(surrogateId);

		Session session = null;

		try {
			session = openSession();

			RelatedEvent[] array = new RelatedEventImpl[3];

			array[0] = getByEventId_PrevAndNext(
				session, relatedEvent, eventId, orderByComparator, true);

			array[1] = relatedEvent;

			array[2] = getByEventId_PrevAndNext(
				session, relatedEvent, eventId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RelatedEvent getByEventId_PrevAndNext(
		Session session, RelatedEvent relatedEvent, long eventId,
		OrderByComparator<RelatedEvent> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_RELATEDEVENT_WHERE);

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
			sb.append(RelatedEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(eventId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(relatedEvent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RelatedEvent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the related events where eventId = &#63; from the database.
	 *
	 * @param eventId the event ID
	 */
	@Override
	public void removeByEventId(long eventId) {
		for (RelatedEvent relatedEvent :
				findByEventId(
					eventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(relatedEvent);
		}
	}

	/**
	 * Returns the number of related events where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the number of matching related events
	 */
	@Override
	public int countByEventId(long eventId) {
		FinderPath finderPath = _finderPathCountByEventId;

		Object[] finderArgs = new Object[] {eventId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RELATEDEVENT_WHERE);

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
		"relatedEvent.eventId = ?";

	public RelatedEventPersistenceImpl() {
		setModelClass(RelatedEvent.class);

		setModelImplClass(RelatedEventImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the related event in the entity cache if it is enabled.
	 *
	 * @param relatedEvent the related event
	 */
	@Override
	public void cacheResult(RelatedEvent relatedEvent) {
		entityCache.putResult(
			RelatedEventImpl.class, relatedEvent.getPrimaryKey(), relatedEvent);
	}

	/**
	 * Caches the related events in the entity cache if it is enabled.
	 *
	 * @param relatedEvents the related events
	 */
	@Override
	public void cacheResult(List<RelatedEvent> relatedEvents) {
		for (RelatedEvent relatedEvent : relatedEvents) {
			if (entityCache.getResult(
					RelatedEventImpl.class, relatedEvent.getPrimaryKey()) ==
						null) {

				cacheResult(relatedEvent);
			}
		}
	}

	/**
	 * Clears the cache for all related events.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RelatedEventImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the related event.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RelatedEvent relatedEvent) {
		entityCache.removeResult(RelatedEventImpl.class, relatedEvent);
	}

	@Override
	public void clearCache(List<RelatedEvent> relatedEvents) {
		for (RelatedEvent relatedEvent : relatedEvents) {
			entityCache.removeResult(RelatedEventImpl.class, relatedEvent);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(RelatedEventImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new related event with the primary key. Does not add the related event to the database.
	 *
	 * @param surrogateId the primary key for the new related event
	 * @return the new related event
	 */
	@Override
	public RelatedEvent create(long surrogateId) {
		RelatedEvent relatedEvent = new RelatedEventImpl();

		relatedEvent.setNew(true);
		relatedEvent.setPrimaryKey(surrogateId);

		return relatedEvent;
	}

	/**
	 * Removes the related event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param surrogateId the primary key of the related event
	 * @return the related event that was removed
	 * @throws NoSuchRelatedEventException if a related event with the primary key could not be found
	 */
	@Override
	public RelatedEvent remove(long surrogateId)
		throws NoSuchRelatedEventException {

		return remove((Serializable)surrogateId);
	}

	/**
	 * Removes the related event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the related event
	 * @return the related event that was removed
	 * @throws NoSuchRelatedEventException if a related event with the primary key could not be found
	 */
	@Override
	public RelatedEvent remove(Serializable primaryKey)
		throws NoSuchRelatedEventException {

		Session session = null;

		try {
			session = openSession();

			RelatedEvent relatedEvent = (RelatedEvent)session.get(
				RelatedEventImpl.class, primaryKey);

			if (relatedEvent == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRelatedEventException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(relatedEvent);
		}
		catch (NoSuchRelatedEventException noSuchEntityException) {
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
	protected RelatedEvent removeImpl(RelatedEvent relatedEvent) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(relatedEvent)) {
				relatedEvent = (RelatedEvent)session.get(
					RelatedEventImpl.class, relatedEvent.getPrimaryKeyObj());
			}

			if (relatedEvent != null) {
				session.delete(relatedEvent);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (relatedEvent != null) {
			clearCache(relatedEvent);
		}

		return relatedEvent;
	}

	@Override
	public RelatedEvent updateImpl(RelatedEvent relatedEvent) {
		boolean isNew = relatedEvent.isNew();

		if (!(relatedEvent instanceof RelatedEventModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(relatedEvent.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					relatedEvent);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in relatedEvent proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RelatedEvent implementation " +
					relatedEvent.getClass());
		}

		RelatedEventModelImpl relatedEventModelImpl =
			(RelatedEventModelImpl)relatedEvent;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(relatedEvent);
			}
			else {
				relatedEvent = (RelatedEvent)session.merge(relatedEvent);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			RelatedEventImpl.class, relatedEventModelImpl, false, true);

		if (isNew) {
			relatedEvent.setNew(false);
		}

		relatedEvent.resetOriginalValues();

		return relatedEvent;
	}

	/**
	 * Returns the related event with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the related event
	 * @return the related event
	 * @throws NoSuchRelatedEventException if a related event with the primary key could not be found
	 */
	@Override
	public RelatedEvent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRelatedEventException {

		RelatedEvent relatedEvent = fetchByPrimaryKey(primaryKey);

		if (relatedEvent == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRelatedEventException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return relatedEvent;
	}

	/**
	 * Returns the related event with the primary key or throws a <code>NoSuchRelatedEventException</code> if it could not be found.
	 *
	 * @param surrogateId the primary key of the related event
	 * @return the related event
	 * @throws NoSuchRelatedEventException if a related event with the primary key could not be found
	 */
	@Override
	public RelatedEvent findByPrimaryKey(long surrogateId)
		throws NoSuchRelatedEventException {

		return findByPrimaryKey((Serializable)surrogateId);
	}

	/**
	 * Returns the related event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param surrogateId the primary key of the related event
	 * @return the related event, or <code>null</code> if a related event with the primary key could not be found
	 */
	@Override
	public RelatedEvent fetchByPrimaryKey(long surrogateId) {
		return fetchByPrimaryKey((Serializable)surrogateId);
	}

	/**
	 * Returns all the related events.
	 *
	 * @return the related events
	 */
	@Override
	public List<RelatedEvent> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the related events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RelatedEventModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of related events
	 * @param end the upper bound of the range of related events (not inclusive)
	 * @return the range of related events
	 */
	@Override
	public List<RelatedEvent> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the related events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RelatedEventModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of related events
	 * @param end the upper bound of the range of related events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of related events
	 */
	@Override
	public List<RelatedEvent> findAll(
		int start, int end, OrderByComparator<RelatedEvent> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the related events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RelatedEventModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of related events
	 * @param end the upper bound of the range of related events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of related events
	 */
	@Override
	public List<RelatedEvent> findAll(
		int start, int end, OrderByComparator<RelatedEvent> orderByComparator,
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

		List<RelatedEvent> list = null;

		if (useFinderCache) {
			list = (List<RelatedEvent>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_RELATEDEVENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_RELATEDEVENT;

				sql = sql.concat(RelatedEventModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RelatedEvent>)QueryUtil.list(
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
	 * Removes all the related events from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RelatedEvent relatedEvent : findAll()) {
			remove(relatedEvent);
		}
	}

	/**
	 * Returns the number of related events.
	 *
	 * @return the number of related events
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_RELATEDEVENT);

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
		return _SQL_SELECT_RELATEDEVENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RelatedEventModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the related event persistence.
	 */
	public void afterPropertiesSet() {
		Bundle bundle = FrameworkUtil.getBundle(
			RelatedEventPersistenceImpl.class);

		_bundleContext = bundle.getBundleContext();

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new RelatedEventModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", RelatedEvent.class.getName()));

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
		entityCache.removeCache(RelatedEventImpl.class.getName());

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

	private static final String _SQL_SELECT_RELATEDEVENT =
		"SELECT relatedEvent FROM RelatedEvent relatedEvent";

	private static final String _SQL_SELECT_RELATEDEVENT_WHERE =
		"SELECT relatedEvent FROM RelatedEvent relatedEvent WHERE ";

	private static final String _SQL_COUNT_RELATEDEVENT =
		"SELECT COUNT(relatedEvent) FROM RelatedEvent relatedEvent";

	private static final String _SQL_COUNT_RELATEDEVENT_WHERE =
		"SELECT COUNT(relatedEvent) FROM RelatedEvent relatedEvent WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "relatedEvent.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RelatedEvent exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RelatedEvent exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RelatedEventPersistenceImpl.class);

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

	private static class RelatedEventModelArgumentsResolver
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

			RelatedEventModelImpl relatedEventModelImpl =
				(RelatedEventModelImpl)baseModel;

			long columnBitmask = relatedEventModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(relatedEventModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						relatedEventModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(relatedEventModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			RelatedEventModelImpl relatedEventModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = relatedEventModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = relatedEventModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}