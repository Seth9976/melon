package u9;

import android.content.Context;
import android.os.Environment;
import com.iloen.melon.utils.log.LogU;
import ie.j;
import java.io.File;
import java.util.HashMap;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;

public final class c {
    public static f a(Context context0, String s) {
        switch(s) {
            case "lyric": 
            case "offline": {
                Context context1 = context0.getApplicationContext();
                q.f(context1, "getApplicationContext(...)");
                return new f(context1, s);
            }
            case "mcache": 
            case "streamlyric": {
                Context context2 = context0.getApplicationContext();
                q.f(context2, "getApplicationContext(...)");
                f f0 = new f(context2, s);
                LogU.Companion.i("Storage", "create() path : " + f0.f);
                File file0 = (File)((j)f0.d).getValue();
                q.g(file0, "sourceDirectory");
                if(file0.exists()) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(f.i), null, null, new d(f0, file0, null), 3, null);
                }
                return f0;
            }
            default: {
                throw new IllegalArgumentException("Invalid storage name.");
            }
        }
    }

    public final f b(Context context0, String s) {
        q.g(context0, "context");
        HashMap hashMap0 = f.h;
        f f0 = (f)hashMap0.get(s);
        if(f0 == null) {
            synchronized(this) {
                f f1 = (f)hashMap0.get(s);
                if(f1 == null) {
                    f1 = c.a(context0, s);
                    hashMap0.put(s, f1);
                }
                return f1;
            }
        }
        return f0;
    }

    public static File c() {
        return new File(Environment.getExternalStorageDirectory(), "melon");
    }
}

