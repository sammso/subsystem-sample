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

import com.dnebinger.subsystem.events.model.RelatedEvent;
import com.dnebinger.subsystem.events.model.RelatedEventModel;
import com.dnebinger.subsystem.events.model.RelatedEventSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
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
 * The base model implementation for the RelatedEvent service. Represents a row in the &quot;SUBSYS_RelatedEvent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>RelatedEventModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RelatedEventImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RelatedEventImpl
 * @generated
 */
@JSON(strict = true)
public class RelatedEventModelImpl
	extends BaseModelImpl<RelatedEvent> implements RelatedEventModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a related event model instance should use the <code>RelatedEvent</code> interface instead.
	 */
	public static final String TABLE_NAME = "SUBSYS_RelatedEvent";

	public static final Object[][] TABLE_COLUMNS = {
		{"surrogateId", Types.BIGINT}, {"eventId", Types.BIGINT},
		{"relatedEventId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("surrogateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("eventId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("relatedEventId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SUBSYS_RelatedEvent (surrogateId LONG not null primary key,eventId LONG,relatedEventId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table SUBSYS_RelatedEvent";

	public static final String ORDER_BY_JPQL =
		" ORDER BY relatedEvent.surrogateId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY SUBSYS_RelatedEvent.surrogateId ASC";

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
	public static RelatedEvent toModel(RelatedEventSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		RelatedEvent model = new RelatedEventImpl();

		model.setSurrogateId(soapModel.getSurrogateId());
		model.setEventId(soapModel.getEventId());
		model.setRelatedEventId(soapModel.getRelatedEventId());

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
	public static List<RelatedEvent> toModels(RelatedEventSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<RelatedEvent> models = new ArrayList<RelatedEvent>(
			soapModels.length);

		for (RelatedEventSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.dnebinger.subsystem.events.service.util.ServiceProps.get(
			"lock.expiration.time.com.dnebinger.subsystem.events.model.RelatedEvent"));

	public RelatedEventModelImpl() {
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
		return RelatedEvent.class;
	}

	@Override
	public String getModelClassName() {
		return RelatedEvent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<RelatedEvent, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<RelatedEvent, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RelatedEvent, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((RelatedEvent)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<RelatedEvent, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<RelatedEvent, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(RelatedEvent)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<RelatedEvent, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<RelatedEvent, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, RelatedEvent>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			RelatedEvent.class.getClassLoader(), RelatedEvent.class,
			ModelWrapper.class);

		try {
			Constructor<RelatedEvent> constructor =
				(Constructor<RelatedEvent>)proxyClass.getConstructor(
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

	private static final Map<String, Function<RelatedEvent, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<RelatedEvent, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<RelatedEvent, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<RelatedEvent, Object>>();
		Map<String, BiConsumer<RelatedEvent, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<RelatedEvent, ?>>();

		attributeGetterFunctions.put(
			"surrogateId", RelatedEvent::getSurrogateId);
		attributeSetterBiConsumers.put(
			"surrogateId",
			(BiConsumer<RelatedEvent, Long>)RelatedEvent::setSurrogateId);
		attributeGetterFunctions.put("eventId", RelatedEvent::getEventId);
		attributeSetterBiConsumers.put(
			"eventId",
			(BiConsumer<RelatedEvent, Long>)RelatedEvent::setEventId);
		attributeGetterFunctions.put(
			"relatedEventId", RelatedEvent::getRelatedEventId);
		attributeSetterBiConsumers.put(
			"relatedEventId",
			(BiConsumer<RelatedEvent, Long>)RelatedEvent::setRelatedEventId);

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
	public long getRelatedEventId() {
		return _relatedEventId;
	}

	@Override
	public void setRelatedEventId(long relatedEventId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_relatedEventId = relatedEventId;
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
			0, RelatedEvent.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public RelatedEvent toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, RelatedEvent>
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
		RelatedEventImpl relatedEventImpl = new RelatedEventImpl();

		relatedEventImpl.setSurrogateId(getSurrogateId());
		relatedEventImpl.setEventId(getEventId());
		relatedEventImpl.setRelatedEventId(getRelatedEventId());

		relatedEventImpl.resetOriginalValues();

		return relatedEventImpl;
	}

	@Override
	public int compareTo(RelatedEvent relatedEvent) {
		long primaryKey = relatedEvent.getPrimaryKey();

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

		if (!(object instanceof RelatedEvent)) {
			return false;
		}

		RelatedEvent relatedEvent = (RelatedEvent)object;

		long primaryKey = relatedEvent.getPrimaryKey();

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
	public CacheModel<RelatedEvent> toCacheModel() {
		RelatedEventCacheModel relatedEventCacheModel =
			new RelatedEventCacheModel();

		relatedEventCacheModel.surrogateId = getSurrogateId();

		relatedEventCacheModel.eventId = getEventId();

		relatedEventCacheModel.relatedEventId = getRelatedEventId();

		return relatedEventCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<RelatedEvent, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<RelatedEvent, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RelatedEvent, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((RelatedEvent)this));
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
		Map<String, Function<RelatedEvent, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<RelatedEvent, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RelatedEvent, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((RelatedEvent)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, RelatedEvent>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _surrogateId;
	private long _eventId;
	private long _relatedEventId;

	public <T> T getColumnValue(String columnName) {
		Function<RelatedEvent, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((RelatedEvent)this);
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
		_columnOriginalValues.put("relatedEventId", _relatedEventId);
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

		columnBitmasks.put("relatedEventId", 4L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private RelatedEvent _escapedModel;

}