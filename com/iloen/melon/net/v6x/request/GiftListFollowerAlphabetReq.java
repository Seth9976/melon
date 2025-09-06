package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.GiftListFollowerAlphabetRes;

public class GiftListFollowerAlphabetReq extends ListFollowerAlphabetBaseReq {
    public GiftListFollowerAlphabetReq(Context context0, Params listFollowerAlphabetBaseReq$Params0) {
        super(context0, 0, GiftListFollowerAlphabetRes.class);
        this.addMemberKey();
        this.addParams(listFollowerAlphabetBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/gift/listFollowerAlphabet.json";
    }
}

