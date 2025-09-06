package w4;

import I.t0;
import U4.x;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build.VERSION;
import android.util.Log;
import e3.h;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import jeb.synthetic.TWR;
import k8.Y;

public abstract class c {
    public static final h a;
    public static final byte[] b;
    public static final byte[] c;
    public static final byte[] d;
    public static final byte[] e;
    public static final byte[] f;
    public static final byte[] g;
    public static final byte[] h;
    public static final byte[] i;
    public static final byte[] j;

    static {
        c.a = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
        c.b = new byte[]{0x70, 0x72, 0x6F, 0};
        c.c = new byte[]{0x70, 0x72, 109, 0};
        c.d = new byte[]{0x30, 49, 53, 0};
        c.e = new byte[]{0x30, 49, 0x30, 0};
        c.f = new byte[]{0x30, 0x30, 57, 0};
        c.g = new byte[]{0x30, 0x30, 53, 0};
        c.h = new byte[]{0x30, 0x30, 49, 0};
        c.i = new byte[]{0x30, 0x30, 49, 0};
        c.j = new byte[]{0x30, 0x30, 50, 0};
    }

    public static byte[] a(byte[] arr_b) {
        Deflater deflater0 = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        try(DeflaterOutputStream deflaterOutputStream0 = new DeflaterOutputStream(byteArrayOutputStream0, deflater0)) {
            deflaterOutputStream0.write(arr_b);
        }
        finally {
            deflater0.end();
        }
        return byteArrayOutputStream0.toByteArray();
    }

    public static byte[] b(a[] arr_a, byte[] arr_b) {
        int v = 0;
        int v2 = 0;
        for(int v1 = 0; v1 < arr_a.length; ++v1) {
            a a0 = arr_a[v1];
            byte[] arr_b1 = c.d(a0.a, a0.b, arr_b).getBytes(StandardCharsets.UTF_8);
            v2 += (a0.g * 2 + 7 & -8) / 8 + (a0.e * 2 + (arr_b1.length + 16) + a0.f);
        }
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream(v2);
        if(Arrays.equals(arr_b, c.f)) {
            while(v < arr_a.length) {
                a a1 = arr_a[v];
                c.q(byteArrayOutputStream0, a1, c.d(a1.a, a1.b, arr_b));
                c.p(byteArrayOutputStream0, a1);
                ++v;
            }
        }
        else {
            for(int v3 = 0; v3 < arr_a.length; ++v3) {
                a a2 = arr_a[v3];
                c.q(byteArrayOutputStream0, a2, c.d(a2.a, a2.b, arr_b));
            }
            while(v < arr_a.length) {
                c.p(byteArrayOutputStream0, arr_a[v]);
                ++v;
            }
        }
        if(byteArrayOutputStream0.size() != v2) {
            throw new IllegalStateException("The bytes saved do not match expectation. actual=" + byteArrayOutputStream0.size() + " expected=" + v2);
        }
        return byteArrayOutputStream0.toByteArray();
    }

    public static boolean c(File file0) {
        if(file0.isDirectory()) {
            File[] arr_file = file0.listFiles();
            if(arr_file == null) {
                return false;
            }
            boolean z = true;
            for(int v = 0; v < arr_file.length; ++v) {
                z = c.c(arr_file[v]) && z;
            }
            return z;
        }
        file0.delete();
        return true;
    }

    public static String d(String s, String s1, byte[] arr_b) {
        byte[] arr_b1 = c.h;
        boolean z = Arrays.equals(arr_b, arr_b1);
        byte[] arr_b2 = c.g;
        String s2 = "!";
        String s3 = !z && !Arrays.equals(arr_b, arr_b2) ? "!" : ":";
        if(s.length() <= 0) {
            if("!".equals(s3)) {
                return s1.replace(":", "!");
            }
            return ":".equals(s3) ? s1.replace("!", ":") : s1;
        }
        if(s1.equals("classes.dex")) {
            return s;
        }
        if(!s1.contains("!") && !s1.contains(":")) {
            if(!s1.endsWith(".apk")) {
                StringBuilder stringBuilder0 = Y.p(s);
                if(Arrays.equals(arr_b, arr_b1) || Arrays.equals(arr_b, arr_b2)) {
                    s2 = ":";
                }
                return x.m(stringBuilder0, s2, s1);
            }
            return s1;
        }
        if("!".equals(s3)) {
            return s1.replace(":", "!");
        }
        return ":".equals(s3) ? s1.replace("!", ":") : s1;
    }

    public static void e(PackageInfo packageInfo0, File file0) {
        File file1 = new File(file0, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
        try(DataOutputStream dataOutputStream0 = new DataOutputStream(new FileOutputStream(file1))) {
            dataOutputStream0.writeLong(packageInfo0.lastUpdateTime);
        }
        catch(IOException unused_ex) {
        }
    }

    public static byte[] f(InputStream inputStream0, int v) {
        byte[] arr_b = new byte[v];
        for(int v1 = 0; v1 < v; v1 += v2) {
            int v2 = inputStream0.read(arr_b, v1, v - v1);
            if(v2 < 0) {
                throw new IllegalStateException("Not enough bytes to read: " + v);
            }
        }
        return arr_b;
    }

    public static int[] g(ByteArrayInputStream byteArrayInputStream0, int v) {
        int[] arr_v = new int[v];
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += (int)c.m(byteArrayInputStream0, 2);
            arr_v[v1] = v2;
        }
        return arr_v;
    }

    public static byte[] h(FileInputStream fileInputStream0, int v, int v1) {
        int v3;
        Inflater inflater0 = new Inflater();
        try {
            byte[] arr_b = new byte[v1];
            byte[] arr_b1 = new byte[0x800];
            v3 = 0;
            int v4 = 0;
            while(!inflater0.finished() && !inflater0.needsDictionary() && v3 < v) {
                int v5 = fileInputStream0.read(arr_b1);
                if(v5 < 0) {
                    throw new IllegalStateException("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + v + " bytes");
                }
                inflater0.setInput(arr_b1, 0, v5);
                try {
                    v4 += inflater0.inflate(arr_b, v4, v1 - v4);
                    v3 += v5;
                }
                catch(DataFormatException dataFormatException0) {
                    throw new IllegalStateException(dataFormatException0.getMessage());
                }
            }
            if(v3 == v) {
                if(!inflater0.finished()) {
                    throw new IllegalStateException("Inflater did not finish");
                }
                return arr_b;
            }
        }
        finally {
            inflater0.end();
        }
        throw new IllegalStateException("Didn\'t read enough bytes during decompression. expected=" + v + " actual=" + v3);
    }

    public static a[] i(FileInputStream fileInputStream0, byte[] arr_b, byte[] arr_b1, a[] arr_a) {
        byte[] arr_b2 = c.i;
        if(Arrays.equals(arr_b, arr_b2)) {
            if(Arrays.equals(c.d, arr_b1)) {
                throw new IllegalStateException("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            }
            if(!Arrays.equals(arr_b, arr_b2)) {
                throw new IllegalStateException("Unsupported meta version");
            }
            int v = (int)c.m(fileInputStream0, 1);
            long v1 = c.m(fileInputStream0, 4);
            byte[] arr_b3 = c.h(fileInputStream0, ((int)c.m(fileInputStream0, 4)), ((int)v1));
            if(fileInputStream0.read() <= 0) {
                try(ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(arr_b3)) {
                    return c.j(byteArrayInputStream0, v, arr_a);
                }
            }
            throw new IllegalStateException("Content found after the end of file");
        }
        if(!Arrays.equals(arr_b, c.j)) {
            throw new IllegalStateException("Unsupported meta version");
        }
        int v2 = (int)c.m(fileInputStream0, 2);
        long v3 = c.m(fileInputStream0, 4);
        byte[] arr_b4 = c.h(fileInputStream0, ((int)c.m(fileInputStream0, 4)), ((int)v3));
        if(fileInputStream0.read() <= 0) {
            try(ByteArrayInputStream byteArrayInputStream1 = new ByteArrayInputStream(arr_b4)) {
                return c.k(byteArrayInputStream1, arr_b1, v2, arr_a);
            }
        }
        throw new IllegalStateException("Content found after the end of file");
    }

    public static a[] j(ByteArrayInputStream byteArrayInputStream0, int v, a[] arr_a) {
        if(byteArrayInputStream0.available() == 0) {
            return new a[0];
        }
        if(v != arr_a.length) {
            throw new IllegalStateException("Mismatched number of dex files found in metadata");
        }
        String[] arr_s = new String[v];
        int[] arr_v = new int[v];
        for(int v2 = 0; v2 < v; ++v2) {
            int v3 = (int)c.m(byteArrayInputStream0, 2);
            arr_v[v2] = (int)c.m(byteArrayInputStream0, 2);
            arr_s[v2] = new String(c.f(byteArrayInputStream0, v3), StandardCharsets.UTF_8);
        }
        for(int v1 = 0; v1 < v; ++v1) {
            a a0 = arr_a[v1];
            if(!a0.b.equals(arr_s[v1])) {
                throw new IllegalStateException("Order of dexfiles in metadata did not match baseline");
            }
            int v4 = arr_v[v1];
            a0.e = v4;
            a0.h = c.g(byteArrayInputStream0, v4);
        }
        return arr_a;
    }

    public static a[] k(ByteArrayInputStream byteArrayInputStream0, byte[] arr_b, int v, a[] arr_a) {
        if(byteArrayInputStream0.available() == 0) {
            return new a[0];
        }
        if(v != arr_a.length) {
            throw new IllegalStateException("Mismatched number of dex files found in metadata");
        }
        for(int v1 = 0; v1 < v; ++v1) {
            c.m(byteArrayInputStream0, 2);
            String s = new String(c.f(byteArrayInputStream0, ((int)c.m(byteArrayInputStream0, 2))), StandardCharsets.UTF_8);
            long v2 = c.m(byteArrayInputStream0, 4);
            int v3 = (int)c.m(byteArrayInputStream0, 2);
            a a0 = null;
            if(arr_a.length > 0) {
                int v4 = s.indexOf("!") >= 0 ? s.indexOf("!") : s.indexOf(":");
                String s1 = v4 <= 0 ? s : s.substring(v4 + 1);
                for(int v5 = 0; v5 < arr_a.length; ++v5) {
                    if(arr_a[v5].b.equals(s1)) {
                        a0 = arr_a[v5];
                        break;
                    }
                }
            }
            if(a0 == null) {
                throw new IllegalStateException("Missing profile key: " + s);
            }
            a0.d = v2;
            int[] arr_v = c.g(byteArrayInputStream0, v3);
            if(Arrays.equals(arr_b, c.h)) {
                a0.e = v3;
                a0.h = arr_v;
            }
        }
        return arr_a;
    }

    public static a[] l(FileInputStream fileInputStream0, byte[] arr_b, String s) {
        if(!Arrays.equals(arr_b, c.e)) {
            throw new IllegalStateException("Unsupported version");
        }
        int v = (int)c.m(fileInputStream0, 1);
        long v1 = c.m(fileInputStream0, 4);
        byte[] arr_b1 = c.h(fileInputStream0, ((int)c.m(fileInputStream0, 4)), ((int)v1));
        if(fileInputStream0.read() <= 0) {
            try(ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(arr_b1)) {
                return c.n(byteArrayInputStream0, s, v);
            }
        }
        throw new IllegalStateException("Content found after the end of file");
    }

    public static long m(InputStream inputStream0, int v) {
        byte[] arr_b = c.f(inputStream0, v);
        long v1 = 0L;
        for(int v2 = 0; v2 < v; ++v2) {
            v1 += ((long)(arr_b[v2] & 0xFF)) << v2 * 8;
        }
        return v1;
    }

    public static a[] n(ByteArrayInputStream byteArrayInputStream0, String s, int v) {
        if(byteArrayInputStream0.available() == 0) {
            return new a[0];
        }
        a[] arr_a = new a[v];
        for(int v1 = 0; v1 < v; ++v1) {
            int v2 = (int)c.m(byteArrayInputStream0, 2);
            int v3 = (int)c.m(byteArrayInputStream0, 2);
            long v4 = c.m(byteArrayInputStream0, 4);
            long v5 = c.m(byteArrayInputStream0, 4);
            long v6 = c.m(byteArrayInputStream0, 4);
            String s1 = new String(c.f(byteArrayInputStream0, v2), StandardCharsets.UTF_8);
            TreeMap treeMap0 = new TreeMap();
            arr_a[v1] = new a(s, s1, v5, v3, ((int)v4), ((int)v6), new int[v3], treeMap0);
        }
        for(int v7 = 0; v7 < v; ++v7) {
            a a0 = arr_a[v7];
            int v8 = byteArrayInputStream0.available();
            int v9 = a0.g;
            TreeMap treeMap1 = a0.i;
            int v10 = v8 - a0.f;
            int v11 = 0;
            while(byteArrayInputStream0.available() > v10) {
                v11 += (int)c.m(byteArrayInputStream0, 2);
                treeMap1.put(v11, 1);
                for(int v12 = (int)c.m(byteArrayInputStream0, 2); v12 > 0; --v12) {
                    c.m(byteArrayInputStream0, 2);
                    int v13 = (int)c.m(byteArrayInputStream0, 1);
                    if(v13 != 6 && v13 != 7) {
                        while(v13 > 0) {
                            c.m(byteArrayInputStream0, 1);
                            for(int v14 = (int)c.m(byteArrayInputStream0, 1); v14 > 0; --v14) {
                                c.m(byteArrayInputStream0, 2);
                            }
                            --v13;
                        }
                    }
                }
            }
            if(byteArrayInputStream0.available() != v10) {
                throw new IllegalStateException("Read too much data during profile line parse");
            }
            a0.h = c.g(byteArrayInputStream0, a0.e);
            BitSet bitSet0 = BitSet.valueOf(c.f(byteArrayInputStream0, (v9 * 2 + 7 & -8) / 8));
            for(int v15 = 0; v15 < v9; ++v15) {
                int v16 = bitSet0.get(v15) ? 2 : 0;
                if(bitSet0.get(v15 + v9)) {
                    v16 |= 4;
                }
                if(v16 != 0) {
                    Integer integer0 = (Integer)treeMap1.get(v15);
                    if(integer0 == null) {
                        integer0 = 0;
                    }
                    treeMap1.put(v15, ((int)(v16 | ((int)integer0))));
                }
            }
        }
        return arr_a;
    }

    public static boolean o(ByteArrayOutputStream byteArrayOutputStream0, byte[] arr_b, a[] arr_a) {
        int v14;
        ArrayList arrayList3;
        long v13;
        w4.h h2;
        ArrayList arrayList2;
        byte[] arr_b6;
        byte[] arr_b5;
        w4.h h1;
        w4.h h0;
        ArrayList arrayList1;
        ArrayList arrayList0;
        byte[] arr_b1 = c.d;
        if(Arrays.equals(arr_b, arr_b1)) {
            arrayList0 = new ArrayList(3);
            arrayList1 = new ArrayList(3);
            try(ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream()) {
                c.v(byteArrayOutputStream1, arr_a.length);
                int v1 = 2;
                for(int v = 0; true; ++v) {
                    if(v >= arr_a.length) {
                        break;
                    }
                    a a0 = arr_a[v];
                    c.u(byteArrayOutputStream1, a0.c, 4);
                    c.u(byteArrayOutputStream1, a0.d, 4);
                    c.u(byteArrayOutputStream1, ((long)a0.g), 4);
                    String s = c.d(a0.a, a0.b, arr_b1);
                    Charset charset0 = StandardCharsets.UTF_8;
                    byte[] arr_b2 = s.getBytes(charset0);
                    c.v(byteArrayOutputStream1, arr_b2.length);
                    v1 = v1 + 14 + arr_b2.length;
                    byteArrayOutputStream1.write(s.getBytes(charset0));
                }
                byte[] arr_b3 = byteArrayOutputStream1.toByteArray();
                if(v1 != arr_b3.length) {
                    throw new IllegalStateException("Expected size " + v1 + ", does not match actual size " + arr_b3.length);
                }
                h0 = new w4.h(arr_b3, 1, false);
            }
            arrayList0.add(h0);
            try(ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream()) {
                int v3 = 0;
                for(int v2 = 0; true; ++v2) {
                    if(v2 >= arr_a.length) {
                        break;
                    }
                    a a1 = arr_a[v2];
                    c.v(byteArrayOutputStream2, v2);
                    c.v(byteArrayOutputStream2, a1.e);
                    v3 = v3 + 4 + a1.e * 2;
                    int[] arr_v = a1.h;
                    int v5 = 0;
                    for(int v4 = 0; true; v4 = v6) {
                        if(v5 >= arr_v.length) {
                            break;
                        }
                        int v6 = arr_v[v5];
                        c.v(byteArrayOutputStream2, v6 - v4);
                        ++v5;
                    }
                }
                byte[] arr_b4 = byteArrayOutputStream2.toByteArray();
                if(v3 != arr_b4.length) {
                    throw new IllegalStateException("Expected size " + v3 + ", does not match actual size " + arr_b4.length);
                }
                h1 = new w4.h(arr_b4, 3, true);
            }
            arrayList0.add(h1);
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            int v8 = 0;
            try {
                for(int v7 = 0; v7 < arr_a.length; ++v7) {
                    a a2 = arr_a[v7];
                    int v9 = 0;
                    for(Object object0: a2.i.entrySet()) {
                        v9 |= (int)(((Integer)((Map.Entry)object0).getValue()));
                    }
                    ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                    try {
                        c.r(byteArrayOutputStream4, v9, a2);
                        arr_b5 = byteArrayOutputStream4.toByteArray();
                    }
                    catch(Throwable throwable3) {
                        TWR.safeClose$NT(byteArrayOutputStream4, throwable3);
                        throw throwable3;
                    }
                    byteArrayOutputStream4.close();
                    ByteArrayOutputStream byteArrayOutputStream5 = new ByteArrayOutputStream();
                    try {
                        c.s(byteArrayOutputStream5, a2);
                        arr_b6 = byteArrayOutputStream5.toByteArray();
                    }
                    catch(Throwable throwable4) {
                        TWR.safeClose$NT(byteArrayOutputStream5, throwable4);
                        throw throwable4;
                    }
                    byteArrayOutputStream5.close();
                    c.v(byteArrayOutputStream3, v7);
                    int v10 = arr_b5.length + 2 + arr_b6.length;
                    c.u(byteArrayOutputStream3, ((long)v10), 4);
                    c.v(byteArrayOutputStream3, v9);
                    byteArrayOutputStream3.write(arr_b5);
                    byteArrayOutputStream3.write(arr_b6);
                    v8 = v8 + 6 + v10;
                }
                arrayList2 = arrayList1;
                byte[] arr_b7 = byteArrayOutputStream3.toByteArray();
                if(v8 != arr_b7.length) {
                    throw new IllegalStateException("Expected size " + v8 + ", does not match actual size " + arr_b7.length);
                }
                h2 = new w4.h(arr_b7, 4, true);
            }
            catch(Throwable throwable2) {
                TWR.safeClose$NT(byteArrayOutputStream3, throwable2);
                throw throwable2;
            }
            byteArrayOutputStream3.close();
            arrayList0.add(h2);
            long v11 = 12L + ((long)(arrayList0.size() * 16));
            c.u(byteArrayOutputStream0, ((long)arrayList0.size()), 4);
            int v12 = 0;
            while(v12 < arrayList0.size()) {
                w4.h h3 = (w4.h)arrayList0.get(v12);
                byte[] arr_b8 = h3.b;
                switch(h3.a) {
                    case 1: {
                        v13 = 0L;
                        break;
                    }
                    case 2: {
                        v13 = 1L;
                        break;
                    }
                    case 3: {
                        v13 = 2L;
                        break;
                    }
                    case 4: {
                        v13 = 3L;
                        break;
                    }
                    case 5: {
                        v13 = 4L;
                        break;
                    }
                    default: {
                        throw null;
                    }
                }
                c.u(byteArrayOutputStream0, v13, 4);
                c.u(byteArrayOutputStream0, v11, 4);
                if(h3.c) {
                    byte[] arr_b9 = c.a(arr_b8);
                    arrayList3 = arrayList2;
                    arrayList3.add(arr_b9);
                    c.u(byteArrayOutputStream0, ((long)arr_b9.length), 4);
                    c.u(byteArrayOutputStream0, ((long)arr_b8.length), 4);
                    v14 = arr_b9.length;
                }
                else {
                    arrayList3 = arrayList2;
                    arrayList3.add(arr_b8);
                    c.u(byteArrayOutputStream0, ((long)arr_b8.length), 4);
                    c.u(byteArrayOutputStream0, 0L, 4);
                    v14 = arr_b8.length;
                }
                v11 += (long)v14;
                ++v12;
                arrayList2 = arrayList3;
            }
            for(int v15 = 0; v15 < arrayList2.size(); ++v15) {
                byteArrayOutputStream0.write(((byte[])arrayList2.get(v15)));
            }
            return true;
        }
        byte[] arr_b10 = c.e;
        if(Arrays.equals(arr_b, arr_b10)) {
            byte[] arr_b11 = c.b(arr_a, arr_b10);
            c.u(byteArrayOutputStream0, ((long)arr_a.length), 1);
            c.u(byteArrayOutputStream0, ((long)arr_b11.length), 4);
            byte[] arr_b12 = c.a(arr_b11);
            c.u(byteArrayOutputStream0, ((long)arr_b12.length), 4);
            byteArrayOutputStream0.write(arr_b12);
            return true;
        }
        byte[] arr_b13 = c.g;
        if(Arrays.equals(arr_b, arr_b13)) {
            c.u(byteArrayOutputStream0, ((long)arr_a.length), 1);
            for(int v16 = 0; v16 < arr_a.length; ++v16) {
                a a3 = arr_a[v16];
                String s1 = c.d(a3.a, a3.b, arr_b13);
                Charset charset1 = StandardCharsets.UTF_8;
                c.v(byteArrayOutputStream0, s1.getBytes(charset1).length);
                c.v(byteArrayOutputStream0, a3.h.length);
                c.u(byteArrayOutputStream0, ((long)(a3.i.size() * 4)), 4);
                c.u(byteArrayOutputStream0, a3.c, 4);
                byteArrayOutputStream0.write(s1.getBytes(charset1));
                for(Object object1: a3.i.keySet()) {
                    c.v(byteArrayOutputStream0, ((int)(((Integer)object1))));
                    c.v(byteArrayOutputStream0, 0);
                }
                int[] arr_v1 = a3.h;
                for(int v17 = 0; v17 < arr_v1.length; ++v17) {
                    c.v(byteArrayOutputStream0, arr_v1[v17]);
                }
            }
            return true;
        }
        byte[] arr_b14 = c.f;
        if(Arrays.equals(arr_b, arr_b14)) {
            byte[] arr_b15 = c.b(arr_a, arr_b14);
            c.u(byteArrayOutputStream0, ((long)arr_a.length), 1);
            c.u(byteArrayOutputStream0, ((long)arr_b15.length), 4);
            byte[] arr_b16 = c.a(arr_b15);
            c.u(byteArrayOutputStream0, ((long)arr_b16.length), 4);
            byteArrayOutputStream0.write(arr_b16);
            return true;
        }
        byte[] arr_b17 = c.h;
        if(Arrays.equals(arr_b, arr_b17)) {
            c.v(byteArrayOutputStream0, arr_a.length);
            for(int v18 = 0; v18 < arr_a.length; ++v18) {
                a a4 = arr_a[v18];
                String s2 = c.d(a4.a, a4.b, arr_b17);
                Charset charset2 = StandardCharsets.UTF_8;
                c.v(byteArrayOutputStream0, s2.getBytes(charset2).length);
                c.v(byteArrayOutputStream0, a4.i.size());
                c.v(byteArrayOutputStream0, a4.h.length);
                c.u(byteArrayOutputStream0, a4.c, 4);
                byteArrayOutputStream0.write(s2.getBytes(charset2));
                for(Object object2: a4.i.keySet()) {
                    c.v(byteArrayOutputStream0, ((int)(((Integer)object2))));
                }
                int[] arr_v2 = a4.h;
                for(int v19 = 0; v19 < arr_v2.length; ++v19) {
                    c.v(byteArrayOutputStream0, arr_v2[v19]);
                }
            }
            return true;
        }
        return false;
    }

    public static void p(ByteArrayOutputStream byteArrayOutputStream0, a a0) {
        c.s(byteArrayOutputStream0, a0);
        int v = a0.g;
        int[] arr_v = a0.h;
        int v1 = 0;
        for(int v2 = 0; v1 < arr_v.length; v2 = v3) {
            int v3 = arr_v[v1];
            c.v(byteArrayOutputStream0, v3 - v2);
            ++v1;
        }
        byte[] arr_b = new byte[(v * 2 + 7 & -8) / 8];
        for(Object object0: a0.i.entrySet()) {
            int v4 = (int)(((Integer)((Map.Entry)object0).getKey()));
            int v5 = (int)(((Integer)((Map.Entry)object0).getValue()));
            if((v5 & 2) != 0) {
                arr_b[v4 / 8] = (byte)(arr_b[v4 / 8] | 1 << v4 % 8);
            }
            if((v5 & 4) != 0) {
                int v6 = v4 + v;
                arr_b[v6 / 8] = (byte)(1 << v6 % 8 | arr_b[v6 / 8]);
            }
        }
        byteArrayOutputStream0.write(arr_b);
    }

    public static void q(ByteArrayOutputStream byteArrayOutputStream0, a a0, String s) {
        Charset charset0 = StandardCharsets.UTF_8;
        c.v(byteArrayOutputStream0, s.getBytes(charset0).length);
        c.v(byteArrayOutputStream0, a0.e);
        c.u(byteArrayOutputStream0, ((long)a0.f), 4);
        c.u(byteArrayOutputStream0, a0.c, 4);
        c.u(byteArrayOutputStream0, ((long)a0.g), 4);
        byteArrayOutputStream0.write(s.getBytes(charset0));
    }

    public static void r(ByteArrayOutputStream byteArrayOutputStream0, int v, a a0) {
        int v1 = a0.g;
        byte[] arr_b = new byte[(Integer.bitCount(v & -2) * v1 + 7 & -8) / 8];
        for(Object object0: a0.i.entrySet()) {
            int v2 = (int)(((Integer)((Map.Entry)object0).getKey()));
            int v3 = (int)(((Integer)((Map.Entry)object0).getValue()));
            int v4 = 0;
            for(int v5 = 1; v5 <= 4; v5 <<= 1) {
                if(v5 != 1 && (v5 & v) != 0) {
                    if((v5 & v3) == v5) {
                        int v6 = v4 * v1 + v2;
                        arr_b[v6 / 8] = (byte)(1 << v6 % 8 | arr_b[v6 / 8]);
                    }
                    ++v4;
                }
            }
        }
        byteArrayOutputStream0.write(arr_b);
    }

    public static void s(ByteArrayOutputStream byteArrayOutputStream0, a a0) {
        int v = 0;
        for(Object object0: a0.i.entrySet()) {
            int v1 = (int)(((Integer)((Map.Entry)object0).getKey()));
            if((((int)(((Integer)((Map.Entry)object0).getValue()))) & 1) != 0) {
                c.v(byteArrayOutputStream0, v1 - v);
                c.v(byteArrayOutputStream0, 0);
                v = v1;
            }
        }
    }

    public static void t(Context context0, Executor executor0, b b0, boolean z) {
        FileInputStream fileInputStream0;
        int v2;
        t0 t01;
        a[] arr_a;
        int v;
        PackageInfo packageInfo0;
        Context context1 = context0.getApplicationContext();
        ApplicationInfo applicationInfo0 = context1.getApplicationInfo();
        AssetManager assetManager0 = context1.getAssets();
        String s = new File(applicationInfo0.sourceDir).getName();
        PackageManager packageManager0 = context0.getPackageManager();
        try {
            packageInfo0 = packageManager0.getPackageInfo("com.iloen.melon", 0);
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            b0.f(7, packageManager$NameNotFoundException0);
            g.c(context0, false);
            return;
        }
        File file0 = context0.getFilesDir();
        if(!z) {
            File file1 = new File(file0, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
            boolean z1 = false;
            if(file1.exists()) {
                try(DataInputStream dataInputStream0 = new DataInputStream(new FileInputStream(file1))) {
                    if(dataInputStream0.readLong() == packageInfo0.lastUpdateTime) {
                        goto label_20;
                    }
                }
                catch(IOException unused_ex) {
                }
                goto label_22;
            label_20:
                z1 = true;
                b0.f(2, null);
            }
        label_22:
            if(z1) {
                Log.d("ProfileInstaller", "Skipping profile installation for com.iloen.melon");
                g.c(context0, false);
                return;
            }
        }
        Log.d("ProfileInstaller", "Installing profile for com.iloen.melon");
        File file2 = new File(new File("/data/misc/profiles/cur/0", "com.iloen.melon"), "primary.prof");
        t0 t00 = new t0(assetManager0, executor0, b0, s, file2);
        byte[] arr_b = (byte[])t00.d;
        if(arr_b == null) {
            t00.i(Build.VERSION.SDK_INT, 3);
            v = 0;
        }
        else if(!file2.exists()) {
            try {
                if(file2.createNewFile()) {
                    t00.a = true;
                    fileInputStream0 = t00.g(assetManager0, "dexopt/baseline.prof");
                    goto label_56;
                }
                else {
                    t00.i(null, 4);
                    v = 0;
                }
            }
            catch(IOException unused_ex) {
                t00.i(null, 4);
                v = 0;
            }
            g.c(context0, v != 0 && z);
            return;
            try {
                t00.a = true;
                fileInputStream0 = t00.g(assetManager0, "dexopt/baseline.prof");
                goto label_56;
            }
            catch(FileNotFoundException fileNotFoundException0) {
            label_51:
                b0.f(6, fileNotFoundException0);
            }
            catch(IOException iOException0) {
            label_54:
                b0.f(7, iOException0);
            }
            fileInputStream0 = null;
        label_56:
            byte[] arr_b1 = c.b;
            if(fileInputStream0 != null) {
                try {
                    try {
                        if(!Arrays.equals(arr_b1, c.f(fileInputStream0, 4))) {
                            throw new IllegalStateException("Invalid magic");
                        }
                        arr_a = c.l(fileInputStream0, c.f(fileInputStream0, 4), ((String)t00.f));
                        goto label_79;
                    }
                    catch(IOException iOException1) {
                        b0.f(7, iOException1);
                    }
                    catch(IllegalStateException illegalStateException0) {
                        b0.f(8, illegalStateException0);
                    }
                }
                catch(Throwable throwable0) {
                    goto label_74;
                }
                try {
                    fileInputStream0.close();
                }
                catch(IOException iOException2) {
                    b0.f(7, iOException2);
                }
                arr_a = null;
                goto label_83;
                try {
                label_74:
                    fileInputStream0.close();
                }
                catch(IOException iOException3) {
                    b0.f(7, iOException3);
                }
                throw throwable0;
                try {
                label_79:
                    fileInputStream0.close();
                }
                catch(IOException iOException4) {
                    b0.f(7, iOException4);
                }
            label_83:
                t00.g = arr_a;
            }
            a[] arr_a1 = (a[])t00.g;
            if(arr_a1 != null && Build.VERSION.SDK_INT >= 0x1F) {
                try(FileInputStream fileInputStream1 = t00.g(assetManager0, "dexopt/baseline.profm")) {
                    if(fileInputStream1 == null) {
                        goto label_107;
                    }
                    else {
                        byte[] arr_b2 = c.f(fileInputStream1, 4);
                        if(!Arrays.equals(c.c, arr_b2)) {
                            throw new IllegalStateException("Invalid magic");
                        }
                        t00.g = c.i(fileInputStream1, c.f(fileInputStream1, 4), arr_b, arr_a1);
                        t01 = t00;
                    }
                    goto label_108;
                }
                catch(FileNotFoundException fileNotFoundException1) {
                    b0.f(9, fileNotFoundException1);
                }
                catch(IOException iOException5) {
                    b0.f(7, iOException5);
                }
                catch(IllegalStateException illegalStateException1) {
                    t00.g = null;
                    b0.f(8, illegalStateException1);
                }
            label_107:
                t01 = null;
            label_108:
                if(t01 != null) {
                    t00 = t01;
                }
            }
            b b1 = (b)t00.c;
            a[] arr_a2 = (a[])t00.g;
            byte[] arr_b3 = (byte[])t00.d;
            if(arr_a2 != null && arr_b3 != null) {
                if(!t00.a) {
                    throw new IllegalStateException("This device doesn\'t support aot. Did you call deviceSupportsAotProfile()?");
                }
                try(ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream()) {
                    byteArrayOutputStream0.write(arr_b1);
                    byteArrayOutputStream0.write(arr_b3);
                    if(c.o(byteArrayOutputStream0, arr_b3, arr_a2)) {
                        t00.h = byteArrayOutputStream0.toByteArray();
                        goto label_133;
                    }
                    else {
                        b1.f(5, null);
                        t00.g = null;
                    }
                    goto label_136;
                }
                catch(IOException iOException6) {
                    b1.f(7, iOException6);
                }
                catch(IllegalStateException illegalStateException2) {
                    b1.f(8, illegalStateException2);
                }
            label_133:
                t00.g = null;
            }
        label_136:
            byte[] arr_b4 = (byte[])t00.h;
            if(arr_b4 == null) {
                v2 = 0;
            }
            else {
                if(t00.a) {
                    try {
                        try(ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(arr_b4); FileOutputStream fileOutputStream0 = new FileOutputStream(((File)t00.e)); FileChannel fileChannel0 = fileOutputStream0.getChannel(); FileLock fileLock0 = fileChannel0.tryLock()) {
                            if(fileLock0 == null) {
                                throw new IOException("Unable to acquire a lock on the underlying file channel.");
                            }
                            if(!fileLock0.isValid()) {
                                throw new IOException("Unable to acquire a lock on the underlying file channel.");
                            }
                            byte[] arr_b5 = new byte[0x200];
                            int v1;
                            while((v1 = byteArrayInputStream0.read(arr_b5)) > 0) {
                                fileOutputStream0.write(arr_b5, 0, v1);
                            }
                            t00.i(null, 1);
                            t00.h = null;
                            t00.g = null;
                            v2 = 1;
                            goto label_211;
                        }
                        catch(FileNotFoundException fileNotFoundException2) {
                            t00.i(fileNotFoundException2, 6);
                        }
                        catch(IOException iOException7) {
                            t00.i(iOException7, 7);
                        }
                        t00.h = null;
                        t00.g = null;
                        v2 = 0;
                        goto label_211;
                    }
                    catch(Throwable throwable1) {
                        t00.h = null;
                        t00.g = null;
                        throw throwable1;
                    }
                }
                throw new IllegalStateException("This device doesn\'t support aot. Did you call deviceSupportsAotProfile()?");
            }
        label_211:
            if(v2 != 0) {
                c.e(packageInfo0, file0);
            }
            v = v2;
        }
        else if(file2.canWrite()) {
            try {
                t00.a = true;
                fileInputStream0 = t00.g(assetManager0, "dexopt/baseline.prof");
                goto label_56;
            }
            catch(FileNotFoundException fileNotFoundException0) {
                goto label_51;
            }
            catch(IOException iOException0) {
                goto label_54;
            }
        }
        else {
            t00.i(null, 4);
            v = 0;
        }
        g.c(context0, v != 0 && z);
    }

    public static void u(ByteArrayOutputStream byteArrayOutputStream0, long v, int v1) {
        byte[] arr_b = new byte[v1];
        for(int v2 = 0; v2 < v1; ++v2) {
            arr_b[v2] = (byte)(((int)(v >> v2 * 8 & 0xFFL)));
        }
        byteArrayOutputStream0.write(arr_b);
    }

    public static void v(ByteArrayOutputStream byteArrayOutputStream0, int v) {
        c.u(byteArrayOutputStream0, ((long)v), 2);
    }
}

