package com.mmt.web.sample.sms.mybatis.th;

import com.mmt.common.util.Json;
import com.mmt.web.sample.sms.entity.TJsonTest;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@MappedTypes(TJsonTest.JsonContent.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class JsonContnetTypeHandler implements TypeHandler<TJsonTest.JsonContent> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, TJsonTest.JsonContent jsonContent, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i,Json.toJson(jsonContent));
    }

    @Override
    public TJsonTest.JsonContent getResult(ResultSet resultSet, String s) throws SQLException {
        return Json.fromJson(resultSet.getString(s), TJsonTest.JsonContent.class);
    }

    @Override
    public TJsonTest.JsonContent getResult(ResultSet resultSet, int i) throws SQLException {
        return Json.fromJson(resultSet.getString(i), TJsonTest.JsonContent.class);
    }

    @Override
    public TJsonTest.JsonContent getResult(CallableStatement callableStatement, int i) throws SQLException {
        return Json.fromJson(callableStatement.getString(i), TJsonTest.JsonContent.class);
    }
}
