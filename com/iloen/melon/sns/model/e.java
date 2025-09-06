package com.iloen.melon.sns.model;

import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.Mp4LocationData;
import androidx.media3.container.Mp4OrientationData;
import androidx.media3.container.Mp4TimestampData;
import androidx.media3.container.XmpData;
import androidx.media3.exoplayer.hls.HlsTrackMetadataEntry;
import androidx.media3.exoplayer.offline.DownloadRequest;
import androidx.media3.exoplayer.scheduler.Requirements;
import coil.memory.MemoryCache.Key;
import com.google.android.material.badge.BadgeState.State;
import com.iloen.melon.lyric.LyricsInfo;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.SpecialBgVideo;
import com.iloen.melon.types.BasicNameValuePair;
import com.melon.playlist.interfaces.PlayableData;
import com.melon.playlist.mixup.DjMalrangInfo;
import com.melon.ui.musicwave.ChannelInfoData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import kotlin.jvm.internal.q;
import pc.b;

public final class e implements Parcelable.Creator {
    public final int a;

    public e(int v) {
        this.a = v;
        super();
    }

    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        switch(this.a) {
            case 0: {
                return new SharablePhoto(parcel0);
            }
            case 1: {
                SharablePhotoTheme sharablePhotoTheme0 = new SharablePhotoTheme(parcel0);  // 初始化器: Lcom/iloen/melon/sns/model/SharablePhoto;-><init>(Landroid/os/Parcel;)V
                sharablePhotoTheme0.g = parcel0.readString();
                return sharablePhotoTheme0;
            }
            case 2: {
                return new SharablePlaylist(parcel0);
            }
            case 3: {
                q.g(parcel0, "source");
                SharableProgram sharableProgram0 = new SharableProgram();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharableProgram0.a = parcel0.readString();
                sharableProgram0.b = parcel0.readString();
                sharableProgram0.d = parcel0.readString();
                return sharableProgram0;
            }
            case 4: {
                SharableRealChart sharableRealChart0 = new SharableRealChart();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharableRealChart0.a = parcel0.readString();
                sharableRealChart0.b = parcel0.readString();
                sharableRealChart0.d = parcel0.readString();
                sharableRealChart0.e = parcel0.readString();
                sharableRealChart0.f = parcel0.readString();
                sharableRealChart0.g = parcel0.readString();
                sharableRealChart0.h = parcel0.readString();
                return sharableRealChart0;
            }
            case 5: {
                SharableSong sharableSong0 = new SharableSong();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharableSong0.a = parcel0.readString();
                sharableSong0.b = parcel0.readString();
                sharableSong0.d = parcel0.readString();
                sharableSong0.e = parcel0.readString();
                sharableSong0.f = parcel0.readString();
                sharableSong0.g = parcel0.readString();
                return sharableSong0;
            }
            case 6: {
                SharableStory sharableStory0 = new SharableStory();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharableStory0.a = parcel0.readString();
                sharableStory0.b = parcel0.readString();
                sharableStory0.d = parcel0.readString();
                sharableStory0.e = parcel0.readString();
                return sharableStory0;
            }
            case 7: {
                q.g(parcel0, "source");
                SharableStreamingCard sharableStreamingCard0 = new SharableStreamingCard();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharableStreamingCard0.h = -1;
                sharableStreamingCard0.a = parcel0.readString();
                sharableStreamingCard0.b = parcel0.readString();
                sharableStreamingCard0.d = parcel0.readString();
                sharableStreamingCard0.e = parcel0.readString();
                sharableStreamingCard0.f = parcel0.readString();
                sharableStreamingCard0.g = parcel0.readString();
                sharableStreamingCard0.h = parcel0.readInt();
                return sharableStreamingCard0;
            }
            case 8: {
                q.g(parcel0, "source");
                SharableTemperatureCard sharableTemperatureCard0 = new SharableTemperatureCard();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharableTemperatureCard0.a = parcel0.readString();
                sharableTemperatureCard0.b = parcel0.readString();
                sharableTemperatureCard0.d = parcel0.readString();
                sharableTemperatureCard0.e = parcel0.readString();
                sharableTemperatureCard0.f = parcel0.readString();
                return sharableTemperatureCard0;
            }
            case 9: {
                SharableTheme sharableTheme0 = new SharableTheme();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharableTheme0.a = parcel0.readString();
                sharableTheme0.b = parcel0.readString();
                sharableTheme0.d = parcel0.readString();
                sharableTheme0.e = parcel0.readString();
                return sharableTheme0;
            }
            case 10: {
                q.g(parcel0, "source");
                SharableTopic sharableTopic0 = new SharableTopic();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharableTopic0.a = parcel0.readString();
                sharableTopic0.b = parcel0.readString();
                sharableTopic0.d = parcel0.readString();
                sharableTopic0.e = parcel0.readString();
                sharableTopic0.f = (ShareLinkData)parcel0.readParcelable(ShareLinkData.class.getClassLoader());
                return sharableTopic0;
            }
            case 11: {
                q.g(parcel0, "source");
                SharableTvProgram sharableTvProgram0 = new SharableTvProgram();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharableTvProgram0.a = parcel0.readString();
                sharableTvProgram0.b = parcel0.readString();
                sharableTvProgram0.d = parcel0.readString();
                sharableTvProgram0.e = (ShareLinkData)parcel0.readParcelable(ShareLinkData.class.getClassLoader());
                return sharableTvProgram0;
            }
            case 12: {
                ShareLinkData shareLinkData0 = new ShareLinkData();  // 初始化器: Ljava/lang/Object;-><init>()V
                shareLinkData0.a = parcel0.readString();
                shareLinkData0.b = parcel0.readString();
                shareLinkData0.c = parcel0.readString();
                shareLinkData0.d = parcel0.readString();
                return shareLinkData0;
            }
            case 13: {
                q.g(parcel0, "parcel");
                return new LyricsInfo(parcel0.readLong(), parcel0.readString());
            }
            case 14: {
                q.g(parcel0, "parcel");
                int v = parcel0.readInt();
                return parcel0.readInt() == 0 ? new ActivityResult(v, null) : new ActivityResult(v, ((Intent)Intent.CREATOR.createFromParcel(parcel0)));
            }
            case 15: {
                q.g(parcel0, "inParcel");
                Parcelable parcelable0 = parcel0.readParcelable(IntentSender.class.getClassLoader());
                q.d(parcelable0);
                return new IntentSenderRequest(((IntentSender)parcelable0), ((Intent)parcel0.readParcelable(Intent.class.getClassLoader())), parcel0.readInt(), parcel0.readInt());
            }
            case 16: {
                return new MdtaMetadataEntry(parcel0);
            }
            case 17: {
                return new Mp4LocationData(parcel0);
            }
            case 18: {
                return new Mp4OrientationData(parcel0);
            }
            case 19: {
                return new Mp4TimestampData(parcel0);
            }
            case 20: {
                return new XmpData(parcel0);
            }
            case 21: {
                BadgeState.State badgeState$State0 = new BadgeState.State();  // 初始化器: Ljava/lang/Object;-><init>()V
                badgeState$State0.i = 0xFF;
                badgeState$State0.k = -2;
                badgeState$State0.l = -2;
                badgeState$State0.m = -2;
                badgeState$State0.E = Boolean.TRUE;
                badgeState$State0.a = parcel0.readInt();
                badgeState$State0.b = (Integer)parcel0.readSerializable();
                badgeState$State0.c = (Integer)parcel0.readSerializable();
                badgeState$State0.d = (Integer)parcel0.readSerializable();
                badgeState$State0.e = (Integer)parcel0.readSerializable();
                badgeState$State0.f = (Integer)parcel0.readSerializable();
                badgeState$State0.g = (Integer)parcel0.readSerializable();
                badgeState$State0.h = (Integer)parcel0.readSerializable();
                badgeState$State0.i = parcel0.readInt();
                badgeState$State0.j = parcel0.readString();
                badgeState$State0.k = parcel0.readInt();
                badgeState$State0.l = parcel0.readInt();
                badgeState$State0.m = parcel0.readInt();
                badgeState$State0.o = parcel0.readString();
                badgeState$State0.r = parcel0.readString();
                badgeState$State0.w = parcel0.readInt();
                badgeState$State0.D = (Integer)parcel0.readSerializable();
                badgeState$State0.G = (Integer)parcel0.readSerializable();
                badgeState$State0.I = (Integer)parcel0.readSerializable();
                badgeState$State0.M = (Integer)parcel0.readSerializable();
                badgeState$State0.N = (Integer)parcel0.readSerializable();
                badgeState$State0.S = (Integer)parcel0.readSerializable();
                badgeState$State0.T = (Integer)parcel0.readSerializable();
                badgeState$State0.X = (Integer)parcel0.readSerializable();
                badgeState$State0.V = (Integer)parcel0.readSerializable();
                badgeState$State0.W = (Integer)parcel0.readSerializable();
                badgeState$State0.E = (Boolean)parcel0.readSerializable();
                badgeState$State0.n = (Locale)parcel0.readSerializable();
                badgeState$State0.Y = (Boolean)parcel0.readSerializable();
                return badgeState$State0;
            }
            case 22: {
                q.g(parcel0, "parcel");
                String s = parcel0.readString();
                String s1 = parcel0.readString();
                String s2 = parcel0.readString();
                return parcel0.readInt() == 0 ? new ChannelInfoData(s, s1, s2, false, parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString()) : new ChannelInfoData(s, s1, s2, true, parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString());
            }
            case 23: {
                return new HlsTrackMetadataEntry(parcel0);
            }
            case 24: {
                q.g(parcel0, "parcel");
                Parcelable parcelable1 = parcel0.readParcelable(PlayableData.class.getClassLoader());
                String s3 = parcel0.readString();
                boolean z = parcel0.readInt() != 0;
                boolean z1 = parcel0.readInt() != 0;
                String s4 = parcel0.readString();
                String s5 = parcel0.readString();
                long v2 = parcel0.readLong();
                String s6 = parcel0.readString();
                String s7 = parcel0.readString();
                boolean z2 = parcel0.readInt() != 0;
                boolean z3 = parcel0.readInt() != 0;
                int v3 = parcel0.readInt();
                Parcelable parcelable2 = parcel0.readParcelable(PlayableData.class.getClassLoader());
                Parcelable parcelable3 = parcel0.readParcelable(PlayableData.class.getClassLoader());
                Serializable serializable0 = parcel0.readSerializable();
                int v4 = parcel0.readInt();
                ArrayList arrayList0 = new ArrayList(v4);
                for(int v1 = 0; v1 != v4; ++v1) {
                    arrayList0.add(parcel0.readSerializable());
                }
                return new PlayableData(((Playable)parcelable1), s3, z, z1, s4, s5, v2, s6, s7, z2, z3, v3, ((Uri)parcelable2), ((Uri)parcelable3), ((SpecialBgVideo)serializable0), arrayList0);
            }
            case 25: {
                q.g(parcel0, "parcel");
                return new DjMalrangInfo(parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), b.valueOf(parcel0.readString()));
            }
            case 26: {
                return new DownloadRequest(parcel0);
            }
            case 27: {
                return new Requirements(parcel0.readInt());
            }
            case 28: {
                String s8 = parcel0.readString();
                q.d(s8);
                int v5 = parcel0.readInt();
                LinkedHashMap linkedHashMap0 = new LinkedHashMap(v5);
                for(int v6 = 0; v6 < v5; ++v6) {
                    String s9 = parcel0.readString();
                    q.d(s9);
                    String s10 = parcel0.readString();
                    q.d(s10);
                    linkedHashMap0.put(s9, s10);
                }
                return new MemoryCache.Key(s8, linkedHashMap0);
            }
            default: {
                return new BasicNameValuePair(parcel0);
            }
        }
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        switch(this.a) {
            case 0: {
                return new SharablePhoto[v];
            }
            case 1: {
                return new SharablePhotoTheme[v];
            }
            case 2: {
                return new SharablePlaylist[v];
            }
            case 3: {
                return new SharableProgram[v];
            }
            case 4: {
                return new SharableRealChart[v];
            }
            case 5: {
                return new SharableSong[v];
            }
            case 6: {
                return new SharableStory[v];
            }
            case 7: {
                return new SharableStreamingCard[v];
            }
            case 8: {
                return new SharableTemperatureCard[v];
            }
            case 9: {
                return new SharableTheme[v];
            }
            case 10: {
                return new SharableTopic[v];
            }
            case 11: {
                return new SharableTvProgram[v];
            }
            case 12: {
                return new ShareLinkData[v];
            }
            case 13: {
                return new LyricsInfo[v];
            }
            case 14: {
                return new ActivityResult[v];
            }
            case 15: {
                return new IntentSenderRequest[v];
            }
            case 16: {
                return new MdtaMetadataEntry[v];
            }
            case 17: {
                return new Mp4LocationData[v];
            }
            case 18: {
                return new Mp4OrientationData[v];
            }
            case 19: {
                return new Mp4TimestampData[v];
            }
            case 20: {
                return new XmpData[v];
            }
            case 21: {
                return new BadgeState.State[v];
            }
            case 22: {
                return new ChannelInfoData[v];
            }
            case 23: {
                return new HlsTrackMetadataEntry[v];
            }
            case 24: {
                return new PlayableData[v];
            }
            case 25: {
                return new DjMalrangInfo[v];
            }
            case 26: {
                return new DownloadRequest[v];
            }
            case 27: {
                return new Requirements[v];
            }
            case 28: {
                return new MemoryCache.Key[v];
            }
            default: {
                return new BasicNameValuePair[v];
            }
        }
    }
}

