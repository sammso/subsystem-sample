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
 * This class is a wrapper for {@link RelatedEvent}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RelatedEvent
 * @generated
 */
public class RelatedEventWrapper
	extends BaseModelWrapper<RelatedEvent>
	implements ModelWrapper<RelatedEvent>, RelatedEvent {

	public RelatedEventWrapper(RelatedEvent relatedEvent) {
		super(relatedEvent);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("surrogateId", getSurrogateId());
		attributes.put("eventId", getEventId());
		attributes.put("relatedEventId", getRelatedEventId());

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

		Long relatedEventId = (Long)attributes.get("relatedEventId");

		if (relatedEventId != null) {
			setRelatedEventId(relatedEventId);
		}
	}

	/**
	 * Returns the event ID of this related event.
	 *
	 * @return the event ID of this related event
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
	 * getId: Returns an integer form of the id since json treats the long as a string.
	 *
	 * @return int
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this related event.
	 *
	 * @return the primary key of this related event
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the related event ID of this related event.
	 *
	 * @return the related event ID of this related event
	 */
	@Override
	public long getRelatedEventId() {
		return model.getRelatedEventId();
	}

	/**
	 * getRelatedEventName: Returns the name of the related event.
	 *
	 * @return String The name of the related event.
	 */
	@Override
	public String getRelatedEventName() {
		return model.getRelatedEventName();
	}

	/**
	 * getRelatedId: Returns an integer form of the related id since json treats the long as a string.
	 *
	 * @return int
	 */
	@Override
	public int getRelatedId() {
		return model.getRelatedId();
	}

	/**
	 * Returns the surrogate ID of this related event.
	 *
	 * @return the surrogate ID of this related event
	 */
	@Override
	public long getSurrogateId() {
		return model.getSurrogateId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the event ID of this related event.
	 *
	 * @param eventId the event ID of this related event
	 */
	@Override
	public void setEventId(long eventId) {
		model.setEventId(eventId);
	}

	/**
	 * Sets the primary key of this related event.
	 *
	 * @param primaryKey the primary key of this related event
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the related event ID of this related event.
	 *
	 * @param relatedEventId the related event ID of this related event
	 */
	@Override
	public void setRelatedEventId(long relatedEventId) {
		model.setRelatedEventId(relatedEventId);
	}

	/**
	 * Sets the surrogate ID of this related event.
	 *
	 * @param surrogateId the surrogate ID of this related event
	 */
	@Override
	public void setSurrogateId(long surrogateId) {
		model.setSurrogateId(surrogateId);
	}

	@Override
	protected RelatedEventWrapper wrap(RelatedEvent relatedEvent) {
		return new RelatedEventWrapper(relatedEvent);
	}

}