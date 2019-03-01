package com.funti.hello.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication()
public class HelloSpringBootApplication {

    //如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
    //如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加@ResponseBody注解。

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String sayHi(){
        return "Hello Spring Boot";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringBootApplication.class, args);
    }

}
