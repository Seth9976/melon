package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicMyMusicListMymusicListenHistoryRes;
import e1.u;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001A\u00020\u0007H\u0014¨\u0006\b"}, d2 = {"Lcom/iloen/melon/net/v6x/request/MyMusicListMyMusicListenHistoryReq;", "Lcom/iloen/melon/net/v6x/request/RequestV6Req;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getApiPath", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MyMusicListMyMusicListenHistoryReq extends RequestV6Req {
    public static final int $stable = 8;

    public MyMusicListMyMusicListenHistoryReq(@Nullable Context context0) {
        super(context0, 0, MyMusicMyMusicListMymusicListenHistoryRes.class, false);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    @NotNull
    public String getApiPath() {
        return "/mymusic/listMymusicListenHistory.json";
    }
}

