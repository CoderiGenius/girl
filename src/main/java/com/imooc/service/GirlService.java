package com.imooc.service;

import com.imooc.domain.Girl;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.GirlException;
import com.imooc.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class GirlService {
	@Autowired
	private GirlRepository girlRepository;

	public void getAge(Integer id) throws Exception{
	    try {
            Girl girl = girlRepository.findById(id).get();
            if(girl.getAge() < 10){
                throw new GirlException(100,"小学");
            }else {
                throw new GirlException(100,"非小学");
            }
        }catch(NoSuchElementException e){
            throw new Exception("id 不存在");
        }

    }
}
