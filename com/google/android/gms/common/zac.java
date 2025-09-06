package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.IntentSender;
import androidx.activity.result.IntentSenderRequest;
import e.b;
import kotlin.jvm.internal.q;

final class zac implements DialogInterface.OnClickListener {
    final Activity zaa;
    final int zab;
    final b zac;
    final GoogleApiAvailability zad;

    public zac(GoogleApiAvailability googleApiAvailability0, Activity activity0, int v, b b0) {
        this.zad = googleApiAvailability0;
        this.zaa = activity0;
        this.zab = v;
        this.zac = b0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface0, int v) {
        dialogInterface0.dismiss();
        PendingIntent pendingIntent0 = this.zad.getErrorResolutionPendingIntent(this.zaa, this.zab, 0);
        if(pendingIntent0 == null) {
            return;
        }
        IntentSender intentSender0 = pendingIntent0.getIntentSender();
        q.g(intentSender0, "intentSender");
        IntentSenderRequest intentSenderRequest0 = new IntentSenderRequest(intentSender0, null, 0, 0);
        this.zac.b(intentSenderRequest0);
    }
}

