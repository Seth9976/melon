package d8;

import R6.d;
import androidx.media3.session.m1;

public final class g extends d {
    public final int c;

    public g(int v) {
        this.c = v;
        super(27);
    }

    @Override  // R6.d
    public void i(m1 m10) {
        if(this.c != 1) {
            super.i(m10);
            return;
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        while(m10.c()) {
            int v = m10.a();
            ++m10.b;
            this.t(((char)v), stringBuilder0);
            if(stringBuilder0.length() % 3 == 0) {
                d.B(m10, stringBuilder0);
                if(d8.d.z(m10.a, m10.b, 3) != 3) {
                    m10.c = 0;
                    break;
                }
                if(false) {
                    break;
                }
            }
        }
        this.w(m10, stringBuilder0);
    }

    @Override  // R6.d
    public final int t(char c, StringBuilder stringBuilder0) {
        if(this.c != 0) {
            switch(c) {
                case 13: {
                    stringBuilder0.append('\u0000');
                    return 1;
                }
                case 0x20: {
                    stringBuilder0.append('\u0003');
                    return 1;
                }
                case 42: {
                    stringBuilder0.append('\u0001');
                    return 1;
                }
                case 62: {
                    stringBuilder0.append('\u0002');
                    return 1;
                }
                default: {
                    if(c >= 0x30 && c <= 57) {
                        stringBuilder0.append(((char)(c - 44)));
                        return 1;
                    }
                    if(c >= 65 && c <= 90) {
                        stringBuilder0.append(((char)(c - 51)));
                        return 1;
                    }
                    d8.d.u(c);
                    throw null;
                }
            }
        }
        if(c == 0x20) {
            stringBuilder0.append('\u0003');
            return 1;
        }
        if(c >= 0x30 && c <= 57) {
            stringBuilder0.append(((char)(c - 44)));
            return 1;
        }
        if(c >= 97 && c <= 0x7A) {
            stringBuilder0.append(((char)(c - 83)));
            return 1;
        }
        if(c < 0x20) {
            stringBuilder0.append('\u0000');
            stringBuilder0.append(c);
            return 2;
        }
        if(c >= 33 && c <= 0x2F) {
            stringBuilder0.append('\u0001');
            stringBuilder0.append(((char)(c - 33)));
            return 2;
        }
        if(c >= 58 && c <= 0x40) {
            stringBuilder0.append('\u0001');
            stringBuilder0.append(((char)(c - 43)));
            return 2;
        }
        if(c >= 91 && c <= 0x5F) {
            stringBuilder0.append('\u0001');
            stringBuilder0.append(((char)(c - 69)));
            return 2;
        }
        if(c == 0x60) {
            stringBuilder0.append('\u0002');
            stringBuilder0.append('\u0000');
            return 2;
        }
        if(c >= 65 && c <= 90) {
            stringBuilder0.append('\u0002');
            stringBuilder0.append(((char)(c - 0x40)));
            return 2;
        }
        if(c >= 0x7B && c <= 0x7F) {
            stringBuilder0.append('\u0002');
            stringBuilder0.append(((char)(c - 0x60)));
            return 2;
        }
        stringBuilder0.append("\u0001\u001E");
        return this.t(((char)(c - 0x80)), stringBuilder0) + 2;
    }

    @Override  // R6.d
    public final int u() {
        return this.c == 0 ? 2 : 3;
    }

    @Override  // R6.d
    public void w(m1 m10, StringBuilder stringBuilder0) {
        if(this.c != 1) {
            super.w(m10, stringBuilder0);
            return;
        }
        m10.d(((StringBuilder)m10.f).length());
        int v = ((e)m10.g).b - ((StringBuilder)m10.f).length();
        m10.b -= stringBuilder0.length();
        if(m10.a.length() - m10.d - m10.b > 1 || v > 1 || m10.a.length() - m10.d - m10.b != v) {
            m10.e('þ');
        }
        if(m10.c < 0) {
            m10.c = 0;
        }
    }
}

