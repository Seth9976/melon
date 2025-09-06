package com.melon.net.res.v3;

import S7.b;
import ba.s;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/melon/net/res/v3/InsertAdcmtRes;", "Lcom/melon/net/res/v3/CmtBaseRes;", "<init>", "()V", "res", "Lcom/melon/net/res/v3/InsertAdcmtRes$Result;", "getRes", "()Lcom/melon/net/res/v3/InsertAdcmtRes$Result;", "setRes", "(Lcom/melon/net/res/v3/InsertAdcmtRes$Result;)V", "Result", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class InsertAdcmtRes extends CmtBaseRes {
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R6\u0010\u000B\u001A\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n8\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R$\u0010\u0012\u001A\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001A\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001E¨\u0006\u001F"}, d2 = {"Lcom/melon/net/res/v3/InsertAdcmtRes$Result;", "Ljava/io/Serializable;", "", "<init>", "()V", "Lcom/melon/net/res/v3/InsertReplyUiModel;", "toUiModel", "()Lcom/melon/net/res/v3/InsertReplyUiModel;", "Ljava/util/ArrayList;", "Lcom/melon/net/res/v3/CommentApiModel$CmtInfoBase;", "Lkotlin/collections/ArrayList;", "adcmtList", "Ljava/util/ArrayList;", "getAdcmtList", "()Ljava/util/ArrayList;", "setAdcmtList", "(Ljava/util/ArrayList;)V", "Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;", "memberInfo", "Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;", "getMemberInfo", "()Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;", "setMemberInfo", "(Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;)V", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Result implements Serializable {
        public static final int $stable = 8;
        @b("adcmtList")
        @Nullable
        private ArrayList adcmtList;
        @b("memberInfo")
        @Nullable
        private MemberInfoBase memberInfo;
        @b("message")
        @Nullable
        private String message;

        @Nullable
        public final ArrayList getAdcmtList() {
            return this.adcmtList;
        }

        @Nullable
        public final MemberInfoBase getMemberInfo() {
            return this.memberInfo;
        }

        @Nullable
        public final String getMessage() {
            return this.message;
        }

        public final void setAdcmtList(@Nullable ArrayList arrayList0) {
            this.adcmtList = arrayList0;
        }

        public final void setMemberInfo(@Nullable MemberInfoBase commentApiModel$MemberInfoBase0) {
            this.memberInfo = commentApiModel$MemberInfoBase0;
        }

        public final void setMessage(@Nullable String s) {
            this.message = s;
        }

        public s toUiModel() {
            return this.toUiModel();
        }

        @NotNull
        public InsertReplyUiModel toUiModel() {
            return new InsertReplyUiModel((this.message == null ? "" : this.message));
        }
    }

    public static final int $stable = 8;
    @b("result")
    @Nullable
    private Result res;

    @Nullable
    public final Result getRes() {
        return this.res;
    }

    public final void setRes(@Nullable Result insertAdcmtRes$Result0) {
        this.res = insertAdcmtRes$Result0;
    }
}

