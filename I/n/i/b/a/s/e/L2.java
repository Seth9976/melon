package i.n.i.b.a.s.e;

import H0.b;
import android.util.Base64;
import androidx.media3.session.legacy.p;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;

public final class l2 extends p {
    public boolean e;
    public UUID f;
    public byte[] g;

    @Override  // androidx.media3.session.legacy.p
    public final Object c(Gd gd0) {
        UUID uUID0 = this.f;
        byte[] arr_b = Ja.J(uUID0, null, this.g);
        byte[] arr_b1 = this.g;
        StringBuilder stringBuilder0 = new StringBuilder();
        for(int v = 0; v < arr_b1.length; v += 2) {
            stringBuilder0.append(((char)arr_b1[v]));
        }
        String s = stringBuilder0.toString();
        byte[] arr_b2 = Base64.decode(s.substring(s.indexOf("<KID>") + 5, s.indexOf("</KID>")), 0);
        byte b = arr_b2[0];
        arr_b2[0] = arr_b2[3];
        arr_b2[3] = b;
        byte b1 = arr_b2[1];
        arr_b2[1] = arr_b2[2];
        arr_b2[2] = b1;
        byte b2 = arr_b2[4];
        arr_b2[4] = arr_b2[5];
        arr_b2[5] = b2;
        byte b3 = arr_b2[6];
        arr_b2[6] = arr_b2[7];
        arr_b2[7] = b3;
        return new s1(uUID0, arr_b, new a7[]{new a7(true, null, 8, arr_b2, 0, 0, null)});
    }

    @Override  // androidx.media3.session.legacy.p
    public final void g(XmlPullParser xmlPullParser0) {
        if("ProtectionHeader".equals(xmlPullParser0.getName())) {
            this.e = false;
        }
    }

    @Override  // androidx.media3.session.legacy.p
    public final void i(XmlPullParser xmlPullParser0) {
        if("ProtectionHeader".equals(xmlPullParser0.getName())) {
            this.e = true;
            String s = xmlPullParser0.getAttributeValue(null, "SystemID");
            if(s.charAt(0) == 0x7B && s.charAt(s.length() - 1) == 0x7D) {
                s = b.d(1, 1, s);
            }
            this.f = UUID.fromString(s);
        }
    }

    @Override  // androidx.media3.session.legacy.p
    public final boolean j(String s) {
        return "ProtectionHeader".equals(s);
    }

    @Override  // androidx.media3.session.legacy.p
    public final void k(XmlPullParser xmlPullParser0) {
        if(this.e) {
            this.g = Base64.decode(xmlPullParser0.getText(), 0);
        }
    }
}

