package com.melon.net.res.v3;

import S7.b;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/melon/net/res/v3/UpdateCmtRes;", "Lcom/melon/net/res/v3/CmtBaseRes;", "<init>", "()V", "result", "Lcom/melon/net/res/v3/UpdateCmtRes$Result;", "getResult", "()Lcom/melon/net/res/v3/UpdateCmtRes$Result;", "setResult", "(Lcom/melon/net/res/v3/UpdateCmtRes$Result;)V", "Result", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class UpdateCmtRes extends CmtBaseRes {
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR2\u0010\u0010\u001A\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u00138\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001A\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001D¨\u0006\u001E"}, d2 = {"Lcom/melon/net/res/v3/UpdateCmtRes$Result;", "Ljava/io/Serializable;", "<init>", "()V", "cmtInfo", "Lcom/melon/net/res/v3/CommentApiModel$CmtInfoBase;", "getCmtInfo", "()Lcom/melon/net/res/v3/CommentApiModel$CmtInfoBase;", "setCmtInfo", "(Lcom/melon/net/res/v3/CommentApiModel$CmtInfoBase;)V", "memberInfo", "Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;", "getMemberInfo", "()Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;", "setMemberInfo", "(Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;)V", "attachList", "Ljava/util/ArrayList;", "Lcom/melon/net/res/v3/CommentApiModel$AttachListBase;", "Lkotlin/collections/ArrayList;", "getAttachList", "()Ljava/util/ArrayList;", "setAttachList", "(Ljava/util/ArrayList;)V", "message", "", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Result implements Serializable {
        public static final int $stable = 8;
        @b("atachList")
        @Nullable
        private ArrayList attachList;
        @b("cmtInfo")
        @Nullable
        private CmtInfoBase cmtInfo;
        @b("memberInfo")
        @Nullable
        private MemberInfoBase memberInfo;
        @b("message")
        @Nullable
        private String message;

        @Nullable
        public final ArrayList getAttachList() {
            return this.attachList;
        }

        @Nullable
        public final CmtInfoBase getCmtInfo() {
            return this.cmtInfo;
        }

        @Nullable
        public final MemberInfoBase getMemberInfo() {
            return this.memberInfo;
        }

        @Nullable
        public final String getMessage() {
            return this.message;
        }

        public final void setAttachList(@Nullable ArrayList arrayList0) {
            this.attachList = arrayList0;
        }

        public final void setCmtInfo(@Nullable CmtInfoBase commentApiModel$CmtInfoBase0) {
            this.cmtInfo = commentApiModel$CmtInfoBase0;
        }

        public final void setMemberInfo(@Nullable MemberInfoBase commentApiModel$MemberInfoBase0) {
            this.memberInfo = commentApiModel$MemberInfoBase0;
        }

        public final void setMessage(@Nullable String s) {
            this.message = s;
        }
    }

    public static final int $stable = 8;
    @b("result")
    @Nullable
    private Result result;

    @Nullable
    public final Result getResult() {
        return this.result;
    }

    public final void setResult(@Nullable Result updateCmtRes$Result0) {
        this.result = updateCmtRes$Result0;
    }
}

