package com.google.firebase.messaging;

import com.google.android.gms.tasks.TaskCompletionSource;

public final class n implements Runnable {
    public final int a;
    public final TaskCompletionSource b;
    public final Object c;

    public n(Object object0, TaskCompletionSource taskCompletionSource0, int v) {
        this.a = v;
        this.c = object0;
        this.b = taskCompletionSource0;
        super();
    }

    @Override
    public final void run() {
        TaskCompletionSource taskCompletionSource0 = this.b;
        Object object0 = this.c;
        if(this.a != 0) {
            r r0 = (r)object0;
            try {
                taskCompletionSource0.setResult(r0.h());
            }
            catch(Exception exception0) {
                taskCompletionSource0.setException(exception0);
            }
            return;
        }
        FirebaseMessaging firebaseMessaging0 = (FirebaseMessaging)object0;
        firebaseMessaging0.getClass();
        try {
            taskCompletionSource0.setResult(firebaseMessaging0.a());
        }
        catch(Exception exception1) {
            taskCompletionSource0.setException(exception1);
        }
    }
}

