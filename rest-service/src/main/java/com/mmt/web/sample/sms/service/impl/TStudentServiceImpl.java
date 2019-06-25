package com.mmt.web.sample.sms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mmt.client.form.StudentForm;
import com.mmt.client.vo.StudentVo;
import com.mmt.common.model.RestResponse;
import com.mmt.common.util.MyBeanCopier;
import com.mmt.web.sample.sms.entity.TStudent;
import com.mmt.web.sample.sms.mapper.TStudentMapper;
import com.mmt.web.sample.sms.service.ITStudentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 * 学生表 服务实现类
 * </p>
 *
 * @author mmt
 * @since 2019-06-25
 */
@Service
public class TStudentServiceImpl extends ServiceImpl<TStudentMapper, TStudent> implements ITStudentService {
    public RestResponse<Void> add(@RequestBody StudentForm studentForm){
        TStudent tStudent = MyBeanCopier.copyAsObject(studentForm,TStudent.class);
        this.save(tStudent);
        return RestResponse.buildSuccess(null);
    }

    public RestResponse<Void> update(@PathVariable Long id, @RequestBody StudentForm classForm){
        TStudent history = this.getById(id);
        if(history == null){
            return RestResponse.buildNotFound();
        }
        history.setName(classForm.getName());
        history.setClassId(classForm.getClassId());
        history.setAge(classForm.getAge());
        this.updateById(history);
        return RestResponse.buildSuccess(null);
    }

    public RestResponse<StudentVo> get(@PathVariable Long id){
        TStudent tStudent = this.getById(id);
        if(tStudent == null){
            return RestResponse.buildNotFound();
        }
        return RestResponse.buildSuccess(MyBeanCopier.copyAsObject(tStudent,StudentVo.class));
    }
}
