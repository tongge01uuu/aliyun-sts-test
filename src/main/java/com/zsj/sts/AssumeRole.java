// This file is auto-generated, don't edit it. Thanks.
package com.zsj.sts;

import com.aliyun.sts20150401.models.AssumeRoleResponse;
import com.aliyun.tea.TeaException;

public class AssumeRole {

    /**
     * 使用AK&SK初始化账号Client
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    public static com.aliyun.sts20150401.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                // 必填，您的 AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 必填，您的 AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // Endpoint 请参考 https://api.aliyun.com/product/Sts
        config.endpoint = "sts.cn-shanghai.aliyuncs.com";
        return new com.aliyun.sts20150401.Client(config);
    }

    public static AssumeRoleResponse assumeRole(String accessKeyId,
                                                String accessKeySecret,
                                                String roleArn,
                                                String roleSessionName) {

        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        try {
            com.aliyun.sts20150401.Client client = AssumeRole.createClient(accessKeyId, accessKeySecret);
            com.aliyun.sts20150401.models.AssumeRoleRequest assumeRoleRequest = new com.aliyun.sts20150401.models.AssumeRoleRequest();
            assumeRoleRequest.setRoleArn(roleArn);
            assumeRoleRequest.setRoleSessionName(roleSessionName);
            // 复制代码运行请自行打印 API 的返回值
            final AssumeRoleResponse assumeRoleResponse = client.assumeRoleWithOptions(assumeRoleRequest, runtime);
            System.out.println(assumeRoleResponse.getBody().getCredentials().getAccessKeyId());
            System.out.println(assumeRoleResponse.getBody().getCredentials().getAccessKeySecret());
            System.out.println(assumeRoleResponse.getBody().getCredentials().getExpiration());
            System.out.println(assumeRoleResponse.getBody().getCredentials().getSecurityToken());
            return assumeRoleResponse;
        } catch (TeaException error) {
            // 错误 message
            System.out.println(error.getMessage());
            // 诊断地址
            System.out.println(error.getData().get("Recommend"));
            com.aliyun.teautil.Common.assertAsString(error.message);
        } catch (Exception _error) {
            TeaException error = new TeaException(_error.getMessage(), _error);
            // 错误 message
            System.out.println(error.getMessage());
            // 诊断地址
            System.out.println(error.getData().get("Recommend"));
            com.aliyun.teautil.Common.assertAsString(error.message);
        }
        return null;
    }
}
