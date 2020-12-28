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

package com.dnebinger.subsystem.events.model.impl;

import com.dnebinger.subsystem.events.model.Event;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Event in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EventCacheModel implements CacheModel<Event>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EventCacheModel)) {
			return false;
		}

		EventCacheModel eventCacheModel = (EventCacheModel)object;

		if (eventId == eventCacheModel.eventId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, eventId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", occursOn=");
		sb.append(occursOn);
		sb.append(", endsOn=");
		sb.append(endsOn);
		sb.append(", adultOnly=");
		sb.append(adultOnly);
		sb.append(", maxOccupants=");
		sb.append(maxOccupants);
		sb.append(", description=");
		sb.append(description);
		sb.append(", floor=");
		sb.append(floor);
		sb.append(", room=");
		sb.append(room);
		sb.append(", organizer=");
		sb.append(organizer);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Event toEntityModel() {
		EventImpl eventImpl = new EventImpl();

		if (uuid == null) {
			eventImpl.setUuid("");
		}
		else {
			eventImpl.setUuid(uuid);
		}

		eventImpl.setEventId(eventId);

		if (name == null) {
			eventImpl.setName("");
		}
		else {
			eventImpl.setName(name);
		}

		if (occursOn == Long.MIN_VALUE) {
			eventImpl.setOccursOn(null);
		}
		else {
			eventImpl.setOccursOn(new Date(occursOn));
		}

		if (endsOn == Long.MIN_VALUE) {
			eventImpl.setEndsOn(null);
		}
		else {
			eventImpl.setEndsOn(new Date(endsOn));
		}

		eventImpl.setAdultOnly(adultOnly);
		eventImpl.setMaxOccupants(maxOccupants);

		if (description == null) {
			eventImpl.setDescription("");
		}
		else {
			eventImpl.setDescription(description);
		}

		eventImpl.setFloor(floor);

		if (room == null) {
			eventImpl.setRoom("");
		}
		else {
			eventImpl.setRoom(room);
		}

		eventImpl.setOrganizer(organizer);

		eventImpl.resetOriginalValues();

		return eventImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		eventId = objectInput.readLong();
		name = objectInput.readUTF();
		occursOn = objectInput.readLong();
		endsOn = objectInput.readLong();

		adultOnly = objectInput.readBoolean();

		maxOccupants = objectInput.readInt();
		description = objectInput.readUTF();

		floor = objectInput.readInt();
		room = objectInput.readUTF();

		organizer = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(eventId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(occursOn);
		objectOutput.writeLong(endsOn);

		objectOutput.writeBoolean(adultOnly);

		objectOutput.writeInt(maxOccupants);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeInt(floor);

		if (room == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(room);
		}

		objectOutput.writeLong(organizer);
	}

	public String uuid;
	public long eventId;
	public String name;
	public long occursOn;
	public long endsOn;
	public boolean adultOnly;
	public int maxOccupants;
	public String description;
	public int floor;
	public String room;
	public long organizer;

}