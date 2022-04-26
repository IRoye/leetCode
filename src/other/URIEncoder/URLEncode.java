package other.URIEncoder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class URLEncode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String result = URLEncoder.encode("http://192.168.2.140:8082/gateway/interactive-service/util/environment?propertyKey=web.user-encrypt.enabled", "UTF-8");
        System.out.printf(result);
    }
}
