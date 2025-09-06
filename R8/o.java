package R8;

import A7.d;
import U4.x;
import android.net.Uri;

public final class o {
    public Uri a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public int g;
    public int h;
    public int i;
    public int j;
    public long k;

    @Override
    public final String toString() {
        Uri uri0 = this.a;
        String s = this.b;
        String s1 = this.c;
        String s2 = this.d;
        String s3 = this.e;
        String s4 = this.f;
        int v = this.g;
        int v1 = this.h;
        int v2 = this.i;
        int v3 = this.j;
        long v4 = this.k;
        StringBuilder stringBuilder0 = new StringBuilder("DcfMeta {path=null, uri=");
        stringBuilder0.append(uri0);
        stringBuilder0.append(", title=");
        stringBuilder0.append(s);
        stringBuilder0.append(", artist=");
        d.u(stringBuilder0, s1, ", album=", s2, ", composer=null, genre=");
        d.u(stringBuilder0, s3, ", mimeType=", s4, ", fileType=");
        x.x(stringBuilder0, v, ", track=", v1, ", year=");
        x.x(stringBuilder0, v2, ", duration=", v3, ", lastModified=0, fileSize=");
        return x.h(v4, "}", stringBuilder0);
    }
}

