package com.mmt.web.sample.sms.mybatis.th;


import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;


@MappedTypes(Long.class)
@MappedJdbcTypes(JdbcType.TIMESTAMP)
public class Time2longTypeHandler implements TypeHandler<Long> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Long aLong, JdbcType jdbcType) throws SQLException {
        preparedStatement.setTimestamp(i,new Timestamp(aLong));
    }

    @Override
    public Long getResult(ResultSet resultSet, String s) throws SQLException {
        return resultSet.getTimestamp(s).getTime();
    }

    @Override
    public Long getResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getTimestamp(i).getTime();
    }

    @Override
    public Long getResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getTimestamp(i).getTime();
    }
}
