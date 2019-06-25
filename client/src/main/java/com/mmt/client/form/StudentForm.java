package com.mmt.client.form;

import lombok.Data;

@Data
public class StudentForm {
    private Long id;
    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 班级
     */
    private Long classId;
}
