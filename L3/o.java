package l3;

import androidx.media3.common.DrmInitData;
import androidx.media3.common.Metadata.Entry;
import androidx.media3.common.Metadata;
import androidx.media3.common.b;
import androidx.media3.extractor.metadata.id3.PrivFrame;
import b3.n;
import java.util.Map;
import k3.k;
import s3.U;
import w3.d;

public final class o extends U {
    public final Map H;
    public DrmInitData I;

    public o(d d0, k3.o o0, k k0, Map map0) {
        super(d0, o0, k0);
        this.H = map0;
    }

    @Override  // s3.U
    public final b j(b b0) {
        DrmInitData drmInitData0 = this.I == null ? b0.r : this.I;
        if(drmInitData0 != null) {
            DrmInitData drmInitData1 = (DrmInitData)this.H.get(drmInitData0.c);
            if(drmInitData1 != null) {
                drmInitData0 = drmInitData1;
            }
        }
        Metadata metadata0 = b0.l;
        Metadata metadata1 = null;
        if(metadata0 == null) {
            metadata0 = null;
        }
        else {
            Entry[] arr_metadata$Entry = metadata0.a;
            int v1;
            for(v1 = 0; true; ++v1) {
                if(v1 >= arr_metadata$Entry.length) {
                    v1 = -1;
                    break;
                }
                Entry metadata$Entry0 = arr_metadata$Entry[v1];
                if(metadata$Entry0 instanceof PrivFrame && "com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame)metadata$Entry0).b)) {
                    break;
                }
            }
            if(v1 != -1) {
                if(arr_metadata$Entry.length != 1) {
                    Entry[] arr_metadata$Entry1 = new Entry[arr_metadata$Entry.length - 1];
                    for(int v = 0; v < arr_metadata$Entry.length; ++v) {
                        if(v != v1) {
                            arr_metadata$Entry1[(v >= v1 ? v - 1 : v)] = arr_metadata$Entry[v];
                        }
                    }
                    metadata1 = new Metadata(arr_metadata$Entry1);
                }
                metadata0 = metadata1;
            }
        }
        if(drmInitData0 != b0.r || metadata0 != b0.l) {
            n n0 = b0.a();
            n0.q = drmInitData0;
            n0.k = metadata0;
            b0 = new b(n0);
        }
        return super.j(b0);
    }
}

