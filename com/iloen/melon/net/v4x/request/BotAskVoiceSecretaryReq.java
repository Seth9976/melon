package com.iloen.melon.net.v4x.request;

import android.content.Context;
import com.iloen.melon.net.v4x.response.BotAskVoiceSecretaryRes;

public class BotAskVoiceSecretaryReq extends RequestV4Req {
    public static class Params {
        public String cType;
        public String clientTime;
        public String keyWord;
        public String keyWordType;
        public String memberKey;
        public String playerSonglist;
        public String sessionKey;
        public String status;

    }

    public static final String INPUT_TYPE_TEXT = "T";
    public static final String INPUT_TYPE_VOICE = "V";
    public static final String PAUSE = "PAUSE";
    public static final String PLAY = "PLAY";

    public BotAskVoiceSecretaryReq(Context context0, Params botAskVoiceSecretaryReq$Params0) {
        super(context0, 1, BotAskVoiceSecretaryRes.class);
        this.addParams(botAskVoiceSecretaryReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/bot/askVoiceSecretary.json";
    }
}

