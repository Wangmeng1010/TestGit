package com.example.demo.controller;

import com.example.demo.aspect.HttpAspect;
import com.example.demo.domain.Girl;
import com.example.demo.repository.GirlRepository;
import com.example.demo.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by wangmeng on 2017/12/18.
 */


@RequestMapping(value = "/grel")
@RestController
public class GrelController {
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    private  final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);


    /*获取女生列表*/
    @GetMapping(value = "/girls")
       public List<Girl> grilList(){
        logger.info("222222222222222");
        return girlRepository.findAll();
    }
    /**
     *     通过id获取一个女生
     */
    @GetMapping(value ="/girls/{id}")
    public Girl grilFindOne(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }
    /**
     *     创建一个女生
     */
    @PostMapping(value = "/girls")
    public  Girl addgirl(@Valid Girl girl, BindingResult bindingResult){//@RequestParam("age") Integer age, @RequestParam("cupSize" ) String cupSize
        if(bindingResult.hasErrors()){
        System.out.println(bindingResult.getFieldError().getDefaultMessage());
                return null;
        }
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());
        return girlRepository.save(girl);
    }

    /**
     * 通过id更新一个女生?
     *
     */
    @PutMapping(value= "/girl/id")
    public Girl updateGirl(@PathVariable("id")  Integer id,
                             @RequestParam("age") Integer age,
                             @RequestParam("cupSize") String cupSize){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
       return girlRepository.save(girl);
    }

    /**
     * 通过id删除一个女生
     */

    @DeleteMapping(value ="/girls/id")
    public void updateGirl(@PathVariable("id") Integer id){
               girlRepository.delete(id);
    }
    /**
     *
     */
    @PostMapping(value ="/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }
}
