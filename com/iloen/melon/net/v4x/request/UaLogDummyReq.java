package com.iloen.melon.net.v4x.request;

import U4.x;
import android.content.Context;
import androidx.appcompat.app.o;
import java.util.HashMap;

public class UaLogDummyReq extends PvLogDummyReq {
    public UaLogDummyReq(Context context0, String s) {
        super(context0, s);
    }

    public UaLogDummyReq(Context context0, String s, HashMap hashMap0) {
        super(context0, s);
        if(hashMap0 != null) {
            for(Object object0: hashMap0.keySet()) {
                this.addParam(((String)object0), ((String)hashMap0.get(((String)object0))));
            }
        }
    }

    @Override  // com.iloen.melon.net.v4x.request.PvLogDummyReq
    public String getApiPath() {
        return x.m(new StringBuilder("/ualog/dummy/"), this.mAction, ".json");
    }

    @Override  // com.iloen.melon.net.v4x.request.PvLogDummyReq
    public String toString() {
        return o.r(new StringBuilder("UaLogDummyReq {action="), this.mAction, '}');
    }
}

