package pf;

public abstract class a {
    static {
        String s = null;
        try {
            s = System.getProperty("kotlin.jvm.serialization.use8to7");
        }
        catch(SecurityException unused_ex) {
        }
        "true".equals(s);
    }

    public static byte[] a(String[] arr_s) {
        if(arr_s == null) {
            throw new IllegalArgumentException("Argument for @NotNull parameter \'data\' of kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding.decodeBytes must not be null");
        }
        if(arr_s.length > 0 && !arr_s[0].isEmpty()) {
            int v = arr_s[0].charAt(0);
            if(v == 0) {
                String[] arr_s1 = (String[])arr_s.clone();
                arr_s1[0] = arr_s1[0].substring(1);
                int v2 = 0;
                for(int v1 = 0; v1 < arr_s1.length; ++v1) {
                    v2 += arr_s1[v1].length();
                }
                byte[] arr_b = new byte[v2];
                for(int v3 = 0; v3 < arr_s1.length; ++v3) {
                    String s = arr_s1[v3];
                    int v5 = s.length();
                    int v6 = 0;
                    for(int v4 = 0; v6 < v5; ++v4) {
                        arr_b[v4] = (byte)s.charAt(v6);
                        ++v6;
                    }
                }
                return arr_b;
            }
            if(v == 0xFFFF) {
                arr_s = (String[])arr_s.clone();
                arr_s[0] = arr_s[0].substring(1);
            }
        }
        int v8 = 0;
        for(int v7 = 0; v7 < arr_s.length; ++v7) {
            v8 += arr_s[v7].length();
        }
        byte[] arr_b1 = new byte[v8];
        for(int v9 = 0; v9 < arr_s.length; ++v9) {
            String s1 = arr_s[v9];
            int v11 = s1.length();
            int v12 = 0;
            for(int v10 = 0; v12 < v11; ++v10) {
                arr_b1[v10] = (byte)s1.charAt(v12);
                ++v12;
            }
        }
        for(int v13 = 0; v13 < v8; ++v13) {
            arr_b1[v13] = (byte)(arr_b1[v13] + 0x7F & 0x7F);
        }
        int v14 = v8 * 7 / 8;
        byte[] arr_b2 = new byte[v14];
        int v16 = 0;
        int v17 = 0;
        for(int v15 = 0; v15 < v14; ++v15) {
            arr_b2[v15] = (byte)(((arr_b1[v16] & 0xFF) >>> v17) + ((arr_b1[v16 + 1] & (1 << v17 + 1) - 1) << 7 - v17));
            if(v17 == 6) {
                v16 += 2;
                v17 = 0;
            }
            else {
                ++v16;
                ++v17;
            }
        }
        return arr_b2;
    }
}

