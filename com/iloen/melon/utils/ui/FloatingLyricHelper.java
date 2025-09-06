package com.iloen.melon.utils.ui;

import Ma.m;
import android.content.Context;
import com.google.firebase.b;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.task.MelonServiceManager;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.melon.playback.FloatingLyricService;
import k8.Y;
import k8.o;
import k8.t;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import ob.z;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0014\n\u0002\b\u000F\bÇ\u0002\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\r\u0010\f\u001A\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0011J\u0015\u0010\u0013\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0017\u0010\u001E\u001A\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u001DR\u0017\u0010!\u001A\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001F\u0010\u001B\u001A\u0004\b \u0010\u001DR\u0017\u0010$\u001A\u00020\u00198\u0006¢\u0006\f\n\u0004\b\"\u0010\u001B\u001A\u0004\b#\u0010\u001DR\u0014\u0010%\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010\u0015R\u0014\u0010&\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010\u0015R\u0014\u0010\'\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\'\u0010\u0015¨\u0006("}, d2 = {"Lcom/iloen/melon/utils/ui/FloatingLyricHelper;", "", "Lie/H;", "requestStopFloatingLyric", "()V", "", "percent", "getAlphaValue", "(I)I", "", "requestStartFloatingLyric", "()Z", "getFontIndex", "()I", "index", "", "getFontSize", "(I)F", "getTextviewGap", "getLayoutHeight", "FONT_INDEX_0", "I", "FONT_INDEX_1", "FONT_INDEX_2", "FONT_INDEX_3", "", "a", "[F", "getLAYOUT_HEIGHTS", "()[F", "LAYOUT_HEIGHTS", "b", "getFONT_SIZES", "FONT_SIZES", "c", "getTEXTVIEW_GAPS", "TEXTVIEW_GAPS", "DEFAULT_TRANSPARENCY_VALUE", "SKINTYPE_BLACK", "SKINTYPE_WHITE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class FloatingLyricHelper {
    public static final int $stable = 0;
    public static final int DEFAULT_TRANSPARENCY_VALUE = 30;
    public static final int FONT_INDEX_0 = 0;
    public static final int FONT_INDEX_1 = 1;
    public static final int FONT_INDEX_2 = 2;
    public static final int FONT_INDEX_3 = 3;
    @NotNull
    public static final FloatingLyricHelper INSTANCE = null;
    public static final int SKINTYPE_BLACK = 0;
    public static final int SKINTYPE_WHITE = 1;
    public static final float[] a;
    public static final float[] b;
    public static final float[] c;

    static {
        FloatingLyricHelper.INSTANCE = new FloatingLyricHelper();  // 初始化器: Ljava/lang/Object;-><init>()V
        FloatingLyricHelper.a = new float[]{97.0f, 100.0f, 101.0f, 108.0f};
        FloatingLyricHelper.b = new float[]{13.0f, 14.0f, 15.0f, 17.0f};
        FloatingLyricHelper.c = new float[]{4.0f, 4.5f, 4.0f, 5.0f};
        FloatingLyricHelper.$stable = 8;
    }

    public final int getAlphaValue(int v) {
        if(v > 100) {
            return 0;
        }
        return v >= 0 ? 0xFF - ((int)(((double)(v * 0xFF)) / 100.0)) : 0xFF;
    }

    @NotNull
    public final float[] getFONT_SIZES() {
        return FloatingLyricHelper.b;
    }

    public final int getFontIndex() {
        int v;
        if(MelonPrefs.getInstance().contains("FloatingLyricFontSize")) {
            float f = MelonSettingInfo.getLaboratoryFloatingLyricFontSize();
            if(f == 14.0f) {
                v = 1;
            }
            else {
                switch(f) {
                    case 0x41700000: {
                        v = 2;
                        break;
                    }
                    case 0x41880000: {
                        v = 3;
                        break;
                    }
                    default: {
                        v = 0;
                    }
                }
            }
            MelonPrefs.getInstance().removeAndCommit("FloatingLyricFontSize");
            MelonPrefs.getInstance().removeAndCommit("FloatingLyricLayoutHeight");
            MelonPrefs.getInstance().removeAndCommit("FloatingLyricTextViewGap");
            MelonSettingInfo.setLaboratoryFloatingLyricFontIndex(v);
            return v;
        }
        return MelonSettingInfo.getLaboratoryFloatingLyricFontIndex();
    }

    public final float getFontSize(int v) {
        return 4 <= v || v < 0 ? FloatingLyricHelper.b[0] : FloatingLyricHelper.b[v];
    }

    @NotNull
    public final float[] getLAYOUT_HEIGHTS() {
        return FloatingLyricHelper.a;
    }

    public final float getLayoutHeight(int v) {
        return 4 <= v || v < 0 ? FloatingLyricHelper.a[0] : FloatingLyricHelper.a[v];
    }

    @NotNull
    public final float[] getTEXTVIEW_GAPS() {
        return FloatingLyricHelper.c;
    }

    public final float getTextviewGap(int v) {
        return 4 <= v || v < 0 ? FloatingLyricHelper.c[0] : FloatingLyricHelper.c[v];
    }

    public final boolean requestStartFloatingLyric() {
        s2 s20 = (s2)((o)(((m)Y.g(MelonAppBase.Companion, "context", m.class)))).w.get();
        Context context0 = t.a().getContext();
        q.g(context0, "context");
        Context context1 = context0.getApplicationContext();
        q.d(context1);
        z z0 = ((o)(((Ma.o)b.B(context1, Ma.o.class)))).k();
        Playable playable0 = ((d3)s20).f();
        boolean z1 = playable0 != null && (playable0.isTypeOfMv() || playable0.isTypeOfLive());
        if(z0.n() && !z1 && MelonSettingInfo.isUseLaboratoryFloatingLyric() && !t.a().isAppForeground()) {
            LogU.Companion.d("FloatingLyricHelper", "requestStartFloatingLyric : floating lyric will be started");
            Context context2 = t.a().getContext();
            MelonServiceManager.INSTANCE.bind(context2, FloatingLyricService.class);
            return true;
        }
        LogU.Companion.d("FloatingLyricHelper", "requestStartFloatingLyric : floating lyric can not started");
        return false;
    }

    public static final void requestStopFloatingLyric() {
        LogU.Companion.d("FloatingLyricHelper", "requestStopFloatingLyric : floating lyric will be stopped");
        MelonAppBase.Companion.getClass();
        Context context0 = t.a().getContext();
        MelonServiceManager.INSTANCE.unbind(context0, FloatingLyricService.class);
    }
}

