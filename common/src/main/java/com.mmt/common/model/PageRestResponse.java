package com.mmt.common.model;

import lombok.Data;

import java.util.List;

@Data
public class PageRestResponse<T extends List> extends RestResponse<T> {
    private long totalSize;
    private int currentPage;
    private int pageSize;
}
