package com.iloen.melon.eventbus;

import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u000F2\u00020\u0001:\u0001\u000FBM\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000B\u001A\u00020\u0003\u0012\b\b\u0002\u0010\f\u001A\u00020\b¢\u0006\u0004\b\r\u0010\u000ER\u0010\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001A\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/eventbus/EventComment;", "Ljava/io/Serializable;", "actiontype", "", "chnlSeq", "", "cmtSeq", "isReplyAdded", "", "item", "Lcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;", "contsRefValue", "isCountAdded", "<init>", "(Ljava/lang/String;IIZLcom/iloen/melon/net/v3x/comments/CmtResViewModel$result$cmtList;Ljava/lang/String;Z)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class EventComment implements Serializable {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/eventbus/EventComment$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public final String actiontype;
    public final int chnlSeq;
    public final int cmtSeq;
    @NotNull
    public final String contsRefValue;
    public final boolean isCountAdded;
    public final boolean isReplyAdded;
    @Nullable
    public final cmtList item;
    private static final long serialVersionUID = 0x5A4807EFAC438710L;

    static {
        EventComment.Companion = new Companion(null);
        EventComment.$stable = 8;
    }

    public EventComment(@NotNull String s, int v) {
        q.g(s, "actiontype");
        this(s, v, 0, false, null, null, false, 0x7C, null);
    }

    public EventComment(@NotNull String s, int v, int v1) {
        q.g(s, "actiontype");
        this(s, v, v1, false, null, null, false, 120, null);
    }

    public EventComment(@NotNull String s, int v, int v1, boolean z) {
        q.g(s, "actiontype");
        this(s, v, v1, z, null, null, false, 0x70, null);
    }

    public EventComment(@NotNull String s, int v, int v1, boolean z, @Nullable cmtList cmtResViewModel$result$cmtList0) {
        q.g(s, "actiontype");
        this(s, v, v1, z, cmtResViewModel$result$cmtList0, null, false, 0x60, null);
    }

    public EventComment(@NotNull String s, int v, int v1, boolean z, @Nullable cmtList cmtResViewModel$result$cmtList0, @NotNull String s1) {
        q.g(s, "actiontype");
        q.g(s1, "contsRefValue");
        this(s, v, v1, z, cmtResViewModel$result$cmtList0, s1, false, 0x40, null);
    }

    public EventComment(@NotNull String s, int v, int v1, boolean z, @Nullable cmtList cmtResViewModel$result$cmtList0, @NotNull String s1, boolean z1) {
        q.g(s, "actiontype");
        q.g(s1, "contsRefValue");
        super();
        this.actiontype = s;
        this.chnlSeq = v;
        this.cmtSeq = v1;
        this.isReplyAdded = z;
        this.item = cmtResViewModel$result$cmtList0;
        this.contsRefValue = s1;
        this.isCountAdded = z1;
    }

    public EventComment(String s, int v, int v1, boolean z, cmtList cmtResViewModel$result$cmtList0, String s1, boolean z1, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v2 & 4) != 0) {
            v1 = -1;
        }
        if((v2 & 16) != 0) {
            cmtResViewModel$result$cmtList0 = null;
        }
        if((v2 & 0x20) != 0) {
            s1 = "";
        }
        this(s, v, v1, ((v2 & 8) == 0 ? z : false), cmtResViewModel$result$cmtList0, s1, ((v2 & 0x40) == 0 ? z1 : false));
    }
}

