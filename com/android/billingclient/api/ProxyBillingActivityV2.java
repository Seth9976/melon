package com.android.billingclient.api;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.fragment.app.f0;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.internal.play_billing.zzb;
import e.b;
import kotlin.jvm.internal.q;

@UsedByReflection("PlatformActivityProxy")
public class ProxyBillingActivityV2 extends ComponentActivity {
    private b zza;
    private b zzb;
    private ResultReceiver zzc;
    private ResultReceiver zzd;

    @Override  // androidx.activity.ComponentActivity
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.zza = this.registerForActivityResult(new f0(3), new zzcw(this));
        this.zzb = this.registerForActivityResult(new f0(3), new zzcx(this));
        if(bundle0 == null) {
            zzb.zzj("ProxyBillingActivityV2", "Launching Play Store billing dialog");
            if(this.getIntent().hasExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT")) {
                PendingIntent pendingIntent0 = (PendingIntent)this.getIntent().getParcelableExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT");
                this.zzc = (ResultReceiver)this.getIntent().getParcelableExtra("alternative_billing_only_dialog_result_receiver");
                b b0 = this.zza;
                q.g(pendingIntent0, "pendingIntent");
                IntentSender intentSender0 = pendingIntent0.getIntentSender();
                q.f(intentSender0, "pendingIntent.intentSender");
                b0.b(new IntentSenderRequest(intentSender0, null, 0, 0));
                return;
            }
            if(this.getIntent().hasExtra("external_payment_dialog_pending_intent")) {
                PendingIntent pendingIntent1 = (PendingIntent)this.getIntent().getParcelableExtra("external_payment_dialog_pending_intent");
                this.zzd = (ResultReceiver)this.getIntent().getParcelableExtra("external_payment_dialog_result_receiver");
                b b1 = this.zzb;
                q.g(pendingIntent1, "pendingIntent");
                IntentSender intentSender1 = pendingIntent1.getIntentSender();
                q.f(intentSender1, "pendingIntent.intentSender");
                b1.b(new IntentSenderRequest(intentSender1, null, 0, 0));
            }
        }
        else {
            if(bundle0.containsKey("alternative_billing_only_dialog_result_receiver")) {
                this.zzc = (ResultReceiver)bundle0.getParcelable("alternative_billing_only_dialog_result_receiver");
                return;
            }
            if(bundle0.containsKey("external_payment_dialog_result_receiver")) {
                this.zzd = (ResultReceiver)bundle0.getParcelable("external_payment_dialog_result_receiver");
            }
        }
    }

    @Override  // androidx.activity.ComponentActivity
    public final void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        ResultReceiver resultReceiver0 = this.zzc;
        if(resultReceiver0 != null) {
            bundle0.putParcelable("alternative_billing_only_dialog_result_receiver", resultReceiver0);
        }
        ResultReceiver resultReceiver1 = this.zzd;
        if(resultReceiver1 != null) {
            bundle0.putParcelable("external_payment_dialog_result_receiver", resultReceiver1);
        }
    }

    public final void zza(ActivityResult activityResult0) {
        Intent intent0 = activityResult0.b;
        int v = zzb.zze(intent0, "ProxyBillingActivityV2").getResponseCode();
        ResultReceiver resultReceiver0 = this.zzc;
        if(resultReceiver0 != null) {
            resultReceiver0.send(v, (intent0 == null ? null : intent0.getExtras()));
        }
        int v1 = activityResult0.a;
        if(v1 != -1 || v != 0) {
            zzb.zzk("ProxyBillingActivityV2", "Alternative billing only dialog finished with resultCode " + v1 + " and billing\'s responseCode: " + v);
        }
        this.finish();
    }

    public final void zzb(ActivityResult activityResult0) {
        Intent intent0 = activityResult0.b;
        int v = zzb.zze(intent0, "ProxyBillingActivityV2").getResponseCode();
        ResultReceiver resultReceiver0 = this.zzd;
        if(resultReceiver0 != null) {
            resultReceiver0.send(v, (intent0 == null ? null : intent0.getExtras()));
        }
        int v1 = activityResult0.a;
        if(v1 != -1 || v != 0) {
            zzb.zzk("ProxyBillingActivityV2", "External offer dialog finished with resultCode: " + v1 + " and billing\'s responseCode: " + v);
        }
        this.finish();
    }
}

