package com.example.demo.controller;


import com.example.demo.properties.GrilProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by wangmeng on 2017/12/14.
 */

@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    /*@Value("${cupSize}")//获取application.yml文件中名为ip的value值
    private String cupSize;
    @Value("${age}")
    private Integer age;
    @Value("${content}")
    private String content;*/
    @Autowired
    private GrilProperties grilProperties;

    //@RequestMapping(value = "/say", method = RequestMethod.GET)//value = "say/{id}"
    @GetMapping("/say")
    //或者@PostMapping("/say")
    public String say(@RequestParam  (value="id",required= true, defaultValue="0") Integer myId){//,
        // return  capSize + age;
        return "id " + myId;
    }
}
