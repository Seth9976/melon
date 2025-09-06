package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public final class AdPlaybackState {
    public static final class AdGroup {
        public final int count;
        public final long[] durationsUs;
        public final int[] states;
        public final Uri[] uris;

        public AdGroup() {
            this(-1, new int[0], new Uri[0], new long[0]);
        }

        private AdGroup(int v, int[] arr_v, Uri[] arr_uri, long[] arr_v1) {
            Assertions.checkArgument(arr_v.length == arr_uri.length);
            this.count = v;
            this.states = arr_v;
            this.uris = arr_uri;
            this.durationsUs = arr_v1;
        }

        private static long[] copyDurationsUsWithSpaceForAdCount(long[] arr_v, int v) {
            int v1 = Math.max(v, arr_v.length);
            long[] arr_v1 = Arrays.copyOf(arr_v, v1);
            Arrays.fill(arr_v1, arr_v.length, v1, 0x8000000000000001L);
            return arr_v1;
        }

        private static int[] copyStatesWithSpaceForAdCount(int[] arr_v, int v) {
            int v1 = Math.max(v, arr_v.length);
            int[] arr_v1 = Arrays.copyOf(arr_v, v1);
            Arrays.fill(arr_v1, arr_v.length, v1, 0);
            return arr_v1;
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(object0 != null) {
                Class class0 = object0.getClass();
                return AdGroup.class == class0 && this.count == ((AdGroup)object0).count && Arrays.equals(this.uris, ((AdGroup)object0).uris) && Arrays.equals(this.states, ((AdGroup)object0).states) && Arrays.equals(this.durationsUs, ((AdGroup)object0).durationsUs);
            }
            return false;
        }

        public int getFirstAdIndexToPlay() {
            return this.getNextAdIndexToPlay(-1);
        }

        public int getNextAdIndexToPlay(int v) {
            int v1 = v + 1;
        alab1:
            while(true) {
                int[] arr_v = this.states;
                if(v1 >= arr_v.length) {
                    break;
                }
                switch(arr_v[v1]) {
                    case 0: 
                    case 1: {
                        break alab1;
                    }
                    default: {
                        ++v1;
                    }
                }
            }
            return v1;
        }

        public boolean hasUnplayedAds() {
            return this.count == -1 || this.getFirstAdIndexToPlay() < this.count;
        }

        @Override
        public int hashCode() {
            int v = Arrays.hashCode(this.uris);
            int v1 = Arrays.hashCode(this.states);
            return Arrays.hashCode(this.durationsUs) + (v1 + (this.count * 0x1F + v) * 0x1F) * 0x1F;
        }

        public AdGroup withAdCount(int v) {
            int[] arr_v = AdGroup.copyStatesWithSpaceForAdCount(this.states, v);
            long[] arr_v1 = AdGroup.copyDurationsUsWithSpaceForAdCount(this.durationsUs, v);
            return new AdGroup(v, arr_v, ((Uri[])Arrays.copyOf(this.uris, v)), arr_v1);
        }

        public AdGroup withAdDurationsUs(long[] arr_v) {
            Assertions.checkArgument(this.count == -1 || arr_v.length <= this.uris.length);
            Uri[] arr_uri = this.uris;
            if(arr_v.length < arr_uri.length) {
                arr_v = AdGroup.copyDurationsUsWithSpaceForAdCount(arr_v, arr_uri.length);
            }
            return new AdGroup(this.count, this.states, this.uris, arr_v);
        }

        public AdGroup withAdState(int v, int v1) {
            boolean z = false;
            Assertions.checkArgument(this.count == -1 || v1 < this.count);
            int[] arr_v = AdGroup.copyStatesWithSpaceForAdCount(this.states, v1 + 1);
            int v2 = arr_v[v1];
            if(v2 == 0 || v2 == 1 || v2 == v) {
                z = true;
            }
            Assertions.checkArgument(z);
            long[] arr_v1 = this.durationsUs.length == arr_v.length ? this.durationsUs : AdGroup.copyDurationsUsWithSpaceForAdCount(this.durationsUs, arr_v.length);
            Uri[] arr_uri = this.uris.length == arr_v.length ? this.uris : ((Uri[])Arrays.copyOf(this.uris, arr_v.length));
            arr_v[v1] = v;
            return new AdGroup(this.count, arr_v, arr_uri, arr_v1);
        }

        public AdGroup withAdUri(Uri uri0, int v) {
            int[] arr_v = AdGroup.copyStatesWithSpaceForAdCount(this.states, v + 1);
            long[] arr_v1 = this.durationsUs.length == arr_v.length ? this.durationsUs : AdGroup.copyDurationsUsWithSpaceForAdCount(this.durationsUs, arr_v.length);
            Uri[] arr_uri = (Uri[])Arrays.copyOf(this.uris, arr_v.length);
            arr_uri[v] = uri0;
            arr_v[v] = 1;
            return new AdGroup(this.count, arr_v, arr_uri, arr_v1);
        }

        public AdGroup withAllAdsSkipped() {
            if(this.count == -1) {
                return new AdGroup(0, new int[0], new Uri[0], new long[0]);
            }
            int[] arr_v = Arrays.copyOf(this.states, this.states.length);
            for(int v = 0; v < this.states.length; ++v) {
                switch(arr_v[v]) {
                    case 0: 
                    case 1: {
                        arr_v[v] = 2;
                    }
                }
            }
            return new AdGroup(this.states.length, arr_v, this.uris, this.durationsUs);
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdState {
    }

    public static final int AD_STATE_AVAILABLE = 1;
    public static final int AD_STATE_ERROR = 4;
    public static final int AD_STATE_PLAYED = 3;
    public static final int AD_STATE_SKIPPED = 2;
    public static final int AD_STATE_UNAVAILABLE;
    public static final AdPlaybackState NONE;
    public final int adGroupCount;
    public final long[] adGroupTimesUs;
    public final AdGroup[] adGroups;
    public final long adResumePositionUs;
    public final long contentDurationUs;

    static {
        AdPlaybackState.NONE = new AdPlaybackState(new long[0]);
    }

    public AdPlaybackState(long[] arr_v) {
        this.adGroupCount = arr_v.length;
        this.adGroupTimesUs = Arrays.copyOf(arr_v, arr_v.length);
        this.adGroups = new AdGroup[arr_v.length];
        for(int v = 0; v < arr_v.length; ++v) {
            this.adGroups[v] = new AdGroup();
        }
        this.adResumePositionUs = 0L;
        this.contentDurationUs = 0x8000000000000001L;
    }

    private AdPlaybackState(long[] arr_v, AdGroup[] arr_adPlaybackState$AdGroup, long v, long v1) {
        this.adGroupCount = arr_adPlaybackState$AdGroup.length;
        this.adGroupTimesUs = arr_v;
        this.adGroups = arr_adPlaybackState$AdGroup;
        this.adResumePositionUs = v;
        this.contentDurationUs = v1;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return AdPlaybackState.class == class0 && this.adGroupCount == ((AdPlaybackState)object0).adGroupCount && this.adResumePositionUs == ((AdPlaybackState)object0).adResumePositionUs && this.contentDurationUs == ((AdPlaybackState)object0).contentDurationUs && Arrays.equals(this.adGroupTimesUs, ((AdPlaybackState)object0).adGroupTimesUs) && Arrays.equals(this.adGroups, ((AdPlaybackState)object0).adGroups);
        }
        return false;
    }

    public int getAdGroupIndexAfterPositionUs(long v, long v1) {
        if(Long.compare(v, 0x8000000000000000L) != 0 && (v1 == 0x8000000000000001L || v < v1)) {
            int v2;
            for(v2 = 0; true; ++v2) {
                long[] arr_v = this.adGroupTimesUs;
                if(v2 >= arr_v.length) {
                    break;
                }
                long v3 = arr_v[v2];
                if(v3 == 0x8000000000000000L || v < v3 && this.adGroups[v2].hasUnplayedAds()) {
                    break;
                }
            }
            return v2 >= this.adGroupTimesUs.length ? -1 : v2;
        }
        return -1;
    }

    public int getAdGroupIndexForPositionUs(long v, long v1) {
        int v2;
        for(v2 = this.adGroupTimesUs.length - 1; v2 >= 0 && this.isPositionBeforeAdGroup(v, v1, v2); --v2) {
        }
        return v2 < 0 || !this.adGroups[v2].hasUnplayedAds() ? -1 : v2;
    }

    @Override
    public int hashCode() {
        int v = Arrays.hashCode(this.adGroupTimesUs);
        return Arrays.hashCode(this.adGroups) + (v + ((this.adGroupCount * 0x1F + ((int)this.adResumePositionUs)) * 0x1F + ((int)this.contentDurationUs)) * 0x1F) * 0x1F;
    }

    public boolean isAdInErrorState(int v, int v1) {
        AdGroup[] arr_adPlaybackState$AdGroup = this.adGroups;
        if(v >= arr_adPlaybackState$AdGroup.length) {
            return false;
        }
        AdGroup adPlaybackState$AdGroup0 = arr_adPlaybackState$AdGroup[v];
        return adPlaybackState$AdGroup0.count != -1 && v1 < adPlaybackState$AdGroup0.count && adPlaybackState$AdGroup0.states[v1] == 4;
    }

    private boolean isPositionBeforeAdGroup(long v, long v1, int v2) {
        if(Long.compare(v, 0x8000000000000000L) == 0) {
            return false;
        }
        long v3 = this.adGroupTimesUs[v2];
        return Long.compare(v3, 0x8000000000000000L) == 0 ? v1 == 0x8000000000000001L || v < v1 : v < v3;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("AdPlaybackState(adResumePositionUs=");
        stringBuilder0.append(this.adResumePositionUs);
        stringBuilder0.append(", adGroups=[");
        for(int v = 0; v < this.adGroups.length; ++v) {
            stringBuilder0.append("adGroup(timeUs=");
            stringBuilder0.append(this.adGroupTimesUs[v]);
            stringBuilder0.append(", ads=[");
            for(int v1 = 0; v1 < this.adGroups[v].states.length; ++v1) {
                stringBuilder0.append("ad(state=");
                switch(this.adGroups[v].states[v1]) {
                    case 0: {
                        stringBuilder0.append('_');
                        break;
                    }
                    case 1: {
                        stringBuilder0.append('R');
                        break;
                    }
                    case 2: {
                        stringBuilder0.append('S');
                        break;
                    }
                    case 3: {
                        stringBuilder0.append('P');
                        break;
                    }
                    case 4: {
                        stringBuilder0.append('!');
                        break;
                    }
                    default: {
                        stringBuilder0.append('?');
                    }
                }
                stringBuilder0.append(", durationUs=");
                stringBuilder0.append(this.adGroups[v].durationsUs[v1]);
                stringBuilder0.append(')');
                if(v1 < this.adGroups[v].states.length - 1) {
                    stringBuilder0.append(", ");
                }
            }
            stringBuilder0.append("])");
            if(v < this.adGroups.length - 1) {
                stringBuilder0.append(", ");
            }
        }
        stringBuilder0.append("])");
        return stringBuilder0.toString();
    }

    public AdPlaybackState withAdCount(int v, int v1) {
        Assertions.checkArgument(v1 > 0);
        AdGroup[] arr_adPlaybackState$AdGroup = this.adGroups;
        if(arr_adPlaybackState$AdGroup[v].count == v1) {
            return this;
        }
        Object[] arr_object = Util.nullSafeArrayCopy(arr_adPlaybackState$AdGroup, arr_adPlaybackState$AdGroup.length);
        ((AdGroup[])arr_object)[v] = this.adGroups[v].withAdCount(v1);
        return new AdPlaybackState(this.adGroupTimesUs, ((AdGroup[])arr_object), this.adResumePositionUs, this.contentDurationUs);
    }

    public AdPlaybackState withAdDurationsUs(long[][] arr2_v) {
        Object[] arr_object = Util.nullSafeArrayCopy(this.adGroups, this.adGroups.length);
        for(int v = 0; v < this.adGroupCount; ++v) {
            ((AdGroup[])arr_object)[v] = ((AdGroup[])arr_object)[v].withAdDurationsUs(arr2_v[v]);
        }
        return new AdPlaybackState(this.adGroupTimesUs, ((AdGroup[])arr_object), this.adResumePositionUs, this.contentDurationUs);
    }

    public AdPlaybackState withAdLoadError(int v, int v1) {
        Object[] arr_object = Util.nullSafeArrayCopy(this.adGroups, this.adGroups.length);
        ((AdGroup[])arr_object)[v] = ((AdGroup[])arr_object)[v].withAdState(4, v1);
        return new AdPlaybackState(this.adGroupTimesUs, ((AdGroup[])arr_object), this.adResumePositionUs, this.contentDurationUs);
    }

    public AdPlaybackState withAdResumePositionUs(long v) {
        return this.adResumePositionUs == v ? this : new AdPlaybackState(this.adGroupTimesUs, this.adGroups, v, this.contentDurationUs);
    }

    public AdPlaybackState withAdUri(int v, int v1, Uri uri0) {
        Object[] arr_object = Util.nullSafeArrayCopy(this.adGroups, this.adGroups.length);
        ((AdGroup[])arr_object)[v] = ((AdGroup[])arr_object)[v].withAdUri(uri0, v1);
        return new AdPlaybackState(this.adGroupTimesUs, ((AdGroup[])arr_object), this.adResumePositionUs, this.contentDurationUs);
    }

    public AdPlaybackState withContentDurationUs(long v) {
        return this.contentDurationUs == v ? this : new AdPlaybackState(this.adGroupTimesUs, this.adGroups, this.adResumePositionUs, v);
    }

    public AdPlaybackState withPlayedAd(int v, int v1) {
        Object[] arr_object = Util.nullSafeArrayCopy(this.adGroups, this.adGroups.length);
        ((AdGroup[])arr_object)[v] = ((AdGroup[])arr_object)[v].withAdState(3, v1);
        return new AdPlaybackState(this.adGroupTimesUs, ((AdGroup[])arr_object), this.adResumePositionUs, this.contentDurationUs);
    }

    public AdPlaybackState withSkippedAd(int v, int v1) {
        Object[] arr_object = Util.nullSafeArrayCopy(this.adGroups, this.adGroups.length);
        ((AdGroup[])arr_object)[v] = ((AdGroup[])arr_object)[v].withAdState(2, v1);
        return new AdPlaybackState(this.adGroupTimesUs, ((AdGroup[])arr_object), this.adResumePositionUs, this.contentDurationUs);
    }

    public AdPlaybackState withSkippedAdGroup(int v) {
        Object[] arr_object = Util.nullSafeArrayCopy(this.adGroups, this.adGroups.length);
        ((AdGroup[])arr_object)[v] = ((AdGroup[])arr_object)[v].withAllAdsSkipped();
        return new AdPlaybackState(this.adGroupTimesUs, ((AdGroup[])arr_object), this.adResumePositionUs, this.contentDurationUs);
    }
}

