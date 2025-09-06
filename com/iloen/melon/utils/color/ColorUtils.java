package com.iloen.melon.utils.color;

import A8.i;
import H0.b;
import P1.c;
import Tf.v;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import java.util.Arrays;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ye.a;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001J#\u0010\u0006\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\u0006\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\bH\u0007¢\u0006\u0004\b\u0006\u0010\nJ/\u0010\u0006\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u00042\n\b\u0001\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0007¢\u0006\u0004\b\u0006\u0010\rJ7\u0010\u0006\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u00042\n\b\u0001\u0010\f\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\t\u001A\u00020\bH\u0007¢\u0006\u0004\b\u0006\u0010\u000EJ\u0019\u0010\u0011\u001A\u00020\u00042\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0011\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\b\b\u0001\u0010\u0013\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0014J#\u0010\u0016\u001A\u0004\u0018\u00010\u00152\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001A\u00020\u00182\b\b\u0001\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001B\u001A\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001B\u0010\u001C¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/utils/color/ColorUtils;", "", "Landroid/content/Context;", "context", "", "resId", "getColor", "(Landroid/content/Context;I)I", "", "isHighContrastMode", "(Landroid/content/Context;IZ)I", "", "alpha", "(Landroid/content/Context;ILjava/lang/Float;)I", "(Landroid/content/Context;ILjava/lang/Float;Z)I", "", "hexStr", "getColorFromHexStr", "(Ljava/lang/String;)I", "defaultColorResId", "(Landroid/content/Context;Ljava/lang/String;I)I", "Landroid/content/res/ColorStateList;", "getColorStateList", "(Landroid/content/Context;I)Landroid/content/res/ColorStateList;", "Lie/H;", "isHighContrastColorDefinition", "(I)V", "DEFAULT_COLOR_TRANSPARENT", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ColorUtils {
    public static final int $stable;
    public static final int DEFAULT_COLOR_TRANSPARENT;
    @NotNull
    public static final ColorUtils INSTANCE;

    static {
        ColorUtils.INSTANCE = new ColorUtils();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static Integer a(int v) {
        switch(v) {
            case 0x7F060046: {  // color:blue400s_support_high_contrast
                return i.r;
            }
            case 0x7F060140: {  // color:gray001e_support_high_contrast
                return i.m;
            }
            case 0x7F06014B: {  // color:gray100s_support_high_contrast
                return i.i;
            }
            case 0x7F060154: {  // color:gray200s_support_high_contrast
                return i.h;
            }
            case 0x7F060159: {  // color:gray400s_support_high_contrast
                return i.g;
            }
            case 0x7F06015D: {  // color:gray500s_support_high_contrast
                return i.f;
            }
            case 0x7F060160: {  // color:gray600s_support_high_contrast
                return i.e;
            }
            case 0x7F06016F: {  // color:gray920e_10_support_high_contrast
                return i.l;
            }
            case 0x7F060170: {  // color:gray920e_support_high_contrast
                return i.k;
            }
            case 0x7F06017A: {  // color:green500e_support_high_contrast
                return i.a;
            }
            case 0x7F06017C: {  // color:green500s_support_high_contrast
                return i.b;
            }
            case 0x7F06017E: {  // color:green502e_support_high_contrast
                return i.d;
            }
            case 0x7F06017F: {  // color:green502s_support_high_contrast
                return i.c;
            }
            case 0x7F0604AA: {  // color:white000s_support_high_contrast
                return i.j;
            }
            case 0x7F0604AF: {  // color:white160e_support_high_contrast
                return i.q;
            }
            case 0x7F0604B2: {  // color:white300e_support_high_contrast
                return i.p;
            }
            case 0x7F0604B3: {  // color:white400e_support_high_contrast
                return i.o;
            }
            case 0x7F0604B4: {  // color:white500e_support_high_contrast
                return i.n;
            }
            default: {
                return null;
            }
        }
    }

    public static final int getColor(@Nullable Context context0, int v) {
        return ColorUtils.getColor(context0, v, null, ScreenUtils.INSTANCE.isHighContrastMode());
    }

    public static final int getColor(@Nullable Context context0, int v, @Nullable Float float0) {
        return ColorUtils.getColor(context0, v, float0, ScreenUtils.INSTANCE.isHighContrastMode());
    }

    public static final int getColor(@Nullable Context context0, int v, @Nullable Float float0, boolean z) {
        int v1;
        if(context0 != null && -1 != v) {
            if(z) {
                ColorUtils.INSTANCE.getClass();
                Integer integer0 = ColorUtils.a(v);
                v1 = integer0 == null ? c.getColor(context0, v) : ((int)integer0);
            }
            else {
                v1 = c.getColor(context0, v);
            }
            if(float0 == null) {
                return v1;
            }
            String s = Integer.toHexString(a.V(((float)float0) * 255.0f));
            if(s.length() == 1) {
                s = "0" + s;
            }
            return ColorUtils.getColorFromHexStr(String.format("#%s%06x", Arrays.copyOf(new Object[]{s, ((int)(v1 & 0xFFFFFF))}, 2)));
        }
        LogU.Companion.w("ColorUtils", "getColor() invalid parameter");
        return 0;
    }

    public static final int getColor(@Nullable Context context0, int v, boolean z) {
        return ColorUtils.getColor(context0, v, null, z);
    }

    public static final int getColorFromHexStr(@Nullable Context context0, @Nullable String s, int v) {
        if(s != null && s.length() != 0) {
            try {
                if(!v.r0(s, "#", false)) {
                    s = String.format("#%s", Arrays.copyOf(new Object[]{s}, 1));
                }
                return Color.parseColor(s);
            }
            catch(Exception unused_ex) {
                return 0;
            }
        }
        return v == -1 || context0 == null ? 0 : ColorUtils.getColor(context0, v);
    }

    public static final int getColorFromHexStr(@Nullable String s) {
        return ColorUtils.getColorFromHexStr(null, s, -1);
    }

    @Nullable
    public static final ColorStateList getColorStateList(@Nullable Context context0, int v) {
        Integer integer0;
        if(context0 != null && -1 != v) {
            if(ScreenUtils.INSTANCE.isHighContrastMode()) {
                ColorUtils.INSTANCE.getClass();
                integer0 = ColorUtils.a(v);
            }
            else {
                integer0 = v;
            }
            if(integer0 != null) {
                v = (int)integer0;
            }
            try {
                return c.getColorStateList(context0, v);
            }
            catch(Exception exception0) {
                b.w("getColorStateList() exception: ", exception0.getMessage(), LogU.Companion, "ColorUtils");
                return null;
            }
        }
        LogU.Companion.w("ColorUtils", "getColorStateList() invalid parameter");
        return null;
    }

    public static final void isHighContrastColorDefinition(int v) {
        ColorUtils.INSTANCE.getClass();
        if(ColorUtils.a(v) == null) {
            throw new RuntimeException("ColorUtils.isHighContrastColorDefinition() - colorId: " + v + " is not founded");
        }
    }
}

