package com.melon.net.res.v3;

import S7.b;
import ba.s;
import java.io.Serializable;
import java.util.ArrayList;
import je.q;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000B2\u00020\u0001:\u0002\n\u000BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/melon/net/res/v3/ListCmtRes;", "Lcom/melon/net/res/v3/CmtBaseRes;", "<init>", "()V", "res", "Lcom/melon/net/res/v3/ListCmtRes$Result;", "getRes", "()Lcom/melon/net/res/v3/ListCmtRes$Result;", "setRes", "(Lcom/melon/net/res/v3/ListCmtRes$Result;)V", "Result", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ListCmtRes extends CmtBaseRes {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/melon/net/res/v3/ListCmtRes$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R$\u0010\t\u001A\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\t\u0010\n\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER$\u0010\u0010\u001A\u0004\u0018\u00010\u000F8\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R6\u0010\u0019\u001A\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u00188\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER6\u0010\u001F\u001A\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u00188\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u001F\u0010\u001A\u001A\u0004\b \u0010\u001C\"\u0004\b!\u0010\u001E¨\u0006#"}, d2 = {"Lcom/melon/net/res/v3/ListCmtRes$Result;", "Ljava/io/Serializable;", "", "<init>", "()V", "Lcom/melon/net/res/v3/CommentListUiModel;", "toUiModel", "()Lcom/melon/net/res/v3/CommentListUiModel;", "Lcom/melon/net/res/v3/CommentApiModel$PageInfoBase;", "pageInfo", "Lcom/melon/net/res/v3/CommentApiModel$PageInfoBase;", "getPageInfo", "()Lcom/melon/net/res/v3/CommentApiModel$PageInfoBase;", "setPageInfo", "(Lcom/melon/net/res/v3/CommentApiModel$PageInfoBase;)V", "Lcom/melon/net/res/v3/CommentApiModel$PagingInfoBase;", "pagingInfo", "Lcom/melon/net/res/v3/CommentApiModel$PagingInfoBase;", "getPagingInfo", "()Lcom/melon/net/res/v3/CommentApiModel$PagingInfoBase;", "setPagingInfo", "(Lcom/melon/net/res/v3/CommentApiModel$PagingInfoBase;)V", "Ljava/util/ArrayList;", "Lcom/melon/net/res/v3/CommentApiModel$CmtListBase;", "Lkotlin/collections/ArrayList;", "cmtList", "Ljava/util/ArrayList;", "getCmtList", "()Ljava/util/ArrayList;", "setCmtList", "(Ljava/util/ArrayList;)V", "topList", "getTopList", "setTopList", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Result implements Serializable {
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/melon/net/res/v3/ListCmtRes$Result$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.melon.net.res.v3.ListCmtRes.Result.Companion {
            private com.melon.net.res.v3.ListCmtRes.Result.Companion() {
            }

            public com.melon.net.res.v3.ListCmtRes.Result.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        public static final int $stable = 0;
        @NotNull
        public static final com.melon.net.res.v3.ListCmtRes.Result.Companion Companion = null;
        @b("cmtList")
        @Nullable
        private ArrayList cmtList;
        @b("pageInfo")
        @Nullable
        private PageInfoBase pageInfo;
        @b("pagingInfo")
        @Nullable
        private PagingInfoBase pagingInfo;
        private static final long serialVersionUID = 0x9A080EBFC75F0B8L;
        @b("topList")
        @Nullable
        private ArrayList topList;

        static {
            Result.Companion = new com.melon.net.res.v3.ListCmtRes.Result.Companion(null);
            Result.$stable = 8;
        }

        @Nullable
        public final ArrayList getCmtList() {
            return this.cmtList;
        }

        @Nullable
        public final PageInfoBase getPageInfo() {
            return this.pageInfo;
        }

        @Nullable
        public final PagingInfoBase getPagingInfo() {
            return this.pagingInfo;
        }

        @Nullable
        public final ArrayList getTopList() {
            return this.topList;
        }

        public final void setCmtList(@Nullable ArrayList arrayList0) {
            this.cmtList = arrayList0;
        }

        public final void setPageInfo(@Nullable PageInfoBase commentApiModel$PageInfoBase0) {
            this.pageInfo = commentApiModel$PageInfoBase0;
        }

        public final void setPagingInfo(@Nullable PagingInfoBase commentApiModel$PagingInfoBase0) {
            this.pagingInfo = commentApiModel$PagingInfoBase0;
        }

        public final void setTopList(@Nullable ArrayList arrayList0) {
            this.topList = arrayList0;
        }

        public s toUiModel() {
            return this.toUiModel();
        }

        @NotNull
        public CommentListUiModel toUiModel() {
            w w1;
            int v = -1;
            int v1 = 0;
            boolean z = (this.pageInfo == null ? -1 : this.pageInfo.getPageNo()) < (this.pagingInfo == null ? -1 : this.pagingInfo.getNextPageNo());
            int v2 = this.pagingInfo == null ? -1 : this.pagingInfo.getNextPageNo();
            PageInfoBase commentApiModel$PageInfoBase0 = this.pageInfo;
            if(commentApiModel$PageInfoBase0 != null) {
                v = commentApiModel$PageInfoBase0.getPageNo();
            }
            PageInfoBase commentApiModel$PageInfoBase1 = this.pageInfo;
            if(commentApiModel$PageInfoBase1 != null) {
                v1 = commentApiModel$PageInfoBase1.getValidCnt();
            }
            ArrayList arrayList0 = this.cmtList;
            w w0 = w.a;
            if(arrayList0 == null) {
                w1 = w0;
            }
            else {
                ArrayList arrayList1 = new ArrayList(q.Q(10, arrayList0));
                for(Object object0: arrayList0) {
                    s s0 = ((CmtListBase)object0).toUiModel();
                    kotlin.jvm.internal.q.e(s0, "null cannot be cast to non-null type com.melon.net.res.v3.CommentUiModel");
                    arrayList1.add(((CommentUiModel)s0));
                }
                w1 = arrayList1;
            }
            ArrayList arrayList2 = this.topList;
            if(arrayList2 != null) {
                w0 = new ArrayList(q.Q(10, arrayList2));
                for(Object object1: arrayList2) {
                    s s1 = ((CmtListBase)object1).toUiModel();
                    kotlin.jvm.internal.q.e(s1, "null cannot be cast to non-null type com.melon.net.res.v3.CommentUiModel");
                    w0.add(((CommentUiModel)s1));
                }
            }
            return new CommentListUiModel(z, v2, v, v1, w1, w0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @b("result")
    @Nullable
    private Result res;
    private static final long serialVersionUID = -3999506342838430773L;

    static {
        ListCmtRes.Companion = new Companion(null);
        ListCmtRes.$stable = 8;
    }

    @Nullable
    public final Result getRes() {
        return this.res;
    }

    public final void setRes(@Nullable Result listCmtRes$Result0) {
        this.res = listCmtRes$Result0;
    }
}

