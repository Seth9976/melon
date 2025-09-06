package k8;

import android.app.Application;
import com.iloen.melon.MelonAppBase;
import com.kakao.emoticon.auth.EmoticonConfig;
import com.kakao.emoticon.auth.IdpType;
import com.kakao.emoticon.interfaces.EmoticonAuthListener;
import com.kakao.sdk.auth.TokenManager;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import e3.h;

public final class z implements EmoticonConfig {
    public final IdpType a;

    public z() {
        this.a = IdpType.KAKAO;
    }

    @Override  // com.kakao.emoticon.auth.EmoticonConfig
    public final boolean enableLoginTab() {
        return true;
    }

    @Override  // com.kakao.emoticon.auth.EmoticonConfig
    public final String getAppKey() {
        return KakaoSdk.INSTANCE.getApplicationContextInfo().getAppKey();
    }

    @Override  // com.kakao.emoticon.auth.EmoticonConfig
    public final Application getApplication() {
        MelonAppBase.Companion.getClass();
        return t.a();
    }

    @Override  // com.kakao.emoticon.auth.EmoticonConfig
    public final EmoticonAuthListener getEmoticonAuthListener() {
        return new h();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // com.kakao.emoticon.auth.EmoticonConfig
    public final String getIdpToken() {
        OAuthToken oAuthToken0 = TokenManager.Companion.getInstance().getToken();
        return oAuthToken0 == null ? null : oAuthToken0.getAccessToken();
    }

    @Override  // com.kakao.emoticon.auth.EmoticonConfig
    public final IdpType getIdpType() {
        return this.a;
    }

    @Override  // com.kakao.emoticon.auth.EmoticonConfig
    public final String getKaHeader() {
        return KakaoSdk.INSTANCE.getApplicationContextInfo().getKaHeader();
    }
}

