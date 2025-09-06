package com.iloen.melon.utils.system;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources;
import android.graphics.Insets;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.lifecycle.b;
import c2.C0;
import c2.D0;
import c2.E0;
import c2.h0;
import com.google.android.material.internal.F;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.MelonThemeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u00C7\u0002\u0018\u00002\u00020\u0001J!\u0010\u0007\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u0007\u0010\bJ!\u0010\n\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\t\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0019\u0010\f\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000E\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\b\u000E\u0010\rJ\u0019\u0010\u0010\u001A\u00020\u000F2\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001A\u00020\u000F2\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\b\u0012\u0010\u0011J\u0019\u0010\u0013\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\b\u0013\u0010\rJ\u0019\u0010\u0015\u001A\u00020\u00142\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001A\u00020\u00142\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\b\u0017\u0010\u0016J\u0019\u0010\u0018\u001A\u00020\u00142\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\b\u0018\u0010\u0016J\u0019\u0010\u0019\u001A\u00020\u00142\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\b\u0019\u0010\u0016J\u0019\u0010\u001B\u001A\u00020\u001A2\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0019\u0010\u001D\u001A\u00020\u00142\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0007\u00A2\u0006\u0004\b\u001D\u0010\u0016J!\u0010\"\u001A\u00020!2\b\u0010\u001F\u001A\u0004\u0018\u00010\u001E2\u0006\u0010 \u001A\u00020\u0014H\u0007\u00A2\u0006\u0004\b\"\u0010#J\u001F\u0010%\u001A\u00020!2\u0006\u0010\u001F\u001A\u00020\u001E2\u0006\u0010$\u001A\u00020\u0014H\u0007\u00A2\u0006\u0004\b%\u0010#J\u0017\u0010&\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b&\u0010\rJ\u0017\u0010\'\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\'\u0010\rJ\r\u0010(\u001A\u00020\u0014\u00A2\u0006\u0004\b(\u0010)J\u001F\u0010*\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001A\u00020\u0014\u00A2\u0006\u0004\b*\u0010+\u00A8\u0006,"}, d2 = {"Lcom/iloen/melon/utils/system/ScreenUtils;", "", "Landroid/content/Context;", "context", "", "dip", "", "dipToPixel", "(Landroid/content/Context;F)I", "pixel", "pixelToDip", "(Landroid/content/Context;I)I", "getScreenWidth", "(Landroid/content/Context;)I", "getScreenHeight", "Landroid/graphics/Point;", "getRealScreenSize", "(Landroid/content/Context;)Landroid/graphics/Point;", "getScreenSize", "getStatusBarHeight", "", "isOrientationPortrait", "(Landroid/content/Context;)Z", "isPortrait", "isLandscape", "isTablet", "", "getResolution", "(Landroid/content/Context;)Ljava/lang/String;", "isDarkMode", "Landroid/view/Window;", "window", "isLightStatusBar", "Lie/H;", "setAppearanceLightStatusBars", "(Landroid/view/Window;Z)V", "isLight", "setAppearanceLightNavigationBars", "getNavigationBarHeight", "getArtistShortCutIconDpi", "isHighContrastMode", "()Z", "getHeightExcludeStatusBar", "(Landroid/content/Context;Z)I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ScreenUtils {
    public static final int $stable;
    @NotNull
    public static final ScreenUtils INSTANCE;

    static {
        ScreenUtils.INSTANCE = new ScreenUtils();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static final int dipToPixel(@Nullable Context context0, float f) {
        if(context0 == null) {
            LogU.Companion.w("ScreenUtils", "dipToPixel() invalid context");
            return 0;
        }
        int v = (int)(context0.getResources().getDisplayMetrics().density * f);
        return f > 0.0f ? Math.max(v, 1) : v;
    }

    public final int getArtistShortCutIconDpi(@Nullable Context context0) {
        if(context0 == null) {
            LogU.Companion.w("ScreenUtils", "getArtistShortCutIconDpi() invalid context");
            return 0;
        }
        float f = context0.getResources().getDisplayMetrics().density;
        LogU.Companion.d("ScreenUtils", "ScreenUtils getArtistShortCutIconDpi() >> density: " + f);
        if(((double)f) <= 0.75) {
            return 36;
        }
        if(((double)f) <= 1.0) {
            return 0x30;
        }
        if(((double)f) <= 1.5) {
            return 72;
        }
        if(((double)f) <= 2.0) {
            return 0x60;
        }
        return ((double)f) <= 3.0 ? 0x90 : 0xC0;
    }

    public final int getHeightExcludeStatusBar(@Nullable Context context0, boolean z) {
        int v = 0;
        if(context0 == null) {
            return 0;
        }
        Resources resources0 = context0.getResources();
        q.f(resources0, "getResources(...)");
        int v1 = resources0.getIdentifier("status_bar_height", "dimen", "android");
        if(v1 > 0) {
            v = resources0.getDimensionPixelSize(v1);
        }
        DisplayMetrics displayMetrics0 = Resources.getSystem().getDisplayMetrics();
        return z ? ((int)(((float)displayMetrics0.heightPixels) / displayMetrics0.density - ((float)v) / displayMetrics0.density)) : ((int)(((float)displayMetrics0.widthPixels) / displayMetrics0.density - ((float)v) / displayMetrics0.density));
    }

    public final int getNavigationBarHeight(@Nullable Context context0) {
        if(context0 == null) {
            LogU.Companion.w("ScreenUtils", "getNavigationBarHeight() invalid context");
            return 0;
        }
        int v = context0.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        return v <= 0 ? 0 : context0.getResources().getDimensionPixelSize(v);
    }

    @NotNull
    public static final Point getRealScreenSize(@Nullable Context context0) {
        if(context0 == null) {
            LogU.Companion.w("ScreenUtils", "getRealScreenWidth() invalid context");
            return new Point(0, 0);
        }
        Point point0 = new Point();
        Object object0 = context0.getSystemService("window");
        q.e(object0, "null cannot be cast to non-null type android.view.WindowManager");
        if(Build.VERSION.SDK_INT >= 30) {
            WindowMetrics windowMetrics0 = ((WindowManager)object0).getCurrentWindowMetrics();
            q.f(windowMetrics0, "getCurrentWindowMetrics(...)");
            Rect rect0 = windowMetrics0.getBounds();
            q.f(rect0, "getBounds(...)");
            point0.set(rect0.width(), rect0.height());
            return point0;
        }
        ((WindowManager)object0).getDefaultDisplay().getRealSize(point0);
        return point0;
    }

    @NotNull
    public static final String getResolution(@Nullable Context context0) {
        if(context0 == null) {
            LogU.Companion.w("ScreenUtils", "getResolution() invalid context");
            return "";
        }
        Resources resources0 = context0.getResources();
        return resources0 == null ? "" : String.valueOf(((int)(((float)Math.rint(resources0.getDisplayMetrics().density)))));
    }

    public static final int getScreenHeight(@Nullable Context context0) {
        if(context0 == null) {
            LogU.Companion.w("ScreenUtils", "getScreenHeight() invalid context");
            return 0;
        }
        Object object0 = context0.getSystemService("window");
        WindowManager windowManager0 = object0 instanceof WindowManager ? ((WindowManager)object0) : null;
        if(windowManager0 == null) {
            LogU.Companion.w("ScreenUtils", "getScreenHeight() failed to get WindowManager");
            return 0;
        }
        if(Build.VERSION.SDK_INT >= 30) {
            WindowMetrics windowMetrics0 = windowManager0.getCurrentWindowMetrics();
            q.f(windowMetrics0, "getCurrentWindowMetrics(...)");
            Insets insets0 = windowMetrics0.getWindowInsets().getInsetsIgnoringVisibility(F.a() | h0.D());
            q.f(insets0, "getInsetsIgnoringVisibility(...)");
            Rect rect0 = windowMetrics0.getBounds();
            q.f(rect0, "getBounds(...)");
            return rect0.height() - insets0.top - insets0.bottom;
        }
        return context0.getResources().getDisplayMetrics().heightPixels;
    }

    @NotNull
    public static final Point getScreenSize(@Nullable Context context0) {
        if(context0 == null) {
            LogU.Companion.w("ScreenUtils", "getScreenSize() invalid context");
            return new Point(0, 0);
        }
        Point point0 = new Point();
        Object object0 = context0.getSystemService("window");
        q.e(object0, "null cannot be cast to non-null type android.view.WindowManager");
        if(Build.VERSION.SDK_INT >= 30) {
            WindowMetrics windowMetrics0 = ((WindowManager)object0).getCurrentWindowMetrics();
            q.f(windowMetrics0, "getCurrentWindowMetrics(...)");
            WindowInsets windowInsets0 = windowMetrics0.getWindowInsets();
            q.f(windowInsets0, "getWindowInsets(...)");
            Insets insets0 = windowInsets0.getInsetsIgnoringVisibility(h0.s() | h0.D());
            q.f(insets0, "getInsetsIgnoringVisibility(...)");
            Rect rect0 = windowMetrics0.getBounds();
            q.f(rect0, "getBounds(...)");
            point0.set(rect0.width() - (insets0.left + insets0.right), rect0.height() - (insets0.bottom + insets0.top));
            return point0;
        }
        ((WindowManager)object0).getDefaultDisplay().getSize(point0);
        return point0;
    }

    public static final int getScreenWidth(@Nullable Context context0) {
        if(context0 == null) {
            LogU.Companion.w("ScreenUtils", "getScreenWidth() invalid context");
            return 0;
        }
        Object object0 = context0.getSystemService("window");
        WindowManager windowManager0 = object0 instanceof WindowManager ? ((WindowManager)object0) : null;
        if(windowManager0 == null) {
            LogU.Companion.w("ScreenUtils", "getScreenWidth() failed to get WindowManager");
            return 0;
        }
        if(Build.VERSION.SDK_INT >= 30) {
            WindowMetrics windowMetrics0 = windowManager0.getCurrentWindowMetrics();
            q.f(windowMetrics0, "getCurrentWindowMetrics(...)");
            Insets insets0 = windowMetrics0.getWindowInsets().getInsetsIgnoringVisibility(F.a() | h0.D());
            q.f(insets0, "getInsetsIgnoringVisibility(...)");
            Rect rect0 = windowMetrics0.getBounds();
            q.f(rect0, "getBounds(...)");
            return rect0.width() - insets0.left - insets0.right;
        }
        return context0.getResources().getDisplayMetrics().widthPixels;
    }

    public static final int getStatusBarHeight(@Nullable Context context0) {
        if(context0 == null) {
            LogU.Companion.w("ScreenUtils", "getStatusBarHeight() invalid context");
            return 0;
        }
        Resources resources0 = context0.getResources();
        if(resources0 == null) {
            return 0;
        }
        int v = resources0.getIdentifier("status_bar_height", "dimen", "android");
        if(v > 0) {
            try {
                int v1 = context0.getResources().getDimensionPixelSize(v);
                return v1 >= 0 ? v1 : ((int)Math.ceil(25.0 * ((double)resources0.getDisplayMetrics().density)));
            }
            catch(Resources.NotFoundException resources$NotFoundException0) {
                LogU.Companion.e("ScreenUtils", resources$NotFoundException0.toString());
            }
        }
        return (int)Math.ceil(25.0 * ((double)resources0.getDisplayMetrics().density));
    }

    public static final boolean isDarkMode(@Nullable Context context0) {
        if(context0 == null) {
            return false;
        }
        switch(MelonThemeUtils.getCurrentTheme()) {
            case 0: {
                return false;
            }
            case 1: {
                return true;
            }
            default: {
                return (context0.getResources().getConfiguration().uiMode & 0x30) == 0x20;
            }
        }
    }

    public final boolean isHighContrastMode() {
        return MelonSettingInfo.isUseHighContrastMode();
    }

    public static final boolean isLandscape(@Nullable Context context0) {
        return !ScreenUtils.isPortrait(context0);
    }

    public static final boolean isOrientationPortrait(@Nullable Context context0) {
        if(context0 == null) {
            LogU.Companion.d("ScreenUtils", "isOrientationPortrait() invalid context");
            return true;
        }
        return context0.getResources().getConfiguration().orientation == 1;
    }

    public static final boolean isPortrait(@Nullable Context context0) {
        if(context0 == null) {
            LogU.Companion.d("ScreenUtils", "isPortrait() invalid context");
            return true;
        }
        Object object0 = context0.getSystemService("window");
        q.e(object0, "null cannot be cast to non-null type android.view.WindowManager");
        Display display0 = ((WindowManager)object0).getDefaultDisplay();
        if(display0 == null) {
            return true;
        }
        switch(display0.getRotation()) {
            case 0: {
                return true;
            }
            case 1: {
                return false;
            }
            case 2: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static final boolean isTablet(@Nullable Context context0) {
        if(context0 == null) {
            LogU.Companion.d("ScreenUtils", "isTablet() invalid context");
            return false;
        }
        Point point0 = ScreenUtils.getScreenSize(context0);
        DisplayMetrics displayMetrics0 = context0.getResources().getDisplayMetrics();
        return Math.min(((float)point0.x) / displayMetrics0.density, ((float)point0.y) / displayMetrics0.density) > 600.0f;
    }

    public static final int pixelToDip(@Nullable Context context0, int v) {
        if(context0 == null) {
            LogU.Companion.w("ScreenUtils", "pixelToDip() invalid context");
            return 0;
        }
        return (int)(((float)v) / context0.getResources().getDisplayMetrics().density);
    }

    public static final void setAppearanceLightNavigationBars(@NotNull Window window0, boolean z) {
        D0 d00;
        q.g(window0, "window");
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
        d00.P(z);
    }

    public static final void setAppearanceLightStatusBars(@Nullable Window window0, boolean z) {
        D0 d00;
        if(window0 == null) {
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
        d00.Q(z);
    }
}

