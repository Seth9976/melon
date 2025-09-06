package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.List;

public final class Metadata implements Parcelable {
    public interface Entry extends Parcelable {
        default byte[] getWrappedMetadataBytes() {
            return null;
        }

        default Format getWrappedMetadataFormat() {
            return null;
        }
    }

    public static final Parcelable.Creator CREATOR;
    private final Entry[] entries;

    static {
        Metadata.CREATOR = new Parcelable.Creator() {
            public Metadata createFromParcel(Parcel parcel0) {
                return new Metadata(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public Metadata[] newArray(int v) {
                return new Metadata[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public Metadata(Parcel parcel0) {
        this.entries = new Entry[parcel0.readInt()];
        for(int v = 0; true; ++v) {
            Entry[] arr_metadata$Entry = this.entries;
            if(v >= arr_metadata$Entry.length) {
                break;
            }
            arr_metadata$Entry[v] = (Entry)parcel0.readParcelable(Entry.class.getClassLoader());
        }
    }

    public Metadata(List list0) {
        Entry[] arr_metadata$Entry = new Entry[list0.size()];
        this.entries = arr_metadata$Entry;
        list0.toArray(arr_metadata$Entry);
    }

    public Metadata(Entry[] arr_metadata$Entry) {
        this.entries = arr_metadata$Entry;
    }

    public Metadata copyWithAppendedEntries(Entry[] arr_metadata$Entry) {
        return arr_metadata$Entry.length == 0 ? this : new Metadata(((Entry[])Util.nullSafeArrayConcatenation(this.entries, arr_metadata$Entry)));
    }

    public Metadata copyWithAppendedEntriesFrom(Metadata metadata0) {
        return metadata0 == null ? this : this.copyWithAppendedEntries(metadata0.entries);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return Metadata.class == class0 ? Arrays.equals(this.entries, ((Metadata)object0).entries) : false;
        }
        return false;
    }

    public Entry get(int v) {
        return this.entries[v];
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.entries);
    }

    public int length() {
        return this.entries.length;
    }

    @Override
    public String toString() {
        String s = Arrays.toString(this.entries);
        return s.length() == 0 ? new String("entries=") : "entries=" + s;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.entries.length);
        Entry[] arr_metadata$Entry = this.entries;
        for(int v1 = 0; v1 < arr_metadata$Entry.length; ++v1) {
            parcel0.writeParcelable(arr_metadata$Entry[v1], 0);
        }
    }
}

