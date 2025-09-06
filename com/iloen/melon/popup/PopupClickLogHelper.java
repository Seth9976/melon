package com.iloen.melon.popup;

import android.content.Context;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.playback.Playable;
import com.kakao.tiara.data.ActionKind;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.g;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/popup/PopupClickLogHelper;", "", "<init>", "()V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PopupClickLogHelper {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J-\u0010\t\u001A\u00020\b2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/popup/PopupClickLogHelper$Companion;", "", "Landroid/content/Context;", "context", "", "menuId", "Lcom/iloen/melon/playback/Playable;", "playable", "Lie/H;", "sendMorePopupPlayClickLog", "(Landroid/content/Context;Ljava/lang/String;Lcom/iloen/melon/playback/Playable;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final void sendMorePopupPlayClickLog(@Nullable Context context0, @Nullable String s, @Nullable Playable playable0) {
            if(playable0 != null) {
                String s1 = "더보기";
                PopupClickLogHelper.Companion.getClass();
                g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                String s2 = "";
                if(context0 == null) {
                    s1 = "";
                }
                String s3 = "더보기_곡리스트";
                g0.b = s1;
                if(context0 == null) {
                    s3 = "";
                }
                String s4 = "음악재생";
                g0.c = s3;
                g0.I = s;
                g0.d = ActionKind.PlayMusic;
                if(context0 == null) {
                    s4 = "";
                }
                String s5 = "더보기 팝업";
                g0.a = s4;
                if(context0 == null) {
                    s5 = "";
                }
                String s6 = "이 곡으로 믹스업";
                g0.y = s5;
                if(context0 == null) {
                    s6 = "";
                }
                g0.F = s6;
                g0.o = "";
                if(context0 != null) {
                    s2 = "곡";
                }
                g0.p = s2;
                g0.q = "";
                g0.e = "";
                g0.f = Y.i(ContsTypeCode.SONG_MIXUP, "code(...)");
                g0.g = "";
                g0.W = "1000003099";
                g0.a().track();
            }
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;

    static {
        PopupClickLogHelper.Companion = new Companion(null);
    }

    public static final void sendMorePopupPlayClickLog(@Nullable Context context0, @Nullable String s, @Nullable Playable playable0) {
        PopupClickLogHelper.Companion.sendMorePopupPlayClickLog(context0, s, playable0);
    }
}

