package androidx.fragment.app;

import P1.c;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import f.a;
import f.b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import je.C;
import je.D;
import je.n;
import je.p;
import je.x;
import kotlin.jvm.internal.q;

public final class f0 extends b {
    public final int a;

    public f0(int v) {
        this.a = v;
        super();
    }

    @Override  // f.b
    public final Intent createIntent(Context context0, Object object0) {
        switch(this.a) {
            case 0: {
                IntentSenderRequest intentSenderRequest0 = (IntentSenderRequest)object0;
                Intent intent1 = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
                Intent intent2 = intentSenderRequest0.b;
                if(intent2 != null) {
                    Bundle bundle0 = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    if(bundle0 != null) {
                        intent1.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle0);
                        intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                        if(intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                            q.g(intentSenderRequest0.a, "intentSender");
                            intentSenderRequest0 = new IntentSenderRequest(intentSenderRequest0.a, null, intentSenderRequest0.c, intentSenderRequest0.d);
                        }
                    }
                }
                intent1.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest0);
                if(l0.P(2)) {
                    Log.v("FragmentManager", "CreateIntent created the following intent: " + intent1);
                }
                return intent1;
            }
            case 1: {
                q.g(((String[])object0), "input");
                Intent intent3 = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", ((String[])object0));
                q.f(intent3, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
                return intent3;
            }
            case 2: {
                q.g(((Intent)object0), "input");
                return (Intent)object0;
            }
            default: {
                q.g(((IntentSenderRequest)object0), "input");
                Intent intent0 = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", ((IntentSenderRequest)object0));
                q.f(intent0, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
                return intent0;
            }
        }
    }

    @Override  // f.b
    public a getSynchronousResult(Context context0, Object object0) {
        if(this.a != 1) {
            return super.getSynchronousResult(context0, object0);
        }
        q.g(context0, "context");
        q.g(((String[])object0), "input");
        if(((String[])object0).length == 0) {
            return new a(x.a);
        }
        int v1 = 0;
        while(v1 < ((String[])object0).length) {
            if(c.checkSelfPermission(context0, ((String[])object0)[v1]) == 0) {
                ++v1;
                continue;
            }
            return null;
        }
        int v2 = D.N(((String[])object0).length);
        if(v2 < 16) {
            v2 = 16;
        }
        LinkedHashMap linkedHashMap0 = new LinkedHashMap(v2);
        for(int v = 0; v < ((String[])object0).length; ++v) {
            linkedHashMap0.put(((String[])object0)[v], Boolean.TRUE);
        }
        return new a(linkedHashMap0);
    }

    @Override  // f.b
    public final Object parseResult(int v, Intent intent0) {
        switch(this.a) {
            case 0: {
                return new ActivityResult(v, intent0);
            }
            case 1: {
                if(v == -1 && intent0 != null) {
                    String[] arr_s = intent0.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    int[] arr_v = intent0.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                    if(arr_v != null && arr_s != null) {
                        ArrayList arrayList0 = new ArrayList(arr_v.length);
                        for(int v1 = 0; v1 < arr_v.length; ++v1) {
                            arrayList0.add(Boolean.valueOf(arr_v[v1] == 0));
                        }
                        return C.Y(p.W0(n.g0(arr_s), arrayList0));
                    }
                }
                return x.a;
            }
            case 2: {
                return new ActivityResult(v, intent0);
            }
            default: {
                return new ActivityResult(v, intent0);
            }
        }
    }
}

