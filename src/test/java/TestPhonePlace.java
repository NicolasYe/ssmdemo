import sun.net.www.protocol.http.HttpURLConnection;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class TestPhonePlace {
    public static String checkMobilePlace(String mobilephone)
            throws IOException {
        //检测手机号码归属地
        URL url = new URL(
                "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel="
                        + mobilephone);
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        //取回查询结果
        String result="";
        int c;
        while (((c = inputStream.read()) != -1)) {
            int all = inputStream.available();
            byte[] b = new byte[all];
            inputStream.read(b);
            result += new String(b, "gbk");
        }
        System.out.println(result);
        HttpURLConnection httpConnection = (HttpURLConnection) urlConnection;
        String phoneadd = result.substring(55, 57)+result.substring(76, 78);
//        System.out.println(phoneadd);
        return phoneadd;
    }

    public static void main(String[] args) {
        try {
            String place=checkMobilePlace("15200033333");
            System.out.println(place);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
