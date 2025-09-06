package com.google.firebase.messaging;

import Q1.c;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public final class o implements OnSuccessListener {
    public final int a;
    public final FirebaseMessaging b;

    public o(FirebaseMessaging firebaseMessaging0, int v) {
        this.a = v;
        this.b = firebaseMessaging0;
        super();
    }

    @Override  // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object object0) {
        if(this.a != 0) {
            if(this.b.e.i() && ((C)object0).h.a() != null && !((C)object0).g) {
                ((C)object0).f(0L);
            }
            return;
        }
        FirebaseMessaging firebaseMessaging0 = this.b;
        if(((CloudMessage)object0) != null) {
            c.J(((CloudMessage)object0).getIntent());
            Task task0 = ((Rpc)firebaseMessaging0.c.c).getProxiedNotificationData();
            o o0 = new o(firebaseMessaging0, 0);
            task0.addOnSuccessListener(firebaseMessaging0.f, o0);
        }
    }
}

