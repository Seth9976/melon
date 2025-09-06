package com.iloen.melon.utils.datastore;

import android.content.Context;
import java.util.Set;
import je.I;
import je.n;
import kotlin.jvm.internal.q;
import o2.d;
import ob.f;
import p2.j;
import we.k;

public final class a implements k {
    public final int a;

    public a(int v) {
        this.a = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                q.g(((Context)object0), "context");
                CommonPlytSettingPreferencesSerializerKt.commonPlaylistSettingPrefDataStore.2.1 commonPlytSettingPreferencesSerializerKt$commonPlaylistSettingPrefDataStore$2$10 = new CommonPlytSettingPreferencesSerializerKt.commonPlaylistSettingPrefDataStore.2.1(3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                return e.k.z(new d(((Context)object0), "DbPlaylist_0", CommonPlytSettingPreferencesSerializerKt.b, null, commonPlytSettingPreferencesSerializerKt$commonPlaylistSettingPrefDataStore$2$10, 8));
            }
            case 1: {
                q.g(((Context)object0), "context");
                EachPlytSettingPreferencesSerializerKt.musicPlytPrefDataStore.2.1 eachPlytSettingPreferencesSerializerKt$musicPlytPrefDataStore$2$10 = new EachPlytSettingPreferencesSerializerKt.musicPlytPrefDataStore.2.1(3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                d d0 = new d(((Context)object0), "DbPlaylist_0", EachPlytSettingPreferencesSerializerKt.b, null, eachPlytSettingPreferencesSerializerKt$musicPlytPrefDataStore$2$10, 8);
                EachPlytSettingPreferencesSerializerKt.musicPlytPrefDataStore.2.2 eachPlytSettingPreferencesSerializerKt$musicPlytPrefDataStore$2$20 = new EachPlytSettingPreferencesSerializerKt.musicPlytPrefDataStore.2.2(3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                return e.k.A(new d[]{d0, new d(((Context)object0), "com.iloen.melon.tablet.Preference.SETTING", EachPlytSettingPreferencesSerializerKt.c, null, eachPlytSettingPreferencesSerializerKt$musicPlytPrefDataStore$2$20, 8)});
            }
            case 2: {
                q.g(((Context)object0), "context");
                EachPlytSettingPreferencesSerializerKt.stationPlytPrefDataStore.2.1 eachPlytSettingPreferencesSerializerKt$stationPlytPrefDataStore$2$10 = new EachPlytSettingPreferencesSerializerKt.stationPlytPrefDataStore.2.1(3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                return e.k.A(new d[]{new d(((Context)object0), "DbPlaylist_8", EachPlytSettingPreferencesSerializerKt.b, null, eachPlytSettingPreferencesSerializerKt$stationPlytPrefDataStore$2$10, 8), new d(((Context)object0), "com.iloen.melon.tablet.Preference.SETTING", I.J(new String[]{"CAST_LAST_PLAYABLE_SONGID"}), null, new EachPlytSettingPreferencesSerializerKt.stationPlytPrefDataStore.2.2(3, null), 8)});  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
            }
            case 3: {
                q.g(((Context)object0), "context");
                return e.k.z(new d(((Context)object0), "com.iloen.melon.tablet.Preference.SETTING", n.A0(new String[]{"MelonId", "AuthTokenV2"}), null, new LoginUserDataStoreKt.loginUserDataStore.2.1(3, null), 8));  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
            }
            default: {
                q.g(((Context)object0), "context");
                Set set0 = n.A0(new String[]{MainBottomTabBadgePreferenceKeys.INSTANCE.getAREA_CODE_SIDEMENU_NOTICE().a, MainBottomTabBadgePreferenceKeys.INSTANCE.getAREA_CODE_FORYOU_TAB().a, MainBottomTabBadgePreferenceKeys.INSTANCE.getAREA_CODE_SEARCH_TAB().a, MainBottomTabBadgePreferenceKeys.INSTANCE.getAREA_CODE_LIBRARY_TAB().a, MainBottomTabBadgePreferenceKeys.INSTANCE.getAREA_CODE_MENU_TAB().a});
                return set0 == p2.k.a ? e.k.z(new d(((Context)object0), "com.iloen.melon.tablet.Preference.SETTING", null, new j(set0, null), new f(3, 1, null), 4)) : e.k.z(new d(((Context)object0), "com.iloen.melon.tablet.Preference.SETTING", set0, new j(set0, null), new f(3, 1, null)));
            }
        }
    }
}

