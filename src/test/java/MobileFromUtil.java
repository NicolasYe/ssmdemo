import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 通过手机号码,获得该号码的归属地
 *
 * @author Administrator
 *
 */
public class MobileFromUtil {
    //正则表达式,抽取手机归属地
    public static final String REGEX_GET_MOBILE= "" +
            "(?is)(<tr[^\\u4e00-\\u9fa5]*卡号归属地</td>[\\S]*[\\u4e00-\\u9fa5]*&nbsp;[\\u4e00-\\u9fa5]*</td></tr>)";
    //正则表达式,审核要获取手机归属地的手机是否符合格式,可以只输入手机 号码前7位
    public static final String REGEX_IS_MOBILE=
            "(?is)(^1[3|4|5|8][0-9]\\d{4,8}$)";

    /**
     * 获得手机号码归属地
     *
     * @param mobileNumber
     * @return
     * @throws Exception
     */
    public static String getMobileFrom(String mobileNumber) throws Exception {
        if(!veriyMobile(mobileNumber)){
            throw new Exception("不是完整的11位手机号或者正确的手机号前七位");
        }
        HttpClient client=null;
        HttpMethod method=null;
        NameValuePair mobileParameter=null;
        NameValuePair actionParameter=null;
        int httpStatusCode;

        String htmlSource=null;
        String result=null;


        try {
            client=new HttpClient();
            client.getHostConfiguration().setHost("www.ip138.com", 8080, "http");
            String url="/search.asp?mobile="+mobileNumber+"&action=mobile";
            method=new GetMethod(url);
//            mobileParameter=new NameValuePair("mobile",mobileNumber);
//            actionParameter=new NameValuePair("action","mobile");
//            method.setRequestBody(new NameValuePair[] { actionParameter,mobileParameter });
            //设置编码
            method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "GB2312");
            client.executeMethod(method);
//            String response = method.getResponseBodyAsString();
//            System.out.println(response);
            httpStatusCode=method.getStatusLine().getStatusCode();
            if(httpStatusCode!=200){
                throw new Exception("网页内容获取异常！Http Status Code:"+httpStatusCode);
            }

            htmlSource=method.getResponseBodyAsString();
            if(htmlSource!=null&&!htmlSource.equals("")){
                htmlSource=htmlSource.replaceAll("\\s*", "");
                System.out.println(htmlSource);
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
     * 验证手机号
     * @param mobileNumber
     * @return
     */
    public static boolean veriyMobile(String mobileNumber){
        Pattern p=null;
        Matcher m=null;

        p=Pattern.compile(REGEX_IS_MOBILE);
        m=p.matcher(mobileNumber);

        return m.matches();
    }

    /**
     * 测试
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println(getMobileFrom("13587155281"));
    }

}