package com.google.android.gms.internal.cast;

final class zzke implements zzkd {
    @Override  // com.google.android.gms.internal.cast.zzkd
    public final StackTraceElement zza(Class class0, int v) {
        StackTraceElement[] arr_stackTraceElement = new Throwable().getStackTrace();
        String s = class0.getName();
        int v1 = 3;
        boolean z = false;
        while(true) {
            if(v1 >= arr_stackTraceElement.length) {
                v1 = -1;
                break;
            }
            if(arr_stackTraceElement[v1].getClassName().equals(s)) {
                z = true;
            }
            else {
                if(z) {
                    break;
                }
                z = false;
            }
            ++v1;
        }
        return v1 == -1 ? null : arr_stackTraceElement[v1];
    }
}

