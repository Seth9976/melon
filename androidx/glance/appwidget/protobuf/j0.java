package androidx.glance.appwidget.protobuf;

import com.google.firebase.b;
import d5.f;
import java.util.Arrays;

public final class j0 extends f {
    public final int f;

    public j0(int v) {
        this.f = v;
        super();
    }

    @Override  // d5.f
    public final String t(byte[] arr_b, int v, int v1) {
        if(this.f != 0) {
            String s = new String(arr_b, v, v1, B.a);
            if(s.indexOf(0xFFFD) >= 0 && !Arrays.equals(s.getBytes(B.a), Arrays.copyOfRange(arr_b, v, v1 + v))) {
                throw D.a();
            }
            return s;
        }
        if((v | v1 | arr_b.length - v - v1) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", ((int)arr_b.length), v, v1));
        }
        int v2 = v + v1;
        char[] arr_c = new char[v1];
        int v3;
        for(v3 = 0; v < v2; ++v3) {
            int v4 = arr_b[v];
            if(v4 < 0) {
                break;
            }
            ++v;
            arr_c[v3] = (char)v4;
        }
        while(v < v2) {
            int v5 = v + 1;
            int v6 = arr_b[v];
            if(v6 >= 0) {
                int v7 = v3 + 1;
                arr_c[v3] = (char)v6;
                while(v5 < v2) {
                    int v8 = arr_b[v5];
                    if(v8 < 0) {
                        break;
                    }
                    ++v5;
                    arr_c[v7] = (char)v8;
                    ++v7;
                }
                v3 = v7;
                v = v5;
                continue;
            }
            if(v6 < 0xFFFFFFE0) {
                if(v5 < v2) {
                    v += 2;
                    int v9 = arr_b[v5];
                    if(v6 < -62 || b.J(((byte)v9))) {
                        throw D.a();
                    }
                    arr_c[v3] = (char)(v9 & 0x3F | (v6 & 0x1F) << 6);
                    ++v3;
                    continue;
                }
            }
            else if(v6 < -16) {
                if(v5 < v2 - 1) {
                    int v10 = v + 2;
                    int v11 = arr_b[v5];
                    v += 3;
                    int v12 = arr_b[v10];
                    if(b.J(((byte)v11)) || v6 == 0xFFFFFFE0 && v11 < 0xFFFFFFA0 || v6 == -19 && v11 >= 0xFFFFFFA0 || b.J(((byte)v12))) {
                        throw D.a();
                    }
                    arr_c[v3] = (char)((v11 & 0x3F) << 6 | (v6 & 15) << 12 | v12 & 0x3F);
                    ++v3;
                    continue;
                }
            }
            else if(v5 < v2 - 2) {
                int v13 = arr_b[v5];
                int v14 = v + 3;
                int v15 = arr_b[v + 2];
                v += 4;
                int v16 = arr_b[v14];
                if(b.J(((byte)v13)) || v13 + 0x70 + (v6 << 28) >> 30 != 0 || b.J(((byte)v15)) || b.J(((byte)v16))) {
                    throw D.a();
                }
                int v17 = (v13 & 0x3F) << 12 | (v6 & 7) << 18 | (v15 & 0x3F) << 6 | v16 & 0x3F;
                arr_c[v3] = (char)((v17 >>> 10) + 0xD7C0);
                arr_c[v3 + 1] = (char)((v17 & 0x3FF) + 0xDC00);
                v3 += 2;
                continue;
            }
            throw D.a();
        }
        return new String(arr_c, 0, v3);
    }

    @Override  // d5.f
    public final int v(String s, byte[] arr_b, int v, int v1) {
        long v8;
        if(this.f != 0) {
            long v2 = (long)v;
            long v3 = ((long)v1) + v2;
            int v4 = s.length();
            if(v4 > v1 || arr_b.length - v1 < v) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + s.charAt(v4 - 1) + " at index " + (v + v1));
            }
            int v5 = 0;
            while(v5 < v4) {
                int v6 = s.charAt(v5);
                if(v6 >= 0x80) {
                    break;
                }
                i0.j(arr_b, v2, ((byte)v6));
                ++v5;
                ++v2;
            }
            if(v5 == v4) {
                return (int)v2;
            }
            while(v5 < v4) {
                int v7 = s.charAt(v5);
                if(v7 < 0x80 && v2 < v3) {
                    i0.j(arr_b, v2, ((byte)v7));
                    v8 = v2 + 1L;
                }
                else if(v7 < 0x800 && v2 <= v3 - 2L) {
                    i0.j(arr_b, v2, ((byte)(v7 >>> 6 | 960)));
                    i0.j(arr_b, v2 + 1L, ((byte)(v7 & 0x3F | 0x80)));
                    v8 = v2 + 2L;
                }
                else if(v7 >= 0xD800 && 0xDFFF >= v7 || v2 > v3 - 3L) {
                    if(v2 > v3 - 4L) {
                        goto label_48;
                    }
                    if(v5 + 1 == v4) {
                        throw new k0(v5 - 1, v4);
                    }
                    int v9 = s.charAt(v5 + 1);
                    if(!Character.isSurrogatePair(((char)v7), ((char)v9))) {
                        goto label_46;
                    }
                    int v10 = Character.toCodePoint(((char)v7), ((char)v9));
                    i0.j(arr_b, v2, ((byte)(v10 >>> 18 | 0xF0)));
                    i0.j(arr_b, v2 + 1L, ((byte)(v10 >>> 12 & 0x3F | 0x80)));
                    i0.j(arr_b, v2 + 2L, ((byte)(v10 >>> 6 & 0x3F | 0x80)));
                    i0.j(arr_b, v2 + 3L, ((byte)(v10 & 0x3F | 0x80)));
                    v8 = v2 + 4L;
                    ++v5;
                }
                else {
                    i0.j(arr_b, v2, ((byte)(v7 >>> 12 | 480)));
                    i0.j(arr_b, v2 + 1L, ((byte)(v7 >>> 6 & 0x3F | 0x80)));
                    v8 = v2 + 3L;
                    i0.j(arr_b, v2 + 2L, ((byte)(v7 & 0x3F | 0x80)));
                }
                ++v5;
                v2 = v8;
                continue;
            label_46:
                ++v5;
                throw new k0(v5 - 1, v4);
            label_48:
                if(0xD800 <= v7 && v7 <= 0xDFFF && (v5 + 1 == v4 || !Character.isSurrogatePair(((char)v7), s.charAt(v5 + 1)))) {
                    throw new k0(v5, v4);
                }
                throw new ArrayIndexOutOfBoundsException("Failed writing " + ((char)v7) + " at index " + v2);
            }
            return (int)v2;
        }
        int v11 = s.length();
        int v12 = v1 + v;
        int v13;
        for(v13 = 0; v13 < v11; ++v13) {
            int v14 = v13 + v;
            if(v14 >= v12) {
                break;
            }
            int v15 = s.charAt(v13);
            if(v15 >= 0x80) {
                break;
            }
            arr_b[v14] = (byte)v15;
        }
        if(v13 == v11) {
            return v + v11;
        }
        int v16 = v + v13;
        while(v13 < v11) {
            int v17 = s.charAt(v13);
            if(v17 < 0x80 && v16 < v12) {
                arr_b[v16] = (byte)v17;
                ++v16;
            }
            else if(v17 < 0x800 && v16 <= v12 - 2) {
                int v18 = v16 + 1;
                arr_b[v16] = (byte)(v17 >>> 6 | 960);
                v16 += 2;
                arr_b[v18] = (byte)(v17 & 0x3F | 0x80);
            }
            else if(v17 >= 0xD800 && 0xDFFF >= v17 || v16 > v12 - 3) {
                if(v16 > v12 - 4) {
                    goto label_102;
                }
                if(v13 + 1 == s.length()) {
                    throw new k0(v13 - 1, v11);
                }
                int v20 = s.charAt(v13 + 1);
                if(!Character.isSurrogatePair(((char)v17), ((char)v20))) {
                    goto label_100;
                }
                int v21 = Character.toCodePoint(((char)v17), ((char)v20));
                arr_b[v16] = (byte)(v21 >>> 18 | 0xF0);
                arr_b[v16 + 1] = (byte)(v21 >>> 12 & 0x3F | 0x80);
                int v22 = v16 + 3;
                arr_b[v16 + 2] = (byte)(v21 >>> 6 & 0x3F | 0x80);
                v16 += 4;
                arr_b[v22] = (byte)(v21 & 0x3F | 0x80);
                ++v13;
            }
            else {
                arr_b[v16] = (byte)(v17 >>> 12 | 480);
                int v19 = v16 + 2;
                arr_b[v16 + 1] = (byte)(v17 >>> 6 & 0x3F | 0x80);
                v16 += 3;
                arr_b[v19] = (byte)(v17 & 0x3F | 0x80);
            }
            ++v13;
            continue;
        label_100:
            ++v13;
            throw new k0(v13 - 1, v11);
        label_102:
            if(0xD800 <= v17 && v17 <= 0xDFFF && (v13 + 1 == s.length() || !Character.isSurrogatePair(((char)v17), s.charAt(v13 + 1)))) {
                throw new k0(v13, v11);
            }
            throw new ArrayIndexOutOfBoundsException("Failed writing " + ((char)v17) + " at index " + v16);
        }
        return v16;
    }
}

