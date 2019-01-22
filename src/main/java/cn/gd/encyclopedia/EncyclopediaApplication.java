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

        URL u = new URL("http://route.showapi.com/1164-2?showapi_appid=85976&showapi_sign=0f5e472368a74be5bf2a15c584a71275");
        InputStream in = u.openStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            byte buf[] = new byte[1024];
            int read = 0;
            while ((read = in .read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        } finally {
            if ( in != null) {
                in .close();
            }
        }
        byte b[] = out.toByteArray();
        String s = new String(b, "utf-8");
        Map map = JSON.parseObject(s, Map.class);
        Map showapi_res_body = (Map)map.get("showapi_res_body");
        for (Object object : showapi_res_body.values()){
            System.out.println(object.toString());
//            for (Object map2 : ((Map)object).values()){
//                System.out.println(map2.toString());
//            }
        }

//        SpringApplication.run(EncyclopediaApplication.class, args);
    }
}
