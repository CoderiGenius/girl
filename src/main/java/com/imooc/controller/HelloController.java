package com.imooc.controller;

import com.imooc.domain.Girl;
import com.imooc.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
public class HelloController {
    @Autowired
    GirlProperties girlProperties;

    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping("/hello")
    public ResponseEntity<Map<String,Object>> hello(@RequestParam(value = "id", required = false, defaultValue = "default") String parm1, String parm2){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name", "zhangsan");
        return new ResponseEntity<Map<String,Object>>(map, HttpStatus.valueOf(400));
    }


    @GetMapping("/hello1")
    public ResponseEntity<Object> hello1(@RequestParam(value = "id", required = false, defaultValue = "default") String parm1, String parm2){
        return new ResponseEntity<Object>(new Girl(), HttpStatus.valueOf(404));
    }


    @RequestMapping(value = "/say/{id}", method = RequestMethod.GET)
    public String say(@PathVariable("id") String parm1, String parm2){
        return parm1+"~~"+parm2;
    }
}
