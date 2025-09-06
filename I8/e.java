package I8;

import android.content.Context;
import com.iloen.melon.utils.FilenameUtils;
import com.iloen.melon.utils.log.DevLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

public final class e {
    // 去混淆评级： 低(20)
    public static boolean a() {
        return j.e.g().a.get() || j.c.o().a.get();
    }

    public static Job b(Context context0, String s, boolean z) {
        q.g(context0, "context");
        return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new c(context0, z, s, null), 3, null);
    }

    public static void c(Context context0, List list0) {
        q.g(context0, "context");
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            if(FilenameUtils.isMusic(((File)object0).getName(), R8.q.a.c())) {
                arrayList0.add(object0);
            }
        }
        if(!arrayList0.isEmpty()) {
            p p0 = j.e.g().c(context0, list0);
            if(p0.a() > 0) {
                DevLog.Companion.get("Local Audio").put("syncImmediately(mediaStore fileList : " + list0.size() + "), " + p0 + " ");
            }
        }
        if(R8.q.a.c()) {
            ArrayList arrayList1 = new ArrayList();
            for(Object object1: list0) {
                if(FilenameUtils.isDcf(((File)object1).getName())) {
                    arrayList1.add(object1);
                }
            }
            if(!arrayList1.isEmpty()) {
                p p1 = j.c.o().c(context0, list0);
                if(p1.a() > 0) {
                    DevLog.Companion.get("Local Audio").put("syncImmediately(dcf fileList : " + list0.size() + "), " + p1 + " ");
                }
            }
        }
    }
}

