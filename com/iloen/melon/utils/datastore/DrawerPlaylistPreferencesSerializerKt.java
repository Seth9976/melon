package com.iloen.melon.utils.datastore;

import De.w;
import android.content.Context;
import com.iloen.melon.utils.datastore.common.DefaultFileCorruptionHandlerKt;
import d8.d;
import k2.c;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.z;
import l2.i;
import m2.a;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\")\u0010\b\u001A\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001*\u00020\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007*\n\u0010\t\"\u00020\u00022\u00020\u0002¨\u0006\n"}, d2 = {"Landroid/content/Context;", "Ll2/i;", "Lcom/iloen/melon/MusicDrawerPreferences;", "Lcom/iloen/melon/utils/datastore/DrawerPlaylistPreferences;", "b", "Lze/b;", "getDrawerPlaylistDataStore", "(Landroid/content/Context;)Ll2/i;", "drawerPlaylistDataStore", "DrawerPlaylistPreferences", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerPlaylistPreferencesSerializerKt {
    public static final w[] a;
    public static final c b;

    static {
        z z0 = new z(DrawerPlaylistPreferencesSerializerKt.class, "drawerPlaylistDataStore", "getDrawerPlaylistDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1);
        DrawerPlaylistPreferencesSerializerKt.a = new w[]{I.a.g(z0)};
        a a0 = DefaultFileCorruptionHandlerKt.getDefaultFileCorruptionHandler(DrawerPlaylistPreferencesSerializer.INSTANCE);
        DrawerPlaylistPreferencesSerializerKt.b = d.n("music_drawer_prefs.pb", DrawerPlaylistPreferencesSerializer.INSTANCE.getSerializer(), a0, null, 24);
    }

    @NotNull
    public static final i getDrawerPlaylistDataStore(@NotNull Context context0) {
        q.g(context0, "<this>");
        return (i)DrawerPlaylistPreferencesSerializerKt.b.getValue(context0, DrawerPlaylistPreferencesSerializerKt.a[0]);
    }
}

