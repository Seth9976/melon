package u9;

import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import ie.H;
import ie.j;
import java.io.File;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class e extends i implements n {
    public final f r;

    public e(f f0, Continuation continuation0) {
        this.r = f0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new e(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((e)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        boolean z;
        d5.n.D(object0);
        f f0 = this.r;
        LogU.info$default(f0.c, "migrateUsingCopy() " + f0.b, null, false, 6, null);
        long v = System.currentTimeMillis();
        if(!MelonPrefs.getInstance().getBoolean("lyricMigration", false)) {
            try {
                File[] arr_file = ((File)((j)f0.d).getValue()).listFiles();
                if(arr_file == null) {
                    z = true;
                }
                else {
                    z = true;
                    for(int v1 = 0; v1 < arr_file.length; ++v1) {
                        File file0 = arr_file[v1];
                        File file1 = new File(f0.a(), file0.getName());
                        if(!file1.exists()) {
                            try {
                                te.j.y(file0, file1, false, 6);
                            }
                            catch(Exception unused_ex) {
                                z = false;
                            }
                        }
                    }
                }
                if(z) {
                    MelonPrefs.getInstance().setBoolean("lyricMigration", true);
                }
            }
            catch(Exception exception0) {
                LogU.error$default(f0.c, "migrateUsingCopy() error : " + exception0.getMessage(), null, false, 6, null);
            }
        }
        LogConstantsKt.debug(f0.c, "migrateUsingCopy task completed", v);
        return H.a;
    }
}

