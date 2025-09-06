package com.iloen.melon.player.video;

import androidx.lifecycle.K;
import androidx.lifecycle.L;
import androidx.lifecycle.f0;
import androidx.lifecycle.m0;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.utils.log.LogU;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001F\u0010\u000F\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/player/video/VideoLivePreviewViewModel;", "Landroidx/lifecycle/m0;", "<init>", "()V", "", "newLiveSeq", "Lie/H;", "updateLiveSeqAndFetchSubApis", "(Ljava/lang/String;)V", "Landroidx/lifecycle/K;", "Lcom/iloen/melon/net/v6x/response/PromotionContentsBannerRes$RESPONSE$Banner;", "c", "Landroidx/lifecycle/K;", "getBannerRes", "()Landroidx/lifecycle/K;", "bannerRes", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoLivePreviewViewModel extends m0 {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/player/video/VideoLivePreviewViewModel$Companion;", "", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public String a;
    public final L b;
    public final L c;
    public final String d;

    static {
        VideoLivePreviewViewModel.Companion = new Companion(null);
        VideoLivePreviewViewModel.$stable = 8;
    }

    public VideoLivePreviewViewModel() {
        new LogU("VideoLivePreviewViewModel");
        L l0 = new L();  // 初始化器: Landroidx/lifecycle/K;-><init>()V
        this.b = l0;
        this.c = l0;
        String s = MelonContentUris.d1.buildUpon().appendQueryParameter("liveSeq", String.valueOf(this.a)).build().toString();
        q.f(s, "toString(...)");
        this.d = s;
    }

    public static final String access$getBannerApiCacheKey$p(VideoLivePreviewViewModel videoLivePreviewViewModel0) {
        return videoLivePreviewViewModel0.d;
    }

    public static final String access$getLiveSeq$p(VideoLivePreviewViewModel videoLivePreviewViewModel0) {
        return videoLivePreviewViewModel0.a;
    }

    public static final L access$get_bannerRes$p(VideoLivePreviewViewModel videoLivePreviewViewModel0) {
        return videoLivePreviewViewModel0.b;
    }

    @NotNull
    public final K getBannerRes() {
        return this.c;
    }

    public final void updateLiveSeqAndFetchSubApis(@Nullable String s) {
        this.a = s;
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new VideoLivePreviewViewModel.fetchBannerAsync.1(this, null), 3, null);
    }
}

