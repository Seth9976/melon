package G8;

import android.content.Context;
import android.net.Uri;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.FileUtils;
import java.io.File;
import k8.Y;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.c;

public final class o {
    public final Comparable a(Context context0, String s, long v, String s1, c c0) {
        n n0;
        if(c0 instanceof n) {
            n0 = (n)c0;
            int v1 = n0.B;
            if((v1 & 0x80000000) == 0) {
                n0 = new n(this, c0);
            }
            else {
                n0.B = v1 ^ 0x80000000;
            }
        }
        else {
            n0 = new n(this, c0);
        }
        Uri uri0 = n0.r;
        Comparable comparable0 = a.a;
        switch(n0.B) {
            case 0: {
                d5.n.D(uri0);
                if(context0 == null) {
                    context0 = Y.a(MelonAppBase.Companion);
                }
                String s2 = s1 == null ? "" : s1;
                n0.B = 1;
                if(Tf.o.H0(s) || Tf.o.H0(s2)) {
                    uri0 = null;
                }
                else {
                    String s3 = Tf.o.e1(s2).toString();
                    String s4 = FileUtils.INSTANCE.makeSafeFileNameByMD5(s3);
                    if(s4 == null) {
                        uri0 = null;
                    }
                    else {
                        File file0 = FileUtils.getDiskCacheDir(context0, "albumThumbs");
                        if(!file0.exists()) {
                            file0.mkdirs();
                        }
                        File file1 = new File(file0, s4);
                        Uri uri1 = file1.exists() ? Uri.fromFile(file1) : BuildersKt.withContext(Dispatchers.getIO(), new m(context0, s, v, s4, null), n0);
                        uri0 = uri1;
                    }
                }
                if(uri0 == comparable0) {
                    return comparable0;
                }
                return uri0 == null ? Uri.EMPTY : uri0;
            }
            case 1: {
                d5.n.D(uri0);
                return uri0 == null ? Uri.EMPTY : uri0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

