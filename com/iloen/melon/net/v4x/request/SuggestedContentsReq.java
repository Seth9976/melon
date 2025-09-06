package com.iloen.melon.net.v4x.request;

import android.content.Context;
import java.util.Random;

public abstract class SuggestedContentsReq extends RequestV4Req {
    private static final int MAX_RECOMMEND_RANDOMKEY = 10;

    public SuggestedContentsReq(Context context0, int v, Class class0, boolean z) {
        super(context0, v, class0, z);
        this.addParam("randomKey", String.valueOf(SuggestedContentsReq.getRecommendKey()));
    }

    public static final int getRecommendKey() {
        return new Random().nextInt(10) + 1;
    }
}

