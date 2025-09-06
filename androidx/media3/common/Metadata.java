package androidx.media3.common;

import B.a;
import R3.e;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

public final class Metadata implements Parcelable {
    public interface Entry extends Parcelable {
        default void M(c c0) {
        }

        default byte[] getWrappedMetadataBytes() {
            return null;
        }

        default b getWrappedMetadataFormat() {
            return null;
        }
    }

    public static final Parcelable.Creator CREATOR;
    public final Entry[] a;
    public final long b;

    static {
        Metadata.CREATOR = new e(3);
    }

    public Metadata(long v, Entry[] arr_metadata$Entry) {
        this.b = v;
        this.a = arr_metadata$Entry;
    }

    public Metadata(Parcel parcel0) {
        this.a = new Entry[parcel0.readInt()];
        for(int v = 0; true; ++v) {
            Entry[] arr_metadata$Entry = this.a;
            if(v >= arr_metadata$Entry.length) {
                break;
            }
            arr_metadata$Entry[v] = (Entry)parcel0.readParcelable(Entry.class.getClassLoader());
        }
        this.b = parcel0.readLong();
    }

    public Metadata(List list0) {
        this(((Entry[])list0.toArray(new Entry[0])));
    }

    public Metadata(Entry[] arr_metadata$Entry) {
        this(0x8000000000000001L, arr_metadata$Entry);
    }

    public final Metadata a(Entry[] arr_metadata$Entry) {
        if(arr_metadata$Entry.length == 0) {
            return this;
        }
        Object[] arr_object = Arrays.copyOf(this.a, this.a.length + arr_metadata$Entry.length);
        System.arraycopy(arr_metadata$Entry, 0, arr_object, this.a.length, arr_metadata$Entry.length);
        return new Metadata(this.b, ((Entry[])arr_object));
    }

    public final Metadata b(Metadata metadata0) {
        return metadata0 == null ? this : this.a(metadata0.a);
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
            return Metadata.class == class0 && Arrays.equals(this.a, ((Metadata)object0).a) && this.b == ((Metadata)object0).b;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = Arrays.hashCode(this.a);
        return a.P(this.b) + v * 0x1F;
    }

    @Override
    public final String toString() {
        return "entries=" + Arrays.toString(this.a) + (this.b == 0x8000000000000001L ? "" : ", presentationTimeUs=" + this.b);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        Entry[] arr_metadata$Entry = this.a;
        parcel0.writeInt(arr_metadata$Entry.length);
        for(int v1 = 0; v1 < arr_metadata$Entry.length; ++v1) {
            parcel0.writeParcelable(arr_metadata$Entry[v1], 0);
        }
        parcel0.writeLong(this.b);
    }
}

