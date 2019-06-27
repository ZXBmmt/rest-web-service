package com.mmt.common.model;

import lombok.Data;

import java.util.List;

@Data
public class PageRestResponse<T extends List> extends RestResponse<T> {
    private long totalSize;
    private int currentPage;
    private int pageSize;

    public static <T> PageRestResponse buildSuccess(T t,long totalSize,int currentPage,int pageSize) {
        PageRestResponse restResponse = new PageRestResponse();
        restResponse.setStatusCode(200);
        restResponse.setMessage("success");
        restResponse.setData(t);
        restResponse.totalSize = totalSize;
        restResponse.currentPage = currentPage;
        restResponse.pageSize = pageSize;
        return restResponse;
    }
}
