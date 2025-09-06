package androidx.media3.extractor.metadata.id3;

import I6.V;
import I6.p0;
import P3.d;
import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.media3.common.c;
import e3.b;
import java.util.ArrayList;
import java.util.Objects;
import y.a;

public final class TextInformationFrame extends Id3Frame {
    public static final Parcelable.Creator CREATOR;
    public final String b;
    public final V c;

    static {
        TextInformationFrame.CREATOR = new a(21);
    }

    public TextInformationFrame(String s, String s1, p0 p00) {
        super(s);
        b.c(!p00.isEmpty());
        this.b = s1;
        V v0 = V.p(p00);
        this.c = v0;
        String s2 = (String)v0.get(0);
    }

    @Override  // androidx.media3.common.Metadata$Entry
    public final void M(c c0) {
        int v;
        this.a.getClass();
        switch(this.a) {
            case "TAL": {
                v = 0;
                break;
            }
            case "TALB": {
                v = 10;
                break;
            }
            case "TCM": {
                v = 1;
                break;
            }
            case "TCOM": {
                v = 11;
                break;
            }
            case "TCON": {
                v = 12;
                break;
            }
            case "TDA": {
                v = 2;
                break;
            }
            case "TDAT": {
                v = 13;
                break;
            }
            case "TDRC": {
                v = 14;
                break;
            }
            case "TDRL": {
                v = 15;
                break;
            }
            case "TEXT": {
                v = 16;
                break;
            }
            case "TIT2": {
                v = 17;
                break;
            }
            case "TP1": {
                v = 3;
                break;
            }
            case "TP2": {
                v = 4;
                break;
            }
            case "TP3": {
                v = 5;
                break;
            }
            case "TPE1": {
                v = 18;
                break;
            }
            case "TPE2": {
                v = 19;
                break;
            }
            case "TPE3": {
                v = 20;
                break;
            }
            case "TRCK": {
                v = 21;
                break;
            }
            case "TRK": {
                v = 6;
                break;
            }
            case "TT2": {
                v = 7;
                break;
            }
            case "TXT": {
                v = 8;
                break;
            }
            case "TYE": {
                v = 9;
                break;
            }
            case "TYER": {
                v = 22;
                break;
            }
            default: {
                v = -1;
            }
        }
        V v1 = this.c;
        switch(v) {
            case 0: 
            case 10: {
                c0.c = (CharSequence)v1.get(0);
                return;
            }
            case 1: 
            case 11: {
                c0.z = (CharSequence)v1.get(0);
                return;
            }
            case 12: {
                Integer integer1 = ye.a.c0(((String)v1.get(0)));
                if(integer1 == null) {
                    c0.D = (CharSequence)v1.get(0);
                    return;
                }
                String s1 = d.a(((int)integer1));
                if(s1 != null) {
                    c0.D = s1;
                    return;
                }
                return;
            }
            case 2: 
            case 13: {
                try {
                    String s = (String)v1.get(0);
                    int v2 = Integer.parseInt(s.substring(2, 4));
                    int v3 = Integer.parseInt(s.substring(0, 2));
                    c0.t = v2;
                    c0.u = v3;
                }
                catch(NumberFormatException | StringIndexOutOfBoundsException unused_ex) {
                }
                return;
            }
            case 14: {
                ArrayList arrayList0 = TextInformationFrame.a(((String)v1.get(0)));
                switch(arrayList0.size()) {
                    case 1: {
                        break;
                    }
                    case 2: {
                        c0.t = (Integer)arrayList0.get(1);
                        break;
                    }
                    case 3: {
                        c0.u = (Integer)arrayList0.get(2);
                        c0.t = (Integer)arrayList0.get(1);
                        break;
                    }
                    default: {
                        return;
                    }
                }
                c0.s = (Integer)arrayList0.get(0);
                return;
            }
            case 15: {
                ArrayList arrayList1 = TextInformationFrame.a(((String)v1.get(0)));
                switch(arrayList1.size()) {
                    case 1: {
                        break;
                    }
                    case 2: {
                        c0.w = (Integer)arrayList1.get(1);
                        break;
                    }
                    case 3: {
                        c0.x = (Integer)arrayList1.get(2);
                        c0.w = (Integer)arrayList1.get(1);
                        break;
                    }
                    default: {
                        return;
                    }
                }
                c0.v = (Integer)arrayList1.get(0);
                return;
            }
            case 8: 
            case 16: {
                c0.y = (CharSequence)v1.get(0);
                return;
            }
            case 7: 
            case 17: {
                c0.a = (CharSequence)v1.get(0);
                return;
            }
            case 3: 
            case 18: {
                c0.b = (CharSequence)v1.get(0);
                return;
            }
            case 4: 
            case 19: {
                c0.d = (CharSequence)v1.get(0);
                return;
            }
            case 5: 
            case 20: {
                c0.A = (CharSequence)v1.get(0);
                return;
            }
            case 6: 
            case 21: {
                String[] arr_s = ((String)v1.get(0)).split("/", -1);
                try {
                    int v4 = Integer.parseInt(arr_s[0]);
                    Integer integer0 = arr_s.length <= 1 ? null : Integer.parseInt(arr_s[1]);
                    c0.n = v4;
                    c0.o = integer0;
                }
                catch(NumberFormatException unused_ex) {
                }
                return;
            }
            case 9: 
            case 22: {
                try {
                    c0.s = Integer.parseInt(((String)v1.get(0)));
                }
                catch(NumberFormatException unused_ex) {
                }
            }
        }
    }

    public static ArrayList a(String s) {
        ArrayList arrayList0 = new ArrayList();
        try {
            if(s.length() >= 10) {
                arrayList0.add(Integer.parseInt(s.substring(0, 4)));
                arrayList0.add(Integer.parseInt(s.substring(5, 7)));
                arrayList0.add(Integer.parseInt(s.substring(8, 10)));
                return arrayList0;
            }
            if(s.length() >= 7) {
                arrayList0.add(Integer.parseInt(s.substring(0, 4)));
                arrayList0.add(Integer.parseInt(s.substring(5, 7)));
                return arrayList0;
            }
            if(s.length() >= 4) {
                arrayList0.add(Integer.parseInt(s.substring(0, 4)));
            }
            return arrayList0;
        }
        catch(NumberFormatException unused_ex) {
            return new ArrayList();
        }
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return TextInformationFrame.class == class0 && Objects.equals(this.a, ((TextInformationFrame)object0).a) && Objects.equals(this.b, ((TextInformationFrame)object0).b) && this.c.equals(((TextInformationFrame)object0).c);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = x.b(0x20F, 0x1F, this.a);
        return this.b == null ? this.c.hashCode() + v * 0x1F : this.c.hashCode() + (v + this.b.hashCode()) * 0x1F;
    }

    @Override  // androidx.media3.extractor.metadata.id3.Id3Frame
    public final String toString() {
        return this.a + ": description=" + this.b + ": values=" + this.c;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeStringArray(((String[])this.c.toArray(new String[0])));
    }
}

