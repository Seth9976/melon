package com.iloen.melon.net.v4x.request;

import U4.x;
import android.content.Context;
import androidx.appcompat.app.o;
import com.iloen.melon.net.v4x.response.PvLogDummyRes;

public class PvLogDummyReq extends RequestV4Req {
    protected String mAction;

    public PvLogDummyReq(Context context0, String s) {
        super(context0, 0, PvLogDummyRes.class, false);
        this.mAction = s;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return x.m(new StringBuilder("/pvlog/dummy/"), this.mAction, ".json");
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public boolean shouldCache() {
        return false;
    }

    @Override
    public String toString() {
        return o.r(new StringBuilder("PvLogDummyReq {action="), this.mAction, '}');
    }
}

