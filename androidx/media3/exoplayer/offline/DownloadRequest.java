package androidx.media3.exoplayer.offline;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import androidx.media3.common.StreamKey;
import com.iloen.melon.sns.model.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class DownloadRequest implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final String a;
    public final Uri b;
    public final String c;
    public final List d;
    public final byte[] e;
    public final String f;
    public final byte[] g;

    static {
        DownloadRequest.CREATOR = new e(26);
    }

    public DownloadRequest(Parcel parcel0) {
        this.a = parcel0.readString();
        this.b = Uri.parse(parcel0.readString());
        this.c = parcel0.readString();
        int v = parcel0.readInt();
        ArrayList arrayList0 = new ArrayList(v);
        for(int v1 = 0; v1 < v; ++v1) {
            arrayList0.add(((StreamKey)parcel0.readParcelable(StreamKey.class.getClassLoader())));
        }
        this.d = Collections.unmodifiableList(arrayList0);
        this.e = parcel0.createByteArray();
        this.f = parcel0.readString();
        this.g = parcel0.createByteArray();
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    // 去混淆评级： 中等(80)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof DownloadRequest ? this.a.equals(((DownloadRequest)object0).a) && this.b.equals(((DownloadRequest)object0).b) && Objects.equals(this.c, ((DownloadRequest)object0).c) && this.d.equals(((DownloadRequest)object0).d) && Arrays.equals(this.e, ((DownloadRequest)object0).e) && Objects.equals(this.f, ((DownloadRequest)object0).f) && Arrays.equals(this.g, ((DownloadRequest)object0).g) : false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        int v1 = this.b.hashCode();
        int v2 = 0;
        int v3 = this.c == null ? 0 : this.c.hashCode();
        int v4 = this.d.hashCode();
        int v5 = Arrays.hashCode(this.e);
        String s = this.f;
        if(s != null) {
            v2 = s.hashCode();
        }
        return Arrays.hashCode(this.g) + ((v5 + (v4 + ((v1 + v * 961) * 0x1F + v3) * 0x1F) * 0x1F) * 0x1F + v2) * 0x1F;
    }

    @Override
    public final String toString() {
        return this.c + ":" + this.a;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b.toString());
        parcel0.writeString(this.c);
        List list0 = this.d;
        parcel0.writeInt(list0.size());
        for(int v1 = 0; v1 < list0.size(); ++v1) {
            parcel0.writeParcelable(((Parcelable)list0.get(v1)), 0);
        }
        parcel0.writeByteArray(this.e);
        parcel0.writeString(this.f);
        parcel0.writeByteArray(this.g);
    }
}

