package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.LiveChatRes;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0019\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001A\u00020\tH\u0014¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/net/v6x/request/LiveChatReq;", "Lcom/iloen/melon/net/v6x/request/RequestV6Req;", "context", "Landroid/content/Context;", "param", "Lcom/iloen/melon/net/v6x/request/LiveChatReq$Param;", "<init>", "(Landroid/content/Context;Lcom/iloen/melon/net/v6x/request/LiveChatReq$Param;)V", "getApiPath", "", "Param", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LiveChatReq extends RequestV6Req {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/net/v6x/request/LiveChatReq$Param;", "", "liveSeq", "", "memberKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getLiveSeq", "()Ljava/lang/String;", "getMemberKey", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Param {
        public static final int $stable;
        @NotNull
        private final String liveSeq;
        @NotNull
        private final String memberKey;

        public Param(@NotNull String s, @NotNull String s1) {
            q.g(s, "liveSeq");
            q.g(s1, "memberKey");
            super();
            this.liveSeq = s;
            this.memberKey = s1;
        }

        @NotNull
        public final String component1() {
            return this.liveSeq;
        }

        @NotNull
        public final String component2() {
            return this.memberKey;
        }

        @NotNull
        public final Param copy(@NotNull String s, @NotNull String s1) {
            q.g(s, "liveSeq");
            q.g(s1, "memberKey");
            return new Param(s, s1);
        }

        public static Param copy$default(Param liveChatReq$Param0, String s, String s1, int v, Object object0) {
            if((v & 1) != 0) {
                s = liveChatReq$Param0.liveSeq;
            }
            if((v & 2) != 0) {
                s1 = liveChatReq$Param0.memberKey;
            }
            return liveChatReq$Param0.copy(s, s1);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Param)) {
                return false;
            }
            return q.b(this.liveSeq, ((Param)object0).liveSeq) ? q.b(this.memberKey, ((Param)object0).memberKey) : false;
        }

        @NotNull
        public final String getLiveSeq() {
            return this.liveSeq;
        }

        @NotNull
        public final String getMemberKey() {
            return this.memberKey;
        }

        @Override
        public int hashCode() {
            return this.memberKey.hashCode() + this.liveSeq.hashCode() * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            return "Param(liveSeq=" + this.liveSeq + ", memberKey=" + this.memberKey + ")";
        }
    }

    public static final int $stable = 8;

    public LiveChatReq(@Nullable Context context0, @NotNull Param liveChatReq$Param0) {
        q.g(liveChatReq$Param0, "param");
        super(context0, 0, LiveChatRes.class);
        this.addParam("liveSeq", liveChatReq$Param0.getLiveSeq());
        this.addParam("memberKey", liveChatReq$Param0.getMemberKey());
    }

    @Override  // com.iloen.melon.net.HttpRequest
    @NotNull
    public String getApiPath() {
        return "/live/chat.json";
    }
}

