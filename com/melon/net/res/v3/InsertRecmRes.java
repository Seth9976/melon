package com.melon.net.res.v3;

import S7.b;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/melon/net/res/v3/InsertRecmRes;", "Lcom/melon/net/res/v3/CmtBaseRes;", "<init>", "()V", "insertResult", "Lcom/melon/net/res/v3/InsertRecmRes$Result;", "getInsertResult", "()Lcom/melon/net/res/v3/InsertRecmRes$Result;", "setInsertResult", "(Lcom/melon/net/res/v3/InsertRecmRes$Result;)V", "Result", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class InsertRecmRes extends CmtBaseRes {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/melon/net/res/v3/InsertRecmRes$Result;", "Ljava/io/Serializable;", "<init>", "()V", "recmInfo", "Lcom/melon/net/res/v3/InsertRecmRes$Result$RecmInfo;", "getRecmInfo", "()Lcom/melon/net/res/v3/InsertRecmRes$Result$RecmInfo;", "setRecmInfo", "(Lcom/melon/net/res/v3/InsertRecmRes$Result$RecmInfo;)V", "RecmInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Result implements Serializable {
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u000E\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001E\u0010\n\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001E\u0010\u0010\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000FR\u001E\u0010\u0013\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001E\u0010\u0016\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR \u0010\u0019\u001A\u0004\u0018\u00010\u001A8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER \u0010\u001F\u001A\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/melon/net/res/v3/InsertRecmRes$Result$RecmInfo;", "Ljava/io/Serializable;", "<init>", "()V", "cmtSeq", "", "getCmtSeq", "()I", "setCmtSeq", "(I)V", "recmFlag", "", "getRecmFlag", "()Z", "setRecmFlag", "(Z)V", "nonRecmFlag", "getNonRecmFlag", "setNonRecmFlag", "recmChgCount", "getRecmChgCount", "setRecmChgCount", "nonRecmChgCount", "getNonRecmChgCount", "setNonRecmChgCount", "message", "", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "recommenderInfo", "Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;", "getRecommenderInfo", "()Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;", "setRecommenderInfo", "(Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class RecmInfo implements Serializable {
            public static final int $stable = 8;
            @b("cmtSeq")
            private int cmtSeq;
            @b("message")
            @Nullable
            private String message;
            @b("nonRecmChgCount")
            private int nonRecmChgCount;
            @b("nonRecmFlag")
            private boolean nonRecmFlag;
            @b("recmChgCount")
            private int recmChgCount;
            @b("recmFlag")
            private boolean recmFlag;
            @b("recommenderInfo")
            @Nullable
            private MemberInfoBase recommenderInfo;

            public RecmInfo() {
                this.cmtSeq = -1;
            }

            public final int getCmtSeq() {
                return this.cmtSeq;
            }

            @Nullable
            public final String getMessage() {
                return this.message;
            }

            public final int getNonRecmChgCount() {
                return this.nonRecmChgCount;
            }

            public final boolean getNonRecmFlag() {
                return this.nonRecmFlag;
            }

            public final int getRecmChgCount() {
                return this.recmChgCount;
            }

            public final boolean getRecmFlag() {
                return this.recmFlag;
            }

            @Nullable
            public final MemberInfoBase getRecommenderInfo() {
                return this.recommenderInfo;
            }

            public final void setCmtSeq(int v) {
                this.cmtSeq = v;
            }

            public final void setMessage(@Nullable String s) {
                this.message = s;
            }

            public final void setNonRecmChgCount(int v) {
                this.nonRecmChgCount = v;
            }

            public final void setNonRecmFlag(boolean z) {
                this.nonRecmFlag = z;
            }

            public final void setRecmChgCount(int v) {
                this.recmChgCount = v;
            }

            public final void setRecmFlag(boolean z) {
                this.recmFlag = z;
            }

            public final void setRecommenderInfo(@Nullable MemberInfoBase commentApiModel$MemberInfoBase0) {
                this.recommenderInfo = commentApiModel$MemberInfoBase0;
            }
        }

        public static final int $stable = 8;
        @b("recmInfo")
        @Nullable
        private RecmInfo recmInfo;

        @Nullable
        public final RecmInfo getRecmInfo() {
            return this.recmInfo;
        }

        public final void setRecmInfo(@Nullable RecmInfo insertRecmRes$Result$RecmInfo0) {
            this.recmInfo = insertRecmRes$Result$RecmInfo0;
        }
    }

    public static final int $stable = 8;
    @b("result")
    @Nullable
    private Result insertResult;

    @Nullable
    public final Result getInsertResult() {
        return this.insertResult;
    }

    public final void setInsertResult(@Nullable Result insertRecmRes$Result0) {
        this.insertResult = insertRecmRes$Result0;
    }
}

