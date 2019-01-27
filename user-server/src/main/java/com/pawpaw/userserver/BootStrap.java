package com.pawpaw.userserver;

import com.pawpaw.framework.core.PawpawApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.pawpaw.userserver.dao")
@EnableAspectJAutoProxy
public class BootStrap {

    public static void main(String[] args) {
        new PawpawApplication().run(BootStrap.class, args);
    }
}
