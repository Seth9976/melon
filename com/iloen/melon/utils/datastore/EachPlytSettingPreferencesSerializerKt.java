package com.iloen.melon.utils.datastore;

import De.t;
import De.w;
import android.content.Context;
import com.iloen.melon.EachPlytSettingPreferences;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.datastore.common.DefaultFileCorruptionHandlerKt;
import com.iloen.melon.utils.log.LogU;
import d8.d;
import java.util.Set;
import k2.c;
import k8.r;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.z;
import l2.i;
import o2.f;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\"%\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006\"%\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0004\u001A\u0004\b\t\u0010\u0006\"%\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000B\u0010\u0004\u001A\u0004\b\f\u0010\u0006\"%\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000E\u0010\u0004\u001A\u0004\b\u000F\u0010\u0006\"%\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001A\u0004\b\u0012\u0010\u0006¨\u0006\u0014"}, d2 = {"Landroid/content/Context;", "Ll2/i;", "Lcom/iloen/melon/EachPlytSettingPreferences;", "d", "Lze/b;", "getMusicPlytPrefDataStore", "(Landroid/content/Context;)Ll2/i;", "musicPlytPrefDataStore", "e", "getStationPlytPrefDataStore", "stationPlytPrefDataStore", "f", "getDrawerPlytPrefDataStore", "drawerPlytPrefDataStore", "g", "getSmartPlaylistPrefDataStore", "smartPlaylistPrefDataStore", "h", "getCommonMixUpPrefDataStore", "commonMixUpPrefDataStore", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class EachPlytSettingPreferencesSerializerKt {
    public static final w[] a;
    public static final Set b;
    public static final Set c;
    public static final c d;
    public static final c e;
    public static final c f;
    public static final c g;
    public static final c h;

    static {
        z z0 = new z(EachPlytSettingPreferencesSerializerKt.class, "musicPlytPrefDataStore", "getMusicPlytPrefDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1);
        t t0 = a.e(EachPlytSettingPreferencesSerializerKt.class, "stationPlytPrefDataStore", "getStationPlytPrefDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1, I.a);
        t t1 = a.e(EachPlytSettingPreferencesSerializerKt.class, "drawerPlytPrefDataStore", "getDrawerPlytPrefDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1, I.a);
        t t2 = a.e(EachPlytSettingPreferencesSerializerKt.class, "smartPlaylistPrefDataStore", "getSmartPlaylistPrefDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1, I.a);
        t t3 = a.e(EachPlytSettingPreferencesSerializerKt.class, "commonMixUpPrefDataStore", "getCommonMixUpPrefDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1, I.a);
        EachPlytSettingPreferencesSerializerKt.a = new w[]{I.a.g(z0), t0, t1, t2, t3};
        EachPlytSettingPreferencesSerializerKt.b = je.I.J(new String[]{"position", "sort", "playedtime"});
        EachPlytSettingPreferencesSerializerKt.c = je.I.J(new String[]{"SECTION_REPEAT_START_POSITION", "SECTION_REPEAT_END_POSITION"});
        m2.a a0 = DefaultFileCorruptionHandlerKt.getDefaultFileCorruptionHandler(EachPlytSettingPreferencesSerializer.INSTANCE);
        com.iloen.melon.utils.datastore.a a1 = new com.iloen.melon.utils.datastore.a(1);
        EachPlytSettingPreferencesSerializerKt.d = d.n("music_plyt_pref.pb", EachPlytSettingPreferencesSerializer.INSTANCE.getSerializer(), a0, a1, 16);
        m2.a a2 = DefaultFileCorruptionHandlerKt.getDefaultFileCorruptionHandler(EachPlytSettingPreferencesSerializer.INSTANCE);
        com.iloen.melon.utils.datastore.a a3 = new com.iloen.melon.utils.datastore.a(2);
        EachPlytSettingPreferencesSerializerKt.e = d.n("radio_plyt_pref.pb", EachPlytSettingPreferencesSerializer.INSTANCE.getSerializer(), a2, a3, 16);
        m2.a a4 = DefaultFileCorruptionHandlerKt.getDefaultFileCorruptionHandler(EachPlytSettingPreferencesSerializer.INSTANCE);
        EachPlytSettingPreferencesSerializerKt.f = d.n("drawer_plyt_pref.pb", EachPlytSettingPreferencesSerializer.INSTANCE.getSerializer(), a4, null, 24);
        m2.a a5 = DefaultFileCorruptionHandlerKt.getDefaultFileCorruptionHandler(EachPlytSettingPreferencesSerializer.INSTANCE);
        EachPlytSettingPreferencesSerializerKt.g = d.n("sp_pref.pb", EachPlytSettingPreferencesSerializer.INSTANCE.getSerializer(), a5, null, 24);
        m2.a a6 = DefaultFileCorruptionHandlerKt.getDefaultFileCorruptionHandler(EachPlytSettingPreferencesSerializer.INSTANCE);
        EachPlytSettingPreferencesSerializerKt.h = d.n("common_mix_up_pref.pb", EachPlytSettingPreferencesSerializer.INSTANCE.getSerializer(), a6, null, 24);
    }

    public static EachPlytSettingPreferences a(f f0, EachPlytSettingPreferences eachPlytSettingPreferences0, String s) {
        LogU.Companion.d("SharedPrefsMigration", "handleDbPlaylistMigration() " + s);
        f0.a("sort");
        int v = f0.a.getInt("sort", 0);
        f0.a("playedtime");
        long v1 = f0.a.getLong("playedtime", 0L);
        r r0 = (r)eachPlytSettingPreferences0.toBuilder();
        f0.a("position");
        String s1 = String.valueOf(f0.a.getInt("position", -1));
        r0.d();
        ((EachPlytSettingPreferences)r0.b).setLastUniqueId(s1);
        r0.d();
        ((EachPlytSettingPreferences)r0.b).setSortType(v);
        r0.d();
        ((EachPlytSettingPreferences)r0.b).setPlayedTime(v1);
        r0.d();
        ((EachPlytSettingPreferences)r0.b).addAllSelectedRepeatUniqueId(je.w.a);
        return (EachPlytSettingPreferences)r0.a();
    }

    @NotNull
    public static final i getCommonMixUpPrefDataStore(@NotNull Context context0) {
        q.g(context0, "<this>");
        return (i)EachPlytSettingPreferencesSerializerKt.h.getValue(context0, EachPlytSettingPreferencesSerializerKt.a[4]);
    }

    @NotNull
    public static final i getDrawerPlytPrefDataStore(@NotNull Context context0) {
        q.g(context0, "<this>");
        return (i)EachPlytSettingPreferencesSerializerKt.f.getValue(context0, EachPlytSettingPreferencesSerializerKt.a[2]);
    }

    @NotNull
    public static final i getMusicPlytPrefDataStore(@NotNull Context context0) {
        q.g(context0, "<this>");
        return (i)EachPlytSettingPreferencesSerializerKt.d.getValue(context0, EachPlytSettingPreferencesSerializerKt.a[0]);
    }

    @NotNull
    public static final i getSmartPlaylistPrefDataStore(@NotNull Context context0) {
        q.g(context0, "<this>");
        return (i)EachPlytSettingPreferencesSerializerKt.g.getValue(context0, EachPlytSettingPreferencesSerializerKt.a[3]);
    }

    @NotNull
    public static final i getStationPlytPrefDataStore(@NotNull Context context0) {
        q.g(context0, "<this>");
        return (i)EachPlytSettingPreferencesSerializerKt.e.getValue(context0, EachPlytSettingPreferencesSerializerKt.a[1]);
    }
}

