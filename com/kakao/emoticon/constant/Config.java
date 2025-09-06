package com.kakao.emoticon.constant;

import android.content.Context;
import android.os.Bundle;
import com.kakao.emoticon.KakaoEmoticon;
import com.kakao.emoticon.auth.IdpType;

public class Config {
    public static final String EMOTICON_SDK_VERSION = "2.0.1";
    public static final String ITEM_API_AUTHORITY = null;
    public static final String KAKAOTALK_URI = "com.kakao.talk";
    public static final boolean isDebuggable = false;
    public static final boolean isLoggable = true;

    static {
        Config.ITEM_API_AUTHORITY = Config.getItemApiAuthority();
    }

    private static String getItemApiAuthority() {
        PhaseType phaseType0 = Config.getPhaseFromManifest(KakaoEmoticon.getApplication());
        if(KakaoEmoticon.getIdpType() == IdpType.DAUM) {
            switch(com.kakao.emoticon.constant.Config.1.$SwitchMap$com$kakao$emoticon$constant$PhaseType[phaseType0.ordinal()]) {
                case 1: {
                    return "beta-api-item.dev.daum.net";
                }
                case 2: {
                    return "sandbox-api-item.dev.daum.net";
                }
                case 3: {
                    return "alpha-api-item.dev.daum.net";
                }
                default: {
                    return "api-item.daum.net";
                }
            }
        }
        switch(com.kakao.emoticon.constant.Config.1.$SwitchMap$com$kakao$emoticon$constant$PhaseType[phaseType0.ordinal()]) {
            case 1: {
                return "beta-api-item.devel.kakao.com";
            }
            case 2: {
                return "sandbox-api-item.devel.kakao.com";
            }
            case 3: {
                return "alpha-api-item.devel.kakao.com";
            }
            default: {
                return "api-item.kakao.com";
            }
        }
    }

    private static PhaseType getPhaseFromManifest(Context context0) {
        PhaseType phaseType0;
        try {
            phaseType0 = PhaseType.production;
            Bundle bundle0 = context0.getPackageManager().getApplicationInfo("com.iloen.melon", 0x80).metaData;
            return bundle0 == null ? phaseType0 : PhaseType.valueOf(bundle0.getString("com.kakao.emoticon.Phase"));
        }
        catch(Exception unused_ex) {
            stringBuilder0.toString();
            return phaseType0;
        }
    }
}

