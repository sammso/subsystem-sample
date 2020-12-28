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

import com.dnebinger.subsystem.events.exception.NoSuchRelatedEventException;
import com.dnebinger.subsystem.events.model.RelatedEvent;
import com.dnebinger.subsystem.events.service.RelatedEventLocalServiceUtil;
import com.dnebinger.subsystem.events.service.persistence.RelatedEventPersistence;
import com.dnebinger.subsystem.events.service.persistence.RelatedEventUtil;

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
public class RelatedEventPersistenceTest {

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
		_persistence = RelatedEventUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<RelatedEvent> iterator = _relatedEvents.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RelatedEvent relatedEvent = _persistence.create(pk);

		Assert.assertNotNull(relatedEvent);

		Assert.assertEquals(relatedEvent.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		RelatedEvent newRelatedEvent = addRelatedEvent();

		_persistence.remove(newRelatedEvent);

		RelatedEvent existingRelatedEvent = _persistence.fetchByPrimaryKey(
			newRelatedEvent.getPrimaryKey());

		Assert.assertNull(existingRelatedEvent);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addRelatedEvent();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RelatedEvent newRelatedEvent = _persistence.create(pk);

		newRelatedEvent.setEventId(RandomTestUtil.nextLong());

		newRelatedEvent.setRelatedEventId(RandomTestUtil.nextLong());

		_relatedEvents.add(_persistence.update(newRelatedEvent));

		RelatedEvent existingRelatedEvent = _persistence.findByPrimaryKey(
			newRelatedEvent.getPrimaryKey());

		Assert.assertEquals(
			existingRelatedEvent.getSurrogateId(),
			newRelatedEvent.getSurrogateId());
		Assert.assertEquals(
			existingRelatedEvent.getEventId(), newRelatedEvent.getEventId());
		Assert.assertEquals(
			existingRelatedEvent.getRelatedEventId(),
			newRelatedEvent.getRelatedEventId());
	}

	@Test
	public void testCountByEventId() throws Exception {
		_persistence.countByEventId(RandomTestUtil.nextLong());

		_persistence.countByEventId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		RelatedEvent newRelatedEvent = addRelatedEvent();

		RelatedEvent existingRelatedEvent = _persistence.findByPrimaryKey(
			newRelatedEvent.getPrimaryKey());

		Assert.assertEquals(existingRelatedEvent, newRelatedEvent);
	}

	@Test(expected = NoSuchRelatedEventException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<RelatedEvent> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SUBSYS_RelatedEvent", "surrogateId", true, "eventId", true,
			"relatedEventId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		RelatedEvent newRelatedEvent = addRelatedEvent();

		RelatedEvent existingRelatedEvent = _persistence.fetchByPrimaryKey(
			newRelatedEvent.getPrimaryKey());

		Assert.assertEquals(existingRelatedEvent, newRelatedEvent);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RelatedEvent missingRelatedEvent = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingRelatedEvent);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		RelatedEvent newRelatedEvent1 = addRelatedEvent();
		RelatedEvent newRelatedEvent2 = addRelatedEvent();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRelatedEvent1.getPrimaryKey());
		primaryKeys.add(newRelatedEvent2.getPrimaryKey());

		Map<Serializable, RelatedEvent> relatedEvents =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, relatedEvents.size());
		Assert.assertEquals(
			newRelatedEvent1,
			relatedEvents.get(newRelatedEvent1.getPrimaryKey()));
		Assert.assertEquals(
			newRelatedEvent2,
			relatedEvents.get(newRelatedEvent2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, RelatedEvent> relatedEvents =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(relatedEvents.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		RelatedEvent newRelatedEvent = addRelatedEvent();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRelatedEvent.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, RelatedEvent> relatedEvents =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, relatedEvents.size());
		Assert.assertEquals(
			newRelatedEvent,
			relatedEvents.get(newRelatedEvent.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, RelatedEvent> relatedEvents =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(relatedEvents.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		RelatedEvent newRelatedEvent = addRelatedEvent();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newRelatedEvent.getPrimaryKey());

		Map<Serializable, RelatedEvent> relatedEvents =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, relatedEvents.size());
		Assert.assertEquals(
			newRelatedEvent,
			relatedEvents.get(newRelatedEvent.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			RelatedEventLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<RelatedEvent>() {

				@Override
				public void performAction(RelatedEvent relatedEvent) {
					Assert.assertNotNull(relatedEvent);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		RelatedEvent newRelatedEvent = addRelatedEvent();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RelatedEvent.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"surrogateId", newRelatedEvent.getSurrogateId()));

		List<RelatedEvent> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		RelatedEvent existingRelatedEvent = result.get(0);

		Assert.assertEquals(existingRelatedEvent, newRelatedEvent);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RelatedEvent.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"surrogateId", RandomTestUtil.nextLong()));

		List<RelatedEvent> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		RelatedEvent newRelatedEvent = addRelatedEvent();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			RelatedEvent.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("surrogateId"));

		Object newSurrogateId = newRelatedEvent.getSurrogateId();

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
			RelatedEvent.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("surrogateId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"surrogateId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected RelatedEvent addRelatedEvent() throws Exception {
		long pk = RandomTestUtil.nextLong();

		RelatedEvent relatedEvent = _persistence.create(pk);

		relatedEvent.setEventId(RandomTestUtil.nextLong());

		relatedEvent.setRelatedEventId(RandomTestUtil.nextLong());

		_relatedEvents.add(_persistence.update(relatedEvent));

		return relatedEvent;
	}

	private List<RelatedEvent> _relatedEvents = new ArrayList<RelatedEvent>();
	private RelatedEventPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}