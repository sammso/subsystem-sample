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

package com.dnebinger.subsystem.events.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EventAttendee}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventAttendee
 * @generated
 */
public class EventAttendeeWrapper
	extends BaseModelWrapper<EventAttendee>
	implements EventAttendee, ModelWrapper<EventAttendee> {

	public EventAttendeeWrapper(EventAttendee eventAttendee) {
		super(eventAttendee);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("surrogateId", getSurrogateId());
		attributes.put("eventId", getEventId());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long surrogateId = (Long)attributes.get("surrogateId");

		if (surrogateId != null) {
			setSurrogateId(surrogateId);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	/**
	 * Returns the event ID of this event attendee.
	 *
	 * @return the event ID of this event attendee
	 */
	@Override
	public long getEventId() {
		return model.getEventId();
	}

	/**
	 * getEventName: Returns the name of the event.
	 *
	 * @return String The name of the event.
	 */
	@Override
	public String getEventName() {
		return model.getEventName();
	}

	/**
	 * Returns the primary key of this event attendee.
	 *
	 * @return the primary key of this event attendee
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the surrogate ID of this event attendee.
	 *
	 * @return the surrogate ID of this event attendee
	 */
	@Override
	public long getSurrogateId() {
		return model.getSurrogateId();
	}

	/**
	 * Returns the user ID of this event attendee.
	 *
	 * @return the user ID of this event attendee
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * getUserName; Returns the name of the event attendee.
	 *
	 * @return String The attendee name.
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this event attendee.
	 *
	 * @return the user uuid of this event attendee
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the event ID of this event attendee.
	 *
	 * @param eventId the event ID of this event attendee
	 */
	@Override
	public void setEventId(long eventId) {
		model.setEventId(eventId);
	}

	/**
	 * Sets the primary key of this event attendee.
	 *
	 * @param primaryKey the primary key of this event attendee
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the surrogate ID of this event attendee.
	 *
	 * @param surrogateId the surrogate ID of this event attendee
	 */
	@Override
	public void setSurrogateId(long surrogateId) {
		model.setSurrogateId(surrogateId);
	}

	/**
	 * Sets the user ID of this event attendee.
	 *
	 * @param userId the user ID of this event attendee
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this event attendee.
	 *
	 * @param userUuid the user uuid of this event attendee
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected EventAttendeeWrapper wrap(EventAttendee eventAttendee) {
		return new EventAttendeeWrapper(eventAttendee);
	}

}