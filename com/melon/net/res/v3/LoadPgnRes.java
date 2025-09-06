package com.melon.net.res.v3;

import Cb.i;
import E9.h;
import S7.b;
import ba.s;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000B2\u00020\u0001:\u0002\n\u000BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/melon/net/res/v3/LoadPgnRes;", "Lcom/melon/net/res/v3/CmtBaseRes;", "<init>", "()V", "result", "Lcom/melon/net/res/v3/LoadPgnRes$Result;", "getResult", "()Lcom/melon/net/res/v3/LoadPgnRes$Result;", "setResult", "(Lcom/melon/net/res/v3/LoadPgnRes$Result;)V", "Result", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LoadPgnRes extends CmtBaseRes {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/melon/net/res/v3/LoadPgnRes$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0004<=>;B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R$\u0010\t\u001A\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\t\u0010\n\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER$\u0010\u0010\u001A\u0004\u0018\u00010\u000F8\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001A\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u001A\"\u0004\b\u001B\u0010\u001CR$\u0010\u001E\u001A\u0004\u0018\u00010\u001D8\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u001E\u0010\u001F\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R6\u0010\'\u001A\u0016\u0012\u0004\u0012\u00020%\u0018\u00010$j\n\u0012\u0004\u0012\u00020%\u0018\u0001`&8\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\'\u0010(\u001A\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010.\u001A\u0004\u0018\u00010-8\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b.\u0010/\u001A\u0004\b0\u00101\"\u0004\b2\u00103R$\u00105\u001A\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b5\u00106\u001A\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006?"}, d2 = {"Lcom/melon/net/res/v3/LoadPgnRes$Result;", "Ljava/io/Serializable;", "", "<init>", "()V", "Lcom/melon/net/res/v3/CommentConfig;", "toUiModel", "()Lcom/melon/net/res/v3/CommentConfig;", "Lcom/melon/net/res/v3/LoadPgnRes$Result$ChnlInfo;", "chnlInfo", "Lcom/melon/net/res/v3/LoadPgnRes$Result$ChnlInfo;", "getChnlInfo", "()Lcom/melon/net/res/v3/LoadPgnRes$Result$ChnlInfo;", "setChnlInfo", "(Lcom/melon/net/res/v3/LoadPgnRes$Result$ChnlInfo;)V", "Lcom/melon/net/res/v3/LoadPgnRes$Result$SpamInfo;", "spamInfo", "Lcom/melon/net/res/v3/LoadPgnRes$Result$SpamInfo;", "getSpamInfo", "()Lcom/melon/net/res/v3/LoadPgnRes$Result$SpamInfo;", "setSpamInfo", "(Lcom/melon/net/res/v3/LoadPgnRes$Result$SpamInfo;)V", "Lcom/melon/net/res/v3/CommentApiModel$PageInfoBase;", "pageInfo", "Lcom/melon/net/res/v3/CommentApiModel$PageInfoBase;", "getPageInfo", "()Lcom/melon/net/res/v3/CommentApiModel$PageInfoBase;", "setPageInfo", "(Lcom/melon/net/res/v3/CommentApiModel$PageInfoBase;)V", "Lcom/melon/net/res/v3/CommentApiModel$PagingInfoBase;", "pagingInfo", "Lcom/melon/net/res/v3/CommentApiModel$PagingInfoBase;", "getPagingInfo", "()Lcom/melon/net/res/v3/CommentApiModel$PagingInfoBase;", "setPagingInfo", "(Lcom/melon/net/res/v3/CommentApiModel$PagingInfoBase;)V", "Ljava/util/ArrayList;", "Lcom/melon/net/res/v3/CommentApiModel$CmtListBase;", "Lkotlin/collections/ArrayList;", "cmtList", "Ljava/util/ArrayList;", "getCmtList", "()Ljava/util/ArrayList;", "setCmtList", "(Ljava/util/ArrayList;)V", "Lcom/melon/net/res/v3/LoadPgnRes$Result$SnsInfo;", "snsInfo", "Lcom/melon/net/res/v3/LoadPgnRes$Result$SnsInfo;", "getSnsInfo", "()Lcom/melon/net/res/v3/LoadPgnRes$Result$SnsInfo;", "setSnsInfo", "(Lcom/melon/net/res/v3/LoadPgnRes$Result$SnsInfo;)V", "Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;", "myMemberInfo", "Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;", "getMyMemberInfo", "()Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;", "setMyMemberInfo", "(Lcom/melon/net/res/v3/CommentApiModel$MemberInfoBase;)V", "Companion", "ChnlInfo", "SpamInfo", "SnsInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Result implements Serializable {
        @Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u001D\n\u0002\u0010\u000B\n\u0003\b\u0089\u0001\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00B9\u00012\u00020\u0001:\u0004\u00B8\u0001\u00B9\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR \u0010\u0010\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000FR \u0010\u0013\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000FR \u0010\u0016\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000FR\u001E\u0010\u0019\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0007\"\u0004\b\u001B\u0010\tR\u001E\u0010\u001C\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u0007\"\u0004\b\u001E\u0010\tR\u001E\u0010\u001F\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001E\u0010\"\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001E\u0010%\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\u0007\"\u0004\b\'\u0010\tR\u001E\u0010(\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001E\u0010.\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b/\u0010+\"\u0004\b0\u0010-R\u001E\u00101\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b2\u0010+\"\u0004\b3\u0010-R\u001E\u00104\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b5\u0010+\"\u0004\b6\u0010-R\u001E\u00107\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b8\u0010+\"\u0004\b9\u0010-R\u001E\u0010:\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b;\u0010+\"\u0004\b<\u0010-R\u001E\u0010=\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b>\u0010+\"\u0004\b?\u0010-R\u001E\u0010@\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bA\u0010+\"\u0004\bB\u0010-R\u001E\u0010C\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bD\u0010+\"\u0004\bE\u0010-R\u001E\u0010F\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bG\u0010+\"\u0004\bH\u0010-R\u001E\u0010I\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bJ\u0010+\"\u0004\bK\u0010-R\u001E\u0010L\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bM\u0010+\"\u0004\bN\u0010-R\u001E\u0010O\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bP\u0010\u0007\"\u0004\bQ\u0010\tR\u001E\u0010R\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bS\u0010+\"\u0004\bT\u0010-R\u001E\u0010U\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bV\u0010+\"\u0004\bW\u0010-R \u0010X\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bY\u0010\r\"\u0004\bZ\u0010\u000FR \u0010[\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\\\u0010\r\"\u0004\b]\u0010\u000FR \u0010^\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b_\u0010\r\"\u0004\b`\u0010\u000FR\u001E\u0010a\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bb\u0010\r\"\u0004\bc\u0010\u000FR\u001E\u0010d\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\be\u0010+\"\u0004\bf\u0010-R\u001E\u0010g\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bh\u0010+\"\u0004\bi\u0010-R\u001E\u0010j\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bk\u0010+\"\u0004\bl\u0010-R\u001E\u0010m\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bn\u0010+\"\u0004\bo\u0010-R\u001E\u0010p\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bq\u0010+\"\u0004\br\u0010-R\u001E\u0010s\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bt\u0010+\"\u0004\bu\u0010-R\u001E\u0010v\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bw\u0010+\"\u0004\bx\u0010-R\u001E\u0010y\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\bz\u0010+\"\u0004\b{\u0010-R\u001E\u0010|\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b}\u0010\u0007\"\u0004\b~\u0010\tR\"\u0010\u007F\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0080\u0001\u0010\r\"\u0005\b\u0081\u0001\u0010\u000FR#\u0010\u0082\u0001\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0083\u0001\u0010\r\"\u0005\b\u0084\u0001\u0010\u000FR#\u0010\u0085\u0001\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0086\u0001\u0010\r\"\u0005\b\u0087\u0001\u0010\u000FR#\u0010\u0088\u0001\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0089\u0001\u0010\r\"\u0005\b\u008A\u0001\u0010\u000FR!\u0010\u008B\u0001\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u008C\u0001\u0010\u0007\"\u0005\b\u008D\u0001\u0010\tR!\u0010\u008E\u0001\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u008F\u0001\u0010+\"\u0005\b\u0090\u0001\u0010-R!\u0010\u0091\u0001\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0092\u0001\u0010+\"\u0005\b\u0093\u0001\u0010-R!\u0010\u0094\u0001\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0095\u0001\u0010+\"\u0005\b\u0096\u0001\u0010-R!\u0010\u0097\u0001\u001A\u00020)8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u0098\u0001\u0010+\"\u0005\b\u0099\u0001\u0010-R#\u0010\u009A\u0001\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u009B\u0001\u0010\r\"\u0005\b\u009C\u0001\u0010\u000FR\u001F\u0010\u009D\u0001\u001A\u0004\u0018\u00010\u000BX\u0086\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u009E\u0001\u0010\r\"\u0005\b\u009F\u0001\u0010\u000FR\u001F\u0010\u00A0\u0001\u001A\u0004\u0018\u00010\u000BX\u0086\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u00A1\u0001\u0010\r\"\u0005\b\u00A2\u0001\u0010\u000FR\u001F\u0010\u00A3\u0001\u001A\u0004\u0018\u00010\u000BX\u0086\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u00A4\u0001\u0010\r\"\u0005\b\u00A5\u0001\u0010\u000FR\u001D\u0010\u00A6\u0001\u001A\u00020)X\u0086\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u00A7\u0001\u0010+\"\u0005\b\u00A8\u0001\u0010-R\u001D\u0010\u00A9\u0001\u001A\u00020)X\u0086\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u00AA\u0001\u0010+\"\u0005\b\u00AB\u0001\u0010-R\u001D\u0010\u00AC\u0001\u001A\u00020\u000BX\u0086\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u00AD\u0001\u0010\r\"\u0005\b\u00AE\u0001\u0010\u000FR\u001D\u0010\u00AF\u0001\u001A\u00020\u000BX\u0086\u000E\u00A2\u0006\u0010\n\u0000\u001A\u0005\b\u00B0\u0001\u0010\r\"\u0005\b\u00B1\u0001\u0010\u000FR\"\u0010\u00B2\u0001\u001A\u0005\u0018\u00010\u00B3\u0001X\u0086\u000E\u00A2\u0006\u0012\n\u0000\u001A\u0006\b\u00B4\u0001\u0010\u00B5\u0001\"\u0006\b\u00B6\u0001\u0010\u00B7\u0001\u00A8\u0006\u00BA\u0001"}, d2 = {"Lcom/melon/net/res/v3/LoadPgnRes$Result$ChnlInfo;", "Ljava/io/Serializable;", "<init>", "()V", "chnlSeq", "", "getChnlSeq", "()I", "setChnlSeq", "(I)V", "pocTypeCode", "", "getPocTypeCode", "()Ljava/lang/String;", "setPocTypeCode", "(Ljava/lang/String;)V", "cmtPocTypeCode", "getCmtPocTypeCode", "setCmtPocTypeCode", "chnlName", "getChnlName", "setChnlName", "pgnTitle", "getPgnTitle", "setPgnTitle", "cmtDsplyCnt", "getCmtDsplyCnt", "setCmtDsplyCnt", "cmtRegMinLength", "getCmtRegMinLength", "setCmtRegMinLength", "cmtRegMaxLength", "getCmtRegMaxLength", "setCmtRegMaxLength", "adcmtRegMinLength", "getAdcmtRegMinLength", "setAdcmtRegMinLength", "adcmtRegMaxLength", "getAdcmtRegMaxLength", "setAdcmtRegMaxLength", "adcmtUseFlag", "", "getAdcmtUseFlag", "()Z", "setAdcmtUseFlag", "(Z)V", "recmUseFlag", "getRecmUseFlag", "setRecmUseFlag", "reprtUseFlag", "getReprtUseFlag", "setReprtUseFlag", "attachUseFlag", "getAttachUseFlag", "setAttachUseFlag", "textAttachUseFlag", "getTextAttachUseFlag", "setTextAttachUseFlag", "musicAttachUseFlag", "getMusicAttachUseFlag", "setMusicAttachUseFlag", "imageAttachUseFlag", "getImageAttachUseFlag", "setImageAttachUseFlag", "vdoAttachUseFlag", "getVdoAttachUseFlag", "setVdoAttachUseFlag", "linkAttachUseFlag", "getLinkAttachUseFlag", "setLinkAttachUseFlag", "vdoLinkAttachUseFlag", "getVdoLinkAttachUseFlag", "setVdoLinkAttachUseFlag", "genrlLinkAttachUseFlag", "getGenrlLinkAttachUseFlag", "setGenrlLinkAttachUseFlag", "kakaoEmoticonAttachUseFlag", "getKakaoEmoticonAttachUseFlag", "setKakaoEmoticonAttachUseFlag", "attachMaxCnt", "getAttachMaxCnt", "setAttachMaxCnt", "pastePermFlag", "getPastePermFlag", "setPastePermFlag", "sumryViewUseFlag", "getSumryViewUseFlag", "setSumryViewUseFlag", "cmtGuidetext", "getCmtGuidetext", "setCmtGuidetext", "cmtPlaceholderText", "getCmtPlaceholderText", "setCmtPlaceholderText", "adcmtPlaceholderText", "getAdcmtPlaceholderText", "setAdcmtPlaceholderText", "mobileCmtPlaceholderText", "getMobileCmtPlaceholderText", "setMobileCmtPlaceholderText", "snsSimultPostUseFlag", "getSnsSimultPostUseFlag", "setSnsSimultPostUseFlag", "snsSyncpstUseFlag", "getSnsSyncpstUseFlag", "setSnsSyncpstUseFlag", "facebookSyncpstUseFlag", "getFacebookSyncpstUseFlag", "setFacebookSyncpstUseFlag", "twitterSyncpstUseFlag", "getTwitterSyncpstUseFlag", "setTwitterSyncpstUseFlag", "nateonSyncpstUseFlag", "getNateonSyncpstUseFlag", "setNateonSyncpstUseFlag", "cyworldSyncpstUseFlag", "getCyworldSyncpstUseFlag", "setCyworldSyncpstUseFlag", "kakaotalkSyncpstUseFlag", "getKakaotalkSyncpstUseFlag", "setKakaotalkSyncpstUseFlag", "kakaostorySyncpstUseFlag", "getKakaostorySyncpstUseFlag", "setKakaostorySyncpstUseFlag", "pageDsplyCmtCnt", "getPageDsplyCmtCnt", "setPageDsplyCmtCnt", "dateDsplyForm", "getDateDsplyForm", "setDateDsplyForm", "breakCmtDsplyText", "getBreakCmtDsplyText", "setBreakCmtDsplyText", "deleteCmtDsplyText", "getDeleteCmtDsplyText", "setDeleteCmtDsplyText", "secrtCmtDsplyText", "getSecrtCmtDsplyText", "setSecrtCmtDsplyText", "newDispPrid", "getNewDispPrid", "setNewDispPrid", "secrtCmtUseFlag", "getSecrtCmtUseFlag", "setSecrtCmtUseFlag", "readOnlyFlag", "getReadOnlyFlag", "setReadOnlyFlag", "blindContsCmtListFlag", "getBlindContsCmtListFlag", "setBlindContsCmtListFlag", "blindContsCmtWriteFlag", "getBlindContsCmtWriteFlag", "setBlindContsCmtWriteFlag", "blindContsDsplyText", "getBlindContsDsplyText", "setBlindContsDsplyText", "tempActCmtDsplyText", "getTempActCmtDsplyText", "setTempActCmtDsplyText", "tempActLinkUrlText", "getTempActLinkUrlText", "setTempActLinkUrlText", "reprtWindowUrl", "getReprtWindowUrl", "setReprtWindowUrl", "playFilterUseFlag", "getPlayFilterUseFlag", "setPlayFilterUseFlag", "checkArtistFanFlag", "getCheckArtistFanFlag", "setCheckArtistFanFlag", "cmtImageUploadDomain", "getCmtImageUploadDomain", "setCmtImageUploadDomain", "cmtImageCdnDomain", "getCmtImageCdnDomain", "setCmtImageCdnDomain", "contsRefLinkInfo", "Lcom/melon/net/res/v3/LoadPgnRes$Result$ChnlInfo$LinkInfo;", "getContsRefLinkInfo", "()Lcom/melon/net/res/v3/LoadPgnRes$Result$ChnlInfo$LinkInfo;", "setContsRefLinkInfo", "(Lcom/melon/net/res/v3/LoadPgnRes$Result$ChnlInfo$LinkInfo;)V", "LinkInfo", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class ChnlInfo implements Serializable {
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/melon/net/res/v3/LoadPgnRes$Result$ChnlInfo$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.melon.net.res.v3.LoadPgnRes.Result.ChnlInfo.Companion {
                private com.melon.net.res.v3.LoadPgnRes.Result.ChnlInfo.Companion() {
                }

                public com.melon.net.res.v3.LoadPgnRes.Result.ChnlInfo.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                }
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000B\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001C\u0010\n\u001A\u0004\u0018\u00010\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR\u001C\u0010\r\u001A\u0004\u0018\u00010\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/melon/net/res/v3/LoadPgnRes$Result$ChnlInfo$LinkInfo;", "Ljava/io/Serializable;", "<init>", "()V", "link", "", "getLink", "()Ljava/lang/String;", "setLink", "(Ljava/lang/String;)V", "contsRefName", "getContsRefName", "setContsRefName", "text1", "getText1", "setText1", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class LinkInfo implements Serializable {
                public static final int $stable = 8;
                @Nullable
                private String contsRefName;
                @Nullable
                private String link;
                @Nullable
                private String text1;

                @Nullable
                public final String getContsRefName() {
                    return this.contsRefName;
                }

                @Nullable
                public final String getLink() {
                    return this.link;
                }

                @Nullable
                public final String getText1() {
                    return this.text1;
                }

                public final void setContsRefName(@Nullable String s) {
                    this.contsRefName = s;
                }

                public final void setLink(@Nullable String s) {
                    this.link = s;
                }

                public final void setText1(@Nullable String s) {
                    this.text1 = s;
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final com.melon.net.res.v3.LoadPgnRes.Result.ChnlInfo.Companion Companion = null;
            @b("adcmtPlaceholderText")
            @Nullable
            private String adcmtPlaceholderText;
            @b("adcmtRegMaxLength")
            private int adcmtRegMaxLength;
            @b("adcmtRegMinLength")
            private int adcmtRegMinLength;
            @b("adcmtUseFlag")
            private boolean adcmtUseFlag;
            @b("atachMaxCnt")
            private int attachMaxCnt;
            @b("atachUseFlag")
            private boolean attachUseFlag;
            @b("blindContsCmtListFlag")
            private boolean blindContsCmtListFlag;
            @b("blindContsCmtWriteFlag")
            private boolean blindContsCmtWriteFlag;
            @b("blindContsDsplyText")
            @Nullable
            private String blindContsDsplyText;
            @b("breakCmtDsplyText")
            @Nullable
            private String breakCmtDsplyText;
            private boolean checkArtistFanFlag;
            @b("chnlName")
            @Nullable
            private String chnlName;
            @b("chnlSeq")
            private int chnlSeq;
            @b("cmtDsplyCnt")
            private int cmtDsplyCnt;
            @b("cmtGuidetext")
            @Nullable
            private String cmtGuidetext;
            @NotNull
            private String cmtImageCdnDomain;
            @NotNull
            private String cmtImageUploadDomain;
            @b("cmtPlaceholderText")
            @Nullable
            private String cmtPlaceholderText;
            @b("cmtPocTypeCode")
            @Nullable
            private String cmtPocTypeCode;
            @b("cmtRegMaxLength")
            private int cmtRegMaxLength;
            @b("cmtRegMinLength")
            private int cmtRegMinLength;
            @Nullable
            private LinkInfo contsRefLinkInfo;
            @b("cyworldSyncpstUseFlag")
            private boolean cyworldSyncpstUseFlag;
            @b("dateDsplyForm")
            @Nullable
            private String dateDsplyForm;
            @b("deleteCmtDsplyText")
            @Nullable
            private String deleteCmtDsplyText;
            @b("facebookSyncpstUseFlag")
            private boolean facebookSyncpstUseFlag;
            @b("genrlLinkAtachUseFlag")
            private boolean genrlLinkAttachUseFlag;
            @b("imageAtachUseFlag")
            private boolean imageAttachUseFlag;
            @b("kakaoEmoticonAtachUseFlag")
            private boolean kakaoEmoticonAttachUseFlag;
            @b("kakaostorySyncpstUseFlag")
            private boolean kakaostorySyncpstUseFlag;
            @b("kakaotalkSyncpstUseFlag")
            private boolean kakaotalkSyncpstUseFlag;
            @b("linkAtachUseFlag")
            private boolean linkAttachUseFlag;
            @b("mobileCmtPlaceholderText")
            @NotNull
            private String mobileCmtPlaceholderText;
            @b("musicAtachUseFlag")
            private boolean musicAttachUseFlag;
            @b("nateonSyncpstUseFlag")
            private boolean nateonSyncpstUseFlag;
            @b("newDispPrid")
            private int newDispPrid;
            @b("pageDsplyCmtCnt")
            private int pageDsplyCmtCnt;
            @b("pastePermFlag")
            private boolean pastePermFlag;
            @b("pgnTitle")
            @Nullable
            private String pgnTitle;
            private boolean playFilterUseFlag;
            @b("pocTypeCode")
            @Nullable
            private String pocTypeCode;
            @b("readOnlyFlag")
            private boolean readOnlyFlag;
            @b("recmUseFlag")
            private boolean recmUseFlag;
            @b("reprtUseFlag")
            private boolean reprtUseFlag;
            @Nullable
            private String reprtWindowUrl;
            @b("secrtCmtDsplyText")
            @Nullable
            private String secrtCmtDsplyText;
            @b("secrtCmtUseFlag")
            private boolean secrtCmtUseFlag;
            private static final long serialVersionUID = 0x79CD8CBA731D6F6L;
            @b("snsSimultPostUseFlag")
            private boolean snsSimultPostUseFlag;
            @b("snsSyncpstUseFlag")
            private boolean snsSyncpstUseFlag;
            @b("sumryViewUseFlag")
            private boolean sumryViewUseFlag;
            @Nullable
            private String tempActCmtDsplyText;
            @Nullable
            private String tempActLinkUrlText;
            @b("textAtachUseFlag")
            private boolean textAttachUseFlag;
            @b("twitterSyncpstUseFlag")
            private boolean twitterSyncpstUseFlag;
            @b("vdoAtachUseFlag")
            private boolean vdoAttachUseFlag;
            @b("vdoLinkAtachUseFlag")
            private boolean vdoLinkAttachUseFlag;

            static {
                ChnlInfo.Companion = new com.melon.net.res.v3.LoadPgnRes.Result.ChnlInfo.Companion(null);
                ChnlInfo.$stable = 8;
            }

            public ChnlInfo() {
                this.chnlSeq = -1;
                this.cmtDsplyCnt = -1;
                this.cmtRegMinLength = -1;
                this.cmtRegMaxLength = -1;
                this.adcmtRegMinLength = -1;
                this.adcmtRegMaxLength = -1;
                this.attachMaxCnt = -1;
                this.mobileCmtPlaceholderText = "";
                this.pageDsplyCmtCnt = -1;
                this.newDispPrid = -1;
                this.cmtImageUploadDomain = "";
                this.cmtImageCdnDomain = "";
            }

            @Nullable
            public final String getAdcmtPlaceholderText() {
                return this.adcmtPlaceholderText;
            }

            public final int getAdcmtRegMaxLength() {
                return this.adcmtRegMaxLength;
            }

            public final int getAdcmtRegMinLength() {
                return this.adcmtRegMinLength;
            }

            public final boolean getAdcmtUseFlag() {
                return this.adcmtUseFlag;
            }

            public final int getAttachMaxCnt() {
                return this.attachMaxCnt;
            }

            public final boolean getAttachUseFlag() {
                return this.attachUseFlag;
            }

            public final boolean getBlindContsCmtListFlag() {
                return this.blindContsCmtListFlag;
            }

            public final boolean getBlindContsCmtWriteFlag() {
                return this.blindContsCmtWriteFlag;
            }

            @Nullable
            public final String getBlindContsDsplyText() {
                return this.blindContsDsplyText;
            }

            @Nullable
            public final String getBreakCmtDsplyText() {
                return this.breakCmtDsplyText;
            }

            public final boolean getCheckArtistFanFlag() {
                return this.checkArtistFanFlag;
            }

            @Nullable
            public final String getChnlName() {
                return this.chnlName;
            }

            public final int getChnlSeq() {
                return this.chnlSeq;
            }

            public final int getCmtDsplyCnt() {
                return this.cmtDsplyCnt;
            }

            @Nullable
            public final String getCmtGuidetext() {
                return this.cmtGuidetext;
            }

            @NotNull
            public final String getCmtImageCdnDomain() {
                return this.cmtImageCdnDomain;
            }

            @NotNull
            public final String getCmtImageUploadDomain() [...] // 潜在的解密器

            @Nullable
            public final String getCmtPlaceholderText() {
                return this.cmtPlaceholderText;
            }

            @Nullable
            public final String getCmtPocTypeCode() {
                return this.cmtPocTypeCode;
            }

            public final int getCmtRegMaxLength() {
                return this.cmtRegMaxLength;
            }

            public final int getCmtRegMinLength() {
                return this.cmtRegMinLength;
            }

            @Nullable
            public final LinkInfo getContsRefLinkInfo() {
                return this.contsRefLinkInfo;
            }

            public final boolean getCyworldSyncpstUseFlag() {
                return this.cyworldSyncpstUseFlag;
            }

            @Nullable
            public final String getDateDsplyForm() {
                return this.dateDsplyForm;
            }

            @Nullable
            public final String getDeleteCmtDsplyText() {
                return this.deleteCmtDsplyText;
            }

            public final boolean getFacebookSyncpstUseFlag() {
                return this.facebookSyncpstUseFlag;
            }

            public final boolean getGenrlLinkAttachUseFlag() {
                return this.genrlLinkAttachUseFlag;
            }

            public final boolean getImageAttachUseFlag() {
                return this.imageAttachUseFlag;
            }

            public final boolean getKakaoEmoticonAttachUseFlag() {
                return this.kakaoEmoticonAttachUseFlag;
            }

            public final boolean getKakaostorySyncpstUseFlag() {
                return this.kakaostorySyncpstUseFlag;
            }

            public final boolean getKakaotalkSyncpstUseFlag() {
                return this.kakaotalkSyncpstUseFlag;
            }

            public final boolean getLinkAttachUseFlag() {
                return this.linkAttachUseFlag;
            }

            @NotNull
            public final String getMobileCmtPlaceholderText() [...] // 潜在的解密器

            public final boolean getMusicAttachUseFlag() {
                return this.musicAttachUseFlag;
            }

            public final boolean getNateonSyncpstUseFlag() {
                return this.nateonSyncpstUseFlag;
            }

            public final int getNewDispPrid() {
                return this.newDispPrid;
            }

            public final int getPageDsplyCmtCnt() {
                return this.pageDsplyCmtCnt;
            }

            public final boolean getPastePermFlag() {
                return this.pastePermFlag;
            }

            @Nullable
            public final String getPgnTitle() {
                return this.pgnTitle;
            }

            public final boolean getPlayFilterUseFlag() {
                return this.playFilterUseFlag;
            }

            @Nullable
            public final String getPocTypeCode() {
                return this.pocTypeCode;
            }

            public final boolean getReadOnlyFlag() {
                return this.readOnlyFlag;
            }

            public final boolean getRecmUseFlag() {
                return this.recmUseFlag;
            }

            public final boolean getReprtUseFlag() {
                return this.reprtUseFlag;
            }

            @Nullable
            public final String getReprtWindowUrl() {
                return this.reprtWindowUrl;
            }

            @Nullable
            public final String getSecrtCmtDsplyText() {
                return this.secrtCmtDsplyText;
            }

            public final boolean getSecrtCmtUseFlag() {
                return this.secrtCmtUseFlag;
            }

            public final boolean getSnsSimultPostUseFlag() {
                return this.snsSimultPostUseFlag;
            }

            public final boolean getSnsSyncpstUseFlag() {
                return this.snsSyncpstUseFlag;
            }

            public final boolean getSumryViewUseFlag() {
                return this.sumryViewUseFlag;
            }

            @Nullable
            public final String getTempActCmtDsplyText() {
                return this.tempActCmtDsplyText;
            }

            @Nullable
            public final String getTempActLinkUrlText() {
                return this.tempActLinkUrlText;
            }

            public final boolean getTextAttachUseFlag() {
                return this.textAttachUseFlag;
            }

            public final boolean getTwitterSyncpstUseFlag() {
                return this.twitterSyncpstUseFlag;
            }

            public final boolean getVdoAttachUseFlag() {
                return this.vdoAttachUseFlag;
            }

            public final boolean getVdoLinkAttachUseFlag() {
                return this.vdoLinkAttachUseFlag;
            }

            public final void setAdcmtPlaceholderText(@Nullable String s) {
                this.adcmtPlaceholderText = s;
            }

            public final void setAdcmtRegMaxLength(int v) {
                this.adcmtRegMaxLength = v;
            }

            public final void setAdcmtRegMinLength(int v) {
                this.adcmtRegMinLength = v;
            }

            public final void setAdcmtUseFlag(boolean z) {
                this.adcmtUseFlag = z;
            }

            public final void setAttachMaxCnt(int v) {
                this.attachMaxCnt = v;
            }

            public final void setAttachUseFlag(boolean z) {
                this.attachUseFlag = z;
            }

            public final void setBlindContsCmtListFlag(boolean z) {
                this.blindContsCmtListFlag = z;
            }

            public final void setBlindContsCmtWriteFlag(boolean z) {
                this.blindContsCmtWriteFlag = z;
            }

            public final void setBlindContsDsplyText(@Nullable String s) {
                this.blindContsDsplyText = s;
            }

            public final void setBreakCmtDsplyText(@Nullable String s) {
                this.breakCmtDsplyText = s;
            }

            public final void setCheckArtistFanFlag(boolean z) {
                this.checkArtistFanFlag = z;
            }

            public final void setChnlName(@Nullable String s) {
                this.chnlName = s;
            }

            public final void setChnlSeq(int v) {
                this.chnlSeq = v;
            }

            public final void setCmtDsplyCnt(int v) {
                this.cmtDsplyCnt = v;
            }

            public final void setCmtGuidetext(@Nullable String s) {
                this.cmtGuidetext = s;
            }

            public final void setCmtImageCdnDomain(@NotNull String s) {
                q.g(s, "<set-?>");
                this.cmtImageCdnDomain = s;
            }

            public final void setCmtImageUploadDomain(@NotNull String s) {
                q.g(s, "<set-?>");
                this.cmtImageUploadDomain = s;
            }

            public final void setCmtPlaceholderText(@Nullable String s) {
                this.cmtPlaceholderText = s;
            }

            public final void setCmtPocTypeCode(@Nullable String s) {
                this.cmtPocTypeCode = s;
            }

            public final void setCmtRegMaxLength(int v) {
                this.cmtRegMaxLength = v;
            }

            public final void setCmtRegMinLength(int v) {
                this.cmtRegMinLength = v;
            }

            public final void setContsRefLinkInfo(@Nullable LinkInfo loadPgnRes$Result$ChnlInfo$LinkInfo0) {
                this.contsRefLinkInfo = loadPgnRes$Result$ChnlInfo$LinkInfo0;
            }

            public final void setCyworldSyncpstUseFlag(boolean z) {
                this.cyworldSyncpstUseFlag = z;
            }

            public final void setDateDsplyForm(@Nullable String s) {
                this.dateDsplyForm = s;
            }

            public final void setDeleteCmtDsplyText(@Nullable String s) {
                this.deleteCmtDsplyText = s;
            }

            public final void setFacebookSyncpstUseFlag(boolean z) {
                this.facebookSyncpstUseFlag = z;
            }

            public final void setGenrlLinkAttachUseFlag(boolean z) {
                this.genrlLinkAttachUseFlag = z;
            }

            public final void setImageAttachUseFlag(boolean z) {
                this.imageAttachUseFlag = z;
            }

            public final void setKakaoEmoticonAttachUseFlag(boolean z) {
                this.kakaoEmoticonAttachUseFlag = z;
            }

            public final void setKakaostorySyncpstUseFlag(boolean z) {
                this.kakaostorySyncpstUseFlag = z;
            }

            public final void setKakaotalkSyncpstUseFlag(boolean z) {
                this.kakaotalkSyncpstUseFlag = z;
            }

            public final void setLinkAttachUseFlag(boolean z) {
                this.linkAttachUseFlag = z;
            }

            public final void setMobileCmtPlaceholderText(@NotNull String s) {
                q.g(s, "<set-?>");
                this.mobileCmtPlaceholderText = s;
            }

            public final void setMusicAttachUseFlag(boolean z) {
                this.musicAttachUseFlag = z;
            }

            public final void setNateonSyncpstUseFlag(boolean z) {
                this.nateonSyncpstUseFlag = z;
            }

            public final void setNewDispPrid(int v) {
                this.newDispPrid = v;
            }

            public final void setPageDsplyCmtCnt(int v) {
                this.pageDsplyCmtCnt = v;
            }

            public final void setPastePermFlag(boolean z) {
                this.pastePermFlag = z;
            }

            public final void setPgnTitle(@Nullable String s) {
                this.pgnTitle = s;
            }

            public final void setPlayFilterUseFlag(boolean z) {
                this.playFilterUseFlag = z;
            }

            public final void setPocTypeCode(@Nullable String s) {
                this.pocTypeCode = s;
            }

            public final void setReadOnlyFlag(boolean z) {
                this.readOnlyFlag = z;
            }

            public final void setRecmUseFlag(boolean z) {
                this.recmUseFlag = z;
            }

            public final void setReprtUseFlag(boolean z) {
                this.reprtUseFlag = z;
            }

            public final void setReprtWindowUrl(@Nullable String s) {
                this.reprtWindowUrl = s;
            }

            public final void setSecrtCmtDsplyText(@Nullable String s) {
                this.secrtCmtDsplyText = s;
            }

            public final void setSecrtCmtUseFlag(boolean z) {
                this.secrtCmtUseFlag = z;
            }

            public final void setSnsSimultPostUseFlag(boolean z) {
                this.snsSimultPostUseFlag = z;
            }

            public final void setSnsSyncpstUseFlag(boolean z) {
                this.snsSyncpstUseFlag = z;
            }

            public final void setSumryViewUseFlag(boolean z) {
                this.sumryViewUseFlag = z;
            }

            public final void setTempActCmtDsplyText(@Nullable String s) {
                this.tempActCmtDsplyText = s;
            }

            public final void setTempActLinkUrlText(@Nullable String s) {
                this.tempActLinkUrlText = s;
            }

            public final void setTextAttachUseFlag(boolean z) {
                this.textAttachUseFlag = z;
            }

            public final void setTwitterSyncpstUseFlag(boolean z) {
                this.twitterSyncpstUseFlag = z;
            }

            public final void setVdoAttachUseFlag(boolean z) {
                this.vdoAttachUseFlag = z;
            }

            public final void setVdoLinkAttachUseFlag(boolean z) {
                this.vdoLinkAttachUseFlag = z;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/melon/net/res/v3/LoadPgnRes$Result$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.melon.net.res.v3.LoadPgnRes.Result.Companion {
            private com.melon.net.res.v3.LoadPgnRes.Result.Companion() {
            }

            public com.melon.net.res.v3.LoadPgnRes.Result.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u000F\b\u0007\u0018\u0000 \u001C2\u00020\u0001:\u0001\u001CB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001E\u0010\n\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001E\u0010\u0013\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001E\u0010\u0016\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR \u0010\u0019\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0010\"\u0004\b\u001B\u0010\u0012¨\u0006\u001D"}, d2 = {"Lcom/melon/net/res/v3/LoadPgnRes$Result$SnsInfo;", "Ljava/io/Serializable;", "<init>", "()V", "facebookConnectFlag", "", "getFacebookConnectFlag", "()Z", "setFacebookConnectFlag", "(Z)V", "facebookConnectExpiredFlag", "getFacebookConnectExpiredFlag", "setFacebookConnectExpiredFlag", "facebookConnectInfoStatus", "", "getFacebookConnectInfoStatus", "()Ljava/lang/String;", "setFacebookConnectInfoStatus", "(Ljava/lang/String;)V", "twitterConnectFlag", "getTwitterConnectFlag", "setTwitterConnectFlag", "twitterConnectExpiredFlag", "getTwitterConnectExpiredFlag", "setTwitterConnectExpiredFlag", "twitterConnectInfoStatus", "getTwitterConnectInfoStatus", "setTwitterConnectInfoStatus", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class SnsInfo implements Serializable {
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/melon/net/res/v3/LoadPgnRes$Result$SnsInfo$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.melon.net.res.v3.LoadPgnRes.Result.SnsInfo.Companion {
                private com.melon.net.res.v3.LoadPgnRes.Result.SnsInfo.Companion() {
                }

                public com.melon.net.res.v3.LoadPgnRes.Result.SnsInfo.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final com.melon.net.res.v3.LoadPgnRes.Result.SnsInfo.Companion Companion = null;
            @b("facebookConnectExpiredFlag")
            private boolean facebookConnectExpiredFlag;
            @b("facebookConnectFlag")
            private boolean facebookConnectFlag;
            @b("facebookConnectInfoStatus")
            @Nullable
            private String facebookConnectInfoStatus;
            private static final long serialVersionUID = 0x139815DDF964B73EL;
            @b("twitterConnectExpiredFlag")
            private boolean twitterConnectExpiredFlag;
            @b("twitterConnectFlag")
            private boolean twitterConnectFlag;
            @b("twitterConnectInfoStatus")
            @Nullable
            private String twitterConnectInfoStatus;

            static {
                SnsInfo.Companion = new com.melon.net.res.v3.LoadPgnRes.Result.SnsInfo.Companion(null);
                SnsInfo.$stable = 8;
            }

            public final boolean getFacebookConnectExpiredFlag() {
                return this.facebookConnectExpiredFlag;
            }

            public final boolean getFacebookConnectFlag() {
                return this.facebookConnectFlag;
            }

            @Nullable
            public final String getFacebookConnectInfoStatus() {
                return this.facebookConnectInfoStatus;
            }

            public final boolean getTwitterConnectExpiredFlag() {
                return this.twitterConnectExpiredFlag;
            }

            public final boolean getTwitterConnectFlag() {
                return this.twitterConnectFlag;
            }

            @Nullable
            public final String getTwitterConnectInfoStatus() {
                return this.twitterConnectInfoStatus;
            }

            public final void setFacebookConnectExpiredFlag(boolean z) {
                this.facebookConnectExpiredFlag = z;
            }

            public final void setFacebookConnectFlag(boolean z) {
                this.facebookConnectFlag = z;
            }

            public final void setFacebookConnectInfoStatus(@Nullable String s) {
                this.facebookConnectInfoStatus = s;
            }

            public final void setTwitterConnectExpiredFlag(boolean z) {
                this.twitterConnectExpiredFlag = z;
            }

            public final void setTwitterConnectFlag(boolean z) {
                this.twitterConnectFlag = z;
            }

            public final void setTwitterConnectInfoStatus(@Nullable String s) {
                this.twitterConnectInfoStatus = s;
            }
        }

        @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 92\u00020\u0001:\u00019B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR\u001E\u0010\r\u001A\u00020\u000E8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001E\u0010\u0013\u001A\u00020\u000E8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001E\u0010\u0016\u001A\u00020\u00178\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001BR2\u0010\u001C\u001A\u0016\u0012\u0004\u0012\u00020\u001E\u0018\u00010\u001Dj\n\u0012\u0004\u0012\u00020\u001E\u0018\u0001`\u001F8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R2\u0010$\u001A\u0016\u0012\u0004\u0012\u00020%\u0018\u00010\u001Dj\n\u0012\u0004\u0012\u00020%\u0018\u0001`\u001F8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b&\u0010!\"\u0004\b\'\u0010#R2\u0010(\u001A\u0016\u0012\u0004\u0012\u00020)\u0018\u00010\u001Dj\n\u0012\u0004\u0012\u00020)\u0018\u0001`\u001F8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b*\u0010!\"\u0004\b+\u0010#R2\u0010,\u001A\u0016\u0012\u0004\u0012\u00020-\u0018\u00010\u001Dj\n\u0012\u0004\u0012\u00020-\u0018\u0001`\u001F8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b.\u0010!\"\u0004\b/\u0010#R \u00100\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b1\u0010\u0007\"\u0004\b2\u0010\tR \u00103\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b4\u0010\u0007\"\u0004\b5\u0010\tR \u00106\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b7\u0010\u0007\"\u0004\b8\u0010\t\u00A8\u0006:"}, d2 = {"Lcom/melon/net/res/v3/LoadPgnRes$Result$SpamInfo;", "Ljava/io/Serializable;", "<init>", "()V", "checkIpAddr", "", "getCheckIpAddr", "()Ljava/lang/String;", "setCheckIpAddr", "(Ljava/lang/String;)V", "checkMemberKey", "getCheckMemberKey", "setCheckMemberKey", "breakMemberFlag", "", "getBreakMemberFlag", "()Z", "setBreakMemberFlag", "(Z)V", "breakIpFlag", "getBreakIpFlag", "setBreakIpFlag", "cmtRegPosblMin", "", "getCmtRegPosblMin", "()I", "setCmtRegPosblMin", "(I)V", "breakWordList", "Ljava/util/ArrayList;", "Lcom/melon/net/res/v3/CommentApiModel$BreakWordlistBase;", "Lkotlin/collections/ArrayList;", "getBreakWordList", "()Ljava/util/ArrayList;", "setBreakWordList", "(Ljava/util/ArrayList;)V", "breakIpList", "Lcom/melon/net/res/v3/CommentApiModel$BreakIPListBase;", "getBreakIpList", "setBreakIpList", "vdoLinkAttachPermUrlList", "Lcom/melon/net/res/v3/CommentApiModel$VdoLinkAttachPermURLListBase;", "getVdoLinkAttachPermUrlList", "setVdoLinkAttachPermUrlList", "genrlLinkAttachBreakURLList", "Lcom/melon/net/res/v3/CommentApiModel$GenrlLinkAttachBreakURLListBase;", "getGenrlLinkAttachBreakURLList", "setGenrlLinkAttachBreakURLList", "breakMemberGuideUrl", "getBreakMemberGuideUrl", "setBreakMemberGuideUrl", "breakMemberGuideAppSchme", "getBreakMemberGuideAppSchme", "setBreakMemberGuideAppSchme", "breakMemberGuideText", "getBreakMemberGuideText", "setBreakMemberGuideText", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class SpamInfo implements Serializable {
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/melon/net/res/v3/LoadPgnRes$Result$SpamInfo$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class com.melon.net.res.v3.LoadPgnRes.Result.SpamInfo.Companion {
                private com.melon.net.res.v3.LoadPgnRes.Result.SpamInfo.Companion() {
                }

                public com.melon.net.res.v3.LoadPgnRes.Result.SpamInfo.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                }
            }

            public static final int $stable = 0;
            @NotNull
            public static final com.melon.net.res.v3.LoadPgnRes.Result.SpamInfo.Companion Companion = null;
            @b("breakIpFlag")
            private boolean breakIpFlag;
            @b("breakIpList")
            @Nullable
            private ArrayList breakIpList;
            @b("breakMemberFlag")
            private boolean breakMemberFlag;
            @b("breakMemberGuideAppSchme")
            @Nullable
            private String breakMemberGuideAppSchme;
            @b("breakMemberGuideText")
            @Nullable
            private String breakMemberGuideText;
            @b("breakMemberGuideUrl")
            @Nullable
            private String breakMemberGuideUrl;
            @b("breakWordList")
            @Nullable
            private ArrayList breakWordList;
            @b("checkIpAddr")
            @Nullable
            private String checkIpAddr;
            @b("checkMemberKey")
            @Nullable
            private String checkMemberKey;
            @b("cmtRegPosblMin")
            private int cmtRegPosblMin;
            @b("genrlLinkAtachBreakURLList")
            @Nullable
            private ArrayList genrlLinkAttachBreakURLList;
            private static final long serialVersionUID = 0xE8D2DF7C8C5C3C71L;
            @b("vdoLinkAtachPermUrlList")
            @Nullable
            private ArrayList vdoLinkAttachPermUrlList;

            static {
                SpamInfo.Companion = new com.melon.net.res.v3.LoadPgnRes.Result.SpamInfo.Companion(null);
                SpamInfo.$stable = 8;
            }

            public SpamInfo() {
                this.cmtRegPosblMin = -1;
            }

            public final boolean getBreakIpFlag() {
                return this.breakIpFlag;
            }

            @Nullable
            public final ArrayList getBreakIpList() {
                return this.breakIpList;
            }

            public final boolean getBreakMemberFlag() {
                return this.breakMemberFlag;
            }

            @Nullable
            public final String getBreakMemberGuideAppSchme() {
                return this.breakMemberGuideAppSchme;
            }

            @Nullable
            public final String getBreakMemberGuideText() {
                return this.breakMemberGuideText;
            }

            @Nullable
            public final String getBreakMemberGuideUrl() {
                return this.breakMemberGuideUrl;
            }

            @Nullable
            public final ArrayList getBreakWordList() {
                return this.breakWordList;
            }

            @Nullable
            public final String getCheckIpAddr() {
                return this.checkIpAddr;
            }

            @Nullable
            public final String getCheckMemberKey() {
                return this.checkMemberKey;
            }

            public final int getCmtRegPosblMin() {
                return this.cmtRegPosblMin;
            }

            @Nullable
            public final ArrayList getGenrlLinkAttachBreakURLList() {
                return this.genrlLinkAttachBreakURLList;
            }

            @Nullable
            public final ArrayList getVdoLinkAttachPermUrlList() {
                return this.vdoLinkAttachPermUrlList;
            }

            public final void setBreakIpFlag(boolean z) {
                this.breakIpFlag = z;
            }

            public final void setBreakIpList(@Nullable ArrayList arrayList0) {
                this.breakIpList = arrayList0;
            }

            public final void setBreakMemberFlag(boolean z) {
                this.breakMemberFlag = z;
            }

            public final void setBreakMemberGuideAppSchme(@Nullable String s) {
                this.breakMemberGuideAppSchme = s;
            }

            public final void setBreakMemberGuideText(@Nullable String s) {
                this.breakMemberGuideText = s;
            }

            public final void setBreakMemberGuideUrl(@Nullable String s) {
                this.breakMemberGuideUrl = s;
            }

            public final void setBreakWordList(@Nullable ArrayList arrayList0) {
                this.breakWordList = arrayList0;
            }

            public final void setCheckIpAddr(@Nullable String s) {
                this.checkIpAddr = s;
            }

            public final void setCheckMemberKey(@Nullable String s) {
                this.checkMemberKey = s;
            }

            public final void setCmtRegPosblMin(int v) {
                this.cmtRegPosblMin = v;
            }

            public final void setGenrlLinkAttachBreakURLList(@Nullable ArrayList arrayList0) {
                this.genrlLinkAttachBreakURLList = arrayList0;
            }

            public final void setVdoLinkAttachPermUrlList(@Nullable ArrayList arrayList0) {
                this.vdoLinkAttachPermUrlList = arrayList0;
            }
        }

        public static final int $stable = 0;
        @NotNull
        public static final com.melon.net.res.v3.LoadPgnRes.Result.Companion Companion = null;
        @b("chnlInfo")
        @Nullable
        private ChnlInfo chnlInfo;
        @b("cmtList")
        @Nullable
        private ArrayList cmtList;
        @Nullable
        private MemberInfoBase myMemberInfo;
        @b("pageInfo")
        @Nullable
        private PageInfoBase pageInfo;
        @b("pagingInfo")
        @Nullable
        private PagingInfoBase pagingInfo;
        private static final long serialVersionUID = 0x59E15AE8B1AA8977L;
        @b("snsInfo")
        @Nullable
        private SnsInfo snsInfo;
        @b("spamInfo")
        @Nullable
        private SpamInfo spamInfo;

        static {
            Result.Companion = new com.melon.net.res.v3.LoadPgnRes.Result.Companion(null);
            Result.$stable = 8;
        }

        @Nullable
        public final ChnlInfo getChnlInfo() {
            return this.chnlInfo;
        }

        @Nullable
        public final ArrayList getCmtList() {
            return this.cmtList;
        }

        @Nullable
        public final MemberInfoBase getMyMemberInfo() {
            return this.myMemberInfo;
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
        public final SnsInfo getSnsInfo() {
            return this.snsInfo;
        }

        @Nullable
        public final SpamInfo getSpamInfo() {
            return this.spamInfo;
        }

        public final void setChnlInfo(@Nullable ChnlInfo loadPgnRes$Result$ChnlInfo0) {
            this.chnlInfo = loadPgnRes$Result$ChnlInfo0;
        }

        public final void setCmtList(@Nullable ArrayList arrayList0) {
            this.cmtList = arrayList0;
        }

        public final void setMyMemberInfo(@Nullable MemberInfoBase commentApiModel$MemberInfoBase0) {
            this.myMemberInfo = commentApiModel$MemberInfoBase0;
        }

        public final void setPageInfo(@Nullable PageInfoBase commentApiModel$PageInfoBase0) {
            this.pageInfo = commentApiModel$PageInfoBase0;
        }

        public final void setPagingInfo(@Nullable PagingInfoBase commentApiModel$PagingInfoBase0) {
            this.pagingInfo = commentApiModel$PagingInfoBase0;
        }

        public final void setSnsInfo(@Nullable SnsInfo loadPgnRes$Result$SnsInfo0) {
            this.snsInfo = loadPgnRes$Result$SnsInfo0;
        }

        public final void setSpamInfo(@Nullable SpamInfo loadPgnRes$Result$SpamInfo0) {
            this.spamInfo = loadPgnRes$Result$SpamInfo0;
        }

        public s toUiModel() {
            return this.toUiModel();
        }

        @NotNull
        public CommentConfig toUiModel() {
            ArrayList arrayList2;
            SpamInfo loadPgnRes$Result$SpamInfo0 = this.spamInfo;
            if(loadPgnRes$Result$SpamInfo0 == null) {
                arrayList2 = new ArrayList();
            }
            else {
                ArrayList arrayList0 = loadPgnRes$Result$SpamInfo0.getVdoLinkAttachPermUrlList();
                if(arrayList0 == null) {
                    arrayList2 = new ArrayList();
                }
                else {
                    ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
                    for(Object object0: arrayList0) {
                        String s = ((VdoLinkAttachPermURLListBase)object0).getVdoLinkAttachPermUrl();
                        if(s == null) {
                            s = "";
                        }
                        arrayList1.add(s);
                    }
                    arrayList2 = h.W(arrayList1);
                }
            }
            int v = this.pagingInfo == null ? -1 : this.pagingInfo.getFirstPageNo();
            boolean z = this.chnlInfo == null ? false : this.chnlInfo.getPlayFilterUseFlag();
            boolean z1 = i.l(this.chnlInfo) && i.l(this.spamInfo);
            boolean z2 = this.chnlInfo == null ? false : this.chnlInfo.getRecmUseFlag();
            int v1 = this.pageInfo == null ? 0 : this.pageInfo.getValidCnt();
            boolean z3 = this.chnlInfo == null ? false : this.chnlInfo.getBlindContsCmtListFlag();
            boolean z4 = this.chnlInfo == null ? false : this.chnlInfo.getBlindContsCmtWriteFlag();
            String s1 = this.chnlInfo == null ? null : this.chnlInfo.getBlindContsDsplyText();
            if(s1 == null) {
                s1 = "";
            }
            int v2 = this.pageInfo == null ? -1 : this.pageInfo.getStartSeq();
            boolean z5 = this.chnlInfo == null ? false : this.chnlInfo.getCheckArtistFanFlag();
            boolean z6 = this.myMemberInfo == null ? false : this.myMemberInfo.getArtistFanFlag();
            boolean z7 = this.spamInfo == null ? false : this.spamInfo.getBreakMemberFlag();
            String s2 = this.spamInfo == null ? null : this.spamInfo.getBreakMemberGuideUrl();
            if(s2 == null) {
                s2 = "";
            }
            String s3 = this.spamInfo == null ? null : this.spamInfo.getBreakMemberGuideAppSchme();
            String s4 = s3 == null ? "" : s3;
            String s5 = this.spamInfo == null ? null : this.spamInfo.getBreakMemberGuideText();
            String s6 = s5 == null ? "" : s5;
            int v3 = this.chnlInfo == null ? -1 : this.chnlInfo.getChnlSeq();
            String s7 = this.chnlInfo == null ? null : this.chnlInfo.getChnlName();
            String s8 = s7 == null ? "" : s7;
            String s9 = this.pageInfo == null ? null : this.pageInfo.getContsRefValue();
            String s10 = s9 == null ? "" : s9;
            String s11 = this.chnlInfo == null ? null : this.chnlInfo.getAdcmtPlaceholderText();
            String s12 = s11 == null ? "" : s11;
            int v4 = this.chnlInfo == null ? 0 : this.chnlInfo.getAdcmtRegMinLength();
            int v5 = this.chnlInfo == null ? 0 : this.chnlInfo.getAdcmtRegMaxLength();
            boolean z8 = this.chnlInfo == null ? false : this.chnlInfo.getReprtUseFlag();
            boolean z9 = this.chnlInfo == null ? false : this.chnlInfo.getAdcmtUseFlag();
            boolean z10 = this.myMemberInfo == null ? false : this.myMemberInfo.getPinUseFlag();
            boolean z11 = this.chnlInfo == null ? false : this.chnlInfo.getPlayFilterUseFlag();
            String s13 = this.chnlInfo == null ? null : this.chnlInfo.getReprtWindowUrl();
            String s14 = s13 == null ? "" : s13;
            String s15 = this.chnlInfo == null ? null : "";
            String s16 = s15 == null ? "" : s15;
            int v6 = this.chnlInfo == null ? 0 : this.chnlInfo.getCmtRegMaxLength();
            int v7 = this.chnlInfo == null ? 0 : this.chnlInfo.getCmtRegMinLength();
            boolean z12 = this.chnlInfo == null ? false : this.chnlInfo.getMusicAttachUseFlag();
            boolean z13 = this.chnlInfo == null ? false : this.chnlInfo.getImageAttachUseFlag();
            boolean z14 = this.chnlInfo == null ? false : this.chnlInfo.getVdoAttachUseFlag();
            boolean z15 = this.chnlInfo == null ? false : this.chnlInfo.getLinkAttachUseFlag();
            boolean z16 = this.chnlInfo == null ? false : this.chnlInfo.getKakaoEmoticonAttachUseFlag();
            boolean z17 = this.chnlInfo == null ? false : this.chnlInfo.getAttachUseFlag();
            int v8 = this.chnlInfo == null ? 0 : this.chnlInfo.getAttachMaxCnt();
            String s17 = this.chnlInfo == null ? null : "";
            String s18 = s17 == null ? "" : s17;
            ChnlInfo loadPgnRes$Result$ChnlInfo0 = this.chnlInfo;
            return loadPgnRes$Result$ChnlInfo0 == null ? new CommentConfig(v, z, z1, z2, v1, z3, z4, s1, v2, z5, z6, z7, s2, s4, s6, v3, s8, s10, 0, s12, v4, v5, z8, z9, z10, z11, s14, s16, v6, v7, z12, z13, z14, z15, z16, z17, v8, s18, arrayList2, null, 0x40000, 0, null) : new CommentConfig(v, z, z1, z2, v1, z3, z4, s1, v2, z5, z6, z7, s2, s4, s6, v3, s8, s10, 0, s12, v4, v5, z8, z9, z10, z11, s14, s16, v6, v7, z12, z13, z14, z15, z16, z17, v8, s18, arrayList2, loadPgnRes$Result$ChnlInfo0.getContsRefLinkInfo(), 0x40000, 0, null);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @b("result")
    @Nullable
    private Result result;
    private static final long serialVersionUID = 0x96790A0C03F52401L;

    static {
        LoadPgnRes.Companion = new Companion(null);
        LoadPgnRes.$stable = 8;
    }

    @Nullable
    public final Result getResult() {
        return this.result;
    }

    public final void setResult(@Nullable Result loadPgnRes$Result0) {
        this.result = loadPgnRes$Result0;
    }
}

