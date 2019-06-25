package com.mmt.common.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;

@Data
public class RObj {
    @TableId(type = AUTO)
    private Long id;
    private int version;
    private Timestamp creation;
    private Timestamp lastModified;
}
