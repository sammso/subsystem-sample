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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Event}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Event
 * @generated
 */
public class EventWrapper
	extends BaseModelWrapper<Event> implements Event, ModelWrapper<Event> {

	public EventWrapper(Event event) {
		super(event);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("eventId", getEventId());
		attributes.put("name", getName());
		attributes.put("occursOn", getOccursOn());
		attributes.put("endsOn", getEndsOn());
		attributes.put("adultOnly", isAdultOnly());
		attributes.put("maxOccupants", getMaxOccupants());
		attributes.put("description", getDescription());
		attributes.put("floor", getFloor());
		attributes.put("room", getRoom());
		attributes.put("organizer", getOrganizer());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Date occursOn = (Date)attributes.get("occursOn");

		if (occursOn != null) {
			setOccursOn(occursOn);
		}

		Date endsOn = (Date)attributes.get("endsOn");

		if (endsOn != null) {
			setEndsOn(endsOn);
		}

		Boolean adultOnly = (Boolean)attributes.get("adultOnly");

		if (adultOnly != null) {
			setAdultOnly(adultOnly);
		}

		Integer maxOccupants = (Integer)attributes.get("maxOccupants");

		if (maxOccupants != null) {
			setMaxOccupants(maxOccupants);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer floor = (Integer)attributes.get("floor");

		if (floor != null) {
			setFloor(floor);
		}

		String room = (String)attributes.get("room");

		if (room != null) {
			setRoom(room);
		}

		Long organizer = (Long)attributes.get("organizer");

		if (organizer != null) {
			setOrganizer(organizer);
		}
	}

	/**
	 * Returns the adult only of this event.
	 *
	 * @return the adult only of this event
	 */
	@Override
	public boolean getAdultOnly() {
		return model.getAdultOnly();
	}

	/**
	 * getDateDisplay: Returns the display date string for the event.
	 *
	 * @return String The display date string.
	 */
	@Override
	public String getDateDisplay() {
		return model.getDateDisplay();
	}

	/**
	 * Returns the description of this event.
	 *
	 * @return the description of this event
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the ends on of this event.
	 *
	 * @return the ends on of this event
	 */
	@Override
	public Date getEndsOn() {
		return model.getEndsOn();
	}

	/**
	 * Returns the event ID of this event.
	 *
	 * @return the event ID of this event
	 */
	@Override
	public long getEventId() {
		return model.getEventId();
	}

	/**
	 * Returns the floor of this event.
	 *
	 * @return the floor of this event
	 */
	@Override
	public int getFloor() {
		return model.getFloor();
	}

	/**
	 * getId: Return an integer of the id since the json conversion of our long id is returned as a string.
	 *
	 * @return int The integer version of the event id.
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * getLocation: Returns the location as a simple string.
	 *
	 * @return String The location string.
	 */
	@Override
	public String getLocation() {
		return model.getLocation();
	}

	/**
	 * Returns the max occupants of this event.
	 *
	 * @return the max occupants of this event
	 */
	@Override
	public int getMaxOccupants() {
		return model.getMaxOccupants();
	}

	/**
	 * Returns the name of this event.
	 *
	 * @return the name of this event
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the occurs on of this event.
	 *
	 * @return the occurs on of this event
	 */
	@Override
	public Date getOccursOn() {
		return model.getOccursOn();
	}

	/**
	 * Returns the organizer of this event.
	 *
	 * @return the organizer of this event
	 */
	@Override
	public long getOrganizer() {
		return model.getOrganizer();
	}

	/**
	 * getOrganizerName: Return the event organizer name.
	 *
	 * @return String The organizer name.
	 */
	@Override
	public String getOrganizerName() {
		return model.getOrganizerName();
	}

	/**
	 * Returns the primary key of this event.
	 *
	 * @return the primary key of this event
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the room of this event.
	 *
	 * @return the room of this event
	 */
	@Override
	public String getRoom() {
		return model.getRoom();
	}

	/**
	 * getSelected: Doesn't really do much but it will inject a default boolean of false into
	 * the json representation of our object.
	 *
	 * @return boolean Always returns <code>false</code>.
	 */
	@Override
	public boolean getSelected() {
		return model.getSelected();
	}

	/**
	 * Returns the uuid of this event.
	 *
	 * @return the uuid of this event
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this event is adult only.
	 *
	 * @return <code>true</code> if this event is adult only; <code>false</code> otherwise
	 */
	@Override
	public boolean isAdultOnly() {
		return model.isAdultOnly();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this event is adult only.
	 *
	 * @param adultOnly the adult only of this event
	 */
	@Override
	public void setAdultOnly(boolean adultOnly) {
		model.setAdultOnly(adultOnly);
	}

	/**
	 * Sets the description of this event.
	 *
	 * @param description the description of this event
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the ends on of this event.
	 *
	 * @param endsOn the ends on of this event
	 */
	@Override
	public void setEndsOn(Date endsOn) {
		model.setEndsOn(endsOn);
	}

	/**
	 * Sets the event ID of this event.
	 *
	 * @param eventId the event ID of this event
	 */
	@Override
	public void setEventId(long eventId) {
		model.setEventId(eventId);
	}

	/**
	 * Sets the floor of this event.
	 *
	 * @param floor the floor of this event
	 */
	@Override
	public void setFloor(int floor) {
		model.setFloor(floor);
	}

	/**
	 * Sets the max occupants of this event.
	 *
	 * @param maxOccupants the max occupants of this event
	 */
	@Override
	public void setMaxOccupants(int maxOccupants) {
		model.setMaxOccupants(maxOccupants);
	}

	/**
	 * Sets the name of this event.
	 *
	 * @param name the name of this event
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the occurs on of this event.
	 *
	 * @param occursOn the occurs on of this event
	 */
	@Override
	public void setOccursOn(Date occursOn) {
		model.setOccursOn(occursOn);
	}

	/**
	 * Sets the organizer of this event.
	 *
	 * @param organizer the organizer of this event
	 */
	@Override
	public void setOrganizer(long organizer) {
		model.setOrganizer(organizer);
	}

	/**
	 * Sets the primary key of this event.
	 *
	 * @param primaryKey the primary key of this event
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the room of this event.
	 *
	 * @param room the room of this event
	 */
	@Override
	public void setRoom(String room) {
		model.setRoom(room);
	}

	/**
	 * Sets the uuid of this event.
	 *
	 * @param uuid the uuid of this event
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected EventWrapper wrap(Event event) {
		return new EventWrapper(event);
	}

}