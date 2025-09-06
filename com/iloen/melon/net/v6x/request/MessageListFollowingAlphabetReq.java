package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MessageListFollowingAlphabetRes;

public class MessageListFollowingAlphabetReq extends ListFollowingAlphabetBaseReq {
    public MessageListFollowingAlphabetReq(Context context0, Params listFollowingAlphabetBaseReq$Params0) {
        super(context0, 0, MessageListFollowingAlphabetRes.class);
        this.addMemberKey();
        this.addParams(listFollowingAlphabetBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/message/listFollowingAlphabet.json";
    }
}

