package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "AuthenticationExtensionsCreator")
@Reserved({1})
public class AuthenticationExtensions extends AbstractSafeParcelable {
    public static final class Builder {
        private FidoAppIdExtension zza;
        private UserVerificationMethodExtension zzb;
        private zzs zzc;
        private zzz zzd;
        private zzab zze;
        private zzad zzf;
        private zzu zzg;
        private zzag zzh;
        private GoogleThirdPartyPaymentExtension zzi;
        private zzai zzj;

        public Builder() {
        }

        public Builder(AuthenticationExtensions authenticationExtensions0) {
            if(authenticationExtensions0 != null) {
                this.zza = authenticationExtensions0.getFidoAppIdExtension();
                this.zzb = authenticationExtensions0.getUserVerificationMethodExtension();
                this.zzc = authenticationExtensions0.zza();
                this.zzd = authenticationExtensions0.zzc();
                this.zze = authenticationExtensions0.zzd();
                this.zzf = authenticationExtensions0.zze();
                this.zzg = authenticationExtensions0.zzb();
                this.zzh = authenticationExtensions0.zzg();
                this.zzi = authenticationExtensions0.zzf();
                this.zzj = authenticationExtensions0.zzh();
            }
        }

        public AuthenticationExtensions build() {
            return new AuthenticationExtensions(this.zza, this.zzc, this.zzb, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj);
        }

        public Builder setFido2Extension(FidoAppIdExtension fidoAppIdExtension0) {
            this.zza = fidoAppIdExtension0;
            return this;
        }

        public Builder setGoogleThirdPartyPaymentExtension(GoogleThirdPartyPaymentExtension googleThirdPartyPaymentExtension0) {
            this.zzi = googleThirdPartyPaymentExtension0;
            return this;
        }

        public Builder setUserVerificationMethodExtension(UserVerificationMethodExtension userVerificationMethodExtension0) {
            this.zzb = userVerificationMethodExtension0;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getFidoAppIdExtension", id = 2)
    private final FidoAppIdExtension zza;
    @Field(getter = "getCableAuthenticationExtension", id = 3)
    private final zzs zzb;
    @Field(getter = "getUserVerificationMethodExtension", id = 4)
    private final UserVerificationMethodExtension zzc;
    @Field(getter = "getGoogleMultiAssertionExtension", id = 5)
    private final zzz zzd;
    @Field(getter = "getGoogleSessionIdExtension", id = 6)
    private final zzab zze;
    @Field(getter = "getGoogleSilentVerificationExtension", id = 7)
    private final zzad zzf;
    @Field(getter = "getDevicePublicKeyExtension", id = 8)
    private final zzu zzg;
    @Field(getter = "getGoogleTunnelServerIdExtension", id = 9)
    private final zzag zzh;
    @Field(getter = "getGoogleThirdPartyPaymentExtension", id = 10)
    private final GoogleThirdPartyPaymentExtension zzi;
    @Field(getter = "getPrfExtension", id = 11)
    private final zzai zzj;

    static {
        AuthenticationExtensions.CREATOR = new zzd();
    }

    @Constructor
    public AuthenticationExtensions(@Param(id = 2) FidoAppIdExtension fidoAppIdExtension0, @Param(id = 3) zzs zzs0, @Param(id = 4) UserVerificationMethodExtension userVerificationMethodExtension0, @Param(id = 5) zzz zzz0, @Param(id = 6) zzab zzab0, @Param(id = 7) zzad zzad0, @Param(id = 8) zzu zzu0, @Param(id = 9) zzag zzag0, @Param(id = 10) GoogleThirdPartyPaymentExtension googleThirdPartyPaymentExtension0, @Param(id = 11) zzai zzai0) {
        this.zza = fidoAppIdExtension0;
        this.zzc = userVerificationMethodExtension0;
        this.zzb = zzs0;
        this.zzd = zzz0;
        this.zze = zzab0;
        this.zzf = zzad0;
        this.zzg = zzu0;
        this.zzh = zzag0;
        this.zzi = googleThirdPartyPaymentExtension0;
        this.zzj = zzai0;
    }

    // 去混淆评级： 中等(110)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof AuthenticationExtensions ? Objects.equal(this.zza, ((AuthenticationExtensions)object0).zza) && Objects.equal(this.zzb, ((AuthenticationExtensions)object0).zzb) && Objects.equal(this.zzc, ((AuthenticationExtensions)object0).zzc) && Objects.equal(this.zzd, ((AuthenticationExtensions)object0).zzd) && Objects.equal(this.zze, ((AuthenticationExtensions)object0).zze) && Objects.equal(this.zzf, ((AuthenticationExtensions)object0).zzf) && Objects.equal(this.zzg, ((AuthenticationExtensions)object0).zzg) && Objects.equal(this.zzh, ((AuthenticationExtensions)object0).zzh) && Objects.equal(this.zzi, ((AuthenticationExtensions)object0).zzi) && Objects.equal(this.zzj, ((AuthenticationExtensions)object0).zzj) : false;
    }

    public FidoAppIdExtension getFidoAppIdExtension() {
        return this.zza;
    }

    public UserVerificationMethodExtension getUserVerificationMethodExtension() {
        return this.zzc;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj});
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.getFidoAppIdExtension(), v, false);
        SafeParcelWriter.writeParcelable(parcel0, 3, this.zzb, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 4, this.getUserVerificationMethodExtension(), v, false);
        SafeParcelWriter.writeParcelable(parcel0, 5, this.zzd, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 6, this.zze, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 7, this.zzf, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 8, this.zzg, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 9, this.zzh, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 10, this.zzi, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 11, this.zzj, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final zzs zza() {
        return this.zzb;
    }

    public final zzu zzb() {
        return this.zzg;
    }

    public final zzz zzc() {
        return this.zzd;
    }

    public final zzab zzd() {
        return this.zze;
    }

    public final zzad zze() {
        return this.zzf;
    }

    public final GoogleThirdPartyPaymentExtension zzf() {
        return this.zzi;
    }

    public final zzag zzg() {
        return this.zzh;
    }

    public final zzai zzh() {
        return this.zzj;
    }
}

