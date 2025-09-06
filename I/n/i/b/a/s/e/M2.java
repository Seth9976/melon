package i.n.i.b.a.s.e;

import android.text.TextUtils;
import androidx.media3.session.legacy.p;
import com.iloen.melon.utils.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public final class m2 extends p {
    public u e;

    @Override  // androidx.media3.session.legacy.p
    public final Object c(Gd gd0) {
        return this.e;
    }

    @Override  // androidx.media3.session.legacy.p
    public final void i(XmlPullParser xmlPullParser0) {
        String s1;
        ob ob0 = new ob();
        String s = xmlPullParser0.getAttributeValue(null, "FourCC");
        if(s == null) {
            throw new k2("FourCC");
        }
        if(s.equalsIgnoreCase("H264") || s.equalsIgnoreCase("X264") || s.equalsIgnoreCase("AVC1") || s.equalsIgnoreCase("DAVC")) {
            s1 = "video/avc";
        }
        else if(s.equalsIgnoreCase("AAC") || s.equalsIgnoreCase("AACL") || s.equalsIgnoreCase("AACH") || s.equalsIgnoreCase("AACP")) {
            s1 = "audio/mp4a-latm";
        }
        else if(s.equalsIgnoreCase("TTML") || s.equalsIgnoreCase("DFXP")) {
            s1 = "application/ttml+xml";
        }
        else if(s.equalsIgnoreCase("ac-3") || s.equalsIgnoreCase("dac3")) {
            s1 = "audio/ac3";
        }
        else if(s.equalsIgnoreCase("ec-3") || s.equalsIgnoreCase("dec3")) {
            s1 = "audio/eac3";
        }
        else if(s.equalsIgnoreCase("dtsc")) {
            s1 = "audio/vnd.dts";
        }
        else if(s.equalsIgnoreCase("dtsh") || s.equalsIgnoreCase("dtsl")) {
            s1 = "audio/vnd.dts.hd";
        }
        else if(s.equalsIgnoreCase("dtse")) {
            s1 = "audio/vnd.dts.hd;profile=lbr";
        }
        else if(s.equalsIgnoreCase("opus")) {
            s1 = "audio/opus";
        }
        else {
            s1 = null;
        }
        int v = 0;
        int v1 = (int)(((Integer)this.d("Type")));
        if(v1 == 2) {
            ArrayList arrayList0 = m2.o(xmlPullParser0.getAttributeValue(null, "CodecPrivateData"));
            ob0.j = "video/mp4";
            ob0.p = p.h(xmlPullParser0, "MaxWidth");
            ob0.q = p.h(xmlPullParser0, "MaxHeight");
            ob0.m = arrayList0;
        }
        else {
            switch(v1) {
                case 1: {
                    if(s1 == null) {
                        s1 = "audio/mp4a-latm";
                    }
                    int v2 = p.h(xmlPullParser0, "Channels");
                    int v3 = p.h(xmlPullParser0, "SamplingRate");
                    List list0 = m2.o(xmlPullParser0.getAttributeValue(null, "CodecPrivateData"));
                    if(((ArrayList)list0).isEmpty() && "audio/mp4a-latm".equals(s1)) {
                        int v4 = -1;
                        for(int v5 = 0; true; ++v5) {
                            int[] arr_v = Ja.c;
                            if(v5 >= 13) {
                                break;
                            }
                            if(v3 == arr_v[v5]) {
                                v4 = v5;
                            }
                        }
                        int v6 = -1;
                        while(true) {
                            int[] arr_v1 = Ja.d;
                            if(v >= 16) {
                                break;
                            }
                            if(v2 == arr_v1[v]) {
                                v6 = v;
                            }
                            ++v;
                        }
                        if(v3 == -1 || v6 == -1) {
                            throw new IllegalArgumentException("Invalid sample rate or number of channels: " + v3 + ", " + v2);
                        }
                        list0 = Collections.singletonList(Ja.H(2, v4, v6));
                    }
                    ob0.j = "audio/mp4";
                    ob0.x = v2;
                    ob0.y = v3;
                    ob0.m = list0;
                    break;
                }
                case 3: {
                    String s2 = (String)this.d("Subtype");
                    if(s2 != null) {
                        switch(s2) {
                            case "CAPT": {
                                v = 0x40;
                                break;
                            }
                            case "DESC": {
                                v = 0x400;
                            }
                        }
                    }
                    ob0.j = "application/mp4";
                    ob0.e = v;
                    break;
                }
                default: {
                    ob0.j = "application/mp4";
                }
            }
        }
        ob0.a = xmlPullParser0.getAttributeValue(null, "Index");
        ob0.b = (String)this.d("Name");
        ob0.k = s1;
        ob0.f = p.h(xmlPullParser0, "Bitrate");
        ob0.c = (String)this.d("Language");
        this.e = new u(ob0);
    }

    public static ArrayList o(String s) {
        Object[] arr_object;
        byte[] arr_b = Ja.a;
        ArrayList arrayList0 = new ArrayList();
        if(!TextUtils.isEmpty(s)) {
            int v = s.length();
            byte[] arr_b1 = new byte[v / 2];
            for(int v1 = 0; v1 < v / 2; ++v1) {
                arr_b1[v1] = (byte)(Character.digit(s.charAt(v1 * 2 + 1), 16) + (Character.digit(s.charAt(v1 * 2), 16) << 4));
            }
            if(v / 2 > 4) {
                int v2 = 0;
                while(v2 < 4) {
                    if(arr_b1[v2] != arr_b[v2]) {
                        goto label_44;
                    }
                    ++v2;
                }
                ArrayList arrayList1 = new ArrayList();
                int v3 = 0;
                do {
                alab1:
                    for(v3 = a.d(v3, v3, 4, arrayList1); true; ++v3) {
                        if(v3 > v / 2 - 4) {
                            v3 = -1;
                            break;
                        }
                        if(v / 2 - v3 > 4) {
                            int v4 = 0;
                            while(v4 < 4) {
                                if(arr_b1[v3 + v4] != arr_b[v4]) {
                                    continue alab1;
                                }
                                ++v4;
                            }
                            break;
                        }
                    }
                }
                while(v3 != -1);
                byte[][] arr2_b = new byte[arrayList1.size()][];
                for(int v5 = 0; v5 < arrayList1.size(); ++v5) {
                    int v6 = (int)(((Integer)arrayList1.get(v5)));
                    int v7 = (v5 >= arrayList1.size() - 1 ? v / 2 : ((int)(((Integer)arrayList1.get(v5 + 1))))) - v6;
                    byte[] arr_b2 = new byte[v7];
                    System.arraycopy(arr_b1, v6, arr_b2, 0, v7);
                    arr2_b[v5] = arr_b2;
                }
                arr_object = arr2_b;
            }
            else {
            label_44:
                arr_object = null;
            }
            if(arr_object == null) {
                arrayList0.add(arr_b1);
                return arrayList0;
            }
            Collections.addAll(arrayList0, arr_object);
        }
        return arrayList0;
    }
}

