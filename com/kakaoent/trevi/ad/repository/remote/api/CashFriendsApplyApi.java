package com.kakaoent.trevi.ad.repository.remote.api;

import com.google.gson.t;
import com.kakaoent.trevi.ad.constants.TreviAdUrl;
import com.kakaoent.trevi.ad.constants.TreviAdUrlType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.a;
import vg.k;
import vg.o;

@TreviAdUrl(type = TreviAdUrlType.CASH_FRIENDS_APPLY_SERVER)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u001A\u0010\u0005\u001A\u00020\u00042\b\b\u0001\u0010\u0003\u001A\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u001A\u0010\n\u001A\u00020\t2\b\b\u0001\u0010\b\u001A\u00020\u0007H§@¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/kakaoent/trevi/ad/repository/remote/api/CashFriendsApplyApi;", "", "Lcom/google/gson/t;", "jsonObject", "Lcom/kakaoent/trevi/ad/domain/CashFriendsApplyApiData;", "notifyInstalled", "(Lcom/google/gson/t;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/kakaoent/trevi/ad/repository/remote/api/CpcApply;", "cpcApply", "Lcom/kakaoent/trevi/ad/domain/ApplyCPCDTO;", "applyCPC", "(Lcom/kakaoent/trevi/ad/repository/remote/api/CpcApply;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public interface CashFriendsApplyApi {
    @Nullable
    @k({"Content-Type: application/json; charset=UTF-8"})
    @o("/apply")
    Object applyCPC(@NotNull @a CpcApply arg1, @NotNull Continuation arg2);

    @Nullable
    @o("/notify/installed")
    Object notifyInstalled(@NotNull @a t arg1, @NotNull Continuation arg2);
}

