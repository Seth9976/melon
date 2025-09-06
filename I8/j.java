package I8;

import Cb.i;
import Cc.K1;
import E9.w;
import G8.g;
import H8.c;
import H8.e;
import H8.u;
import U4.x;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.provider.MediaStore.Audio.Media;
import b3.Z;
import com.iloen.melon.database.core.LocalContentDatabase_Impl;
import com.iloen.melon.types.Song;
import com.iloen.melon.utils.FilenameUtils;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.SongMetaParser;
import com.iloen.melon.utils.ui.CursorUtil;
import e.k;
import i9.m;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import k8.Y;
import kotlin.jvm.internal.q;
import w7.d;
import z6.f;

public abstract class j extends o {
    public final LogU b;
    public static final f c;
    public static j d;
    public static final d e;
    public static j f;

    static {
        j.c = new f(17);
        j.e = new d(18);
    }

    public j(int v) {
        if(v != 1) {
            super();
            LogU logU0 = Z.g("DcfSyncHelper", true);
            logU0.setCategory(Category.LocalSync);
            this.b = logU0;
            return;
        }
        super();
        LogU logU1 = Z.g("MediaStoreSyncHelper", true);
        logU1.setCategory(Category.LocalSync);
        this.b = logU1;
    }

    @Override  // I8.o
    public p e(Context context0, List list0) {
        q.g(context0, "context");
        LogU.info$default(this.b, androidx.appcompat.app.o.j(list0.size(), "syncImpl() TargetList[", "] sync"), null, false, 6, null);
        p p0 = this.j(context0, list0, true);
        LogConstantsKt.debug(this.b, "syncImpl() Complete targetList sync. " + p0, System.currentTimeMillis());
        return p0;
    }

    @Override  // I8.o
    public p f(Context context0, boolean z) {
        List list2;
        List list0;
        LogU.info$default(this.b, "syncImpl() Start full sync", null, false, 6, null);
        long v = System.currentTimeMillis();
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Uri uri0 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        q.f(uri0, "EXTERNAL_CONTENT_URI");
        Cursor cursor0 = i.n(context0, uri0, new String[]{"_data"}, "is_music = 1", null, 24);
        if(cursor0 != null) {
            try {
                if(cursor0.moveToFirst()) {
                    do {
                        String s = i.j(cursor0, "_data");
                        if(s.length() > 0) {
                            arrayList3.add(s);
                        }
                    }
                    while(cursor0.moveToNext());
                }
            }
            catch(Throwable throwable0) {
                d8.d.l(cursor0, throwable0);
                throw throwable0;
            }
            cursor0.close();
        }
        f f0 = g.a;
        int v1 = 0;
        if(arrayList3.isEmpty()) {
            if(R8.q.a.c()) {
                f0.m();
                list0 = (List)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new K1(24));
            }
            else {
                f0.m();
                list0 = (List)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new K1(25));
            }
            if(!list0.isEmpty()) {
                f0.m();
                g.b(list0);
                ArrayList arrayList4 = je.p.Q0(list0);
                while(!arrayList4.isEmpty()) {
                    List list1 = A7.d.p(arrayList4, 50, arrayList4);
                    arrayList4.removeAll(list1);
                    o.a(("deleteAllAudioData() items[" + list1.size() + "] : { " + je.p.q0(list1, null, null, null, null, 0x3F) + " }"));
                }
            }
            arrayList2.addAll(list0);
        }
        else {
            if(R8.q.a.c()) {
                f0.m();
                list2 = (List)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new K1(23));
            }
            else {
                f0.m();
                list2 = (List)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new K1(27));
            }
            ArrayList arrayList5 = new ArrayList(list2);
            if(!arrayList5.isEmpty()) {
                arrayList5.removeAll(arrayList3);
                f0.m();
                g.a(arrayList5);
                ArrayList arrayList6 = je.p.Q0(arrayList5);
                while(!arrayList6.isEmpty()) {
                    List list3 = A7.d.p(arrayList6, 50, arrayList6);
                    arrayList6.removeAll(list3);
                    o.a(("deleteNotExistAudioData() items[" + list3.size() + "] : { " + je.p.q0(list3, null, null, null, null, 0x3F) + " }"));
                }
            }
            for(Object object0: arrayList5) {
                if(v1 >= 0) {
                    String s1 = (String)object0;
                    arrayList2.add(((long)v1));
                    ++v1;
                    continue;
                }
                k.O();
                throw null;
            }
        }
        while(!arrayList3.isEmpty()) {
            List list4 = A7.d.p(arrayList3, 1000, arrayList3);
            arrayList3.removeAll(list4);
            ArrayList arrayList7 = new ArrayList(je.q.Q(10, list4));
            for(Object object1: list4) {
                arrayList7.add(new File(((String)object1)));
            }
            p p0 = this.j(context0, arrayList7, z);
            arrayList0.addAll(((Collection)p0.a));
            arrayList1.addAll(((Collection)p0.b));
        }
        p p1 = new p(arrayList0, arrayList1, arrayList2);
        LogConstantsKt.debug(this.b, "syncImpl() Complete full sync. " + p1, v);
        return p1;
    }

    public H8.k g(Cursor cursor0, List list0) {
        H8.k k0 = new H8.k();
        k0.b = i.j(cursor0, "_data");
        k0.d = i.j(cursor0, "_display_name");
        k0.g = i.f(cursor0, "_size", 0L);
        k0.h = i.j(cursor0, "mime_type");
        k0.i = i.f(cursor0, "date_added", 0L);
        k0.j = i.f(cursor0, "date_modified", 0L);
        k0.k = i.j(cursor0, "title");
        k0.l = (int)i.f(cursor0, "duration", 0L);
        k0.m = i.j(cursor0, "artist");
        k0.o = i.j(cursor0, "album");
        k0.t = (int)i.f(cursor0, "track", 0L);
        k0.u = (int)i.f(cursor0, "year", 0L);
        k0.v = i.f(cursor0, "_id", 0L);
        k0.w = i.f(cursor0, "album_id", 0L);
        if(StorageUtils.isScopedStorage()) {
            String s = CursorUtil.getAudioContentUri(k0.v).toString();
            q.f(s, "toString(...)");
            k0.c = s;
        }
        k0.r = i.j(cursor0, "genre");
        return k0;
    }

    public List h(Context context0, List list0) {
        q.g(context0, "context");
        return je.w.a;
    }

    public ArrayList i(Context context0, HashMap hashMap0) {
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        Collection collection0 = hashMap0.values();
        q.f(collection0, "<get-values>(...)");
        for(Object object0: collection0) {
            arrayList1.add(((a)object0).d);
        }
        Uri uri0 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        q.f(uri0, "EXTERNAL_CONTENT_URI");
        Cursor cursor0 = i.n(context0, uri0, ((String[])l.c.getValue()), x.k("_id IN (", je.p.q0(arrayList1, null, null, null, null, 0x3F), ")"), null, 24);
        if(cursor0 != null) {
            try {
                if(cursor0.moveToFirst()) {
                    List list0 = this.h(context0, arrayList1);
                    do {
                        arrayList0.add(this.g(cursor0, list0));
                    }
                    while(cursor0.moveToNext());
                }
            }
            catch(Throwable throwable0) {
                d8.d.l(cursor0, throwable0);
                throw throwable0;
            }
            cursor0.close();
            return arrayList0;
        }
        return arrayList0;
    }

    public p j(Context context0, List list0, boolean z) {
        ArrayList arrayList12;
        ArrayList arrayList5;
        ArrayList arrayList4;
        Iterator iterator4;
        HashMap hashMap0 = new HashMap();
        if(!list0.isEmpty()) {
            StringBuilder stringBuilder0 = Y.p("is_music = 1 AND _data IN (");
            int v = 0;
            for(Object object0: list0) {
                if(v >= 0) {
                    if(v > 0) {
                        stringBuilder0.append(",");
                    }
                    DatabaseUtils.appendEscapedSQLString(stringBuilder0, i.i(((File)object0)));
                    ++v;
                    continue;
                }
                k.O();
                throw null;
            }
            stringBuilder0.append(")");
            Uri uri0 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            q.f(uri0, "EXTERNAL_CONTENT_URI");
            Cursor cursor0 = i.n(context0, uri0, a.g, stringBuilder0.toString(), null, 24);
            if(cursor0 != null) {
                try {
                    if(cursor0.moveToFirst()) {
                        do {
                            String s = i.j(cursor0, "_data");
                            long v1 = i.f(cursor0, "date_modified", 0L);
                            String s1 = i.j(cursor0, "title");
                            hashMap0.put(s, new a(v1, i.f(cursor0, "_id", 0L), s, s1, i.f(cursor0, "album_id", 0L)));
                        }
                        while(cursor0.moveToNext());
                    }
                }
                catch(Throwable throwable0) {
                    d8.d.l(cursor0, throwable0);
                    throw throwable0;
                }
                cursor0.close();
            }
        }
        HashMap hashMap1 = new HashMap();
        f f0 = g.a;
        if(!list0.isEmpty()) {
            f0.m();
            for(Object object1: g.l(list0)) {
                q.g(((H8.k)object1), "entity");
                String s2 = ((H8.k)object1).b;
                a a0 = new a(((H8.k)object1).j, ((H8.k)object1).v, s2, ((H8.k)object1).k, ((H8.k)object1).w);
                String s3 = ((H8.k)object1).c;
                q.g(s3, "<set-?>");
                a0.f = s3;
                hashMap1.put(s2, a0);
            }
        }
        HashMap hashMap2 = new HashMap();
        for(Object object2: hashMap1.entrySet()) {
            String s4 = (String)((Map.Entry)object2).getKey();
            a a1 = (a)((Map.Entry)object2).getValue();
            if(hashMap0.containsKey(s4)) {
                if(q.b(hashMap0.get(s4), a1)) {
                    a1.getClass();
                    if(!StorageUtils.isScopedStorage()) {
                        if(a1.a.length() == 0) {
                            goto label_59;
                        }
                    }
                    else if(a1.f.length() == 0) {
                        goto label_59;
                    }
                }
                else {
                label_59:
                    Object object3 = hashMap0.get(s4);
                    q.d(object3);
                    hashMap2.put(s4, object3);
                }
                hashMap0.remove(s4);
            }
        }
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        if(hashMap2.isEmpty()) {
            hashMap2 = null;
        }
        if(hashMap2 == null) {
            arrayList5 = arrayList0;
        }
        else {
            ArrayList arrayList2 = new ArrayList();
            LogU.info$default(this.b, x.e(hashMap2.size(), "update() items: "), null, false, 6, null);
            ArrayList arrayList3 = new ArrayList();
            Iterator iterator3 = this.i(context0, hashMap2).iterator();
            while(iterator3.hasNext()) {
                Object object4 = iterator3.next();
                H8.k k0 = (H8.k)object4;
                f0.m();
                H8.k k1 = g.k(k0.b);
                if(k1 == null) {
                    arrayList4 = arrayList0;
                    iterator4 = iterator3;
                }
                else {
                    iterator4 = iterator3;
                    String s5 = k0.d;
                    q.g(s5, "<set-?>");
                    k1.d = s5;
                    arrayList4 = arrayList0;
                    k1.g = k0.g;
                    String s6 = k0.h;
                    q.g(s6, "<set-?>");
                    k1.h = s6;
                    k1.i = k0.i;
                    k1.j = k0.j;
                    String s7 = k0.k;
                    q.g(s7, "<set-?>");
                    k1.k = s7;
                    k1.t = k0.t;
                    k1.u = k0.u;
                    k1.v = k0.v;
                    k1.w = k0.w;
                    k1.l = k0.l;
                    String s8 = k0.o;
                    q.g(s8, "<set-?>");
                    k1.o = s8;
                    String s9 = k0.r;
                    q.g(s9, "<set-?>");
                    k1.r = s9;
                    String s10 = k0.s;
                    q.g(s10, "<set-?>");
                    k1.s = s10;
                    if(StorageUtils.isScopedStorage()) {
                        String s11 = CursorUtil.getAudioContentUri(k1.v).toString();
                        q.f(s11, "toString(...)");
                        k1.c = s11;
                    }
                    arrayList3.add(k1);
                }
                iterator3 = iterator4;
                arrayList0 = arrayList4;
            }
            arrayList5 = arrayList0;
            if(!arrayList3.isEmpty()) {
                f0.m();
                for(Object object5: arrayList3) {
                    g.p(((H8.k)object5));
                }
                H8.i i0 = g.g();
                i0.getClass();
                w.N(((LocalContentDatabase_Impl)i0.b), false, true, new e(i0, arrayList3, 2));
                ArrayList arrayList6 = new ArrayList(je.q.Q(10, arrayList3));
                for(Object object6: arrayList3) {
                    arrayList6.add(((H8.k)object6).a);
                }
                arrayList2.addAll(arrayList6);
                if(!StorageUtils.isScopedStorage()) {
                    for(Object object7: arrayList3) {
                        m.a(((H8.k)object7), "MediaStoreSyncHelper");
                    }
                }
                ArrayList arrayList7 = je.p.Q0(arrayList3);
                while(!arrayList7.isEmpty()) {
                    List list1 = A7.d.p(arrayList7, 50, arrayList7);
                    arrayList7.removeAll(list1);
                    StringBuilder stringBuilder1 = new StringBuilder();
                    stringBuilder1.append("update() items[" + list1.size() + "]");
                    for(Object object8: list1) {
                        i.m(stringBuilder1);
                        stringBuilder1.append("id : " + ((H8.k)object8).a + ", displayName : " + ((H8.k)object8).d);
                    }
                    o.a(stringBuilder1.toString());
                }
            }
            arrayList1.addAll(arrayList2);
        }
        HashMap hashMap3 = hashMap0.isEmpty() ? null : hashMap0;
        if(hashMap3 == null) {
            arrayList12 = arrayList5;
        }
        else {
            ArrayList arrayList8 = new ArrayList();
            LogU.info$default(this.b, x.e(hashMap3.size(), "insert() items: "), null, false, 6, null);
            ArrayList arrayList9 = this.i(context0, hashMap3);
            if(!arrayList9.isEmpty()) {
                f0.m();
                g.o(arrayList9);
                f0.m();
                ArrayList arrayList10 = new ArrayList(je.q.Q(10, arrayList9));
                for(Object object9: arrayList9) {
                    arrayList10.add(((H8.k)object9).b);
                }
                arrayList8.addAll(g.f(arrayList10));
                if(!StorageUtils.isScopedStorage()) {
                    for(Object object10: arrayList9) {
                        m.a(((H8.k)object10), "MediaStoreSyncHelper");
                    }
                }
                ArrayList arrayList11 = je.p.Q0(arrayList9);
                while(!arrayList11.isEmpty()) {
                    List list2 = A7.d.p(arrayList11, 50, arrayList11);
                    arrayList11.removeAll(list2);
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("insert() items[" + list2.size() + "]");
                    for(Object object11: list2) {
                        i.m(stringBuilder2);
                        stringBuilder2.append("displayName : " + ((H8.k)object11).d);
                    }
                    o.a(stringBuilder2.toString());
                }
            }
            arrayList12 = arrayList5;
            arrayList12.addAll(arrayList8);
        }
        if(z) {
            LogU.info$default(this.b, "updateFileMeta() targetList: " + list0.size(), null, false, 6, null);
            long v2 = System.currentTimeMillis();
            ArrayList arrayList13 = new ArrayList();
            ArrayList arrayList14 = new ArrayList(je.q.Q(10, list0));
            for(Object object12: list0) {
                arrayList14.add(i.i(((File)object12)));
            }
            f0.m();
            ArrayList arrayList15 = new ArrayList();
            ArrayList arrayList16 = je.p.Q0(arrayList14);
            while(!arrayList16.isEmpty()) {
                List list3 = A7.d.p(arrayList16, 500, arrayList16);
                arrayList16.removeAll(list3);
                H8.i i1 = g.g();
                i1.getClass();
                StringBuilder stringBuilder3 = Y.p("SELECT _id, data, song_id, match_stat, artists, artist_ids, album, album_key, album_id FROM local_contents WHERE song_id = \'\' and data in (");
                a.a.k(list3.size(), stringBuilder3);
                stringBuilder3.append(")");
                arrayList15.addAll(((List)w.N(((LocalContentDatabase_Impl)i1.b), true, false, new c(stringBuilder3.toString(), 7, list3))));
            }
            for(Object object13: arrayList15) {
                u u0 = (u)object13;
                Song song0 = SongMetaParser.parseMeta(u0.b, null, 2);
                if(song0 != null) {
                    String s12 = song0.b;
                    q.f(s12, "songId");
                    u0.c = s12;
                    u0.d = song0.e;
                    arrayList13.add(u0);
                }
            }
            if(!arrayList13.isEmpty()) {
                LogU.debug$default(this.b, "updateFileMeta() update items : " + arrayList13.size(), null, false, 6, null);
                f0.m();
                g.s(arrayList13);
                ArrayList arrayList17 = je.p.Q0(arrayList13);
                while(!arrayList17.isEmpty()) {
                    List list4 = A7.d.p(arrayList17, 50, arrayList17);
                    arrayList17.removeAll(list4);
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("updateFileMeta() items[" + list4.size() + "]");
                    for(Object object14: list4) {
                        i.m(stringBuilder4);
                        stringBuilder4.append("id : " + ((u)object14).a + ", displayName : " + FilenameUtils.getName(((u)object14).b));
                    }
                    o.a(stringBuilder4.toString());
                }
            }
            LogConstantsKt.debug(this.b, "updateFileMeta() Complete", v2);
        }
        return new p(arrayList12, arrayList1, je.w.a);
    }
}

