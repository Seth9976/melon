package vc;

import H7.d;
import android.content.Intent;
import androidx.car.app.IStartCarApp;
import androidx.car.app.utils.b;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.MutableStateFlow;
import x9.c;

public final class a implements b, OnCompleteListener {
    public final Object a;
    public final Object b;

    public a(Object object0, Object object1) {
        this.a = object0;
        this.b = object1;
        super();
    }

    @Override  // androidx.car.app.utils.b
    public void call() {
        ((IStartCarApp)this.a).startCarApp(((Intent)this.b));
    }

    @Override  // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task0) {
        c c0 = (c)this.a;
        d d0 = (d)this.b;
        q.g(task0, "task");
        if(task0.isSuccessful()) {
            MutableStateFlow mutableStateFlow0 = (MutableStateFlow)c0.b;
            while(true) {
                Object object0 = mutableStateFlow0.getValue();
                String s = d0.a("MCACHE_NEW_LOGIC_ENABLE_YN_V2");
                String s1 = d0.a("GAP_HOUR_OF_USAGE_OPTIMIZATION");
                String s2 = d0.a("TRACE_TARGET_MEMBERS");
                String s3 = d0.a("USER_CHOICE_BILLING_YN");
                ((vc.d)object0).getClass();
                if(mutableStateFlow0.compareAndSet(object0, new vc.d(s, s1, s2, s3))) {
                    break;
                }
            }
        }
    }
}

