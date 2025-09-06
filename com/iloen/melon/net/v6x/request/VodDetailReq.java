package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.VodDetailRes;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001A\u00020\u0005H\u0014¨\u0006\t"}, d2 = {"Lcom/iloen/melon/net/v6x/request/VodDetailReq;", "Lcom/iloen/melon/net/v6x/request/RequestV6Req;", "context", "Landroid/content/Context;", "mvId", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "getApiPath", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VodDetailReq extends RequestV6Req {
    public static final int $stable = 8;

    public VodDetailReq(@Nullable Context context0, @NotNull String s) {
        q.g(s, "mvId");
        super(context0, 0, VodDetailRes.class);
        this.addParam("mvId", s);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    @NotNull
    public String getApiPath() {
        return "/vod/detail.json";
    }
}

