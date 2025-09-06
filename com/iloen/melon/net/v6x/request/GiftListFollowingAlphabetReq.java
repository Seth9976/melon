package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.GiftListFollowingAlphabetRes;

public class GiftListFollowingAlphabetReq extends ListFollowingAlphabetBaseReq {
    public GiftListFollowingAlphabetReq(Context context0, Params listFollowingAlphabetBaseReq$Params0) {
        super(context0, 0, GiftListFollowingAlphabetRes.class);
        this.addMemberKey();
        this.addParams(listFollowingAlphabetBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/gift/listFollowingAlphabet.json";
    }
}

