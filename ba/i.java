package Ba;

import com.melon.net.Api;
import com.melon.net.ApiType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.c;
import vg.e;
import vg.f;
import vg.o;
import vg.t;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0001\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0004\u001A\u00020\u0002H§@¢\u0006\u0004\b\u0007\u0010\bJ6\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u00052\b\b\u0001\u0010\t\u001A\u00020\u00022\b\b\u0001\u0010\n\u001A\u00020\u00022\n\b\u0003\u0010\u000B\u001A\u0004\u0018\u00010\u0002H§@¢\u0006\u0004\b\r\u0010\u000E¨\u0006\u000FÀ\u0006\u0003"}, d2 = {"LBa/i;", "", "", "contsId", "contsTypeCode", "Lcom/melon/net/ApiResult;", "Lcom/iloen/melon/net/v4x/response/ContentsInfoPostImgRes;", "a", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "contsType", "contsIds", "memberKey", "Lcom/iloen/melon/net/v4x/response/ContentsInfoListRes;", "b", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface i {
    @Api(type = ApiType.V4, useAppVersion = false)
    @Nullable
    @f("/contents/infoPostImg.json")
    Object a(@NotNull @t("contsId") String arg1, @NotNull @t("contsTypeCode") String arg2, @NotNull Continuation arg3);

    @Api(type = ApiType.V4, useAppVersion = true)
    @Nullable
    @e
    @o("/contents/infoList.json")
    Object b(@NotNull @c("contsType") String arg1, @NotNull @c("contsIds") String arg2, @Nullable @c("memberKey") String arg3, @NotNull Continuation arg4);
}

