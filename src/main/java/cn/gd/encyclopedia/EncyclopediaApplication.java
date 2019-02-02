package cn.gd.encyclopedia;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

/**
 * @program: encyclopedia
 * @description: 启动类
 * @author: Mr.Ning
 * @create: 2019-01-22 15:32
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class EncyclopediaApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(EncyclopediaApplication.class, args);
    }
}
