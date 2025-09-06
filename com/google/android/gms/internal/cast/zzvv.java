package com.google.android.gms.internal.cast;

final class zzvv {
    public static void zza(Throwable throwable0) {
        if(throwable0 instanceof Error && !(throwable0 instanceof StackOverflowError)) {
            throw (Error)throwable0;
        }
    }
}

