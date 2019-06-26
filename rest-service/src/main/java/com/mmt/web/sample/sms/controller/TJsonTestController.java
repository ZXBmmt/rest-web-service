package com.mmt.web.sample.sms.controller;


import com.mmt.client.vo.StudentVo;
import com.mmt.common.model.RestResponse;
import com.mmt.web.sample.sms.entity.TJsonTest;
import com.mmt.web.sample.sms.service.impl.TJsonTestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * json字段测试 前端控制器
 * </p>
 *
 * @author mmt
 * @since 2019-06-26
 */
@RestController
public class TJsonTestController {
    @Autowired
    private TJsonTestServiceImpl jsonTestService;

    @PostMapping("/json-tests")
    public RestResponse<Void> insert(@RequestBody TJsonTest jsonTest){
        return jsonTestService.insert(jsonTest);
    }

    @GetMapping("/json-tests/{id}")
    public RestResponse<TJsonTest> get(@PathVariable Long id){
        return jsonTestService.get(id);
    }
}
