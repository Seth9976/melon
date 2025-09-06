package com.google.android.exoplayer2.scheduler;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.os.PowerManager;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Requirements implements Parcelable {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface RequirementFlags {
    }

    public static final Parcelable.Creator CREATOR = null;
    public static final int DEVICE_CHARGING = 8;
    public static final int DEVICE_IDLE = 4;
    public static final int NETWORK = 1;
    public static final int NETWORK_UNMETERED = 2;
    private final int requirements;

    static {
        Requirements.CREATOR = new Parcelable.Creator() {
            public Requirements createFromParcel(Parcel parcel0) {
                return new Requirements(parcel0.readInt());
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public Requirements[] newArray(int v) {
                return new Requirements[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public Requirements(int v) {
        if((v & 2) != 0) {
            v |= 1;
        }
        this.requirements = v;
    }

    public boolean checkRequirements(Context context0) {
        return this.getNotMetRequirements(context0) == 0;
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return Requirements.class == class0 && this.requirements == ((Requirements)object0).requirements;
        }
        return false;
    }

    private int getNotMetNetworkRequirements(Context context0) {
        if(!this.isNetworkRequired()) {
            return 0;
        }
        ConnectivityManager connectivityManager0 = (ConnectivityManager)Assertions.checkNotNull(context0.getSystemService("connectivity"));
        NetworkInfo networkInfo0 = connectivityManager0.getActiveNetworkInfo();
        if(networkInfo0 != null && networkInfo0.isConnected() && Requirements.isInternetConnectivityValidated(connectivityManager0)) {
            return !this.isUnmeteredNetworkRequired() || !connectivityManager0.isActiveNetworkMetered() ? 0 : 2;
        }
        return this.requirements & 3;
    }

    public int getNotMetRequirements(Context context0) {
        int v = this.getNotMetNetworkRequirements(context0);
        if(this.isChargingRequired() && !this.isDeviceCharging(context0)) {
            v |= 8;
        }
        return !this.isIdleRequired() || this.isDeviceIdle(context0) ? v : v | 4;
    }

    public int getRequirements() {
        return this.requirements;
    }

    @Override
    public int hashCode() {
        return this.requirements;
    }

    public boolean isChargingRequired() {
        return (this.requirements & 8) != 0;
    }

    private boolean isDeviceCharging(Context context0) {
        Intent intent0 = context0.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if(intent0 == null) {
            return false;
        }
        switch(intent0.getIntExtra("status", -1)) {
            case 2: 
            case 5: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    private boolean isDeviceIdle(Context context0) {
        PowerManager powerManager0 = (PowerManager)Assertions.checkNotNull(context0.getSystemService("power"));
        int v = Util.SDK_INT;
        if(v >= 23) {
            return powerManager0.isDeviceIdleMode();
        }
        return v < 20 ? !powerManager0.isScreenOn() : !powerManager0.isInteractive();
    }

    public boolean isIdleRequired() {
        return (this.requirements & 4) != 0;
    }

    private static boolean isInternetConnectivityValidated(ConnectivityManager connectivityManager0) {
        if(Util.SDK_INT < 24) {
            return true;
        }
        Network network0 = connectivityManager0.getActiveNetwork();
        if(network0 == null) {
            return false;
        }
        NetworkCapabilities networkCapabilities0 = connectivityManager0.getNetworkCapabilities(network0);
        return networkCapabilities0 != null && networkCapabilities0.hasCapability(16);
    }

    public boolean isNetworkRequired() {
        return (this.requirements & 1) != 0;
    }

    public boolean isUnmeteredNetworkRequired() {
        return (this.requirements & 2) != 0;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.requirements);
    }
}

