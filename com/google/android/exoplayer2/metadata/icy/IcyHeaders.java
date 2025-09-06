package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import b3.Z;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.List;
import java.util.Map;

public final class IcyHeaders implements Entry {
    public static final Parcelable.Creator CREATOR = null;
    public static final String REQUEST_HEADER_ENABLE_METADATA_NAME = "Icy-MetaData";
    public static final String REQUEST_HEADER_ENABLE_METADATA_VALUE = "1";
    private static final String RESPONSE_HEADER_BITRATE = "icy-br";
    private static final String RESPONSE_HEADER_GENRE = "icy-genre";
    private static final String RESPONSE_HEADER_METADATA_INTERVAL = "icy-metaint";
    private static final String RESPONSE_HEADER_NAME = "icy-name";
    private static final String RESPONSE_HEADER_PUB = "icy-pub";
    private static final String RESPONSE_HEADER_URL = "icy-url";
    private static final String TAG = "IcyHeaders";
    public final int bitrate;
    public final String genre;
    public final boolean isPublic;
    public final int metadataInterval;
    public final String name;
    public final String url;

    static {
        IcyHeaders.CREATOR = new Parcelable.Creator() {
            public IcyHeaders createFromParcel(Parcel parcel0) {
                return new IcyHeaders(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public IcyHeaders[] newArray(int v) {
                return new IcyHeaders[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public IcyHeaders(int v, String s, String s1, String s2, boolean z, int v1) {
        Assertions.checkArgument(v1 == -1 || v1 > 0);
        this.bitrate = v;
        this.genre = s;
        this.name = s1;
        this.url = s2;
        this.isPublic = z;
        this.metadataInterval = v1;
    }

    public IcyHeaders(Parcel parcel0) {
        this.bitrate = parcel0.readInt();
        this.genre = parcel0.readString();
        this.name = parcel0.readString();
        this.url = parcel0.readString();
        this.isPublic = Util.readBoolean(parcel0);
        this.metadataInterval = parcel0.readInt();
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
            return IcyHeaders.class == class0 && this.bitrate == ((IcyHeaders)object0).bitrate && Util.areEqual(this.genre, ((IcyHeaders)object0).genre) && Util.areEqual(this.name, ((IcyHeaders)object0).name) && Util.areEqual(this.url, ((IcyHeaders)object0).url) && this.isPublic == ((IcyHeaders)object0).isPublic && this.metadataInterval == ((IcyHeaders)object0).metadataInterval;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int v = (this.bitrate + 0x20F) * 0x1F;
        int v1 = 0;
        int v2 = this.genre == null ? 0 : this.genre.hashCode();
        int v3 = this.name == null ? 0 : this.name.hashCode();
        String s = this.url;
        if(s != null) {
            v1 = s.hashCode();
        }
        return ((((v + v2) * 0x1F + v3) * 0x1F + v1) * 0x1F + this.isPublic) * 0x1F + this.metadataInterval;
    }

    public static IcyHeaders parse(Map map0) {
        int v3;
        boolean z1;
        String s5;
        String s4;
        int v2;
        boolean z;
        int v1;
        List list0 = (List)map0.get("icy-br");
        int v = -1;
        if(list0 == null) {
            z = false;
            v2 = -1;
        }
        else {
            String s = (String)list0.get(0);
            try {
                v1 = -1;
                v1 = Integer.parseInt(s) * 1000;
                if(v1 <= 0) {
                    String s1 = String.valueOf(s);
                    Log.w("IcyHeaders", (s1.length() == 0 ? new String("Invalid bitrate: ") : "Invalid bitrate: " + s1));
                    z = false;
                    v1 = -1;
                }
                else {
                    z = true;
                }
            }
            catch(NumberFormatException unused_ex) {
                String s2 = String.valueOf(s);
                Log.w("IcyHeaders", (s2.length() == 0 ? new String("Invalid bitrate header: ") : "Invalid bitrate header: " + s2));
                z = false;
            }
            v2 = v1;
        }
        List list1 = (List)map0.get("icy-genre");
        String s3 = null;
        if(list1 != null) {
            s3 = (String)list1.get(0);
            z = true;
        }
        List list2 = (List)map0.get("icy-name");
        if(list2 == null) {
            s4 = null;
        }
        else {
            s4 = (String)list2.get(0);
            z = true;
        }
        List list3 = (List)map0.get("icy-url");
        if(list3 == null) {
            s5 = null;
        }
        else {
            s5 = (String)list3.get(0);
            z = true;
        }
        List list4 = (List)map0.get("icy-pub");
        if(list4 == null) {
            z1 = false;
        }
        else {
            z1 = ((String)list4.get(0)).equals("1");
            z = true;
        }
        List list5 = (List)map0.get("icy-metaint");
        if(list5 != null) {
            String s6 = (String)list5.get(0);
            try {
                v3 = Integer.parseInt(s6);
                if(v3 > 0) {
                    return new IcyHeaders(v2, s3, s4, s5, z1, v3);
                }
                goto label_50;
            }
            catch(NumberFormatException unused_ex) {
                goto label_54;
            }
            return new IcyHeaders(v2, s3, s4, s5, z1, v3);
            try {
            label_50:
                String s7 = String.valueOf(s6);
                Log.w("IcyHeaders", (s7.length() == 0 ? new String("Invalid metadata interval: ") : "Invalid metadata interval: " + s7));
                return z ? new IcyHeaders(v2, s3, s4, s5, z1, -1) : null;
            label_53:
                v = v3;
            }
            catch(NumberFormatException unused_ex) {
                goto label_53;
            }
        label_54:
            String s8 = String.valueOf(s6);
            Log.w("IcyHeaders", (s8.length() == 0 ? new String("Invalid metadata interval: ") : "Invalid metadata interval: " + s8));
            return z ? new IcyHeaders(v2, s3, s4, s5, z1, v) : null;
        }
        return z ? new IcyHeaders(v2, s3, s4, s5, z1, -1) : null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = Z.o(Z.e(Z.e(80, this.name), this.genre), "IcyHeaders: name=\"", this.name, "\", genre=\"", this.genre);
        stringBuilder0.append("\", bitrate=");
        stringBuilder0.append(this.bitrate);
        stringBuilder0.append(", metadataInterval=");
        stringBuilder0.append(this.metadataInterval);
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.bitrate);
        parcel0.writeString(this.genre);
        parcel0.writeString(this.name);
        parcel0.writeString(this.url);
        Util.writeBoolean(parcel0, this.isPublic);
        parcel0.writeInt(this.metadataInterval);
    }
}

