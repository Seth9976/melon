package Ba;

import com.melon.net.Api;
import com.melon.net.ApiType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.MultipartBody.Part;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.f;
import vg.l;
import vg.o;
import vg.q;
import vg.t;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001C\u0010\u0005\u001A\u00020\u00042\n\b\u0003\u0010\u0003\u001A\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u001C\u0010\u0007\u001A\u00020\u00042\n\b\u0003\u0010\u0003\u001A\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\u0007\u0010\u0006J,\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0001\u0010\b\u001A\u00020\u00022\n\b\u0003\u0010\u0003\u001A\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\u000B\u0010\fJ\"\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\t2\n\b\u0003\u0010\u0003\u001A\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\u000E\u0010\u0006J,\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000F0\t2\b\b\u0001\u0010\b\u001A\u00020\u00022\n\b\u0003\u0010\u0003\u001A\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\u0010\u0010\fJN\u0010\u0018\u001A\u00020\u00172\b\b\u0001\u0010\u0012\u001A\u00020\u00112\b\b\u0001\u0010\u0013\u001A\u00020\u00022\b\b\u0001\u0010\u0014\u001A\u00020\u00022\b\b\u0001\u0010\u0015\u001A\u00020\u00022\b\b\u0001\u0010\u0016\u001A\u00020\u00022\n\b\u0003\u0010\u0003\u001A\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001AÀ\u0006\u0003"}, d2 = {"LBa/z;", "", "", "memberKey", "Lcom/iloen/melon/net/v6x/response/MusicDnaMonthListRes;", "c", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "f", "month", "Lcom/melon/net/ApiResult;", "Lcom/melon/net/res/MusicDnaMonthlyLogRes;", "b", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/melon/net/res/MusicDnaMainRes;", "a", "Lcom/melon/net/res/MusicDnaMainMonthlyLogRes;", "e", "Lokhttp3/MultipartBody$Part;", "file", "type", "contentsTitle", "contentsName", "logMonth", "Lcom/iloen/melon/net/v6x/response/MusicDnaUploadRes;", "d", "(Lokhttp3/MultipartBody$Part;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface z {
    @Api(type = ApiType.V6)
    @Nullable
    @f("/mymusic/musicdna/main.json")
    Object a(@Nullable @t("memberKey") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V6, useAppVersion = true)
    @Nullable
    @f("/mymusic/musicdna/monthly_log.json")
    Object b(@NotNull @t("month") String arg1, @Nullable @t("memberKey") String arg2, @NotNull Continuation arg3);

    @Api(type = ApiType.V6)
    @Nullable
    @f("/mymusic/musicdna/past/month_list.json")
    Object c(@Nullable @t("memberKey") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V6, useAppVersion = true)
    @Nullable
    @l
    @o("/mymusic/musicdna/upload.json")
    Object d(@NotNull @q Part arg1, @NotNull @t("type") String arg2, @NotNull @t("contentsTitle") String arg3, @NotNull @t("contentsName") String arg4, @NotNull @t("logMonth") String arg5, @Nullable @t("memberKey") String arg6, @NotNull Continuation arg7);

    @Api(type = ApiType.V6)
    @Nullable
    @f("/mymusic/musicdna/main/monthly_log.json")
    Object e(@NotNull @t("month") String arg1, @Nullable @t("memberKey") String arg2, @NotNull Continuation arg3);

    @Api(type = ApiType.V6)
    @Nullable
    @f("/mymusic/musicdna/2023/month_list.json")
    Object f(@Nullable @t("memberKey") String arg1, @NotNull Continuation arg2);
}

