package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.MessageListFollowerAlphabetRes;

public class MessageListFollowerAlphabetReq extends ListFollowerAlphabetBaseReq {
    public MessageListFollowerAlphabetReq(Context context0, Params listFollowerAlphabetBaseReq$Params0) {
        super(context0, 0, MessageListFollowerAlphabetRes.class);
        this.addMemberKey();
        this.addParams(listFollowerAlphabetBaseReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/message/listFollowerAlphabet.json";
    }
}

