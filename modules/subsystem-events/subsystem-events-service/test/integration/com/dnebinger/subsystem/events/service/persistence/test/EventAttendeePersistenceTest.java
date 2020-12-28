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

package com.dnebinger.subsystem.events.service.persistence.test;

import com.dnebinger.subsystem.events.exception.NoSuchEventAttendeeException;
import com.dnebinger.subsystem.events.model.EventAttendee;
import com.dnebinger.subsystem.events.service.EventAttendeeLocalServiceUtil;
import com.dnebinger.subsystem.events.service.persistence.EventAttendeePersistence;
import com.dnebinger.subsystem.events.service.persistence.EventAttendeeUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class EventAttendeePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED,
				"com.dnebinger.subsystem.events.service"));

	@Before
	public void setUp() {
		_persistence = EventAttendeeUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<EventAttendee> iterator = _eventAttendees.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EventAttendee eventAttendee = _persistence.create(pk);

		Assert.assertNotNull(eventAttendee);

		Assert.assertEquals(eventAttendee.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		EventAttendee newEventAttendee = addEventAttendee();

		_persistence.remove(newEventAttendee);

		EventAttendee existingEventAttendee = _persistence.fetchByPrimaryKey(
			newEventAttendee.getPrimaryKey());

		Assert.assertNull(existingEventAttendee);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEventAttendee();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EventAttendee newEventAttendee = _persistence.create(pk);

		newEventAttendee.setEventId(RandomTestUtil.nextLong());

		newEventAttendee.setUserId(RandomTestUtil.nextLong());

		_eventAttendees.add(_persistence.update(newEventAttendee));

		EventAttendee existingEventAttendee = _persistence.findByPrimaryKey(
			newEventAttendee.getPrimaryKey());

		Assert.assertEquals(
			existingEventAttendee.getSurrogateId(),
			newEventAttendee.getSurrogateId());
		Assert.assertEquals(
			existingEventAttendee.getEventId(), newEventAttendee.getEventId());
		Assert.assertEquals(
			existingEventAttendee.getUserId(), newEventAttendee.getUserId());
	}

	@Test
	public void testCountByEventId() throws Exception {
		_persistence.countByEventId(RandomTestUtil.nextLong());

		_persistence.countByEventId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		EventAttendee newEventAttendee = addEventAttendee();

		EventAttendee existingEventAttendee = _persistence.findByPrimaryKey(
			newEventAttendee.getPrimaryKey());

		Assert.assertEquals(existingEventAttendee, newEventAttendee);
	}

	@Test(expected = NoSuchEventAttendeeException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<EventAttendee> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SUBSYS_EventAttendee", "surrogateId", true, "eventId", true,
			"userId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		EventAttendee newEventAttendee = addEventAttendee();

		EventAttendee existingEventAttendee = _persistence.fetchByPrimaryKey(
			newEventAttendee.getPrimaryKey());

		Assert.assertEquals(existingEventAttendee, newEventAttendee);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EventAttendee missingEventAttendee = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEventAttendee);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		EventAttendee newEventAttendee1 = addEventAttendee();
		EventAttendee newEventAttendee2 = addEventAttendee();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEventAttendee1.getPrimaryKey());
		primaryKeys.add(newEventAttendee2.getPrimaryKey());

		Map<Serializable, EventAttendee> eventAttendees =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, eventAttendees.size());
		Assert.assertEquals(
			newEventAttendee1,
			eventAttendees.get(newEventAttendee1.getPrimaryKey()));
		Assert.assertEquals(
			newEventAttendee2,
			eventAttendees.get(newEventAttendee2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, EventAttendee> eventAttendees =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(eventAttendees.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		EventAttendee newEventAttendee = addEventAttendee();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEventAttendee.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, EventAttendee> eventAttendees =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, eventAttendees.size());
		Assert.assertEquals(
			newEventAttendee,
			eventAttendees.get(newEventAttendee.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, EventAttendee> eventAttendees =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(eventAttendees.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		EventAttendee newEventAttendee = addEventAttendee();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEventAttendee.getPrimaryKey());

		Map<Serializable, EventAttendee> eventAttendees =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, eventAttendees.size());
		Assert.assertEquals(
			newEventAttendee,
			eventAttendees.get(newEventAttendee.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			EventAttendeeLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<EventAttendee>() {

				@Override
				public void performAction(EventAttendee eventAttendee) {
					Assert.assertNotNull(eventAttendee);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		EventAttendee newEventAttendee = addEventAttendee();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EventAttendee.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"surrogateId", newEventAttendee.getSurrogateId()));

		List<EventAttendee> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		EventAttendee existingEventAttendee = result.get(0);

		Assert.assertEquals(existingEventAttendee, newEventAttendee);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EventAttendee.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"surrogateId", RandomTestUtil.nextLong()));

		List<EventAttendee> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		EventAttendee newEventAttendee = addEventAttendee();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EventAttendee.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("surrogateId"));

		Object newSurrogateId = newEventAttendee.getSurrogateId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"surrogateId", new Object[] {newSurrogateId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingSurrogateId = result.get(0);

		Assert.assertEquals(existingSurrogateId, newSurrogateId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			EventAttendee.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("surrogateId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"surrogateId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected EventAttendee addEventAttendee() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EventAttendee eventAttendee = _persistence.create(pk);

		eventAttendee.setEventId(RandomTestUtil.nextLong());

		eventAttendee.setUserId(RandomTestUtil.nextLong());

		_eventAttendees.add(_persistence.update(eventAttendee));

		return eventAttendee;
	}

	private List<EventAttendee> _eventAttendees =
		new ArrayList<EventAttendee>();
	private EventAttendeePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}