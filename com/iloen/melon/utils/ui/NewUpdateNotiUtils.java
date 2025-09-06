package com.iloen.melon.utils.ui;

import com.iloen.melon.utils.preference.MelonPrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000B\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000B\u0010\fR\u0016\u0010\r\u001A\u00020\u00028\u0006@\u0006X\u0087\u000E¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0016\u0010\u000E\u001A\u00020\u00028\u0006@\u0006X\u0087\u000E¢\u0006\u0006\n\u0004\b\u000E\u0010\fR\u0016\u0010\u000F\u001A\u00020\u00028\u0006@\u0006X\u0087\u000E¢\u0006\u0006\n\u0004\b\u000F\u0010\fR\u0016\u0010\u0010\u001A\u00020\u00028\u0006@\u0006X\u0087\u000E¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0016\u0010\u0011\u001A\u00020\u00028\u0006@\u0006X\u0087\u000E¢\u0006\u0006\n\u0004\b\u0011\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/utils/ui/NewUpdateNotiUtils;", "", "", "areaCode", "", "hasNew", "Lie/H;", "setHasNewUpdate", "(Ljava/lang/String;Z)V", "getHasNewUpdate", "(Ljava/lang/String;)Z", "HAS_PREFERENCE_PREFIX", "Ljava/lang/String;", "AREA_CODE_SIDEMENU_NOTICE", "AREA_CODE_STATION_TAB", "AREA_CODE_SEARCH_TAB", "AREA_CODE_LIBRARY_TAB", "AREA_CODE_MENU_TAB", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class NewUpdateNotiUtils {
    public static final int $stable = 8;
    @NotNull
    public static String AREA_CODE_LIBRARY_TAB = "T004";
    @NotNull
    public static String AREA_CODE_MENU_TAB = "T001";
    @NotNull
    public static String AREA_CODE_SEARCH_TAB = "T003";
    @NotNull
    public static String AREA_CODE_SIDEMENU_NOTICE = "B001";
    @NotNull
    public static String AREA_CODE_STATION_TAB = "T002";
    @NotNull
    public static final String HAS_PREFERENCE_PREFIX = "has-";
    @NotNull
    public static final NewUpdateNotiUtils INSTANCE;

    static {
        NewUpdateNotiUtils.INSTANCE = new NewUpdateNotiUtils();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static final boolean getHasNewUpdate(@NotNull String s) {
        q.g(s, "areaCode");
        return MelonPrefs.getInstance().getBoolean("has-" + s, false);
    }

    public static final void setHasNewUpdate(@NotNull String s, boolean z) {
        q.g(s, "areaCode");
        MelonPrefs.getInstance().setBoolean("has-" + s, z);
    }
}

