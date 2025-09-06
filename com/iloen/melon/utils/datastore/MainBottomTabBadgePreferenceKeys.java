package com.iloen.melon.utils.datastore;

import df.v;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import q2.f;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0018\bÇ\u0002\u0018\u00002\u00020\u0001R\u001D\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007R\u001D\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0005\u001A\u0004\b\n\u0010\u0007R\u001D\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0005\u001A\u0004\b\r\u0010\u0007R\u001D\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u000F\u0010\u0005\u001A\u0004\b\u0010\u0010\u0007R\u001D\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001A\u0004\b\u0013\u0010\u0007R\u001D\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001A\u0004\b\u0016\u0010\u0007R\u001D\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001A\u0004\b\u0019\u0010\u0007¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/utils/datastore/MainBottomTabBadgePreferenceKeys;", "", "Lq2/f;", "", "a", "Lq2/f;", "getAREA_CODE_MENU_TAB", "()Lq2/f;", "AREA_CODE_MENU_TAB", "b", "getAREA_CODE_FORYOU_TAB", "AREA_CODE_FORYOU_TAB", "c", "getAREA_CODE_SEARCH_TAB", "AREA_CODE_SEARCH_TAB", "d", "getAREA_CODE_LIBRARY_TAB", "AREA_CODE_LIBRARY_TAB", "e", "getAREA_CODE_HOME_TAB", "AREA_CODE_HOME_TAB", "f", "getAREA_CODE_SIDEMENU_NOTICE", "AREA_CODE_SIDEMENU_NOTICE", "g", "getFORU_TAB_VISITORS", "FORU_TAB_VISITORS", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MainBottomTabBadgePreferenceKeys {
    public static final int $stable;
    @NotNull
    public static final MainBottomTabBadgePreferenceKeys INSTANCE;
    public static final f a;
    public static final f b;
    public static final f c;
    public static final f d;
    public static final f e;
    public static final f f;
    public static final f g;

    static {
        MainBottomTabBadgePreferenceKeys.INSTANCE = new MainBottomTabBadgePreferenceKeys();  // 初始化器: Ljava/lang/Object;-><init>()V
        MainBottomTabBadgePreferenceKeys.a = v.K("T001");
        MainBottomTabBadgePreferenceKeys.b = v.K("T002");
        MainBottomTabBadgePreferenceKeys.c = v.K("T003");
        MainBottomTabBadgePreferenceKeys.d = v.K("T004");
        MainBottomTabBadgePreferenceKeys.e = v.K("T000");
        MainBottomTabBadgePreferenceKeys.f = v.K("B001");
        MainBottomTabBadgePreferenceKeys.g = v.K("FORU_TAB_VISITORS");
        MainBottomTabBadgePreferenceKeys.$stable = 8;
    }

    @NotNull
    public final f getAREA_CODE_FORYOU_TAB() {
        return MainBottomTabBadgePreferenceKeys.b;
    }

    @NotNull
    public final f getAREA_CODE_HOME_TAB() {
        return MainBottomTabBadgePreferenceKeys.e;
    }

    @NotNull
    public final f getAREA_CODE_LIBRARY_TAB() {
        return MainBottomTabBadgePreferenceKeys.d;
    }

    @NotNull
    public final f getAREA_CODE_MENU_TAB() {
        return MainBottomTabBadgePreferenceKeys.a;
    }

    @NotNull
    public final f getAREA_CODE_SEARCH_TAB() {
        return MainBottomTabBadgePreferenceKeys.c;
    }

    @NotNull
    public final f getAREA_CODE_SIDEMENU_NOTICE() {
        return MainBottomTabBadgePreferenceKeys.f;
    }

    @NotNull
    public final f getFORU_TAB_VISITORS() {
        return MainBottomTabBadgePreferenceKeys.g;
    }
}

