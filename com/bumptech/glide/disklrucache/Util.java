package com.bumptech.glide.disklrucache;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import jeb.synthetic.TWR;

final class Util {
    static final Charset US_ASCII;
    static final Charset UTF_8;

    static {
        Util.US_ASCII = Charset.forName("US-ASCII");
        Util.UTF_8 = Charset.forName("UTF-8");
    }

    public static void closeQuietly(Closeable closeable0) {
        if(closeable0 != null) {
            try {
                closeable0.close();
            }
            catch(RuntimeException runtimeException0) {
                throw runtimeException0;
            }
            catch(Exception unused_ex) {
            }
        }
    }

    public static void deleteContents(File file0) {
        File[] arr_file = file0.listFiles();
        if(arr_file == null) {
            throw new IOException("not a readable directory: " + file0);
        }
        for(int v = 0; v < arr_file.length; ++v) {
            File file1 = arr_file[v];
            if(file1.isDirectory()) {
                Util.deleteContents(file1);
            }
            if(!file1.delete()) {
                throw new IOException("failed to delete file: " + file1);
            }
        }
    }

    public static String readFully(Reader reader0) {
        try {
            StringWriter stringWriter0 = new StringWriter();
            char[] arr_c = new char[0x400];
            while(true) {
                reader0 = TWR.getResource$NT(reader0);
                TWR.declareResource(reader0);
                TWR.useResource$NT(reader0);
                int v = reader0.read(arr_c);
                if(v == -1) {
                    break;
                }
                TWR.useResource$NT(reader0);
                stringWriter0.write(arr_c, 0, v);
            }
            return stringWriter0.toString();
        }
        catch(Throwable throwable0) {
            TWR.moot$NT();
            throw throwable0;
        }
    }
}

