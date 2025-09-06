package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.ArrayList;
import java.util.List;

@Class(creator = "SaveAccountLinkingTokenRequestCreator")
public class SaveAccountLinkingTokenRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final class Builder {
        private PendingIntent zba;
        private String zbb;
        private String zbc;
        private List zbd;
        private String zbe;
        private int zbf;

        public Builder() {
            this.zbd = new ArrayList();
        }

        public SaveAccountLinkingTokenRequest build() {
            boolean z = false;
            Preconditions.checkArgument(this.zba != null, "Consent PendingIntent cannot be null");
            Preconditions.checkArgument("auth_code".equals(this.zbb), "Invalid tokenType");
            Preconditions.checkArgument(!TextUtils.isEmpty(this.zbc), "serviceId cannot be null or empty");
            if(this.zbd != null) {
                z = true;
            }
            Preconditions.checkArgument(z, "scopes cannot be null");
            return new SaveAccountLinkingTokenRequest(this.zba, this.zbb, this.zbc, this.zbd, this.zbe, this.zbf);
        }

        public Builder setConsentPendingIntent(PendingIntent pendingIntent0) {
            this.zba = pendingIntent0;
            return this;
        }

        public Builder setScopes(List list0) {
            this.zbd = list0;
            return this;
        }

        public Builder setServiceId(String s) {
            this.zbc = s;
            return this;
        }

        public Builder setTokenType(String s) {
            this.zbb = s;
            return this;
        }

        public final Builder zba(String s) {
            this.zbe = s;
            return this;
        }

        public final Builder zbb(int v) {
            this.zbf = v;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR = null;
    public static final String EXTRA_TOKEN = "extra_token";
    public static final String TOKEN_TYPE_AUTH_CODE = "auth_code";
    @Field(getter = "getConsentPendingIntent", id = 1)
    private final PendingIntent zba;
    @Field(getter = "getTokenType", id = 2)
    private final String zbb;
    @Field(getter = "getServiceId", id = 3)
    private final String zbc;
    @Field(getter = "getScopes", id = 4)
    private final List zbd;
    @Field(getter = "getSessionId", id = 5)
    private final String zbe;
    @Field(getter = "getTheme", id = 6)
    private final int zbf;

    static {
        SaveAccountLinkingTokenRequest.CREATOR = new zbn();
    }

    @Constructor
    public SaveAccountLinkingTokenRequest(@Param(id = 1) PendingIntent pendingIntent0, @Param(id = 2) String s, @Param(id = 3) String s1, @Param(id = 4) List list0, @Param(id = 5) String s2, @Param(id = 6) int v) {
        this.zba = pendingIntent0;
        this.zbb = s;
        this.zbc = s1;
        this.zbd = list0;
        this.zbe = s2;
        this.zbf = v;
    }

    public static Builder builder() {
        return new Builder();
    }

    // 去混淆评级： 中等(60)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof SaveAccountLinkingTokenRequest ? this.zbd.size() == ((SaveAccountLinkingTokenRequest)object0).zbd.size() && this.zbd.containsAll(((SaveAccountLinkingTokenRequest)object0).zbd) && Objects.equal(this.zba, ((SaveAccountLinkingTokenRequest)object0).zba) && Objects.equal(this.zbb, ((SaveAccountLinkingTokenRequest)object0).zbb) && Objects.equal(this.zbc, ((SaveAccountLinkingTokenRequest)object0).zbc) && Objects.equal(this.zbe, ((SaveAccountLinkingTokenRequest)object0).zbe) && this.zbf == ((SaveAccountLinkingTokenRequest)object0).zbf : false;
    }

    public PendingIntent getConsentPendingIntent() {
        return this.zba;
    }

    public List getScopes() {
        return this.zbd;
    }

    public String getServiceId() {
        return this.zbc;
    }

    public String getTokenType() {
        return this.zbb;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zba, this.zbb, this.zbc, this.zbd, this.zbe});
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 1, this.getConsentPendingIntent(), v, false);
        SafeParcelWriter.writeString(parcel0, 2, this.getTokenType(), false);
        SafeParcelWriter.writeString(parcel0, 3, this.getServiceId(), false);
        SafeParcelWriter.writeStringList(parcel0, 4, this.getScopes(), false);
        SafeParcelWriter.writeString(parcel0, 5, this.zbe, false);
        SafeParcelWriter.writeInt(parcel0, 6, this.zbf);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public static Builder zba(SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest0) {
        Preconditions.checkNotNull(saveAccountLinkingTokenRequest0);
        Builder saveAccountLinkingTokenRequest$Builder0 = SaveAccountLinkingTokenRequest.builder();
        saveAccountLinkingTokenRequest$Builder0.setScopes(saveAccountLinkingTokenRequest0.getScopes());
        saveAccountLinkingTokenRequest$Builder0.setServiceId(saveAccountLinkingTokenRequest0.getServiceId());
        saveAccountLinkingTokenRequest$Builder0.setConsentPendingIntent(saveAccountLinkingTokenRequest0.getConsentPendingIntent());
        saveAccountLinkingTokenRequest$Builder0.setTokenType(saveAccountLinkingTokenRequest0.getTokenType());
        saveAccountLinkingTokenRequest$Builder0.zbb(saveAccountLinkingTokenRequest0.zbf);
        String s = saveAccountLinkingTokenRequest0.zbe;
        if(!TextUtils.isEmpty(s)) {
            saveAccountLinkingTokenRequest$Builder0.zba(s);
        }
        return saveAccountLinkingTokenRequest$Builder0;
    }
}

