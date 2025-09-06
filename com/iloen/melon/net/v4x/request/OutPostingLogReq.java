package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.target.SnsTarget;

public class OutPostingLogReq extends RequestV4Req {
    private static final String TAG = "OutPostingLogReq";
    private String mParam;

    public OutPostingLogReq(Context context0, SnsTarget snsTarget0, Sharable sharable0) {
        super(context0, 0, HttpResponse.class);
        this.mParam = sharable0.getOutPostingLogParam(snsTarget0);
        this.addMemberKey();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/sns/outPostingLog.json" + this.mParam;
    }
}

