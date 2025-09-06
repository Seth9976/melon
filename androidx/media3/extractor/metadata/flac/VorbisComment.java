package androidx.media3.extractor.metadata.flac;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.media3.common.Metadata.Entry;
import androidx.media3.common.c;
import h7.u0;
import y.a;

@Deprecated
public class VorbisComment implements Entry {
    public static final Parcelable.Creator CREATOR;
    public final String a;
    public final String b;

    static {
        VorbisComment.CREATOR = new a(9);
    }

    public VorbisComment(Parcel parcel0) {
        this.a = parcel0.readString();
        this.b = parcel0.readString();
    }

    public VorbisComment(String s, String s1) {
        this.a = u0.V(s);
        this.b = s1;
    }

    @Override  // androidx.media3.common.Metadata$Entry
    public final void M(c c0) {
        this.a.getClass();
        int v = -1;
        switch(this.a) {
            case "ALBUM": {
                v = 3;
                break;
            }
            case "ALBUMARTIST": {
                v = 8;
                break;
            }
            case "ARTIST": {
                v = 9;
                break;
            }
            case "DESCRIPTION": {
                v = 6;
                break;
            }
            case "DISCNUMBER": {
                v = 7;
                break;
            }
            case "GENRE": {
                v = 4;
                break;
            }
            case "TITLE": {
                v = 5;
                break;
            }
            case "TOTALDISCS": {
                v = 1;
                break;
            }
            case "TOTALTRACKS": {
                v = 0;
                break;
            }
            case "TRACKNUMBER": {
                v = 2;
            }
        }
        String s = this.b;
        switch(v) {
            case 0: {
                Integer integer0 = ye.a.c0(s);
                if(integer0 != null) {
                    c0.o = integer0;
                    return;
                }
                break;
            }
            case 1: {
                Integer integer1 = ye.a.c0(s);
                if(integer1 != null) {
                    c0.C = integer1;
                    return;
                }
                break;
            }
            case 2: {
                Integer integer2 = ye.a.c0(s);
                if(integer2 != null) {
                    c0.n = integer2;
                    return;
                }
                break;
            }
            case 3: {
                c0.c = s;
                return;
            }
            case 4: {
                c0.D = s;
                return;
            }
            case 5: {
                c0.a = s;
                return;
            }
            case 6: {
                c0.g = s;
                return;
            }
            case 7: {
                Integer integer3 = ye.a.c0(s);
                if(integer3 != null) {
                    c0.B = integer3;
                    return;
                }
                break;
            }
            case 8: {
                c0.d = s;
                return;
            }
            case 9: {
                c0.b = s;
            }
        }
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 != null && this.getClass() == object0.getClass() && this.a.equals(((VorbisComment)object0).a) && this.b.equals(((VorbisComment)object0).b);
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + x.b(0x20F, 0x1F, this.a);
    }

    @Override
    public final String toString() {
        return "VC: " + this.a + "=" + this.b;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
    }
}

