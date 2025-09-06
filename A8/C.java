package a8;

import java.util.HashMap;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class c extends Enum {
    public final int[] a;
    public final String[] b;
    public static final HashMap c;
    public static final HashMap d;
    public static final c[] e;

    static {
        c.e = new c[]{new c("Cp437", 0, new int[]{0, 2}, new String[0]), new c("ISO8859_1", 1, new int[]{1, 3}, new String[]{"ISO-8859-1"}), new c("ISO8859_2", 2, 4, new String[]{"ISO-8859-2"}), new c("ISO8859_3", 3, 5, new String[]{"ISO-8859-3"}), new c("ISO8859_4", 4, 6, new String[]{"ISO-8859-4"}), new c("ISO8859_5", 5, 7, new String[]{"ISO-8859-5"}), new c("ISO8859_6", 6, 8, new String[]{"ISO-8859-6"}), new c("ISO8859_7", 7, 9, new String[]{"ISO-8859-7"}), new c("ISO8859_8", 8, 10, new String[]{"ISO-8859-8"}), new c("ISO8859_9", 9, 11, new String[]{"ISO-8859-9"}), new c("ISO8859_10", 10, 12, new String[]{"ISO-8859-10"}), new c("ISO8859_11", 11, 13, new String[]{"ISO-8859-11"}), new c("ISO8859_13", 12, 15, new String[]{"ISO-8859-13"}), new c("ISO8859_14", 13, 16, new String[]{"ISO-8859-14"}), new c("ISO8859_15", 14, 17, new String[]{"ISO-8859-15"}), new c("ISO8859_16", 15, 18, new String[]{"ISO-8859-16"}), new c("SJIS", 16, 20, new String[]{"Shift_JIS"}), new c("Cp1250", 17, 21, new String[]{"windows-1250"}), new c("Cp1251", 18, 22, new String[]{"windows-1251"}), new c("Cp1252", 19, 23, new String[]{"windows-1252"}), new c("Cp1256", 20, 24, new String[]{"windows-1256"}), new c("UnicodeBigUnmarked", 21, 25, new String[]{"UTF-16BE", "UnicodeBig"}), new c("UTF8", 22, 26, new String[]{"UTF-8"}), new c("ASCII", 23, new int[]{27, 170}, new String[]{"US-ASCII"}), new c("Big5", 24, new int[]{28}, new String[0]), new c("GB18030", 25, 29, new String[]{"GB2312", "EUC_CN", "GBK"}), new c("EUC_KR", 26, 30, new String[]{"EUC-KR"})};
        c.c = new HashMap();
        c.d = new HashMap();
        c[] arr_c = (c[])c.e.clone();
        for(int v = 0; v < arr_c.length; ++v) {
            c c0 = arr_c[v];
            int[] arr_v = c0.a;
            for(int v1 = 0; v1 < arr_v.length; ++v1) {
                c.c.put(((int)arr_v[v1]), c0);
            }
            c.d.put(c0.name(), c0);
            String[] arr_s = c0.b;
            for(int v2 = 0; v2 < arr_s.length; ++v2) {
                c.d.put(arr_s[v2], c0);
            }
        }
    }

    public c(String s, int v, int v1, String[] arr_s) {
        super(s, v);
        this.a = new int[]{v1};
        this.b = arr_s;
    }

    public c(String s, int v, int[] arr_v, String[] arr_s) {
        super(s, v);
        this.a = arr_v;
        this.b = arr_s;
    }

    public static c valueOf(String s) {
        return (c)Enum.valueOf(c.class, s);
    }

    public static c[] values() [...] // Inlined contents
}

