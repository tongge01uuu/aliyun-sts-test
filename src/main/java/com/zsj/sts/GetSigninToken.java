package com.zsj.sts;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.aliyun.sts20150401.models.AssumeRoleResponse;

import java.util.HashMap;
import java.util.Map;

public class GetSigninToken {

    public static String getSignToken(AssumeRoleResponse roleToken) {
        String url = "https://signin.aliyun.com/federation";

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8;");

        HttpRequest request = HttpUtil.createPost(url);
        request.addHeaders(headers);
        HttpResponse execute = request
                .form("Action", "GetSigninToken")
                .form("AccessKeyId", roleToken.getBody().getCredentials().getAccessKeyId())
                .form("AccessKeySecret", roleToken.getBody().getCredentials().getAccessKeySecret())
                .form("SecurityToken", roleToken.getBody().getCredentials().getSecurityToken())
                .form("TicketType", "mini")
                .execute();
        System.out.println(execute.getStatus());
        System.out.println(execute.body());
        final JSONObject jsonObject = JSONUtil.parseObj(execute.body());
        return jsonObject.getStr("SigninToken");


    }

}
