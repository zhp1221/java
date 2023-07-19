package com.zhanghp.lab03_req_rep.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanghp
 * @date 2023/7/18 20:00
 */
@RestController
@RequestMapping("/excel")
public class ExcelCtrl {

    @GetMapping("/response")
    public String responseHandle(){
        return "hello";
    }
}
