package I8;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.MediaStore.Audio.Media;
import b3.Z;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import java.util.ArrayList;
import java.util.Collection;

public final class f {
    public final Context a;
    public static final e b;
    public static final LogU c;
    public static f d;

    static {
        f.b = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        LogU logU0 = Z.g("AudioSyncManager", true);
        logU0.setCategory(Category.LocalSync);
        f.c = logU0;
    }

    public f(Context context0) {
        this.a = context0;
        ContentResolver contentResolver0 = context0.getContentResolver();
        HandlerThread handlerThread0 = new HandlerThread("MediaUriContentObserver");
        handlerThread0.start();
        n n0 = new n(context0, new Handler(handlerThread0.getLooper()));
        contentResolver0.registerContentObserver(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, true, n0);
    }

    public static final p a(f f0, boolean z) {
        LogU.info$default(f.c, "syncAll() updateFileMeta: " + z, null, false, 6, null);
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        f0.getClass();
        LogU.info$default(f.c, "syncMediaStore() updateFileMeta: " + z, null, false, 6, null);
        p p0 = j.e.g().d(f0.a, z);
        LogConstantsKt.debug(f.c, "syncMediaStore() Complete", System.currentTimeMillis());
        arrayList0.addAll(((Collection)p0.a));
        arrayList1.addAll(((Collection)p0.b));
        arrayList2.addAll(p0.c);
        LogU.info$default(f.c, "syncMelonMediaStore() updateFileMeta: " + z, null, false, 6, null);
        p p1 = j.c.o().d(f0.a, z);
        LogConstantsKt.debug(f.c, "syncMelonMediaStore() Complete", System.currentTimeMillis());
        arrayList0.addAll(((Collection)p1.a));
        arrayList1.addAll(((Collection)p1.b));
        arrayList2.addAll(p1.c);
        LogConstantsKt.debug(f.c, "syncAll() Complete", System.currentTimeMillis());
        return new p(arrayList0, arrayList1, arrayList2);
    }
}

