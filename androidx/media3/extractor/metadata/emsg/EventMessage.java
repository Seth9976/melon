package androidx.media3.extractor.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.media3.common.Metadata.Entry;
import androidx.media3.common.b;
import b3.n;
import java.util.Arrays;
import java.util.Objects;
import y.a;

public final class EventMessage implements Entry {
    public static final Parcelable.Creator CREATOR;
    public final String a;
    public final String b;
    public final long c;
    public final long d;
    public final byte[] e;
    public int f;
    public static final b g;
    public static final b h;

    static {
        n n0 = new n();
        n0.m = "application/id3";
        EventMessage.g = new b(n0);
        n n1 = new n();
        n1.m = "application/x-scte35";
        EventMessage.h = new b(n1);
        EventMessage.CREATOR = new a(7);
    }

    public EventMessage(Parcel parcel0) {
        this.a = parcel0.readString();
        this.b = parcel0.readString();
        this.c = parcel0.readLong();
        this.d = parcel0.readLong();
        this.e = parcel0.createByteArray();
    }

    public EventMessage(String s, String s1, long v, long v1, byte[] arr_b) {
        this.a = s;
        this.b = s1;
        this.c = v;
        this.d = v1;
        this.e = arr_b;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return EventMessage.class == class0 && this.c == ((EventMessage)object0).c && this.d == ((EventMessage)object0).d && Objects.equals(this.a, ((EventMessage)object0).a) && Objects.equals(this.b, ((EventMessage)object0).b) && Arrays.equals(this.e, ((EventMessage)object0).e);
        }
        return false;
    }

    @Override  // androidx.media3.common.Metadata$Entry
    public final byte[] getWrappedMetadataBytes() {
        return this.getWrappedMetadataFormat() == null ? null : this.e;
    }

    @Override  // androidx.media3.common.Metadata$Entry
    public final b getWrappedMetadataFormat() {
        this.a.getClass();
        switch(this.a) {
            case "https://aomedia.org/emsg/ID3": {
                return EventMessage.g;
            }
            case "https://developer.apple.com/streaming/emsg-id3": {
                return EventMessage.g;
            }
            case "urn:scte:scte35:2014:bin": {
                return EventMessage.h;
            }
            default: {
                return null;
            }
        }
    }

    @Override
    public final int hashCode() {
        if(this.f == 0) {
            int v = 0;
            int v1 = this.a == null ? 0 : this.a.hashCode();
            String s = this.b;
            if(s != null) {
                v = s.hashCode();
            }
            this.f = Arrays.hashCode(this.e) + ((((v1 + 0x20F) * 0x1F + v) * 0x1F + ((int)(this.c ^ this.c >>> 0x20))) * 0x1F + ((int)(this.d ^ this.d >>> 0x20))) * 0x1F;
        }
        return this.f;
    }

    @Override
    public final String toString() {
        return "EMSG: scheme=" + this.a + ", id=" + this.d + ", durationMs=" + this.c + ", value=" + this.b;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeLong(this.c);
        parcel0.writeLong(this.d);
        parcel0.writeByteArray(this.e);
    }
}

