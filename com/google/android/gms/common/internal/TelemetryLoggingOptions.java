package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;

@KeepForSdk
public class TelemetryLoggingOptions implements Optional {
    @KeepForSdk
    public static class Builder {
        private String zaa;

        private Builder() {
        }

        public Builder(zaac zaac0) {
        }

        @KeepForSdk
        public TelemetryLoggingOptions build() {
            return new TelemetryLoggingOptions(this.zaa, null);
        }

        @KeepForSdk
        public Builder setApi(String s) {
            this.zaa = s;
            return this;
        }
    }

    public static final TelemetryLoggingOptions zaa;
    private final String zab;

    static {
        TelemetryLoggingOptions.zaa = TelemetryLoggingOptions.builder().build();
    }

    public TelemetryLoggingOptions(String s, zaad zaad0) {
        this.zab = s;
    }

    @KeepForSdk
    public static Builder builder() {
        return new Builder(null);
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof TelemetryLoggingOptions ? Objects.equal(this.zab, ((TelemetryLoggingOptions)object0).zab) : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zab});
    }

    public final Bundle zaa() {
        Bundle bundle0 = new Bundle();
        String s = this.zab;
        if(s != null) {
            bundle0.putString("api", s);
        }
        return bundle0;
    }
}

