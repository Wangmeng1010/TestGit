package com.example.demo.service;

import com.example.demo.domain.Girl;
import com.example.demo.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangmeng on 2017/12/21.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;
    @Transactional
    public void  insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(19);
        girlB.setCupSize("BBB");
        girlRepository.save(girlB);

    }
}
