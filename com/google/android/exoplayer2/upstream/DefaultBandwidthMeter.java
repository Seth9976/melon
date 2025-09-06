package com.google.android.exoplayer2.upstream;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.EventDispatcher;
import com.google.android.exoplayer2.util.SlidingPercentile;
import com.google.android.exoplayer2.util.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class DefaultBandwidthMeter implements BandwidthMeter, TransferListener {
    public static final class Builder {
        private Clock clock;
        private final Context context;
        private SparseArray initialBitrateEstimates;
        private boolean resetOnNetworkTypeChange;
        private int slidingWindowMaxWeight;

        public Builder(Context context0) {
            this.context = context0 == null ? null : context0.getApplicationContext();
            this.initialBitrateEstimates = Builder.getInitialBitrateEstimatesForCountry(Util.getCountryCode(context0));
            this.slidingWindowMaxWeight = 2000;
            this.clock = Clock.DEFAULT;
            this.resetOnNetworkTypeChange = true;
        }

        public DefaultBandwidthMeter build() {
            return new DefaultBandwidthMeter(this.context, this.initialBitrateEstimates, this.slidingWindowMaxWeight, this.clock, this.resetOnNetworkTypeChange, null);
        }

        private static int[] getCountryGroupIndices(String s) {
            int[] arr_v = (int[])DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_COUNTRY_GROUPS.get(s);
            return arr_v == null ? new int[]{2, 2, 2, 2} : arr_v;
        }

        private static SparseArray getInitialBitrateEstimatesForCountry(String s) {
            int[] arr_v = Builder.getCountryGroupIndices(s);
            SparseArray sparseArray0 = new SparseArray(6);
            sparseArray0.append(0, 1000000L);
            sparseArray0.append(2, ((long)DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI[arr_v[0]]));
            sparseArray0.append(3, ((long)DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_2G[arr_v[1]]));
            sparseArray0.append(4, ((long)DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_3G[arr_v[2]]));
            sparseArray0.append(5, ((long)DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_4G[arr_v[3]]));
            sparseArray0.append(7, ((long)DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI[arr_v[0]]));
            sparseArray0.append(9, ((long)DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_4G[arr_v[3]]));
            return sparseArray0;
        }

        public Builder setClock(Clock clock0) {
            this.clock = clock0;
            return this;
        }

        public Builder setInitialBitrateEstimate(int v, long v1) {
            this.initialBitrateEstimates.put(v, v1);
            return this;
        }

        public Builder setInitialBitrateEstimate(long v) {
            for(int v1 = 0; v1 < this.initialBitrateEstimates.size(); ++v1) {
                this.initialBitrateEstimates.setValueAt(v1, v);
            }
            return this;
        }

        public Builder setInitialBitrateEstimate(String s) {
            this.initialBitrateEstimates = Builder.getInitialBitrateEstimatesForCountry(Util.toUpperInvariant(s));
            return this;
        }

        public Builder setResetOnNetworkTypeChange(boolean z) {
            this.resetOnNetworkTypeChange = z;
            return this;
        }

        public Builder setSlidingWindowMaxWeight(int v) {
            this.slidingWindowMaxWeight = v;
            return this;
        }
    }

    static class ConnectivityActionReceiver extends BroadcastReceiver {
        private final ArrayList bandwidthMeters;
        private final Handler mainHandler;
        private static ConnectivityActionReceiver staticInstance;

        private ConnectivityActionReceiver() {
            this.mainHandler = new Handler(Looper.getMainLooper());
            this.bandwidthMeters = new ArrayList();
        }

        public static ConnectivityActionReceiver getInstance(Context context0) {
            synchronized(ConnectivityActionReceiver.class) {
                if(ConnectivityActionReceiver.staticInstance == null) {
                    ConnectivityActionReceiver.staticInstance = new ConnectivityActionReceiver();
                    IntentFilter intentFilter0 = new IntentFilter();
                    intentFilter0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    context0.registerReceiver(ConnectivityActionReceiver.staticInstance, intentFilter0);
                }
                return ConnectivityActionReceiver.staticInstance;
            }
        }

        // 检测为 Lambda 实现
        private void lambda$register$0(DefaultBandwidthMeter defaultBandwidthMeter0) [...]

        @Override  // android.content.BroadcastReceiver
        public void onReceive(Context context0, Intent intent0) {
            synchronized(this) {
                if(this.isInitialStickyBroadcast()) {
                    return;
                }
                this.removeClearedReferences();
                for(int v1 = 0; v1 < this.bandwidthMeters.size(); ++v1) {
                    DefaultBandwidthMeter defaultBandwidthMeter0 = (DefaultBandwidthMeter)((WeakReference)this.bandwidthMeters.get(v1)).get();
                    if(defaultBandwidthMeter0 != null) {
                        this.updateBandwidthMeter(defaultBandwidthMeter0);
                    }
                }
            }
        }

        public void register(DefaultBandwidthMeter defaultBandwidthMeter0) {
            synchronized(this) {
                this.removeClearedReferences();
                WeakReference weakReference0 = new WeakReference(defaultBandwidthMeter0);
                this.bandwidthMeters.add(weakReference0);
                b b0 = () -> this.updateBandwidthMeter(defaultBandwidthMeter0);
                this.mainHandler.post(b0);
            }
        }

        private void removeClearedReferences() {
            for(int v = this.bandwidthMeters.size() - 1; v >= 0; --v) {
                if(((DefaultBandwidthMeter)((WeakReference)this.bandwidthMeters.get(v)).get()) == null) {
                    this.bandwidthMeters.remove(v);
                }
            }
        }

        private void updateBandwidthMeter(DefaultBandwidthMeter defaultBandwidthMeter0) {
            defaultBandwidthMeter0.onConnectivityAction();
        }
    }

    private static final int BYTES_TRANSFERRED_FOR_ESTIMATE = 0x80000;
    public static final Map DEFAULT_INITIAL_BITRATE_COUNTRY_GROUPS = null;
    public static final long DEFAULT_INITIAL_BITRATE_ESTIMATE = 1000000L;
    public static final long[] DEFAULT_INITIAL_BITRATE_ESTIMATES_2G = null;
    public static final long[] DEFAULT_INITIAL_BITRATE_ESTIMATES_3G = null;
    public static final long[] DEFAULT_INITIAL_BITRATE_ESTIMATES_4G = null;
    public static final long[] DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI = null;
    public static final int DEFAULT_SLIDING_WINDOW_MAX_WEIGHT = 2000;
    private static final int ELAPSED_MILLIS_FOR_ESTIMATE = 2000;
    private long bitrateEstimate;
    private final Clock clock;
    private final Context context;
    private final EventDispatcher eventDispatcher;
    private final SparseArray initialBitrateEstimates;
    private long lastReportedBitrateEstimate;
    private int networkType;
    private int networkTypeOverride;
    private boolean networkTypeOverrideSet;
    private long sampleBytesTransferred;
    private long sampleStartTimeMs;
    private static DefaultBandwidthMeter singletonInstance;
    private final SlidingPercentile slidingPercentile;
    private int streamCount;
    private long totalBytesTransferred;
    private long totalElapsedTimeMs;

    static {
        DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_COUNTRY_GROUPS = DefaultBandwidthMeter.createInitialBitrateCountryGroupAssignment();
        DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI = new long[]{5800000L, 3500000L, 1900000L, 1000000L, 520000L};
        DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_2G = new long[]{204000L, 154000L, 139000L, 122000L, 102000L};
        DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_3G = new long[]{2200000L, 1150000L, 810000L, 640000L, 450000L};
        DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_4G = new long[]{4900000L, 2300000L, 1500000L, 970000L, 540000L};
    }

    @Deprecated
    public DefaultBandwidthMeter() {
        this(null, new SparseArray(), 2000, Clock.DEFAULT, false);
    }

    private DefaultBandwidthMeter(Context context0, SparseArray sparseArray0, int v, Clock clock0, boolean z) {
        this.context = context0 == null ? null : context0.getApplicationContext();
        this.initialBitrateEstimates = sparseArray0;
        this.eventDispatcher = new EventDispatcher();
        this.slidingPercentile = new SlidingPercentile(v);
        this.clock = clock0;
        int v1 = context0 == null ? 0 : Util.getNetworkType(context0);
        this.networkType = v1;
        this.bitrateEstimate = this.getInitialBitrateEstimateForNetworkType(v1);
        if(context0 != null && z) {
            ConnectivityActionReceiver.getInstance(context0).register(this);
        }
    }

    public DefaultBandwidthMeter(Context context0, SparseArray sparseArray0, int v, Clock clock0, boolean z, com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.1 defaultBandwidthMeter$10) {
        this(context0, sparseArray0, v, clock0, z);
    }

    @Override  // com.google.android.exoplayer2.upstream.BandwidthMeter
    public void addEventListener(Handler handler0, EventListener bandwidthMeter$EventListener0) {
        this.eventDispatcher.addListener(handler0, bandwidthMeter$EventListener0);
    }

    private static Map createInitialBitrateCountryGroupAssignment() {
        HashMap hashMap0 = new HashMap();
        hashMap0.put("AD", new int[]{0, 2, 0, 0});
        hashMap0.put("AE", new int[]{2, 4, 4, 4});
        hashMap0.put("AF", new int[]{4, 4, 3, 3});
        hashMap0.put("AG", new int[]{4, 2, 2, 3});
        hashMap0.put("AI", new int[]{0, 3, 2, 4});
        hashMap0.put("AL", new int[]{1, 2, 0, 1});
        hashMap0.put("AM", new int[]{2, 2, 1, 2});
        hashMap0.put("AO", new int[]{3, 4, 3, 1});
        hashMap0.put("AQ", new int[]{4, 2, 2, 2});
        hashMap0.put("AR", new int[]{2, 3, 1, 2});
        hashMap0.put("AS", new int[]{2, 2, 4, 2});
        hashMap0.put("AT", new int[]{0, 3, 0, 0});
        hashMap0.put("AU", new int[]{0, 2, 0, 1});
        hashMap0.put("AW", new int[]{1, 1, 2, 4});
        hashMap0.put("AX", new int[]{0, 1, 0, 0});
        hashMap0.put("AZ", new int[]{3, 3, 3, 3});
        hashMap0.put("BA", new int[]{1, 1, 0, 1});
        hashMap0.put("BB", new int[]{0, 3, 0, 0});
        hashMap0.put("BD", new int[]{2, 0, 4, 3});
        hashMap0.put("BE", new int[]{0, 1, 2, 3});
        hashMap0.put("BF", new int[]{4, 4, 4, 1});
        hashMap0.put("BG", new int[]{0, 1, 0, 0});
        hashMap0.put("BH", new int[]{1, 0, 3, 4});
        hashMap0.put("BI", new int[]{4, 4, 4, 4});
        hashMap0.put("BJ", new int[]{4, 4, 3, 4});
        hashMap0.put("BL", new int[]{1, 0, 4, 3});
        hashMap0.put("BM", new int[]{0, 1, 0, 0});
        hashMap0.put("BN", new int[]{4, 0, 2, 4});
        hashMap0.put("BO", new int[]{1, 3, 3, 3});
        hashMap0.put("BQ", new int[]{1, 0, 1, 0});
        hashMap0.put("BR", new int[]{2, 4, 3, 1});
        hashMap0.put("BS", new int[]{3, 1, 1, 3});
        hashMap0.put("BT", new int[]{3, 0, 3, 1});
        hashMap0.put("BW", new int[]{3, 4, 3, 3});
        hashMap0.put("BY", new int[]{0, 1, 1, 1});
        hashMap0.put("BZ", new int[]{1, 3, 2, 1});
        hashMap0.put("CA", new int[]{0, 3, 2, 2});
        hashMap0.put("CD", new int[]{3, 4, 2, 2});
        hashMap0.put("CF", new int[]{4, 3, 2, 2});
        hashMap0.put("CG", new int[]{3, 4, 1, 1});
        hashMap0.put("CH", new int[]{0, 0, 0, 0});
        hashMap0.put("CI", new int[]{3, 4, 3, 3});
        hashMap0.put("CK", new int[]{2, 0, 1, 0});
        hashMap0.put("CL", new int[]{1, 2, 2, 3});
        hashMap0.put("CM", new int[]{3, 4, 3, 2});
        hashMap0.put("CN", new int[]{1, 0, 1, 1});
        hashMap0.put("CO", new int[]{2, 3, 3, 2});
        hashMap0.put("CR", new int[]{2, 2, 4, 4});
        hashMap0.put("CU", new int[]{4, 4, 2, 1});
        hashMap0.put("CV", new int[]{2, 3, 3, 2});
        hashMap0.put("CW", new int[]{1, 1, 0, 0});
        hashMap0.put("CY", new int[]{1, 1, 0, 0});
        hashMap0.put("CZ", new int[]{0, 1, 0, 0});
        hashMap0.put("DE", new int[]{0, 1, 2, 3});
        hashMap0.put("DJ", new int[]{4, 2, 4, 4});
        hashMap0.put("DK", new int[]{0, 0, 1, 0});
        hashMap0.put("DM", new int[]{1, 1, 0, 2});
        hashMap0.put("DO", new int[]{3, 3, 4, 4});
        hashMap0.put("DZ", new int[]{3, 3, 4, 4});
        hashMap0.put("EC", new int[]{2, 3, 4, 2});
        hashMap0.put("EE", new int[]{0, 0, 0, 0});
        hashMap0.put("EG", new int[]{3, 4, 2, 1});
        hashMap0.put("EH", new int[]{2, 0, 3, 1});
        hashMap0.put("ER", new int[]{4, 2, 4, 4});
        hashMap0.put("ES", new int[]{0, 1, 1, 1});
        hashMap0.put("ET", new int[]{4, 4, 4, 1});
        hashMap0.put("FI", new int[]{0, 0, 1, 0});
        hashMap0.put("FJ", new int[]{3, 0, 4, 4});
        hashMap0.put("FK", new int[]{2, 2, 2, 1});
        hashMap0.put("FM", new int[]{3, 2, 4, 1});
        hashMap0.put("FO", new int[]{1, 1, 0, 0});
        hashMap0.put("FR", new int[]{1, 1, 1, 1});
        hashMap0.put("GA", new int[]{3, 2, 2, 2});
        hashMap0.put("GB", new int[]{0, 1, 1, 1});
        hashMap0.put("GD", new int[]{1, 1, 3, 1});
        hashMap0.put("GE", new int[]{1, 0, 1, 4});
        hashMap0.put("GF", new int[]{2, 0, 1, 3});
        hashMap0.put("GG", new int[]{1, 0, 0, 0});
        hashMap0.put("GH", new int[]{3, 3, 3, 3});
        hashMap0.put("GI", new int[]{4, 4, 0, 0});
        hashMap0.put("GL", new int[]{2, 1, 1, 2});
        hashMap0.put("GM", new int[]{4, 3, 2, 4});
        hashMap0.put("GN", new int[]{3, 4, 4, 2});
        hashMap0.put("GP", new int[]{2, 1, 3, 4});
        hashMap0.put("GQ", new int[]{4, 4, 4, 0});
        hashMap0.put("GR", new int[]{1, 1, 0, 1});
        hashMap0.put("GT", new int[]{3, 2, 2, 2});
        hashMap0.put("GU", new int[]{1, 0, 2, 2});
        hashMap0.put("GW", new int[]{3, 4, 4, 3});
        hashMap0.put("GY", new int[]{3, 2, 1, 1});
        hashMap0.put("HK", new int[]{0, 2, 3, 4});
        hashMap0.put("HN", new int[]{3, 1, 3, 3});
        hashMap0.put("HR", new int[]{1, 1, 0, 1});
        hashMap0.put("HT", new int[]{4, 4, 4, 4});
        hashMap0.put("HU", new int[]{0, 1, 0, 0});
        hashMap0.put("ID", new int[]{2, 2, 2, 3});
        hashMap0.put("IE", new int[]{1, 0, 1, 1});
        hashMap0.put("IL", new int[]{1, 0, 2, 3});
        hashMap0.put("IM", new int[]{0, 0, 0, 1});
        hashMap0.put("IN", new int[]{2, 2, 4, 3});
        hashMap0.put("IO", new int[]{4, 4, 2, 3});
        hashMap0.put("IQ", new int[]{3, 3, 4, 2});
        hashMap0.put("IR", new int[]{3, 0, 2, 1});
        hashMap0.put("IS", new int[]{0, 1, 0, 0});
        hashMap0.put("IT", new int[]{1, 1, 1, 2});
        hashMap0.put("JE", new int[]{1, 0, 0, 1});
        hashMap0.put("JM", new int[]{3, 3, 3, 4});
        hashMap0.put("JO", new int[]{1, 2, 1, 1});
        hashMap0.put("JP", new int[]{0, 2, 0, 0});
        hashMap0.put("KE", new int[]{3, 4, 3, 3});
        hashMap0.put("KG", new int[]{2, 0, 2, 2});
        hashMap0.put("KH", new int[]{1, 0, 4, 3});
        hashMap0.put("KI", new int[]{4, 4, 4, 0});
        hashMap0.put("KM", new int[]{4, 3, 2, 4});
        hashMap0.put("KN", new int[]{1, 0, 2, 4});
        hashMap0.put("KP", new int[]{4, 2, 0, 2});
        hashMap0.put("KR", new int[]{0, 1, 0, 1});
        hashMap0.put("KW", new int[]{2, 3, 1, 2});
        hashMap0.put("KY", new int[]{3, 1, 2, 3});
        hashMap0.put("KZ", new int[]{1, 2, 2, 2});
        hashMap0.put("LA", new int[]{2, 2, 1, 1});
        hashMap0.put("LB", new int[]{3, 2, 0, 0});
        hashMap0.put("LC", new int[]{1, 1, 0, 0});
        hashMap0.put("LI", new int[]{0, 0, 1, 1});
        hashMap0.put("LK", new int[]{2, 0, 2, 3});
        hashMap0.put("LR", new int[]{3, 4, 4, 2});
        hashMap0.put("LS", new int[]{3, 3, 2, 2});
        hashMap0.put("LT", new int[]{0, 0, 0, 0});
        hashMap0.put("LU", new int[]{0, 0, 0, 0});
        hashMap0.put("LV", new int[]{0, 0, 0, 0});
        hashMap0.put("LY", new int[]{3, 3, 4, 3});
        hashMap0.put("MA", new int[]{3, 2, 3, 2});
        hashMap0.put("MC", new int[]{0, 4, 0, 0});
        hashMap0.put("MD", new int[]{1, 1, 0, 0});
        hashMap0.put("ME", new int[]{1, 3, 1, 2});
        hashMap0.put("MF", new int[]{2, 3, 1, 1});
        hashMap0.put("MG", new int[]{3, 4, 2, 3});
        hashMap0.put("MH", new int[]{4, 0, 2, 4});
        hashMap0.put("MK", new int[]{1, 0, 0, 0});
        hashMap0.put("ML", new int[]{4, 4, 2, 0});
        hashMap0.put("MM", new int[]{3, 3, 2, 2});
        hashMap0.put("MN", new int[]{2, 3, 1, 1});
        hashMap0.put("MO", new int[]{0, 0, 4, 4});
        hashMap0.put("MP", new int[]{0, 2, 1, 2});
        hashMap0.put("MQ", new int[]{2, 1, 1, 3});
        hashMap0.put("MR", new int[]{4, 2, 4, 4});
        hashMap0.put("MS", new int[]{1, 4, 3, 4});
        hashMap0.put("MT", new int[]{0, 0, 0, 0});
        hashMap0.put("MU", new int[]{2, 2, 4, 4});
        hashMap0.put("MV", new int[]{4, 3, 2, 4});
        hashMap0.put("MW", new int[]{3, 1, 1, 1});
        hashMap0.put("MX", new int[]{2, 4, 3, 3});
        hashMap0.put("MY", new int[]{2, 1, 3, 3});
        hashMap0.put("MZ", new int[]{3, 3, 3, 3});
        hashMap0.put("NA", new int[]{4, 3, 3, 3});
        hashMap0.put("NC", new int[]{2, 0, 4, 4});
        hashMap0.put("NE", new int[]{4, 4, 4, 4});
        hashMap0.put("NF", new int[]{1, 2, 2, 0});
        hashMap0.put("NG", new int[]{3, 3, 2, 2});
        hashMap0.put("NI", new int[]{3, 2, 4, 3});
        hashMap0.put("NL", new int[]{0, 2, 3, 2});
        hashMap0.put("NO", new int[]{0, 2, 1, 0});
        hashMap0.put("NP", new int[]{2, 2, 2, 2});
        hashMap0.put("NR", new int[]{4, 0, 3, 2});
        hashMap0.put("NZ", new int[]{0, 0, 1, 2});
        hashMap0.put("OM", new int[]{2, 3, 0, 2});
        hashMap0.put("PA", new int[]{1, 3, 3, 3});
        hashMap0.put("PE", new int[]{2, 4, 4, 4});
        hashMap0.put("PF", new int[]{2, 1, 1, 1});
        hashMap0.put("PG", new int[]{4, 3, 3, 2});
        hashMap0.put("PH", new int[]{3, 0, 3, 4});
        hashMap0.put("PK", new int[]{3, 2, 3, 2});
        hashMap0.put("PL", new int[]{1, 0, 1, 2});
        hashMap0.put("PM", new int[]{0, 2, 2, 0});
        hashMap0.put("PR", new int[]{2, 2, 2, 2});
        hashMap0.put("PS", new int[]{3, 3, 1, 4});
        hashMap0.put("PT", new int[]{1, 1, 0, 0});
        hashMap0.put("PW", new int[]{1, 1, 3, 0});
        hashMap0.put("PY", new int[]{2, 0, 3, 3});
        hashMap0.put("QA", new int[]{2, 3, 1, 1});
        hashMap0.put("RE", new int[]{1, 0, 2, 2});
        hashMap0.put("RO", new int[]{0, 1, 1, 2});
        hashMap0.put("RS", new int[]{1, 2, 0, 0});
        hashMap0.put("RU", new int[]{0, 1, 0, 1});
        hashMap0.put("RW", new int[]{4, 4, 4, 4});
        hashMap0.put("SA", new int[]{2, 2, 2, 1});
        hashMap0.put("SB", new int[]{4, 4, 4, 1});
        hashMap0.put("SC", new int[]{4, 2, 0, 1});
        hashMap0.put("SD", new int[]{4, 4, 4, 4});
        hashMap0.put("SE", new int[]{0, 1, 0, 0});
        hashMap0.put("SG", new int[]{1, 0, 3, 3});
        hashMap0.put("SH", new int[]{4, 2, 2, 2});
        hashMap0.put("SI", new int[]{0, 1, 0, 0});
        hashMap0.put("SJ", new int[]{2, 2, 2, 4});
        hashMap0.put("SK", new int[]{0, 1, 0, 0});
        hashMap0.put("SL", new int[]{4, 3, 3, 1});
        hashMap0.put("SM", new int[]{0, 0, 1, 2});
        hashMap0.put("SN", new int[]{4, 4, 4, 3});
        hashMap0.put("SO", new int[]{3, 4, 3, 4});
        hashMap0.put("SR", new int[]{2, 2, 2, 1});
        hashMap0.put("SS", new int[]{4, 4, 4, 4});
        hashMap0.put("ST", new int[]{2, 3, 1, 2});
        hashMap0.put("SV", new int[]{2, 2, 4, 4});
        hashMap0.put("SX", new int[]{2, 4, 1, 0});
        hashMap0.put("SY", new int[]{4, 3, 1, 1});
        hashMap0.put("SZ", new int[]{4, 4, 3, 4});
        hashMap0.put("TC", new int[]{1, 2, 1, 0});
        hashMap0.put("TD", new int[]{4, 4, 4, 3});
        hashMap0.put("TG", new int[]{3, 2, 1, 0});
        hashMap0.put("TH", new int[]{1, 3, 3, 3});
        hashMap0.put("TJ", new int[]{4, 4, 4, 4});
        hashMap0.put("TL", new int[]{4, 2, 4, 4});
        hashMap0.put("TM", new int[]{4, 2, 2, 2});
        hashMap0.put("TN", new int[]{2, 1, 1, 1});
        hashMap0.put("TO", new int[]{4, 3, 4, 4});
        hashMap0.put("TR", new int[]{1, 2, 1, 1});
        hashMap0.put("TT", new int[]{1, 3, 2, 4});
        hashMap0.put("TV", new int[]{4, 2, 3, 4});
        hashMap0.put("TW", new int[]{0, 0, 0, 0});
        hashMap0.put("TZ", new int[]{3, 4, 3, 3});
        hashMap0.put("UA", new int[]{0, 3, 1, 1});
        hashMap0.put("UG", new int[]{3, 2, 2, 3});
        hashMap0.put("US", new int[]{0, 1, 2, 2});
        hashMap0.put("UY", new int[]{2, 1, 2, 2});
        hashMap0.put("UZ", new int[]{2, 2, 3, 2});
        hashMap0.put("VA", new int[]{0, 2, 2, 2});
        hashMap0.put("VC", new int[]{2, 3, 0, 2});
        hashMap0.put("VE", new int[]{4, 4, 4, 4});
        hashMap0.put("VG", new int[]{3, 1, 2, 4});
        hashMap0.put("VI", new int[]{1, 4, 4, 3});
        hashMap0.put("VN", new int[]{0, 1, 3, 4});
        hashMap0.put("VU", new int[]{4, 0, 3, 3});
        hashMap0.put("WS", new int[]{3, 2, 4, 3});
        hashMap0.put("XK", new int[]{1, 2, 1, 0});
        hashMap0.put("YE", new int[]{4, 4, 4, 3});
        hashMap0.put("YT", new int[]{2, 2, 2, 3});
        hashMap0.put("ZA", new int[]{2, 3, 2, 2});
        hashMap0.put("ZM", new int[]{3, 2, 3, 3});
        hashMap0.put("ZW", new int[]{3, 3, 2, 3});
        return Collections.unmodifiableMap(hashMap0);
    }

    @Override  // com.google.android.exoplayer2.upstream.BandwidthMeter
    public long getBitrateEstimate() {
        synchronized(this) {
        }
        return this.bitrateEstimate;
    }

    private long getInitialBitrateEstimateForNetworkType(int v) {
        Long long0 = (Long)this.initialBitrateEstimates.get(v);
        if(long0 == null) {
            long0 = (Long)this.initialBitrateEstimates.get(0);
        }
        if(long0 == null) {
            long0 = 1000000L;
        }
        return (long)long0;
    }

    public static DefaultBandwidthMeter getSingletonInstance(Context context0) {
        synchronized(DefaultBandwidthMeter.class) {
            if(DefaultBandwidthMeter.singletonInstance == null) {
                DefaultBandwidthMeter.singletonInstance = new Builder(context0).build();
            }
            return DefaultBandwidthMeter.singletonInstance;
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.BandwidthMeter
    public TransferListener getTransferListener() {
        return this;
    }

    // 检测为 Lambda 实现
    private static void lambda$maybeNotifyBandwidthSample$0(int v, long v1, long v2, EventListener bandwidthMeter$EventListener0) [...]

    private void maybeNotifyBandwidthSample(int v, long v1, long v2) {
        if(v == 0 && v1 == 0L && v2 == this.lastReportedBitrateEstimate) {
            return;
        }
        this.lastReportedBitrateEstimate = v2;
        a a0 = (EventListener bandwidthMeter$EventListener0) -> bandwidthMeter$EventListener0.onBandwidthSample(v, v1, v2);
        this.eventDispatcher.dispatch(a0);
    }

    @Override  // com.google.android.exoplayer2.upstream.TransferListener
    public void onBytesTransferred(DataSource dataSource0, DataSpec dataSpec0, boolean z, int v) {
        synchronized(this) {
            if(!z) {
                return;
            }
            this.sampleBytesTransferred += (long)v;
        }
    }

    private void onConnectivityAction() {
        int v2;
        int v = 0;
        synchronized(this) {
            if(this.networkTypeOverrideSet) {
                v2 = this.networkTypeOverride;
            }
            else {
                v2 = this.context == null ? 0 : Util.getNetworkType(this.context);
            }
            if(this.networkType == v2) {
                return;
            }
            this.networkType = v2;
            if(v2 != 0 && v2 != 1 && v2 != 8) {
                this.bitrateEstimate = this.getInitialBitrateEstimateForNetworkType(v2);
                long v3 = this.clock.elapsedRealtime();
                if(this.streamCount > 0) {
                    v = (int)(v3 - this.sampleStartTimeMs);
                }
                this.maybeNotifyBandwidthSample(v, this.sampleBytesTransferred, this.bitrateEstimate);
                this.sampleStartTimeMs = v3;
                this.sampleBytesTransferred = 0L;
                this.totalBytesTransferred = 0L;
                this.totalElapsedTimeMs = 0L;
                this.slidingPercentile.reset();
            }
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.TransferListener
    public void onTransferEnd(DataSource dataSource0, DataSpec dataSpec0, boolean z) {
        synchronized(this) {
            if(!z) {
                return;
            }
            Assertions.checkState(this.streamCount > 0);
            long v1 = this.clock.elapsedRealtime();
            int v2 = (int)(v1 - this.sampleStartTimeMs);
            this.totalElapsedTimeMs += (long)v2;
            long v3 = this.sampleBytesTransferred;
            this.totalBytesTransferred += v3;
            if(v2 > 0) {
                this.slidingPercentile.addSample(((int)Math.sqrt(v3)), ((float)v3) * 8000.0f / ((float)v2));
                if(this.totalElapsedTimeMs >= 2000L || this.totalBytesTransferred >= 0x80000L) {
                    this.bitrateEstimate = (long)this.slidingPercentile.getPercentile(0.5f);
                }
                this.maybeNotifyBandwidthSample(v2, this.sampleBytesTransferred, this.bitrateEstimate);
                this.sampleStartTimeMs = v1;
                this.sampleBytesTransferred = 0L;
            }
            --this.streamCount;
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.TransferListener
    public void onTransferInitializing(DataSource dataSource0, DataSpec dataSpec0, boolean z) {
    }

    @Override  // com.google.android.exoplayer2.upstream.TransferListener
    public void onTransferStart(DataSource dataSource0, DataSpec dataSpec0, boolean z) {
        synchronized(this) {
            if(!z) {
                return;
            }
            if(this.streamCount == 0) {
                this.sampleStartTimeMs = this.clock.elapsedRealtime();
            }
            ++this.streamCount;
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.BandwidthMeter
    public void removeEventListener(EventListener bandwidthMeter$EventListener0) {
        this.eventDispatcher.removeListener(bandwidthMeter$EventListener0);
    }

    public void setNetworkTypeOverride(int v) {
        synchronized(this) {
            this.networkTypeOverride = v;
            this.networkTypeOverrideSet = true;
            this.onConnectivityAction();
        }
    }

    class com.google.android.exoplayer2.upstream.DefaultBandwidthMeter.1 {
    }

}

