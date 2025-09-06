package com.iloen.melon.net.v6x.request;

import A8.M;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.request.RequestV4Req;
import com.iloen.melon.net.v6x.response.BannerRes;
import e1.u;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\bB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001A\u00020\u0003H\u0014J\b\u0010\u0007\u001A\u00020\u0003H\u0014R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/iloen/melon/net/v6x/request/BannerReq;", "Lcom/iloen/melon/net/v4x/request/RequestV4Req;", "bannerType", "", "<init>", "(Ljava/lang/String;)V", "domain", "getApiPath", "BannerType", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class BannerReq extends RequestV4Req {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/net/v6x/request/BannerReq$BannerType;", "", "<init>", "()V", "MusicTab", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class BannerType {
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/net/v6x/request/BannerReq$BannerType$MusicTab;", "", "<init>", "()V", "TOP", "", "MIDDLE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class MusicTab {
            public static final int $stable = 0;
            @NotNull
            public static final MusicTab INSTANCE = null;
            @NotNull
            public static final String MIDDLE = "BN000009";
            @NotNull
            public static final String TOP = "BN000040";

            static {
                MusicTab.INSTANCE = new MusicTab();
            }
        }

        public static final int $stable;
        @NotNull
        public static final BannerType INSTANCE;

        static {
            BannerType.INSTANCE = new BannerType();
        }
    }

    public static final int $stable = 8;
    @NotNull
    private final String bannerType;

    public BannerReq(@NotNull String s) {
        q.g(s, "bannerType");
        super(Y.a(MelonAppBase.Companion), 0, BannerRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.bannerType = s;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    @NotNull
    public String domain() {
        q.f(M.e, "BANNER_SERVER_ADDR");
        return M.e;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.net.HttpRequest
    @NotNull
    public String getApiPath() {
        return "BN000040".equals(this.bannerType) ? "/api/public/bypass/v1/banner/" + this.bannerType : "/api/public/v1/banner/" + this.bannerType;
    }
}

