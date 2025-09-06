package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MainTopNotificationRes;
import e1.u;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000B\u001A\u00020\u0005H\u0014R\u000E\u0010\t\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/net/v6x/request/MainTopNotificationReq;", "Lcom/iloen/melon/net/v6x/request/RequestV6Req;", "context", "Landroid/content/Context;", "excludeNoticeSeqs", "", "excludeBadgeKey", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "KEY_EXCLUDE_NOTICE_SEQS", "KEY_EXCLUDE_BADGE", "getApiPath", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MainTopNotificationReq extends RequestV6Req {
    public static final int $stable = 8;
    @NotNull
    private final String KEY_EXCLUDE_BADGE;
    @NotNull
    private final String KEY_EXCLUDE_NOTICE_SEQS;

    public MainTopNotificationReq(@Nullable Context context0, @Nullable String s, @Nullable String s1) {
        super(context0, 0, MainTopNotificationRes.class, true);
        this.KEY_EXCLUDE_NOTICE_SEQS = "excludeNoticeSeqs";
        this.KEY_EXCLUDE_BADGE = "excludeBadgeKey";
        this.addParam("excludeNoticeSeqs", s);
        this.addParam("excludeBadgeKey", s1);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    @NotNull
    public String getApiPath() {
        return "/main/music/listUpperFeed.json";
    }
}

