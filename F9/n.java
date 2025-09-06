package f9;

import android.net.Uri;
import android.text.TextUtils;
import com.iloen.melon.mcache.error.ParseError.NeedParse;
import com.iloen.melon.mcache.error.ParseError;
import com.iloen.melon.utils.a;
import h9.f;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import java.io.Closeable;

public final class n implements Closeable {
    public String B;
    public String D;
    public final CompositeByteBuf a;
    public StringBuilder b;
    public StringBuilder c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public int l;
    public String m;
    public long n;
    public boolean o;
    public long r;
    public boolean w;

    public n() {
        this.a = Unpooled.compositeBuffer();
        this.b = null;
        this.c = null;
        this.d = null;
        this.k = null;
        this.l = 80;
        this.m = null;
        this.n = 0L;
        this.o = false;
        this.r = -1L;
        this.w = false;
        this.B = null;
        this.D = "";
    }

    public final String A() {
        if(this.F()) {
            throw new NeedParse("ClientRequest", "getC() - Please parsing.");
        }
        return this.m;
    }

    public final String B() {
        byte[] arr_b = this.a.array();
        return arr_b == null || arr_b.length == 0 ? "No Data." : new String(arr_b).trim();
    }

    public final String C() {
        if(this.F()) {
            throw new NeedParse("ClientRequest", "host() - Please parsing.");
        }
        return this.k;
    }

    public final String E() {
        if(this.F()) {
            throw new NeedParse("ClientRequest", "metaType() - Please parsing.");
        }
        return this.j;
    }

    public final boolean F() {
        return this.b == null;
    }

    public final int G() {
        if(this.F()) {
            throw new NeedParse("ClientRequest", "port() - Please parsing.");
        }
        return this.l;
    }

    @Override
    public final void close() {
        if(this.F()) {
            this.a.release();
        }
    }

    public final String h() {
        if(this.F()) {
            throw new NeedParse("ClientRequest", "bitrate() - Please parsing.");
        }
        return this.i;
    }

    // 去混淆评级： 低(20)
    public static String i(String s) {
        return TextUtils.isEmpty(s) || !s.contains("amp;") ? s : s.replaceAll("amp;", "");
    }

    public final void j(long v) {
        this.n = v;
    }

    public final void l(Uri uri0, long v, String s) {
        try {
            this.m(uri0.toString());
        }
        catch(ParseError parseError0) {
            throw new ParseError("ClientRequest", "Can\'t parse - " + parseError0.toString());
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        this.b = stringBuilder0;
        stringBuilder0.append("GET ");
        this.b.append(uri0.getPath());
        StringBuilder stringBuilder1 = this.b;
        stringBuilder1.append("?q=");
        stringBuilder1.append(uri0.getQueryParameter("q"));
        if(uri0.getQueryParameter("gck") != null) {
            StringBuilder stringBuilder2 = this.b;
            stringBuilder2.append("&gck=");
            stringBuilder2.append(uri0.getQueryParameter("gck"));
        }
        StringBuilder stringBuilder3 = this.b;
        stringBuilder3.append("&cid=");
        stringBuilder3.append(this.d);
        StringBuilder stringBuilder4 = this.b;
        stringBuilder4.append("&cacheEnable=");
        stringBuilder4.append(this.e);
        StringBuilder stringBuilder5 = this.b;
        stringBuilder5.append("&isLocal=");
        stringBuilder5.append(this.f);
        StringBuilder stringBuilder6 = this.b;
        stringBuilder6.append("&bitrate=");
        stringBuilder6.append(this.i);
        StringBuilder stringBuilder7 = this.b;
        stringBuilder7.append("&metaType=");
        stringBuilder7.append(this.j);
        this.b.append(" HTTP/1.1");
        this.b.append("\r\n");
        StringBuilder stringBuilder8 = this.b;
        stringBuilder8.append("User-Agent: ");
        stringBuilder8.append(s);
        this.b.append("\r\n");
        StringBuilder stringBuilder9 = this.b;
        stringBuilder9.append("Host: ");
        stringBuilder9.append(this.k);
        this.b.append("\r\n");
        this.b.append("Connection: Keep-Alive");
        this.b.append("\r\n");
        if(v > 0L) {
            this.n = v;
            this.o = true;
            return;
        }
        this.n = 0L;
        this.o = false;
    }

    public final void m(String s) {
        int v10;
        StringBuilder stringBuilder0 = new StringBuilder(s);
        boolean z = true;
        if(s.startsWith("GET")) {
            this.w = true;
        }
        int v = s.lastIndexOf("&cid=");
        if(v >= 0) {
            this.d = s.substring(v + 5, (s.indexOf(38, v + 5) >= 0 ? s.indexOf(38, v + 5) : s.indexOf(0x20, v + 5)));
            int v1 = s.lastIndexOf("&isLocal=");
            if(v1 + 9 > 0) {
                String s1 = s.substring(v1 + 9, (s.indexOf(38, v1 + 9) >= 0 ? s.indexOf(38, v1 + 9) : s.indexOf(0x20, v1 + 9)));
                this.f = s1;
                if("Y".equals(s1)) {
                    int v2 = s.lastIndexOf("&localPath=");
                    this.g = s.substring(v2 + 11, (s.indexOf(38, v2 + 11) >= 0 ? s.indexOf(38, v2 + 11) : s.indexOf(0x20, v2 + 11)));
                    int v3 = s.lastIndexOf("&contentType=");
                    this.h = s.substring(v3 + 13, (s.indexOf(38, v3 + 13) >= 0 ? s.indexOf(38, v3 + 13) : s.indexOf(0x20, v3 + 13)));
                }
                else {
                    z = false;
                }
            }
            else {
                z = false;
            }
            int v4 = s.lastIndexOf("&cacheEnable=");
            if(v4 + 13 > 0) {
                this.e = s.substring(v4 + 13, (s.indexOf(38, v4 + 13) >= 0 ? s.indexOf(38, v4 + 13) : s.indexOf(0x20, v4 + 13)));
                if(s.contains("&bitrate=")) {
                    int v5 = s.lastIndexOf("&bitrate=");
                    this.i = s.substring(v5 + 9, (s.indexOf(38, v5 + 9) >= 0 ? s.indexOf(38, v5 + 9) : s.indexOf(0x20, v5 + 9)));
                }
                if(s.contains("&metaType=")) {
                    int v6 = s.lastIndexOf("&metaType=");
                    this.j = s.substring(v6 + 10, (s.indexOf(38, v6 + 10) >= 0 ? s.indexOf(38, v6 + 10) : s.indexOf(0x20, v6 + 10)));
                }
            }
            if(!z) {
                int v7 = s.lastIndexOf("&_host=");
                if(v7 < 0) {
                    throw new ParseError("ClientRequest", "Can\'t find the host. - Host info is not exist. / " + this.B());
                }
                int v8 = s.indexOf(38, v7 + 7) >= 0 ? s.indexOf(38, v7 + 7) : s.indexOf(0x20, v7 + 7);
                this.k = s.substring(v7 + 7, v8);
                String s2 = stringBuilder0.delete(v7, v8).toString();
                int v9 = s2.lastIndexOf("&_port=");
                if(v9 < 0) {
                    throw new ParseError("ClientRequest", "Can\'t parse the port. - Port info is not exist. / " + this.B());
                }
                try {
                    v10 = s2.indexOf(38, v9 + 7) >= 0 ? s2.indexOf(38, v9 + 7) : s2.indexOf(0x20, v9 + 7);
                    this.l = Integer.parseInt(s2.substring(v9 + 7, v10));
                }
                catch(Exception exception0) {
                    throw new ParseError("ClientRequest", "Can\'t find the port. - " + exception0.toString() + " / " + this.B());
                }
                s = stringBuilder0.delete(v9, v10).toString();
            }
            int v11 = s.lastIndexOf("&_c=");
            if(v11 < 0) {
                throw new ParseError("ClientRequest", "Can\'t find the c. - C info is not exist. / " + this.B());
            }
            int v12 = s.indexOf(38, v11 + 4) >= 0 ? s.indexOf(38, v11 + 4) : s.indexOf(0x20, v11 + 4);
            if(v12 < 0) {
                v12 = s.length();
            }
            this.m = s.substring(v11 + 4, v12);
            String s3 = stringBuilder0.delete(v11, v12).toString();
            StringBuilder stringBuilder1 = this.b;
            if(stringBuilder1 != null) {
                stringBuilder1.append(s3);
                stringBuilder1.append("\r\n");
            }
            return;
        }
        StringBuilder stringBuilder2 = a.n("Can\'t find the contens id. uri: ", s, " / ");
        stringBuilder2.append(this.B());
        throw new ParseError("ClientRequest", stringBuilder2.toString());
    }

    public final void o() {
        this.o = true;
    }

    public final String p() {
        if(this.F()) {
            throw new NeedParse("ClientRequest", "cacheEnable() - Please parsing.");
        }
        return this.e;
    }

    public final String q() {
        if(this.F()) {
            throw new NeedParse("ClientRequest", "cid() - Please parsing.");
        }
        return this.d;
    }

    public final ByteBuf r() {
        if(this.F()) {
            throw new IllegalStateException("Please parsing.");
        }
        StringBuilder stringBuilder0 = new StringBuilder(this.b);
        if(!TextUtils.isEmpty(stringBuilder0) && stringBuilder0.length() > 3 && "GET".equals(stringBuilder0.substring(0, 3))) {
            stringBuilder0.replace(0, 3, "HEAD");
        }
        if(this.o) {
            stringBuilder0.append("Range: bytes=");
            stringBuilder0.append(this.n);
            stringBuilder0.append("-");
        }
        else {
            stringBuilder0.append("Range: bytes=0-");
        }
        stringBuilder0.append("\r\n\r\n");
        f.b("ClientRequest", "Data HEAD Request: " + stringBuilder0);
        return Unpooled.wrappedBuffer(stringBuilder0.toString().getBytes(CharsetUtil.UTF_8));
    }

    public final ByteBuf s() {
        if(this.F()) {
            throw new IllegalStateException("Please parsing.");
        }
        StringBuilder stringBuilder0 = new StringBuilder(this.b);
        if(this.o) {
            stringBuilder0.append("Range: bytes=");
            stringBuilder0.append(this.n);
            stringBuilder0.append("-\r\n\r\n");
        }
        else {
            stringBuilder0.append("Range: bytes=0-\r\n\r\n");
        }
        f.b("ClientRequest", "Data TAIL Request: " + stringBuilder0);
        return Unpooled.wrappedBuffer(stringBuilder0.toString().getBytes(CharsetUtil.UTF_8));
    }
}

