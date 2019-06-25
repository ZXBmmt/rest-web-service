package com.mmt.client.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ClassVo {
    private Long id;
    private String name;
    private Timestamp creation;
    private Timestamp lastModified;
}
