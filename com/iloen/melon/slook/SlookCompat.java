package com.iloen.melon.slook;

import android.content.Context;
import b3.Z;
import com.iloen.melon.utils.log.LogU;
import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.look.Slook;

public class SlookCompat {
    public static final class Feature {
        public static final int BAR = 1;
        public static final int NOT_SUPPORTED = 0;
        public static final int PANEL = 2;
        public static final int UNINITIALIZED = -1;

    }

    static final class SlookCompatHolder {
        public static final SlookCompat a;

        static {
            SlookCompatHolder.a = new SlookCompat();
        }
    }

    public int a;

    public SlookCompat() {
        this.a = -1;
    }

    public static SlookCompat getInstance() {
        return SlookCompatHolder.a;
    }

    public int getSupportedFeature(Context context0) {
        if(this.a == -1) {
            try {
                try {
                    Slook slook0 = new Slook();
                    slook0.initialize(context0);
                    if(slook0.isFeatureEnabled(6)) {
                        this.a = 1;
                    }
                    else if(slook0.isFeatureEnabled(7)) {
                        this.a = 2;
                    }
                    goto label_36;
                }
                catch(SsdkUnsupportedException ssdkUnsupportedException0) {
                }
                catch(Exception exception0) {
                    goto label_21;
                }
                catch(Error error0) {
                    goto label_26;
                }
                LogU.e("SlookCompat", "getSupportedFeature() " + ssdkUnsupportedException0.toString());
                if(this.a == -1) {
                    goto label_18;
                }
                goto label_19;
            }
            catch(Throwable throwable0) {
                goto label_31;
            }
        label_18:
            this.a = 0;
        label_19:
            StringBuilder stringBuilder0 = new StringBuilder("getSupportedFeature() supportedFeature:");
            Z.s(this.a, "SlookCompat", stringBuilder0);
            return this.a;
            try {
            label_21:
                LogU.e("SlookCompat", "getSupportedFeature() " + exception0.toString());
                if(this.a == -1) {
                    goto label_23;
                }
                goto label_24;
            }
            catch(Throwable throwable0) {
                goto label_31;
            }
        label_23:
            this.a = 0;
        label_24:
            stringBuilder0 = new StringBuilder("getSupportedFeature() supportedFeature:");
            Z.s(this.a, "SlookCompat", stringBuilder0);
            return this.a;
            try {
            label_26:
                LogU.e("SlookCompat", "getSupportedFeature() " + error0.toString());
                if(this.a == -1) {
                    goto label_28;
                }
                goto label_29;
            }
            catch(Throwable throwable0) {
                goto label_31;
            }
        label_28:
            this.a = 0;
        label_29:
            stringBuilder0 = new StringBuilder("getSupportedFeature() supportedFeature:");
            Z.s(this.a, "SlookCompat", stringBuilder0);
            return this.a;
        label_31:
            if(this.a == -1) {
                this.a = 0;
            }
            StringBuilder stringBuilder1 = new StringBuilder("getSupportedFeature() supportedFeature:");
            Z.s(this.a, "SlookCompat", stringBuilder1);
            throw throwable0;
        label_36:
            if(this.a == -1) {
                this.a = 0;
            }
            stringBuilder0 = new StringBuilder("getSupportedFeature() supportedFeature:");
            Z.s(this.a, "SlookCompat", stringBuilder0);
            return this.a;
        }
        return this.a;
    }

    public boolean isSupported(Context context0) {
        return this.getSupportedFeature(context0) > 0;
    }
}

