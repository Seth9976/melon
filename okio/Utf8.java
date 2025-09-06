package okio;

import U4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u0000@\n\u0002\u0010\u000E\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0011\u001A\'\u0010\u0007\u001A\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00012\b\b\u0002\u0010\u0003\u001A\u00020\u0001H\u0007\u00A2\u0006\u0004\b\u0005\u0010\u0006\u001A\u0018\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0001H\u0080\b\u00A2\u0006\u0004\b\n\u0010\u000B\u001A\u0018\u0010\u000E\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\b\u000E\u0010\u000F\u001A;\u0010\u0013\u001A\u00020\u0011*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0012\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00110\u0010H\u0080\b\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0013\u0010\u0014\u001A;\u0010\u0016\u001A\u00020\u0011*\u00020\u00152\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0012\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00110\u0010H\u0080\b\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0016\u0010\u0017\u001A;\u0010\u0019\u001A\u00020\u0011*\u00020\u00152\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0012\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00110\u0010H\u0080\b\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0019\u0010\u0017\u001A;\u0010\u001A\u001A\u00020\u0001*\u00020\u00152\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0012\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00110\u0010H\u0080\b\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u001A\u0010\u001B\u001A;\u0010\u001C\u001A\u00020\u0001*\u00020\u00152\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0012\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00110\u0010H\u0080\b\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u001C\u0010\u001B\u001A;\u0010\u001D\u001A\u00020\u0001*\u00020\u00152\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0012\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00110\u0010H\u0080\b\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u001D\u0010\u001B\"\u0014\u0010\u001E\u001A\u00020\f8\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b\u001E\u0010\u001F\"\u0014\u0010 \u001A\u00020\u00188\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b \u0010!\"\u0014\u0010\"\u001A\u00020\u00018\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b\"\u0010#\"\u0014\u0010$\u001A\u00020\u00018\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b$\u0010#\"\u0014\u0010%\u001A\u00020\u00018\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b%\u0010#\"\u0014\u0010&\u001A\u00020\u00018\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b&\u0010#\"\u0014\u0010\'\u001A\u00020\u00018\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b\'\u0010#\"\u0014\u0010(\u001A\u00020\u00018\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b(\u0010#\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00A8\u0006)"}, d2 = {"", "", "beginIndex", "endIndex", "", "size", "(Ljava/lang/String;II)J", "utf8Size", "codePoint", "", "isIsoControl", "(I)Z", "", "byte", "isUtf8Continuation", "(B)Z", "Lkotlin/Function1;", "Lie/H;", "yield", "processUtf8Bytes", "(Ljava/lang/String;IILwe/k;)V", "", "processUtf8CodePoints", "([BIILwe/k;)V", "", "processUtf16Chars", "process2Utf8Bytes", "([BIILwe/k;)I", "process3Utf8Bytes", "process4Utf8Bytes", "REPLACEMENT_BYTE", "B", "REPLACEMENT_CHARACTER", "C", "REPLACEMENT_CODE_POINT", "I", "HIGH_SURROGATE_HEADER", "LOG_SURROGATE_HEADER", "MASK_2BYTES", "MASK_3BYTES", "MASK_4BYTES", "okio"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 0xD7C0;
    public static final int LOG_SURROGATE_HEADER = 0xDC00;
    public static final int MASK_2BYTES = 0xF80;
    public static final int MASK_3BYTES = 0xFFFE1F80;
    public static final int MASK_4BYTES = 0x381F80;
    public static final byte REPLACEMENT_BYTE = 0x3F;
    public static final char REPLACEMENT_CHARACTER = '\uFFFD';
    public static final int REPLACEMENT_CODE_POINT = 0xFFFD;

    // 去混淆评级： 低(20)
    public static final boolean isIsoControl(int v) {
        return v >= 0 && v < 0x20 || 0x7F <= v && v < 0xA0;
    }

    public static final boolean isUtf8Continuation(byte b) {
        return (b & 0xC0) == 0x80;
    }

    public static final int process2Utf8Bytes(@NotNull byte[] arr_b, int v, int v1, @NotNull k k0) {
        q.g(arr_b, "<this>");
        q.g(k0, "yield");
        if(v1 <= v + 1) {
            k0.invoke(0xFFFD);
            return 1;
        }
        int v2 = arr_b[v];
        int v3 = arr_b[v + 1];
        if((v3 & 0xC0) == 0x80) {
            int v4 = v3 ^ 0xF80 ^ v2 << 6;
            if(v4 < 0x80) {
                k0.invoke(0xFFFD);
                return 2;
            }
            k0.invoke(v4);
            return 2;
        }
        k0.invoke(0xFFFD);
        return 1;
    }

    public static final int process3Utf8Bytes(@NotNull byte[] arr_b, int v, int v1, @NotNull k k0) {
        q.g(arr_b, "<this>");
        q.g(k0, "yield");
        if(v1 <= v + 2) {
            k0.invoke(0xFFFD);
            return v1 <= v + 1 || (arr_b[v + 1] & 0xC0) != 0x80 ? 1 : 2;
        }
        int v2 = arr_b[v];
        int v3 = arr_b[v + 1];
        if((v3 & 0xC0) == 0x80) {
            int v4 = arr_b[v + 2];
            if((v4 & 0xC0) == 0x80) {
                int v5 = v4 ^ 0xFFFE1F80 ^ v3 << 6 ^ v2 << 12;
                if(v5 < 0x800) {
                    k0.invoke(0xFFFD);
                    return 3;
                }
                if(0xD800 <= v5 && v5 < 0xE000) {
                    k0.invoke(0xFFFD);
                    return 3;
                }
                k0.invoke(v5);
                return 3;
            }
            k0.invoke(0xFFFD);
            return 2;
        }
        k0.invoke(0xFFFD);
        return 1;
    }

    public static final int process4Utf8Bytes(@NotNull byte[] arr_b, int v, int v1, @NotNull k k0) {
        q.g(arr_b, "<this>");
        q.g(k0, "yield");
        if(v1 <= v + 3) {
            k0.invoke(0xFFFD);
            if(v1 > v + 1 && (arr_b[v + 1] & 0xC0) == 0x80) {
                return v1 <= v + 2 || (arr_b[v + 2] & 0xC0) != 0x80 ? 2 : 3;
            }
            return 1;
        }
        int v2 = arr_b[v];
        int v3 = arr_b[v + 1];
        if((v3 & 0xC0) == 0x80) {
            int v4 = arr_b[v + 2];
            if((v4 & 0xC0) == 0x80) {
                int v5 = arr_b[v + 3];
                if((v5 & 0xC0) == 0x80) {
                    int v6 = v5 ^ 0x381F80 ^ v4 << 6 ^ v3 << 12 ^ v2 << 18;
                    if(v6 > 0x10FFFF) {
                        k0.invoke(0xFFFD);
                        return 4;
                    }
                    if(0xD800 <= v6 && v6 < 0xE000) {
                        k0.invoke(0xFFFD);
                        return 4;
                    }
                    if(v6 < 0x10000) {
                        k0.invoke(0xFFFD);
                        return 4;
                    }
                    k0.invoke(v6);
                    return 4;
                }
                k0.invoke(0xFFFD);
                return 3;
            }
            k0.invoke(0xFFFD);
            return 2;
        }
        k0.invoke(0xFFFD);
        return 1;
    }

    public static final void processUtf16Chars(@NotNull byte[] arr_b, int v, int v1, @NotNull k k0) {
        q.g(arr_b, "<this>");
        q.g(k0, "yield");
        while(v < v1) {
            int v2 = 2;
            int v3 = arr_b[v];
            if(v3 >= 0) {
                k0.invoke(Character.valueOf(((char)v3)));
                ++v;
                while(v < v1) {
                    int v4 = arr_b[v];
                    if(v4 < 0) {
                        break;
                    }
                    ++v;
                    k0.invoke(Character.valueOf(((char)v4)));
                }
            }
            else {
                if(v3 >> 5 == -2) {
                    if(v1 > v + 1) {
                        int v5 = arr_b[v + 1];
                        if((v5 & 0xC0) == 0x80) {
                            int v6 = v3 << 6 ^ (v5 ^ 0xF80);
                            k0.invoke(Character.valueOf((v6 >= 0x80 ? ((char)v6) : '\uFFFD')));
                            goto label_73;
                        }
                    }
                    k0.invoke(Character.valueOf('\uFFFD'));
                    v2 = 1;
                }
                else if(v3 >> 4 == -2) {
                    if(v1 <= v + 2) {
                        k0.invoke(Character.valueOf('\uFFFD'));
                        if(v1 > v + 1 && (arr_b[v + 1] & 0xC0) == 0x80) {
                            goto label_73;
                        }
                    }
                    else {
                        int v7 = arr_b[v + 1];
                        if((v7 & 0xC0) == 0x80) {
                            int v8 = arr_b[v + 2];
                            if((v8 & 0xC0) == 0x80) {
                                int v9 = v3 << 12 ^ (v8 ^ 0xFFFE1F80 ^ v7 << 6);
                                k0.invoke(Character.valueOf((v9 < 0x800 || 0xD800 <= v9 && v9 < 0xE000 ? '\uFFFD' : ((char)v9))));
                                v2 = 3;
                            }
                            else {
                                k0.invoke(Character.valueOf('\uFFFD'));
                            }
                            goto label_73;
                        }
                        else {
                            k0.invoke(Character.valueOf('\uFFFD'));
                        }
                    }
                    v2 = 1;
                }
                else if(v3 >> 3 != -2) {
                    goto label_75;
                }
                else if(v1 <= v + 3) {
                    k0.invoke(Character.valueOf('\uFFFD'));
                    if(v1 <= v + 1 || (arr_b[v + 1] & 0xC0) != 0x80) {
                        v2 = 1;
                    }
                    else if(v1 > v + 2 && (arr_b[v + 2] & 0xC0) == 0x80) {
                        v2 = 3;
                    }
                }
                else {
                    int v10 = arr_b[v + 1];
                    if((v10 & 0xC0) == 0x80) {
                        int v11 = arr_b[v + 2];
                        if((v11 & 0xC0) == 0x80) {
                            int v12 = arr_b[v + 3];
                            if((v12 & 0xC0) == 0x80) {
                                int v13 = v3 << 18 ^ (v12 ^ 0x381F80 ^ v11 << 6 ^ v10 << 12);
                                if(v13 > 0x10FFFF || (0xD800 <= v13 && v13 < 0xE000 || v13 < 0x10000 || v13 == 0xFFFD)) {
                                    k0.invoke(Character.valueOf('\uFFFD'));
                                }
                                else {
                                    k0.invoke(Character.valueOf(((char)((v13 >>> 10) + 0xD7C0))));
                                    k0.invoke(Character.valueOf(((char)((v13 & 0x3FF) + 0xDC00))));
                                }
                                v2 = 4;
                            }
                            else {
                                k0.invoke(Character.valueOf('\uFFFD'));
                                v2 = 3;
                            }
                        }
                        else {
                            k0.invoke(Character.valueOf('\uFFFD'));
                        }
                    }
                    else {
                        k0.invoke(Character.valueOf('\uFFFD'));
                        v2 = 1;
                    }
                }
            label_73:
                v += v2;
                continue;
            label_75:
                k0.invoke(Character.valueOf('\uFFFD'));
                ++v;
            }
        }
    }

    public static final void processUtf8Bytes(@NotNull String s, int v, int v1, @NotNull k k0) {
        q.g(s, "<this>");
        q.g(k0, "yield");
        while(v < v1) {
            int v2 = s.charAt(v);
            if(q.h(v2, 0x80) < 0) {
                k0.invoke(((byte)v2));
                ++v;
                while(v < v1 && q.h(s.charAt(v), 0x80) < 0) {
                    k0.invoke(((byte)s.charAt(v)));
                    ++v;
                }
            }
            else {
                if(q.h(v2, 0x800) < 0) {
                    k0.invoke(((byte)(v2 >> 6 | 0xC0)));
                    k0.invoke(((byte)(v2 & 0x3F | 0x80)));
                }
                else if(0xD800 > v2 || v2 >= 0xE000) {
                    k0.invoke(((byte)(v2 >> 12 | 0xE0)));
                    k0.invoke(((byte)(v2 >> 6 & 0x3F | 0x80)));
                    k0.invoke(((byte)(v2 & 0x3F | 0x80)));
                }
                else {
                    if(q.h(v2, 0xDBFF) <= 0 && v1 > v + 1) {
                        int v3 = s.charAt(v + 1);
                        if(0xDC00 <= v3 && v3 < 0xE000) {
                            int v4 = s.charAt(v + 1) + (v2 << 10) - 0x35FDC00;
                            k0.invoke(((byte)(v4 >> 18 | 0xF0)));
                            k0.invoke(((byte)(v4 >> 12 & 0x3F | 0x80)));
                            k0.invoke(((byte)(v4 >> 6 & 0x3F | 0x80)));
                            k0.invoke(((byte)(v4 & 0x3F | 0x80)));
                            v += 2;
                            continue;
                        }
                    }
                    k0.invoke(((byte)0x3F));
                }
                ++v;
            }
        }
    }

    public static final void processUtf8CodePoints(@NotNull byte[] arr_b, int v, int v1, @NotNull k k0) {
        q.g(arr_b, "<this>");
        q.g(k0, "yield");
        while(v < v1) {
            int v2 = 2;
            int v3 = arr_b[v];
            if(v3 >= 0) {
                k0.invoke(v3);
                ++v;
                while(v < v1) {
                    int v4 = arr_b[v];
                    if(v4 < 0) {
                        break;
                    }
                    ++v;
                    k0.invoke(v4);
                }
            }
            else {
                if(v3 >> 5 == -2) {
                    if(v1 > v + 1) {
                        int v5 = arr_b[v + 1];
                        if((v5 & 0xC0) == 0x80) {
                            int v6 = v3 << 6 ^ (v5 ^ 0xF80);
                            if(v6 < 0x80) {
                                k0.invoke(0xFFFD);
                            }
                            else {
                                k0.invoke(v6);
                            }
                            goto label_77;
                        }
                    }
                    k0.invoke(0xFFFD);
                    v2 = 1;
                }
                else if(v3 >> 4 == -2) {
                    if(v1 <= v + 2) {
                        k0.invoke(0xFFFD);
                        if(v1 > v + 1 && (arr_b[v + 1] & 0xC0) == 0x80) {
                            goto label_77;
                        }
                    }
                    else {
                        int v7 = arr_b[v + 1];
                        if((v7 & 0xC0) == 0x80) {
                            int v8 = arr_b[v + 2];
                            if((v8 & 0xC0) == 0x80) {
                                int v9 = v3 << 12 ^ (v8 ^ 0xFFFE1F80 ^ v7 << 6);
                                if(v9 < 0x800 || 0xD800 <= v9 && v9 < 0xE000) {
                                    k0.invoke(0xFFFD);
                                }
                                else {
                                    k0.invoke(v9);
                                }
                                goto label_53;
                            }
                            else {
                                k0.invoke(0xFFFD);
                                goto label_77;
                            }
                            goto label_45;
                        }
                        else {
                        label_45:
                            k0.invoke(0xFFFD);
                        }
                    }
                    v2 = 1;
                }
                else if(v3 >> 3 != -2) {
                    goto label_79;
                }
                else if(v1 <= v + 3) {
                    k0.invoke(0xFFFD);
                    if(v1 <= v + 1 || (arr_b[v + 1] & 0xC0) != 0x80) {
                        v2 = 1;
                    }
                    else if(v1 > v + 2 && (arr_b[v + 2] & 0xC0) == 0x80) {
                    label_53:
                        v2 = 3;
                    }
                }
                else {
                    int v10 = arr_b[v + 1];
                    if((v10 & 0xC0) == 0x80) {
                        int v11 = arr_b[v + 2];
                        if((v11 & 0xC0) == 0x80) {
                            int v12 = arr_b[v + 3];
                            if((v12 & 0xC0) == 0x80) {
                                int v13 = v3 << 18 ^ (v12 ^ 0x381F80 ^ v11 << 6 ^ v10 << 12);
                                if(v13 > 0x10FFFF || (0xD800 <= v13 && v13 < 0xE000 || v13 < 0x10000)) {
                                    k0.invoke(0xFFFD);
                                }
                                else {
                                    k0.invoke(v13);
                                }
                                v2 = 4;
                            }
                            else {
                                k0.invoke(0xFFFD);
                                v2 = 3;
                            }
                        }
                        else {
                            k0.invoke(0xFFFD);
                        }
                    }
                    else {
                        k0.invoke(0xFFFD);
                        v2 = 1;
                    }
                }
            label_77:
                v += v2;
                continue;
            label_79:
                k0.invoke(0xFFFD);
                ++v;
            }
        }
    }

    public static final long size(@NotNull String s) {
        q.g(s, "<this>");
        return Utf8.size$default(s, 0, 0, 3, null);
    }

    public static final long size(@NotNull String s, int v) {
        q.g(s, "<this>");
        return Utf8.size$default(s, v, 0, 2, null);
    }

    public static final long size(@NotNull String s, int v, int v1) {
        int v4;
        q.g(s, "<this>");
        if(v < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + v).toString());
        }
        if(v1 < v) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + v1 + " < " + v).toString());
        }
        if(v1 <= s.length()) {
            long v2 = 0L;
            while(v < v1) {
                int v3 = s.charAt(v);
                if(v3 < 0x80) {
                    ++v2;
                }
                else {
                    if(v3 < 0x800) {
                        v4 = 2;
                    }
                    else if(v3 < 0xD800 || v3 > 0xDFFF) {
                        v4 = 3;
                    }
                    else {
                        int v5 = v + 1 >= v1 ? 0 : s.charAt(v + 1);
                        if(v3 > 0xDBFF || v5 < 0xDC00 || v5 > 0xDFFF) {
                            ++v2;
                            ++v;
                        }
                        else {
                            v2 += 4L;
                            v += 2;
                        }
                        continue;
                    }
                    v2 += (long)v4;
                }
                ++v;
            }
            return v2;
        }
        StringBuilder stringBuilder0 = x.n(v1, "endIndex > string.length: ", " > ");
        stringBuilder0.append(s.length());
        throw new IllegalArgumentException(stringBuilder0.toString().toString());
    }

    public static long size$default(String s, int v, int v1, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = 0;
        }
        if((v2 & 2) != 0) {
            v1 = s.length();
        }
        return Utf8.size(s, v, v1);
    }
}

