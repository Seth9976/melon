package com.iloen.melon.utils;

import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.OauthUserMeReq;
import com.iloen.melon.utils.log.LogU;
import k8.Y;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/iloen/melon/utils/PartnerUtils;", "", "Lcom/iloen/melon/utils/PartnerUtils$Callback;", "callback", "Lie/H;", "updateOauthUser", "(Lcom/iloen/melon/utils/PartnerUtils$Callback;)V", "Callback", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PartnerUtils {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/utils/PartnerUtils$Callback;", "", "", "appUserId", "Lie/H;", "onComplete", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface Callback {
        void onComplete(@NotNull String arg1);
    }

    public static final int $stable;
    @NotNull
    public static final PartnerUtils INSTANCE;

    static {
        PartnerUtils.INSTANCE = new PartnerUtils();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static final void updateOauthUser(@Nullable Callback partnerUtils$Callback0) {
        LogU.Companion.i("PartnerUtils", "updateOauthUser()");
        RequestBuilder.newInstance(new OauthUserMeReq(Y.a(MelonAppBase.Companion))).tag("PartnerUtils").listener(new b(partnerUtils$Callback0)).errorListener(new b(partnerUtils$Callback0)).request();
    }
}

