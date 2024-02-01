package com.zsj.sts;

import com.aliyun.sts20150401.models.AssumeRoleResponse;

public class StsMain {

    public static void main(String[] args) {
        String accessKeyId = "RAM的accessKeyId";
        String accessKeySecret = "RAM的accessKeySecret";
        String roleArn = "acs:ram::主账号id:role/主账号角色名";
        String sessionName = "本次访问的人的用户唯一标识";
        AssumeRoleResponse assumeRoleResponse = AssumeRole.assumeRole(accessKeyId, accessKeySecret, roleArn, sessionName);
        String siginToken = GetSigninToken.getSignToken(assumeRoleResponse);
        String url = GetHomeUrl.getHomeUrl(siginToken);
        System.out.println(url);
    }

}
