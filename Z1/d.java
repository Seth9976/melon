package Z1;

import android.util.Base64;
import java.util.List;

public final class d {
    public final String a;
    public final String b;
    public final String c;
    public final List d;
    public final String e;

    public d(String s, String s1, String s2, List list0) {
        s.getClass();
        this.a = s;
        s1.getClass();
        this.b = s1;
        this.c = s2;
        list0.getClass();
        this.d = list0;
        this.e = s + "-" + s1 + "-" + s2;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("FontRequest {mProviderAuthority: " + this.a + ", mProviderPackage: " + this.b + ", mQuery: " + this.c + ", mCertificates:");
        for(int v = 0; true; ++v) {
            List list0 = this.d;
            if(v >= list0.size()) {
                break;
            }
            stringBuilder0.append(" [");
            List list1 = (List)list0.get(v);
            for(int v1 = 0; v1 < list1.size(); ++v1) {
                stringBuilder0.append(" \"");
                stringBuilder0.append(Base64.encodeToString(((byte[])list1.get(v1)), 0));
                stringBuilder0.append("\"");
            }
            stringBuilder0.append(" ]");
        }
        stringBuilder0.append("}mCertificatesArray: 0");
        return stringBuilder0.toString();
    }
}

