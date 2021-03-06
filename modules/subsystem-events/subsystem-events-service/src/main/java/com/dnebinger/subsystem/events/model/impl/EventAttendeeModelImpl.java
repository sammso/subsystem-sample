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

import com.dnebinger.subsystem.events.model.EventAttendee;
import com.dnebinger.subsystem.events.model.EventAttendeeModel;
import com.dnebinger.subsystem.events.model.EventAttendeeSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the EventAttendee service. Represents a row in the &quot;SUBSYS_EventAttendee&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>EventAttendeeModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EventAttendeeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventAttendeeImpl
 * @generated
 */
@JSON(strict = true)
public class EventAttendeeModelImpl
	extends BaseModelImpl<EventAttendee> implements EventAttendeeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a event attendee model instance should use the <code>EventAttendee</code> interface instead.
	 */
	public static final String TABLE_NAME = "SUBSYS_EventAttendee";

	public static final Object[][] TABLE_COLUMNS = {
		{"surrogateId", Types.BIGINT}, {"eventId", Types.BIGINT},
		{"userId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("surrogateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("eventId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SUBSYS_EventAttendee (surrogateId LONG not null primary key,eventId LONG,userId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table SUBSYS_EventAttendee";

	public static final String ORDER_BY_JPQL =
		" ORDER BY eventAttendee.surrogateId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY SUBSYS_EventAttendee.surrogateId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean ENTITY_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean FINDER_CACHE_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static final boolean COLUMN_BITMASK_ENABLED = true;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long EVENTID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long SURROGATEID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static EventAttendee toModel(EventAttendeeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		EventAttendee model = new EventAttendeeImpl();

		model.setSurrogateId(soapModel.getSurrogateId());
		model.setEventId(soapModel.getEventId());
		model.setUserId(soapModel.getUserId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<EventAttendee> toModels(EventAttendeeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<EventAttendee> models = new ArrayList<EventAttendee>(
			soapModels.length);

		for (EventAttendeeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.dnebinger.subsystem.events.service.util.ServiceProps.get(
			"lock.expiration.time.com.dnebinger.subsystem.events.model.EventAttendee"));

	public EventAttendeeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _surrogateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSurrogateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _surrogateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EventAttendee.class;
	}

	@Override
	public String getModelClassName() {
		return EventAttendee.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<EventAttendee, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<EventAttendee, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EventAttendee, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((EventAttendee)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<EventAttendee, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<EventAttendee, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(EventAttendee)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<EventAttendee, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<EventAttendee, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, EventAttendee>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			EventAttendee.class.getClassLoader(), EventAttendee.class,
			ModelWrapper.class);

		try {
			Constructor<EventAttendee> constructor =
				(Constructor<EventAttendee>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<EventAttendee, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<EventAttendee, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<EventAttendee, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<EventAttendee, Object>>();
		Map<String, BiConsumer<EventAttendee, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<EventAttendee, ?>>();

		attributeGetterFunctions.put(
			"surrogateId", EventAttendee::getSurrogateId);
		attributeSetterBiConsumers.put(
			"surrogateId",
			(BiConsumer<EventAttendee, Long>)EventAttendee::setSurrogateId);
		attributeGetterFunctions.put("eventId", EventAttendee::getEventId);
		attributeSetterBiConsumers.put(
			"eventId",
			(BiConsumer<EventAttendee, Long>)EventAttendee::setEventId);
		attributeGetterFunctions.put("userId", EventAttendee::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<EventAttendee, Long>)EventAttendee::setUserId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getSurrogateId() {
		return _surrogateId;
	}

	@Override
	public void setSurrogateId(long surrogateId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_surrogateId = surrogateId;
	}

	@JSON
	@Override
	public long getEventId() {
		return _eventId;
	}

	@Override
	public void setEventId(long eventId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_eventId = eventId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalEventId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("eventId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (entry.getValue() != getColumnValue(entry.getKey())) {
				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, EventAttendee.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EventAttendee toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, EventAttendee>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EventAttendeeImpl eventAttendeeImpl = new EventAttendeeImpl();

		eventAttendeeImpl.setSurrogateId(getSurrogateId());
		eventAttendeeImpl.setEventId(getEventId());
		eventAttendeeImpl.setUserId(getUserId());

		eventAttendeeImpl.resetOriginalValues();

		return eventAttendeeImpl;
	}

	@Override
	public int compareTo(EventAttendee eventAttendee) {
		long primaryKey = eventAttendee.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EventAttendee)) {
			return false;
		}

		EventAttendee eventAttendee = (EventAttendee)object;

		long primaryKey = eventAttendee.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<EventAttendee> toCacheModel() {
		EventAttendeeCacheModel eventAttendeeCacheModel =
			new EventAttendeeCacheModel();

		eventAttendeeCacheModel.surrogateId = getSurrogateId();

		eventAttendeeCacheModel.eventId = getEventId();

		eventAttendeeCacheModel.userId = getUserId();

		return eventAttendeeCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<EventAttendee, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<EventAttendee, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EventAttendee, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((EventAttendee)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<EventAttendee, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<EventAttendee, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EventAttendee, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((EventAttendee)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, EventAttendee>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _surrogateId;
	private long _eventId;
	private long _userId;

	public <T> T getColumnValue(String columnName) {
		Function<EventAttendee, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((EventAttendee)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("surrogateId", _surrogateId);
		_columnOriginalValues.put("eventId", _eventId);
		_columnOriginalValues.put("userId", _userId);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("surrogateId", 1L);

		columnBitmasks.put("eventId", 2L);

		columnBitmasks.put("userId", 4L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private EventAttendee _escapedModel;

}