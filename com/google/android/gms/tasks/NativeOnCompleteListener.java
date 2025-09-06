package com.google.android.gms.tasks;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class NativeOnCompleteListener implements OnCompleteListener {
    private final long zza;

    @KeepForSdk
    public NativeOnCompleteListener(long v) {
        this.zza = v;
    }

    @KeepForSdk
    public static void createAndAddCallback(Task task0, long v) {
        task0.addOnCompleteListener(new NativeOnCompleteListener(v));
    }

    @KeepForSdk
    public native void nativeOnComplete(long arg1, Object arg2, boolean arg3, boolean arg4, String arg5) {
    }

    @Override  // com.google.android.gms.tasks.OnCompleteListener
    @KeepForSdk
    public void onComplete(Task task0) {
        String s;
        Object object0;
        if(task0.isSuccessful()) {
            object0 = task0.getResult();
            s = null;
        }
        else if(task0.isCanceled()) {
            object0 = null;
            s = null;
        }
        else {
            Exception exception0 = task0.getException();
            if(exception0 == null) {
                object0 = null;
                s = null;
            }
            else {
                s = exception0.getMessage();
                object0 = null;
            }
        }
        boolean z = task0.isSuccessful();
        boolean z1 = task0.isCanceled();
        this.nativeOnComplete(this.zza, object0, z, z1, s);
    }
}

