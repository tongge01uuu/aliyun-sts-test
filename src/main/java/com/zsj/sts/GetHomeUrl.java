package com.zsj.sts;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class GetHomeUrl {

    public static String getHomeUrl(String singinToken) {
        try {
            String url = "https://signin.aliyun.com/federation"
                    + "?Action=Login"
                    + "&LoginUrl=" + URLEncoder.encode("https://signin.aliyun.com/1856383002258993.onaliyun.com/login.htm","utf-8")
                    + "&Destination="+ URLEncoder.encode("https://dmc-cn-shanghai.data.aliyun.com/dm/","utf-8")
                    + "&SigninToken=" + URLEncoder.encode(singinToken,"utf-8");
            return url;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
