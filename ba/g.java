package Ba;

import com.melon.net.Api;
import com.melon.net.ApiType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.c;
import vg.d;
import vg.e;
import vg.f;
import vg.l;
import vg.o;
import vg.q;
import vg.t;
import vg.y;

@Metadata(d1 = {"\u0000\u00B4\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0098\u0001\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0003\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u00042\b\b\u0003\u0010\u0006\u001A\u00020\u00022\b\b\u0003\u0010\u0007\u001A\u00020\u00022\b\b\u0003\u0010\b\u001A\u00020\u00042\b\b\u0003\u0010\t\u001A\u00020\u00022\b\b\u0003\u0010\n\u001A\u00020\u00022\b\b\u0003\u0010\f\u001A\u00020\u000B2\b\b\u0003\u0010\r\u001A\u00020\u00022\b\b\u0003\u0010\u000E\u001A\u00020\u00022\b\b\u0003\u0010\u000F\u001A\u00020\u00022\b\b\u0003\u0010\u0010\u001A\u00020\u00042\b\b\u0003\u0010\u0011\u001A\u00020\u0004H\u00A7@\u00A2\u0006\u0004\b\u0014\u0010\u0015Jp\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00170\u00122\b\b\u0003\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u00042\b\b\u0003\u0010\u0016\u001A\u00020\u00022\b\b\u0003\u0010\u0006\u001A\u00020\u00022\b\b\u0003\u0010\t\u001A\u00020\u00022\b\b\u0003\u0010\n\u001A\u00020\u00022\b\b\u0003\u0010\u000F\u001A\u00020\u00022\b\b\u0003\u0010\u0010\u001A\u00020\u00042\b\b\u0003\u0010\u0011\u001A\u00020\u0004H\u00A7@\u00A2\u0006\u0004\b\u0018\u0010\u0019J\\\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u001B0\u00122\b\b\u0003\u0010\b\u001A\u00020\u00042\b\b\u0003\u0010\t\u001A\u00020\u00022\b\b\u0003\u0010\n\u001A\u00020\u00022\b\b\u0003\u0010\u0006\u001A\u00020\u00022\b\b\u0003\u0010\u001A\u001A\u00020\u00042\b\b\u0003\u0010\u0010\u001A\u00020\u00042\b\b\u0003\u0010\u0011\u001A\u00020\u0004H\u00A7@\u00A2\u0006\u0004\b\u001C\u0010\u001DJH\u0010 \u001A\b\u0012\u0004\u0012\u00020\u001F0\u00122\b\b\u0003\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u00042\b\b\u0003\u0010\u001E\u001A\u00020\u00022\b\b\u0003\u0010\u0010\u001A\u00020\u00042\b\b\u0003\u0010\u0011\u001A\u00020\u0004H\u00A7@\u00A2\u0006\u0004\b \u0010!JR\u0010%\u001A\b\u0012\u0004\u0012\u00020$0\u00122\b\b\u0003\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u00042\b\b\u0003\u0010\"\u001A\u00020\u00022\b\b\u0003\u0010#\u001A\u00020\u000B2\b\b\u0003\u0010\u0010\u001A\u00020\u00042\b\b\u0003\u0010\u0011\u001A\u00020\u0004H\u00A7@\u00A2\u0006\u0004\b%\u0010&J4\u0010)\u001A\b\u0012\u0004\u0012\u00020(0\u00122\b\b\u0001\u0010\'\u001A\u00020\u00042\b\b\u0003\u0010\u0010\u001A\u00020\u00042\b\b\u0003\u0010\u0011\u001A\u00020\u0004H\u00A7@\u00A2\u0006\u0004\b)\u0010*Jj\u00100\u001A\b\u0012\u0004\u0012\u00020/0\u00122\b\b\u0003\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u00042\b\b\u0003\u0010+\u001A\u00020\u000B2\b\b\u0003\u0010,\u001A\u00020\u00042\u0016\b\u0003\u0010.\u001A\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010-2\b\b\u0003\u0010\u0010\u001A\u00020\u00042\b\b\u0003\u0010\u0011\u001A\u00020\u0004H\u00A7@\u00A2\u0006\u0004\b0\u00101Jf\u00105\u001A\b\u0012\u0004\u0012\u0002040\u00122\b\b\u0003\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u00042\b\b\u0003\u00102\u001A\u00020\u00022\b\b\u0001\u00103\u001A\u00020\u00042\b\b\u0003\u0010+\u001A\u00020\u000B2\b\b\u0003\u0010,\u001A\u00020\u00042\b\b\u0003\u0010\u0010\u001A\u00020\u00042\b\b\u0003\u0010\u0011\u001A\u00020\u0004H\u00A7@\u00A2\u0006\u0004\b5\u00106JT\u00109\u001A\b\u0012\u0004\u0012\u0002080\u00122\b\b\u0001\u0010\u0003\u001A\u00020\u00022\n\b\u0001\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\b\u0001\u0010\"\u001A\u00020\u00022\b\b\u0003\u00107\u001A\u00020\u000B2\b\b\u0003\u0010\u0010\u001A\u00020\u00042\b\b\u0003\u0010\u0011\u001A\u00020\u0004H\u00A7@\u00A2\u0006\u0004\b9\u0010&Jj\u0010;\u001A\b\u0012\u0004\u0012\u00020:0\u00122\b\b\u0003\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u00042\b\b\u0003\u0010\"\u001A\u00020\u00022\b\b\u0003\u0010,\u001A\u00020\u00042\u0016\b\u0003\u0010.\u001A\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010-2\b\b\u0003\u0010\u0010\u001A\u00020\u00042\b\b\u0003\u0010\u0011\u001A\u00020\u0004H\u00A7@\u00A2\u0006\u0004\b;\u0010<JH\u0010>\u001A\b\u0012\u0004\u0012\u00020=0\u00122\b\b\u0003\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u00042\b\b\u0003\u0010\"\u001A\u00020\u00022\b\b\u0003\u0010\u0010\u001A\u00020\u00042\b\b\u0003\u0010\u0011\u001A\u00020\u0004H\u00A7@\u00A2\u0006\u0004\b>\u0010!JR\u0010@\u001A\b\u0012\u0004\u0012\u00020?0\u00122\b\b\u0003\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u00042\b\b\u0003\u00102\u001A\u00020\u00022\b\b\u0003\u0010\"\u001A\u00020\u00022\b\b\u0003\u0010\u0010\u001A\u00020\u00042\b\b\u0003\u0010\u0011\u001A\u00020\u0004H\u00A7@\u00A2\u0006\u0004\b@\u0010AJR\u0010C\u001A\b\u0012\u0004\u0012\u00020B0\u00122\b\b\u0003\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u00042\b\b\u0003\u0010\"\u001A\u00020\u00022\b\b\u0003\u00107\u001A\u00020\u000B2\b\b\u0003\u0010\u0010\u001A\u00020\u00042\b\b\u0003\u0010\u0011\u001A\u00020\u0004H\u00A7@\u00A2\u0006\u0004\bC\u0010&J*\u0010G\u001A\b\u0012\u0004\u0012\u00020F0\u00122\b\b\u0001\u0010D\u001A\u00020\u00042\b\b\u0003\u0010E\u001A\u00020\u0004H\u00A7@\u00A2\u0006\u0004\bG\u0010HJR\u0010Q\u001A\b\u0012\u0004\u0012\u00020P0\u00122\b\b\u0001\u0010D\u001A\u00020\u00042\b\b\u0001\u0010J\u001A\u00020I2\b\b\u0001\u0010K\u001A\u00020I2\b\b\u0001\u0010M\u001A\u00020L2\b\b\u0001\u0010N\u001A\u00020I2\b\b\u0001\u0010O\u001A\u00020IH\u00A7@\u00A2\u0006\u0004\bQ\u0010RJR\u0010U\u001A\b\u0012\u0004\u0012\u00020T0\u00122\b\b\u0003\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u00042\b\b\u0003\u0010\"\u001A\u00020\u00022\b\b\u0003\u0010S\u001A\u00020\u000B2\b\b\u0003\u0010\u0010\u001A\u00020\u00042\b\b\u0003\u0010\u0011\u001A\u00020\u0004H\u00A7@\u00A2\u0006\u0004\bU\u0010&\u00A8\u0006V\u00C0\u0006\u0003"}, d2 = {"LBa/g;", "", "", "chnlSeq", "", "contsRefValue", "sortType", "srchType", "srchWord", "pageNo", "pageSize", "", "cmtListFlag", "myPageMemberKey", "pageGroupSize", "filterType", "pocId", "cmtPocType", "Lcom/melon/net/ApiResult;", "Lcom/melon/net/res/v3/LoadPgnRes;", "j", "(ILjava/lang/String;IILjava/lang/String;IIZIIILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startSeq", "Lcom/melon/net/res/v3/ListCmtRes;", "i", "(ILjava/lang/String;IIIIILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "musicType", "Lcom/melon/net/res/v3/ListMusicRes;", "a", "(Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "latestCmtSeq", "Lcom/melon/net/res/v3/InformCmtContsSummRes;", "m", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cmtSeq", "adcmtListFlag", "Lcom/melon/net/res/v3/InformCmtRes;", "k", "(ILjava/lang/String;IZLjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "youtubeUrl", "Lcom/melon/net/res/v3/InformOembedRes;", "d", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "secrtFlag", "stickerSeq", "", "attachMap", "Lcom/melon/net/res/v3/InsertCmtRes;", "h", "(ILjava/lang/String;ZLjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parntCmtSeq", "cmtCont", "Lcom/melon/net/res/v3/InsertAdcmtRes;", "o", "(ILjava/lang/String;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nonRecmFlag", "Lcom/melon/net/res/v3/InsertRecmRes;", "c", "Lcom/melon/net/res/v3/UpdateCmtRes;", "g", "(ILjava/lang/String;ILjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/melon/net/res/v3/DeleteCmtRes;", "e", "Lcom/melon/net/res/v3/DeleteAdcmtRes;", "b", "(ILjava/lang/String;IILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/melon/net/res/v3/CancelRecmRes;", "l", "url", "vod", "Lcom/melon/net/res/v3/AuthHsJsonRes;", "p", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lokhttp3/RequestBody;", "filePath", "overWrite", "Lokhttp3/MultipartBody$Part;", "file", "fileName", "auth", "Lcom/melon/net/res/v3/HsUploadJsonRes;", "f", "(Ljava/lang/String;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/MultipartBody$Part;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unpinnedFlag", "Lcom/melon/net/res/v3/PinnedRes;", "n", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface g {
    @Nullable
    @f("/cmt/api/api_listMusic.json")
    Object a(@NotNull @t("srchWord") String arg1, @t("pageNo") int arg2, @t("pageSize") int arg3, @t("sortType") int arg4, @NotNull @t("musicType") String arg5, @NotNull @t("pocId") String arg6, @NotNull @t("cmtPocType") String arg7, @NotNull Continuation arg8);

    @Nullable
    @e
    @o("/cmt/api/api_deleteAdcmt.json")
    Object b(@c("chnlSeq") int arg1, @NotNull @c("contsRefValue") String arg2, @c("parntCmtSeq") int arg3, @c("cmtSeq") int arg4, @NotNull @c("pocId") String arg5, @NotNull @c("cmtPocType") String arg6, @NotNull Continuation arg7);

    @Nullable
    @e
    @o("/cmt/api/v2/api_insertRecm.json")
    Object c(@c("chnlSeq") int arg1, @Nullable @c("contsRefValue") String arg2, @c("cmtSeq") int arg3, @c("nonRecmFlag") boolean arg4, @NotNull @c("pocId") String arg5, @NotNull @c("cmtPocType") String arg6, @NotNull Continuation arg7);

    @Nullable
    @f("/cmt/api/api_informOembed.json")
    Object d(@NotNull @t("youtubeUrl") String arg1, @NotNull @t("pocId") String arg2, @NotNull @t("cmtPocType") String arg3, @NotNull Continuation arg4);

    @Nullable
    @e
    @o("/cmt/api/api_deleteCmt.json")
    Object e(@c("chnlSeq") int arg1, @NotNull @c("contsRefValue") String arg2, @c("cmtSeq") int arg3, @NotNull @c("pocId") String arg4, @NotNull @c("cmtPocType") String arg5, @NotNull Continuation arg6);

    @Api(type = ApiType.EMPTY)
    @Nullable
    @l
    @o
    Object f(@NotNull @y String arg1, @NotNull @q("filePath") RequestBody arg2, @NotNull @q("overWrite") RequestBody arg3, @NotNull @q Part arg4, @NotNull @q("fileName") RequestBody arg5, @NotNull @q("auth") RequestBody arg6, @NotNull Continuation arg7);

    @Nullable
    @e
    @o("/cmt/api/api_updateCmt.json")
    Object g(@c("chnlSeq") int arg1, @NotNull @c("contsRefValue") String arg2, @c("cmtSeq") int arg3, @NotNull @c("stickerSeq") String arg4, @Nullable @d Map arg5, @NotNull @c("pocId") String arg6, @NotNull @c("cmtPocType") String arg7, @NotNull Continuation arg8);

    @Nullable
    @e
    @o("/cmt/api/api_insertCmt.json")
    Object h(@c("chnlSeq") int arg1, @NotNull @c("contsRefValue") String arg2, @c("secrtFlag") boolean arg3, @NotNull @c("stickerSeq") String arg4, @Nullable @d Map arg5, @NotNull @c("pocId") String arg6, @NotNull @c("cmtPocType") String arg7, @NotNull Continuation arg8);

    @Nullable
    @f("/cmt/api/api_listCmt.json")
    Object i(@t("chnlSeq") int arg1, @NotNull @t("contsRefValue") String arg2, @t("startSeq") int arg3, @t("sortType") int arg4, @t("pageNo") int arg5, @t("pageSize") int arg6, @t("filterType") int arg7, @NotNull @t("pocId") String arg8, @NotNull @t("cmtPocType") String arg9, @NotNull Continuation arg10);

    @Nullable
    @f("/cmt/api/api_loadPgn.json")
    Object j(@t("chnlSeq") int arg1, @NotNull @t("contsRefValue") String arg2, @t("sortType") int arg3, @t("srchType") int arg4, @NotNull @t("srchWord") String arg5, @t("pageNo") int arg6, @t("pageSize") int arg7, @t("cmtListFlag") boolean arg8, @t("mypageMemberKey") int arg9, @t("pageGroupSize") int arg10, @t("filterType") int arg11, @NotNull @t("pocId") String arg12, @NotNull @t("cmtPocType") String arg13, @NotNull Continuation arg14);

    @Nullable
    @f("/cmt/api/api_informCmt.json")
    Object k(@t("chnlSeq") int arg1, @NotNull @t("contsRefValue") String arg2, @t("cmtSeq") int arg3, @t("adcmtListFlag") boolean arg4, @NotNull @t("pocId") String arg5, @NotNull @t("cmtPocType") String arg6, @NotNull Continuation arg7);

    @Nullable
    @e
    @o("/cmt/api/api_cancelRecm.json")
    Object l(@c("chnlSeq") int arg1, @NotNull @c("contsRefValue") String arg2, @c("cmtSeq") int arg3, @c("nonRecmFlag") boolean arg4, @NotNull @c("pocId") String arg5, @NotNull @c("cmtPocType") String arg6, @NotNull Continuation arg7);

    @Nullable
    @f("/cmt/api/api_informCmtContsSumm.json")
    Object m(@t("chnlSeq") int arg1, @NotNull @t("contsRefValue") String arg2, @t("latestCmtSeq") int arg3, @NotNull @t("pocId") String arg4, @NotNull @t("cmtPocType") String arg5, @NotNull Continuation arg6);

    @Nullable
    @e
    @o("/cmt/api/api_pinned.json")
    Object n(@c("chnlSeq") int arg1, @NotNull @c("contsRefValue") String arg2, @c("cmtSeq") int arg3, @c("unpinnedFlag") boolean arg4, @NotNull @c("pocId") String arg5, @NotNull @c("cmtPocType") String arg6, @NotNull Continuation arg7);

    @Nullable
    @e
    @o("/cmt/api/api_insertAdcmt.json")
    Object o(@c("chnlSeq") int arg1, @NotNull @c("contsRefValue") String arg2, @c("parntCmtSeq") int arg3, @NotNull @c("cmtCont") String arg4, @c("secrtFlag") boolean arg5, @NotNull @c("stickerSeq") String arg6, @NotNull @c("pocId") String arg7, @NotNull @c("cmtPocType") String arg8, @NotNull Continuation arg9);

    @Api(type = ApiType.EMPTY)
    @Nullable
    @e
    @o
    Object p(@NotNull @y String arg1, @NotNull @c("VOD") String arg2, @NotNull Continuation arg3);
}

