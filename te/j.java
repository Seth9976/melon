package te;

import Tf.o;
import d5.w;
import d8.d;
import de.c;
import i.n.i.b.a.s.e.t8;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import je.n;
import kotlin.jvm.internal.q;

public abstract class j extends c {
    public static String A(File file0) {
        q.g(file0, "<this>");
        String s = file0.getName();
        q.f(s, "getName(...)");
        return o.Y0('.', s, "");
    }

    public static byte[] B(File file0) {
        byte[] arr_b;
        FileInputStream fileInputStream0 = new FileInputStream(file0);
        try {
            long v = file0.length();
            if(Long.compare(v, 0x7FFFFFFFL) > 0) {
                throw new OutOfMemoryError("File " + file0 + " is too big (" + v + " bytes) to fit in memory.");
            }
            arr_b = new byte[((int)v)];
            int v1 = (int)v;
            int v2;
            for(v2 = 0; v1 > 0; v2 += v3) {
                int v3 = fileInputStream0.read(arr_b, v2, v1);
                if(v3 < 0) {
                    break;
                }
                v1 -= v3;
            }
            if(v1 > 0) {
                arr_b = Arrays.copyOf(arr_b, v2);
                q.f(arr_b, "copyOf(...)");
            }
            else {
                int v4 = fileInputStream0.read();
                if(v4 != -1) {
                    a a0 = new a(0x2001);  // 初始化器: Ljava/io/ByteArrayOutputStream;-><init>(I)V
                    a0.write(v4);
                    w.t(fileInputStream0, a0);
                    int v5 = a0.size() + ((int)v);
                    if(v5 < 0) {
                        throw new OutOfMemoryError("File " + file0 + " is too big to fit in memory.");
                    }
                    byte[] arr_b1 = a0.h();
                    arr_b = Arrays.copyOf(arr_b, v5);
                    q.f(arr_b, "copyOf(...)");
                    n.T(arr_b1, ((int)v), 0, arr_b, a0.size());
                }
            }
        }
        catch(Throwable throwable0) {
            d.l(fileInputStream0, throwable0);
            throw throwable0;
        }
        fileInputStream0.close();
        return arr_b;
    }

    public static File C(File file0) {
        int v4;
        File file1 = new File("image_cache");
        q.f("image_cache", "getPath(...)");
        int v = File.separatorChar;
        int v1 = o.E0("image_cache", ((char)v), 0, 4);
        if(v1 != 0) {
            if(v1 <= 0 || "image_cache".charAt(v1 - 1) != 58) {
                v4 = v1 != -1 || !o.A0("image_cache", ':') ? 0 : 11;
            }
            else {
                v4 = v1 + 1;
            }
        }
        else if('m' == v) {
            int v2 = o.E0("image_cache", 'm', 2, 4);
            if(v2 >= 0) {
                int v3 = o.E0("image_cache", 'm', v2 + 1, 4);
                v4 = v3 >= 0 ? v3 + 1 : 11;
            }
            else {
                v4 = 1;
            }
        }
        else {
            v4 = 1;
        }
        if(v4 > 0) {
            return file1;
        }
        String s = file0.toString();
        q.f(s, "toString(...)");
        return s.length() == 0 || o.A0(s, ((char)v)) ? new File(s + file1) : new File(s + ((char)v) + file1);
    }

    public static void y(File file0, File file1, boolean z, int v) {
        if((v & 2) != 0) {
            z = false;
        }
        if(!file0.exists()) {
            throw new b(file0, null, "The source file doesn\'t exist.");  // 初始化器: Li/n/i/b/a/s/e/t8;-><init>(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V
        }
        if(file1.exists()) {
            if(!z) {
                throw new b(file0, file1, "The destination file already exists.");  // 初始化器: Li/n/i/b/a/s/e/t8;-><init>(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V
            }
            if(!file1.delete()) {
                throw new b(file0, file1, "Tried to overwrite the destination, but failed to delete it.");  // 初始化器: Li/n/i/b/a/s/e/t8;-><init>(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V
            }
        }
        if(file0.isDirectory()) {
            if(!file1.mkdirs()) {
                throw new t8(file0, file1, "Failed to create target directory.");
            }
            return;
        }
        File file2 = file1.getParentFile();
        if(file2 != null) {
            file2.mkdirs();
        }
        FileInputStream fileInputStream0 = new FileInputStream(file0);
        try {
            FileOutputStream fileOutputStream0 = new FileOutputStream(file1);
            try {
                w.t(fileInputStream0, fileOutputStream0);
            }
            catch(Throwable throwable1) {
                d.l(fileOutputStream0, throwable1);
                throw throwable1;
            }
            fileOutputStream0.close();
        }
        catch(Throwable throwable0) {
            d.l(fileInputStream0, throwable0);
            throw throwable0;
        }
        fileInputStream0.close();
    }

    public static void z(File file0) {
        g g0 = new g(new Sf.j(file0));
    alab1:
        while(true) {
            for(boolean z = true; true; z = false) {
                if(!g0.hasNext()) {
                    break alab1;
                }
                File file1 = (File)g0.next();
                if((file1.delete() || !file1.exists()) && z) {
                    break;
                }
            }
        }
    }
}

