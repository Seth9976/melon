package androidx.appcompat.app;

import N1.e;
import Y1.f;
import Y1.g;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import androidx.collection.b;
import com.kakao.emoticon.ui.tab.StoreItem;
import java.lang.ref.WeakReference;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import l.a;
import w4.c;

public final class j implements Runnable {
    public final int a;
    public final Context b;

    public j(Context context0, int v) {
        this.a = v;
        this.b = context0;
        super();
    }

    @Override
    public final void run() {
        f f0;
        switch(this.a) {
            case 0: {
                int v = Build.VERSION.SDK_INT;
                if(v >= 33) {
                    Context context0 = this.b;
                    ComponentName componentName0 = new ComponentName(context0, "androidx.appcompat.app.AppLocalesMetadataHolderService");
                    if(context0.getPackageManager().getComponentEnabledSetting(componentName0) != 1) {
                        if(v >= 33) {
                            Object object0 = null;
                            n.g.getClass();
                            b b0 = new b(n.g);
                            while(b0.hasNext()) {
                                n n0 = (n)((WeakReference)b0.next()).get();
                                if(n0 != null) {
                                    Context context1 = ((D)n0).k;
                                    if(context1 != null) {
                                        object0 = context1.getSystemService("locale");
                                        break;
                                    }
                                }
                            }
                            f0 = object0 == null ? f.b : new f(new g(l.a(object0)));
                        }
                        else {
                            f0 = n.c;
                            if(f0 == null) {
                                f0 = f.b;
                            }
                        }
                        if(f0.a.a.isEmpty()) {
                            String s = e.e(context0);
                            Object object1 = context0.getSystemService("locale");
                            if(object1 != null) {
                                l.b(object1, k.a(s));
                            }
                        }
                        context0.getPackageManager().setComponentEnabledSetting(componentName0, 1, 1);
                    }
                }
                n.f = true;
                return;
            }
            case 1: {
                StoreItem.lambda$doClick$0(this.b);
                return;
            }
            case 2: {
                new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new j(this.b, 3));
                return;
            }
            default: {
                a a0 = new a(1);
                c.t(this.b, a0, c.a, false);
            }
        }
    }
}

