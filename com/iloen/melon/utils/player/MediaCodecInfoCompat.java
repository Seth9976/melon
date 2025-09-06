package com.iloen.melon.utils.player;

import Tf.v;
import android.media.MediaCodecInfo;
import com.iloen.melon.popup.H;
import com.iloen.melon.utils.log.LogU;
import d3.g;
import ie.r;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001A\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001A\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001A\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\b¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/utils/player/MediaCodecInfoCompat;", "", "", "isAc4Supported", "()Z", "isFlacSupported", "", "MIMETYPE_FLAC", "Ljava/lang/String;", "MIMETYPE_AC4", "MIMETYPE_EAC3", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MediaCodecInfoCompat {
    public static final int $stable = 0;
    @NotNull
    public static final MediaCodecInfoCompat INSTANCE = null;
    @NotNull
    public static final String MIMETYPE_AC4 = "audio/ac4";
    @NotNull
    public static final String MIMETYPE_EAC3 = "audio/eac3";
    @NotNull
    public static final String MIMETYPE_FLAC = "audio/flac";
    public static final r a;

    static {
        MediaCodecInfoCompat.INSTANCE = new MediaCodecInfoCompat();  // 初始化器: Ljava/lang/Object;-><init>()V
        MediaCodecInfoCompat.a = g.Q(new H(10));
        MediaCodecInfoCompat.$stable = 8;
    }

    public static boolean a(String s) {
        MediaCodecInfo[] arr_mediaCodecInfo = (MediaCodecInfo[])MediaCodecInfoCompat.a.getValue();
        q.f(arr_mediaCodecInfo, "<get-codecInfos>(...)");
        ArrayList arrayList0 = new ArrayList();
        boolean z = false;
        for(int v = 0; v < arr_mediaCodecInfo.length; ++v) {
            MediaCodecInfo mediaCodecInfo0 = arr_mediaCodecInfo[v];
            if(!mediaCodecInfo0.isEncoder()) {
                arrayList0.add(mediaCodecInfo0);
            }
        }
        if(!arrayList0.isEmpty()) {
        alab1:
            for(Object object0: arrayList0) {
                String[] arr_s = ((MediaCodecInfo)object0).getSupportedTypes();
                q.f(arr_s, "getSupportedTypes(...)");
                for(int v1 = 0; v1 < arr_s.length; ++v1) {
                    if(v.j0(arr_s[v1], s, true)) {
                        z = true;
                        break alab1;
                    }
                }
            }
        }
        LogU.Companion.d("MediaCodecInfoCompat", "codecInfo.supportedTypes.any(" + s + "): " + z);
        return z;
    }

    public static final boolean isAc4Supported() {
        MediaCodecInfoCompat.INSTANCE.getClass();
        return MediaCodecInfoCompat.a("audio/ac4");
    }

    public final boolean isFlacSupported() {
        return MediaCodecInfoCompat.a("audio/flac");
    }
}

