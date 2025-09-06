package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.framework.media.internal.ResourceProvider;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.internal.cast.zzhg;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Class(creator = "NotificationOptionsCreator")
@Reserved({1})
public class NotificationOptions extends AbstractSafeParcelable {
    public static final class Builder {
        private String zza;
        private List zzb;
        private NotificationActionsProvider zzc;
        private int[] zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private int zzh;
        private int zzi;
        private int zzj;
        private int zzk;
        private int zzl;
        private int zzm;
        private int zzn;
        private int zzo;
        private int zzp;
        private int zzq;
        private long zzr;
        private boolean zzs;
        private boolean zzt;

        public Builder() {
            this.zzb = NotificationOptions.zza;
            this.zzd = NotificationOptions.zzb;
            this.zze = Builder.zza("smallIconDrawableResId");
            this.zzf = Builder.zza("stopLiveStreamDrawableResId");
            this.zzg = Builder.zza("pauseDrawableResId");
            this.zzh = Builder.zza("playDrawableResId");
            this.zzi = Builder.zza("skipNextDrawableResId");
            this.zzj = Builder.zza("skipPrevDrawableResId");
            this.zzk = Builder.zza("forwardDrawableResId");
            this.zzl = Builder.zza("forward10DrawableResId");
            this.zzm = Builder.zza("forward30DrawableResId");
            this.zzn = Builder.zza("rewindDrawableResId");
            this.zzo = Builder.zza("rewind10DrawableResId");
            this.zzp = Builder.zza("rewind30DrawableResId");
            this.zzq = Builder.zza("disconnectDrawableResId");
            this.zzr = 10000L;
        }

        public NotificationOptions build() {
            NotificationActionsProvider notificationActionsProvider0 = this.zzc;
            return notificationActionsProvider0 == null ? new NotificationOptions(this.zzb, this.zzd, this.zzr, this.zza, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzp, this.zzq, Builder.zza("notificationImageSizeDimenResId"), Builder.zza("castingToDeviceStringResId"), Builder.zza("stopLiveStreamStringResId"), Builder.zza("pauseStringResId"), Builder.zza("playStringResId"), Builder.zza("skipNextStringResId"), Builder.zza("skipPrevStringResId"), Builder.zza("forwardStringResId"), Builder.zza("forward10StringResId"), Builder.zza("forward30StringResId"), Builder.zza("rewindStringResId"), Builder.zza("rewind10StringResId"), Builder.zza("rewind30StringResId"), Builder.zza("disconnectStringResId"), null, this.zzs, this.zzt) : new NotificationOptions(this.zzb, this.zzd, this.zzr, this.zza, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzp, this.zzq, Builder.zza("notificationImageSizeDimenResId"), Builder.zza("castingToDeviceStringResId"), Builder.zza("stopLiveStreamStringResId"), Builder.zza("pauseStringResId"), Builder.zza("playStringResId"), Builder.zza("skipNextStringResId"), Builder.zza("skipPrevStringResId"), Builder.zza("forwardStringResId"), Builder.zza("forward10StringResId"), Builder.zza("forward30StringResId"), Builder.zza("rewindStringResId"), Builder.zza("rewind10StringResId"), Builder.zza("rewind30StringResId"), Builder.zza("disconnectStringResId"), ((IBinder)notificationActionsProvider0.zza()), this.zzs, this.zzt);
        }

        public Builder setActions(List list0, int[] arr_v) {
            if(list0 == null && arr_v != null) {
                throw new IllegalArgumentException("When setting actions to null, you must also set compatActionIndices to null.");
            }
            if(list0 != null && arr_v == null) {
                throw new IllegalArgumentException("When setting compatActionIndices to null, you must also set actions to null.");
            }
            if(list0 != null && arr_v != null) {
                int v = list0.size();
                if(arr_v.length > v) {
                    throw new IllegalArgumentException("Invalid number of compat actions: " + arr_v.length + " > " + v + ".");
                }
                for(int v1 = 0; v1 < arr_v.length; ++v1) {
                    int v2 = arr_v[v1];
                    if(v2 < 0 || v2 >= v) {
                        throw new IllegalArgumentException("Index " + v2 + " in compatActionIndices out of range: [0, " + (v - 1) + "]");
                    }
                }
                this.zzb = new ArrayList(list0);
                this.zzd = Arrays.copyOf(arr_v, arr_v.length);
                return this;
            }
            this.zzb = NotificationOptions.zza;
            this.zzd = NotificationOptions.zzb;
            return this;
        }

        public Builder setDisconnectDrawableResId(int v) {
            this.zzq = v;
            return this;
        }

        public Builder setForward10DrawableResId(int v) {
            this.zzl = v;
            return this;
        }

        public Builder setForward30DrawableResId(int v) {
            this.zzm = v;
            return this;
        }

        public Builder setForwardDrawableResId(int v) {
            this.zzk = v;
            return this;
        }

        public Builder setNotificationActionsProvider(NotificationActionsProvider notificationActionsProvider0) {
            if(notificationActionsProvider0 == null) {
                throw new IllegalArgumentException("notificationActionsProvider cannot be null.");
            }
            this.zzc = notificationActionsProvider0;
            return this;
        }

        public Builder setPauseDrawableResId(int v) {
            this.zzg = v;
            return this;
        }

        public Builder setPlayDrawableResId(int v) {
            this.zzh = v;
            return this;
        }

        public Builder setRewind10DrawableResId(int v) {
            this.zzo = v;
            return this;
        }

        public Builder setRewind30DrawableResId(int v) {
            this.zzp = v;
            return this;
        }

        public Builder setRewindDrawableResId(int v) {
            this.zzn = v;
            return this;
        }

        public Builder setSkipNextDrawableResId(int v) {
            this.zzi = v;
            return this;
        }

        public Builder setSkipPrevDrawableResId(int v) {
            this.zzj = v;
            return this;
        }

        public Builder setSkipStepMs(long v) {
            Preconditions.checkArgument(v > 0L, "skipStepMs must be positive.");
            this.zzr = v;
            return this;
        }

        public Builder setSkipToNextSlotReserved(boolean z) {
            this.zzt = z;
            return this;
        }

        public Builder setSkipToPrevSlotReserved(boolean z) {
            this.zzs = z;
            return this;
        }

        public Builder setSmallIconDrawableResId(int v) {
            this.zze = v;
            return this;
        }

        public Builder setStopLiveStreamDrawableResId(int v) {
            this.zzf = v;
            return this;
        }

        public Builder setTargetActivityClassName(String s) {
            this.zza = s;
            return this;
        }

        private static int zza(String s) {
            Integer integer0 = ResourceProvider.findResourceByName(s);
            if(integer0 != null) {
                try {
                    return (int)integer0;
                }
                catch(ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException unused_ex) {
                }
            }
            return 0;
        }
    }

    public static final Parcelable.Creator CREATOR = null;
    public static final long SKIP_STEP_TEN_SECONDS_IN_MS = 10000L;
    public static final long SKIP_STEP_THIRTY_SECONDS_IN_MS = 30000L;
    @Field(getter = "getForwardTitleResId", id = 26)
    private final int zzA;
    @Field(getter = "getForward10TitleResId", id = 27)
    private final int zzB;
    @Field(getter = "getForward30TitleResId", id = 28)
    private final int zzC;
    @Field(getter = "getRewindTitleResId", id = 29)
    private final int zzD;
    @Field(getter = "getRewind10TitleResId", id = 30)
    private final int zzE;
    @Field(getter = "getRewind30TitleResId", id = 0x1F)
    private final int zzF;
    @Field(getter = "getDisconnectTitleResId", id = 0x20)
    private final int zzG;
    @Field(getter = "getNotificationActionsProviderAsBinder", id = 33, type = "android.os.IBinder")
    private final zzg zzH;
    @Field(getter = "isSkipToPrevSlotReserved", id = 34)
    private final boolean zzI;
    @Field(getter = "isSkipToNextSlotReserved", id = 35)
    private final boolean zzJ;
    private static final zzhg zza;
    private static final int[] zzb;
    @Field(getter = "getActions", id = 2)
    private final List zzc;
    @Field(getter = "getCompatActionIndices", id = 3)
    private final int[] zzd;
    @Field(getter = "getSkipStepMs", id = 4)
    private final long zze;
    @Field(getter = "getTargetActivityClassName", id = 5)
    private final String zzf;
    @Field(getter = "getSmallIconDrawableResId", id = 6)
    private final int zzg;
    @Field(getter = "getStopLiveStreamDrawableResId", id = 7)
    private final int zzh;
    @Field(getter = "getPauseDrawableResId", id = 8)
    private final int zzi;
    @Field(getter = "getPlayDrawableResId", id = 9)
    private final int zzj;
    @Field(getter = "getSkipNextDrawableResId", id = 10)
    private final int zzk;
    @Field(getter = "getSkipPrevDrawableResId", id = 11)
    private final int zzl;
    @Field(getter = "getForwardDrawableResId", id = 12)
    private final int zzm;
    @Field(getter = "getForward10DrawableResId", id = 13)
    private final int zzn;
    @Field(getter = "getForward30DrawableResId", id = 14)
    private final int zzo;
    @Field(getter = "getRewindDrawableResId", id = 15)
    private final int zzp;
    @Field(getter = "getRewind10DrawableResId", id = 16)
    private final int zzq;
    @Field(getter = "getRewind30DrawableResId", id = 17)
    private final int zzr;
    @Field(getter = "getDisconnectDrawableResId", id = 18)
    private final int zzs;
    @Field(getter = "getImageSizeDimenResId", id = 19)
    private final int zzt;
    @Field(getter = "getCastingToDeviceStringResId", id = 20)
    private final int zzu;
    @Field(getter = "getStopLiveStreamTitleResId", id = 21)
    private final int zzv;
    @Field(getter = "getPauseTitleResId", id = 22)
    private final int zzw;
    @Field(getter = "getPlayTitleResId", id = 23)
    private final int zzx;
    @Field(getter = "getSkipNextTitleResId", id = 24)
    private final int zzy;
    @Field(getter = "getSkipPrevTitleResId", id = 25)
    private final int zzz;

    static {
        NotificationOptions.zza = zzhg.zzk("com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK", "com.google.android.gms.cast.framework.action.STOP_CASTING");
        NotificationOptions.zzb = new int[]{0, 1};
        NotificationOptions.CREATOR = new zzw();
    }

    @Constructor
    public NotificationOptions(@Param(id = 2) List list0, @Param(id = 3) int[] arr_v, @Param(id = 4) long v, @Param(id = 5) String s, @Param(id = 6) int v1, @Param(id = 7) int v2, @Param(id = 8) int v3, @Param(id = 9) int v4, @Param(id = 10) int v5, @Param(id = 11) int v6, @Param(id = 12) int v7, @Param(id = 13) int v8, @Param(id = 14) int v9, @Param(id = 15) int v10, @Param(id = 16) int v11, @Param(id = 17) int v12, @Param(id = 18) int v13, @Param(id = 19) int v14, @Param(id = 20) int v15, @Param(id = 21) int v16, @Param(id = 22) int v17, @Param(id = 23) int v18, @Param(id = 24) int v19, @Param(id = 25) int v20, @Param(id = 26) int v21, @Param(id = 27) int v22, @Param(id = 28) int v23, @Param(id = 29) int v24, @Param(id = 30) int v25, @Param(id = 0x1F) int v26, @Param(id = 0x20) int v27, @Param(id = 33) IBinder iBinder0, @Param(id = 34) boolean z, @Param(id = 35) boolean z1) {
        zzg zzg0;
        this.zzc = new ArrayList(list0);
        this.zzd = Arrays.copyOf(arr_v, arr_v.length);
        this.zze = v;
        this.zzf = s;
        this.zzg = v1;
        this.zzh = v2;
        this.zzi = v3;
        this.zzj = v4;
        this.zzk = v5;
        this.zzl = v6;
        this.zzm = v7;
        this.zzn = v8;
        this.zzo = v9;
        this.zzp = v10;
        this.zzq = v11;
        this.zzr = v12;
        this.zzs = v13;
        this.zzt = v14;
        this.zzu = v15;
        this.zzv = v16;
        this.zzw = v17;
        this.zzx = v18;
        this.zzy = v19;
        this.zzz = v20;
        this.zzA = v21;
        this.zzB = v22;
        this.zzC = v23;
        this.zzD = v24;
        this.zzE = v25;
        this.zzF = v26;
        this.zzG = v27;
        this.zzI = z;
        this.zzJ = z1;
        if(iBinder0 == null) {
            zzg0 = null;
        }
        else {
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.cast.framework.media.INotificationActionsProvider");
            zzg0 = iInterface0 instanceof zzg ? ((zzg)iInterface0) : new zze(iBinder0);
        }
        this.zzH = zzg0;
    }

    public List getActions() {
        return this.zzc;
    }

    public int getCastingToDeviceStringResId() {
        return this.zzu;
    }

    public int[] getCompatActionIndices() {
        return Arrays.copyOf(this.zzd, this.zzd.length);
    }

    public int getDisconnectDrawableResId() {
        return this.zzs;
    }

    public int getForward10DrawableResId() {
        return this.zzn;
    }

    public int getForward30DrawableResId() {
        return this.zzo;
    }

    public int getForwardDrawableResId() {
        return this.zzm;
    }

    public int getPauseDrawableResId() {
        return this.zzi;
    }

    public int getPlayDrawableResId() {
        return this.zzj;
    }

    public int getRewind10DrawableResId() {
        return this.zzq;
    }

    public int getRewind30DrawableResId() {
        return this.zzr;
    }

    public int getRewindDrawableResId() {
        return this.zzp;
    }

    public int getSkipNextDrawableResId() {
        return this.zzk;
    }

    public int getSkipPrevDrawableResId() {
        return this.zzl;
    }

    public long getSkipStepMs() {
        return this.zze;
    }

    public int getSmallIconDrawableResId() {
        return this.zzg;
    }

    public int getStopLiveStreamDrawableResId() {
        return this.zzh;
    }

    public int getStopLiveStreamTitleResId() {
        return this.zzv;
    }

    public String getTargetActivityClassName() {
        return this.zzf;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeStringList(parcel0, 2, this.getActions(), false);
        SafeParcelWriter.writeIntArray(parcel0, 3, this.getCompatActionIndices(), false);
        SafeParcelWriter.writeLong(parcel0, 4, this.getSkipStepMs());
        SafeParcelWriter.writeString(parcel0, 5, this.getTargetActivityClassName(), false);
        SafeParcelWriter.writeInt(parcel0, 6, this.getSmallIconDrawableResId());
        SafeParcelWriter.writeInt(parcel0, 7, this.getStopLiveStreamDrawableResId());
        SafeParcelWriter.writeInt(parcel0, 8, this.getPauseDrawableResId());
        SafeParcelWriter.writeInt(parcel0, 9, this.getPlayDrawableResId());
        SafeParcelWriter.writeInt(parcel0, 10, this.getSkipNextDrawableResId());
        SafeParcelWriter.writeInt(parcel0, 11, this.getSkipPrevDrawableResId());
        SafeParcelWriter.writeInt(parcel0, 12, this.getForwardDrawableResId());
        SafeParcelWriter.writeInt(parcel0, 13, this.getForward10DrawableResId());
        SafeParcelWriter.writeInt(parcel0, 14, this.getForward30DrawableResId());
        SafeParcelWriter.writeInt(parcel0, 15, this.getRewindDrawableResId());
        SafeParcelWriter.writeInt(parcel0, 16, this.getRewind10DrawableResId());
        SafeParcelWriter.writeInt(parcel0, 17, this.getRewind30DrawableResId());
        SafeParcelWriter.writeInt(parcel0, 18, this.getDisconnectDrawableResId());
        SafeParcelWriter.writeInt(parcel0, 19, this.zzt);
        SafeParcelWriter.writeInt(parcel0, 20, this.getCastingToDeviceStringResId());
        SafeParcelWriter.writeInt(parcel0, 21, this.getStopLiveStreamTitleResId());
        SafeParcelWriter.writeInt(parcel0, 22, this.zzw);
        SafeParcelWriter.writeInt(parcel0, 23, this.zzx);
        SafeParcelWriter.writeInt(parcel0, 24, this.zzy);
        SafeParcelWriter.writeInt(parcel0, 25, this.zzz);
        SafeParcelWriter.writeInt(parcel0, 26, this.zzA);
        SafeParcelWriter.writeInt(parcel0, 27, this.zzB);
        SafeParcelWriter.writeInt(parcel0, 28, this.zzC);
        SafeParcelWriter.writeInt(parcel0, 29, this.zzD);
        SafeParcelWriter.writeInt(parcel0, 30, this.zzE);
        SafeParcelWriter.writeInt(parcel0, 0x1F, this.zzF);
        SafeParcelWriter.writeInt(parcel0, 0x20, this.zzG);
        SafeParcelWriter.writeIBinder(parcel0, 33, (this.zzH == null ? null : this.zzH.asBinder()), false);
        SafeParcelWriter.writeBoolean(parcel0, 34, this.zzI);
        SafeParcelWriter.writeBoolean(parcel0, 35, this.zzJ);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final int zza() {
        return this.zzG;
    }

    public final int zzb() {
        return this.zzB;
    }

    public final int zzc() {
        return this.zzC;
    }

    public final int zzd() {
        return this.zzA;
    }

    public final int zze() {
        return this.zzt;
    }

    public final int zzf() {
        return this.zzw;
    }

    public final int zzg() {
        return this.zzx;
    }

    public final int zzh() {
        return this.zzE;
    }

    public final int zzi() {
        return this.zzF;
    }

    public final int zzj() {
        return this.zzD;
    }

    public final int zzk() {
        return this.zzy;
    }

    public final int zzl() {
        return this.zzz;
    }

    public final zzg zzm() {
        return this.zzH;
    }

    public final boolean zzo() {
        return this.zzJ;
    }

    public final boolean zzp() {
        return this.zzI;
    }
}

