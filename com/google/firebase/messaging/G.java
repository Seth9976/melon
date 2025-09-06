package com.google.firebase.messaging;

import android.content.Intent;
import androidx.collection.f;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import ea.a;

public final class g implements Continuation, OnCompleteListener {
    public final Object a;
    public final Object b;

    public g(Object object0, Object object1) {
        this.a = object0;
        this.b = object1;
        super();
    }

    @Override  // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task0) {
        ((EnhancedIntentService)this.a).a(((Intent)this.b));
    }

    @Override  // com.google.android.gms.tasks.Continuation
    public Object then(Task task0) {
        synchronized(((a)this.a)) {
            ((f)((a)this.a).b).remove(((String)this.b));
            return task0;
        }
    }
}

