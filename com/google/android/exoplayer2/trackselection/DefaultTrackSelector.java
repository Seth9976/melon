package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.iloen.melon.utils.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class DefaultTrackSelector extends MappingTrackSelector {
    static final class AudioConfigurationTuple {
        public final int channelCount;
        public final String mimeType;
        public final int sampleRate;

        public AudioConfigurationTuple(int v, int v1, String s) {
            this.channelCount = v;
            this.sampleRate = v1;
            this.mimeType = s;
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(object0 != null) {
                Class class0 = object0.getClass();
                return AudioConfigurationTuple.class == class0 && this.channelCount == ((AudioConfigurationTuple)object0).channelCount && this.sampleRate == ((AudioConfigurationTuple)object0).sampleRate && TextUtils.equals(this.mimeType, ((AudioConfigurationTuple)object0).mimeType);
            }
            return false;
        }

        @Override
        public int hashCode() {
            int v = (this.channelCount * 0x1F + this.sampleRate) * 0x1F;
            return this.mimeType == null ? v : v + this.mimeType.hashCode();
        }
    }

    public static final class AudioTrackScore implements Comparable {
        private final int bitrate;
        private final int channelCount;
        private final boolean isDefaultSelectionFlag;
        public final boolean isWithinConstraints;
        private final boolean isWithinRendererCapabilities;
        private final String language;
        private final int localeLanguageMatchIndex;
        private final int localeLanguageScore;
        private final Parameters parameters;
        private final int preferredLanguageScore;
        private final int sampleRate;

        public AudioTrackScore(Format format0, Parameters defaultTrackSelector$Parameters0, int v) {
            this.parameters = defaultTrackSelector$Parameters0;
            this.language = DefaultTrackSelector.normalizeUndeterminedLanguageToNull(format0.language);
            int v1 = 0;
            this.isWithinRendererCapabilities = DefaultTrackSelector.isSupported(v, false);
            this.preferredLanguageScore = DefaultTrackSelector.getFormatLanguageScore(format0, defaultTrackSelector$Parameters0.preferredAudioLanguage, false);
            boolean z = true;
            this.isDefaultSelectionFlag = (format0.selectionFlags & 1) != 0;
            this.channelCount = format0.channelCount;
            this.sampleRate = format0.sampleRate;
            this.bitrate = format0.bitrate;
            if(format0.bitrate != -1 && format0.bitrate > defaultTrackSelector$Parameters0.maxAudioBitrate || format0.channelCount != -1 && format0.channelCount > defaultTrackSelector$Parameters0.maxAudioChannelCount) {
                z = false;
            }
            this.isWithinConstraints = z;
            String[] arr_s = Util.getSystemLanguageCodes();
            int v2;
            for(v2 = 0; true; ++v2) {
                if(v2 >= arr_s.length) {
                    v2 = 0x7FFFFFFF;
                    break;
                }
                int v3 = DefaultTrackSelector.getFormatLanguageScore(format0, arr_s[v2], false);
                if(v3 > 0) {
                    v1 = v3;
                    break;
                }
            }
            this.localeLanguageMatchIndex = v2;
            this.localeLanguageScore = v1;
        }

        public int compareTo(AudioTrackScore defaultTrackSelector$AudioTrackScore0) {
            boolean z = this.isWithinRendererCapabilities;
            int v = -1;
            if(z != defaultTrackSelector$AudioTrackScore0.isWithinRendererCapabilities) {
                return z ? 1 : -1;
            }
            int v1 = this.preferredLanguageScore;
            int v2 = defaultTrackSelector$AudioTrackScore0.preferredLanguageScore;
            if(v1 != v2) {
                return DefaultTrackSelector.compareInts(v1, v2);
            }
            boolean z1 = this.isWithinConstraints;
            if(z1 != defaultTrackSelector$AudioTrackScore0.isWithinConstraints) {
                return z1 ? 1 : -1;
            }
            if(this.parameters.forceLowestBitrate) {
                int v3 = DefaultTrackSelector.compareFormatValues(this.bitrate, defaultTrackSelector$AudioTrackScore0.bitrate);
                if(v3 != 0) {
                    return v3 <= 0 ? 1 : -1;
                }
            }
            boolean z2 = this.isDefaultSelectionFlag;
            if(z2 != defaultTrackSelector$AudioTrackScore0.isDefaultSelectionFlag) {
                return z2 ? 1 : -1;
            }
            int v4 = this.localeLanguageMatchIndex;
            int v5 = defaultTrackSelector$AudioTrackScore0.localeLanguageMatchIndex;
            if(v4 != v5) {
                return -DefaultTrackSelector.compareInts(v4, v5);
            }
            int v6 = this.localeLanguageScore;
            int v7 = defaultTrackSelector$AudioTrackScore0.localeLanguageScore;
            if(v6 != v7) {
                return DefaultTrackSelector.compareInts(v6, v7);
            }
            if(this.isWithinConstraints && this.isWithinRendererCapabilities) {
                v = 1;
            }
            int v8 = this.channelCount;
            int v9 = defaultTrackSelector$AudioTrackScore0.channelCount;
            if(v8 != v9) {
                return DefaultTrackSelector.compareInts(v8, v9) * v;
            }
            int v10 = this.sampleRate;
            int v11 = defaultTrackSelector$AudioTrackScore0.sampleRate;
            if(v10 != v11) {
                return DefaultTrackSelector.compareInts(v10, v11) * v;
            }
            return Util.areEqual(this.language, defaultTrackSelector$AudioTrackScore0.language) ? DefaultTrackSelector.compareInts(this.bitrate, defaultTrackSelector$AudioTrackScore0.bitrate) * v : 0;
        }

        @Override
        public int compareTo(Object object0) {
            return this.compareTo(((AudioTrackScore)object0));
        }
    }

    public static final class Parameters extends TrackSelectionParameters {
        public static final Parcelable.Creator CREATOR;
        @Deprecated
        public static final Parameters DEFAULT;
        public static final Parameters DEFAULT_WITHOUT_CONTEXT;
        @Deprecated
        public static final Parameters DEFAULT_WITHOUT_VIEWPORT;
        public final boolean allowAudioMixedChannelCountAdaptiveness;
        public final boolean allowAudioMixedMimeTypeAdaptiveness;
        public final boolean allowAudioMixedSampleRateAdaptiveness;
        @Deprecated
        public final boolean allowMixedMimeAdaptiveness;
        @Deprecated
        public final boolean allowNonSeamlessAdaptiveness;
        public final boolean allowVideoMixedMimeTypeAdaptiveness;
        public final boolean allowVideoNonSeamlessAdaptiveness;
        public final boolean exceedAudioConstraintsIfNecessary;
        public final boolean exceedRendererCapabilitiesIfNecessary;
        public final boolean exceedVideoConstraintsIfNecessary;
        public final boolean forceHighestSupportedBitrate;
        public final boolean forceLowestBitrate;
        public final int maxAudioBitrate;
        public final int maxAudioChannelCount;
        public final int maxVideoBitrate;
        public final int maxVideoFrameRate;
        public final int maxVideoHeight;
        public final int maxVideoWidth;
        private final SparseBooleanArray rendererDisabledFlags;
        private final SparseArray selectionOverrides;
        public final int tunnelingAudioSessionId;
        public final int viewportHeight;
        public final boolean viewportOrientationMayChange;
        public final int viewportWidth;

        static {
            Parameters defaultTrackSelector$Parameters0 = new ParametersBuilder().build();
            Parameters.DEFAULT_WITHOUT_CONTEXT = defaultTrackSelector$Parameters0;
            Parameters.DEFAULT_WITHOUT_VIEWPORT = defaultTrackSelector$Parameters0;
            Parameters.DEFAULT = defaultTrackSelector$Parameters0;
            Parameters.CREATOR = new Parcelable.Creator() {
                public Parameters createFromParcel(Parcel parcel0) {
                    return new Parameters(parcel0);
                }

                @Override  // android.os.Parcelable$Creator
                public Object createFromParcel(Parcel parcel0) {
                    return this.createFromParcel(parcel0);
                }

                public Parameters[] newArray(int v) {
                    return new Parameters[v];
                }

                @Override  // android.os.Parcelable$Creator
                public Object[] newArray(int v) {
                    return this.newArray(v);
                }
            };
        }

        public Parameters(int v, int v1, int v2, int v3, boolean z, boolean z1, boolean z2, int v4, int v5, boolean z3, String s, int v6, int v7, boolean z4, boolean z5, boolean z6, boolean z7, String s1, int v8, boolean z8, int v9, boolean z9, boolean z10, boolean z11, int v10, SparseArray sparseArray0, SparseBooleanArray sparseBooleanArray0) {
            super(s, s1, v8, z8, v9);
            this.maxVideoWidth = v;
            this.maxVideoHeight = v1;
            this.maxVideoFrameRate = v2;
            this.maxVideoBitrate = v3;
            this.exceedVideoConstraintsIfNecessary = z;
            this.allowVideoMixedMimeTypeAdaptiveness = z1;
            this.allowVideoNonSeamlessAdaptiveness = z2;
            this.viewportWidth = v4;
            this.viewportHeight = v5;
            this.viewportOrientationMayChange = z3;
            this.maxAudioChannelCount = v6;
            this.maxAudioBitrate = v7;
            this.exceedAudioConstraintsIfNecessary = z4;
            this.allowAudioMixedMimeTypeAdaptiveness = z5;
            this.allowAudioMixedSampleRateAdaptiveness = z6;
            this.allowAudioMixedChannelCountAdaptiveness = z7;
            this.forceLowestBitrate = z9;
            this.forceHighestSupportedBitrate = z10;
            this.exceedRendererCapabilitiesIfNecessary = z11;
            this.tunnelingAudioSessionId = v10;
            this.allowMixedMimeAdaptiveness = z1;
            this.allowNonSeamlessAdaptiveness = z2;
            this.selectionOverrides = sparseArray0;
            this.rendererDisabledFlags = sparseBooleanArray0;
        }

        public Parameters(Parcel parcel0) {
            super(parcel0);
            this.maxVideoWidth = parcel0.readInt();
            this.maxVideoHeight = parcel0.readInt();
            this.maxVideoFrameRate = parcel0.readInt();
            this.maxVideoBitrate = parcel0.readInt();
            this.exceedVideoConstraintsIfNecessary = Util.readBoolean(parcel0);
            boolean z = Util.readBoolean(parcel0);
            this.allowVideoMixedMimeTypeAdaptiveness = z;
            boolean z1 = Util.readBoolean(parcel0);
            this.allowVideoNonSeamlessAdaptiveness = z1;
            this.viewportWidth = parcel0.readInt();
            this.viewportHeight = parcel0.readInt();
            this.viewportOrientationMayChange = Util.readBoolean(parcel0);
            this.maxAudioChannelCount = parcel0.readInt();
            this.maxAudioBitrate = parcel0.readInt();
            this.exceedAudioConstraintsIfNecessary = Util.readBoolean(parcel0);
            this.allowAudioMixedMimeTypeAdaptiveness = Util.readBoolean(parcel0);
            this.allowAudioMixedSampleRateAdaptiveness = Util.readBoolean(parcel0);
            this.allowAudioMixedChannelCountAdaptiveness = Util.readBoolean(parcel0);
            this.forceLowestBitrate = Util.readBoolean(parcel0);
            this.forceHighestSupportedBitrate = Util.readBoolean(parcel0);
            this.exceedRendererCapabilitiesIfNecessary = Util.readBoolean(parcel0);
            this.tunnelingAudioSessionId = parcel0.readInt();
            this.selectionOverrides = Parameters.readSelectionOverrides(parcel0);
            this.rendererDisabledFlags = (SparseBooleanArray)Util.castNonNull(parcel0.readSparseBooleanArray());
            this.allowMixedMimeAdaptiveness = z;
            this.allowNonSeamlessAdaptiveness = z1;
        }

        private static boolean areRendererDisabledFlagsEqual(SparseBooleanArray sparseBooleanArray0, SparseBooleanArray sparseBooleanArray1) {
            int v = sparseBooleanArray0.size();
            if(sparseBooleanArray1.size() != v) {
                return false;
            }
            for(int v1 = 0; v1 < v; ++v1) {
                if(sparseBooleanArray1.indexOfKey(sparseBooleanArray0.keyAt(v1)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean areSelectionOverridesEqual(SparseArray sparseArray0, SparseArray sparseArray1) {
            int v = sparseArray0.size();
            if(sparseArray1.size() != v) {
                return false;
            }
            int v1 = 0;
            while(v1 < v) {
                int v2 = sparseArray1.indexOfKey(sparseArray0.keyAt(v1));
                if(v2 >= 0 && Parameters.areSelectionOverridesEqual(((Map)sparseArray0.valueAt(v1)), ((Map)sparseArray1.valueAt(v2)))) {
                    ++v1;
                    continue;
                }
                return false;
            }
            return true;
        }

        private static boolean areSelectionOverridesEqual(Map map0, Map map1) {
            if(map1.size() != map0.size()) {
                return false;
            }
            for(Object object0: map0.entrySet()) {
                TrackGroupArray trackGroupArray0 = (TrackGroupArray)((Map.Entry)object0).getKey();
                if(!map1.containsKey(trackGroupArray0) || !Util.areEqual(((Map.Entry)object0).getValue(), map1.get(trackGroupArray0))) {
                    return false;
                }
                if(false) {
                    break;
                }
            }
            return true;
        }

        public ParametersBuilder buildUpon() {
            return new ParametersBuilder(this, null);
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        public Builder buildUpon() {
            return this.buildUpon();
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        public int describeContents() {
            return 0;
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(object0 != null) {
                Class class0 = object0.getClass();
                if(Parameters.class == class0) {
                    Parameters defaultTrackSelector$Parameters0 = (Parameters)object0;
                    return super.equals(object0) && this.maxVideoWidth == defaultTrackSelector$Parameters0.maxVideoWidth && this.maxVideoHeight == defaultTrackSelector$Parameters0.maxVideoHeight && this.maxVideoFrameRate == defaultTrackSelector$Parameters0.maxVideoFrameRate && this.maxVideoBitrate == defaultTrackSelector$Parameters0.maxVideoBitrate && this.exceedVideoConstraintsIfNecessary == defaultTrackSelector$Parameters0.exceedVideoConstraintsIfNecessary && this.allowVideoMixedMimeTypeAdaptiveness == defaultTrackSelector$Parameters0.allowVideoMixedMimeTypeAdaptiveness && this.allowVideoNonSeamlessAdaptiveness == defaultTrackSelector$Parameters0.allowVideoNonSeamlessAdaptiveness && this.viewportOrientationMayChange == defaultTrackSelector$Parameters0.viewportOrientationMayChange && this.viewportWidth == defaultTrackSelector$Parameters0.viewportWidth && this.viewportHeight == defaultTrackSelector$Parameters0.viewportHeight && this.maxAudioChannelCount == defaultTrackSelector$Parameters0.maxAudioChannelCount && this.maxAudioBitrate == defaultTrackSelector$Parameters0.maxAudioBitrate && this.exceedAudioConstraintsIfNecessary == defaultTrackSelector$Parameters0.exceedAudioConstraintsIfNecessary && this.allowAudioMixedMimeTypeAdaptiveness == defaultTrackSelector$Parameters0.allowAudioMixedMimeTypeAdaptiveness && this.allowAudioMixedSampleRateAdaptiveness == defaultTrackSelector$Parameters0.allowAudioMixedSampleRateAdaptiveness && this.allowAudioMixedChannelCountAdaptiveness == defaultTrackSelector$Parameters0.allowAudioMixedChannelCountAdaptiveness && this.forceLowestBitrate == defaultTrackSelector$Parameters0.forceLowestBitrate && this.forceHighestSupportedBitrate == defaultTrackSelector$Parameters0.forceHighestSupportedBitrate && this.exceedRendererCapabilitiesIfNecessary == defaultTrackSelector$Parameters0.exceedRendererCapabilitiesIfNecessary && this.tunnelingAudioSessionId == defaultTrackSelector$Parameters0.tunnelingAudioSessionId && Parameters.areRendererDisabledFlagsEqual(this.rendererDisabledFlags, defaultTrackSelector$Parameters0.rendererDisabledFlags) && Parameters.areSelectionOverridesEqual(this.selectionOverrides, defaultTrackSelector$Parameters0.selectionOverrides);
                }
            }
            return false;
        }

        public static Parameters getDefaults(Context context0) {
            return new ParametersBuilder(context0).build();
        }

        public final boolean getRendererDisabled(int v) {
            return this.rendererDisabledFlags.get(v);
        }

        public final SelectionOverride getSelectionOverride(int v, TrackGroupArray trackGroupArray0) {
            Map map0 = (Map)this.selectionOverrides.get(v);
            return map0 == null ? null : ((SelectionOverride)map0.get(trackGroupArray0));
        }

        public final boolean hasSelectionOverride(int v, TrackGroupArray trackGroupArray0) {
            Map map0 = (Map)this.selectionOverrides.get(v);
            return map0 != null && map0.containsKey(trackGroupArray0);
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        public int hashCode() {
            return (((((((((((((((((((super.hashCode() * 0x1F + this.maxVideoWidth) * 0x1F + this.maxVideoHeight) * 0x1F + this.maxVideoFrameRate) * 0x1F + this.maxVideoBitrate) * 0x1F + this.exceedVideoConstraintsIfNecessary) * 0x1F + this.allowVideoMixedMimeTypeAdaptiveness) * 0x1F + this.allowVideoNonSeamlessAdaptiveness) * 0x1F + this.viewportOrientationMayChange) * 0x1F + this.viewportWidth) * 0x1F + this.viewportHeight) * 0x1F + this.maxAudioChannelCount) * 0x1F + this.maxAudioBitrate) * 0x1F + this.exceedAudioConstraintsIfNecessary) * 0x1F + this.allowAudioMixedMimeTypeAdaptiveness) * 0x1F + this.allowAudioMixedSampleRateAdaptiveness) * 0x1F + this.allowAudioMixedChannelCountAdaptiveness) * 0x1F + this.forceLowestBitrate) * 0x1F + this.forceHighestSupportedBitrate) * 0x1F + this.exceedRendererCapabilitiesIfNecessary) * 0x1F + this.tunnelingAudioSessionId;
        }

        private static SparseArray readSelectionOverrides(Parcel parcel0) {
            int v = parcel0.readInt();
            SparseArray sparseArray0 = new SparseArray(v);
            for(int v1 = 0; v1 < v; ++v1) {
                int v2 = parcel0.readInt();
                int v3 = parcel0.readInt();
                HashMap hashMap0 = new HashMap(v3);
                for(int v4 = 0; v4 < v3; ++v4) {
                    hashMap0.put(((TrackGroupArray)Assertions.checkNotNull(((TrackGroupArray)parcel0.readParcelable(TrackGroupArray.class.getClassLoader())))), ((SelectionOverride)parcel0.readParcelable(SelectionOverride.class.getClassLoader())));
                }
                sparseArray0.put(v2, hashMap0);
            }
            return sparseArray0;
        }

        private static void writeSelectionOverridesToParcel(Parcel parcel0, SparseArray sparseArray0) {
            int v = sparseArray0.size();
            parcel0.writeInt(v);
            for(int v1 = 0; v1 < v; ++v1) {
                int v2 = sparseArray0.keyAt(v1);
                Map map0 = (Map)sparseArray0.valueAt(v1);
                parcel0.writeInt(v2);
                parcel0.writeInt(map0.size());
                for(Object object0: map0.entrySet()) {
                    parcel0.writeParcelable(((Parcelable)((Map.Entry)object0).getKey()), 0);
                    parcel0.writeParcelable(((Parcelable)((Map.Entry)object0).getValue()), 0);
                }
            }
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
        public void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeInt(this.maxVideoWidth);
            parcel0.writeInt(this.maxVideoHeight);
            parcel0.writeInt(this.maxVideoFrameRate);
            parcel0.writeInt(this.maxVideoBitrate);
            Util.writeBoolean(parcel0, this.exceedVideoConstraintsIfNecessary);
            Util.writeBoolean(parcel0, this.allowVideoMixedMimeTypeAdaptiveness);
            Util.writeBoolean(parcel0, this.allowVideoNonSeamlessAdaptiveness);
            parcel0.writeInt(this.viewportWidth);
            parcel0.writeInt(this.viewportHeight);
            Util.writeBoolean(parcel0, this.viewportOrientationMayChange);
            parcel0.writeInt(this.maxAudioChannelCount);
            parcel0.writeInt(this.maxAudioBitrate);
            Util.writeBoolean(parcel0, this.exceedAudioConstraintsIfNecessary);
            Util.writeBoolean(parcel0, this.allowAudioMixedMimeTypeAdaptiveness);
            Util.writeBoolean(parcel0, this.allowAudioMixedSampleRateAdaptiveness);
            Util.writeBoolean(parcel0, this.allowAudioMixedChannelCountAdaptiveness);
            Util.writeBoolean(parcel0, this.forceLowestBitrate);
            Util.writeBoolean(parcel0, this.forceHighestSupportedBitrate);
            Util.writeBoolean(parcel0, this.exceedRendererCapabilitiesIfNecessary);
            parcel0.writeInt(this.tunnelingAudioSessionId);
            Parameters.writeSelectionOverridesToParcel(parcel0, this.selectionOverrides);
            parcel0.writeSparseBooleanArray(this.rendererDisabledFlags);
        }
    }

    public static final class ParametersBuilder extends Builder {
        private boolean allowAudioMixedChannelCountAdaptiveness;
        private boolean allowAudioMixedMimeTypeAdaptiveness;
        private boolean allowAudioMixedSampleRateAdaptiveness;
        private boolean allowVideoMixedMimeTypeAdaptiveness;
        private boolean allowVideoNonSeamlessAdaptiveness;
        private boolean exceedAudioConstraintsIfNecessary;
        private boolean exceedRendererCapabilitiesIfNecessary;
        private boolean exceedVideoConstraintsIfNecessary;
        private boolean forceHighestSupportedBitrate;
        private boolean forceLowestBitrate;
        private int maxAudioBitrate;
        private int maxAudioChannelCount;
        private int maxVideoBitrate;
        private int maxVideoFrameRate;
        private int maxVideoHeight;
        private int maxVideoWidth;
        private final SparseBooleanArray rendererDisabledFlags;
        private final SparseArray selectionOverrides;
        private int tunnelingAudioSessionId;
        private int viewportHeight;
        private boolean viewportOrientationMayChange;
        private int viewportWidth;

        @Deprecated
        public ParametersBuilder() {
            this.setInitialValuesWithoutContext();
            this.selectionOverrides = new SparseArray();
            this.rendererDisabledFlags = new SparseBooleanArray();
        }

        public ParametersBuilder(Context context0) {
            super(context0);
            this.setInitialValuesWithoutContext();
            this.selectionOverrides = new SparseArray();
            this.rendererDisabledFlags = new SparseBooleanArray();
            this.setViewportSizeToPhysicalDisplaySize(context0, true);
        }

        private ParametersBuilder(Parameters defaultTrackSelector$Parameters0) {
            super(defaultTrackSelector$Parameters0);
            this.maxVideoWidth = defaultTrackSelector$Parameters0.maxVideoWidth;
            this.maxVideoHeight = defaultTrackSelector$Parameters0.maxVideoHeight;
            this.maxVideoFrameRate = defaultTrackSelector$Parameters0.maxVideoFrameRate;
            this.maxVideoBitrate = defaultTrackSelector$Parameters0.maxVideoBitrate;
            this.exceedVideoConstraintsIfNecessary = defaultTrackSelector$Parameters0.exceedVideoConstraintsIfNecessary;
            this.allowVideoMixedMimeTypeAdaptiveness = defaultTrackSelector$Parameters0.allowVideoMixedMimeTypeAdaptiveness;
            this.allowVideoNonSeamlessAdaptiveness = defaultTrackSelector$Parameters0.allowVideoNonSeamlessAdaptiveness;
            this.viewportWidth = defaultTrackSelector$Parameters0.viewportWidth;
            this.viewportHeight = defaultTrackSelector$Parameters0.viewportHeight;
            this.viewportOrientationMayChange = defaultTrackSelector$Parameters0.viewportOrientationMayChange;
            this.maxAudioChannelCount = defaultTrackSelector$Parameters0.maxAudioChannelCount;
            this.maxAudioBitrate = defaultTrackSelector$Parameters0.maxAudioBitrate;
            this.exceedAudioConstraintsIfNecessary = defaultTrackSelector$Parameters0.exceedAudioConstraintsIfNecessary;
            this.allowAudioMixedMimeTypeAdaptiveness = defaultTrackSelector$Parameters0.allowAudioMixedMimeTypeAdaptiveness;
            this.allowAudioMixedSampleRateAdaptiveness = defaultTrackSelector$Parameters0.allowAudioMixedSampleRateAdaptiveness;
            this.allowAudioMixedChannelCountAdaptiveness = defaultTrackSelector$Parameters0.allowAudioMixedChannelCountAdaptiveness;
            this.forceLowestBitrate = defaultTrackSelector$Parameters0.forceLowestBitrate;
            this.forceHighestSupportedBitrate = defaultTrackSelector$Parameters0.forceHighestSupportedBitrate;
            this.exceedRendererCapabilitiesIfNecessary = defaultTrackSelector$Parameters0.exceedRendererCapabilitiesIfNecessary;
            this.tunnelingAudioSessionId = defaultTrackSelector$Parameters0.tunnelingAudioSessionId;
            this.selectionOverrides = ParametersBuilder.cloneSelectionOverrides(defaultTrackSelector$Parameters0.selectionOverrides);
            this.rendererDisabledFlags = defaultTrackSelector$Parameters0.rendererDisabledFlags.clone();
        }

        public ParametersBuilder(Parameters defaultTrackSelector$Parameters0, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.1 defaultTrackSelector$10) {
            this(defaultTrackSelector$Parameters0);
        }

        public Parameters build() {
            return new Parameters(this.maxVideoWidth, this.maxVideoHeight, this.maxVideoFrameRate, this.maxVideoBitrate, this.exceedVideoConstraintsIfNecessary, this.allowVideoMixedMimeTypeAdaptiveness, this.allowVideoNonSeamlessAdaptiveness, this.viewportWidth, this.viewportHeight, this.viewportOrientationMayChange, this.preferredAudioLanguage, this.maxAudioChannelCount, this.maxAudioBitrate, this.exceedAudioConstraintsIfNecessary, this.allowAudioMixedMimeTypeAdaptiveness, this.allowAudioMixedSampleRateAdaptiveness, this.allowAudioMixedChannelCountAdaptiveness, this.preferredTextLanguage, this.preferredTextRoleFlags, this.selectUndeterminedTextLanguage, this.disabledTextTrackSelectionFlags, this.forceLowestBitrate, this.forceHighestSupportedBitrate, this.exceedRendererCapabilitiesIfNecessary, this.tunnelingAudioSessionId, this.selectionOverrides, this.rendererDisabledFlags);
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelectionParameters$Builder
        public TrackSelectionParameters build() {
            return this.build();
        }

        public final ParametersBuilder clearSelectionOverride(int v, TrackGroupArray trackGroupArray0) {
            Map map0 = (Map)this.selectionOverrides.get(v);
            if(map0 != null && map0.containsKey(trackGroupArray0)) {
                map0.remove(trackGroupArray0);
                if(map0.isEmpty()) {
                    this.selectionOverrides.remove(v);
                }
            }
            return this;
        }

        public final ParametersBuilder clearSelectionOverrides() {
            if(this.selectionOverrides.size() == 0) {
                return this;
            }
            this.selectionOverrides.clear();
            return this;
        }

        public final ParametersBuilder clearSelectionOverrides(int v) {
            Map map0 = (Map)this.selectionOverrides.get(v);
            if(map0 != null && !map0.isEmpty()) {
                this.selectionOverrides.remove(v);
            }
            return this;
        }

        public ParametersBuilder clearVideoSizeConstraints() {
            return this.setMaxVideoSize(0x7FFFFFFF, 0x7FFFFFFF);
        }

        public ParametersBuilder clearViewportSizeConstraints() {
            return this.setViewportSize(0x7FFFFFFF, 0x7FFFFFFF, true);
        }

        private static SparseArray cloneSelectionOverrides(SparseArray sparseArray0) {
            SparseArray sparseArray1 = new SparseArray();
            for(int v = 0; v < sparseArray0.size(); ++v) {
                sparseArray1.put(sparseArray0.keyAt(v), new HashMap(((Map)sparseArray0.valueAt(v))));
            }
            return sparseArray1;
        }

        public ParametersBuilder setAllowAudioMixedChannelCountAdaptiveness(boolean z) {
            this.allowAudioMixedChannelCountAdaptiveness = z;
            return this;
        }

        public ParametersBuilder setAllowAudioMixedMimeTypeAdaptiveness(boolean z) {
            this.allowAudioMixedMimeTypeAdaptiveness = z;
            return this;
        }

        public ParametersBuilder setAllowAudioMixedSampleRateAdaptiveness(boolean z) {
            this.allowAudioMixedSampleRateAdaptiveness = z;
            return this;
        }

        @Deprecated
        public ParametersBuilder setAllowMixedMimeAdaptiveness(boolean z) {
            this.setAllowAudioMixedMimeTypeAdaptiveness(z);
            this.setAllowVideoMixedMimeTypeAdaptiveness(z);
            return this;
        }

        @Deprecated
        public ParametersBuilder setAllowNonSeamlessAdaptiveness(boolean z) {
            return this.setAllowVideoNonSeamlessAdaptiveness(z);
        }

        public ParametersBuilder setAllowVideoMixedMimeTypeAdaptiveness(boolean z) {
            this.allowVideoMixedMimeTypeAdaptiveness = z;
            return this;
        }

        public ParametersBuilder setAllowVideoNonSeamlessAdaptiveness(boolean z) {
            this.allowVideoNonSeamlessAdaptiveness = z;
            return this;
        }

        public ParametersBuilder setDisabledTextTrackSelectionFlags(int v) {
            super.setDisabledTextTrackSelectionFlags(v);
            return this;
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelectionParameters$Builder
        public Builder setDisabledTextTrackSelectionFlags(int v) {
            return this.setDisabledTextTrackSelectionFlags(v);
        }

        public ParametersBuilder setExceedAudioConstraintsIfNecessary(boolean z) {
            this.exceedAudioConstraintsIfNecessary = z;
            return this;
        }

        public ParametersBuilder setExceedRendererCapabilitiesIfNecessary(boolean z) {
            this.exceedRendererCapabilitiesIfNecessary = z;
            return this;
        }

        public ParametersBuilder setExceedVideoConstraintsIfNecessary(boolean z) {
            this.exceedVideoConstraintsIfNecessary = z;
            return this;
        }

        public ParametersBuilder setForceHighestSupportedBitrate(boolean z) {
            this.forceHighestSupportedBitrate = z;
            return this;
        }

        public ParametersBuilder setForceLowestBitrate(boolean z) {
            this.forceLowestBitrate = z;
            return this;
        }

        private void setInitialValuesWithoutContext() {
            this.maxVideoWidth = 0x7FFFFFFF;
            this.maxVideoHeight = 0x7FFFFFFF;
            this.maxVideoFrameRate = 0x7FFFFFFF;
            this.maxVideoBitrate = 0x7FFFFFFF;
            this.exceedVideoConstraintsIfNecessary = true;
            this.allowVideoMixedMimeTypeAdaptiveness = false;
            this.allowVideoNonSeamlessAdaptiveness = true;
            this.viewportWidth = 0x7FFFFFFF;
            this.viewportHeight = 0x7FFFFFFF;
            this.viewportOrientationMayChange = true;
            this.maxAudioChannelCount = 0x7FFFFFFF;
            this.maxAudioBitrate = 0x7FFFFFFF;
            this.exceedAudioConstraintsIfNecessary = true;
            this.allowAudioMixedMimeTypeAdaptiveness = false;
            this.allowAudioMixedSampleRateAdaptiveness = false;
            this.allowAudioMixedChannelCountAdaptiveness = false;
            this.forceLowestBitrate = false;
            this.forceHighestSupportedBitrate = false;
            this.exceedRendererCapabilitiesIfNecessary = true;
            this.tunnelingAudioSessionId = 0;
        }

        public ParametersBuilder setMaxAudioBitrate(int v) {
            this.maxAudioBitrate = v;
            return this;
        }

        public ParametersBuilder setMaxAudioChannelCount(int v) {
            this.maxAudioChannelCount = v;
            return this;
        }

        public ParametersBuilder setMaxVideoBitrate(int v) {
            this.maxVideoBitrate = v;
            return this;
        }

        public ParametersBuilder setMaxVideoFrameRate(int v) {
            this.maxVideoFrameRate = v;
            return this;
        }

        public ParametersBuilder setMaxVideoSize(int v, int v1) {
            this.maxVideoWidth = v;
            this.maxVideoHeight = v1;
            return this;
        }

        public ParametersBuilder setMaxVideoSizeSd() {
            return this.setMaxVideoSize(0x4FF, 0x2CF);
        }

        public ParametersBuilder setPreferredAudioLanguage(String s) {
            super.setPreferredAudioLanguage(s);
            return this;
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelectionParameters$Builder
        public Builder setPreferredAudioLanguage(String s) {
            return this.setPreferredAudioLanguage(s);
        }

        public ParametersBuilder setPreferredTextLanguage(String s) {
            super.setPreferredTextLanguage(s);
            return this;
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelectionParameters$Builder
        public Builder setPreferredTextLanguage(String s) {
            return this.setPreferredTextLanguage(s);
        }

        public ParametersBuilder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context0) {
            super.setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context0);
            return this;
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelectionParameters$Builder
        public Builder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context0) {
            return this.setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context0);
        }

        public ParametersBuilder setPreferredTextRoleFlags(int v) {
            super.setPreferredTextRoleFlags(v);
            return this;
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelectionParameters$Builder
        public Builder setPreferredTextRoleFlags(int v) {
            return this.setPreferredTextRoleFlags(v);
        }

        public final ParametersBuilder setRendererDisabled(int v, boolean z) {
            if(this.rendererDisabledFlags.get(v) == z) {
                return this;
            }
            if(z) {
                this.rendererDisabledFlags.put(v, true);
                return this;
            }
            this.rendererDisabledFlags.delete(v);
            return this;
        }

        public ParametersBuilder setSelectUndeterminedTextLanguage(boolean z) {
            super.setSelectUndeterminedTextLanguage(z);
            return this;
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelectionParameters$Builder
        public Builder setSelectUndeterminedTextLanguage(boolean z) {
            return this.setSelectUndeterminedTextLanguage(z);
        }

        public final ParametersBuilder setSelectionOverride(int v, TrackGroupArray trackGroupArray0, SelectionOverride defaultTrackSelector$SelectionOverride0) {
            Map map0 = (Map)this.selectionOverrides.get(v);
            if(map0 == null) {
                map0 = new HashMap();
                this.selectionOverrides.put(v, map0);
            }
            if(map0.containsKey(trackGroupArray0) && Util.areEqual(map0.get(trackGroupArray0), defaultTrackSelector$SelectionOverride0)) {
                return this;
            }
            map0.put(trackGroupArray0, defaultTrackSelector$SelectionOverride0);
            return this;
        }

        public ParametersBuilder setTunnelingAudioSessionId(int v) {
            this.tunnelingAudioSessionId = v;
            return this;
        }

        public ParametersBuilder setViewportSize(int v, int v1, boolean z) {
            this.viewportWidth = v;
            this.viewportHeight = v1;
            this.viewportOrientationMayChange = z;
            return this;
        }

        public ParametersBuilder setViewportSizeToPhysicalDisplaySize(Context context0, boolean z) {
            Point point0 = Util.getCurrentDisplayModeSize(context0);
            return this.setViewportSize(point0.x, point0.y, z);
        }
    }

    public static final class SelectionOverride implements Parcelable {
        public static final Parcelable.Creator CREATOR;
        public final int data;
        public final int groupIndex;
        public final int length;
        public final int reason;
        public final int[] tracks;

        static {
            SelectionOverride.CREATOR = new Parcelable.Creator() {
                public SelectionOverride createFromParcel(Parcel parcel0) {
                    return new SelectionOverride(parcel0);
                }

                @Override  // android.os.Parcelable$Creator
                public Object createFromParcel(Parcel parcel0) {
                    return this.createFromParcel(parcel0);
                }

                public SelectionOverride[] newArray(int v) {
                    return new SelectionOverride[v];
                }

                @Override  // android.os.Parcelable$Creator
                public Object[] newArray(int v) {
                    return this.newArray(v);
                }
            };
        }

        public SelectionOverride(int v, int[] arr_v) {
            this(v, arr_v, 2, 0);
        }

        public SelectionOverride(int v, int[] arr_v, int v1, int v2) {
            this.groupIndex = v;
            int[] arr_v1 = Arrays.copyOf(arr_v, arr_v.length);
            this.tracks = arr_v1;
            this.length = arr_v.length;
            this.reason = v1;
            this.data = v2;
            Arrays.sort(arr_v1);
        }

        public SelectionOverride(Parcel parcel0) {
            this.groupIndex = parcel0.readInt();
            int v = parcel0.readByte();
            this.length = v;
            int[] arr_v = new int[v];
            this.tracks = arr_v;
            parcel0.readIntArray(arr_v);
            this.reason = parcel0.readInt();
            this.data = parcel0.readInt();
        }

        public boolean containsTrack(int v) {
            int[] arr_v = this.tracks;
            for(int v1 = 0; v1 < arr_v.length; ++v1) {
                if(arr_v[v1] == v) {
                    return true;
                }
            }
            return false;
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
                return SelectionOverride.class == class0 && this.groupIndex == ((SelectionOverride)object0).groupIndex && Arrays.equals(this.tracks, ((SelectionOverride)object0).tracks) && this.reason == ((SelectionOverride)object0).reason && this.data == ((SelectionOverride)object0).data;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return ((Arrays.hashCode(this.tracks) + this.groupIndex * 0x1F) * 0x1F + this.reason) * 0x1F + this.data;
        }

        @Override  // android.os.Parcelable
        public void writeToParcel(Parcel parcel0, int v) {
            parcel0.writeInt(this.groupIndex);
            parcel0.writeInt(this.tracks.length);
            parcel0.writeIntArray(this.tracks);
            parcel0.writeInt(this.reason);
            parcel0.writeInt(this.data);
        }
    }

    public static final class TextTrackScore implements Comparable {
        private final boolean hasCaptionRoleFlags;
        private final boolean hasPreferredIsForcedFlag;
        private final boolean isDefault;
        public final boolean isWithinConstraints;
        private final boolean isWithinRendererCapabilities;
        private final int preferredLanguageScore;
        private final int preferredRoleFlagsScore;
        private final int selectedAudioLanguageScore;

        public TextTrackScore(Format format0, Parameters defaultTrackSelector$Parameters0, int v, String s) {
            boolean z = false;
            this.isWithinRendererCapabilities = DefaultTrackSelector.isSupported(v, false);
            int v1 = format0.selectionFlags & ~defaultTrackSelector$Parameters0.disabledTextTrackSelectionFlags;
            boolean z1 = (v1 & 1) != 0;
            this.isDefault = z1;
            boolean z2 = (v1 & 2) != 0;
            int v2 = DefaultTrackSelector.getFormatLanguageScore(format0, defaultTrackSelector$Parameters0.preferredTextLanguage, defaultTrackSelector$Parameters0.selectUndeterminedTextLanguage);
            this.preferredLanguageScore = v2;
            int v3 = Integer.bitCount(format0.roleFlags & defaultTrackSelector$Parameters0.preferredTextRoleFlags);
            this.preferredRoleFlagsScore = v3;
            this.hasCaptionRoleFlags = (format0.roleFlags & 0x440) != 0;
            this.hasPreferredIsForcedFlag = v2 > 0 && !z2 || v2 == 0 && z2;
            int v4 = DefaultTrackSelector.getFormatLanguageScore(format0, s, DefaultTrackSelector.normalizeUndeterminedLanguageToNull(s) == null);
            this.selectedAudioLanguageScore = v4;
            if(v2 > 0 || defaultTrackSelector$Parameters0.preferredTextLanguage == null && v3 > 0 || z1 || z2 && v4 > 0) {
                z = true;
            }
            this.isWithinConstraints = z;
        }

        public int compareTo(TextTrackScore defaultTrackSelector$TextTrackScore0) {
            boolean z = this.isWithinRendererCapabilities;
            if(z != defaultTrackSelector$TextTrackScore0.isWithinRendererCapabilities) {
                return z ? 1 : -1;
            }
            int v = this.preferredLanguageScore;
            int v1 = defaultTrackSelector$TextTrackScore0.preferredLanguageScore;
            if(v != v1) {
                return DefaultTrackSelector.compareInts(v, v1);
            }
            int v2 = this.preferredRoleFlagsScore;
            int v3 = defaultTrackSelector$TextTrackScore0.preferredRoleFlagsScore;
            if(v2 != v3) {
                return DefaultTrackSelector.compareInts(v2, v3);
            }
            boolean z1 = this.isDefault;
            if(z1 != defaultTrackSelector$TextTrackScore0.isDefault) {
                return z1 ? 1 : -1;
            }
            boolean z2 = this.hasPreferredIsForcedFlag;
            if(z2 != defaultTrackSelector$TextTrackScore0.hasPreferredIsForcedFlag) {
                return z2 ? 1 : -1;
            }
            int v4 = this.selectedAudioLanguageScore;
            int v5 = defaultTrackSelector$TextTrackScore0.selectedAudioLanguageScore;
            if(v4 != v5) {
                return DefaultTrackSelector.compareInts(v4, v5);
            }
            if(v2 == 0) {
                boolean z3 = this.hasCaptionRoleFlags;
                if(z3 != defaultTrackSelector$TextTrackScore0.hasCaptionRoleFlags) {
                    return z3 ? -1 : 1;
                }
            }
            return 0;
        }

        @Override
        public int compareTo(Object object0) {
            return this.compareTo(((TextTrackScore)object0));
        }
    }

    private static final float FRACTION_TO_CONSIDER_FULLSCREEN = 0.98f;
    private static final int[] NO_TRACKS = null;
    private static final int WITHIN_RENDERER_CAPABILITIES_BONUS = 1000;
    private boolean allowMultipleAdaptiveSelections;
    private final AtomicReference parametersReference;
    private final Factory trackSelectionFactory;

    static {
        DefaultTrackSelector.NO_TRACKS = new int[0];
    }

    @Deprecated
    public DefaultTrackSelector() {
        this(new com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.Factory());
    }

    public DefaultTrackSelector(Context context0) {
        this(context0, new com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.Factory());
    }

    public DefaultTrackSelector(Context context0, Factory trackSelection$Factory0) {
        this(Parameters.getDefaults(context0), trackSelection$Factory0);
    }

    public DefaultTrackSelector(Parameters defaultTrackSelector$Parameters0, Factory trackSelection$Factory0) {
        this.trackSelectionFactory = trackSelection$Factory0;
        this.parametersReference = new AtomicReference(defaultTrackSelector$Parameters0);
    }

    @Deprecated
    public DefaultTrackSelector(Factory trackSelection$Factory0) {
        this(Parameters.DEFAULT_WITHOUT_CONTEXT, trackSelection$Factory0);
    }

    @Deprecated
    public DefaultTrackSelector(BandwidthMeter bandwidthMeter0) {
        this(new com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.Factory(bandwidthMeter0));
    }

    public ParametersBuilder buildUponParameters() {
        return this.getParameters().buildUpon();
    }

    @Deprecated
    public final void clearSelectionOverride(int v, TrackGroupArray trackGroupArray0) {
        this.setParameters(this.buildUponParameters().clearSelectionOverride(v, trackGroupArray0));
    }

    @Deprecated
    public final void clearSelectionOverrides() {
        this.setParameters(this.buildUponParameters().clearSelectionOverrides());
    }

    @Deprecated
    public final void clearSelectionOverrides(int v) {
        this.setParameters(this.buildUponParameters().clearSelectionOverrides(v));
    }

    private static int compareFormatValues(int v, int v1) {
        if(v == -1) {
            return v1 == -1 ? 0 : -1;
        }
        return v1 == -1 ? 1 : v - v1;
    }

    private static int compareInts(int v, int v1) {
        if(v > v1) {
            return 1;
        }
        return v1 <= v ? 0 : -1;
    }

    public void experimental_allowMultipleAdaptiveSelections() {
        this.allowMultipleAdaptiveSelections = true;
    }

    private static void filterAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup0, int[] arr_v, int v, String s, int v1, int v2, int v3, int v4, List list0) {
        for(int v5 = list0.size() - 1; v5 >= 0; --v5) {
            int v6 = (int)(((Integer)list0.get(v5)));
            if(!DefaultTrackSelector.isSupportedAdaptiveVideoTrack(trackGroup0.getFormat(v6), s, arr_v[v6], v, v1, v2, v3, v4)) {
                list0.remove(v5);
            }
        }
    }

    private static int getAdaptiveAudioTrackCount(TrackGroup trackGroup0, int[] arr_v, AudioConfigurationTuple defaultTrackSelector$AudioConfigurationTuple0, int v, boolean z, boolean z1, boolean z2) {
        int v2 = 0;
        for(int v1 = 0; v1 < trackGroup0.length; ++v1) {
            if(DefaultTrackSelector.isSupportedAdaptiveAudioTrack(trackGroup0.getFormat(v1), arr_v[v1], defaultTrackSelector$AudioConfigurationTuple0, v, z, z1, z2)) {
                ++v2;
            }
        }
        return v2;
    }

    private static int[] getAdaptiveAudioTracks(TrackGroup trackGroup0, int[] arr_v, int v, boolean z, boolean z1, boolean z2) {
        HashSet hashSet0 = new HashSet();
        AudioConfigurationTuple defaultTrackSelector$AudioConfigurationTuple0 = null;
        int v3 = 0;
        for(int v2 = 0; v2 < trackGroup0.length; ++v2) {
            Format format0 = trackGroup0.getFormat(v2);
            AudioConfigurationTuple defaultTrackSelector$AudioConfigurationTuple1 = new AudioConfigurationTuple(format0.channelCount, format0.sampleRate, format0.sampleMimeType);
            if(hashSet0.add(defaultTrackSelector$AudioConfigurationTuple1)) {
                int v4 = DefaultTrackSelector.getAdaptiveAudioTrackCount(trackGroup0, arr_v, defaultTrackSelector$AudioConfigurationTuple1, v, z, z1, z2);
                if(v4 > v3) {
                    defaultTrackSelector$AudioConfigurationTuple0 = defaultTrackSelector$AudioConfigurationTuple1;
                    v3 = v4;
                }
            }
        }
        if(v3 > 1) {
            Assertions.checkNotNull(defaultTrackSelector$AudioConfigurationTuple0);
            int[] arr_v1 = new int[v3];
            int v5 = 0;
            for(int v1 = 0; v1 < trackGroup0.length; ++v1) {
                if(DefaultTrackSelector.isSupportedAdaptiveAudioTrack(trackGroup0.getFormat(v1), arr_v[v1], defaultTrackSelector$AudioConfigurationTuple0, v, z, z1, z2)) {
                    arr_v1[v5] = v1;
                    ++v5;
                }
            }
            return arr_v1;
        }
        return DefaultTrackSelector.NO_TRACKS;
    }

    private static int getAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup0, int[] arr_v, int v, String s, int v1, int v2, int v3, int v4, List list0) {
        int v6 = 0;
        for(int v5 = 0; v5 < list0.size(); ++v5) {
            int v7 = (int)(((Integer)list0.get(v5)));
            if(DefaultTrackSelector.isSupportedAdaptiveVideoTrack(trackGroup0.getFormat(v7), s, arr_v[v7], v, v1, v2, v3, v4)) {
                ++v6;
            }
        }
        return v6;
    }

    private static int[] getAdaptiveVideoTracksForGroup(TrackGroup trackGroup0, int[] arr_v, boolean z, int v, int v1, int v2, int v3, int v4, int v5, int v6, boolean z1) {
        String s2;
        int v15;
        int v14;
        int v13;
        int v12;
        int v10;
        int v9;
        if(trackGroup0.length < 2) {
            return DefaultTrackSelector.NO_TRACKS;
        }
        List list0 = DefaultTrackSelector.getViewportFilteredTrackIndices(trackGroup0, v5, v6, z1);
        if(list0.size() < 2) {
            return DefaultTrackSelector.NO_TRACKS;
        }
        if(z) {
            v13 = v2;
            v14 = v1;
            v15 = v4;
            s2 = null;
        }
        else {
            HashSet hashSet0 = new HashSet();
            int v7 = 0;
            int v8 = 0;
            String s = null;
            while(v7 < list0.size()) {
                String s1 = trackGroup0.getFormat(((int)(((Integer)list0.get(v7))))).sampleMimeType;
                if(hashSet0.add(s1)) {
                    v9 = v2;
                    v10 = v1;
                    int v11 = DefaultTrackSelector.getAdaptiveVideoTrackCountForMimeType(trackGroup0, arr_v, v, s1, v10, v9, v3, v4, list0);
                    v12 = v4;
                    if(v11 > v8) {
                        v8 = v11;
                        s = s1;
                    }
                }
                else {
                    v10 = v1;
                    v12 = v4;
                    v9 = v2;
                }
                ++v7;
                v4 = v12;
                v1 = v10;
                v2 = v9;
            }
            v13 = v2;
            v14 = v1;
            v15 = v4;
            s2 = s;
        }
        DefaultTrackSelector.filterAdaptiveVideoTrackCountForMimeType(trackGroup0, arr_v, v, s2, v14, v13, v3, v15, list0);
        return list0.size() >= 2 ? Util.toArray(list0) : DefaultTrackSelector.NO_TRACKS;
    }

    public static int getFormatLanguageScore(Format format0, String s, boolean z) {
        if(!TextUtils.isEmpty(s) && s.equals(format0.language)) {
            return 4;
        }
        String s1 = DefaultTrackSelector.normalizeUndeterminedLanguageToNull(s);
        String s2 = DefaultTrackSelector.normalizeUndeterminedLanguageToNull(format0.language);
        if(s2 != null && s1 != null) {
            if(!s2.startsWith(s1) && !s1.startsWith(s2)) {
                return Util.splitAtFirst(s2, "-")[0].equals(Util.splitAtFirst(s1, "-")[0]) ? 2 : 0;
            }
            return 3;
        }
        return !z || s2 != null ? 0 : 1;
    }

    private static Point getMaxVideoSizeInViewport(boolean z, int v, int v1, int v2, int v3) {
        int v4 = 0;
        if(z) {
            if(v > v1) {
                v4 = 1;
            }
            if((v2 <= v3 ? 0 : 1) == v4) {
                goto label_5;
            }
        }
        else {
        label_5:
            int v5 = v1;
            v1 = v;
            v = v5;
        }
        int v6 = v2 * v;
        int v7 = v3 * v1;
        return v6 < v7 ? new Point((v6 + v3 - 1) / v3, v) : new Point(v1, (v7 + v2 - 1) / v2);
    }

    public Parameters getParameters() {
        return (Parameters)this.parametersReference.get();
    }

    @Deprecated
    public final boolean getRendererDisabled(int v) {
        return this.getParameters().getRendererDisabled(v);
    }

    @Deprecated
    public final SelectionOverride getSelectionOverride(int v, TrackGroupArray trackGroupArray0) {
        return this.getParameters().getSelectionOverride(v, trackGroupArray0);
    }

    private static List getViewportFilteredTrackIndices(TrackGroup trackGroup0, int v, int v1, boolean z) {
        List list0 = new ArrayList(trackGroup0.length);
        for(int v3 = 0; v3 < trackGroup0.length; v3 = a.d(v3, v3, 1, ((ArrayList)list0))) {
        }
        if(v != 0x7FFFFFFF && v1 != 0x7FFFFFFF) {
            int v4 = 0x7FFFFFFF;
            for(int v2 = 0; v2 < trackGroup0.length; ++v2) {
                Format format0 = trackGroup0.getFormat(v2);
                int v5 = format0.width;
                if(v5 > 0) {
                    int v6 = format0.height;
                    if(v6 > 0) {
                        Point point0 = DefaultTrackSelector.getMaxVideoSizeInViewport(z, v, v1, v5, v6);
                        int v7 = format0.width * format0.height;
                        if(format0.width >= ((int)(((float)point0.x) * 0.98f)) && format0.height >= ((int)(((float)point0.y) * 0.98f)) && v7 < v4) {
                            v4 = v7;
                        }
                    }
                }
            }
            if(v4 != 0x7FFFFFFF) {
                for(int v8 = ((ArrayList)list0).size() - 1; v8 >= 0; --v8) {
                    int v9 = trackGroup0.getFormat(((int)(((Integer)((ArrayList)list0).get(v8))))).getPixelCount();
                    if(v9 == -1 || v9 > v4) {
                        ((ArrayList)list0).remove(v8);
                    }
                }
            }
        }
        return list0;
    }

    @Deprecated
    public final boolean hasSelectionOverride(int v, TrackGroupArray trackGroupArray0) {
        return this.getParameters().hasSelectionOverride(v, trackGroupArray0);
    }

    public static boolean isSupported(int v, boolean z) {
        return (v & 7) == 4 || z && (v & 7) == 3;
    }

    // 去混淆评级： 中等(60)
    private static boolean isSupportedAdaptiveAudioTrack(Format format0, int v, AudioConfigurationTuple defaultTrackSelector$AudioConfigurationTuple0, int v1, boolean z, boolean z1, boolean z2) {
        return DefaultTrackSelector.isSupported(v, false) && (format0.bitrate == -1 || format0.bitrate <= v1) && (z2 || format0.channelCount != -1 && format0.channelCount == defaultTrackSelector$AudioConfigurationTuple0.channelCount) && (z || format0.sampleMimeType != null && TextUtils.equals(format0.sampleMimeType, defaultTrackSelector$AudioConfigurationTuple0.mimeType)) && (z1 || format0.sampleRate != -1 && format0.sampleRate == defaultTrackSelector$AudioConfigurationTuple0.sampleRate);
    }

    // 去混淆评级： 中等(60)
    private static boolean isSupportedAdaptiveVideoTrack(Format format0, String s, int v, int v1, int v2, int v3, int v4, int v5) {
        return (format0.roleFlags & 0x4000) == 0 ? DefaultTrackSelector.isSupported(v, false) && (v & v1) != 0 && (s == null || Util.areEqual(format0.sampleMimeType, s)) && (format0.width == -1 || format0.width <= v2) && (format0.height == -1 || format0.height <= v3) && (format0.frameRate == -1.0f || format0.frameRate <= ((float)v4)) && (format0.bitrate == -1 || format0.bitrate <= v5) : false;
    }

    private static void maybeConfigureRenderersForTunneling(MappedTrackInfo mappingTrackSelector$MappedTrackInfo0, int[][][] arr3_v, RendererConfiguration[] arr_rendererConfiguration, TrackSelection[] arr_trackSelection, int v) {
        if(v != 0) {
            int v1 = 0;
            int v3 = -1;
            int v4 = -1;
            for(int v2 = 0; true; ++v2) {
                int v5 = 1;
                if(v2 >= mappingTrackSelector$MappedTrackInfo0.getRendererCount()) {
                    break;
                }
                int v6 = mappingTrackSelector$MappedTrackInfo0.getRendererType(v2);
                TrackSelection trackSelection0 = arr_trackSelection[v2];
                if((v6 == 1 || v6 == 2) && trackSelection0 != null && DefaultTrackSelector.rendererSupportsTunneling(arr3_v[v2], mappingTrackSelector$MappedTrackInfo0.getTrackGroups(v2), trackSelection0)) {
                    if(v6 != 1) {
                        if(v3 == -1) {
                            v3 = v2;
                            continue;
                        }
                    }
                    else if(v4 == -1) {
                        v4 = v2;
                        continue;
                    }
                    v5 = 0;
                    break;
                }
            }
            if(v4 != -1 && v3 != -1) {
                v1 = 1;
            }
            if((v5 & v1) != 0) {
                RendererConfiguration rendererConfiguration0 = new RendererConfiguration(v);
                arr_rendererConfiguration[v4] = rendererConfiguration0;
                arr_rendererConfiguration[v3] = rendererConfiguration0;
            }
        }
    }

    // 去混淆评级： 低(20)
    public static String normalizeUndeterminedLanguageToNull(String s) {
        return TextUtils.isEmpty(s) || TextUtils.equals(s, "und") ? null : s;
    }

    private static boolean rendererSupportsTunneling(int[][] arr2_v, TrackGroupArray trackGroupArray0, TrackSelection trackSelection0) {
        if(trackSelection0 == null) {
            return false;
        }
        int v = trackGroupArray0.indexOf(trackSelection0.getTrackGroup());
        for(int v1 = 0; v1 < trackSelection0.length(); ++v1) {
            int[] arr_v = arr2_v[v];
            if(RendererCapabilities.getTunnelingSupport(arr_v[trackSelection0.getIndexInTrackGroup(v1)]) != 0x20) {
                return false;
            }
        }
        return true;
    }

    private static Definition selectAdaptiveVideoTrack(TrackGroupArray trackGroupArray0, int[][] arr2_v, int v, Parameters defaultTrackSelector$Parameters0) {
        int v1 = defaultTrackSelector$Parameters0.allowVideoNonSeamlessAdaptiveness ? 24 : 16;
        boolean z = defaultTrackSelector$Parameters0.allowVideoMixedMimeTypeAdaptiveness && (v & v1) != 0;
        for(int v2 = 0; v2 < trackGroupArray0.length; ++v2) {
            TrackGroup trackGroup0 = trackGroupArray0.get(v2);
            int[] arr_v = DefaultTrackSelector.getAdaptiveVideoTracksForGroup(trackGroup0, arr2_v[v2], z, v1, defaultTrackSelector$Parameters0.maxVideoWidth, defaultTrackSelector$Parameters0.maxVideoHeight, defaultTrackSelector$Parameters0.maxVideoFrameRate, defaultTrackSelector$Parameters0.maxVideoBitrate, defaultTrackSelector$Parameters0.viewportWidth, defaultTrackSelector$Parameters0.viewportHeight, defaultTrackSelector$Parameters0.viewportOrientationMayChange);
            if(arr_v.length > 0) {
                return new Definition(trackGroup0, arr_v);
            }
        }
        return null;
    }

    public Definition[] selectAllTracks(MappedTrackInfo mappingTrackSelector$MappedTrackInfo0, int[][][] arr3_v, int[] arr_v, Parameters defaultTrackSelector$Parameters0) {
        String s2;
        DefaultTrackSelector defaultTrackSelector1;
        int v6;
        AudioTrackScore defaultTrackSelector$AudioTrackScore1;
        String s1;
        int v = mappingTrackSelector$MappedTrackInfo0.getRendererCount();
        Definition[] arr_trackSelection$Definition = new Definition[v];
        boolean z = false;
        int v2 = 0;
        for(int v1 = 0; true; ++v1) {
            int v3 = 1;
            if(v1 >= v) {
                break;
            }
            if(2 == mappingTrackSelector$MappedTrackInfo0.getRendererType(v1)) {
                if(!z) {
                    Definition trackSelection$Definition0 = this.selectVideoTrack(mappingTrackSelector$MappedTrackInfo0.getTrackGroups(v1), arr3_v[v1], arr_v[v1], defaultTrackSelector$Parameters0, true);
                    arr_trackSelection$Definition[v1] = trackSelection$Definition0;
                    z = trackSelection$Definition0 != null;
                }
                if(mappingTrackSelector$MappedTrackInfo0.getTrackGroups(v1).length <= 0) {
                    v3 = 0;
                }
                v2 |= v3;
            }
        }
        DefaultTrackSelector defaultTrackSelector0 = this;
        int v4 = -1;
        String s = null;
        AudioTrackScore defaultTrackSelector$AudioTrackScore0 = null;
        int v5 = 0;
        while(v5 < v) {
            if(1 == mappingTrackSelector$MappedTrackInfo0.getRendererType(v5)) {
                s1 = s;
                defaultTrackSelector$AudioTrackScore1 = defaultTrackSelector$AudioTrackScore0;
                v6 = v4;
                defaultTrackSelector1 = this;
                Pair pair0 = defaultTrackSelector1.selectAudioTrack(mappingTrackSelector$MappedTrackInfo0.getTrackGroups(v5), arr3_v[v5], arr_v[v5], defaultTrackSelector$Parameters0, defaultTrackSelector0.allowMultipleAdaptiveSelections || v2 == 0);
                if(pair0 != null && (defaultTrackSelector$AudioTrackScore1 == null || ((AudioTrackScore)pair0.second).compareTo(defaultTrackSelector$AudioTrackScore1) > 0)) {
                    if(v6 != -1) {
                        arr_trackSelection$Definition[v6] = null;
                    }
                    Definition trackSelection$Definition1 = (Definition)pair0.first;
                    arr_trackSelection$Definition[v5] = trackSelection$Definition1;
                    s2 = trackSelection$Definition1.group.getFormat(trackSelection$Definition1.tracks[0]).language;
                    defaultTrackSelector$AudioTrackScore0 = (AudioTrackScore)pair0.second;
                    v4 = v5;
                    goto label_45;
                }
            }
            else {
                s1 = s;
                defaultTrackSelector$AudioTrackScore1 = defaultTrackSelector$AudioTrackScore0;
                defaultTrackSelector1 = defaultTrackSelector0;
                v6 = v4;
            }
            s2 = s1;
            v4 = v6;
            defaultTrackSelector$AudioTrackScore0 = defaultTrackSelector$AudioTrackScore1;
        label_45:
            ++v5;
            defaultTrackSelector0 = defaultTrackSelector1;
            s = s2;
        }
        int v7 = -1;
        TextTrackScore defaultTrackSelector$TextTrackScore0 = null;
        for(int v8 = 0; v8 < v; ++v8) {
            int v9 = mappingTrackSelector$MappedTrackInfo0.getRendererType(v8);
            if(v9 != 1 && v9 != 2) {
                if(v9 == 3) {
                    Pair pair1 = defaultTrackSelector0.selectTextTrack(mappingTrackSelector$MappedTrackInfo0.getTrackGroups(v8), arr3_v[v8], defaultTrackSelector$Parameters0, s);
                    if(pair1 != null && (defaultTrackSelector$TextTrackScore0 == null || ((TextTrackScore)pair1.second).compareTo(defaultTrackSelector$TextTrackScore0) > 0)) {
                        if(v7 != -1) {
                            arr_trackSelection$Definition[v7] = null;
                        }
                        arr_trackSelection$Definition[v8] = (Definition)pair1.first;
                        defaultTrackSelector$TextTrackScore0 = (TextTrackScore)pair1.second;
                        v7 = v8;
                    }
                }
                else {
                    arr_trackSelection$Definition[v8] = defaultTrackSelector0.selectOtherTrack(v9, mappingTrackSelector$MappedTrackInfo0.getTrackGroups(v8), arr3_v[v8], defaultTrackSelector$Parameters0);
                }
            }
        }
        return arr_trackSelection$Definition;
    }

    public Pair selectAudioTrack(TrackGroupArray trackGroupArray0, int[][] arr2_v, int v, Parameters defaultTrackSelector$Parameters0, boolean z) {
        Definition trackSelection$Definition0 = null;
        int v1 = -1;
        int v2 = -1;
        AudioTrackScore defaultTrackSelector$AudioTrackScore0 = null;
        for(int v3 = 0; v3 < trackGroupArray0.length; ++v3) {
            TrackGroup trackGroup0 = trackGroupArray0.get(v3);
            int[] arr_v = arr2_v[v3];
            for(int v4 = 0; v4 < trackGroup0.length; ++v4) {
                if(DefaultTrackSelector.isSupported(arr_v[v4], defaultTrackSelector$Parameters0.exceedRendererCapabilitiesIfNecessary)) {
                    AudioTrackScore defaultTrackSelector$AudioTrackScore1 = new AudioTrackScore(trackGroup0.getFormat(v4), defaultTrackSelector$Parameters0, arr_v[v4]);
                    if((defaultTrackSelector$AudioTrackScore1.isWithinConstraints || defaultTrackSelector$Parameters0.exceedAudioConstraintsIfNecessary) && (defaultTrackSelector$AudioTrackScore0 == null || defaultTrackSelector$AudioTrackScore1.compareTo(defaultTrackSelector$AudioTrackScore0) > 0)) {
                        v1 = v3;
                        v2 = v4;
                        defaultTrackSelector$AudioTrackScore0 = defaultTrackSelector$AudioTrackScore1;
                    }
                }
            }
        }
        if(v1 == -1) {
            return null;
        }
        TrackGroup trackGroup1 = trackGroupArray0.get(v1);
        if(!defaultTrackSelector$Parameters0.forceHighestSupportedBitrate && !defaultTrackSelector$Parameters0.forceLowestBitrate && z) {
            int[] arr_v1 = DefaultTrackSelector.getAdaptiveAudioTracks(trackGroup1, arr2_v[v1], defaultTrackSelector$Parameters0.maxAudioBitrate, defaultTrackSelector$Parameters0.allowAudioMixedMimeTypeAdaptiveness, defaultTrackSelector$Parameters0.allowAudioMixedSampleRateAdaptiveness, defaultTrackSelector$Parameters0.allowAudioMixedChannelCountAdaptiveness);
            if(arr_v1.length > 0) {
                trackSelection$Definition0 = new Definition(trackGroup1, arr_v1);
            }
        }
        if(trackSelection$Definition0 == null) {
            trackSelection$Definition0 = new Definition(trackGroup1, new int[]{v2});
        }
        return Pair.create(trackSelection$Definition0, ((AudioTrackScore)Assertions.checkNotNull(defaultTrackSelector$AudioTrackScore0)));
    }

    private static Definition selectFixedVideoTrack(TrackGroupArray trackGroupArray0, int[][] arr2_v, Parameters defaultTrackSelector$Parameters0) {
        int v9;
        int v = -1;
        int v1 = -1;
        TrackGroup trackGroup0 = null;
        int v3 = 0;
        int v4 = 0;
        for(int v2 = 0; v2 < trackGroupArray0.length; ++v2) {
            TrackGroup trackGroup1 = trackGroupArray0.get(v2);
            List list0 = DefaultTrackSelector.getViewportFilteredTrackIndices(trackGroup1, defaultTrackSelector$Parameters0.viewportWidth, defaultTrackSelector$Parameters0.viewportHeight, defaultTrackSelector$Parameters0.viewportOrientationMayChange);
            int[] arr_v = arr2_v[v2];
            for(int v5 = 0; v5 < trackGroup1.length; ++v5) {
                Format format0 = trackGroup1.getFormat(v5);
                if((format0.roleFlags & 0x4000) == 0 && DefaultTrackSelector.isSupported(arr_v[v5], defaultTrackSelector$Parameters0.exceedRendererCapabilitiesIfNecessary)) {
                    boolean z = list0.contains(v5) && (format0.width == -1 || format0.width <= defaultTrackSelector$Parameters0.maxVideoWidth) && (format0.height == -1 || format0.height <= defaultTrackSelector$Parameters0.maxVideoHeight) && (format0.frameRate == -1.0f || format0.frameRate <= ((float)defaultTrackSelector$Parameters0.maxVideoFrameRate)) && (format0.bitrate == -1 || format0.bitrate <= defaultTrackSelector$Parameters0.maxVideoBitrate);
                    if(z || defaultTrackSelector$Parameters0.exceedVideoConstraintsIfNecessary) {
                        int v6 = z ? 2 : 1;
                        boolean z1 = DefaultTrackSelector.isSupported(arr_v[v5], false);
                        if(z1) {
                            v6 += 1000;
                        }
                        int v7 = v6 <= v4 ? 0 : 1;
                        if(v6 == v4) {
                            int v8 = DefaultTrackSelector.compareFormatValues(format0.bitrate, v);
                            if(!defaultTrackSelector$Parameters0.forceLowestBitrate || v8 == 0) {
                                int v10 = format0.getPixelCount();
                                int v11 = v10 == v1 ? DefaultTrackSelector.compareFormatValues(format0.bitrate, v) : DefaultTrackSelector.compareFormatValues(v10, v1);
                                if(!z1 || !z) {
                                    if(v11 < 0) {
                                        v9 = 1;
                                    }
                                }
                                else if(v11 > 0) {
                                    v9 = 1;
                                }
                            }
                            else if(v8 < 0) {
                                v9 = 1;
                            }
                            else {
                                v9 = 0;
                            }
                            v7 = v9;
                        }
                        if(v7 != 0) {
                            v = format0.bitrate;
                            v1 = format0.getPixelCount();
                            v4 = v6;
                            trackGroup0 = trackGroup1;
                            v3 = v5;
                        }
                    }
                }
            }
        }
        return trackGroup0 == null ? null : new Definition(trackGroup0, new int[]{v3});
    }

    public Definition selectOtherTrack(int v, TrackGroupArray trackGroupArray0, int[][] arr2_v, Parameters defaultTrackSelector$Parameters0) {
        TrackGroup trackGroup0 = null;
        int v2 = 0;
        int v3 = 0;
        for(int v1 = 0; v1 < trackGroupArray0.length; ++v1) {
            TrackGroup trackGroup1 = trackGroupArray0.get(v1);
            int[] arr_v = arr2_v[v1];
            for(int v4 = 0; true; ++v4) {
                int v5 = 1;
                if(v4 >= trackGroup1.length) {
                    break;
                }
                if(DefaultTrackSelector.isSupported(arr_v[v4], defaultTrackSelector$Parameters0.exceedRendererCapabilitiesIfNecessary)) {
                    if((trackGroup1.getFormat(v4).selectionFlags & 1) != 0) {
                        v5 = 2;
                    }
                    if(DefaultTrackSelector.isSupported(arr_v[v4], false)) {
                        v5 += 1000;
                    }
                    if(v5 > v3) {
                        trackGroup0 = trackGroup1;
                        v2 = v4;
                        v3 = v5;
                    }
                }
            }
        }
        return trackGroup0 == null ? null : new Definition(trackGroup0, new int[]{v2});
    }

    public Pair selectTextTrack(TrackGroupArray trackGroupArray0, int[][] arr2_v, Parameters defaultTrackSelector$Parameters0, String s) {
        int v = -1;
        TrackGroup trackGroup0 = null;
        TextTrackScore defaultTrackSelector$TextTrackScore0 = null;
        for(int v1 = 0; v1 < trackGroupArray0.length; ++v1) {
            TrackGroup trackGroup1 = trackGroupArray0.get(v1);
            int[] arr_v = arr2_v[v1];
            for(int v2 = 0; v2 < trackGroup1.length; ++v2) {
                if(DefaultTrackSelector.isSupported(arr_v[v2], defaultTrackSelector$Parameters0.exceedRendererCapabilitiesIfNecessary)) {
                    TextTrackScore defaultTrackSelector$TextTrackScore1 = new TextTrackScore(trackGroup1.getFormat(v2), defaultTrackSelector$Parameters0, arr_v[v2], s);
                    if(defaultTrackSelector$TextTrackScore1.isWithinConstraints && (defaultTrackSelector$TextTrackScore0 == null || defaultTrackSelector$TextTrackScore1.compareTo(defaultTrackSelector$TextTrackScore0) > 0)) {
                        trackGroup0 = trackGroup1;
                        v = v2;
                        defaultTrackSelector$TextTrackScore0 = defaultTrackSelector$TextTrackScore1;
                    }
                }
            }
        }
        return trackGroup0 == null ? null : Pair.create(new Definition(trackGroup0, new int[]{v}), ((TextTrackScore)Assertions.checkNotNull(defaultTrackSelector$TextTrackScore0)));
    }

    @Override  // com.google.android.exoplayer2.trackselection.MappingTrackSelector
    public final Pair selectTracks(MappedTrackInfo mappingTrackSelector$MappedTrackInfo0, int[][][] arr3_v, int[] arr_v) {
        Parameters defaultTrackSelector$Parameters0 = (Parameters)this.parametersReference.get();
        int v = mappingTrackSelector$MappedTrackInfo0.getRendererCount();
        Definition[] arr_trackSelection$Definition = this.selectAllTracks(mappingTrackSelector$MappedTrackInfo0, arr3_v, arr_v, defaultTrackSelector$Parameters0);
        for(int v2 = 0; true; ++v2) {
            Definition trackSelection$Definition0 = null;
            if(v2 >= v) {
                break;
            }
            if(defaultTrackSelector$Parameters0.getRendererDisabled(v2)) {
                arr_trackSelection$Definition[v2] = null;
            }
            else {
                TrackGroupArray trackGroupArray0 = mappingTrackSelector$MappedTrackInfo0.getTrackGroups(v2);
                if(defaultTrackSelector$Parameters0.hasSelectionOverride(v2, trackGroupArray0)) {
                    SelectionOverride defaultTrackSelector$SelectionOverride0 = defaultTrackSelector$Parameters0.getSelectionOverride(v2, trackGroupArray0);
                    if(defaultTrackSelector$SelectionOverride0 != null) {
                        trackSelection$Definition0 = new Definition(trackGroupArray0.get(defaultTrackSelector$SelectionOverride0.groupIndex), defaultTrackSelector$SelectionOverride0.tracks, defaultTrackSelector$SelectionOverride0.reason, defaultTrackSelector$SelectionOverride0.data);
                    }
                    arr_trackSelection$Definition[v2] = trackSelection$Definition0;
                }
            }
        }
        BandwidthMeter bandwidthMeter0 = this.getBandwidthMeter();
        TrackSelection[] arr_trackSelection = this.trackSelectionFactory.createTrackSelections(arr_trackSelection$Definition, bandwidthMeter0);
        RendererConfiguration[] arr_rendererConfiguration = new RendererConfiguration[v];
        for(int v1 = 0; v1 < v; ++v1) {
            arr_rendererConfiguration[v1] = defaultTrackSelector$Parameters0.getRendererDisabled(v1) || mappingTrackSelector$MappedTrackInfo0.getRendererType(v1) != 6 && arr_trackSelection[v1] == null ? null : RendererConfiguration.DEFAULT;
        }
        DefaultTrackSelector.maybeConfigureRenderersForTunneling(mappingTrackSelector$MappedTrackInfo0, arr3_v, arr_rendererConfiguration, arr_trackSelection, defaultTrackSelector$Parameters0.tunnelingAudioSessionId);
        return Pair.create(arr_rendererConfiguration, arr_trackSelection);
    }

    // 去混淆评级： 低(20)
    public Definition selectVideoTrack(TrackGroupArray trackGroupArray0, int[][] arr2_v, int v, Parameters defaultTrackSelector$Parameters0, boolean z) {
        Definition trackSelection$Definition0 = defaultTrackSelector$Parameters0.forceHighestSupportedBitrate || defaultTrackSelector$Parameters0.forceLowestBitrate || !z ? null : DefaultTrackSelector.selectAdaptiveVideoTrack(trackGroupArray0, arr2_v, v, defaultTrackSelector$Parameters0);
        return trackSelection$Definition0 == null ? DefaultTrackSelector.selectFixedVideoTrack(trackGroupArray0, arr2_v, defaultTrackSelector$Parameters0) : trackSelection$Definition0;
    }

    public void setParameters(Parameters defaultTrackSelector$Parameters0) {
        Assertions.checkNotNull(defaultTrackSelector$Parameters0);
        if(!((Parameters)this.parametersReference.getAndSet(defaultTrackSelector$Parameters0)).equals(defaultTrackSelector$Parameters0)) {
            this.invalidate();
        }
    }

    public void setParameters(ParametersBuilder defaultTrackSelector$ParametersBuilder0) {
        this.setParameters(defaultTrackSelector$ParametersBuilder0.build());
    }

    @Deprecated
    public final void setRendererDisabled(int v, boolean z) {
        this.setParameters(this.buildUponParameters().setRendererDisabled(v, z));
    }

    @Deprecated
    public final void setSelectionOverride(int v, TrackGroupArray trackGroupArray0, SelectionOverride defaultTrackSelector$SelectionOverride0) {
        this.setParameters(this.buildUponParameters().setSelectionOverride(v, trackGroupArray0, defaultTrackSelector$SelectionOverride0));
    }

    @Deprecated
    public void setTunnelingAudioSessionId(int v) {
        this.setParameters(this.buildUponParameters().setTunnelingAudioSessionId(v));
    }

    class com.google.android.exoplayer2.trackselection.DefaultTrackSelector.1 {
    }

}

