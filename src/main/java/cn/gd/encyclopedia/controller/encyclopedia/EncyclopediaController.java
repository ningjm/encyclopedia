package cn.gd.encyclopedia.controller.encyclopedia;

import com.alibaba.fastjson.JSON;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

/**
 * @program: encyclopedia
 * @description: 百科全书
 * @author: Mr.Ning
 * @create: 2019-01-30 14:33
 **/

@Controller
@RequestMapping("api/encyclopedia")
public class EncyclopediaController {

//    @RequestMapping(value = "get_caipu",method = RequestMethod.GET)
    @GetMapping("get_caipu")
    @ResponseBody
    public Map getCaiPu() throws IOException {
        URL u = new URL("http://route.showapi.com/1164-2?showapi_appid=86731&showapi_sign=f527186d5e4b4cc798bee269af22c06b");
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
        Map<String,Object> showapi_res_body = (Map<String, Object>) (JSON.parseObject(s, Map.class).get("showapi_res_body"));
        Map result  = new HashMap();

        Iterator<Map.Entry<String, Object>> iterator = showapi_res_body.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            if(next.getKey().equals("remark") || next.getKey().equals("ret_code")){
                continue;
            }

            Map map = (Map)next.getValue();
            Iterator<Map.Entry<String, Object>> iterator2 = map.entrySet().iterator();
            while(iterator2.hasNext()) {
                Map.Entry<String, Object> next2 = iterator2.next();
                    result.put(next2.getKey(),next2.getValue());
            }
        }
        return result;
    }

    @RequestMapping(value = "get_caipu_page2",method = RequestMethod.GET)
    public String getCaipuPage(){
        return "encyclopedia/test3";//redirect:
    }
}
