package com.mmt.common.util;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.type.TypeFactory;

/**
 * JSON工具
 */
public class Json {

	/**
	 * Jackson ObjectMapper
	 */
	public static final ObjectMapper om = new ObjectMapper();

	static {
		om.setSerializationInclusion(Include.NON_NULL);
		om.enable(SerializationFeature.INDENT_OUTPUT);
		om.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		om.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
		SimpleModule sm = new SimpleModule("emptyToNull");
		sm.addDeserializer(String.class, new StdScalarDeserializer<String>(String.class) {
			private static final long serialVersionUID = 2108254586742323728L;

			@Override
			public String deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException,
					JsonProcessingException {
				if ("".equals(jp.getText())) {
					return null;
				}
				return StringDeserializer.instance.deserialize(jp, ctxt);
			}
		});
		om.registerModule(sm);
	}

	/**
	 * 转为JSON字符串
	 *
	 * @param obj
	 *            对象
	 * @return JSON字符串
	 */
	public static String toJson(Object obj) {
		if (obj == null) {
			return null;
		}
		try {
			return om.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 自JSON解析对象
	 *
	 * @param json
	 *            JSON字符串
	 * @param cls
	 *            数据类
	 * @return 目标对象
	 */
	public static <T> T fromJson(String json, Class<T> cls) {
		if (json == null || json.trim().isEmpty()) {
			return null;
		}
		try {
			return om.readValue(json, cls);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 自JSON解析对象,适用于泛型类
	 * 
	 * @param json
	 *            JSON
	 * @param parametrized
	 *            泛型类
	 * @param parameterClasses
	 *            泛型参数类
	 * @return 目标对象
	 */
	public static <P> P fromJson(String json, Class<P> parametrized, Class<?>... parameterClasses) {
		if (json == null || json.trim().isEmpty()) {
			return null;
		}
		try {
			if (parameterClasses == null || parameterClasses.length == 0) {
				return om.readValue(json, parametrized);
			} else {
				return om.readValue(
						json,
						TypeFactory.defaultInstance().constructParametrizedType(parametrized, parametrized,
								parameterClasses));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 自JSON解析对象
	 *
	 * @param json
	 *            JSON字符串
	 * @param typeReference
	 *            typeReference
	 * @return 目标对象
	 */
	public static <T> T fromJson(String json, TypeReference<T> typeReference) {
		if (json == null || json.trim().isEmpty()) {
			return null;
		}
		try {
			return om.readValue(json, typeReference);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}