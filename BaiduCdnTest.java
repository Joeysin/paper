package com.joeysin.paper;

import com.baidubce.BceClientConfiguration;
import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.services.cdn.CdnClient;
import com.baidubce.services.cdn.model.PurgeRequest;
import com.baidubce.services.cdn.model.PurgeResponse;
import com.baidubce.services.cdn.model.PurgeTask;

public class BaiduCdnTest {
    public static void main(String[] args) {
        BceClientConfiguration config = new BceClientConfiguration()
                .withCredentials(new DefaultBceCredentials("171af9b9e5ac48d88eff4f45cd21fac6", "88accdd0259e4ce78b83374d1cb43a18"))
                .withEndpoint("cdn.baidu.com");
        CdnClient baiDuCdnClient = new CdnClient(config);
        PurgeRequest request = new PurgeRequest()
                .addTask(new PurgeTask().withUrl("http://bdcdn.fotoplace.cc/tv/180428/admin/88888888.jpg"));
        PurgeResponse purgeResponse = baiDuCdnClient.purge(request);
        System.out.println(purgeResponse.getId());
    }
}
