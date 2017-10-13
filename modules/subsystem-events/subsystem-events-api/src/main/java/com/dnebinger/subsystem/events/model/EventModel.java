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

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Event service. Represents a row in the &quot;SUBSYS_Event&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.dnebinger.subsystem.events.model.impl.EventModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.dnebinger.subsystem.events.model.impl.EventImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Event
 * @see com.dnebinger.subsystem.events.model.impl.EventImpl
 * @see com.dnebinger.subsystem.events.model.impl.EventModelImpl
 * @generated
 */
@ProviderType
public interface EventModel extends BaseModel<Event> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a event model instance should use the {@link Event} interface instead.
	 */

	/**
	 * Returns the primary key of this event.
	 *
	 * @return the primary key of this event
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this event.
	 *
	 * @param primaryKey the primary key of this event
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this event.
	 *
	 * @return the uuid of this event
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this event.
	 *
	 * @param uuid the uuid of this event
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the event ID of this event.
	 *
	 * @return the event ID of this event
	 */
	public long getEventId();

	/**
	 * Sets the event ID of this event.
	 *
	 * @param eventId the event ID of this event
	 */
	public void setEventId(long eventId);

	/**
	 * Returns the name of this event.
	 *
	 * @return the name of this event
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this event.
	 *
	 * @param name the name of this event
	 */
	public void setName(String name);

	/**
	 * Returns the occurs on of this event.
	 *
	 * @return the occurs on of this event
	 */
	public Date getOccursOn();

	/**
	 * Sets the occurs on of this event.
	 *
	 * @param occursOn the occurs on of this event
	 */
	public void setOccursOn(Date occursOn);

	/**
	 * Returns the ends on of this event.
	 *
	 * @return the ends on of this event
	 */
	public Date getEndsOn();

	/**
	 * Sets the ends on of this event.
	 *
	 * @param endsOn the ends on of this event
	 */
	public void setEndsOn(Date endsOn);

	/**
	 * Returns the adult only of this event.
	 *
	 * @return the adult only of this event
	 */
	public boolean getAdultOnly();

	/**
	 * Returns <code>true</code> if this event is adult only.
	 *
	 * @return <code>true</code> if this event is adult only; <code>false</code> otherwise
	 */
	public boolean isAdultOnly();

	/**
	 * Sets whether this event is adult only.
	 *
	 * @param adultOnly the adult only of this event
	 */
	public void setAdultOnly(boolean adultOnly);

	/**
	 * Returns the max occupants of this event.
	 *
	 * @return the max occupants of this event
	 */
	public int getMaxOccupants();

	/**
	 * Sets the max occupants of this event.
	 *
	 * @param maxOccupants the max occupants of this event
	 */
	public void setMaxOccupants(int maxOccupants);

	/**
	 * Returns the description of this event.
	 *
	 * @return the description of this event
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this event.
	 *
	 * @param description the description of this event
	 */
	public void setDescription(String description);

	/**
	 * Returns the floor of this event.
	 *
	 * @return the floor of this event
	 */
	public int getFloor();

	/**
	 * Sets the floor of this event.
	 *
	 * @param floor the floor of this event
	 */
	public void setFloor(int floor);

	/**
	 * Returns the room of this event.
	 *
	 * @return the room of this event
	 */
	@AutoEscape
	public String getRoom();

	/**
	 * Sets the room of this event.
	 *
	 * @param room the room of this event
	 */
	public void setRoom(String room);

	/**
	 * Returns the organizer of this event.
	 *
	 * @return the organizer of this event
	 */
	public long getOrganizer();

	/**
	 * Sets the organizer of this event.
	 *
	 * @param organizer the organizer of this event
	 */
	public void setOrganizer(long organizer);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Event event);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Event> toCacheModel();

	@Override
	public Event toEscapedModel();

	@Override
	public Event toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}