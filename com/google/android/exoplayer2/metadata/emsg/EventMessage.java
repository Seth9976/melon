package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import b3.Z;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.util.Util;
import com.iloen.melon.utils.a;
import java.util.Arrays;

public final class EventMessage implements Entry {
    public static final Parcelable.Creator CREATOR = null;
    private static final Format ID3_FORMAT = null;
    public static final String ID3_SCHEME_ID_AOM = "https://aomedia.org/emsg/ID3";
    private static final String ID3_SCHEME_ID_APPLE = "https://developer.apple.com/streaming/emsg-id3";
    private static final Format SCTE35_FORMAT = null;
    public static final String SCTE35_SCHEME_ID = "urn:scte:scte35:2014:bin";
    public final long durationMs;
    private int hashCode;
    public final long id;
    public final byte[] messageData;
    public final String schemeIdUri;
    public final String value;

    static {
        EventMessage.ID3_FORMAT = Format.createSampleFormat(null, "application/id3", 0x7FFFFFFFFFFFFFFFL);
        EventMessage.SCTE35_FORMAT = Format.createSampleFormat(null, "application/x-scte35", 0x7FFFFFFFFFFFFFFFL);
        EventMessage.CREATOR = new Parcelable.Creator() {
            public EventMessage createFromParcel(Parcel parcel0) {
                return new EventMessage(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public EventMessage[] newArray(int v) {
                return new EventMessage[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public EventMessage(Parcel parcel0) {
        this.schemeIdUri = (String)Util.castNonNull(parcel0.readString());
        this.value = (String)Util.castNonNull(parcel0.readString());
        this.durationMs = parcel0.readLong();
        this.id = parcel0.readLong();
        this.messageData = (byte[])Util.castNonNull(parcel0.createByteArray());
    }

    public EventMessage(String s, String s1, long v, long v1, byte[] arr_b) {
        this.schemeIdUri = s;
        this.value = s1;
        this.durationMs = v;
        this.id = v1;
        this.messageData = arr_b;
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
            return EventMessage.class == class0 && this.durationMs == ((EventMessage)object0).durationMs && this.id == ((EventMessage)object0).id && Util.areEqual(this.schemeIdUri, ((EventMessage)object0).schemeIdUri) && Util.areEqual(this.value, ((EventMessage)object0).value) && Arrays.equals(this.messageData, ((EventMessage)object0).messageData);
        }
        return false;
    }

    @Override  // com.google.android.exoplayer2.metadata.Metadata$Entry
    public byte[] getWrappedMetadataBytes() {
        return this.getWrappedMetadataFormat() == null ? null : this.messageData;
    }

    @Override  // com.google.android.exoplayer2.metadata.Metadata$Entry
    public Format getWrappedMetadataFormat() {
        this.schemeIdUri.getClass();
        switch(this.schemeIdUri) {
            case "https://aomedia.org/emsg/ID3": {
                return EventMessage.ID3_FORMAT;
            }
            case "https://developer.apple.com/streaming/emsg-id3": {
                return EventMessage.ID3_FORMAT;
            }
            case "urn:scte:scte35:2014:bin": {
                return EventMessage.SCTE35_FORMAT;
            }
            default: {
                return null;
            }
        }
    }

    @Override
    public int hashCode() {
        if(this.hashCode == 0) {
            int v = 0;
            int v1 = this.schemeIdUri == null ? 0 : this.schemeIdUri.hashCode();
            String s = this.value;
            if(s != null) {
                v = s.hashCode();
            }
            this.hashCode = Arrays.hashCode(this.messageData) + ((((v1 + 0x20F) * 0x1F + v) * 0x1F + ((int)(this.durationMs ^ this.durationMs >>> 0x20))) * 0x1F + ((int)(this.id ^ this.id >>> 0x20))) * 0x1F;
        }
        return this.hashCode;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder(Z.e(Z.e(0x4F, this.schemeIdUri), this.value));
        stringBuilder0.append("EMSG: scheme=");
        stringBuilder0.append(this.schemeIdUri);
        stringBuilder0.append(", id=");
        stringBuilder0.append(this.id);
        a.s(this.durationMs, ", durationMs=", ", value=", stringBuilder0);
        stringBuilder0.append(this.value);
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.schemeIdUri);
        parcel0.writeString(this.value);
        parcel0.writeLong(this.durationMs);
        parcel0.writeLong(this.id);
        parcel0.writeByteArray(this.messageData);
    }
}

