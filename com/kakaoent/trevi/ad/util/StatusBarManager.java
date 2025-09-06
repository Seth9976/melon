package com.kakaoent.trevi.ad.util;

import P1.c;
import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.Window;
import androidx.lifecycle.b;
import c2.C0;
import c2.D0;
import c2.E0;
import com.kakaoent.trevi.ad.R.color;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\t\u0010\bR\"\u0010\u000B\u001A\u00020\n8\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u000B\u0010\f\u001A\u0004\b\u000B\u0010\r\"\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2 = {"Lcom/kakaoent/trevi/ad/util/StatusBarManager;", "", "<init>", "()V", "Landroid/view/Window;", "window", "Lie/H;", "updateStatusBarDarkTheme", "(Landroid/view/Window;)V", "updateStatusBarLightTheme", "", "isStatusBarThemeChangeEnabled", "Z", "()Z", "setStatusBarThemeChangeEnabled", "(Z)V", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class StatusBarManager {
    @NotNull
    public static final StatusBarManager INSTANCE;
    private static boolean isStatusBarThemeChangeEnabled;

    static {
        StatusBarManager.INSTANCE = new StatusBarManager();
        StatusBarManager.isStatusBarThemeChangeEnabled = true;
    }

    @TargetApi(23)
    public final void updateStatusBarDarkTheme(@Nullable Window window0) {
        D0 d00;
        if(window0 == null || !StatusBarManager.isStatusBarThemeChangeEnabled) {
            return;
        }
        b b0 = new b(window0.getDecorView());
        int v = Build.VERSION.SDK_INT;
        if(v >= 35) {
            d00 = new E0(window0, b0);  // 初始化器: Lc2/D0;-><init>(Landroid/view/Window;Landroidx/lifecycle/b;)V
        }
        else if(v >= 30) {
            d00 = new D0(window0, b0);
        }
        else {
            d00 = new C0(window0, b0);
        }
        if(d00.H()) {
            d00.Q(false);
        }
        window0.setStatusBarColor(c.getColor(window0.getContext(), R.color.trevi_dark_mode_background_color));
    }

    @TargetApi(23)
    public final void updateStatusBarLightTheme(@Nullable Window window0) {
        D0 d00;
        if(window0 == null || !StatusBarManager.isStatusBarThemeChangeEnabled) {
            return;
        }
        b b0 = new b(window0.getDecorView());
        int v = Build.VERSION.SDK_INT;
        if(v >= 35) {
            d00 = new E0(window0, b0);  // 初始化器: Lc2/D0;-><init>(Landroid/view/Window;Landroidx/lifecycle/b;)V
        }
        else if(v >= 30) {
            d00 = new D0(window0, b0);
        }
        else {
            d00 = new C0(window0, b0);
        }
        if(!d00.H()) {
            d00.Q(true);
        }
        window0.setStatusBarColor(c.getColor(window0.getContext(), R.color.trevi_light_mode_background_color));
    }
}

