package com.mmt.web.sample.sms.controller;


import com.mmt.client.form.StudentForm;
import com.mmt.client.vo.StudentVo;
import com.mmt.common.model.RestResponse;
import com.mmt.web.sample.sms.service.impl.TStudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 学生表 前端控制器
 * </p>
 *
 * @author mmt
 * @since 2019-06-25
 */
@RestController
public class TStudentController {
    @Autowired
    private TStudentServiceImpl tStudentService;

    @PostMapping("/students")
    public RestResponse<Void> add(@RequestBody StudentForm studentForm){
        return tStudentService.add(studentForm);
    }

    @PutMapping("/students/{id}")
    public RestResponse<Void> update(@PathVariable Long id, @RequestBody StudentForm classForm){
        return tStudentService.update(id,classForm);
    }

    @GetMapping("/students/{id}")
    public RestResponse<StudentVo> get(@PathVariable Long id){
        return tStudentService.get(id);
    }
}
