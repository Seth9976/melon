package com.iloen.melon.drm.embedded;

import C9.d;
import C9.e;
import C9.f;
import DigiCAP.SKT.DRM.DRMInterface;
import DigiCAP.SKT.DRM.DrmConstants;
import T8.a;
import T8.b;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Audio.Media;
import com.iloen.melon.drm.AbsDcfController;
import com.iloen.melon.drm.DcfFile;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.log.DcfLog;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.SongMetaParser;
import com.iloen.melon.utils.system.AndroidSettings;
import d5.l;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class EmbeddedDcfController extends AbsDcfController {
    public EmbeddedDcfController(Context context0) {
        super(context0);
    }

    @Override  // com.iloen.melon.drm.AbsDcfController
    public final void a() {
        try {
            a.a.f();
        }
        catch(Exception exception0) {
            LogU.e("EmbeddedDcfController", "destroy() " + exception0);
        }
        LogU.d("EmbeddedDcfController", "destroyed");
    }

    @Override  // com.iloen.melon.drm.AbsDcfController
    public final ArrayList c(Playable playable0) {
        e e0;
        byte[] arr_b8;
        int v33;
        int v31;
        d d0;
        int v24;
        String s1;
        int v18;
        byte[] arr_b7;
        int v16;
        long v14;
        ByteArrayInputStream byteArrayInputStream0;
        byte[] arr_b4;
        ByteArrayOutputStream byteArrayOutputStream0;
        f f0;
        int v6;
        BufferedInputStream bufferedInputStream2;
        FileInputStream fileInputStream1;
        BufferedInputStream bufferedInputStream1;
        int v4;
        BufferedInputStream bufferedInputStream0;
        FileInputStream fileInputStream0;
        byte[] arr_b;
        long v3;
        File file2;
        long v1;
        File file0 = SongMetaParser.getLyricFile(playable0);
        l l0 = null;
        if(file0 != null) {
            LogU.v("EmbeddedDcfController", "----- DRMInit -----");
            b b0 = a.a;
            try {
                int v = b0.e(file0.getPath().getBytes());
                if(v <= 0) {
                    LogU.v("EmbeddedDcfController", "getDCFLyrics() obtain > open - error fd:" + v);
                    return null;
                }
                File file1 = this.a.getCacheDir();
                if(!file1.exists()) {
                    file1.mkdir();
                }
                String s = file1.getPath() + "/lyrics.slf";
                FileOutputStream fileOutputStream0 = new FileOutputStream(s);
                FileChannel fileChannel0 = fileOutputStream0.getChannel();
                ByteBuffer byteBuffer0 = ByteBuffer.allocate(0x400);
                while(true) {
                    if(b0.a) {
                        v1 = DRMInterface.DRMRead(((short)v), byteBuffer0, ((short)0x400L));
                    }
                    else {
                        LogU.e("EmbeddedDrmWrapper", "read() failed lib not initialized");
                        v1 = -1L;
                    }
                    if(v1 <= 0L) {
                        break;
                    }
                    LogU.v("EmbeddedDcfController", "DRMRead > len:" + v1);
                    byteBuffer0.flip();
                    fileChannel0.write(byteBuffer0);
                    byteBuffer0.clear();
                }
                fileChannel0.close();
                fileOutputStream0.close();
                LogU.v("EmbeddedDcfController", "DRMRead return " + v1);
                LogU.v("EmbeddedDcfController", "DRMClose > start");
                int v2 = b0.a(((short)v));
                if(v2 != 0) {
                    LogU.v("EmbeddedDcfController", "DRMClose > error - retVal: " + v2);
                }
                LogU.v("EmbeddedDcfController", "DRMClose > end");
                file2 = new File(s);
                if(file2.exists() && file2.exists()) {
                    if(file2.exists()) {
                        v3 = file2.length();
                        if(10L > v3) {
                            arr_b = null;
                        }
                        else {
                            goto label_44;
                        }
                    }
                    else {
                        arr_b = null;
                    }
                    goto label_83;
                }
                goto label_400;
            }
            catch(IOException iOException0) {
                LogU.e("EmbeddedDcfController", "getDCFLyrics() IOException : " + iOException0);
                DcfLog.e("EmbeddedDcfController", "getDCFLyrics() IOException : " + iOException0);
                return null;
            }
            arr_b = null;
            goto label_83;
            try {
            label_44:
                fileInputStream0 = new FileInputStream(file2);
            }
            catch(Throwable throwable0) {
                fileInputStream0 = null;
                goto label_73;
            }
            try {
                bufferedInputStream0 = new BufferedInputStream(fileInputStream0, 0x2000);
            }
            catch(Throwable throwable0) {
                goto label_73;
            }
            try {
                bufferedInputStream0.skip(v3 - 10L);
                byte[] arr_b1 = ye.a.T(bufferedInputStream0, 10);
                if(arr_b1[2] != 51 || (arr_b1[1] != 68 || arr_b1[0] != 73)) {
                    goto label_81;
                }
                else {
                    v4 = f.d(6, arr_b1);
                    if(v4 > 0x200000) {
                        LogU.e("MyID3", "ID3v2 header size is too big:" + v4);
                        goto label_81;
                    }
                    else if(((long)(v4 + 10)) <= v3) {
                        bufferedInputStream0.close();
                        goto label_58;
                    }
                    else {
                        goto label_78;
                    }
                }
                goto label_83;
            }
            catch(Throwable throwable0) {
                fileInputStream0 = bufferedInputStream0;
                goto label_73;
            }
            try {
            label_58:
                bufferedInputStream0 = new FileInputStream(file2);
            }
            catch(Throwable throwable0) {
                fileInputStream0 = null;
                goto label_73;
            }
            try {
                bufferedInputStream1 = new BufferedInputStream(bufferedInputStream0, 0x2000);
            }
            catch(Throwable throwable0) {
                fileInputStream0 = bufferedInputStream0;
                goto label_73;
            }
            try {
                bufferedInputStream1.skip(v3 - 10L - ((long)v4) - 10L);
                arr_b = ye.a.T(bufferedInputStream1, v4 + 20);
                goto label_76;
            }
            catch(Throwable throwable0) {
                fileInputStream0 = bufferedInputStream1;
            }
        label_73:
            if(fileInputStream0 != null) {
                try {
                    fileInputStream0.close();
                }
                catch(IOException unused_ex) {
                }
            }
            try {
                throw throwable0;
            }
            catch(IOException iOException0) {
                LogU.e("EmbeddedDcfController", "getDCFLyrics() IOException : " + iOException0);
                DcfLog.e("EmbeddedDcfController", "getDCFLyrics() IOException : " + iOException0);
                return null;
            }
            try {
            label_76:
                bufferedInputStream1.close();
                goto label_83;
            label_78:
                bufferedInputStream0.close();
                arr_b = null;
                goto label_83;
            label_81:
                bufferedInputStream0.close();
                arr_b = null;
            }
            catch(IOException unused_ex) {
            }
            try {
            label_83:
                if(arr_b == null) {
                    if(file2.exists()) {
                        long v5 = file2.length();
                        if(v5 >= 10L) {
                            goto label_87;
                        }
                        else {
                            goto label_117;
                        }
                    }
                    else {
                        goto label_117;
                    }
                }
                goto label_118;
            }
            catch(IOException iOException0) {
                LogU.e("EmbeddedDcfController", "getDCFLyrics() IOException : " + iOException0);
                DcfLog.e("EmbeddedDcfController", "getDCFLyrics() IOException : " + iOException0);
                return null;
            }
            try {
            label_87:
                fileInputStream1 = null;
                fileInputStream1 = new FileInputStream(file2);
                bufferedInputStream2 = new BufferedInputStream(fileInputStream1, 0x2000);
            }
            catch(Throwable throwable1) {
                goto label_113;
            }
            try {
                byte[] arr_b2 = ye.a.T(bufferedInputStream2, 10);
                if(arr_b2[0] != 73 || (arr_b2[1] != 68 || arr_b2[2] != 51)) {
                    goto label_116;
                }
                else {
                    boolean z = (arr_b2[5] & 16) > 0;
                    v6 = f.d(6, arr_b2);
                    if(v6 <= 0x200000) {
                        if(z) {
                            v6 += 10;
                        }
                        if(((long)(v6 + 10)) <= v5) {
                            byte[] arr_b3 = ye.a.T(bufferedInputStream2, v6);
                            arr_b = new byte[arr_b2.length + arr_b3.length];
                            System.arraycopy(arr_b2, 0, arr_b, 0, arr_b2.length);
                            System.arraycopy(arr_b3, 0, arr_b, arr_b2.length, arr_b3.length);
                            goto label_105;
                        }
                        else {
                            goto label_107;
                        }
                    }
                    else {
                        goto label_109;
                    }
                }
                goto label_118;
            }
            catch(Throwable throwable1) {
                goto label_112;
            }
            try {
            label_105:
                bufferedInputStream2.close();
            }
            catch(IOException unused_ex) {
            }
            goto label_118;
            try {
            label_107:
                bufferedInputStream2.close();
            }
            catch(IOException unused_ex) {
            }
            goto label_117;
            try {
            label_109:
                LogU.e("MyID3", "ID3v2 header size is too big:" + v6);
                goto label_116;
            }
            catch(Throwable throwable1) {
            label_112:
                fileInputStream1 = bufferedInputStream2;
            }
        label_113:
            if(fileInputStream1 != null) {
                try {
                    fileInputStream1.close();
                }
                catch(IOException unused_ex) {
                }
            }
            try {
                throw throwable1;
            }
            catch(IOException iOException0) {
                LogU.e("EmbeddedDcfController", "getDCFLyrics() IOException : " + iOException0);
                DcfLog.e("EmbeddedDcfController", "getDCFLyrics() IOException : " + iOException0);
                return null;
            }
            try {
            label_116:
                bufferedInputStream2.close();
            }
            catch(IOException unused_ex) {
            }
            try {
            label_117:
                arr_b = null;
            label_118:
                if(arr_b != null) {
                    f0 = new f(new ByteArrayInputStream(arr_b));
                    while(true) {
                    label_120:
                        if(f0.a()) {
                            goto label_389;
                        }
                        byteArrayOutputStream0 = f0.o;
                        if(f0.a()) {
                            continue;
                        }
                        arr_b4 = f0.r;
                        byteArrayInputStream0 = f0.a;
                        goto label_125;
                    }
                }
                goto label_400;
            }
            catch(IOException iOException0) {
                LogU.e("EmbeddedDcfController", "getDCFLyrics() IOException : " + iOException0);
                DcfLog.e("EmbeddedDcfController", "getDCFLyrics() IOException : " + iOException0);
                return null;
            }
            try {
            label_125:
                if(byteArrayInputStream0.available() < 0) {
                    f0.e = true;
                }
                else if(byteArrayInputStream0.available() < 1) {
                    f0.e = true;
                }
                else {
                    if(byteArrayInputStream0.available() < 1) {
                        goto label_120;
                    }
                    int v7 = byteArrayInputStream0.read(arr_b4);
                    if(v7 < 1) {
                        f0.f("unexpected stream closed");
                    }
                    else {
                        byteArrayOutputStream0.write(arr_b4, 0, v7);
                        f0.p += (long)v7;
                    }
                }
                goto label_141;
            }
            catch(IOException iOException1) {
            }
            try {
                f0.f(iOException1.getMessage());
            label_141:
                if(f0.a()) {
                    goto label_120;
                }
                if(!f0.f) {
                    if(f0.p >= 10L) {
                        byte[] arr_b5 = byteArrayOutputStream0.toByteArray();
                        if(arr_b5.length >= 10) {
                            int v8 = f0.h;
                            int v9 = v8 + 1;
                            f0.h = v9;
                            if(arr_b5[v8] == 73) {
                                f0.h = v8 + 2;
                                if(arr_b5[v9] == 68) {
                                    f0.h = v8 + 3;
                                    if(arr_b5[v8 + 2] != 51) {
                                        f0.d = true;
                                    }
                                }
                                else {
                                    f0.d = true;
                                }
                            }
                            else {
                                f0.d = true;
                            }
                            if(!f0.c && !f0.d) {
                                int v10 = f0.h;
                                f0.h = v10 + 1;
                                byte b1 = arr_b5[v10];
                                f0.j = b1;
                                int v11 = v10 + 2;
                                f0.h = v11;
                                int v12 = arr_b5[v10 + 1];
                                if(b1 < 2 || b1 > 4) {
                                    f0.f("Unknown id3v2 Major Version: " + ((int)f0.j));
                                }
                                else {
                                    f0.h = v10 + 3;
                                    long v13 = (long)arr_b5[v11];
                                    if(b1 == 2) {
                                        if((v13 & 0x80L) > 0L) {
                                            f0.k = true;
                                            v14 = v13 ^ 0x80L;
                                        }
                                        else {
                                            v14 = v13;
                                        }
                                        if((v14 & 0x40L) > 0L) {
                                            v14 ^= 0x40L;
                                        }
                                    }
                                    else {
                                        switch(b1) {
                                            case 3: {
                                                if((v13 & 0x80L) > 0L) {
                                                    f0.k = true;
                                                    v14 = v13 ^ 0x80L;
                                                }
                                                else {
                                                    v14 = v13;
                                                }
                                                if((v14 & 0x40L) > 0L) {
                                                    f0.l = true;
                                                    v14 ^= 0x40L;
                                                }
                                                if((v14 & 0x20L) > 0L) {
                                                    v14 ^= 0x20L;
                                                }
                                                if((v14 & 16L) > 0L) {
                                                    v14 ^= 16L;
                                                    break;
                                                }
                                                break;
                                            }
                                            case 4: {
                                                if((v13 & 0x80L) > 0L) {
                                                    f0.k = true;
                                                    v14 = v13 ^ 0x80L;
                                                }
                                                else {
                                                    v14 = v13;
                                                }
                                                if((v14 & 0x40L) > 0L) {
                                                    f0.l = true;
                                                    v14 ^= 0x40L;
                                                }
                                                if((v14 & 0x20L) > 0L) {
                                                    v14 ^= 0x20L;
                                                }
                                                if((v14 & 16L) > 0L) {
                                                    f0.m = true;
                                                    v14 ^= 16L;
                                                }
                                                break;
                                            }
                                            default: {
                                                f0.f("Unknown id3v2 Major Version: " + ((int)f0.j));
                                                goto label_226;
                                            }
                                        }
                                    }
                                    if(v14 <= 0L) {
                                        int v15 = f0.e(arr_b5, false);
                                        f0.q = v15 + 10;
                                        f0.i = v15 + 10;
                                        if(f0.m) {
                                            f0.q = v15 + 20;
                                        }
                                        f0.f = true;
                                        if(f0.h != 10) {
                                            f0.f("index!=kHEADER_SIZE");
                                        }
                                    }
                                    else {
                                        f0.f("Unknown id3v2 tag flags(id3v2 version: " + ((int)f0.j) + "): " + Long.toHexString(v13));
                                    }
                                }
                            }
                        }
                        else {
                            f0.f("missing header");
                        }
                    }
                    else {
                        if(!f0.e) {
                            goto label_120;
                        }
                        f0.c = true;
                        goto label_120;
                    }
                }
            label_226:
                if(f0.g) {
                    goto label_120;
                }
                if(f0.p >= ((long)f0.q)) {
                    byte[] arr_b6 = byteArrayOutputStream0.toByteArray();
                    if(arr_b6.length >= f0.q) {
                        if(f0.k) {
                            arr_b6 = f.g(arr_b6);
                        }
                        if(f0.l) {
                            f0.h += 4;
                        }
                        v16 = 0;
                    alab1:
                        while(true) {
                        label_235:
                            int v17 = f0.h;
                            if(v17 + 7 >= f0.i || f0.c || v17 + 7 >= f0.i) {
                                f0.g = true;
                                f0.b = true;
                                goto label_120;
                            }
                            if(f0.j >= 3) {
                                arr_b7 = new byte[4];
                                f0.h = v17 + 1;
                                arr_b7[0] = arr_b6[v17];
                                f0.h = v17 + 2;
                                arr_b7[1] = arr_b6[v17 + 1];
                                f0.h = v17 + 3;
                                arr_b7[2] = arr_b6[v17 + 2];
                                f0.h = v17 + 4;
                                arr_b7[3] = arr_b6[v17 + 3];
                            }
                            else {
                                arr_b7 = new byte[3];
                                f0.h = v17 + 1;
                                arr_b7[0] = arr_b6[v17];
                                f0.h = v17 + 2;
                                arr_b7[1] = arr_b6[v17 + 1];
                                f0.h = v17 + 3;
                                arr_b7[2] = arr_b6[v17 + 2];
                            }
                            v18 = 0;
                        label_256:
                            if(v18 >= arr_b7.length) {
                                f0.g = true;
                                f0.b = true;
                                goto label_120;
                            }
                            if((arr_b7[v18] & 0xFF) <= 0) {
                                ++v18;
                                goto label_256;
                            }
                            int v19 = 0;
                            while(v19 < arr_b7.length) {
                                int v20 = arr_b7[v19] & 0xFF;
                                if("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".indexOf(((int)(((char)v20)))) >= 0) {
                                    ++v19;
                                    continue;
                                }
                                f0.f("invalid id3v2 frame id byte: " + Integer.toHexString(v20));
                                s1 = null;
                                goto label_268;
                            }
                            s1 = new String(arr_b7);
                        label_268:
                            if(s1 != null) {
                                int v21 = f0.j;
                                if(v21 >= 4) {
                                    v24 = f0.e(arr_b6, true);
                                }
                                else if(v21 >= 3) {
                                    int v22 = f0.h;
                                    int v23 = v22 + 3;
                                    if(v23 >= f0.q) {
                                        f0.f("readInt(index: " + f0.h + ", tagLength: " + f0.q);
                                        v24 = -1;
                                    }
                                    else if(v23 >= arr_b6.length) {
                                        f0.f("readInt(index: " + f0.h + ", bytes.length: " + arr_b6.length);
                                        v24 = -1;
                                    }
                                    else {
                                        f0.h = v22 + 4;
                                        new int[]{arr_b6[v22] & 0xFF, arr_b6[v22 + 1] & 0xFF, arr_b6[v22 + 2] & 0xFF, arr_b6[v23] & 0xFF};
                                        v24 = arr_b6[v23] & 0xFF | ((arr_b6[v22 + 1] & 0xFF) << 16 | (arr_b6[v22] & 0xFF) << 24 | (arr_b6[v22 + 2] & 0xFF) << 8);
                                    }
                                }
                                else {
                                    int v25 = f0.h;
                                    int v26 = v25 + 2;
                                    if(v26 >= f0.q) {
                                        f0.f("readInt3(index: " + f0.h + ", tagLength: " + f0.q);
                                        v24 = -1;
                                    }
                                    else if(v25 + 3 >= arr_b6.length) {
                                        f0.f("readInt3(index: " + f0.h + ", bytes.length: " + arr_b6.length);
                                        v24 = -1;
                                    }
                                    else {
                                        f0.h = v25 + 3;
                                        new int[]{arr_b6[v25] & 0xFF, arr_b6[v25 + 1] & 0xFF, arr_b6[v26] & 0xFF};
                                        v24 = (arr_b6[v25] & 0xFF) << 16 | (arr_b6[v25 + 1] & 0xFF) << 8 | arr_b6[v26] & 0xFF;
                                    }
                                }
                                int v27 = f0.q;
                                int v28 = f0.h;
                                int v29 = v27 - v28;
                                int v30 = f0.j;
                                if(v30 >= 3) {
                                    v29 += 2;
                                }
                                if(v24 != 0) {
                                    if(v24 <= v29 && v24 >= 0) {
                                        switch(v30) {
                                            case 2: {
                                                d0 = new d();
                                                break;
                                            }
                                            case 3: 
                                            case 4: {
                                                if(v28 + 1 >= v27 || v28 + 1 >= arr_b6.length) {
                                                    f0.f("readShort(index: " + f0.h + ", tagLength: " + f0.q + ", bytes.length: " + arr_b6.length);
                                                    v31 = -1;
                                                }
                                                else {
                                                    f0.h = v28 + 2;
                                                    new byte[]{arr_b6[v28], arr_b6[v28 + 1]};
                                                    v31 = arr_b6[v28] << 8 | arr_b6[v28 + 1];
                                                }
                                                d0 = new d();
                                                int v32 = f0.j;
                                                if(v32 == 3) {
                                                    v33 = (v31 & 0x8000) <= 0 ? v31 : 0x8000 ^ v31;
                                                    if((v33 & 0x4000) > 0) {
                                                        v33 ^= 0x4000;
                                                    }
                                                    if((v33 & 0x2000) > 0) {
                                                        v33 ^= 0x2000;
                                                    }
                                                    if((v33 & 0x20) > 0) {
                                                        v33 ^= 0x20;
                                                    }
                                                    if((v33 & 0x80) > 0) {
                                                        v33 ^= 0x80;
                                                    }
                                                    if((v33 & 0x40) > 0) {
                                                        v33 ^= 0x40;
                                                    }
                                                }
                                                else if(v32 == 4) {
                                                    v33 = (v31 & 0x4000) <= 0 ? v31 : v31 ^ 0x4000;
                                                    if((v33 & 0x2000) > 0) {
                                                        v33 ^= 0x2000;
                                                    }
                                                    if((v33 & 0x1000) > 0) {
                                                        v33 ^= 0x1000;
                                                    }
                                                    if((v33 & 0x40) > 0) {
                                                        v33 ^= 0x40;
                                                    }
                                                    if((v33 & 8) > 0) {
                                                        v33 ^= 8;
                                                    }
                                                    if((v33 & 4) > 0) {
                                                        v33 ^= 4;
                                                    }
                                                    if((v33 & 2) > 0) {
                                                        d0.a = true;
                                                        v33 ^= 2;
                                                    }
                                                    if((v33 & 1) > 0) {
                                                        d0.b = true;
                                                        v33 ^= 1;
                                                    }
                                                }
                                                else {
                                                    v33 = v31;
                                                }
                                                if(v33 <= 0) {
                                                    break;
                                                }
                                                goto label_376;
                                            }
                                            default: {
                                                f0.f("Unknown ID3v2 version: " + ((int)f0.j));
                                                break alab1;
                                            }
                                        }
                                        if(v24 > 0) {
                                            if(d0.b) {
                                                f0.e(arr_b6, true);
                                                v24 -= 4;
                                            }
                                            arr_b8 = new byte[v24];
                                            System.arraycopy(arr_b6, f0.h, arr_b8, 0, v24);
                                            f0.h += v24;
                                            if(d0.a) {
                                                arr_b8 = f.g(arr_b8);
                                            }
                                            LogU.v("MyID3v2Read", "length = " + arr_b8.length + "frameIDString = " + s1);
                                            goto label_367;
                                        }
                                        ++v16;
                                        continue;
                                    }
                                    else {
                                        f0.f("bad frame length(" + v16 + ": " + s1 + "): " + v24 + " (" + new String(arr_b7));
                                        f0.g = true;
                                        f0.b = true;
                                        goto label_120;
                                    }
                                    ++v18;
                                    goto label_256;
                                }
                            }
                            f0.g = true;
                            f0.b = true;
                            goto label_120;
                        }
                    }
                    else {
                        goto label_383;
                    }
                    f0.b = true;
                    goto label_120;
                }
                goto label_386;
            }
            catch(IOException iOException0) {
                LogU.e("EmbeddedDcfController", "getDCFLyrics() IOException : " + iOException0);
                DcfLog.e("EmbeddedDcfController", "getDCFLyrics() IOException : " + iOException0);
                return null;
            }
            try {
            label_367:
                "USLT".equals(s1);
                if(arr_b7[0] != 84) {
                    f0.b(v24, s1, arr_b8);
                }
                ++v16;
                goto label_235;
            }
            catch(IOException iOException2) {
                try {
                    f0.f(iOException2.getMessage());
                    f0.b = true;
                    goto label_120;
                label_376:
                    f0.f("Unknown id3v2 frame flags(id3v2 version: " + ((int)f0.j) + "): " + Long.toHexString(v31));
                    f0.b = true;
                    goto label_120;
                label_383:
                    f0.f("missing tag");
                    f0.b = true;
                    goto label_120;
                label_386:
                    if(!f0.e) {
                        goto label_120;
                    }
                    f0.c = true;
                    goto label_120;
                label_389:
                    if(!f0.c && (f0.b && !f0.d)) {
                        goto label_390;
                    }
                    goto label_400;
                }
                catch(IOException iOException0) {
                    LogU.e("EmbeddedDcfController", "getDCFLyrics() IOException : " + iOException0);
                    DcfLog.e("EmbeddedDcfController", "getDCFLyrics() IOException : " + iOException0);
                    return null;
                }
            }
        label_390:
            HashMap hashMap0 = f0.n;
            if(hashMap0 == null) {
                e0 = null;
            }
            else {
                try {
                    e0 = new e();
                    for(int v34 = 0; v34 < hashMap0.size(); ++v34) {
                        hashMap0.get(v34);
                    }
                }
                catch(Throwable unused_ex) {
                    e0 = null;
                }
            }
            try {
                l0 = new l(1, e0, hashMap0);
            label_400:
                LogU.i("EmbeddedDcfController", "getDCFLyrics() add lyrics");
                if(l0 == null) {
                    LogU.i("EmbeddedDcfController", "getDCFLyrics() src_set == null");
                    return null;
                }
                Map map0 = (Map)l0.c;
                return map0 != null && map0.size() > 0 ? ((ArrayList)map0.get("XSYL")) : null;
            }
            catch(IOException iOException0) {
            }
            LogU.e("EmbeddedDcfController", "getDCFLyrics() IOException : " + iOException0);
            DcfLog.e("EmbeddedDcfController", "getDCFLyrics() IOException : " + iOException0);
        }
        return null;
    }

    @Override  // com.iloen.melon.drm.AbsDcfController
    public final DcfFile d(String s) {
        String s3;
        String s2;
        long v1;
        DcfFile dcfFile0 = new DcfFile(s);  // 初始化器: Lcom/iloen/melon/drm/MelonFile;-><init>(Ljava/lang/String;)V
        b b0 = a.a;
        int v = 0;
        try {
            try {
                v = b0.e(s.getBytes(StandardCharsets.UTF_8));
                if(v > 0) {
                    if(b0.a) {
                        v1 = DRMInterface.DRMGetErrorCode(((short)v));
                    }
                    else {
                        LogU.e("EmbeddedDrmWrapper", "getErrorCode() failed lib not initialized");
                        v1 = -1L;
                    }
                    String s1 = null;
                    if(Long.compare(v1, 0L) >= 0) {
                        if(AndroidSettings.isAutoTimeChecked(this.a)) {
                            if(b0.a) {
                                s2 = DRMInterface.DRMGetValidPeriod(((short)v));
                            }
                            else {
                                LogU.e("EmbeddedDrmWrapper", "getValidPeriod() failed lib not initialized");
                                s2 = null;
                            }
                            if(AbsDcfController.g(s2)) {
                                DcfLog.e("EmbeddedDcfController", "getDcfFile() path validPeriod : " + s2);
                                v1 = -101L;
                            }
                            else {
                                v1 = 0L;
                            }
                        }
                        else {
                            v1 = -103L;
                        }
                    }
                    dcfFile0.g(v1);
                    if(b0.a) {
                        s3 = DRMInterface.DRMGetContentDescription(((short)v));
                    }
                    else {
                        LogU.e("EmbeddedDrmWrapper", "DRMGetContentDescription() failed lib not initialized");
                        s3 = null;
                    }
                    if(b0.a) {
                        s1 = DRMInterface.DRMGetContentID(((short)v));
                    }
                    else {
                        LogU.e("EmbeddedDrmWrapper", "getContentID() failed lib not initialized");
                    }
                    String s4 = SongMetaParser.parseDcfSongId(s3);
                    String s5 = SongMetaParser.parseLCode(s1);
                    dcfFile0.e(s4);
                    dcfFile0.f(s5);
                }
                else {
                    DcfLog.d("EmbeddedDcfController", "getDcfFile() path open : " + v + ", path : " + s);
                    dcfFile0.g(((long)v));
                }
                goto label_57;
            }
            catch(Exception exception0) {
            }
            DcfLog.e("EmbeddedDcfController", "getDcfFile() path : " + s + ", Exception : " + exception0);
            if(dcfFile0.i < 0L) {
                goto label_48;
            }
            goto label_49;
        }
        catch(Throwable throwable0) {
            goto label_52;
        }
    label_48:
        DcfLog.e("EmbeddedDcfController", "getDcfFile() path has error : " + dcfFile0);
    label_49:
        if(v >= 0) {
            try {
                b0.a(((short)v));
            }
            catch(Exception unused_ex) {
            }
            return dcfFile0;
        label_52:
            if(dcfFile0.i < 0L) {
                DcfLog.e("EmbeddedDcfController", "getDcfFile() path has error : " + dcfFile0);
            }
            if(v >= 0) {
                try {
                    b0.a(((short)v));
                }
                catch(Exception unused_ex) {
                }
            }
            throw throwable0;
        label_57:
            if(dcfFile0.i < 0L) {
                DcfLog.e("EmbeddedDcfController", "getDcfFile() path has error : " + dcfFile0);
            }
            if(v >= 0) {
                try {
                    b0.a(((short)v));
                    return dcfFile0;
                }
                catch(Exception unused_ex) {
                }
            }
        }
        return dcfFile0;
    }

    @Override  // com.iloen.melon.drm.AbsDcfController
    public final LinkedList e() {
        LinkedList linkedList0 = new LinkedList();
        ContentResolver contentResolver0 = this.a.getContentResolver();
        if(contentResolver0 == null) {
            DcfLog.d("EmbeddedDcfController", "getDrmExpiredFiles() resolver is null");
            return null;
        }
        Cursor cursor0 = contentResolver0.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{"_data"}, "_data LIKE \'%.dcf\' COLLATE NOCASE and is_music = 1", null, null);
        if(cursor0 != null) {
            DcfLog.i("EmbeddedDcfController", "getDrmExpiredFiles() song count = " + cursor0.getCount());
            try {
                for(int v = 0; v < cursor0.getCount(); ++v) {
                    cursor0.moveToPosition(v);
                    DcfFile dcfFile0 = this.d(cursor0.getString(0));
                    if(dcfFile0.i == -101L) {
                        linkedList0.add(dcfFile0);
                    }
                }
            }
            catch(Exception exception0) {
                DcfLog.e("EmbeddedDcfController", "getDrmExpiredFiles() Exception:" + exception0);
                cursor0.close();
                return linkedList0;
            }
            cursor0.close();
            return linkedList0;
        }
        return linkedList0;
    }

    @Override  // com.iloen.melon.drm.AbsDcfController
    public final void f(String s) {
        LogU.i("EmbeddedDcfController", "initialize mdn : " + s);
        this.b = s;
        a.a.c(s);
        LogU.d("EmbeddedDcfController", "initialize isExpandedFilePath : " + DRMInterface.DRMIsExpandedFilePath());
        if(DRMInterface.DRMIsExpandedFilePath() == 1) {
            DrmConstants.EMBEDDED_DRM_API_MAX_PATH = 400;
            return;
        }
        DrmConstants.EMBEDDED_DRM_API_MAX_PATH = 0xFF;
    }
}

