package com.zhanghp.generate.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zhanghp.generate.service.TestService;
import com.zhanghp.generate.model.ro.TestRO;
import com.zhanghp.generate.model.qo.TestQO;
import com.zhanghp.common.response.R;


/**
 * <p>
 *  controller
 * </p>
 *
 * @author zhanghp
 * @since 2023-06-21
 */
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Api(tags = "REST - ")
@RestController
@RequestMapping("/generate/test")
public class TestController {
    private final TestService service;

    @PostMapping("/create")
    @ApiOperation(value = "新增")
    public R createOne(@RequestBody TestRO ro){
        boolean flag = service.create(ro);
        return R.judgeR(flag, flag ? "创建成功" : "创建失败");
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除")
    public R delete(@PathVariable("id")Integer id){
        boolean flag = service.delete(id);
        return R.judgeR(flag, flag ? "删除成功" : "删除失败");
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改")
    public R update(@RequestBody TestRO ro){
        boolean flag = service.update(ro);
        return R.judgeR(flag, flag ? "修改成功" : "修改失败");
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "单条查询")
    public R getOne(@PathVariable("id")Integer id){

        return R.success(service.getById(id));
    }

    @PostMapping("/findList")
    @ApiOperation(value = "列表查询")
    public R findList(@RequestBody TestQO qo){

        return R.success(service.findList(qo));
    }

    @PostMapping("/findPage")
    @ApiOperation(value = "分页查询")
    public R findPage(@RequestBody TestQO qo){

        return R.success(service.findPage(qo));
    }

}