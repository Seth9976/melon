package Ba;

import ie.d;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.c;
import vg.e;
import vg.f;
import vg.o;
import vg.t;

@d
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JJ\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0001\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u00042\n\b\u0003\u0010\u0006\u001A\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u0007\u001A\u00020\u00042\b\b\u0003\u0010\b\u001A\u00020\u0004H\u00A7@\u00A2\u0006\u0004\b\u000B\u0010\fJ\u009A\u0001\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00160\t2\b\b\u0001\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u00042\n\b\u0003\u0010\r\u001A\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000E\u001A\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000F\u001A\u0004\u0018\u00010\u00042\n\b\u0003\u0010\u0010\u001A\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0011\u001A\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u0013\u001A\u00020\u00122\n\b\u0003\u0010\u0014\u001A\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u0015\u001A\u00020\u00022\b\b\u0003\u0010\u0007\u001A\u00020\u00042\b\b\u0003\u0010\b\u001A\u00020\u0004H\u00A7@\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u00C0\u0001\u0010\u001E\u001A\b\u0012\u0004\u0012\u00020\u001D0\t2\b\b\u0001\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u00042\n\b\u0003\u0010\u0019\u001A\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u001A\u001A\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u001B\u001A\u0004\u0018\u00010\u00022\n\b\u0003\u0010\r\u001A\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000E\u001A\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u000F\u001A\u0004\u0018\u00010\u00042\n\b\u0003\u0010\u0010\u001A\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0011\u001A\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u001C\u001A\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0014\u001A\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u0015\u001A\u00020\u00022\b\b\u0003\u0010\u0007\u001A\u00020\u00042\b\b\u0003\u0010\b\u001A\u00020\u0004H\u00A7@\u00A2\u0006\u0004\b\u001E\u0010\u001FJT\u0010%\u001A\b\u0012\u0004\u0012\u00020$0\t2\b\b\u0001\u0010 \u001A\u00020\u00022\n\b\u0001\u0010!\u001A\u0004\u0018\u00010\u00042\b\b\u0001\u0010\"\u001A\u00020\u00022\b\b\u0001\u0010#\u001A\u00020\u00122\b\b\u0003\u0010\u0007\u001A\u00020\u00042\b\b\u0003\u0010\b\u001A\u00020\u0004H\u00A7@\u00A2\u0006\u0004\b%\u0010&JT\u0010(\u001A\b\u0012\u0004\u0012\u00020\'0\t2\b\b\u0001\u0010 \u001A\u00020\u00022\n\b\u0001\u0010!\u001A\u0004\u0018\u00010\u00042\b\b\u0001\u0010\"\u001A\u00020\u00022\b\b\u0001\u0010#\u001A\u00020\u00122\b\b\u0003\u0010\u0007\u001A\u00020\u00042\b\b\u0003\u0010\b\u001A\u00020\u0004H\u00A7@\u00A2\u0006\u0004\b(\u0010&JJ\u0010*\u001A\b\u0012\u0004\u0012\u00020)0\t2\b\b\u0001\u0010 \u001A\u00020\u00022\n\b\u0001\u0010!\u001A\u0004\u0018\u00010\u00042\b\b\u0001\u0010\"\u001A\u00020\u00022\b\b\u0003\u0010\u0007\u001A\u00020\u00042\b\b\u0003\u0010\b\u001A\u00020\u0004H\u00A7@\u00A2\u0006\u0004\b*\u0010+\u00A8\u0006,\u00C0\u0006\u0003"}, d2 = {"LBa/h;", "", "", "bbsChannelSeq", "", "bbsContentRefValue", "latestCmtSeq", "pocId", "cmtPocType", "Lcom/melon/net/ApiResult;", "Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes;", "d", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sortType", "srchType", "srchWord", "pageNo", "pageSize", "", "cmtListFlag", "pageGroupSize", "filterType", "Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "a", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "totalCnt", "validCnt", "startSeq", "mypageMemberKey", "Lcom/iloen/melon/net/v3x/comments/ListCmtRes;", "b", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "channelSeq", "contsRefValue", "commentSeq", "isNotRecommend", "Lcom/iloen/melon/net/v3x/comments/InsertRecmRes;", "f", "(ILjava/lang/String;IZLjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/net/v3x/comments/CancelRecmRes;", "c", "Lcom/iloen/melon/net/v3x/comments/DeleteCmtRes;", "e", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface h {
    @Nullable
    @f("/cmt/api/api_loadPgn.json")
    Object a(@t("chnlSeq") int arg1, @NotNull @t("contsRefValue") String arg2, @Nullable @t("sortType") Integer arg3, @Nullable @t("srchType") Integer arg4, @Nullable @t("srchWord") String arg5, @Nullable @t("pageNo") Integer arg6, @Nullable @t("pageSize") Integer arg7, @t("cmtListFlag") boolean arg8, @Nullable @t("pageGroupSize") Integer arg9, @t("filterType") int arg10, @NotNull @t("pocId") String arg11, @NotNull @t("cmtPocType") String arg12, @NotNull Continuation arg13);

    @Nullable
    @f("/cmt/api/api_listCmt.json")
    Object b(@t("chnlSeq") int arg1, @NotNull @t("contsRefValue") String arg2, @Nullable @t("totalCnt") Integer arg3, @Nullable @t("validCnt") Integer arg4, @Nullable @t("startSeq") Integer arg5, @Nullable @t("sortType") Integer arg6, @Nullable @t("srchType") Integer arg7, @Nullable @t("srchWord") String arg8, @Nullable @t("pageNo") Integer arg9, @Nullable @t("pageSize") Integer arg10, @Nullable @t("mypageMemberKey") Integer arg11, @Nullable @t("pageGroupSize") Integer arg12, @t("filterType") int arg13, @NotNull @t("pocId") String arg14, @NotNull @t("cmtPocType") String arg15, @NotNull Continuation arg16);

    @Nullable
    @e
    @o("/cmt/api/api_cancelRecm.json")
    Object c(@c("chnlSeq") int arg1, @Nullable @c("contsRefValue") String arg2, @c("cmtSeq") int arg3, @c("nonRecmFlag") boolean arg4, @NotNull @c("pocId") String arg5, @NotNull @c("cmtPocType") String arg6, @NotNull Continuation arg7);

    @Nullable
    @f("/cmt/api/api_informCmtContsSumm.json")
    Object d(@t("chnlSeq") int arg1, @NotNull @t("contsRefValue") String arg2, @Nullable @t("latestCmtSeq") Integer arg3, @NotNull @t("pocId") String arg4, @NotNull @t("cmtPocType") String arg5, @NotNull Continuation arg6);

    @Nullable
    @e
    @o("/cmt/api/api_deleteCmt.json")
    Object e(@c("chnlSeq") int arg1, @Nullable @c("contsRefValue") String arg2, @c("cmtSeq") int arg3, @NotNull @c("pocId") String arg4, @NotNull @c("cmtPocType") String arg5, @NotNull Continuation arg6);

    @Nullable
    @e
    @o("/cmt/api/v2/api_insertRecm.json")
    Object f(@c("chnlSeq") int arg1, @Nullable @c("contsRefValue") String arg2, @c("cmtSeq") int arg3, @c("nonRecmFlag") boolean arg4, @NotNull @c("pocId") String arg5, @NotNull @c("cmtPocType") String arg6, @NotNull Continuation arg7);
}

