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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Event. This utility wraps
 * <code>com.dnebinger.subsystem.events.service.impl.EventServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see EventService
 * @generated
 */
public class EventServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.dnebinger.subsystem.events.service.impl.EventServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.dnebinger.subsystem.events.model.Event getEvent(
		long eventId) {

		return getService().getEvent(eventId);
	}

	public static java.util.List
		<com.dnebinger.subsystem.events.model.EventAttendee> getEventAttendees(
			long eventId) {

		return getService().getEventAttendees(eventId);
	}

	public static java.util.List<com.dnebinger.subsystem.events.model.Event>
		getEvents() {

		return getService().getEvents();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List
		<com.dnebinger.subsystem.events.model.RelatedEvent> getRelatedEvents(
			long eventId) {

		return getService().getRelatedEvents(eventId);
	}

	public static EventService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EventService, EventService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EventService.class);

		ServiceTracker<EventService, EventService> serviceTracker =
			new ServiceTracker<EventService, EventService>(
				bundle.getBundleContext(), EventService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}