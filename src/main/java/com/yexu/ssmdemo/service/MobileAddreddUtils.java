package com.yexu.ssmdemo.service;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileAddreddUtils {

    /**
     * 从www.ip138.com返回的结果网页内容中获取手机号码归属地,结果为：省份 城市
     *
     * @param htmlSource
     * @return
     */
    public static String parseMobileFrom(String htmlSource){
        String result=null;
        String regEx = "[\\u4e00-\\u9fa5]*&nbsp;[\\u4e00-\\u9fa5]*</td></tr>";
        Pattern pattern = Pattern.compile(regEx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(htmlSource);
        if(matcher.find()){
            result=matcher.group().replaceAll("&nbsp;","");
            result=result.substring(0,result.toLowerCase().indexOf("</td></tr>"));
        }
        return result;

    }

    /**
     * 获得手机号码归属地
     *
     * @param mobileNumber
     * @return
     * @throws Exception
     */
    public static String getMobileFrom(String mobileNumber) throws Exception {
//        if(!veriyMobile(mobileNumber)){
//            throw new Exception("不是完整的11位手机号或者正确的手机号前七位");
//        }
        HttpClient client=null;
        HttpMethod method=null;
        int httpStatusCode;
        String htmlSource=null;
        String result=null;

        try {
            client=new HttpClient();
            client.getHostConfiguration().setHost("www.ip138.com", 8080, "http");
            String url="/search.asp?mobile="+mobileNumber+"&action=mobile";
            method=new GetMethod(url);
            //设置编码
            method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "GB2312");
            client.executeMethod(method);
            httpStatusCode=method.getStatusLine().getStatusCode();
            if(httpStatusCode!=200){
                throw new Exception("网页内容获取异常！Http Status Code:"+httpStatusCode);
            }

            htmlSource=method.getResponseBodyAsString();
            if(htmlSource!=null&&!htmlSource.equals("")){
                htmlSource=htmlSource.replaceAll("\\s*", "");
//                System.out.println(htmlSource);
                result=parseMobileFrom(htmlSource);
//                JSONObject json=new JSONObject(htmlSource);
//                System.out.println("key: status"+" "+"values:"+json.getString("status"));
            }
        } catch (RuntimeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            method.releaseConnection();
        }

        return result;

    }
}
