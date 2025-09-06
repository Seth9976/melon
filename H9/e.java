package h9;

import com.iloen.melon.mcache.error.NetworkError.HttpError;
import com.iloen.melon.mcache.error.ParamError.IllegalArgumentError;
import com.iloen.melon.mcache.error.ParseError;
import io.netty.buffer.ByteBuf;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public final class e {
    public int a;
    public StringBuilder b;
    public String c;
    public String d;
    public static final String[] e;

    static {
        e.e = new String[]{"audio", "video", "application", "text"};
    }

    public final d a(long v, boolean z) {
        String s1;
        if(this.a < 2) {
            return null;
        }
        d d0 = new d();
        StringBuilder stringBuilder0 = (StringBuilder)d0.d;
        try(BufferedReader bufferedReader0 = new BufferedReader(new StringReader(this.b.toString()))) {
            StringBuilder stringBuilder1 = new StringBuilder();
            int v1 = 0;
            while(true) {
                String s = bufferedReader0.readLine();
                if(s != null) {
                    if(v1 + 1 == 1 && !z) {
                        if(s.length() < 5 || !s.substring(0, 5).equals("HTTP/")) {
                            throw new ParseError("HttpResponseHeaderParser", "MMD Server Http Response Code is not exist.");
                        }
                        if(s.split(" ")[1].startsWith("20")) {
                            stringBuilder0.append("HTTP/1.1 200 OK\r\n");
                        }
                        else {
                            try {
                                throw new HttpError("HttpResponseHeaderParser", this.b("Header Checking: " + s));
                            }
                            catch(HttpError networkError$HttpError0) {
                                f.d("HttpResponseHeaderParser", networkError$HttpError0.getMessage());
                                stringBuilder0.append(s);
                                stringBuilder0.append("\r\n");
                            }
                        }
                    label_100:
                        s1 = s;
                    }
                    else if(s.length() <= 13 || !s.substring(0, 13).equalsIgnoreCase("Content-Range")) {
                        if(s.length() <= 14) {
                            s1 = s;
                        }
                        else {
                            s1 = s;
                            if(!s1.substring(0, 14).equalsIgnoreCase("Content-Length")) {
                                goto label_23;
                            }
                            goto label_63;
                        }
                    label_23:
                        if(s1.length() > 12 && s1.substring(0, 12).equalsIgnoreCase("Content-Type")) {
                            String s2 = s1.substring(13).trim();
                            String[] arr_s = e.e;
                            for(int v2 = 0; true; ++v2) {
                                if(v2 >= 4) {
                                    throw new IllegalArgumentError("HttpResponseHeaderParser", "Mime type " + s2 + " is not supported." + "[RawData]" + s1);
                                }
                                if(s2.startsWith(arr_s[v2])) {
                                    break;
                                }
                            }
                            stringBuilder0.append(s1);
                            stringBuilder0.append("\r\n");
                        }
                        else if(s1.length() > 13 && s1.substring(0, 13).equalsIgnoreCase("Last-Modified")) {
                            d0.e = s1.substring(14).trim();
                            goto label_102;
                        label_63:
                            long v3 = Long.parseLong(s1.substring(15).trim());
                            if(v3 < 1L) {
                                throw new HttpError("HttpResponseHeaderParser", this.b("MMD Server\'s content length is " + v3 + "[RawData]" + s1));
                            }
                            d0.c = Long.parseLong(s1.substring(15).trim());
                        }
                        else if(s1.length() > 4 && s1.substring(0, 4).equalsIgnoreCase("ETag")) {
                            d0.f = s1.substring(5).trim();
                        }
                        else if(s1.length() > 10 && s1.substring(0, 10).equalsIgnoreCase("X-M-Stream")) {
                            d0.g = s1.substring(11).trim();
                        }
                        else if(s1.length() > 0) {
                            stringBuilder0.append(s1);
                            stringBuilder0.append("\r\n");
                        }
                    }
                    else {
                        d0.b = Long.parseLong(s.substring(s.lastIndexOf(0x2F) + 1));
                        if(z) {
                            stringBuilder0.append("Content-Range");
                            stringBuilder0.append(": bytes ");
                            stringBuilder0.append(v);
                            stringBuilder0.append("-");
                            stringBuilder0.append(d0.b - 1L);
                            stringBuilder0.append("/");
                            stringBuilder0.append(d0.b);
                            stringBuilder0.append("\r\n");
                        }
                        goto label_100;
                    }
                label_102:
                    if(s1.length() == 0) {
                        stringBuilder0.append("Content-Length: ");
                        stringBuilder0.append(d0.b - v);
                        stringBuilder0.append("\r\n\r\n");
                    }
                    else {
                        goto label_111;
                    }
                }
                f.b("HttpResponseHeaderParser", stringBuilder1.toString());
                return d0;
            label_111:
                ++v1;
            }
        }
        catch(IOException iOException0) {
            throw new HttpError("HttpResponseHeaderParser", "Can\'t read a server response data:" + iOException0.getMessage());
        }
    }

    public final String b(String s) {
        return s + "\n[Connected Server Address]\n" + this.d + "\n[Request]\n" + this.c;
    }

    public final boolean c(ByteBuf byteBuf0) {
        while(byteBuf0.isReadable()) {
            int v = byteBuf0.readUnsignedByte();
            switch(v) {
                case 10: {
                    this.b.append('\n');
                    int v1 = this.a + 1;
                    this.a = v1;
                    if(v1 != 2) {
                        continue;
                    }
                    return true;
                }
                case 13: {
                    this.b.append('\r');
                    if(!byteBuf0.isReadable() || ((char)byteBuf0.getUnsignedByte(byteBuf0.readerIndex())) != 10) {
                        continue;
                    }
                    byteBuf0.skipBytes(1);
                    this.b.append('\n');
                    int v2 = this.a + 1;
                    this.a = v2;
                    if(v2 == 2) {
                        return true;
                    }
                    break;
                }
                default: {
                    if(this.a == 1) {
                        this.a = 0;
                    }
                    this.b.append(((char)v));
                    continue;
                }
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    public final void d() {
        this.a = 0;
        this.b = new StringBuilder(0x800);
    }
}

