package com.kakaoent.trevi.ad.repository.remote.interactor;

import com.kakaoent.trevi.ad.network.ApiModule;
import com.kakaoent.trevi.ad.repository.remote.api.CashFriendsTrackApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0007\u001A\u00020\u00068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/kakaoent/trevi/ad/repository/remote/interactor/TreviBannerAdInteractor;", "", "<init>", "()V", "Lie/H;", "changeApi", "Lcom/kakaoent/trevi/ad/repository/remote/api/CashFriendsTrackApi;", "trackApi", "Lcom/kakaoent/trevi/ad/repository/remote/api/CashFriendsTrackApi;", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class TreviBannerAdInteractor {
    @NotNull
    public static final TreviBannerAdInteractor INSTANCE;
    private static CashFriendsTrackApi trackApi;

    static {
        TreviBannerAdInteractor.INSTANCE = new TreviBannerAdInteractor();
    }

    public final void changeApi() {
        TreviBannerAdInteractor.trackApi = (CashFriendsTrackApi)ApiModule.INSTANCE.getApi(CashFriendsTrackApi.class);
    }
}

