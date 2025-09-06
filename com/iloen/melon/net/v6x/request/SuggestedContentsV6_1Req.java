package com.iloen.melon.net.v6x.request;

import android.content.Context;
import java.util.Random;

public abstract class SuggestedContentsV6_1Req extends RequestV6_1Req {
    private static final int MAX_RECOMMEND_RANDOMKEY = 10;

    public SuggestedContentsV6_1Req(Context context0, int v, Class class0, boolean z) {
        super(context0, v, class0, z);
        this.addParam("randomKey", String.valueOf(SuggestedContentsV6_1Req.getRecommendKey()));
    }

    public static final int getRecommendKey() {
        return new Random().nextInt(10) + 1;
    }
}

