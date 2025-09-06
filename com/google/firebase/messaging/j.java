package com.google.firebase.messaging;

import N5.e;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import v7.a;

public final class j implements e, Continuation, a {
    public final int a;

    public j(int v) {
        this.a = v;
        super();
    }

    @Override  // N5.e
    public Object apply(Object object0) {
        F7.e e0 = (F7.e)object0;
        e0.getClass();
        s.a.getClass();
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        try {
            s.a.f(e0, byteArrayOutputStream0);
        }
        catch(IOException unused_ex) {
        }
        return byteArrayOutputStream0.toByteArray();
    }

    @Override  // com.google.android.gms.tasks.Continuation
    public Object then(Task task0) {
        return this.a == 0 ? 403 : -1;
    }
}

