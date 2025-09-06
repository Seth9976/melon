package I8;

import A7.d;
import Cc.K1;
import DigiCAP.SKT.DRM.DrmInitException;
import DigiCAP.SKT.DRM.MelonDRMMetaInterface;
import G8.g;
import H8.c;
import H8.e;
import H8.k;
import R8.r;
import S8.b;
import U4.x;
import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.database.core.LocalContentDatabase_Impl;
import com.iloen.melon.eventbus.EventAudioSync.Finish;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.playback.TaskUpdateLocalPlaylists;
import com.iloen.melon.types.Song;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.FilenameUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.SongMetaParser;
import e1.G;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import je.w;
import k8.Y;
import kotlin.jvm.internal.q;
import u9.a;
import z6.f;

public final class i extends j {
    @Override  // I8.o
    public final void b(Song song0) {
        LogU.info$default(this.b, "insertOrUpdate() song : " + song0.b, null, false, 6, null);
        try {
            this.l(song0);
            LogConstantsKt.debug(this.b, "insertOrUpdate() Complete", System.currentTimeMillis());
        }
        catch(Exception exception0) {
            LogU.error$default(this.b, "insertOrUpdate() Error", exception0, false, 4, null);
        }
    }

    @Override  // I8.j
    public final p e(Context context0, List list0) {
        q.g(context0, "context");
        return p.d;
    }

    @Override  // I8.j
    public final p f(Context context0, boolean z) {
        LogU.info$default(this.b, "syncImpl() Start full sync, updateFileMeta: " + z, null, false, 6, null);
        a a0 = a.c.o("dcf");
        boolean z1 = a0.c();
        w w0 = w.a;
        f f0 = g.a;
        if(!z1) {
            LogU.warn$default(this.b, "syncImpl() Check saf storage permission.", null, false, 6, null);
            f0.m();
            List list0 = (List)E9.w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new K1(22));
            f0.m();
            g.b(list0);
            return new p(w0, w0, list0);
        }
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        long v = System.currentTimeMillis();
        ArrayList arrayList2 = new ArrayList();
        f0.m();
        arrayList2.addAll(g.e());
        ArrayList arrayList3 = new ArrayList();
        for(Object object0: arrayList2) {
            k k0 = (k)object0;
            if(k0.c.length() != 0) {
                Uri uri0 = Uri.parse(k0.c);
                q.f(uri0, "parse(...)");
                Context context1 = Y.a(MelonAppBase.Companion);
                if(DocumentsContract.isDocumentUri(context1, uri0)) {
                    r2.a a1 = r2.a.d(context1, uri0);
                    if(!a1.c() || !a1.a() || !a1.b()) {
                        goto label_30;
                    }
                    continue;
                }
            }
        label_30:
            arrayList3.add(object0);
        }
        if(arrayList3.isEmpty()) {
            arrayList3 = null;
        }
        if(arrayList3 != null) {
            f0.m();
            H8.i i0 = g.g();
            i0.getClass();
            E9.w.N(((LocalContentDatabase_Impl)i0.b), false, true, new e(i0, arrayList3, 0));
            arrayList2.removeAll(arrayList3);
            ArrayList arrayList4 = new ArrayList(je.q.Q(10, arrayList3));
            for(Object object1: arrayList3) {
                arrayList4.add(((k)object1).a);
            }
            arrayList1.addAll(arrayList4);
            ArrayList arrayList5 = new ArrayList(je.q.Q(10, arrayList3));
            for(Object object2: arrayList3) {
                arrayList5.add(((k)object2).a);
            }
            ArrayList arrayList6 = je.p.Q0(arrayList5);
            while(!arrayList6.isEmpty()) {
                List list1 = d.p(arrayList6, 50, arrayList6);
                arrayList6.removeAll(list1);
                o.a(("syncImpl() delete items[" + list1.size() + "] : { " + je.p.q0(list1, null, null, null, null, 0x3F) + " }"));
            }
        }
        if(z) {
            ArrayList arrayList7 = new ArrayList();
            i.m(arrayList7, a0.a());
            ArrayList arrayList8 = new ArrayList();
            Iterator iterator3 = arrayList7.iterator();
        label_64:
            while(iterator3.hasNext()) {
                Object object3 = iterator3.next();
                r2.a a2 = (r2.a)object3;
                if(!arrayList2.isEmpty()) {
                    for(Object object4: arrayList2) {
                        if(q.b(Uri.parse(((k)object4).c), a2.f())) {
                            continue label_64;
                        }
                        if(false) {
                            break;
                        }
                    }
                }
                arrayList8.add(object3);
            }
            if(arrayList8.isEmpty()) {
                arrayList8 = null;
            }
            if(arrayList8 != null) {
                LogU.info$default(this.b, x.e(arrayList8.size(), "syncImpl() insert items : "), null, false, 6, null);
                ArrayList arrayList9 = new ArrayList();
                for(Object object5: arrayList8) {
                    k k1 = this.k(context0, ((r2.a)object5), SongMetaParser.parseDcfMeta(((r2.a)object5).f(), null));
                    if(k1 != null) {
                        arrayList9.add(k1);
                    }
                }
                if(!arrayList9.isEmpty()) {
                    f0.m();
                    g.o(arrayList9);
                }
                f0.m();
                ArrayList arrayList10 = new ArrayList(je.q.Q(10, arrayList8));
                for(Object object6: arrayList8) {
                    Uri uri1 = ((r2.a)object6).f();
                    q.f(uri1, "getUri(...)");
                    arrayList10.add(uri1);
                }
                ArrayList arrayList11 = new ArrayList();
                ArrayList arrayList12 = new ArrayList(je.q.Q(10, arrayList10));
                for(Object object7: arrayList10) {
                    arrayList12.add(((Uri)object7).toString());
                }
                ArrayList arrayList13 = je.p.Q0(arrayList12);
                while(!arrayList13.isEmpty()) {
                    List list2 = d.p(arrayList13, 500, arrayList13);
                    arrayList13.removeAll(list2);
                    H8.i i1 = g.g();
                    i1.getClass();
                    StringBuilder stringBuilder0 = Y.p("SELECT _id FROM local_contents WHERE uri in (");
                    a.a.k(list2.size(), stringBuilder0);
                    stringBuilder0.append(")");
                    arrayList11.addAll(((List)E9.w.N(((LocalContentDatabase_Impl)i1.b), true, false, new c(stringBuilder0.toString(), 9, list2))));
                }
                arrayList0.addAll(arrayList11);
                ArrayList arrayList14 = je.p.Q0(arrayList8);
                while(!arrayList14.isEmpty()) {
                    List list3 = d.p(arrayList14, 50, arrayList14);
                    arrayList14.removeAll(list3);
                    StringBuilder stringBuilder1 = new StringBuilder();
                    stringBuilder1.append("syncImpl() insert items[" + list3.size() + "]");
                    for(Object object8: list3) {
                        Cb.i.m(stringBuilder1);
                        stringBuilder1.append("displayName : " + ((r2.a)object8).e());
                    }
                    o.a(stringBuilder1.toString());
                }
            }
        }
        p p0 = new p(arrayList0, w0, arrayList1);
        LogConstantsKt.debug(this.b, "syncImpl() Complete. " + p0, v);
        return p0;
    }

    public final k k(Context context0, r2.a a0, Song song0) {
        R8.o o0;
        int v10;
        int v9;
        String s9;
        int v5;
        int v4;
        String s5;
        int v3;
        String s4;
        String s3;
        String s2;
        String s1;
        String s;
        int v2;
        r2.a a2;
        b b0;
        Uri uri0 = a0.f();
        q.f(uri0, "getUri(...)");
        if(DocumentsContract.isDocumentUri(context0, uri0)) {
            r2.a a1 = r2.a.d(context0, uri0);
            try {
                b0 = b.b("scanner");
                long v = MelonDRMMetaInterface.DRMMetaSetClientID(r.a(MelonAppBase.instance.getDeviceData().h()));
                if(v < 0L) {
                    LogU.w("DrmHelper", "Failure, setClientId, result = " + v);
                    a2 = a1;
                    o0 = null;
                }
                else {
                    goto label_20;
                }
            }
            catch(DrmInitException drmInitException0) {
                a2 = a1;
                drmInitException0.printStackTrace();
                o0 = null;
            }
            goto label_120;
            try {
            label_20:
                LogU.d("DrmHelper", "getDcfMeta() " + uri0);
                LogU.d("DrmMetaWrapper", "uri open = " + uri0);
                v2 = MelonDRMMetaInterface.DRMMetaOpen(context0, uri0, 3, 1);
                if(v2 > 0) {
                    s = MelonDRMMetaInterface.DRMMetaGetUnsupportedValueUTF8(v2, "Title");
                    s1 = MelonDRMMetaInterface.DRMMetaGetUnsupportedValueUTF8(v2, "X-Artist");
                    s2 = MelonDRMMetaInterface.DRMMetaGetUnsupportedValueUTF8(v2, "X-Album");
                    s3 = MelonDRMMetaInterface.DRMMetaGetUnsupportedValueUTF8(v2, "X-Genre");
                    s4 = MelonDRMMetaInterface.DRMMetaGetUnsupportedValueUTF8(v2, "X-TrackNum");
                    if(TextUtils.isEmpty(s4)) {
                        goto label_37;
                    }
                    else {
                        v3 = Integer.parseInt(s4);
                    }
                    goto label_38;
                }
                else {
                    goto label_107;
                }
                goto label_120;
            }
            catch(Exception exception0) {
                a2 = a1;
                o0 = null;
                LogU.d("DrmHelper", "ee = " + exception0.toString());
                goto label_120;
            }
            finally {
                b0.e();
            }
            try {
                v3 = Integer.parseInt(s4);
                goto label_38;
            }
            catch(Exception exception0) {
                a2 = a1;
                o0 = null;
                LogU.d("DrmHelper", "ee = " + exception0.toString());
                goto label_120;
            }
        label_37:
            v3 = 0;
            try {
            label_38:
                a2 = a1;
                byte[] arr_b = MelonDRMMetaInterface.DRMMetaGetMetaTextValueFromID3UTF8(v2, "TPOS");
                a2 = a1;
                if(arr_b == null) {
                    LogU.d("DrmHelper", "Failure, get TPOS.");
                    s5 = s1;
                }
                else {
                    s5 = s1;
                    String s6 = new String(arr_b, "euc-kr");
                    if(TextUtils.isEmpty(s6)) {
                        v4 = 0;
                    }
                    else {
                        LogU.e("DrmHelper", "TPOS = " + s6);
                        v4 = Integer.parseInt(s6);
                    }
                    if(v4 > 0) {
                        v3 += v4 * 1000;
                    }
                }
                byte[] arr_b1 = MelonDRMMetaInterface.DRMMetaGetMetaTextValueFromID3UTF8(v2, "TYER");
                if(arr_b1 == null) {
                    LogU.d("DrmHelper", "Failure, get TYER.");
                    v5 = 0;
                }
                else {
                    String s7 = new String(arr_b1, "euc-kr");
                    v5 = TextUtils.isEmpty(s7) ? 0 : StringUtils.getNumberFromString(s7);
                }
                String s8 = MelonDRMMetaInterface.DRMMetaGetUnsupportedValueUTF8(v2, "Length");
                if(TextUtils.isEmpty(s8)) {
                    s9 = s2;
                    v10 = 0;
                }
                else {
                    int v6 = s8.indexOf(":");
                    if(v6 > 0) {
                        int v7 = s8.indexOf(":", v6 + 1);
                        if(v7 > 0) {
                            s9 = s2;
                            int v8 = Integer.parseInt(s8.substring(0, v6));
                            v9 = Integer.parseInt(s8.substring(v6 + 1, v7)) * 60 + v8 * 3600 + Integer.parseInt(s8.substring(v7 + 1));
                        }
                        else {
                            s9 = s2;
                            v9 = 0;
                        }
                    }
                    else {
                        s9 = s2;
                        v9 = 0;
                    }
                    v10 = v9 * 1000;
                }
                o0 = new R8.o();  // 初始化器: Ljava/lang/Object;-><init>()V
                goto label_87;
            }
            catch(Exception exception0) {
            }
            o0 = null;
            LogU.d("DrmHelper", "ee = " + exception0.toString());
            goto label_120;
            try {
            label_87:
                String s10 = "<unknown>";
                o0.a = uri0;
                o0.b = s;
                String s11 = TextUtils.isEmpty(s5) ? "<unknown>" : s5;
                o0.c = s11;
                if(!TextUtils.isEmpty(s9)) {
                    s10 = s9;
                }
                o0.d = s10;
                o0.e = s3;
                o0.h = v3;
                o0.i = v5;
                o0.j = v10;
                LogU.i("DrmHelper", "extracted: " + o0.toString());
                MelonDRMMetaInterface.DRMMetaClose(((short)v2));
            }
            catch(Exception exception0) {
                LogU.d("DrmHelper", "ee = " + exception0.toString());
            }
            goto label_120;
            try {
            label_107:
                LogU.d("DrmHelper", "Failure, load content, fd = " + v2);
            }
            catch(Exception exception0) {
                a2 = a1;
                o0 = null;
                LogU.d("DrmHelper", "ee = " + exception0.toString());
                goto label_120;
            }
            a2 = a1;
            o0 = null;
        label_120:
            if(o0 == null) {
                LogU.e("DrmHelper", "getDcfMeta() Not found dcf meta");
                o0 = null;
            }
            else {
                o0.k = a2.h();
                o0.g = 1;
                o0.f = "audio/x-mp3";
                if(o0.b == null || TextUtils.isEmpty(o0.b.trim())) {
                    String s12 = a2.e();
                    int v11 = s12.lastIndexOf(46);
                    if(v11 > 0) {
                        s12 = s12.substring(0, v11);
                    }
                    o0.b = s12;
                }
            }
        }
        else {
            LogU.e("DrmHelper", "getDcfMeta() Invalid uri : " + uri0);
            o0 = null;
        }
        if(o0 == null) {
            LogU.error$default(this.b, "createLocalContentEntity() Failed to get meta", null, false, 6, null);
            return null;
        }
        k k0 = new k();
        long v12 = System.currentTimeMillis();
        String s13 = uri0.toString();
        q.f(s13, "toString(...)");
        k0.c = s13;
        k0.g = a0.h();
        String s14 = a0.e();
        if(s14 != null) {
            k0.d = s14;
        }
        k0.l = o0.j;
        k0.t = o0.h;
        k0.u = o0.i;
        String s15 = o0.f;
        if(s15 != null) {
            k0.h = s15;
        }
        String s16 = o0.b;
        if(s16 != null) {
            k0.k = s16;
        }
        String s17 = o0.c;
        if(s17 != null) {
            k0.m = s17;
        }
        String s18 = o0.d;
        if(s18 != null) {
            k0.o = s18;
        }
        String s19 = o0.e;
        if(s19 != null) {
            k0.r = s19;
        }
        if(song0 != null) {
            String s20 = song0.b;
            q.f(s20, "songId");
            k0.e = s20;
            k0.f = song0.e;
        }
        k0.i = v12 / 1000L;
        k0.j = v12 / 1000L;
        return k0;
    }

    public final void l(Song song0) {
        k k0;
        Uri uri0 = song0.j;
        f f0 = g.a;
        f0.m();
        q.d(uri0);
        String s = null;
        if(!g.c(uri0)) {
            LogU.debug$default(this.b, "insertOrUpdateImpl() insert item : " + song0.b, null, false, 6, null);
            Context context0 = Y.a(MelonAppBase.Companion);
            if(DocumentsContract.isDocumentUri(context0, uri0)) {
                r2.a a0 = r2.a.d(context0, uri0);
                if(!a0.a() || !a0.b()) {
                    LogU.error$default(this.b, "createLocalContentEntity() Not found document file", null, false, 6, null);
                    k0 = null;
                }
                else {
                    k0 = this.k(context0, a0, song0);
                }
            }
            else {
                LogU.error$default(this.b, "createLocalContentEntity() Invalid uri", null, false, 6, null);
                k0 = null;
            }
            if(k0 == null) {
                LogU.error$default(this.b, "insert() Failed  to create entity", null, false, 6, null);
            }
            else {
                f0.m();
                g.n(k0);
                EventBusHelper.post(new Finish(4, 1));
            }
        }
        f0.m();
        k k1 = g.j(uri0);
        if(k1 != null) {
            String s1 = song0.b;
            q.f(s1, "songId");
            k1.e = s1;
            k1.f = song0.e;
            String s2 = song0.g;
            q.f(s2, "albumId");
            k1.q = s2;
            if((StringIds.b(song0.h) ? null : song0.h) != null) {
                q.f("", "toString(...)");
                k1.n = "";
            }
            String s3 = song0.i;
            q.d(s3);
            if(s3.length() > 0) {
                s = s3;
            }
            if(s != null) {
                k1.m = s;
            }
            f0.m();
            g.q(k1);
            new TaskUpdateLocalPlaylists().updateFromLocalContentEntityAsync(k1);
            o.a(("insertOrUpdateImpl() id : " + k1.a + ", displayName : " + k1.d));
            return;
        }
        o.a(("insertOrUpdateImpl() Not found local content, songId : " + song0.b));
        throw new IllegalStateException("Not found local content, songId : " + song0.b);
    }

    public static void m(ArrayList arrayList0, r2.a a0) {
        boolean z;
        if(a0 != null) {
            if(a0.g()) {
                r2.a[] arr_a = a0.i();
                q.f(arr_a, "listFiles(...)");
                for(int v = 0; v < arr_a.length; ++v) {
                    i.m(arrayList0, arr_a[v]);
                }
                return;
            }
            if(a0.c()) {
                if(a0.a == 0) {
                    String s1 = G.z(a0.b, a0.c, "mime_type");
                    z = !"vnd.android.document/directory".equals(s1) && !TextUtils.isEmpty(s1);
                }
                else {
                    String s = G.z(a0.b, a0.c, "mime_type");
                    z = "vnd.android.document/directory".equals(s) || TextUtils.isEmpty(s) ? false : true;
                }
                if(z && FilenameUtils.isDcf(a0.e())) {
                    arrayList0.add(a0);
                }
            }
        }
    }
}

