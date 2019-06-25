package com.mmt.web.sample.sms.controller;


import com.mmt.client.form.ClassForm;
import com.mmt.client.vo.ClassVo;
import com.mmt.common.model.RestResponse;
import com.mmt.web.sample.sms.service.impl.TClassServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mmt
 * @since 2019-06-25
 */
@RestController
public class TClassController {
    @Autowired
    private TClassServiceImpl classService;

    @PostMapping("/classes")
    public RestResponse<Void> add(@RequestBody ClassForm classForm){
        return classService.add(classForm);
    }

    @PutMapping("/classes/{id}")
    public RestResponse<Void> update(@PathVariable Long id, @RequestBody ClassForm classForm){
        return classService.update(id,classForm);
    }

    @GetMapping("/classes/{id}")
    public RestResponse<ClassVo> get(@PathVariable Long id){
       return classService.get(id);
    }
}
