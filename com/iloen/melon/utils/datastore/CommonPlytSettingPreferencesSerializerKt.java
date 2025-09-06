package com.iloen.melon.utils.datastore;

import De.w;
import android.content.Context;
import com.iloen.melon.CommonPlytSettingPreferences;
import com.iloen.melon.utils.datastore.common.DefaultFileCorruptionHandlerKt;
import com.iloen.melon.utils.log.LogU;
import d8.d;
import java.util.Set;
import k2.c;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.z;
import l2.i;
import m2.a;
import o2.f;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"%\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Landroid/content/Context;", "Ll2/i;", "Lcom/iloen/melon/CommonPlytSettingPreferences;", "c", "Lze/b;", "getCommonPlaylistSettingPrefDataStore", "(Landroid/content/Context;)Ll2/i;", "commonPlaylistSettingPrefDataStore", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class CommonPlytSettingPreferencesSerializerKt {
    public static final w[] a;
    public static final Set b;
    public static final c c;

    static {
        z z0 = new z(CommonPlytSettingPreferencesSerializerKt.class, "commonPlaylistSettingPrefDataStore", "getCommonPlaylistSettingPrefDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1);
        CommonPlytSettingPreferencesSerializerKt.a = new w[]{I.a.g(z0)};
        CommonPlytSettingPreferencesSerializerKt.b = je.I.J(new String[]{"shuffle", "repeatmode"});
        a a0 = DefaultFileCorruptionHandlerKt.getDefaultFileCorruptionHandler(CommonPlytSettingPrefSerializer.INSTANCE);
        com.iloen.melon.utils.datastore.a a1 = new com.iloen.melon.utils.datastore.a(0);
        CommonPlytSettingPreferencesSerializerKt.c = d.n("common_plyt_setting_pref.pb", CommonPlytSettingPrefSerializer.INSTANCE.getSerializer(), a0, a1, 16);
    }

    public static final CommonPlytSettingPreferences access$handleDbPlaylistMigration(f f0, CommonPlytSettingPreferences commonPlytSettingPreferences0, String s) {
        LogU.Companion.d("SharedPrefsMigration", "handleDbPlaylistMigration() " + s);
        f0.getClass();
        f0.a("shuffle");
        boolean z = f0.a.getBoolean("shuffle", false);
        f0.a("repeatmode");
        int v = f0.a.getInt("repeatmode", 0);
        k8.d d0 = (k8.d)commonPlytSettingPreferences0.toBuilder();
        d0.d();
        ((CommonPlytSettingPreferences)d0.b).setIsShuffle(z);
        d0.d();
        ((CommonPlytSettingPreferences)d0.b).setRepeatMode(v);
        return (CommonPlytSettingPreferences)d0.a();
    }

    @NotNull
    public static final i getCommonPlaylistSettingPrefDataStore(@NotNull Context context0) {
        q.g(context0, "<this>");
        return (i)CommonPlytSettingPreferencesSerializerKt.c.getValue(context0, CommonPlytSettingPreferencesSerializerKt.a[0]);
    }
}

