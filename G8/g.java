package G8;

import A7.d;
import Cc.K1;
import Dd.J;
import E9.w;
import H8.c;
import H8.e;
import H8.i;
import H8.k;
import a.a;
import android.net.Uri;
import android.text.TextUtils;
import androidx.room.A;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.CType;
import com.iloen.melon.database.core.LocalContentDatabase;
import com.iloen.melon.database.core.LocalContentDatabase_Impl;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.FilenameUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.cipher.Base62UUID;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import je.p;
import k8.Y;
import k8.t;
import kotlin.jvm.internal.q;
import z6.f;

public final class g {
    public static final f a;
    public static g b;

    static {
        g.a = new f(13);
    }

    public static void a(List list0) {
        q.g(list0, "list");
        ArrayList arrayList0 = p.Q0(list0);
        while(!arrayList0.isEmpty()) {
            List list1 = d.p(arrayList0, 500, arrayList0);
            arrayList0.removeAll(list1);
            i i0 = g.g();
            i0.getClass();
            StringBuilder stringBuilder0 = Y.p("DELETE FROM local_contents WHERE data in (");
            a.k(list1.size(), stringBuilder0);
            stringBuilder0.append(")");
            w.N(((LocalContentDatabase_Impl)i0.b), false, true, new c(stringBuilder0.toString(), 1, list1));
        }
    }

    public static void b(List list0) {
        q.g(list0, "contentIds");
        ArrayList arrayList0 = p.Q0(list0);
        while(!arrayList0.isEmpty()) {
            List list1 = d.p(arrayList0, 500, arrayList0);
            arrayList0.removeAll(list1);
            i i0 = g.g();
            i0.getClass();
            StringBuilder stringBuilder0 = Y.p("DELETE FROM local_contents WHERE _id in (");
            a.k(list1.size(), stringBuilder0);
            stringBuilder0.append(")");
            w.N(((LocalContentDatabase_Impl)i0.b), false, true, new c(stringBuilder0.toString(), 8, list1));
        }
    }

    public static boolean c(Uri uri0) {
        q.g(uri0, "uri");
        if(!TextUtils.isEmpty(uri0.toString())) {
            i i0 = g.g();
            String s = uri0.toString();
            q.f(s, "toString(...)");
            return ((int)(((Integer)w.N(((LocalContentDatabase_Impl)i0.b), true, false, new Ac.g(s, 20))))) > 0;
        }
        return false;
    }

    public static boolean d(String s) {
        q.g(s, "data");
        return ((int)(((Integer)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new Ac.g(s, 19))))) > 0;
    }

    public static List e() {
        return (List)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new K1(26));
    }

    public static ArrayList f(ArrayList arrayList0) {
        ArrayList arrayList1 = new ArrayList();
        ArrayList arrayList2 = p.Q0(arrayList0);
        while(!arrayList2.isEmpty()) {
            List list0 = d.p(arrayList2, 500, arrayList2);
            arrayList2.removeAll(list0);
            i i0 = g.g();
            i0.getClass();
            StringBuilder stringBuilder0 = Y.p("SELECT _id FROM local_contents WHERE data in (");
            a.k(list0.size(), stringBuilder0);
            stringBuilder0.append(")");
            arrayList1.addAll(((List)w.N(((LocalContentDatabase_Impl)i0.b), true, false, new c(stringBuilder0.toString(), 6, list0))));
        }
        return arrayList1;
    }

    public static i g() {
        f f0 = LocalContentDatabase.a;
        LocalContentDatabase localContentDatabase0 = LocalContentDatabase.b;
        if(localContentDatabase0 == null) {
            synchronized(f0) {
                MelonAppBase.Companion.getClass();
                A a0 = w.o(t.a().getContext(), LocalContentDatabase.class, "local_content_db");
                a0.i = true;
                a0.d.add(LocalContentDatabase.c);
                localContentDatabase0 = (LocalContentDatabase)a0.b();
                LocalContentDatabase.b = localContentDatabase0;
            }
            return localContentDatabase0.b();
        }
        return localContentDatabase0.b();
    }

    public static Playable h(k k0, String s) {
        q.g(k0, "entity");
        q.g(s, "playbackMenuId");
        String s1 = k0.e;
        String s2 = k0.b;
        String s3 = FilenameUtils.isDcf(k0.d) ? StringUtils.getTitleForDCF(k0.k) : k0.k;
        String s4 = k0.n;
        String s5 = k0.m;
        String s6 = k0.q;
        String s7 = k0.o;
        String s8 = k0.p;
        long v = (long)k0.l;
        CType cType0 = "어학".equals(k0.r) ? CType.EDU : CType.SONG;
        String s9 = String.valueOf(k0.v);
        long v1 = k0.w;
        String s10 = k0.c;
        String s11 = k0.d;
        String s12 = Base62UUID.randomUUID();
        Playable playable0 = Playable.newBuilder(1).isMelonSong(!TextUtils.isEmpty(s1)).data(s2).songIdTitle(s1, s3).artists(StringUtils.makeArtistMap(s4, s5)).albumIdName(s6, s7).localAlbumKey(s8).duration(v).cType(cType0).menuId(s).originMenuId(s).hasMv(0).isAdult(0).dbContentId(s9).mediaStoreAlbumId(v1).uriString(s10).displayName(s11).trackId(s12).build();
        q.f(playable0, "build(...)");
        return playable0;
    }

    public static ArrayList i(String s, List list0) {
        q.g(list0, "list");
        q.g(s, "playbackMenuId");
        ArrayList arrayList0 = new ArrayList();
        if(!list0.isEmpty()) {
            for(Object object0: list0) {
                arrayList0.add(g.h(((k)object0), s));
            }
        }
        return arrayList0;
    }

    public static k j(Uri uri0) {
        q.g(uri0, "uri");
        if(TextUtils.isEmpty(uri0.toString())) {
            return null;
        }
        i i0 = g.g();
        String s = uri0.toString();
        q.f(s, "toString(...)");
        return (k)w.N(((LocalContentDatabase_Impl)i0.b), true, false, new Ac.g(s, 9));
    }

    public static k k(String s) {
        q.g(s, "data");
        return (k)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new Ac.g(s, 18));
    }

    public static ArrayList l(List list0) {
        list0.isEmpty();
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
        for(Object object0: list0) {
            arrayList0.add(Cb.i.i(((File)object0)));
        }
        ArrayList arrayList1 = new ArrayList();
        ArrayList arrayList2 = p.Q0(arrayList0);
        while(!arrayList2.isEmpty()) {
            List list1 = d.p(arrayList2, 500, arrayList2);
            arrayList2.removeAll(list1);
            arrayList1.addAll(g.g().u(list1));
        }
        return arrayList1;
    }

    public static ArrayList m(List list0) {
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = p.Q0(list0);
        while(!arrayList1.isEmpty()) {
            List list1 = d.p(arrayList1, 500, arrayList1);
            arrayList1.removeAll(list1);
            i i0 = g.g();
            i0.getClass();
            StringBuilder stringBuilder0 = Y.p("SELECT * FROM local_contents WHERE _id in (");
            a.k(list1.size(), stringBuilder0);
            stringBuilder0.append(")");
            arrayList0.addAll(((List)w.N(((LocalContentDatabase_Impl)i0.b), true, false, new c(stringBuilder0.toString(), 4, list1))));
        }
        return arrayList0;
    }

    public static void n(k k0) {
        g.p(k0);
        i i0 = g.g();
        i0.getClass();
        w.N(((LocalContentDatabase_Impl)i0.b), false, true, new H8.f(i0, k0, 0));
    }

    public static void o(List list0) {
        for(Object object0: list0) {
            g.p(((k)object0));
        }
        i i0 = g.g();
        i0.getClass();
        w.N(((LocalContentDatabase_Impl)i0.b), false, true, new J(13, i0, list0));
    }

    public static void p(k k0) {
        String s = f.i(k0.m, k0.d, k0.o);
        if(s == null) {
            s = "";
        }
        k0.p = s;
    }

    public static void q(k k0) {
        g.p(k0);
        i i0 = g.g();
        i0.getClass();
        w.N(((LocalContentDatabase_Impl)i0.b), false, true, new H8.f(i0, k0, 1));
    }

    public static int r(String s, String s1, String s2, String s3, String s4) {
        q.g(s4, "artists");
        String s5 = f.i(s4, "", s2);
        return s5 == null ? ((int)(((Integer)w.N(((LocalContentDatabase_Impl)g.g().b), false, true, new H8.d(0, s1, "", s3, s4, s))))) : ((int)(((Integer)w.N(((LocalContentDatabase_Impl)g.g().b), false, true, new H8.d(0, s1, s5, s3, s4, s)))));
    }

    public static void s(ArrayList arrayList0) {
        i i0 = g.g();
        i0.getClass();
        ((Integer)w.N(((LocalContentDatabase_Impl)i0.b), false, true, new e(i0, arrayList0, 1))).getClass();
    }
}

