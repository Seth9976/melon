package I8;

import A7.d;
import Cb.i;
import H0.b;
import H8.e;
import H8.k;
import android.content.Context;
import android.os.RemoteException;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.database.core.LocalContentDatabase_Impl;
import com.iloen.melon.mediastore.MelonMediaScanner;
import com.iloen.melon.playback.TaskUpdateLocalPlaylists;
import com.iloen.melon.types.Song;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.FilenameUtils;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import je.w;
import k8.Y;
import kotlin.jvm.internal.q;
import u9.c;
import z6.f;

public final class h extends j {
    public final File g;
    public final g h;

    public h() {
        super(0);
        this.g = c.c();
        this.h = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
        LogU.info$default(this.b, "DcfSyncForLegacy.int()", null, false, 6, null);
    }

    @Override  // I8.o
    public final void b(Song song0) {
        synchronized(this) {
            LogU.info$default(this.b, "insertOrUpdate() song : " + song0.b, null, false, 6, null);
            try {
                this.l(song0);
                LogConstantsKt.debug(this.b, "insertOrUpdate() Complete", System.currentTimeMillis());
            }
            catch(Exception exception0) {
                LogU.error$default(this.b, "insertOrUpdate() Error", exception0, false, 4, null);
            }
        }
    }

    @Override  // I8.j
    public final p e(Context context0, List list0) {
        synchronized(this) {
            q.g(context0, "context");
            return this.n(context0, list0, true);
        }
    }

    @Override  // I8.j
    public final p f(Context context0, boolean z) {
        synchronized(this) {
            return this.n(context0, w.a, z);
        }
    }

    public final void k(Context context0, File file0) {
        if(!file0.exists()) {
            LogU.error$default(this.b, "insert() Not found drm file.", null, false, 6, null);
            return;
        }
        MelonMediaScanner melonMediaScanner0 = new MelonMediaScanner(context0);
        String s = i.i(file0);
        try {
            melonMediaScanner0.a();
            melonMediaScanner0.b(s);
            File file1 = new File(s);
            long v = file1.lastModified();
            long v1 = file1.length();
            i9.g.a(melonMediaScanner0.h, s, v / 1000L, v1);
        }
        catch(RemoteException remoteException0) {
            LogU.e("MelonMediaScanner", "RemoteException in MediaScanner.scanFile()", remoteException0);
        }
        catch(Exception exception0) {
            b.v(exception0, new StringBuilder("scanSingleFile() - Exception :"), "MelonMediaScanner");
        }
    }

    public final void l(Song song0) {
        f f0 = G8.g.a;
        f0.m();
        String s = song0.a;
        q.f(s, "path");
        if(!G8.g.d(s)) {
            LogU.debug$default(this.b, "insertOrUpdateImpl() insert item : " + song0.b, null, false, 6, null);
            this.k(Y.a(MelonAppBase.Companion), new File(s));
        }
        f0.m();
        q.f(s, "path");
        k k0 = G8.g.k(s);
        if(k0 != null) {
            String s1 = song0.b;
            q.f(s1, "songId");
            k0.e = s1;
            k0.f = song0.e;
            k0.b = s;
            String s2 = song0.g;
            q.f(s2, "albumId");
            k0.q = s2;
            StringIds stringIds0 = song0.h;
            String s3 = null;
            if(StringIds.b(stringIds0)) {
                stringIds0 = null;
            }
            if(stringIds0 != null) {
                q.f("", "toString(...)");
                k0.n = "";
            }
            String s4 = song0.i;
            q.d(s4);
            if(s4.length() > 0) {
                s3 = s4;
            }
            if(s3 != null) {
                k0.m = s3;
            }
            f0.m();
            G8.g.q(k0);
            new TaskUpdateLocalPlaylists().updateFromLocalContentEntityAsync(k0);
            o.a(("insertOrUpdateImpl() id : " + k0.a + ", displayName : " + k0.d));
            return;
        }
        o.a(("insertOrUpdateImpl() Not found local content, songId : " + song0.b));
        throw new IllegalStateException("Not found local content, songId : " + song0.b);
    }

    public static void m(ArrayList arrayList0, FileFilter fileFilter0, File file0) {
        if(file0.isDirectory()) {
            File[] arr_file = file0.listFiles(fileFilter0);
            if(arr_file != null) {
                for(int v = 0; v < arr_file.length; ++v) {
                    File file1 = arr_file[v];
                    q.d(file1);
                    h.m(arrayList0, fileFilter0, file1);
                }
            }
        }
        else if(fileFilter0.accept(file0)) {
            arrayList0.add(file0);
        }
    }

    public final p n(Context context0, List list0, boolean z) {
        List list4;
        List list1;
        long v = System.currentTimeMillis();
        StringBuilder stringBuilder0 = new StringBuilder("syncImpl() Start ");
        if(list0.isEmpty()) {
            stringBuilder0.append("full sync, ");
        }
        else {
            stringBuilder0.append("target file sync " + list0.size() + ", ");
        }
        stringBuilder0.append("updateFileMeta : " + z);
        LogU.info$default(this.b, stringBuilder0.toString(), null, false, 6, null);
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        f f0 = G8.g.a;
        if(list0.isEmpty()) {
            f0.m();
            list1 = G8.g.e();
        }
        else {
            f0.m();
            ArrayList arrayList3 = new ArrayList();
            for(Object object0: list0) {
                if(FilenameUtils.isDcf(((File)object0).getName())) {
                    arrayList3.add(object0);
                }
            }
            ArrayList arrayList4 = new ArrayList(je.q.Q(10, arrayList3));
            for(Object object1: arrayList3) {
                arrayList4.add(i.i(((File)object1)));
            }
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = je.p.Q0(arrayList4);
            while(!arrayList6.isEmpty()) {
                List list2 = d.p(arrayList6, 500, arrayList6);
                arrayList6.removeAll(list2);
                arrayList5.addAll(G8.g.g().u(list2));
            }
            list1 = arrayList5;
        }
        arrayList2.addAll(list1);
        ArrayList arrayList7 = new ArrayList();
        for(Object object2: arrayList2) {
            if(!new File(((k)object2).b).exists()) {
                arrayList7.add(object2);
            }
        }
        if(arrayList7.isEmpty()) {
            arrayList7 = null;
        }
        if(arrayList7 != null) {
            f0.m();
            H8.i i0 = G8.g.g();
            i0.getClass();
            E9.w.N(((LocalContentDatabase_Impl)i0.b), false, true, new e(i0, arrayList7, 0));
            arrayList2.removeAll(arrayList7);
            ArrayList arrayList8 = new ArrayList(je.q.Q(10, arrayList7));
            for(Object object3: arrayList7) {
                arrayList8.add(((k)object3).a);
            }
            arrayList1.addAll(arrayList8);
            ArrayList arrayList9 = new ArrayList(je.q.Q(10, arrayList7));
            for(Object object4: arrayList7) {
                arrayList9.add(((k)object4).a);
            }
            ArrayList arrayList10 = je.p.Q0(arrayList9);
            while(!arrayList10.isEmpty()) {
                List list3 = d.p(arrayList10, 50, arrayList10);
                arrayList10.removeAll(list3);
                o.a(("syncImpl() delete items[" + list3.size() + "] : { " + je.p.q0(list3, null, null, null, null, 0x3F) + " }"));
            }
        }
        if(z) {
            if(list0.isEmpty()) {
                list4 = new ArrayList();
                h.m(((ArrayList)list4), this.h, this.g);
            }
            else {
                list4 = list0;
            }
            ArrayList arrayList11 = new ArrayList();
            Iterator iterator5 = list4.iterator();
        label_81:
            while(iterator5.hasNext()) {
                Object object5 = iterator5.next();
                File file0 = (File)object5;
                if(!arrayList2.isEmpty()) {
                    for(Object object6: arrayList2) {
                        if(q.b(((k)object6).b, i.i(file0))) {
                            continue label_81;
                        }
                        if(false) {
                            break;
                        }
                    }
                }
                arrayList11.add(object5);
            }
            ArrayList arrayList12 = arrayList11.isEmpty() ? null : arrayList11;
            if(arrayList12 != null) {
                for(Object object7: arrayList12) {
                    this.k(context0, ((File)object7));
                }
                f0.m();
                ArrayList arrayList13 = new ArrayList(je.q.Q(10, arrayList12));
                for(Object object8: arrayList12) {
                    arrayList13.add(i.i(((File)object8)));
                }
                arrayList0.addAll(G8.g.f(arrayList13));
                ArrayList arrayList14 = je.p.Q0(arrayList12);
                while(!arrayList14.isEmpty()) {
                    List list5 = d.p(arrayList14, 50, arrayList14);
                    arrayList14.removeAll(list5);
                    StringBuilder stringBuilder1 = new StringBuilder();
                    stringBuilder1.append("syncImpl() insert items[" + list5.size() + "]");
                    for(Object object9: list5) {
                        i.m(stringBuilder1);
                        stringBuilder1.append("displayName : " + FilenameUtils.getName(i.i(((File)object9))));
                    }
                    o.a(stringBuilder1.toString());
                }
            }
        }
        p p0 = new p(arrayList0, w.a, arrayList1);
        LogConstantsKt.debug(this.b, "syncImpl() Complete. " + p0, v);
        return p0;
    }
}

