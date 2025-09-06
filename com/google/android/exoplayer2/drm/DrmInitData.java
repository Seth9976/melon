package com.google.android.exoplayer2.drm;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class DrmInitData implements Parcelable, Comparator {
    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator CREATOR;
        public final byte[] data;
        private int hashCode;
        public final String licenseServerUrl;
        public final String mimeType;
        private final UUID uuid;

        static {
            SchemeData.CREATOR = new Parcelable.Creator() {
                public SchemeData createFromParcel(Parcel parcel0) {
                    return new SchemeData(parcel0);
                }

                @Override  // android.os.Parcelable$Creator
                public Object createFromParcel(Parcel parcel0) {
                    return this.createFromParcel(parcel0);
                }

                public SchemeData[] newArray(int v) {
                    return new SchemeData[v];
                }

                @Override  // android.os.Parcelable$Creator
                public Object[] newArray(int v) {
                    return this.newArray(v);
                }
            };
        }

        public SchemeData(Parcel parcel0) {
            this.uuid = new UUID(parcel0.readLong(), parcel0.readLong());
            this.licenseServerUrl = parcel0.readString();
            this.mimeType = (String)Util.castNonNull(parcel0.readString());
            this.data = parcel0.createByteArray();
        }

        public SchemeData(UUID uUID0, String s, String s1, byte[] arr_b) {
            this.uuid = (UUID)Assertions.checkNotNull(uUID0);
            this.licenseServerUrl = s;
            this.mimeType = (String)Assertions.checkNotNull(s1);
            this.data = arr_b;
        }

        public SchemeData(UUID uUID0, String s, byte[] arr_b) {
            this(uUID0, null, s, arr_b);
        }

        // 去混淆评级： 低(30)
        public boolean canReplace(SchemeData drmInitData$SchemeData0) {
            return this.hasData() && !drmInitData$SchemeData0.hasData() && this.matches(drmInitData$SchemeData0.uuid);
        }

        public SchemeData copyWithData(byte[] arr_b) {
            return new SchemeData(this.uuid, this.licenseServerUrl, this.mimeType, arr_b);
        }

        @Override  // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(Object object0) {
            if(!(object0 instanceof SchemeData)) {
                return false;
            }
            return object0 == this ? true : Util.areEqual(this.licenseServerUrl, ((SchemeData)object0).licenseServerUrl) && Util.areEqual(this.mimeType, ((SchemeData)object0).mimeType) && Util.areEqual(this.uuid, ((SchemeData)object0).uuid) && Arrays.equals(this.data, ((SchemeData)object0).data);
        }

        public boolean hasData() {
            return this.data != null;
        }

        @Override
        public int hashCode() {
            if(this.hashCode == 0) {
                this.hashCode = Arrays.hashCode(this.data) + x.b((this.uuid.hashCode() * 0x1F + (this.licenseServerUrl == null ? 0 : this.licenseServerUrl.hashCode())) * 0x1F, 0x1F, this.mimeType);
            }
            return this.hashCode;
        }

        // 去混淆评级： 低(20)
        public boolean matches(UUID uUID0) {
            return C.UUID_NIL.equals(this.uuid) || uUID0.equals(this.uuid);
        }

        @Override  // android.os.Parcelable
        public void writeToParcel(Parcel parcel0, int v) {
            parcel0.writeLong(this.uuid.getMostSignificantBits());
            parcel0.writeLong(this.uuid.getLeastSignificantBits());
            parcel0.writeString(this.licenseServerUrl);
            parcel0.writeString(this.mimeType);
            parcel0.writeByteArray(this.data);
        }
    }

    public static final Parcelable.Creator CREATOR;
    private int hashCode;
    public final int schemeDataCount;
    private final SchemeData[] schemeDatas;
    public final String schemeType;

    static {
        DrmInitData.CREATOR = new Parcelable.Creator() {
            public DrmInitData createFromParcel(Parcel parcel0) {
                return new DrmInitData(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public DrmInitData[] newArray(int v) {
                return new DrmInitData[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public DrmInitData(Parcel parcel0) {
        this.schemeType = parcel0.readString();
        SchemeData[] arr_drmInitData$SchemeData = (SchemeData[])Util.castNonNull(((SchemeData[])parcel0.createTypedArray(SchemeData.CREATOR)));
        this.schemeDatas = arr_drmInitData$SchemeData;
        this.schemeDataCount = arr_drmInitData$SchemeData.length;
    }

    public DrmInitData(String s, List list0) {
        this(s, false, ((SchemeData[])list0.toArray(new SchemeData[0])));
    }

    private DrmInitData(String s, boolean z, SchemeData[] arr_drmInitData$SchemeData) {
        this.schemeType = s;
        if(z) {
            arr_drmInitData$SchemeData = (SchemeData[])arr_drmInitData$SchemeData.clone();
        }
        this.schemeDatas = arr_drmInitData$SchemeData;
        this.schemeDataCount = arr_drmInitData$SchemeData.length;
        Arrays.sort(arr_drmInitData$SchemeData, this);
    }

    public DrmInitData(String s, SchemeData[] arr_drmInitData$SchemeData) {
        this(s, true, arr_drmInitData$SchemeData);
    }

    public DrmInitData(List list0) {
        this(null, false, ((SchemeData[])list0.toArray(new SchemeData[0])));
    }

    public DrmInitData(SchemeData[] arr_drmInitData$SchemeData) {
        this(null, arr_drmInitData$SchemeData);
    }

    public int compare(SchemeData drmInitData$SchemeData0, SchemeData drmInitData$SchemeData1) {
        UUID uUID0 = C.UUID_NIL;
        if(uUID0.equals(SchemeData.access$000(drmInitData$SchemeData0))) {
            return uUID0.equals(SchemeData.access$000(drmInitData$SchemeData1)) ? 0 : 1;
        }
        return SchemeData.access$000(drmInitData$SchemeData0).compareTo(SchemeData.access$000(drmInitData$SchemeData1));
    }

    @Override
    public int compare(Object object0, Object object1) {
        return this.compare(((SchemeData)object0), ((SchemeData)object1));
    }

    private static boolean containsSchemeDataWithUuid(ArrayList arrayList0, int v, UUID uUID0) {
        for(int v1 = 0; v1 < v; ++v1) {
            if(SchemeData.access$000(((SchemeData)arrayList0.get(v1))).equals(uUID0)) {
                return true;
            }
        }
        return false;
    }

    // 去混淆评级： 低(20)
    public DrmInitData copyWithSchemeType(String s) {
        return Util.areEqual(this.schemeType, s) ? this : new DrmInitData(s, false, this.schemeDatas);
    }

    public static DrmInitData createSessionCreationData(DrmInitData drmInitData0, DrmInitData drmInitData1) {
        String s;
        ArrayList arrayList0 = new ArrayList();
        if(drmInitData0 == null) {
            s = null;
        }
        else {
            s = drmInitData0.schemeType;
            SchemeData[] arr_drmInitData$SchemeData = drmInitData0.schemeDatas;
            for(int v1 = 0; v1 < arr_drmInitData$SchemeData.length; ++v1) {
                SchemeData drmInitData$SchemeData0 = arr_drmInitData$SchemeData[v1];
                if(drmInitData$SchemeData0.hasData()) {
                    arrayList0.add(drmInitData$SchemeData0);
                }
            }
        }
        if(drmInitData1 != null) {
            if(s == null) {
                s = drmInitData1.schemeType;
            }
            int v2 = arrayList0.size();
            SchemeData[] arr_drmInitData$SchemeData1 = drmInitData1.schemeDatas;
            for(int v = 0; v < arr_drmInitData$SchemeData1.length; ++v) {
                SchemeData drmInitData$SchemeData1 = arr_drmInitData$SchemeData1[v];
                if(drmInitData$SchemeData1.hasData() && !DrmInitData.containsSchemeDataWithUuid(arrayList0, v2, drmInitData$SchemeData1.uuid)) {
                    arrayList0.add(drmInitData$SchemeData1);
                }
            }
        }
        return arrayList0.isEmpty() ? null : new DrmInitData(s, arrayList0);
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
            return DrmInitData.class == class0 && Util.areEqual(this.schemeType, ((DrmInitData)object0).schemeType) && Arrays.equals(this.schemeDatas, ((DrmInitData)object0).schemeDatas);
        }
        return false;
    }

    public SchemeData get(int v) {
        return this.schemeDatas[v];
    }

    @Deprecated
    public SchemeData get(UUID uUID0) {
        SchemeData[] arr_drmInitData$SchemeData = this.schemeDatas;
        for(int v = 0; v < arr_drmInitData$SchemeData.length; ++v) {
            SchemeData drmInitData$SchemeData0 = arr_drmInitData$SchemeData[v];
            if(drmInitData$SchemeData0.matches(uUID0)) {
                return drmInitData$SchemeData0;
            }
        }
        return null;
    }

    @Override
    public int hashCode() {
        if(this.hashCode == 0) {
            this.hashCode = (this.schemeType == null ? 0 : this.schemeType.hashCode()) * 0x1F + Arrays.hashCode(this.schemeDatas);
        }
        return this.hashCode;
    }

    public DrmInitData merge(DrmInitData drmInitData0) {
        Assertions.checkState(this.schemeType == null || (drmInitData0.schemeType == null || TextUtils.equals(this.schemeType, drmInitData0.schemeType)));
        return new DrmInitData((this.schemeType == null ? drmInitData0.schemeType : this.schemeType), ((SchemeData[])Util.nullSafeArrayConcatenation(this.schemeDatas, drmInitData0.schemeDatas)));
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.schemeType);
        parcel0.writeTypedArray(this.schemeDatas, 0);
    }
}

