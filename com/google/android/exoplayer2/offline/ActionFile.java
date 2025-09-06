package com.google.android.exoplayer2.offline;

import android.net.Uri;
import com.google.android.exoplayer2.util.AtomicFile;
import com.google.android.exoplayer2.util.Util;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

@Deprecated
final class ActionFile {
    private static final int VERSION;
    private final AtomicFile atomicFile;

    public ActionFile(File file0) {
        this.atomicFile = new AtomicFile(file0);
    }

    public void delete() {
        this.atomicFile.delete();
    }

    public boolean exists() {
        return this.atomicFile.exists();
    }

    private static String generateDownloadId(Uri uri0, String s) {
        return s == null ? uri0.toString() : s;
    }

    public DownloadRequest[] load() {
        int v1;
        InputStream inputStream0;
        if(!this.exists()) {
            return new DownloadRequest[0];
        }
        try {
            inputStream0 = this.atomicFile.openRead();
            DataInputStream dataInputStream0 = new DataInputStream(inputStream0);
            v1 = dataInputStream0.readInt();
            if(v1 <= 0) {
                int v2 = dataInputStream0.readInt();
                ArrayList arrayList0 = new ArrayList();
                for(int v3 = 0; v3 < v2; ++v3) {
                    try {
                        arrayList0.add(ActionFile.readDownloadRequest(dataInputStream0));
                    }
                    catch(UnsupportedRequestException unused_ex) {
                    }
                }
                return (DownloadRequest[])arrayList0.toArray(new DownloadRequest[0]);
            }
        }
        finally {
            Util.closeQuietly(inputStream0);
        }
        throw new IOException("Unsupported action file version: " + v1);
    }

    private static DownloadRequest readDownloadRequest(DataInputStream dataInputStream0) {
        byte[] arr_b1;
        String s = dataInputStream0.readUTF();
        int v = dataInputStream0.readInt();
        Uri uri0 = Uri.parse(dataInputStream0.readUTF());
        boolean z = dataInputStream0.readBoolean();
        int v1 = dataInputStream0.readInt();
        String s1 = null;
        if(v1 == 0) {
            arr_b1 = null;
        }
        else {
            byte[] arr_b = new byte[v1];
            dataInputStream0.readFully(arr_b);
            arr_b1 = arr_b;
        }
        boolean z1 = true;
        ArrayList arrayList0 = new ArrayList();
        if(v != 0 || !"progressive".equals(s)) {
            int v2 = dataInputStream0.readInt();
            for(int v3 = 0; v3 < v2; ++v3) {
                arrayList0.add(ActionFile.readKey(s, v, dataInputStream0));
            }
        }
        if(v >= 2 || !"dash".equals(s) && !"hls".equals(s) && !"ss".equals(s)) {
            z1 = false;
        }
        if(!z1 && dataInputStream0.readBoolean()) {
            s1 = dataInputStream0.readUTF();
        }
        String s2 = v >= 3 ? dataInputStream0.readUTF() : ActionFile.generateDownloadId(uri0, s1);
        if(z) {
            throw new UnsupportedRequestException();
        }
        return new DownloadRequest(s2, s, uri0, arrayList0, s1, arr_b1);
    }

    // 去混淆评级： 低(20)
    private static StreamKey readKey(String s, int v, DataInputStream dataInputStream0) {
        return !"hls".equals(s) && !"ss".equals(s) || v != 0 ? new StreamKey(dataInputStream0.readInt(), dataInputStream0.readInt(), dataInputStream0.readInt()) : new StreamKey(0, dataInputStream0.readInt(), dataInputStream0.readInt());
    }
}

