package com.google.firebase.messaging;

import Y6.f;
import Y6.s;
import Y6.u;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.io.IOException;
import java.util.concurrent.ScheduledFuture;

public final class q implements f, Continuation, OnCompleteListener {
    public final int a;
    public final Object b;

    public q(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // Y6.f
    public Object c(u u0) {
        return FirebaseMessagingRegistrar.lambda$getComponents$0(((s)this.b), u0);
    }

    @Override  // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task0) {
        switch(this.a) {
            case 2: {
                F.a(((Intent)this.b));
                return;
            }
            case 3: {
                ((H)this.b).b.trySetResult(null);
                return;
            }
            default: {
                ((ScheduledFuture)this.b).cancel(false);
            }
        }
    }

    @Override  // com.google.android.gms.tasks.Continuation
    public Object then(Task task0) {
        ((E9.u)this.b).getClass();
        Bundle bundle0 = (Bundle)task0.getResult(IOException.class);
        if(bundle0 == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String s = bundle0.getString("registration_id");
        if(s != null) {
            return s;
        }
        String s1 = bundle0.getString("unregistered");
        if(s1 != null) {
            return s1;
        }
        String s2 = bundle0.getString("error");
        if("RST".equals(s2)) {
            throw new IOException("INSTANCE_ID_RESET");
        }
        if(s2 != null) {
            throw new IOException(s2);
        }
        Log.w("FirebaseMessaging", "Unexpected response: " + bundle0, new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }
}

