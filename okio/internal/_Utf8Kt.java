package okio.internal;

import Tf.v;
import U4.x;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000E\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001A\u001E\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u0004\u001A\n\u0010\u0006\u001A\u00020\u0002*\u00020\u0001¨\u0006\u0007"}, d2 = {"commonToUtf8String", "", "", "beginIndex", "", "endIndex", "commonAsUtf8ToByteArray", "okio"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public final class _Utf8Kt {
    @NotNull
    public static final byte[] commonAsUtf8ToByteArray(@NotNull String s) {
        q.g(s, "<this>");
        byte[] arr_b = new byte[s.length() * 4];
        int v = s.length();
        int v1 = 0;
        while(v1 < v) {
            int v2 = s.charAt(v1);
            if(q.h(v2, 0x80) >= 0) {
                int v3 = s.length();
                int v4 = v1;
            label_9:
                while(v1 < v3) {
                    int v5 = s.charAt(v1);
                    if(q.h(v5, 0x80) < 0) {
                        int v6 = v4 + 1;
                        arr_b[v4] = (byte)v5;
                        ++v1;
                        while(true) {
                            v4 = v6;
                            if(v1 >= v3 || q.h(s.charAt(v1), 0x80) >= 0) {
                                continue label_9;
                            }
                            v6 = v4 + 1;
                            arr_b[v4] = (byte)s.charAt(v1);
                            ++v1;
                        }
                    }
                    if(q.h(v5, 0x800) < 0) {
                        int v7 = v4 + 1;
                        arr_b[v4] = (byte)(v5 >> 6 | 0xC0);
                        v4 += 2;
                        arr_b[v7] = (byte)(v5 & 0x3F | 0x80);
                    }
                    else if(0xD800 > v5 || v5 >= 0xE000) {
                        arr_b[v4] = (byte)(v5 >> 12 | 0xE0);
                        int v11 = v4 + 2;
                        arr_b[v4 + 1] = (byte)(v5 >> 6 & 0x3F | 0x80);
                        v4 += 3;
                        arr_b[v11] = (byte)(v5 & 0x3F | 0x80);
                    }
                    else {
                        if(q.h(v5, 0xDBFF) <= 0 && v3 > v1 + 1) {
                            int v8 = s.charAt(v1 + 1);
                            if(0xDC00 <= v8 && v8 < 0xE000) {
                                int v9 = s.charAt(v1 + 1) + (v5 << 10) - 0x35FDC00;
                                arr_b[v4] = (byte)(v9 >> 18 | 0xF0);
                                arr_b[v4 + 1] = (byte)(v9 >> 12 & 0x3F | 0x80);
                                int v10 = v4 + 3;
                                arr_b[v4 + 2] = (byte)(v9 >> 6 & 0x3F | 0x80);
                                v4 += 4;
                                arr_b[v10] = (byte)(v9 & 0x3F | 0x80);
                                v1 += 2;
                                continue;
                            }
                        }
                        arr_b[v4] = 0x3F;
                        ++v1;
                        ++v4;
                        continue;
                    }
                    ++v1;
                }
                byte[] arr_b1 = Arrays.copyOf(arr_b, v4);
                q.f(arr_b1, "copyOf(...)");
                return arr_b1;
            }
            arr_b[v1] = (byte)v2;
            ++v1;
        }
        byte[] arr_b2 = Arrays.copyOf(arr_b, s.length());
        q.f(arr_b2, "copyOf(...)");
        return arr_b2;
    }

    @NotNull
    public static final String commonToUtf8String(@NotNull byte[] arr_b, int v, int v1) {
        int v13;
        int v12;
        int v8;
        int v4;
        q.g(arr_b, "<this>");
        if(v >= 0 && v1 <= arr_b.length && v <= v1) {
            char[] arr_c = new char[v1 - v];
            int v2 = 0;
            while(v < v1) {
                int v3 = arr_b[v];
                if(v3 >= 0) {
                    v4 = v2 + 1;
                    arr_c[v2] = (char)v3;
                    ++v;
                    while(v < v1) {
                        int v5 = arr_b[v];
                        if(v5 < 0) {
                            break;
                        }
                        ++v;
                        arr_c[v4] = (char)v5;
                        ++v4;
                    }
                }
                else {
                    if(v3 >> 5 == -2) {
                        if(v1 <= v + 1) {
                            v4 = v2 + 1;
                            arr_c[v2] = '\uFFFD';
                            goto label_66;
                        }
                        else {
                            int v6 = arr_b[v + 1];
                            if((v6 & 0xC0) == 0x80) {
                                int v7 = v3 << 6 ^ (v6 ^ 0xF80);
                                if(v7 < 0x80) {
                                    v4 = v2 + 1;
                                    arr_c[v2] = '\uFFFD';
                                }
                                else {
                                    v4 = v2 + 1;
                                    arr_c[v2] = (char)v7;
                                }
                                v8 = 2;
                                goto label_67;
                            }
                            else {
                                v4 = v2 + 1;
                                arr_c[v2] = '\uFFFD';
                                goto label_66;
                            }
                        }
                        goto label_36;
                    }
                    else {
                    label_36:
                        if(v3 >> 4 != -2) {
                            goto label_70;
                        }
                        else if(v1 <= v + 2) {
                            v4 = v2 + 1;
                            arr_c[v2] = '\uFFFD';
                            if(v1 > v + 1 && (arr_b[v + 1] & 0xC0) == 0x80) {
                                v8 = 2;
                                goto label_67;
                            }
                        }
                        else {
                            int v9 = arr_b[v + 1];
                            if((v9 & 0xC0) == 0x80) {
                                int v10 = arr_b[v + 2];
                                if((v10 & 0xC0) == 0x80) {
                                    int v11 = v3 << 12 ^ (v10 ^ 0xFFFE1F80 ^ v9 << 6);
                                    if(v11 < 0x800) {
                                        v4 = v2 + 1;
                                        arr_c[v2] = '\uFFFD';
                                    }
                                    else if(0xD800 > v11 || v11 >= 0xE000) {
                                        v4 = v2 + 1;
                                        arr_c[v2] = (char)v11;
                                    }
                                    else {
                                        v4 = v2 + 1;
                                        arr_c[v2] = '\uFFFD';
                                    }
                                    v8 = 3;
                                }
                                else {
                                    v4 = v2 + 1;
                                    arr_c[v2] = '\uFFFD';
                                    v8 = 2;
                                }
                                goto label_67;
                            }
                            else {
                                v4 = v2 + 1;
                                arr_c[v2] = '\uFFFD';
                            }
                        }
                    }
                label_66:
                    v8 = 1;
                label_67:
                    v += v8;
                }
                v2 = v4;
                continue;
            label_70:
                if(v3 >> 3 == -2) {
                    if(v1 <= v + 3) {
                        v12 = v2 + 1;
                        arr_c[v2] = '\uFFFD';
                        if(v1 > v + 1 && (arr_b[v + 1] & 0xC0) == 0x80) {
                            v13 = v1 <= v + 2 || (arr_b[v + 2] & 0xC0) != 0x80 ? 2 : 3;
                            goto label_115;
                        }
                    }
                    else {
                        int v14 = arr_b[v + 1];
                        if((v14 & 0xC0) == 0x80) {
                            int v15 = arr_b[v + 2];
                            if((v15 & 0xC0) == 0x80) {
                                int v16 = arr_b[v + 3];
                                if((v16 & 0xC0) == 0x80) {
                                    int v17 = v3 << 18 ^ (v16 ^ 0x381F80 ^ v15 << 6 ^ v14 << 12);
                                    if(v17 > 0x10FFFF) {
                                        v12 = v2 + 1;
                                        arr_c[v2] = '\uFFFD';
                                    }
                                    else if(0xD800 <= v17 && v17 < 0xE000) {
                                        v12 = v2 + 1;
                                        arr_c[v2] = '\uFFFD';
                                    }
                                    else if(v17 < 0x10000) {
                                        v12 = v2 + 1;
                                        arr_c[v2] = '\uFFFD';
                                    }
                                    else {
                                        arr_c[v2] = (char)((v17 >>> 10) + 0xD7C0);
                                        arr_c[v2 + 1] = (char)((v17 & 0x3FF) + 0xDC00);
                                        v12 = v2 + 2;
                                    }
                                    v13 = 4;
                                }
                                else {
                                    v12 = v2 + 1;
                                    arr_c[v2] = '\uFFFD';
                                    v13 = 3;
                                }
                            }
                            else {
                                v12 = v2 + 1;
                                arr_c[v2] = '\uFFFD';
                                v13 = 2;
                            }
                            goto label_115;
                        }
                        else {
                            v12 = v2 + 1;
                            arr_c[v2] = '\uFFFD';
                        }
                    }
                    v13 = 1;
                label_115:
                    v += v13;
                }
                else {
                    v12 = v2 + 1;
                    arr_c[v2] = '\uFFFD';
                    ++v;
                }
                v2 = v12;
            }
            return v.h0(arr_c, 0, v2);
        }
        StringBuilder stringBuilder0 = new StringBuilder("size=");
        x.x(stringBuilder0, arr_b.length, " beginIndex=", v, " endIndex=");
        stringBuilder0.append(v1);
        throw new ArrayIndexOutOfBoundsException(stringBuilder0.toString());
    }

    public static String commonToUtf8String$default(byte[] arr_b, int v, int v1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = 0;
        }
        if((v2 & 2) != 0) {
            v1 = arr_b.length;
        }
        return _Utf8Kt.commonToUtf8String(arr_b, v, v1);
    }
}

