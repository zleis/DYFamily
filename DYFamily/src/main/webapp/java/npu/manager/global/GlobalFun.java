package npu.manager.global;

import com.alibaba.fastjson.JSONObject;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.io.*;
import java.net.URLDecoder;

import java.util.*;

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
     * @return HTTP 请求的JSON对象 <String,String>
     * @todo 将HTTP请求中的参数转化为Json对象
     */
    public static JSONObject getParamFromRequest(HttpServletRequest request){
        JSONObject resJson = new JSONObject();
        Map<String, String[]> requestMap = request.getParameterMap();
        try{
            for(Map.Entry<String,String[]> entry : requestMap.entrySet()) {
                resJson.put(entry.getKey(), URLDecoder.decode((entry.getValue())[0], "utf-8"));
            }
        }catch (Exception e){

        }
        return resJson;
    }

    /**
     * function getMapParamFromRequest
     * @author ZLei
     * @date 2017/9/19
     * @param request 获取map参数
     * @return java.util.Map<java.lang.String,java.lang.String>
     * @todo HTTP 请求的参数转为Map对象
     */
    public static Map<String, String> getMapParamFromRequest(HttpServletRequest request){
        Map<String, String> resMap = new HashMap<String, String>();
        Map<String, String[]> requestMap = request.getParameterMap();
        try{
            for(Map.Entry<String,String[]> entry : requestMap.entrySet()) {
                resMap.put(entry.getKey(), URLDecoder.decode((entry.getValue())[0], "utf-8"));
            }
        }catch (Exception e){

        }
        return resMap;
    }


    /**
     * function fileUpload
     * @author ZLei
     * @date 2017/9/17
     * @param path 文件路径,
     * @param fileName 文件名称,
     * @param multipartFile 文件流,
     * @return void
     * @todo 文件上传
     */
    public static int fileUpload(String path, String fileName, MultipartFile multipartFile){
        try{
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream
                    (new File( path + fileName  )));
            out.write(multipartFile.getBytes());
            out.flush();
            out.close();
            return GlobalVariable.REQUEST_SUCCESS;
        }catch (IOException e){
            System.out.println(e.getMessage());
            return GlobalVariable.UPLOAD_FILE_ERROR;
        }

    }
    
    /**
     * function getMenu
     * @author ZLei
     * @date 2017/9/30 
     * @param power 管理员权限
     * @return 返回管理员权限
     * @todo 获取管理员权限
     */
    public static JSONObject getMenu(int power){
        JSONObject jsonObject;
        String jsonStr = "";
        try{
            ResourceLoader loader = new DefaultResourceLoader();
            Resource resource = loader.getResource("classpath:/static/conf/config.json");

            FileInputStream finput = new FileInputStream(resource.getFile());
            InputStreamReader fileInputStream = new InputStreamReader(finput);
            BufferedReader bufferedReader = new BufferedReader(fileInputStream);

            String line = "";
            while((line = bufferedReader.readLine()) != null){
                jsonStr += line;

            }
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }
        JSONObject obj = JSONObject.parseObject(jsonStr);
        JSONObject menuObj = obj.getJSONObject(String.valueOf(power));
        return menuObj;
    }

}
