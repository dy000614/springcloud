package cn.tedu.sp04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Sp04OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sp04OrderApplication.class, args);
    }

}
