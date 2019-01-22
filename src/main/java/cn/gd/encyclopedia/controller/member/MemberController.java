package cn.gd.encyclopedia.controller.member;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * @program: encyclopedia
 * @description: 会员API
 * @author: Mr.Ning
 * @create: 2019-01-19 17:10
 **/

@RestController
public class MemberController {

    @GetMapping("get_caipu")
    public String getCaipu() throws IOException {
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
        for (Object obj : map.values()){
            System.out.println(obj.toString());
        }
        return s;
    }
}
