package com.imooc.controller;

import com.imooc.domain.Girl;
import com.imooc.domain.Result;
import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    @PostMapping(value = "/girls")
    public Object girlAdd(@Valid Girl girl, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			Result result = new Result();
			result.setCode(1);
			result.setMessage(bindingResult.getFieldError().getDefaultMessage());
			return result;
        }
        girlRepository.save(girl);
		Result<Girl> result = new Result();
        result.setCode(0);
		result.setMessage("成功");
		result.setData(girl);
        return result;
    }

    @GetMapping(value = "/girl/{id}")
    public Optional<Girl> girlFindOne(@PathVariable("id") Integer id){
        Girl girl = new Girl();
        girl.setId(id);
        Example<Girl> example = Example.of(girl);
        return girlRepository.findOne(example);
    }

    @PutMapping(value = "/girl/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,String cupSize, Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }
    @DeleteMapping(value = "/girl/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        Girl girl = new Girl();
        girl.setId(id);
        girlRepository.delete(girl);
    }

    @GetMapping(value = "/girl/age/{age}")
    public List<Girl> girlFindByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @GetMapping(value = "/girls/getage/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}
