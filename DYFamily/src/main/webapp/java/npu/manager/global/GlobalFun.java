package npu.manager.global;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by  on .
 *
 * @version ${version}
 * @autor ZLei
 * @date 2017/9/16
 * @todo 公用函数
 */
public class GlobalFun {

    /**
     * function getParamFromRequest
     * @author ZLei
     * @date 2017/9/16
     * @param request
     * @return HTTP 请求的JSON对象 <String,String[]>
     * @todo 将HTTP请求中的参数转化为Json对象
     */
    public static JSONObject getParamFromRequest(HttpServletRequest request){
        JSONObject resJson = new JSONObject();
        Map<String, String[]> requestMap = request.getParameterMap();
        for(Map.Entry<String,String[]> entry : requestMap.entrySet()){
            resJson.put(entry.getKey(), entry.getValue());
        }
        return resJson;
    }
}
