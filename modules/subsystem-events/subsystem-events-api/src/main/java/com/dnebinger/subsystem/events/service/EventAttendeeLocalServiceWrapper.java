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

package com.dnebinger.subsystem.events.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EventAttendeeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EventAttendeeLocalService
 * @generated
 */
public class EventAttendeeLocalServiceWrapper
	implements EventAttendeeLocalService,
			   ServiceWrapper<EventAttendeeLocalService> {

	public EventAttendeeLocalServiceWrapper(
		EventAttendeeLocalService eventAttendeeLocalService) {

		_eventAttendeeLocalService = eventAttendeeLocalService;
	}

	/**
	 * Adds the event attendee to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventAttendeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eventAttendee the event attendee
	 * @return the event attendee that was added
	 */
	@Override
	public com.dnebinger.subsystem.events.model.EventAttendee addEventAttendee(
		com.dnebinger.subsystem.events.model.EventAttendee eventAttendee) {

		return _eventAttendeeLocalService.addEventAttendee(eventAttendee);
	}

	/**
	 * Creates a new event attendee with the primary key. Does not add the event attendee to the database.
	 *
	 * @param surrogateId the primary key for the new event attendee
	 * @return the new event attendee
	 */
	@Override
	public com.dnebinger.subsystem.events.model.EventAttendee
		createEventAttendee(long surrogateId) {

		return _eventAttendeeLocalService.createEventAttendee(surrogateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventAttendeeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the event attendee from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventAttendeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eventAttendee the event attendee
	 * @return the event attendee that was removed
	 */
	@Override
	public com.dnebinger.subsystem.events.model.EventAttendee
		deleteEventAttendee(
			com.dnebinger.subsystem.events.model.EventAttendee eventAttendee) {

		return _eventAttendeeLocalService.deleteEventAttendee(eventAttendee);
	}

	/**
	 * Deletes the event attendee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventAttendeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param surrogateId the primary key of the event attendee
	 * @return the event attendee that was removed
	 * @throws PortalException if a event attendee with the primary key could not be found
	 */
	@Override
	public com.dnebinger.subsystem.events.model.EventAttendee
			deleteEventAttendee(long surrogateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventAttendeeLocalService.deleteEventAttendee(surrogateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventAttendeeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eventAttendeeLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _eventAttendeeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dnebinger.subsystem.events.model.impl.EventAttendeeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _eventAttendeeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dnebinger.subsystem.events.model.impl.EventAttendeeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _eventAttendeeLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _eventAttendeeLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _eventAttendeeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.dnebinger.subsystem.events.model.EventAttendee
		fetchEventAttendee(long surrogateId) {

		return _eventAttendeeLocalService.fetchEventAttendee(surrogateId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _eventAttendeeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the event attendee with the primary key.
	 *
	 * @param surrogateId the primary key of the event attendee
	 * @return the event attendee
	 * @throws PortalException if a event attendee with the primary key could not be found
	 */
	@Override
	public com.dnebinger.subsystem.events.model.EventAttendee getEventAttendee(
			long surrogateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventAttendeeLocalService.getEventAttendee(surrogateId);
	}

	/**
	 * Returns a range of all the event attendees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.dnebinger.subsystem.events.model.impl.EventAttendeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event attendees
	 * @param end the upper bound of the range of event attendees (not inclusive)
	 * @return the range of event attendees
	 */
	@Override
	public java.util.List<com.dnebinger.subsystem.events.model.EventAttendee>
		getEventAttendees(int start, int end) {

		return _eventAttendeeLocalService.getEventAttendees(start, end);
	}

	@Override
	public java.util.List<com.dnebinger.subsystem.events.model.EventAttendee>
		getEventAttendees(long eventId) {

		return _eventAttendeeLocalService.getEventAttendees(eventId);
	}

	/**
	 * Returns the number of event attendees.
	 *
	 * @return the number of event attendees
	 */
	@Override
	public int getEventAttendeesCount() {
		return _eventAttendeeLocalService.getEventAttendeesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _eventAttendeeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _eventAttendeeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventAttendeeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the event attendee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventAttendeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eventAttendee the event attendee
	 * @return the event attendee that was updated
	 */
	@Override
	public com.dnebinger.subsystem.events.model.EventAttendee
		updateEventAttendee(
			com.dnebinger.subsystem.events.model.EventAttendee eventAttendee) {

		return _eventAttendeeLocalService.updateEventAttendee(eventAttendee);
	}

	@Override
	public EventAttendeeLocalService getWrappedService() {
		return _eventAttendeeLocalService;
	}

	@Override
	public void setWrappedService(
		EventAttendeeLocalService eventAttendeeLocalService) {

		_eventAttendeeLocalService = eventAttendeeLocalService;
	}

	private EventAttendeeLocalService _eventAttendeeLocalService;

}