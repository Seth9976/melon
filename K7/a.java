package k7;

import A1.g;
import E5.b;
import android.util.Log;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import e7.h;
import h7.K0;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public final class a {
    public final AtomicInteger a;
    public final FileStore b;
    public final g c;
    public final h d;
    public static final Charset e;
    public static final int f;
    public static final i7.a g;
    public static final E1.a h;
    public static final b i;

    static {
        a.e = Charset.forName("UTF-8");
        a.f = 15;
        a.g = new i7.a();  // 初始化器: Ljava/lang/Object;-><init>()V
        a.h = new E1.a(15);
        a.i = new b(6);
    }

    public a(FileStore fileStore0, g g0, h h0) {
        this.a = new AtomicInteger(0);
        this.b = fileStore0;
        this.c = g0;
        this.d = h0;
    }

    public static void a(List list0) {
        for(Object object0: list0) {
            ((File)object0).delete();
        }
    }

    public final ArrayList b() {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.addAll(FileStore.e(this.b.f.listFiles()));
        arrayList0.addAll(FileStore.e(this.b.g.listFiles()));
        Collections.sort(arrayList0, a.h);
        List list0 = FileStore.e(this.b.e.listFiles());
        Collections.sort(list0, a.h);
        arrayList0.addAll(list0);
        return arrayList0;
    }

    public final NavigableSet c() {
        return new TreeSet(FileStore.e(this.b.d.list())).descendingSet();
    }

    public final void d(K0 k00, String s, boolean z) {
        FileStore fileStore0 = this.b;
        int v = this.c.d().a.a;
        a.g.getClass();
        String s1 = i7.a.a.o(k00);
        Object[] arr_object = {this.a.getAndIncrement()};
        try {
            a.f(fileStore0.b(s, "event" + String.format(Locale.US, "%010d", arr_object) + (z ? "_" : "")), s1);
        }
        catch(IOException iOException0) {
            Log.w("FirebaseCrashlytics", "Could not persist event for session " + s, iOException0);
        }
        b b0 = new b(7);
        fileStore0.getClass();
        File file0 = new File(fileStore0.d, s);
        file0.mkdirs();
        List list0 = FileStore.e(file0.listFiles(b0));
        Collections.sort(list0, new E1.a(16));
        int v1 = list0.size();
        for(Object object0: list0) {
            if(v1 <= v) {
                break;
            }
            FileStore.d(((File)object0));
            --v1;
        }
    }

    public static String e(File file0) {
        byte[] arr_b = new byte[0x2000];
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        try(FileInputStream fileInputStream0 = new FileInputStream(file0)) {
            int v;
            while((v = fileInputStream0.read(arr_b)) > 0) {
                byteArrayOutputStream0.write(arr_b, 0, v);
            }
            return new String(byteArrayOutputStream0.toByteArray(), a.e);
        }
    }

    public static void f(File file0, String s) {
        try(OutputStreamWriter outputStreamWriter0 = new OutputStreamWriter(new FileOutputStream(file0), a.e)) {
            outputStreamWriter0.write(s);
        }
    }
}

