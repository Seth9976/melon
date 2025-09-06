package com.iloen.melon.utils;

import Tf.o;
import Tf.v;
import android.content.Context;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001J!\u0010\u0006\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\tJ\u0019\u0010\r\u001A\u00020\u00042\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0007¢\u0006\u0004\b\r\u0010\u000EJ\u0019\u0010\u000F\u001A\u00020\u00042\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0007¢\u0006\u0004\b\u000F\u0010\u000EJ+\u0010\u0012\u001A\u00020\u000B2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0010\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u0011\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001A\u00020\u00042\b\u0010\u0014\u001A\u0004\u0018\u00010\u000BH\u0007¢\u0006\u0004\b\u0015\u0010\u000EJ\u0019\u0010\u0017\u001A\u00020\u00042\b\u0010\u0016\u001A\u0004\u0018\u00010\u000BH\u0007¢\u0006\u0004\b\u0017\u0010\u000EJ!\u0010\u001A\u001A\u00020\u00042\u0006\u0010\u0019\u001A\u00020\u00182\b\u0010\u0016\u001A\u0004\u0018\u00010\u000BH\u0007¢\u0006\u0004\b\u001A\u0010\u001BJ\u0015\u0010\u001C\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u001C\u0010\tJ\u0015\u0010\u001D\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u001D\u0010\tR\u0014\u0010\u001E\u001A\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001E\u0010\u001F¨\u0006 "}, d2 = {"Lcom/iloen/melon/utils/ResourceUtils;", "", "Landroid/content/Context;", "context", "", "percent", "getFriendlyColorId", "(Landroid/content/Context;I)I", "get4dpDegreeImageResId", "(I)I", "get6dpDegreeImageResId", "", "adultGrade", "getMvAdultGradeIcon", "(Ljava/lang/String;)I", "getMvAdultGradeSmallIcon", "str", "color", "replaceFontColor", "(Landroid/content/Context;Ljava/lang/String;I)Ljava/lang/String;", "memberDjType", "getDjIconResId", "memberDjIconType", "getDjIconColorId", "", "isArtist", "getProfileBadgeColorId", "(ZLjava/lang/String;)I", "get3dpDegreeImageResId", "get8dpDegreeImageResId", "COLOR_GREEN500S", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ResourceUtils {
    public static final int $stable;
    public static final int COLOR_GREEN500S;
    @NotNull
    public static final ResourceUtils INSTANCE;

    static {
        ResourceUtils.INSTANCE = new ResourceUtils();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public final int get3dpDegreeImageResId(int v) {
        if(v >= 90) {
            return 0x7F080863;  // drawable:shape_circle_stroke_0_8dp_red400s_3dp
        }
        if(v >= 80) {
            return 0x7F080862;  // drawable:shape_circle_stroke_0_8dp_purple400s_3dp
        }
        if(v >= 60) {
            return 0x7F080861;  // drawable:shape_circle_stroke_0_8dp_green500e_3dp
        }
        return v < 40 ? 0x7F080860 : 0x7F08085F;  // drawable:shape_circle_stroke_0_8dp_gray450s_3dp
    }

    public static final int get4dpDegreeImageResId(int v) {
        if(v >= 90) {
            return 0x7F08086E;  // drawable:shape_circle_stroke_1dp_red400s_4dp
        }
        if(v >= 80) {
            return 0x7F08086D;  // drawable:shape_circle_stroke_1dp_purple400s_4dp
        }
        if(v >= 60) {
            return 0x7F08086C;  // drawable:shape_circle_stroke_1dp_green500e_4dp
        }
        return v < 40 ? 0x7F08086B : 0x7F08086A;  // drawable:shape_circle_stroke_1dp_gray450s_4dp
    }

    public static final int get6dpDegreeImageResId(int v) {
        if(v >= 90) {
            return 0x7F080868;  // drawable:shape_circle_stroke_1_5dp_red400s_6dp
        }
        if(v >= 80) {
            return 0x7F080867;  // drawable:shape_circle_stroke_1_5dp_purple400s_6dp
        }
        if(v >= 60) {
            return 0x7F080866;  // drawable:shape_circle_stroke_1_5dp_green500e_6dp
        }
        return v < 40 ? 0x7F080865 : 0x7F080864;  // drawable:shape_circle_stroke_1_5dp_gray450s_6dp
    }

    public final int get8dpDegreeImageResId(int v) [...] // 潜在的解密器

    public static final int getDjIconColorId(@Nullable String s) {
        if(s != null) {
            switch(s) {
                case "DJBLUE": {
                    return 0x7F060046;  // color:blue400s_support_high_contrast
                }
                case "DJGREEN": {
                    return 0x7F06017C;  // color:green500s_support_high_contrast
                }
                case "DJORANGE": {
                    return 0x7F060443;  // color:orange500s
                }
                default: {
                    return -1;
                }
            }
        }
        return -1;
    }

    public static final int getDjIconResId(@Nullable String s) {
        if(s != null) {
            switch(s) {
                case "DJ": {
                    return 0x7F0803E7;  // drawable:ic_common_dj_green_20
                }
                case "ESSENTIAL": 
                case "POWER": {
                    return 0x7F0803E8;  // drawable:ic_common_dj_orange_20
                }
                case "LABEL": 
                case "PARTNER": {
                    return 0x7F0803E5;  // drawable:ic_common_dj_blue_20
                }
                default: {
                    return -1;
                }
            }
        }
        return -1;
    }

    public static final int getFriendlyColorId(@Nullable Context context0, int v) {
        if(v >= 90) {
            return ColorUtils.getColor(context0, 0x7F06045C);  // color:red400s
        }
        if(v >= 80) {
            return ColorUtils.getColor(context0, 0x7F060457);  // color:purple400s
        }
        if(v >= 60) {
            return ColorUtils.getColor(context0, 0x7F06017A);  // color:green500e_support_high_contrast
        }
        return v < 40 ? ColorUtils.getColor(context0, 0x7F06015A) : ColorUtils.getColor(context0, 0x7F060047);  // color:gray450s
    }

    // 去混淆评级： 低(20)
    public static final int getMvAdultGradeIcon(@Nullable String s) {
        return "19".equals(s) ? 0x7F0803D4 : -1;  // drawable:ic_common_19_2
    }

    // 去混淆评级： 低(20)
    public static final int getMvAdultGradeSmallIcon(@Nullable String s) {
        return "19".equals(s) ? 0x7F0803D2 : -1;  // drawable:ic_common_19
    }

    // 去混淆评级： 低(20)
    public static final int getProfileBadgeColorId(boolean z, @Nullable String s) {
        return z ? 0x7F060447 : ResourceUtils.getDjIconColorId(s);  // color:pink600s
    }

    @NotNull
    public static final String replaceFontColor(@Nullable Context context0, @Nullable String s, int v) {
        if(s != null && !o.H0(s)) {
            if(v == 0) {
                return ScreenUtils.isDarkMode(context0) ? v.p0(v.p0(s, "<b>", "<font color=\"#00e818\">"), "</b>", "</font>") : v.p0(v.p0(s, "<b>", "<font color=\"#00cd3c\">"), "</b>", "</font>");
            }
            return s;
        }
        return "";
    }
}

