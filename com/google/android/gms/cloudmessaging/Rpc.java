package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.V;
import com.google.android.gms.internal.cloudmessaging.zza;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rpc {
    private static int zza;
    private static PendingIntent zzb;
    private static final Executor zzc;
    private static final Pattern zzd;
    private final V zze;
    private final Context zzf;
    private final zzw zzg;
    private final ScheduledExecutorService zzh;
    private final Messenger zzi;
    private Messenger zzj;
    private zzd zzk;

    static {
        Rpc.zzc = zzy.zza;
        Rpc.zzd = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");
    }

    public Rpc(Context context0) {
        this.zze = new V(0);
        this.zzf = context0;
        this.zzg = new zzw(context0);
        this.zzi = new Messenger(new zzae(this, Looper.getMainLooper()));
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor0 = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor0.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor0.allowCoreThreadTimeOut(true);
        this.zzh = scheduledThreadPoolExecutor0;
    }

    public Task getProxiedNotificationData() {
        return this.zzg.zza() < 241100000 ? Tasks.forException(new IOException("SERVICE_NOT_AVAILABLE")) : zzv.zzb(this.zzf).zzd(5, Bundle.EMPTY).continueWith(Rpc.zzc, zzab.zza);
    }

    public Task messageHandled(CloudMessage cloudMessage0) {
        if(this.zzg.zza() >= 233700000) {
            Bundle bundle0 = new Bundle();
            bundle0.putString("google.message_id", cloudMessage0.getMessageId());
            Integer integer0 = cloudMessage0.zza();
            if(integer0 != null) {
                bundle0.putInt("google.product_id", ((int)integer0));
            }
            return zzv.zzb(this.zzf).zzc(3, bundle0);
        }
        return Tasks.forException(new IOException("SERVICE_NOT_AVAILABLE"));
    }

    public Task send(Bundle bundle0) {
        if(this.zzg.zza() < 12000000) {
            if(this.zzg.zzb() != 0) {
                Task task0 = this.zze(bundle0);
                zzz zzz0 = new zzz(this, bundle0);
                return task0.continueWithTask(Rpc.zzc, zzz0);
            }
            return Tasks.forException(new IOException("MISSING_INSTANCEID_SERVICE"));
        }
        return zzv.zzb(this.zzf).zzd(1, bundle0).continueWith(Rpc.zzc, zzaa.zza);
    }

    public Task setRetainProxiedNotifications(boolean z) {
        if(this.zzg.zza() >= 241100000) {
            Bundle bundle0 = new Bundle();
            bundle0.putBoolean("proxy_retention", z);
            return zzv.zzb(this.zzf).zzc(4, bundle0);
        }
        return Tasks.forException(new IOException("SERVICE_NOT_AVAILABLE"));
    }

    // 去混淆评级： 低(20)
    public static Task zza(Bundle bundle0) {
        return Rpc.zzi(bundle0) ? Tasks.forResult(null) : Tasks.forResult(bundle0);
    }

    // 去混淆评级： 低(20)
    public final Task zzb(Bundle bundle0, Task task0) {
        return !task0.isSuccessful() || !Rpc.zzi(((Bundle)task0.getResult())) ? task0 : this.zze(bundle0).onSuccessTask(Rpc.zzc, zzx.zza);
    }

    public static void zzc(Rpc rpc0, Message message0) {
        if(message0 != null) {
            Object object0 = message0.obj;
            if(object0 instanceof Intent) {
                ((Intent)object0).setExtrasClassLoader(new zzc());
                if(((Intent)object0).hasExtra("google.messenger")) {
                    Parcelable parcelable0 = ((Intent)object0).getParcelableExtra("google.messenger");
                    if(parcelable0 instanceof zzd) {
                        rpc0.zzk = (zzd)parcelable0;
                    }
                    if(parcelable0 instanceof Messenger) {
                        rpc0.zzj = (Messenger)parcelable0;
                    }
                }
                Intent intent0 = (Intent)message0.obj;
                String s = intent0.getAction();
                if(Objects.equals(s, "com.google.android.c2dm.intent.REGISTRATION")) {
                    String s1 = intent0.getStringExtra("registration_id");
                    if(s1 == null) {
                        s1 = intent0.getStringExtra("unregistered");
                    }
                    if(s1 == null) {
                        String s2 = intent0.getStringExtra("error");
                        if(s2 == null) {
                            Log.w("Rpc", "Unexpected response, no error or registration id " + intent0.getExtras());
                            return;
                        }
                        if(Log.isLoggable("Rpc", 3)) {
                            Log.d("Rpc", "Received InstanceID error " + s2);
                        }
                        if(s2.startsWith("|")) {
                            String[] arr_s = s2.split("\\|");
                            if(arr_s.length > 2 && Objects.equals(arr_s[1], "ID")) {
                                String s3 = arr_s[2];
                                String s4 = arr_s[3];
                                if(s4.startsWith(":")) {
                                    s4 = s4.substring(1);
                                }
                                rpc0.zzh(s3, intent0.putExtra("error", s4).getExtras());
                                return;
                            }
                            Log.w("Rpc", "Unexpected structured response " + s2);
                            return;
                        }
                        V v0 = rpc0.zze;
                        synchronized(v0) {
                            for(int v2 = 0; v2 < rpc0.zze.size(); ++v2) {
                                rpc0.zzh(((String)rpc0.zze.keyAt(v2)), intent0.getExtras());
                            }
                        }
                        return;
                    }
                    Matcher matcher0 = Rpc.zzd.matcher(s1);
                    if(matcher0.matches()) {
                        String s5 = matcher0.group(1);
                        String s6 = matcher0.group(2);
                        if(s5 != null) {
                            Bundle bundle0 = intent0.getExtras();
                            bundle0.putString("registration_id", s6);
                            rpc0.zzh(s5, bundle0);
                        }
                    }
                    else if(Log.isLoggable("Rpc", 3)) {
                        Log.d("Rpc", "Unexpected response string: " + s1);
                        return;
                    }
                }
                else if(Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Unexpected response action: " + s);
                    return;
                }
                return;
            }
        }
        Log.w("Rpc", "Dropping invalid message");
    }

    public final void zzd(String s, ScheduledFuture scheduledFuture0, Task task0) {
        synchronized(this.zze) {
            this.zze.remove(s);
        }
        scheduledFuture0.cancel(false);
    }

    private final Task zze(Bundle bundle0) {
        TaskCompletionSource taskCompletionSource0 = new TaskCompletionSource();
        synchronized(this.zze) {
            this.zze.put("0", taskCompletionSource0);
        }
        Intent intent0 = new Intent();
        intent0.setPackage("com.google.android.gms");
        if(this.zzg.zzb() == 2) {
            intent0.setAction("com.google.iid.TOKEN_REQUEST");
        }
        else {
            intent0.setAction("com.google.android.c2dm.intent.REGISTER");
        }
        intent0.putExtras(bundle0);
        Rpc.zzg(this.zzf, intent0);
        intent0.putExtra("kid", "|ID|0|");
        if(Log.isLoggable("Rpc", 3)) {
            Log.d("Rpc", "Sending " + intent0.getExtras());
        }
        intent0.putExtra("google.messenger", this.zzi);
        if(this.zzj == null && this.zzk == null) {
        label_30:
            if(this.zzg.zzb() == 2) {
                this.zzf.sendBroadcast(intent0);
            }
            else {
                this.zzf.startService(intent0);
            }
        }
        else {
            Message message0 = Message.obtain();
            message0.obj = intent0;
            try {
                Messenger messenger0 = this.zzj;
                if(messenger0 == null) {
                    this.zzk.zzb(message0);
                }
                else {
                    messenger0.send(message0);
                }
            }
            catch(RemoteException unused_ex) {
                if(Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Messenger failed, fallback to startService");
                }
                goto label_30;
            }
        }
        zzac zzac0 = new zzac(taskCompletionSource0);
        zzad zzad0 = new zzad(this, "0", this.zzh.schedule(zzac0, 30L, TimeUnit.SECONDS));
        taskCompletionSource0.getTask().addOnCompleteListener(Rpc.zzc, zzad0);
        return taskCompletionSource0.getTask();
    }

    private static String zzf() [...] // 潜在的解密器

    private static void zzg(Context context0, Intent intent0) {
        synchronized(Rpc.class) {
            if(Rpc.zzb == null) {
                Intent intent1 = new Intent();
                intent1.setPackage("com.google.example.invalidpackage");
                Rpc.zzb = PendingIntent.getBroadcast(context0, 0, intent1, zza.zza);
            }
            intent0.putExtra("app", Rpc.zzb);
        }
    }

    private final void zzh(String s, Bundle bundle0) {
        synchronized(this.zze) {
            TaskCompletionSource taskCompletionSource0 = (TaskCompletionSource)this.zze.remove(s);
            if(taskCompletionSource0 == null) {
                Log.w("Rpc", "Missing callback for " + s);
                return;
            }
            taskCompletionSource0.setResult(bundle0);
        }
    }

    private static boolean zzi(Bundle bundle0) {
        return bundle0 != null && bundle0.containsKey("google.messenger");
    }
}

