package com.funti.hello.spring.boot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloSpringBootApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloSpringBootApplicationTests {

    @LocalServerPort
    private int port;       //启动什么端口，用什么端口

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception{
        //测试本地访问的URL
        this.base = new URL("http://localhost:"+port+"/");
    }

    @Test
    public void contextLoads() {
        ResponseEntity<String> response =  template.getForEntity(base.toString(),String.class);
        assertThat(response.getBody(),equalTo("Hello Spring Boot"));
    }

}
