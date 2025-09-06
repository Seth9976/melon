package R8;

import E9.w;
import Eb.d;
import G8.g;
import android.net.Uri;
import com.iloen.melon.database.core.LocalContentDatabase_Impl;
import com.iloen.melon.drm.DcfFile;
import com.iloen.melon.utils.StorageUtils;
import i.n.i.b.a.s.e.i4;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import n3.b;

public final class s extends Thread {
    public final int a;
    public final Object b;

    public s(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super("ExoPlayer:SimpleDecoder");
    }

    public s(ArrayList arrayList0) {
        this.a = 0;
        this.b = arrayList0;
        super();
    }

    @Override
    public final void run() {
        switch(this.a) {
            case 0: {
                g.a.m();
                long v = System.currentTimeMillis();
                for(Object object0: ((ArrayList)this.b)) {
                    DcfFile dcfFile0 = (DcfFile)object0;
                    if(StorageUtils.isScopedStorage()) {
                        String s = (dcfFile0.h == null ? Uri.EMPTY : dcfFile0.h).toString();
                        q.g(s, "uriString");
                        ((Integer)w.N(((LocalContentDatabase_Impl)g.g().b), false, true, new d(v / 1000L, s, 2))).getClass();
                    }
                    else {
                        String s1 = dcfFile0.c();
                        q.g(s1, "path");
                        ((Integer)w.N(((LocalContentDatabase_Impl)g.g().b), false, true, new d(v / 1000L, s1, 1))).getClass();
                    }
                }
                return;
            }
            case 1: {
                b b0 = (b)this.b;
                while(true) {
                    try {
                        if(!b0.e()) {
                            break;
                        }
                    }
                    catch(InterruptedException interruptedException1) {
                        throw new IllegalStateException(interruptedException1);
                    }
                }
                return;
            }
            default: {
                i4 i40 = (i4)this.b;
                while(true) {
                    try {
                        if(!i40.d()) {
                            break;
                        }
                    }
                    catch(InterruptedException interruptedException0) {
                        throw new IllegalStateException(interruptedException0);
                    }
                }
            }
        }
    }
}

