package com.google.android.gms.cast.internal;

import android.os.SystemClock;
import com.google.android.gms.cast.AdBreakStatus;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaLiveSeekableRange;
import com.google.android.gms.cast.MediaLoadRequestData;
import com.google.android.gms.cast.MediaQueueItem.Builder;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaSeekOptions;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.cast.internal.media.MediaCommon;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import va.e;

public final class zzar extends zzd {
    public static final String zzb;
    final zzav zzc;
    final zzav zzd;
    final zzav zze;
    final zzav zzf;
    final zzav zzg;
    final zzav zzh;
    final zzav zzi;
    final zzav zzj;
    final zzav zzk;
    final zzav zzl;
    final zzav zzm;
    final zzav zzn;
    final zzav zzo;
    final zzav zzp;
    final zzav zzq;
    final zzav zzr;
    final zzav zzs;
    final zzav zzt;
    final zzav zzu;
    private long zzv;
    private MediaStatus zzw;
    private Long zzx;
    private zzao zzy;
    private int zzz;

    static {
        zzar.zzb = "urn:x-cast:com.google.cast.media";
    }

    public zzar(String s) {
        super("urn:x-cast:com.google.cast.media", "MediaControlChannel", null);
        this.zzz = -1;
        zzav zzav0 = new zzav(86400000L, "load");
        this.zzc = zzav0;
        zzav zzav1 = new zzav(86400000L, "pause");
        this.zzd = zzav1;
        zzav zzav2 = new zzav(86400000L, "play");
        this.zze = zzav2;
        zzav zzav3 = new zzav(86400000L, "stop");
        this.zzf = zzav3;
        zzav zzav4 = new zzav(10000L, "seek");
        this.zzg = zzav4;
        zzav zzav5 = new zzav(86400000L, "volume");
        this.zzh = zzav5;
        zzav zzav6 = new zzav(86400000L, "mute");
        this.zzi = zzav6;
        zzav zzav7 = new zzav(86400000L, "status");
        this.zzj = zzav7;
        zzav zzav8 = new zzav(86400000L, "activeTracks");
        this.zzk = zzav8;
        zzav zzav9 = new zzav(86400000L, "trackStyle");
        this.zzl = zzav9;
        zzav zzav10 = new zzav(86400000L, "queueInsert");
        this.zzm = zzav10;
        zzav zzav11 = new zzav(86400000L, "queueUpdate");
        this.zzn = zzav11;
        zzav zzav12 = new zzav(86400000L, "queueRemove");
        this.zzo = zzav12;
        zzav zzav13 = new zzav(86400000L, "queueReorder");
        this.zzp = zzav13;
        zzav zzav14 = new zzav(86400000L, "queueFetchItemIds");
        this.zzq = zzav14;
        zzav zzav15 = new zzav(86400000L, "queueFetchItemRange");
        this.zzs = zzav15;
        this.zzr = new zzav(86400000L, "queueFetchItems");
        zzav zzav16 = new zzav(86400000L, "setPlaybackRate");
        this.zzt = zzav16;
        zzav zzav17 = new zzav(86400000L, "skipAd");
        this.zzu = zzav17;
        this.zzc(zzav0);
        this.zzc(zzav1);
        this.zzc(zzav2);
        this.zzc(zzav3);
        this.zzc(zzav4);
        this.zzc(zzav5);
        this.zzc(zzav6);
        this.zzc(zzav7);
        this.zzc(zzav8);
        this.zzc(zzav9);
        this.zzc(zzav10);
        this.zzc(zzav11);
        this.zzc(zzav12);
        this.zzc(zzav13);
        this.zzc(zzav14);
        this.zzc(zzav15);
        this.zzc(zzav15);
        this.zzc(zzav16);
        this.zzc(zzav17);
        this.zzT();
    }

    public final long zzA(zzat zzat0, int v, long v1, MediaQueueItem[] arr_mediaQueueItem, int v2, Boolean boolean0, Integer integer0, JSONObject jSONObject0) {
        int v3 = Long.compare(v1, -1L);
        if(v3 != 0 && v1 < 0L) {
            throw new IllegalArgumentException(e.a(v1, "playPosition cannot be negative: "));
        }
        JSONObject jSONObject1 = new JSONObject();
        long v4 = this.zzd();
        try {
            jSONObject1.put("requestId", v4);
            jSONObject1.put("type", "QUEUE_UPDATE");
            jSONObject1.put("mediaSessionId", this.zzn());
            if(v != 0) {
                jSONObject1.put("currentItemId", v);
            }
            if(v2 != 0) {
                jSONObject1.put("jump", v2);
            }
            if(arr_mediaQueueItem != null && arr_mediaQueueItem.length > 0) {
                JSONArray jSONArray0 = new JSONArray();
                for(int v5 = 0; v5 < arr_mediaQueueItem.length; ++v5) {
                    jSONArray0.put(v5, arr_mediaQueueItem[v5].toJson());
                }
                jSONObject1.put("items", jSONArray0);
            }
            if(boolean0 != null) {
                jSONObject1.put("shuffle", boolean0);
            }
            String s = MediaCommon.zza(integer0);
            if(s != null) {
                jSONObject1.put("repeatMode", s);
            }
            if(v3 != 0) {
                jSONObject1.put("currentTime", ((double)v1) / 1000.0);
            }
            if(jSONObject0 != null) {
                jSONObject1.put("customData", jSONObject0);
            }
            if(this.zzZ()) {
                jSONObject1.put("sequenceNumber", this.zzz);
            }
        }
        catch(JSONException unused_ex) {
        }
        this.zzg(jSONObject1.toString(), v4, null);
        zzan zzan0 = new zzan(this, zzat0);
        this.zzn.zzb(v4, zzan0);
        return v4;
    }

    public final long zzB(zzat zzat0) {
        JSONObject jSONObject0 = new JSONObject();
        long v = this.zzd();
        try {
            jSONObject0.put("requestId", v);
            jSONObject0.put("type", "GET_STATUS");
            MediaStatus mediaStatus0 = this.zzw;
            if(mediaStatus0 != null) {
                jSONObject0.put("mediaSessionId", mediaStatus0.zzb());
            }
        }
        catch(JSONException unused_ex) {
        }
        this.zzg(jSONObject0.toString(), v, null);
        this.zzj.zzb(v, zzat0);
        return v;
    }

    public final long zzC(zzat zzat0, MediaSeekOptions mediaSeekOptions0) {
        JSONObject jSONObject0 = new JSONObject();
        long v = this.zzd();
        long v1 = mediaSeekOptions0.isSeekToInfinite() ? 0x3E800000000L : mediaSeekOptions0.getPosition();
        try {
            jSONObject0.put("requestId", v);
            jSONObject0.put("type", "SEEK");
            jSONObject0.put("mediaSessionId", this.zzn());
            jSONObject0.put("currentTime", ((double)v1) / 1000.0);
            switch(mediaSeekOptions0.getResumeState()) {
                case 1: {
                    jSONObject0.put("resumeState", "PLAYBACK_START");
                    break;
                }
                case 2: {
                    jSONObject0.put("resumeState", "PLAYBACK_PAUSE");
                }
            }
            if(mediaSeekOptions0.getCustomData() != null) {
                jSONObject0.put("customData", mediaSeekOptions0.getCustomData());
            }
        }
        catch(JSONException unused_ex) {
        }
        this.zzg(jSONObject0.toString(), v, null);
        this.zzx = v1;
        zzam zzam0 = new zzam(this, zzat0);
        this.zzg.zzb(v, zzam0);
        return v;
    }

    public final long zzD(zzat zzat0, long[] arr_v) {
        if(arr_v == null) {
            throw new IllegalArgumentException("trackIds cannot be null");
        }
        JSONObject jSONObject0 = new JSONObject();
        long v = this.zzd();
        try {
            jSONObject0.put("requestId", v);
            jSONObject0.put("type", "EDIT_TRACKS_INFO");
            jSONObject0.put("mediaSessionId", this.zzn());
            JSONArray jSONArray0 = new JSONArray();
            for(int v1 = 0; v1 < arr_v.length; ++v1) {
                jSONArray0.put(v1, arr_v[v1]);
            }
            jSONObject0.put("activeTrackIds", jSONArray0);
        }
        catch(JSONException unused_ex) {
        }
        this.zzg(jSONObject0.toString(), v, null);
        this.zzk.zzb(v, zzat0);
        return v;
    }

    public final long zzE(zzat zzat0, double f, JSONObject jSONObject0) {
        if(this.zzw == null) {
            throw new zzap();
        }
        JSONObject jSONObject1 = new JSONObject();
        long v = this.zzd();
        try {
            jSONObject1.put("requestId", v);
            jSONObject1.put("type", "SET_PLAYBACK_RATE");
            jSONObject1.put("playbackRate", f);
            Preconditions.checkNotNull(this.zzw, "mediaStatus should not be null");
            jSONObject1.put("mediaSessionId", this.zzw.zzb());
            if(jSONObject0 != null) {
                jSONObject1.put("customData", jSONObject0);
            }
        }
        catch(JSONException unused_ex) {
        }
        this.zzg(jSONObject1.toString(), v, null);
        this.zzt.zzb(v, zzat0);
        return v;
    }

    public final long zzF(zzat zzat0, boolean z, JSONObject jSONObject0) {
        JSONObject jSONObject1 = new JSONObject();
        long v = this.zzd();
        try {
            jSONObject1.put("requestId", v);
            jSONObject1.put("type", "SET_VOLUME");
            jSONObject1.put("mediaSessionId", this.zzn());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("muted", z);
            jSONObject1.put("volume", jSONObject2);
            if(jSONObject0 != null) {
                jSONObject1.put("customData", jSONObject0);
            }
        }
        catch(JSONException unused_ex) {
        }
        this.zzg(jSONObject1.toString(), v, null);
        this.zzi.zzb(v, zzat0);
        return v;
    }

    public final long zzG(zzat zzat0, double f, JSONObject jSONObject0) {
        if(Double.isInfinite(f) || Double.isNaN(f)) {
            throw new IllegalArgumentException("Volume cannot be " + f);
        }
        JSONObject jSONObject1 = new JSONObject();
        long v = this.zzd();
        try {
            jSONObject1.put("requestId", v);
            jSONObject1.put("type", "SET_VOLUME");
            jSONObject1.put("mediaSessionId", this.zzn());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("level", f);
            jSONObject1.put("volume", jSONObject2);
            if(jSONObject0 != null) {
                jSONObject1.put("customData", jSONObject0);
            }
        }
        catch(JSONException unused_ex) {
        }
        this.zzg(jSONObject1.toString(), v, null);
        this.zzh.zzb(v, zzat0);
        return v;
    }

    public final long zzH(zzat zzat0, TextTrackStyle textTrackStyle0) {
        if(textTrackStyle0 == null) {
            throw new IllegalArgumentException("trackStyle cannot be null");
        }
        JSONObject jSONObject0 = new JSONObject();
        long v = this.zzd();
        try {
            jSONObject0.put("requestId", v);
            jSONObject0.put("type", "EDIT_TRACKS_INFO");
            jSONObject0.put("textTrackStyle", textTrackStyle0.zza());
            jSONObject0.put("mediaSessionId", this.zzn());
        }
        catch(JSONException unused_ex) {
        }
        this.zzg(jSONObject0.toString(), v, null);
        this.zzl.zzb(v, zzat0);
        return v;
    }

    public final long zzI(zzat zzat0) {
        JSONObject jSONObject0 = new JSONObject();
        long v = this.zzd();
        try {
            jSONObject0.put("requestId", v);
            jSONObject0.put("type", "SKIP_AD");
            jSONObject0.put("mediaSessionId", this.zzn());
        }
        catch(JSONException jSONException0) {
            this.zza.w(e.b("Error creating SkipAd message: ", jSONException0.getMessage()), new Object[0]);
        }
        this.zzg(jSONObject0.toString(), v, null);
        this.zzu.zzb(v, zzat0);
        return v;
    }

    public final long zzJ(zzat zzat0, JSONObject jSONObject0) {
        JSONObject jSONObject1 = new JSONObject();
        long v = this.zzd();
        try {
            jSONObject1.put("requestId", v);
            jSONObject1.put("type", "STOP");
            jSONObject1.put("mediaSessionId", this.zzn());
            if(jSONObject0 != null) {
                jSONObject1.put("customData", jSONObject0);
            }
        }
        catch(JSONException unused_ex) {
        }
        this.zzg(jSONObject1.toString(), v, null);
        this.zzf.zzb(v, zzat0);
        return v;
    }

    public final MediaInfo zzK() {
        return this.zzw == null ? null : this.zzw.getMediaInfo();
    }

    public final MediaStatus zzL() {
        return this.zzw;
    }

    public static zzao zzM(zzar zzar0) {
        return zzar0.zzy;
    }

    public static void zzN(zzar zzar0, Long long0) {
        zzar0.zzx = null;
    }

    public final void zzO(String s) {
        int v7;
        int v5;
        int v4;
        int v3;
        Logger logger0 = this.zza;
        logger0.d("message received: %s", new Object[]{s});
        try {
            JSONObject jSONObject0 = new JSONObject(s);
            String s1 = jSONObject0.getString("type");
            long v = jSONObject0.optLong("requestId", -1L);
            int v1 = 1;
            switch(s1) {
                case "ERROR": {
                    for(Object object3: this.zza()) {
                        ((zzav)object3).zzd(v, 2100, zzar.zzS(jSONObject0));
                    }
                    if(this.zzy != null) {
                        MediaError mediaError0 = MediaError.zza(jSONObject0);
                        this.zzy.zzb(mediaError0);
                        return;
                    }
                    break;
                }
                case "INVALID_PLAYER_STATE": {
                    logger0.w("received unexpected error: Invalid Player State.", new Object[0]);
                    for(Object object1: this.zza()) {
                        ((zzav)object1).zzd(v, 2100, zzar.zzS(jSONObject0));
                    }
                    return;
                }
                case "INVALID_REQUEST": {
                    logger0.w("received unexpected error: Invalid Request.", new Object[0]);
                    for(Object object0: this.zza()) {
                        ((zzav)object0).zzd(v, 2001, zzar.zzS(jSONObject0));
                    }
                    return;
                }
                case "LOAD_CANCELLED": {
                    zzaq zzaq0 = zzar.zzS(jSONObject0);
                    this.zzc.zzd(v, 2101, zzaq0);
                    return;
                }
                case "LOAD_FAILED": {
                    zzaq zzaq1 = zzar.zzS(jSONObject0);
                    this.zzc.zzd(v, 2100, zzaq1);
                    return;
                }
                case "MEDIA_STATUS": {
                    JSONArray jSONArray0 = jSONObject0.getJSONArray("status");
                    if(jSONArray0.length() > 0) {
                        JSONObject jSONObject1 = jSONArray0.getJSONObject(0);
                        boolean z = this.zzc.zze(v);
                        if(this.zzh.zzf() && !this.zzh.zze(v)) {
                            v3 = 1;
                        }
                        else if(!this.zzi.zzf() || this.zzi.zze(v)) {
                            v3 = 0;
                        }
                        else {
                            v3 = 1;
                        }
                        if(z) {
                        label_45:
                            this.zzw = new MediaStatus(jSONObject1);
                            this.zzv = SystemClock.elapsedRealtime();
                            v4 = 0x7F;
                        }
                        else {
                            MediaStatus mediaStatus0 = this.zzw;
                            if(mediaStatus0 != null) {
                                v4 = mediaStatus0.zza(jSONObject1, v3);
                                goto label_48;
                            }
                            goto label_45;
                        }
                    label_48:
                        if((v4 & 1) == 0) {
                            v5 = 0;
                        }
                        else {
                            this.zzv = SystemClock.elapsedRealtime();
                            this.zzz = -1;
                            v5 = 1;
                        }
                        if((v4 & 2) == 0) {
                            v1 = v5;
                        }
                        else {
                            this.zzv = SystemClock.elapsedRealtime();
                        }
                        if((v4 & 0x80) != 0) {
                            this.zzv = SystemClock.elapsedRealtime();
                        }
                        if((v4 & 4) != 0) {
                            this.zzV();
                        }
                        if((v4 & 8) != 0) {
                            this.zzX();
                        }
                        if((v4 & 16) != 0) {
                            this.zzW();
                        }
                        if((v4 & 0x20) != 0) {
                            this.zzv = SystemClock.elapsedRealtime();
                            zzao zzao0 = this.zzy;
                            if(zzao0 != null) {
                                zzao0.zza();
                            }
                        }
                        if((v4 & 0x40) != 0) {
                            this.zzv = SystemClock.elapsedRealtime();
                            this.zzY();
                        }
                        else if(v1 != 0) {
                            this.zzY();
                        }
                    }
                    else {
                        this.zzw = null;
                        this.zzY();
                        this.zzV();
                        this.zzX();
                        this.zzW();
                    }
                    for(Object object2: this.zza()) {
                        ((zzav)object2).zzd(v, 0, null);
                    }
                    return;
                }
                case "QUEUE_CHANGE": {
                    this.zzs.zzd(v, 0, null);
                    this.zzU(jSONObject0, "QUEUE_CHANGE");
                    if(this.zzy != null) {
                        String s2 = jSONObject0.getString("changeType");
                        int[] arr_v = zzar.zzaa(jSONObject0.getJSONArray("itemIds"));
                        int v6 = jSONObject0.optInt("insertBefore", 0);
                        if(arr_v != null) {
                            switch(s2) {
                                case "INSERT": {
                                    this.zzy.zzf(arr_v, v6);
                                    return;
                                }
                                case "ITEMS_CHANGE": {
                                    this.zzy.zzj(arr_v);
                                    return;
                                }
                                case "REMOVE": {
                                    this.zzy.zzh(arr_v);
                                    return;
                                }
                                case "UPDATE": {
                                    v7 = 3;
                                    break;
                                }
                                default: {
                                    v7 = -1;
                                    break;
                                }
                            }
                            if(v7 == 3) {
                                int[] arr_v1 = zzar.zzaa(jSONObject0.getJSONArray("itemIds"));
                                Preconditions.checkNotNull(arr_v1, "A list of item IDs is expected in a QUEUE UPDATE message.");
                                JSONArray jSONArray2 = jSONObject0.optJSONArray("reorderItemIds");
                                if(jSONArray2 != null) {
                                    List list0 = CastUtils.zzd(arr_v1);
                                    int v8 = jSONObject0.optInt("insertBefore", 0);
                                    List list1 = CastUtils.zzd(((int[])Preconditions.checkNotNull(zzar.zzaa(jSONArray2))));
                                    this.zzy.zzi(list0, list1, v8);
                                    return;
                                }
                                this.zzy.zze(arr_v1);
                                return;
                            }
                        }
                    }
                    break;
                }
                case "QUEUE_ITEMS": {
                    this.zzr.zzd(v, 0, null);
                    this.zzU(jSONObject0, "QUEUE_ITEMS");
                    if(this.zzy != null) {
                        JSONArray jSONArray1 = jSONObject0.getJSONArray("items");
                        MediaQueueItem[] arr_mediaQueueItem = new MediaQueueItem[jSONArray1.length()];
                        for(int v2 = 0; v2 < jSONArray1.length(); ++v2) {
                            arr_mediaQueueItem[v2] = new Builder(jSONArray1.getJSONObject(v2)).build();
                        }
                        this.zzy.zzg(arr_mediaQueueItem);
                        return;
                    }
                    break;
                }
                case "QUEUE_ITEM_IDS": {
                    this.zzq.zzd(v, 0, null);
                    this.zzU(jSONObject0, "QUEUE_ITEM_IDS");
                    if(this.zzy != null) {
                        int[] arr_v2 = zzar.zzaa(jSONObject0.getJSONArray("itemIds"));
                        if(arr_v2 != null) {
                            this.zzy.zze(arr_v2);
                            return;
                        }
                    }
                    break;
                }
                default: {
                    return;
                }
            }
            return;
        }
        catch(JSONException jSONException0) {
        }
        this.zza.w("Message is malformed (%s); ignoring: %s", new Object[]{jSONException0.getMessage(), s});
    }

    public final void zzP(long v, int v1) {
        for(Object object0: this.zza()) {
            ((zzav)object0).zzd(v, v1, null);
        }
    }

    public final void zzQ(zzao zzao0) {
        this.zzy = zzao0;
    }

    private final long zzR(double f, long v, long v1) {
        long v2 = SystemClock.elapsedRealtime() - this.zzv;
        if(v2 < 0L) {
            v2 = 0L;
        }
        if(v2 == 0L) {
            return v;
        }
        long v3 = v + ((long)(((double)v2) * f));
        if(v1 > 0L && v3 > v1) {
            return v1;
        }
        return v3 < 0L ? 0L : v3;
    }

    private static zzaq zzS(JSONObject jSONObject0) {
        MediaError mediaError0 = MediaError.zza(jSONObject0);
        zzaq zzaq0 = new zzaq();
        zzaq0.zza = jSONObject0.has("customData") ? jSONObject0.optJSONObject("customData") : null;
        zzaq0.zzb = mediaError0;
        return zzaq0;
    }

    private final void zzT() {
        this.zzv = 0L;
        this.zzw = null;
        for(Object object0: this.zza()) {
            ((zzav)object0).zzc(2002);
        }
    }

    private final void zzU(JSONObject jSONObject0, String s) {
        if(jSONObject0.has("sequenceNumber")) {
            this.zzz = jSONObject0.optInt("sequenceNumber", -1);
            return;
        }
        this.zza.w(s + " message is missing a sequence number.", new Object[0]);
    }

    private final void zzV() {
        zzao zzao0 = this.zzy;
        if(zzao0 != null) {
            zzao0.zzc();
        }
    }

    private final void zzW() {
        zzao zzao0 = this.zzy;
        if(zzao0 != null) {
            zzao0.zzd();
        }
    }

    private final void zzX() {
        zzao zzao0 = this.zzy;
        if(zzao0 != null) {
            zzao0.zzk();
        }
    }

    private final void zzY() {
        zzao zzao0 = this.zzy;
        if(zzao0 != null) {
            zzao0.zzm();
        }
    }

    private final boolean zzZ() {
        return this.zzz != -1;
    }

    private static int[] zzaa(JSONArray jSONArray0) {
        if(jSONArray0 == null) {
            return null;
        }
        int[] arr_v = new int[jSONArray0.length()];
        for(int v = 0; v < jSONArray0.length(); ++v) {
            arr_v[v] = jSONArray0.getInt(v);
        }
        return arr_v;
    }

    @Override  // com.google.android.gms.cast.internal.zzq
    public final void zzf() {
        this.zzb();
        this.zzT();
    }

    public static int zzi(zzar zzar0) {
        return zzar0.zzz;
    }

    public final long zzj() {
        if(this.zzv != 0L) {
            MediaStatus mediaStatus0 = this.zzw;
            if(mediaStatus0 != null) {
                AdBreakStatus adBreakStatus0 = mediaStatus0.getAdBreakStatus();
                if(adBreakStatus0 != null) {
                    return mediaStatus0.getPlayerState() == 2 ? this.zzR((mediaStatus0.getPlaybackRate() == 0.0 ? 1.0 : mediaStatus0.getPlaybackRate()), adBreakStatus0.getCurrentBreakClipTimeInMs(), 0L) : this.zzR(0.0, adBreakStatus0.getCurrentBreakClipTimeInMs(), 0L);
                }
            }
        }
        return 0L;
    }

    public final long zzk() {
        MediaStatus mediaStatus0 = this.zzw;
        if(mediaStatus0 == null) {
            return 0L;
        }
        MediaLiveSeekableRange mediaLiveSeekableRange0 = mediaStatus0.getLiveSeekableRange();
        if(mediaLiveSeekableRange0 == null) {
            return 0L;
        }
        long v = mediaLiveSeekableRange0.getEndTime();
        return mediaLiveSeekableRange0.isLiveDone() ? v : this.zzR(1.0, v, -1L);
    }

    public final long zzl() {
        MediaStatus mediaStatus0 = this.zzw;
        if(mediaStatus0 == null) {
            return 0L;
        }
        MediaLiveSeekableRange mediaLiveSeekableRange0 = mediaStatus0.getLiveSeekableRange();
        if(mediaLiveSeekableRange0 == null) {
            return 0L;
        }
        long v = mediaLiveSeekableRange0.getStartTime();
        if(mediaLiveSeekableRange0.isMovingWindow()) {
            v = this.zzR(1.0, v, -1L);
        }
        return mediaLiveSeekableRange0.isLiveDone() ? Math.min(v, mediaLiveSeekableRange0.getEndTime()) : v;
    }

    public final long zzm() {
        MediaInfo mediaInfo0 = this.zzK();
        if(mediaInfo0 != null) {
            MediaStatus mediaStatus0 = this.zzw;
            if(mediaStatus0 != null) {
                Long long0 = this.zzx;
                if(long0 != null) {
                    if(long0.equals(0x3E800000000L)) {
                        if(this.zzw.getLiveSeekableRange() != null) {
                            return Math.min(((long)long0), this.zzk());
                        }
                        return this.zzo() < 0L ? ((long)long0) : Math.min(((long)long0), this.zzo());
                    }
                    return (long)long0;
                }
                if(this.zzv == 0L) {
                    return 0L;
                }
                double f = mediaStatus0.getPlaybackRate();
                long v = mediaStatus0.getStreamPosition();
                return f == 0.0 || mediaStatus0.getPlayerState() != 2 ? v : this.zzR(f, v, mediaInfo0.getStreamDuration());
            }
        }
        return 0L;
    }

    public final long zzn() {
        MediaStatus mediaStatus0 = this.zzw;
        if(mediaStatus0 == null) {
            throw new zzap();
        }
        return mediaStatus0.zzb();
    }

    public final long zzo() {
        MediaInfo mediaInfo0 = this.zzK();
        return mediaInfo0 == null ? 0L : mediaInfo0.getStreamDuration();
    }

    public final long zzp(zzat zzat0, MediaLoadRequestData mediaLoadRequestData0) {
        if(mediaLoadRequestData0.getMediaInfo() == null && mediaLoadRequestData0.getQueueData() == null) {
            throw new IllegalArgumentException("MediaInfo and MediaQueueData should not be both null");
        }
        JSONObject jSONObject0 = mediaLoadRequestData0.toJson();
        if(jSONObject0 == null) {
            throw new IllegalArgumentException("Failed to jsonify the load request due to malformed request");
        }
        long v = this.zzd();
        try {
            jSONObject0.put("requestId", v);
            jSONObject0.put("type", "LOAD");
        }
        catch(JSONException unused_ex) {
        }
        this.zzg(jSONObject0.toString(), v, null);
        this.zzc.zzb(v, zzat0);
        return v;
    }

    public final long zzq(zzat zzat0, JSONObject jSONObject0) {
        JSONObject jSONObject1 = new JSONObject();
        long v = this.zzd();
        try {
            jSONObject1.put("requestId", v);
            jSONObject1.put("type", "PAUSE");
            jSONObject1.put("mediaSessionId", this.zzn());
            if(jSONObject0 != null) {
                jSONObject1.put("customData", jSONObject0);
            }
        }
        catch(JSONException unused_ex) {
        }
        this.zzg(jSONObject1.toString(), v, null);
        this.zzd.zzb(v, zzat0);
        return v;
    }

    public final long zzr(zzat zzat0, JSONObject jSONObject0) {
        JSONObject jSONObject1 = new JSONObject();
        long v = this.zzd();
        try {
            jSONObject1.put("requestId", v);
            jSONObject1.put("type", "PLAY");
            jSONObject1.put("mediaSessionId", this.zzn());
            if(jSONObject0 != null) {
                jSONObject1.put("customData", jSONObject0);
            }
        }
        catch(JSONException unused_ex) {
        }
        this.zzg(jSONObject1.toString(), v, null);
        this.zze.zzb(v, zzat0);
        return v;
    }

    public final long zzs(String s, List list0) {
        long v = this.zzd();
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("requestId", v);
            jSONObject0.put("type", "PRECACHE");
            jSONObject0.put("precacheData", s);
        }
        catch(JSONException unused_ex) {
        }
        this.zzg(jSONObject0.toString(), v, null);
        return v;
    }

    public final long zzt(zzat zzat0, int v, int v1, int v2) {
        if(v1 > 0 && v2 == 0) {
            v2 = 0;
        }
        else if(v1 == 0 && v2 > 0) {
        }
        else {
            throw new IllegalArgumentException("Exactly one of nextCount and prevCount must be positive and the other must be zero");
        }
        JSONObject jSONObject0 = new JSONObject();
        long v3 = this.zzd();
        try {
            jSONObject0.put("requestId", v3);
            jSONObject0.put("type", "QUEUE_GET_ITEM_RANGE");
            jSONObject0.put("mediaSessionId", this.zzn());
            jSONObject0.put("itemId", v);
            if(v1 > 0) {
                jSONObject0.put("nextCount", v1);
            }
            if(v2 > 0) {
                jSONObject0.put("prevCount", v2);
            }
        }
        catch(JSONException unused_ex) {
        }
        this.zzg(jSONObject0.toString(), v3, null);
        this.zzs.zzb(v3, zzat0);
        return v3;
    }

    public final long zzu(zzat zzat0) {
        JSONObject jSONObject0 = new JSONObject();
        long v = this.zzd();
        try {
            jSONObject0.put("requestId", v);
            jSONObject0.put("type", "QUEUE_GET_ITEM_IDS");
            jSONObject0.put("mediaSessionId", this.zzn());
        }
        catch(JSONException unused_ex) {
        }
        this.zzg(jSONObject0.toString(), v, null);
        this.zzq.zzb(v, zzat0);
        return v;
    }

    public final long zzv(zzat zzat0, int[] arr_v) {
        JSONObject jSONObject0 = new JSONObject();
        long v = this.zzd();
        try {
            jSONObject0.put("requestId", v);
            jSONObject0.put("type", "QUEUE_GET_ITEMS");
            jSONObject0.put("mediaSessionId", this.zzn());
            JSONArray jSONArray0 = new JSONArray();
            for(int v1 = 0; v1 < arr_v.length; ++v1) {
                jSONArray0.put(arr_v[v1]);
            }
            jSONObject0.put("itemIds", jSONArray0);
        }
        catch(JSONException unused_ex) {
        }
        this.zzg(jSONObject0.toString(), v, null);
        this.zzr.zzb(v, zzat0);
        return v;
    }

    public final long zzw(zzat zzat0, MediaQueueItem[] arr_mediaQueueItem, int v, int v1, int v2, long v3, JSONObject jSONObject0) {
        if(arr_mediaQueueItem == null || arr_mediaQueueItem.length == 0) {
            throw new IllegalArgumentException("itemsToInsert must not be null or empty.");
        }
        int v4 = Long.compare(v3, -1L);
        if(v4 != 0 && v3 < 0L) {
            throw new IllegalArgumentException(e.a(v3, "playPosition can not be negative: "));
        }
        JSONObject jSONObject1 = new JSONObject();
        long v5 = this.zzd();
        try {
            jSONObject1.put("requestId", v5);
            jSONObject1.put("type", "QUEUE_INSERT");
            jSONObject1.put("mediaSessionId", this.zzn());
            JSONArray jSONArray0 = new JSONArray();
            for(int v6 = 0; v6 < arr_mediaQueueItem.length; ++v6) {
                jSONArray0.put(v6, arr_mediaQueueItem[v6].toJson());
            }
            jSONObject1.put("items", jSONArray0);
            if(v != 0) {
                jSONObject1.put("insertBefore", v);
            }
            if(v2 != -1) {
                jSONObject1.put("currentItemIndex", 0);
            }
            if(v4 != 0) {
                jSONObject1.put("currentTime", ((double)v3) / 1000.0);
            }
            if(jSONObject0 != null) {
                jSONObject1.put("customData", jSONObject0);
            }
            if(this.zzZ()) {
                jSONObject1.put("sequenceNumber", this.zzz);
            }
        }
        catch(JSONException unused_ex) {
        }
        this.zzg(jSONObject1.toString(), v5, null);
        zzan zzan0 = new zzan(this, zzat0);
        this.zzm.zzb(v5, zzan0);
        return v5;
    }

    public final long zzx(zzat zzat0, MediaQueueItem[] arr_mediaQueueItem, int v, int v1, long v2, JSONObject jSONObject0) {
        if(arr_mediaQueueItem == null || arr_mediaQueueItem.length == 0) {
            throw new IllegalArgumentException("items must not be null or empty.");
        }
        if(v < 0 || v >= arr_mediaQueueItem.length) {
            throw new IllegalArgumentException("Invalid startIndex: " + v);
        }
        int v3 = Long.compare(v2, -1L);
        if(v3 != 0 && v2 < 0L) {
            throw new IllegalArgumentException(e.a(v2, "playPosition can not be negative: "));
        }
        JSONObject jSONObject1 = new JSONObject();
        long v4 = this.zzd();
        this.zzc.zzb(v4, zzat0);
        try {
            jSONObject1.put("requestId", v4);
            jSONObject1.put("type", "QUEUE_LOAD");
            JSONArray jSONArray0 = new JSONArray();
            for(int v5 = 0; v5 < arr_mediaQueueItem.length; ++v5) {
                jSONArray0.put(v5, arr_mediaQueueItem[v5].toJson());
            }
            jSONObject1.put("items", jSONArray0);
            String s = MediaCommon.zza(v1);
            if(s == null) {
                throw new IllegalArgumentException("Invalid repeat mode: " + v1);
            }
            jSONObject1.put("repeatMode", s);
            jSONObject1.put("startIndex", v);
            if(v3 != 0) {
                jSONObject1.put("currentTime", ((double)v2) / 1000.0);
            }
            if(jSONObject0 != null) {
                jSONObject1.put("customData", jSONObject0);
            }
            if(this.zzZ()) {
                jSONObject1.put("sequenceNumber", this.zzz);
            }
        }
        catch(JSONException unused_ex) {
        }
        this.zzg(jSONObject1.toString(), v4, null);
        return v4;
    }

    public final long zzy(zzat zzat0, int[] arr_v, JSONObject jSONObject0) {
        if(arr_v == null || arr_v.length == 0) {
            throw new IllegalArgumentException("itemIdsToRemove must not be null or empty.");
        }
        JSONObject jSONObject1 = new JSONObject();
        long v = this.zzd();
        try {
            jSONObject1.put("requestId", v);
            jSONObject1.put("type", "QUEUE_REMOVE");
            jSONObject1.put("mediaSessionId", this.zzn());
            JSONArray jSONArray0 = new JSONArray();
            for(int v1 = 0; v1 < arr_v.length; ++v1) {
                jSONArray0.put(v1, arr_v[v1]);
            }
            jSONObject1.put("itemIds", jSONArray0);
            if(jSONObject0 != null) {
                jSONObject1.put("customData", jSONObject0);
            }
            if(this.zzZ()) {
                jSONObject1.put("sequenceNumber", this.zzz);
            }
        }
        catch(JSONException unused_ex) {
        }
        this.zzg(jSONObject1.toString(), v, null);
        zzan zzan0 = new zzan(this, zzat0);
        this.zzo.zzb(v, zzan0);
        return v;
    }

    public final long zzz(zzat zzat0, int[] arr_v, int v, JSONObject jSONObject0) {
        if(arr_v == null || arr_v.length == 0) {
            throw new IllegalArgumentException("itemIdsToReorder must not be null or empty.");
        }
        JSONObject jSONObject1 = new JSONObject();
        long v1 = this.zzd();
        try {
            jSONObject1.put("requestId", v1);
            jSONObject1.put("type", "QUEUE_REORDER");
            jSONObject1.put("mediaSessionId", this.zzn());
            JSONArray jSONArray0 = new JSONArray();
            for(int v2 = 0; v2 < arr_v.length; ++v2) {
                jSONArray0.put(v2, arr_v[v2]);
            }
            jSONObject1.put("itemIds", jSONArray0);
            if(v != 0) {
                jSONObject1.put("insertBefore", v);
            }
            if(jSONObject0 != null) {
                jSONObject1.put("customData", jSONObject0);
            }
            if(this.zzZ()) {
                jSONObject1.put("sequenceNumber", this.zzz);
            }
        }
        catch(JSONException unused_ex) {
        }
        this.zzg(jSONObject1.toString(), v1, null);
        zzan zzan0 = new zzan(this, zzat0);
        this.zzp.zzb(v1, zzan0);
        return v1;
    }
}

