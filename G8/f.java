package G8;

import Cb.i;
import Cc.K1;
import E9.w;
import H8.k;
import H8.u;
import R8.r;
import Tf.v;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.net.Uri;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.database.core.LocalContentDatabase_Impl;
import com.iloen.melon.utils.FilenameUtils;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.player.MusicUtils;
import com.iloen.melon.utils.preference.MelonPrefs;
import i9.j;
import i9.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import je.p;
import k8.t;
import kotlin.jvm.internal.q;
import r2.a;

public abstract class f {
    public static final o a;

    static {
        f.a = new o();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static void a(Context context0) {
        Cursor cursor1;
        q.g(context0, "context");
        long v = System.currentTimeMillis();
        HashMap hashMap0 = new HashMap();
        HashMap hashMap1 = new HashMap();
        MelonAppBase.Companion.getClass();
        ContentResolver contentResolver0 = t.a().getContext().getContentResolver();
        Cursor cursor0 = null;
        try {
            cursor1 = null;
            cursor1 = contentResolver0.query(m.a, new String[]{"_data", "songid", "bitrate", "match_stat", "albumid", "artistids", "artistnames"}, null, null, null);
        }
        catch(SQLiteCantOpenDatabaseException unused_ex) {
        }
        if(cursor1 != null) {
            if(cursor1.moveToFirst()) {
                while(true) {
                    k k0 = new k();
                    String s = i.j(cursor1, "_data");
                    k0.b = s;
                    k0.e = i.j(cursor1, "songid");
                    k0.f = i.e(cursor1, "match_stat");
                    k0.q = i.j(cursor1, "albumid");
                    k0.n = i.j(cursor1, "artistids");
                    k0.m = i.j(cursor1, "artistnames");
                    if(!R8.q.a.c() || !FilenameUtils.isDcf(s)) {
                        hashMap1.put(s, k0);
                    }
                    else {
                        hashMap0.put(s, k0);
                    }
                    if(!cursor1.moveToNext()) {
                        break;
                    }
                }
            }
            cursor1.close();
            r r0 = R8.q.a;
            if(r0.c()) {
                if(r0.c()) {
                    cursor0 = MusicUtils.query(context0, Uri.withAppendedPath(j.a, "all/members"), new String[]{"audio.*", "audio_genres.name AS genre"}, null, null, null);
                }
                if(cursor0 != null) {
                    if(cursor0.moveToFirst()) {
                        while(true) {
                            String s1 = i.j(cursor0, "_data");
                            k k1 = (k)hashMap0.get(s1);
                            if(k1 == null) {
                                k1 = new k();
                                hashMap0.put(s1, k1);
                            }
                            k1.k = i.j(cursor0, "title");
                            k1.b = s1;
                            k1.d = i.j(cursor0, "_display_name");
                            k1.g = i.f(cursor0, "_size", 0L);
                            k1.o = i.j(cursor0, "album");
                            k1.l = i.e(cursor0, "duration");
                            k1.t = i.e(cursor0, "track");
                            k1.u = i.e(cursor0, "year");
                            k1.h = i.j(cursor0, "mime_type");
                            k1.i = i.f(cursor0, "date_added", 0L);
                            k1.j = i.f(cursor0, "date_modified", 0L);
                            k1.r = i.j(cursor0, "genre");
                            if(Tf.o.H0(k1.m)) {
                                k1.m = i.j(cursor0, "artist");
                            }
                            if(!cursor0.moveToNext()) {
                                break;
                            }
                        }
                    }
                    cursor0.close();
                }
                if(!hashMap0.isEmpty()) {
                    g.a.m();
                    Collection collection0 = hashMap0.values();
                    q.f(collection0, "<get-values>(...)");
                    g.o(p.P0(collection0));
                }
                f.b(hashMap1, true);
            }
            else {
                f.b(hashMap1, false);
            }
            MelonPrefs.getInstance().setBoolean("MELON_MEDIA_STORE_MIGRATION", true);
            LogConstantsKt.debug(h.a, "migrate() Complete", v);
        }
    }

    public static void b(HashMap hashMap0, boolean z) {
        HashMap hashMap1 = new HashMap();
        z6.f f0 = g.a;
        if(z) {
            f0.m();
            for(Object object0: ((List)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new K1(21)))) {
                hashMap1.put(((u)object0).b, ((u)object0));
            }
        }
        else {
            f0.m();
            for(Object object1: ((List)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new K1(19)))) {
                hashMap1.put(((u)object1).b, ((u)object1));
            }
        }
        if(!hashMap1.isEmpty()) {
            ArrayList arrayList0 = new ArrayList();
            for(Object object2: hashMap1.entrySet()) {
                String s = (String)((Map.Entry)object2).getKey();
                u u0 = (u)((Map.Entry)object2).getValue();
                k k0 = (k)hashMap0.get(s);
                if(k0 != null) {
                    String s1 = k0.e;
                    u0.getClass();
                    q.g(s1, "<set-?>");
                    u0.c = s1;
                    u0.d = k0.f;
                    if(!Tf.o.H0(k0.m)) {
                        String s2 = k0.m;
                        q.g(s2, "<set-?>");
                        u0.e = s2;
                    }
                    if(!Tf.o.H0(k0.n)) {
                        String s3 = k0.n;
                        q.g(s3, "<set-?>");
                        u0.f = s3;
                    }
                    if(!Tf.o.H0(k0.q)) {
                        String s4 = k0.q;
                        q.g(s4, "<set-?>");
                        u0.i = s4;
                    }
                    String s5 = z6.f.i(u0.e, k0.b, u0.g);
                    if(s5 == null) {
                        s5 = "";
                    }
                    u0.h = s5;
                    arrayList0.add(u0);
                }
            }
            if(!arrayList0.isEmpty()) {
                f0.m();
                g.s(arrayList0);
            }
        }
    }

    public static void c(ArrayList arrayList0, a a0) {
        if(a0.g()) {
            a[] arr_a = a0.i();
            q.d(arr_a);
            for(int v = 0; v < arr_a.length; ++v) {
                a a1 = arr_a[v];
                q.d(a1);
                f.c(arrayList0, a1);
            }
            return;
        }
        String s = a0.e();
        if(s != null && v.r0(s, "local_playlist_db", false)) {
            arrayList0.add(a0);
        }
    }
}

