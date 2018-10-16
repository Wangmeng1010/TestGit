package com.example.demo.repository;


import com.example.demo.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wangmeng on 2017/12/18.
 */

public interface GirlRepository extends JpaRepository<Girl,Integer> {

}
