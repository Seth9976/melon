package com.google.android.exoplayer2.trackselection;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.util.Util;
import java.util.Locale;

public class TrackSelectionParameters implements Parcelable {
    public static class Builder {
        int disabledTextTrackSelectionFlags;
        String preferredAudioLanguage;
        String preferredTextLanguage;
        int preferredTextRoleFlags;
        boolean selectUndeterminedTextLanguage;

        @Deprecated
        public Builder() {
            this.preferredAudioLanguage = null;
            this.preferredTextLanguage = null;
            this.preferredTextRoleFlags = 0;
            this.selectUndeterminedTextLanguage = false;
            this.disabledTextTrackSelectionFlags = 0;
        }

        public Builder(Context context0) {
            this.setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context0);
        }

        public Builder(TrackSelectionParameters trackSelectionParameters0) {
            this.preferredAudioLanguage = trackSelectionParameters0.preferredAudioLanguage;
            this.preferredTextLanguage = trackSelectionParameters0.preferredTextLanguage;
            this.preferredTextRoleFlags = trackSelectionParameters0.preferredTextRoleFlags;
            this.selectUndeterminedTextLanguage = trackSelectionParameters0.selectUndeterminedTextLanguage;
            this.disabledTextTrackSelectionFlags = trackSelectionParameters0.disabledTextTrackSelectionFlags;
        }

        public TrackSelectionParameters build() {
            return new TrackSelectionParameters(this.preferredAudioLanguage, this.preferredTextLanguage, this.preferredTextRoleFlags, this.selectUndeterminedTextLanguage, this.disabledTextTrackSelectionFlags);
        }

        public Builder setDisabledTextTrackSelectionFlags(int v) {
            this.disabledTextTrackSelectionFlags = v;
            return this;
        }

        public Builder setPreferredAudioLanguage(String s) {
            this.preferredAudioLanguage = s;
            return this;
        }

        public Builder setPreferredTextLanguage(String s) {
            this.preferredTextLanguage = s;
            return this;
        }

        public Builder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context0) {
            if(Util.SDK_INT >= 19) {
                this.setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettingsV19(context0);
            }
            return this;
        }

        @TargetApi(19)
        private void setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettingsV19(Context context0) {
            if(Util.SDK_INT >= 23 || Looper.myLooper() != null) {
                CaptioningManager captioningManager0 = (CaptioningManager)context0.getSystemService("captioning");
                if(captioningManager0 != null && captioningManager0.isEnabled()) {
                    this.preferredTextRoleFlags = 0x440;
                    Locale locale0 = captioningManager0.getLocale();
                    if(locale0 != null) {
                        this.preferredTextLanguage = Util.getLocaleLanguageTag(locale0);
                    }
                }
            }
        }

        public Builder setPreferredTextRoleFlags(int v) {
            this.preferredTextRoleFlags = v;
            return this;
        }

        public Builder setSelectUndeterminedTextLanguage(boolean z) {
            this.selectUndeterminedTextLanguage = z;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    @Deprecated
    public static final TrackSelectionParameters DEFAULT;
    public static final TrackSelectionParameters DEFAULT_WITHOUT_CONTEXT;
    public final int disabledTextTrackSelectionFlags;
    public final String preferredAudioLanguage;
    public final String preferredTextLanguage;
    public final int preferredTextRoleFlags;
    public final boolean selectUndeterminedTextLanguage;

    static {
        TrackSelectionParameters trackSelectionParameters0 = new Builder().build();
        TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT = trackSelectionParameters0;
        TrackSelectionParameters.DEFAULT = trackSelectionParameters0;
        TrackSelectionParameters.CREATOR = new Parcelable.Creator() {
            public TrackSelectionParameters createFromParcel(Parcel parcel0) {
                return new TrackSelectionParameters(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public TrackSelectionParameters[] newArray(int v) {
                return new TrackSelectionParameters[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public TrackSelectionParameters(Parcel parcel0) {
        this.preferredAudioLanguage = parcel0.readString();
        this.preferredTextLanguage = parcel0.readString();
        this.preferredTextRoleFlags = parcel0.readInt();
        this.selectUndeterminedTextLanguage = Util.readBoolean(parcel0);
        this.disabledTextTrackSelectionFlags = parcel0.readInt();
    }

    public TrackSelectionParameters(String s, String s1, int v, boolean z, int v1) {
        this.preferredAudioLanguage = Util.normalizeLanguageCode(s);
        this.preferredTextLanguage = Util.normalizeLanguageCode(s1);
        this.preferredTextRoleFlags = v;
        this.selectUndeterminedTextLanguage = z;
        this.disabledTextTrackSelectionFlags = v1;
    }

    public Builder buildUpon() {
        return new Builder(this);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(Object object0) {
        return this == object0 ? true : object0 != null && this.getClass() == object0.getClass() && TextUtils.equals(this.preferredAudioLanguage, ((TrackSelectionParameters)object0).preferredAudioLanguage) && TextUtils.equals(this.preferredTextLanguage, ((TrackSelectionParameters)object0).preferredTextLanguage) && this.preferredTextRoleFlags == ((TrackSelectionParameters)object0).preferredTextRoleFlags && this.selectUndeterminedTextLanguage == ((TrackSelectionParameters)object0).selectUndeterminedTextLanguage && this.disabledTextTrackSelectionFlags == ((TrackSelectionParameters)object0).disabledTextTrackSelectionFlags;
    }

    public static TrackSelectionParameters getDefaults(Context context0) {
        return new Builder(context0).build();
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.preferredAudioLanguage == null ? 0 : this.preferredAudioLanguage.hashCode();
        String s = this.preferredTextLanguage;
        if(s != null) {
            v = s.hashCode();
        }
        return ((((v1 + 0x1F) * 0x1F + v) * 0x1F + this.preferredTextRoleFlags) * 0x1F + this.selectUndeterminedTextLanguage) * 0x1F + this.disabledTextTrackSelectionFlags;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.preferredAudioLanguage);
        parcel0.writeString(this.preferredTextLanguage);
        parcel0.writeInt(this.preferredTextRoleFlags);
        Util.writeBoolean(parcel0, this.selectUndeterminedTextLanguage);
        parcel0.writeInt(this.disabledTextTrackSelectionFlags);
    }
}

