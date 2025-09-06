package com.google.android.gms.location;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE_USE})
public @interface Granularity {
    public static final int GRANULARITY_COARSE = 1;
    public static final int GRANULARITY_FINE = 2;
    public static final int GRANULARITY_PERMISSION_LEVEL;

}

