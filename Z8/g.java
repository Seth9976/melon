package Z8;

import Ac.X3;
import E9.t;
import R6.c;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.D;
import androidx.lifecycle.f;
import androidx.media3.session.a0;
import com.gaa.sdk.auth.d;
import com.gaa.sdk.iap.e;
import com.gaa.sdk.iap.i;
import com.gaa.sdk.iap.j;
import com.gaa.sdk.iap.k;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v6x.request.OneStoreIapPurchaseReq;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.billing.SingleLiveEvent;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import y5.a;

public final class g implements f {
    public final MelonAppBase a;
    public j b;
    public d c;
    public final SingleLiveEvent d;
    public final SingleLiveEvent e;
    public h f;
    public boolean g;
    public boolean h;
    public static final c i;
    public static volatile g j;

    static {
        g.i = new c(12);
    }

    public g(MelonAppBase melonAppBase0) {
        this.a = melonAppBase0;
        this.d = new SingleLiveEvent();
        this.e = new SingleLiveEvent();
    }

    public static final CompletableDeferred a(g g0) {
        com.gaa.sdk.iap.d d0;
        int v;
        g0.getClass();
        CompletableDeferred completableDeferred0 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        j j0 = g0.d();
        X3 x30 = new X3(completableDeferred0, 22);
        boolean z = false;
        if(!j0.c()) {
            z = true;
            v = 1007;
        }
        else if(TextUtils.isEmpty("inapp")) {
            z = true;
            a.Y("PurchaseClientImpl", "Please provide a valid Product type.");
            v = 1003;
        }
        if(z) {
            d0 = B.a.Z(v);
            x30.e(d0, null);
            return completableDeferred0;
        }
        e e0 = new e(0, j0, x30);
        t t0 = new t(j0, x30);
        if(j0.j.f(e0, 30000L, t0) == null) {
            d0 = j0.b();
            x30.e(d0, null);
            return completableDeferred0;
        }
        return completableDeferred0;
    }

    public final void b(we.a a0) {
        int v1;
        com.gaa.sdk.iap.d d1;
        if(this.g) {
            a0.invoke();
            return;
        }
        Bc.d d0 = new Bc.d(13, a0);
        j j0 = this.d();
        Z8.e e0 = new Z8.e(this, d0);
        String s = j0.h;
        Context context0 = j0.b;
        if(j0.c()) {
            a.X("PurchaseClientImpl", "Service connection is valid. No need to re-initialize.");
            d1 = B.a.Z(0);
            e0.a(d1);
            return;
        }
        int v = j0.a;
        if(v == 1) {
            a.Y("PurchaseClientImpl", "Client is already in the process of connecting to purchasing service.");
            v1 = 5;
            d1 = B.a.Z(v1);
            e0.a(d1);
            return;
        }
        if(v == 3) {
            a.Y("PurchaseClientImpl", "Client was already closed and can\'t be reused. Please create another instance.");
            e0.a(B.a.Z(1009));
        }
        String s1 = (String)j0.i.a.a;
        if(!ye.a.K(context0, s1)) {
            v1 = 1010;
            d1 = B.a.Z(v1);
            e0.a(d1);
            return;
        }
        j0.a = 1;
        com.gaa.sdk.iap.a a1 = (com.gaa.sdk.iap.a)j0.e.c;
        Context context1 = (Context)j0.e.b;
        if(!a1.b) {
            IntentFilter intentFilter0 = new IntentFilter("com.gaa.extern.iap.PURCHASES_UPDATED");
            if(Build.VERSION.SDK_INT >= 33) {
                context1.registerReceiver(a1, intentFilter0, 2);
            }
            else {
                context1.registerReceiver(a1, intentFilter0);
            }
            a1.b = true;
        }
        a.X("PurchaseClientImpl", "Starting in-app purchase client setup.");
        j0.g = new i(j0, e0);
        try {
            Intent intent0 = new Intent("com.gaa.extern.iap.GlobalInAppService.ACTION");
            intent0.setPackage(s1);
            intent0.putExtra("inAppSdkLibraryVersion", s);
            ResolveInfo resolveInfo0 = ye.a.S(context0, intent0);
            ComponentName componentName0 = new ComponentName(resolveInfo0.serviceInfo.packageName, resolveInfo0.serviceInfo.name);
            Intent intent1 = new Intent(intent0);
            intent1.setComponent(componentName0);
            intent1.putExtra("inAppSdkLibraryVersion", s);
            if(context0.bindService(intent1, j0.g, 1)) {
                a.X("PurchaseClientImpl", "Service was bonded successfully.");
                return;
            }
            j0.a = 0;
            a.Y("PurchaseClientImpl", "Connection to Purchase service is blocked.");
            e0.a(B.a.Z(3));
            return;
        }
        catch(com.gaa.sdk.base.e e1) {
        }
        catch(SecurityException unused_ex) {
            goto label_60;
        }
        catch(Exception exception0) {
            goto label_65;
        }
        j0.a = 0;
        a.Y("PurchaseClientImpl", "Purchase service unavailable on device. : " + e1.a);
        int v2 = 11;
        goto label_63;
    label_60:
        j0.a = 0;
        a.Y("PurchaseClientImpl", "Purchase service security exception");
        v2 = 9;
    label_63:
        com.gaa.sdk.iap.d d2 = B.a.Z(v2);
        e0.a(d2);
        return;
    label_65:
        j0.a = 0;
        Log.e("PurchaseClientImpl", "Purchase service exception: ", exception0);
        d2 = B.a.Z(2);
        e0.a(d2);
    }

    @Override  // androidx.lifecycle.f
    public final void c(D d0) {
        q.g(d0, "owner");
        LogU.Companion.d("OneStoreIapClientLifecycle", "onCreate()");
        LogU.Companion.d("OneStoreIapClientLifecycle", "initPurchaseClient()");
        this.b = new j(this.a, this);
        this.b(new Z8.a(this, 0));
        LogU.Companion.d("OneStoreIapClientLifecycle", "initSignInClient()");
        d d1 = new d(this.a);
        this.c = d1;
        d1.b(new a0(new b(this, 1), 19));
    }

    public final j d() {
        j j0 = this.b;
        if(j0 != null) {
            return j0;
        }
        q.m("purchaseClient");
        throw null;
    }

    public final void e(String s, int v, boolean z, boolean z1) {
        if(z1) {
            this.f = null;
        }
        Z8.i i0 = new Z8.i();  // 初始化器: Ljava/lang/Object;-><init>()V
        i0.a = v;
        i0.b = z;
        i0.c = s;
        this.e.postValue(i0);
    }

    public static void f(g g0, int v, boolean z, String s, int v1) {
        if((v1 & 8) != 0) {
            s = null;
        }
        g0.e(s, v, false, z);
    }

    public final void g(com.gaa.sdk.iap.d d0, ArrayList arrayList0) {
        Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.d("OneStoreIapClientLifecycle", "onPurchasesUpdated " + d0.a() + ", " + d0.a + ", " + d0.b);
        int v = 0;
        if(d0.a()) {
            this.i();
            if(arrayList0 != null) {
                for(Object object0: arrayList0) {
                    if(v >= 0) {
                        LogU.Companion.d("OneStoreIapClientLifecycle", "onPurchasesUpdated() purchaseDataList[" + v + "]:" + ((k)object0));
                        boolean z = !MelonSettingInfo.isBlockIapConfirmRequest();
                        String s = Z8.j.a(((k)object0), (this.f == null ? null : this.f.c));
                        LogU.Companion.d("OneStoreIapClientLifecycle", "requestConfirmPurchase() " + s);
                        OneStoreIapPurchaseReq oneStoreIapPurchaseReq0 = new OneStoreIapPurchaseReq(this.a.getApplicationContext(), s);
                        oneStoreIapPurchaseReq0.setActionUrl((this.f == null ? null : this.f.b));
                        RequestBuilder.newInstance(oneStoreIapPurchaseReq0).tag("OneStoreIapClientLifecycle").listener(new b(this, 3)).errorListener(new b(this, 4)).request();
                        ++v;
                        continue;
                    }
                    e.k.O();
                    throw null;
                }
            }
            return;
        }
        int v1 = d0.a;
        switch(v1) {
            case 10: {
                Log.w("OneStoreIapClientLifecycle", "onPurchasesUpdated() RESULT_NEED_LOGIN");
                this.f = null;
                return;
            }
            case 11: {
                logU$Companion0.w("OneStoreIapClientLifecycle", "onPurchasesUpdated() RESULT_NEED_UPDATE");
                g.f(this, 20004, true, null, 10);
                return;
            }
            case 1007: {
                Log.w("OneStoreIapClientLifecycle", "onPurchasesUpdated() ERROR_SERVICE_DISCONNECTED");
                this.g = false;
                this.b(new Z8.a(this, 1));
                this.e(d0.b, d0.a, true, true);
                return;
            }
            default: {
                Log.w("OneStoreIapClientLifecycle", "onPurchasesUpdated() " + v1 + ", " + d0.b);
                this.e(d0.b, d0.a, true, true);
            }
        }
    }

    public final void i() {
        this.b(new Z8.a(this, 2));
    }

    @Override  // androidx.lifecycle.f
    public final void onDestroy(D d0) {
        LogU.Companion.d("OneStoreIapClientLifecycle", "onDestroy()");
        j j0 = this.d();
        try {
            com.gaa.sdk.iap.a a0 = (com.gaa.sdk.iap.a)j0.e.c;
            Context context0 = (Context)j0.e.b;
            if(a0.b) {
                context0.unregisterReceiver(a0);
                a0.b = false;
            }
            i i0 = j0.g;
            if(i0 != null) {
                synchronized(i0.a) {
                    i0.c = null;
                    i0.b = true;
                }
            }
            if(j0.g != null && j0.f != null) {
                a.X("PurchaseClientImpl", "Unbinding from service.");
                j0.b.unbindService(j0.g);
                j0.g = null;
            }
            j0.f = null;
            E9.g g0 = j0.j;
            ExecutorService executorService0 = (ExecutorService)g0.b;
            if(executorService0 != null) {
                executorService0.shutdownNow();
                g0.b = null;
            }
        }
        catch(Exception exception0) {
            a.Y("PurchaseClientImpl", "There was an exception while ending connection: " + exception0);
        }
        finally {
            j0.a = 3;
        }
        this.g = false;
        this.h = false;
    }

    @Override  // androidx.lifecycle.f
    public final void onPause(D d0) {
    }

    @Override  // androidx.lifecycle.f
    public final void onStop(D d0) {
    }
}

