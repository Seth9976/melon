package u9;

import H0.b;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import java.io.File;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import te.j;
import we.n;

public final class d extends i implements n {
    public final f r;
    public final File w;

    public d(f f0, File file0, Continuation continuation0) {
        this.r = f0;
        this.w = file0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new d(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((d)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        f f0 = this.r;
        LogU.info$default(f0.c, "migrate() " + f0.b, null, false, 6, null);
        long v = System.currentTimeMillis();
        File file0 = this.w;
        File[] arr_file = file0.listFiles();
        if(arr_file != null) {
            for(int v1 = 0; v1 < arr_file.length; ++v1) {
                File file1 = arr_file[v1];
                q.d(file1);
                File file2 = new File(f0.a(), file1.getName());
                try {
                    if(!file2.exists() && !file1.renameTo(file2)) {
                        j.y(file1, file2, false, 4);
                    }
                }
                catch(Exception exception0) {
                    b.w("safetyMigrate() error : ", exception0.getMessage(), LogU.Companion, "Storage");
                }
            }
        }
        j.z(file0);
        LogConstantsKt.debug(f0.c, "Migration task completed", v);
        return H.a;
    }
}

