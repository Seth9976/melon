package h3;

import W.p;
import android.media.MediaCodec.CryptoInfo.Pattern;
import android.media.MediaCodec.CryptoInfo;
import i.n.i.b.a.s.e.L7;
import x9.c;

public final class b {
    public byte[] a;
    public byte[] b;
    public int c;
    public int[] d;
    public int[] e;
    public int f;
    public int g;
    public int h;
    public final MediaCodec.CryptoInfo i;
    public final Object j;

    public b(int v) {
        if(v != 1) {
            super();
            MediaCodec.CryptoInfo mediaCodec$CryptoInfo0 = new MediaCodec.CryptoInfo();
            this.i = mediaCodec$CryptoInfo0;
            p p0 = new p();  // 初始化器: Ljava/lang/Object;-><init>()V
            p0.a = mediaCodec$CryptoInfo0;
            p0.b = new MediaCodec.CryptoInfo.Pattern(0, 0);
            this.j = p0;
            return;
        }
        super();
        MediaCodec.CryptoInfo mediaCodec$CryptoInfo1 = new MediaCodec.CryptoInfo();
        this.i = mediaCodec$CryptoInfo1;
        this.j = L7.a < 24 ? null : new c(mediaCodec$CryptoInfo1);
    }

    public void a(int v, int[] arr_v, int[] arr_v1, byte[] arr_b, byte[] arr_b1, int v1, int v2, int v3) {
        this.f = v;
        this.d = arr_v;
        this.e = arr_v1;
        this.b = arr_b;
        this.a = arr_b1;
        this.c = v1;
        this.g = v2;
        this.h = v3;
        this.i.numSubSamples = v;
        this.i.numBytesOfClearData = arr_v;
        this.i.numBytesOfEncryptedData = arr_v1;
        this.i.key = arr_b;
        this.i.iv = arr_b1;
        this.i.mode = v1;
        if(L7.a >= 24) {
            ((c)this.j).getClass();
            MediaCodec.CryptoInfo.Pattern mediaCodec$CryptoInfo$Pattern0 = (MediaCodec.CryptoInfo.Pattern)((c)this.j).c;
            mediaCodec$CryptoInfo$Pattern0.set(v2, v3);
            ((MediaCodec.CryptoInfo)((c)this.j).b).setPattern(mediaCodec$CryptoInfo$Pattern0);
        }
    }
}

