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

package com.dnebinger.subsystem.events.service.base;

import com.dnebinger.subsystem.events.model.Event;
import com.dnebinger.subsystem.events.service.EventService;
import com.dnebinger.subsystem.events.service.persistence.EventAttendeePersistence;
import com.dnebinger.subsystem.events.service.persistence.EventPersistence;
import com.dnebinger.subsystem.events.service.persistence.RelatedEventPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the event remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.dnebinger.subsystem.events.service.impl.EventServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.dnebinger.subsystem.events.service.impl.EventServiceImpl
 * @see com.dnebinger.subsystem.events.service.EventServiceUtil
 * @generated
 */
public abstract class EventServiceBaseImpl extends BaseServiceImpl
	implements EventService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.dnebinger.subsystem.events.service.EventServiceUtil} to access the event remote service.
	 */

	/**
	 * Returns the event local service.
	 *
	 * @return the event local service
	 */
	public com.dnebinger.subsystem.events.service.EventLocalService getEventLocalService() {
		return eventLocalService;
	}

	/**
	 * Sets the event local service.
	 *
	 * @param eventLocalService the event local service
	 */
	public void setEventLocalService(
		com.dnebinger.subsystem.events.service.EventLocalService eventLocalService) {
		this.eventLocalService = eventLocalService;
	}

	/**
	 * Returns the event remote service.
	 *
	 * @return the event remote service
	 */
	public EventService getEventService() {
		return eventService;
	}

	/**
	 * Sets the event remote service.
	 *
	 * @param eventService the event remote service
	 */
	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	/**
	 * Returns the event persistence.
	 *
	 * @return the event persistence
	 */
	public EventPersistence getEventPersistence() {
		return eventPersistence;
	}

	/**
	 * Sets the event persistence.
	 *
	 * @param eventPersistence the event persistence
	 */
	public void setEventPersistence(EventPersistence eventPersistence) {
		this.eventPersistence = eventPersistence;
	}

	/**
	 * Returns the event attendee local service.
	 *
	 * @return the event attendee local service
	 */
	public com.dnebinger.subsystem.events.service.EventAttendeeLocalService getEventAttendeeLocalService() {
		return eventAttendeeLocalService;
	}

	/**
	 * Sets the event attendee local service.
	 *
	 * @param eventAttendeeLocalService the event attendee local service
	 */
	public void setEventAttendeeLocalService(
		com.dnebinger.subsystem.events.service.EventAttendeeLocalService eventAttendeeLocalService) {
		this.eventAttendeeLocalService = eventAttendeeLocalService;
	}

	/**
	 * Returns the event attendee remote service.
	 *
	 * @return the event attendee remote service
	 */
	public com.dnebinger.subsystem.events.service.EventAttendeeService getEventAttendeeService() {
		return eventAttendeeService;
	}

	/**
	 * Sets the event attendee remote service.
	 *
	 * @param eventAttendeeService the event attendee remote service
	 */
	public void setEventAttendeeService(
		com.dnebinger.subsystem.events.service.EventAttendeeService eventAttendeeService) {
		this.eventAttendeeService = eventAttendeeService;
	}

	/**
	 * Returns the event attendee persistence.
	 *
	 * @return the event attendee persistence
	 */
	public EventAttendeePersistence getEventAttendeePersistence() {
		return eventAttendeePersistence;
	}

	/**
	 * Sets the event attendee persistence.
	 *
	 * @param eventAttendeePersistence the event attendee persistence
	 */
	public void setEventAttendeePersistence(
		EventAttendeePersistence eventAttendeePersistence) {
		this.eventAttendeePersistence = eventAttendeePersistence;
	}

	/**
	 * Returns the related event local service.
	 *
	 * @return the related event local service
	 */
	public com.dnebinger.subsystem.events.service.RelatedEventLocalService getRelatedEventLocalService() {
		return relatedEventLocalService;
	}

	/**
	 * Sets the related event local service.
	 *
	 * @param relatedEventLocalService the related event local service
	 */
	public void setRelatedEventLocalService(
		com.dnebinger.subsystem.events.service.RelatedEventLocalService relatedEventLocalService) {
		this.relatedEventLocalService = relatedEventLocalService;
	}

	/**
	 * Returns the related event remote service.
	 *
	 * @return the related event remote service
	 */
	public com.dnebinger.subsystem.events.service.RelatedEventService getRelatedEventService() {
		return relatedEventService;
	}

	/**
	 * Sets the related event remote service.
	 *
	 * @param relatedEventService the related event remote service
	 */
	public void setRelatedEventService(
		com.dnebinger.subsystem.events.service.RelatedEventService relatedEventService) {
		this.relatedEventService = relatedEventService;
	}

	/**
	 * Returns the related event persistence.
	 *
	 * @return the related event persistence
	 */
	public RelatedEventPersistence getRelatedEventPersistence() {
		return relatedEventPersistence;
	}

	/**
	 * Sets the related event persistence.
	 *
	 * @param relatedEventPersistence the related event persistence
	 */
	public void setRelatedEventPersistence(
		RelatedEventPersistence relatedEventPersistence) {
		this.relatedEventPersistence = relatedEventPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return EventService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Event.class;
	}

	protected String getModelClassName() {
		return Event.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = eventPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.dnebinger.subsystem.events.service.EventLocalService.class)
	protected com.dnebinger.subsystem.events.service.EventLocalService eventLocalService;
	@BeanReference(type = EventService.class)
	protected EventService eventService;
	@BeanReference(type = EventPersistence.class)
	protected EventPersistence eventPersistence;
	@BeanReference(type = com.dnebinger.subsystem.events.service.EventAttendeeLocalService.class)
	protected com.dnebinger.subsystem.events.service.EventAttendeeLocalService eventAttendeeLocalService;
	@BeanReference(type = com.dnebinger.subsystem.events.service.EventAttendeeService.class)
	protected com.dnebinger.subsystem.events.service.EventAttendeeService eventAttendeeService;
	@BeanReference(type = EventAttendeePersistence.class)
	protected EventAttendeePersistence eventAttendeePersistence;
	@BeanReference(type = com.dnebinger.subsystem.events.service.RelatedEventLocalService.class)
	protected com.dnebinger.subsystem.events.service.RelatedEventLocalService relatedEventLocalService;
	@BeanReference(type = com.dnebinger.subsystem.events.service.RelatedEventService.class)
	protected com.dnebinger.subsystem.events.service.RelatedEventService relatedEventService;
	@BeanReference(type = RelatedEventPersistence.class)
	protected RelatedEventPersistence relatedEventPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}