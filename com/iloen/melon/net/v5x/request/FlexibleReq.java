package com.iloen.melon.net.v5x.request;

import android.content.Context;
import com.iloen.melon.net.v5x.response.FlexibleRes;
import com.iloen.melon.net.v6x.request.RequestV6Req;
import com.iloen.melon.utils.player.MediaCodecInfoCompat;
import e1.u;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001A\u00020\u0007H\u0014J\b\u0010\b\u001A\u00020\u0007H\u0014¨\u0006\n"}, d2 = {"Lcom/iloen/melon/net/v5x/request/FlexibleReq;", "Lcom/iloen/melon/net/v6x/request/RequestV6Req;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getApiPath", "", "getServerVersionPath", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class FlexibleReq extends RequestV6Req {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/net/v5x/request/FlexibleReq$Companion;", "", "<init>", "()V", "DOLBY_FILTER_CODE", "", "getDOLBY_FILTER_CODE", "()Ljava/lang/String;", "setDOLBY_FILTER_CODE", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        // 去混淆评级： 低(20)
        @NotNull
        public final String getDOLBY_FILTER_CODE() {
            return "FDBSY";
        }

        public final void setDOLBY_FILTER_CODE(@NotNull String s) {
            q.g(s, "<set-?>");
            FlexibleReq.DOLBY_FILTER_CODE = s;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static String DOLBY_FILTER_CODE;

    static {
        FlexibleReq.Companion = new Companion(null);
        FlexibleReq.$stable = 8;
        FlexibleReq.DOLBY_FILTER_CODE = "FDBSY";
    }

    public FlexibleReq(@Nullable Context context0) {
        super(context0, 0, FlexibleRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        if(MediaCodecInfoCompat.isAc4Supported()) {
            this.addParam("filterCodes", "FDBSY");
        }
    }

    // 去混淆评级： 低(20)
    public static final String access$getDOLBY_FILTER_CODE$cp() [...] // 潜在的解密器

    @Override  // com.iloen.melon.net.HttpRequest
    @NotNull
    public String getApiPath() {
        return "/main/music/flexible.json";
    }

    @Override  // com.iloen.melon.net.HttpRequest
    @NotNull
    public String getServerVersionPath() {
        return "/v7";
    }
}

