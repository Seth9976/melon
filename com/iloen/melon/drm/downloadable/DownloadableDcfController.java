package com.iloen.melon.drm.downloadable;

import C9.d;
import C9.e;
import C9.f;
import DigiCAP.SKT.DRM.DrmInitException;
import DigiCAP.SKT.DRM.MelonDRMMetaInterface;
import G8.g;
import H8.k;
import R8.r;
import S8.a;
import S8.b;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import b3.Z;
import com.digicap.melon.exception.DrmNotInitializedDrmException;
import com.digicap.melon.exception.DrmSocketNullDrmException;
import com.iloen.melon.drm.AbsDcfController;
import com.iloen.melon.drm.DcfFile;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.StorageUtils;
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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import jeb.synthetic.FIN;

public class DownloadableDcfController extends AbsDcfController {
    public final a c;
    public static final Object d;

    static {
        DownloadableDcfController.d = new Object();
    }

    public DownloadableDcfController(Context context0) {
        super(context0);
        this.c = new a();  // 初始化器: Lcom/digicap/melon/melonDrmLocalServerInterface;-><init>()V
    }

    @Override  // com.iloen.melon.drm.AbsDcfController
    public final void a() {
        a a0 = this.c;
        if(a0 != null) {
            a0.unloadDRMLocalServer();
            LogU.d("DownloadableDcfController", "unloadDRMLocalServer");
        }
        LogU.d("DownloadableDcfController", "destroyed");
    }

    @Override  // com.iloen.melon.drm.AbsDcfController
    public final ArrayList c(Playable playable0) {
        ArrayList arrayList0;
        e e0;
        l l0;
        int v34;
        int v32;
        int v25;
        String s3;
        int v19;
        byte[] arr_b8;
        long v15;
        long v14;
        long v13;
        long v12;
        f f0;
        int v4;
        BufferedInputStream bufferedInputStream2;
        FileInputStream fileInputStream1;
        BufferedInputStream bufferedInputStream1;
        int v2;
        BufferedInputStream bufferedInputStream0;
        FileInputStream fileInputStream0;
        Object object1;
        long v1;
        File file2;
        LogU.d("DownloadableDcfController", "getDCFLyrics() path :  || uri : ");
        File file0 = SongMetaParser.getLyricFile(playable0);
        if(file0 != null) {
            Object object0 = DownloadableDcfController.d;
            __monitor_enter(object0);
            try {
                try {
                    if(!StorageUtils.isScopedStorage()) {
                        String s = this.c.checkDCF("");
                        LogU.d("DownloadableDcfController", "getDCFLyrics() mineType : " + s);
                        if(s == null) {
                            goto label_9;
                        }
                    }
                    goto label_11;
                }
                catch(Exception exception0) {
                    goto label_420;
                }
            label_9:
                __monitor_exit(object0);
                return null;
                try {
                label_11:
                    if(file0.exists()) {
                        if(!file0.exists() || file0.length() != 0L) {
                            String s1 = file0.getCanonicalPath();
                            int v = this.c.loadFile(s1);
                            byte[] arr_b = this.c.getLyrics(v).array();
                            this.c.unloadFile(v);
                            File file1 = this.a.getCacheDir();
                            if(!file1.exists()) {
                                file1.mkdirs();
                            }
                            String s2 = file1.getPath() + "/lyrics.slf";
                            FileOutputStream fileOutputStream0 = new FileOutputStream(s2);
                            fileOutputStream0.write(arr_b);
                            fileOutputStream0.close();
                            file2 = new File(s2);
                            if(!file2.exists()) {
                                goto label_401;
                            }
                            else if(file2.exists()) {
                                if(file2.exists()) {
                                    v1 = file2.length();
                                    if(10L > v1) {
                                        goto label_30;
                                    }
                                    else {
                                        goto label_33;
                                    }
                                }
                                else {
                                    goto label_76;
                                }
                                goto label_78;
                            }
                            else {
                                goto label_398;
                            }
                            goto label_403;
                        }
                        goto label_417;
                    }
                    goto label_426;
                }
                catch(Exception exception0) {
                    goto label_420;
                }
            }
            catch(Throwable throwable0) {
                object1 = object0;
                goto label_433;
            }
        label_30:
            object1 = object0;
            byte[] arr_b1 = null;
            goto label_78;
            try {
            label_33:
                fileInputStream0 = new FileInputStream(file2);
            }
            catch(Throwable throwable1) {
                object1 = object0;
                fileInputStream0 = null;
                goto label_73;
            }
            try {
                bufferedInputStream0 = new BufferedInputStream(fileInputStream0, 0x2000);
            }
            catch(Throwable throwable1) {
                object1 = object0;
                goto label_73;
            }
            try {
                bufferedInputStream0.skip(v1 - 10L);
                byte[] arr_b2 = ye.a.T(bufferedInputStream0, 10);
                if(arr_b2[2] != 51 || (arr_b2[1] != 68 || arr_b2[0] != 73)) {
                    goto label_66;
                }
                else {
                    v2 = f.d(6, arr_b2);
                    if(v2 > 0x200000) {
                        LogU.e("MyID3", "ID3v2 header size is too big:" + v2);
                        goto label_66;
                    }
                    else if(((long)(v2 + 10)) <= v1) {
                        bufferedInputStream0.close();
                        goto label_48;
                    }
                    else {
                        goto label_64;
                    }
                }
                goto label_78;
            }
            catch(Throwable throwable1) {
                goto label_71;
            }
            try {
            label_48:
                bufferedInputStream0 = new FileInputStream(file2);
            }
            catch(Throwable throwable1) {
                object1 = object0;
                fileInputStream0 = null;
                goto label_73;
            }
            try {
                bufferedInputStream1 = new BufferedInputStream(bufferedInputStream0, 0x2000);
                object1 = object0;
            }
            catch(Throwable throwable1) {
                goto label_71;
            }
            try {
                bufferedInputStream1.skip(v1 - 10L - ((long)v2) - 10L);
                arr_b1 = ye.a.T(bufferedInputStream1, v2 + 20);
            }
            catch(Throwable throwable1) {
                fileInputStream0 = bufferedInputStream1;
                goto label_73;
            }
            try {
                bufferedInputStream1.close();
                goto label_78;
            }
            catch(IOException unused_ex) {
                goto label_78;
            }
            catch(Exception exception0) {
                goto label_421;
            }
            catch(Throwable throwable0) {
                goto label_433;
            }
            try {
            label_64:
                bufferedInputStream0.close();
                object1 = object0;
                arr_b1 = null;
                goto label_78;
            label_66:
                bufferedInputStream0.close();
                object1 = object0;
                arr_b1 = null;
                goto label_78;
            }
            catch(IOException unused_ex) {
                try {
                    object1 = object0;
                    arr_b1 = null;
                    goto label_78;
                }
                catch(Throwable throwable1) {
                label_71:
                    object1 = object0;
                    fileInputStream0 = bufferedInputStream0;
                }
            label_73:
                if(fileInputStream0 != null) {
                    try {
                        try {
                            fileInputStream0.close();
                        }
                        catch(IOException unused_ex) {
                        }
                        throw throwable1;
                    }
                    catch(Exception exception0) {
                        goto label_421;
                    }
                    catch(Throwable throwable0) {
                        goto label_433;
                    }
                }
                throw throwable1;
                try {
                label_76:
                    object1 = object0;
                    arr_b1 = null;
                }
                catch(Exception exception0) {
                    goto label_420;
                }
                catch(Throwable throwable0) {
                    object1 = object0;
                    goto label_433;
                }
                try {
                label_78:
                    if(arr_b1 == null) {
                        if(file2.exists()) {
                            long v3 = file2.length();
                            if(v3 >= 10L) {
                                goto label_82;
                            }
                            else {
                                goto label_112;
                            }
                        }
                        else {
                            goto label_112;
                        }
                    }
                    goto label_113;
                }
                catch(Exception exception0) {
                    goto label_421;
                }
                catch(Throwable throwable0) {
                    goto label_433;
                }
                try {
                label_82:
                    fileInputStream1 = null;
                    fileInputStream1 = new FileInputStream(file2);
                    bufferedInputStream2 = new BufferedInputStream(fileInputStream1, 0x2000);
                }
                catch(Throwable throwable2) {
                    goto label_108;
                }
                try {
                    byte[] arr_b3 = ye.a.T(bufferedInputStream2, 10);
                    if(arr_b3[0] != 73 || (arr_b3[1] != 68 || arr_b3[2] != 51)) {
                        goto label_111;
                    }
                    else {
                        boolean z = (arr_b3[5] & 16) > 0;
                        v4 = f.d(6, arr_b3);
                        if(v4 <= 0x200000) {
                            if(z) {
                                v4 += 10;
                            }
                            if(((long)(v4 + 10)) <= v3) {
                                byte[] arr_b4 = ye.a.T(bufferedInputStream2, v4);
                                arr_b1 = new byte[arr_b3.length + arr_b4.length];
                                System.arraycopy(arr_b3, 0, arr_b1, 0, arr_b3.length);
                                System.arraycopy(arr_b4, 0, arr_b1, arr_b3.length, arr_b4.length);
                                goto label_100;
                            }
                            else {
                                goto label_102;
                            }
                        }
                        else {
                            goto label_104;
                        }
                    }
                    goto label_113;
                }
                catch(Throwable throwable2) {
                    goto label_107;
                }
                try {
                    try {
                    label_100:
                        bufferedInputStream2.close();
                    }
                    catch(IOException unused_ex) {
                    }
                    goto label_113;
                    try {
                    label_102:
                        bufferedInputStream2.close();
                    }
                    catch(IOException unused_ex) {
                    }
                    goto label_112;
                }
                catch(Exception exception0) {
                    goto label_421;
                }
                catch(Throwable throwable0) {
                    goto label_433;
                }
                try {
                label_104:
                    LogU.e("MyID3", "ID3v2 header size is too big:" + v4);
                    goto label_111;
                }
                catch(Throwable throwable2) {
                label_107:
                    fileInputStream1 = bufferedInputStream2;
                }
            label_108:
                if(fileInputStream1 != null) {
                    try {
                        try {
                            fileInputStream1.close();
                        }
                        catch(IOException unused_ex) {
                        }
                        throw throwable2;
                        try {
                        label_111:
                            bufferedInputStream2.close();
                        }
                        catch(IOException unused_ex) {
                        }
                    label_112:
                        arr_b1 = null;
                    label_113:
                        if(arr_b1 == null) {
                            l0 = null;
                        }
                        else {
                            f0 = new f(new ByteArrayInputStream(arr_b1));
                            while(!f0.a()) {
                                ByteArrayOutputStream byteArrayOutputStream0 = f0.o;
                                if(!f0.a()) {
                                    byte[] arr_b5 = f0.r;
                                    ByteArrayInputStream byteArrayInputStream0 = f0.a;
                                    try {
                                        if(byteArrayInputStream0.available() < 0) {
                                            f0.e = true;
                                        }
                                        else if(byteArrayInputStream0.available() < 1) {
                                            f0.e = true;
                                        }
                                        else {
                                            if(byteArrayInputStream0.available() < 1) {
                                                continue;
                                            }
                                            int v5 = byteArrayInputStream0.read(arr_b5);
                                            if(v5 < 1) {
                                                f0.f("unexpected stream closed");
                                            }
                                            else {
                                                byteArrayOutputStream0.write(arr_b5, 0, v5);
                                                f0.p += (long)v5;
                                            }
                                        }
                                    }
                                    catch(IOException iOException0) {
                                        f0.f(iOException0.getMessage());
                                    }
                                    if(!f0.a()) {
                                        if(!f0.f) {
                                            if(f0.p >= 10L) {
                                                byte[] arr_b6 = byteArrayOutputStream0.toByteArray();
                                                if(arr_b6.length >= 10) {
                                                    int v6 = f0.h;
                                                    int v7 = v6 + 1;
                                                    f0.h = v7;
                                                    if(arr_b6[v6] == 73) {
                                                        f0.h = v6 + 2;
                                                        if(arr_b6[v7] == 68) {
                                                            f0.h = v6 + 3;
                                                            if(arr_b6[v6 + 2] != 51) {
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
                                                        int v8 = f0.h;
                                                        f0.h = v8 + 1;
                                                        byte b = arr_b6[v8];
                                                        f0.j = b;
                                                        int v9 = v8 + 2;
                                                        f0.h = v9;
                                                        int v10 = arr_b6[v8 + 1];
                                                        if(b < 2 || b > 4) {
                                                            f0.f("Unknown id3v2 Major Version: " + ((int)f0.j));
                                                        }
                                                        else {
                                                            f0.h = v8 + 3;
                                                            long v11 = (long)arr_b6[v9];
                                                            if(b == 2) {
                                                                if((v11 & 0x80L) > 0L) {
                                                                    f0.k = true;
                                                                    v12 = v11 ^ 0x80L;
                                                                }
                                                                else {
                                                                    v12 = v11;
                                                                }
                                                                if((v12 & 0x40L) > 0L) {
                                                                    v12 ^= 0x40L;
                                                                }
                                                                v13 = v12;
                                                            }
                                                            else {
                                                                switch(b) {
                                                                    case 3: {
                                                                        goto label_178;
                                                                    }
                                                                    case 4: {
                                                                        goto label_191;
                                                                    }
                                                                }
                                                                f0.f("Unknown id3v2 Major Version: " + ((int)f0.j));
                                                                goto label_222;
                                                            label_178:
                                                                if((v11 & 0x80L) > 0L) {
                                                                    f0.k = true;
                                                                    v14 = v11 ^ 0x80L;
                                                                }
                                                                else {
                                                                    v14 = v11;
                                                                }
                                                                if((v14 & 0x40L) > 0L) {
                                                                    f0.l = true;
                                                                    v14 ^= 0x40L;
                                                                }
                                                                v12 = (v14 & 0x20L) <= 0L ? v14 : v14 ^ 0x20L;
                                                                if((v12 & 16L) > 0L) {
                                                                    v12 ^= 16L;
                                                                }
                                                                v13 = v12;
                                                                goto label_203;
                                                            label_191:
                                                                if((v11 & 0x80L) > 0L) {
                                                                    f0.k = true;
                                                                    v15 = v11 ^ 0x80L;
                                                                }
                                                                else {
                                                                    v15 = v11;
                                                                }
                                                                if((v15 & 0x40L) > 0L) {
                                                                    f0.l = true;
                                                                    v15 ^= 0x40L;
                                                                }
                                                                v13 = (v15 & 0x20L) <= 0L ? v15 : v15 ^ 0x20L;
                                                                if((v13 & 16L) > 0L) {
                                                                    f0.m = true;
                                                                    v13 ^= 16L;
                                                                }
                                                            }
                                                        label_203:
                                                            if(v13 <= 0L) {
                                                                int v16 = f0.e(arr_b6, false);
                                                                f0.q = v16 + 10;
                                                                f0.i = v16 + 10;
                                                                if(f0.m) {
                                                                    f0.q = v16 + 20;
                                                                }
                                                                f0.f = true;
                                                                if(f0.h != 10) {
                                                                    f0.f("index!=kHEADER_SIZE");
                                                                }
                                                            }
                                                            else {
                                                                f0.f("Unknown id3v2 tag flags(id3v2 version: " + ((int)f0.j) + "): " + Long.toHexString(v11));
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
                                                    continue;
                                                }
                                                f0.c = true;
                                                continue;
                                            }
                                        }
                                    label_222:
                                        if(f0.g) {
                                        }
                                        else if(f0.p >= ((long)f0.q)) {
                                            byte[] arr_b7 = byteArrayOutputStream0.toByteArray();
                                            if(arr_b7.length >= f0.q) {
                                                if(f0.k) {
                                                    arr_b7 = f.g(arr_b7);
                                                }
                                                if(f0.l) {
                                                    f0.h += 4;
                                                }
                                                int v17 = 0;
                                                while(true) {
                                                    int v18 = f0.h;
                                                    if(v18 + 7 >= f0.i || f0.c || v18 + 7 >= f0.i) {
                                                        goto label_376;
                                                    }
                                                    if(f0.j >= 3) {
                                                        arr_b8 = new byte[4];
                                                        f0.h = v18 + 1;
                                                        arr_b8[0] = arr_b7[v18];
                                                        f0.h = v18 + 2;
                                                        arr_b8[1] = arr_b7[v18 + 1];
                                                        f0.h = v18 + 3;
                                                        arr_b8[2] = arr_b7[v18 + 2];
                                                        f0.h = v18 + 4;
                                                        arr_b8[3] = arr_b7[v18 + 3];
                                                    }
                                                    else {
                                                        arr_b8 = new byte[3];
                                                        f0.h = v18 + 1;
                                                        arr_b8[0] = arr_b7[v18];
                                                        f0.h = v18 + 2;
                                                        arr_b8[1] = arr_b7[v18 + 1];
                                                        f0.h = v18 + 3;
                                                        arr_b8[2] = arr_b7[v18 + 2];
                                                    }
                                                    v19 = 0;
                                                label_252:
                                                    if(v19 >= arr_b8.length) {
                                                        goto label_376;
                                                    }
                                                    if((arr_b8[v19] & 0xFF) <= 0) {
                                                        ++v19;
                                                        goto label_252;
                                                    }
                                                    int v20 = 0;
                                                    while(v20 < arr_b8.length) {
                                                        int v21 = arr_b8[v20] & 0xFF;
                                                        if("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".indexOf(((int)(((char)v21)))) >= 0) {
                                                            ++v20;
                                                            continue;
                                                        }
                                                        f0.f("invalid id3v2 frame id byte: " + Integer.toHexString(v21));
                                                        s3 = null;
                                                        goto label_264;
                                                    }
                                                    s3 = new String(arr_b8);
                                                label_264:
                                                    if(s3 != null) {
                                                        int v22 = f0.j;
                                                        if(v22 < 4) {
                                                            if(v22 >= 3) {
                                                                int v23 = f0.h;
                                                                int v24 = v23 + 3;
                                                                if(v24 >= f0.q) {
                                                                }
                                                                else if(v24 >= arr_b7.length) {
                                                                    f0.f("readInt(index: " + f0.h + ", bytes.length: " + arr_b7.length);
                                                                    goto label_291;
                                                                }
                                                                else {
                                                                    f0.h = v23 + 4;
                                                                    new int[]{arr_b7[v23] & 0xFF, arr_b7[v23 + 1] & 0xFF, arr_b7[v23 + 2] & 0xFF, arr_b7[v24] & 0xFF};
                                                                    v25 = arr_b7[v24] & 0xFF | ((arr_b7[v23] & 0xFF) << 24 | (arr_b7[v23 + 1] & 0xFF) << 16 | (arr_b7[v23 + 2] & 0xFF) << 8);
                                                                    goto label_294;
                                                                }
                                                                f0.f("readInt(index: " + f0.h + ", tagLength: " + f0.q);
                                                            }
                                                            else {
                                                                int v26 = f0.h;
                                                                int v27 = v26 + 2;
                                                                if(v27 < f0.q) {
                                                                    if(v26 + 3 >= arr_b7.length) {
                                                                        f0.f("readInt3(index: " + f0.h + ", bytes.length: " + arr_b7.length);
                                                                        goto label_291;
                                                                    }
                                                                    else {
                                                                        f0.h = v26 + 3;
                                                                        new int[]{arr_b7[v26] & 0xFF, arr_b7[v26 + 1] & 0xFF, arr_b7[v27] & 0xFF};
                                                                        v25 = arr_b7[v27] & 0xFF | ((arr_b7[v26] & 0xFF) << 16 | (arr_b7[v26 + 1] & 0xFF) << 8);
                                                                        goto label_294;
                                                                    }
                                                                    goto label_290;
                                                                }
                                                                else {
                                                                label_290:
                                                                    f0.f("readInt3(index: " + f0.h + ", tagLength: " + f0.q);
                                                                }
                                                            }
                                                        label_291:
                                                            v25 = -1;
                                                        }
                                                        else {
                                                            v25 = f0.e(arr_b7, true);
                                                        }
                                                    label_294:
                                                        int v28 = f0.q;
                                                        int v29 = v28 - f0.h;
                                                        int v30 = f0.j;
                                                        int v31 = f0.h;
                                                        if(v30 >= 3) {
                                                            v29 += 2;
                                                        }
                                                        if(v25 != 0) {
                                                            if(v25 > v29 || v25 < 0) {
                                                                f0.f("bad frame length(" + v17 + ": " + s3 + "): " + v25 + " (" + new String(arr_b8));
                                                                goto label_376;
                                                            }
                                                            else {
                                                                switch(v30) {
                                                                    case 2: {
                                                                        goto label_305;
                                                                    }
                                                                    case 3: 
                                                                    case 4: {
                                                                        goto label_307;
                                                                    }
                                                                }
                                                                f0.f("Unknown ID3v2 version: " + ((int)f0.j));
                                                                goto label_379;
                                                            label_305:
                                                                d d0 = new d();
                                                                goto label_351;
                                                            label_307:
                                                                if(v31 + 1 >= v28 || v31 + 1 >= arr_b7.length) {
                                                                    f0.f("readShort(index: " + f0.h + ", tagLength: " + f0.q + ", bytes.length: " + arr_b7.length);
                                                                    v32 = -1;
                                                                }
                                                                else {
                                                                    f0.h = v31 + 2;
                                                                    new byte[]{arr_b7[v31], arr_b7[v31 + 1]};
                                                                    v32 = arr_b7[v31] << 8 | arr_b7[v31 + 1];
                                                                }
                                                                d d1 = new d();
                                                                int v33 = f0.j;
                                                                if(v33 == 3) {
                                                                    v34 = (v32 & 0x8000) <= 0 ? v32 : 0x8000 ^ v32;
                                                                    if((v34 & 0x4000) > 0) {
                                                                        v34 ^= 0x4000;
                                                                    }
                                                                    if((v34 & 0x2000) > 0) {
                                                                        v34 ^= 0x2000;
                                                                    }
                                                                    if((v34 & 0x20) > 0) {
                                                                        v34 ^= 0x20;
                                                                    }
                                                                    if((v34 & 0x80) > 0) {
                                                                        v34 ^= 0x80;
                                                                    }
                                                                    if((v34 & 0x40) > 0) {
                                                                        v34 ^= 0x40;
                                                                    }
                                                                }
                                                                else if(v33 == 4) {
                                                                    v34 = (v32 & 0x4000) <= 0 ? v32 : v32 ^ 0x4000;
                                                                    if((v34 & 0x2000) > 0) {
                                                                        v34 ^= 0x2000;
                                                                    }
                                                                    if((v34 & 0x1000) > 0) {
                                                                        v34 ^= 0x1000;
                                                                    }
                                                                    if((v34 & 0x40) > 0) {
                                                                        v34 ^= 0x40;
                                                                    }
                                                                    if((v34 & 8) > 0) {
                                                                        v34 ^= 8;
                                                                    }
                                                                    if((v34 & 4) > 0) {
                                                                        v34 ^= 4;
                                                                    }
                                                                    if((v34 & 2) > 0) {
                                                                        d1.a = true;
                                                                        v34 ^= 2;
                                                                    }
                                                                    if((v34 & 1) > 0) {
                                                                        d1.b = true;
                                                                        v34 ^= 1;
                                                                    }
                                                                }
                                                                else {
                                                                    v34 = v32;
                                                                }
                                                                if(v34 <= 0) {
                                                                    d0 = d1;
                                                                }
                                                                else {
                                                                    break;
                                                                }
                                                            label_351:
                                                                if(v25 > 0) {
                                                                    if(d0.b) {
                                                                        f0.e(arr_b7, true);
                                                                        v25 -= 4;
                                                                    }
                                                                    byte[] arr_b9 = new byte[v25];
                                                                    System.arraycopy(arr_b7, f0.h, arr_b9, 0, v25);
                                                                    f0.h += v25;
                                                                    if(d0.a) {
                                                                        arr_b9 = f.g(arr_b9);
                                                                    }
                                                                    LogU.v("MyID3v2Read", "length = " + arr_b9.length + "frameIDString = " + s3);
                                                                    try {
                                                                        "USLT".equals(s3);
                                                                        if(arr_b8[0] != 84) {
                                                                            f0.b(v25, s3, arr_b9);
                                                                        }
                                                                    }
                                                                    catch(IOException iOException1) {
                                                                        f0.f(iOException1.getMessage());
                                                                        goto label_379;
                                                                    }
                                                                }
                                                                ++v17;
                                                                continue;
                                                            }
                                                            ++v19;
                                                            goto label_252;
                                                        }
                                                    }
                                                    goto label_376;
                                                }
                                                f0.f("Unknown id3v2 frame flags(id3v2 version: " + ((int)f0.j) + "): " + Long.toHexString(v32));
                                                goto label_379;
                                            label_376:
                                                f0.g = true;
                                            }
                                            else {
                                                f0.f("missing tag");
                                            }
                                        label_379:
                                            f0.b = true;
                                        }
                                        else if(f0.e) {
                                            f0.c = true;
                                        }
                                    }
                                }
                            }
                            if(f0.c || (!f0.b || f0.d)) {
                                l0 = null;
                                goto label_403;
                            }
                            goto label_387;
                        }
                        goto label_403;
                    }
                    catch(Exception exception0) {
                        goto label_421;
                    }
                    catch(Throwable throwable0) {
                        goto label_433;
                    }
                }
                throw throwable2;
            label_387:
                HashMap hashMap0 = f0.n;
                if(hashMap0 == null) {
                    e0 = null;
                }
                else {
                    try {
                        e0 = new e();
                        for(int v35 = 0; v35 < hashMap0.size(); ++v35) {
                            hashMap0.get(v35);
                        }
                    }
                    catch(Throwable unused_ex) {
                        e0 = null;
                    }
                }
                try {
                    l0 = new l(1, e0, hashMap0);
                    goto label_403;
                }
                catch(Exception exception0) {
                    goto label_421;
                }
                catch(Throwable throwable0) {
                    goto label_433;
                }
                try {
                label_398:
                    object1 = object0;
                }
                catch(Exception exception0) {
                    goto label_420;
                }
                catch(Throwable throwable0) {
                    object1 = object0;
                    goto label_433;
                }
                try {
                    l0 = null;
                    goto label_403;
                }
                catch(Exception exception0) {
                    goto label_421;
                }
                catch(Throwable throwable0) {
                    goto label_433;
                }
                try {
                label_401:
                    l0 = null;
                    object1 = object0;
                }
                catch(Exception exception0) {
                    goto label_420;
                }
                catch(Throwable throwable0) {
                    object1 = object0;
                    goto label_433;
                }
                try {
                    try {
                    label_403:
                        if(l0 != null) {
                            Map map0 = (Map)l0.c;
                            if(map0 != null && map0.size() > 0) {
                                arrayList0 = (ArrayList)((Map)l0.c).get("XSYL");
                                goto label_407;
                            }
                            goto label_409;
                        }
                        goto label_411;
                    }
                    catch(Exception exception0) {
                        goto label_421;
                    }
                label_407:
                    __monitor_exit(object1);
                    return arrayList0;
                label_409:
                    __monitor_exit(object1);
                    return null;
                    try {
                    label_411:
                        LogU.i("DownloadableDcfController", "src_set == null");
                    }
                    catch(Exception exception0) {
                        goto label_421;
                    }
                    __monitor_exit(object1);
                    return null;
                }
                catch(Throwable throwable0) {
                    goto label_433;
                }
                try {
                label_417:
                    file0.delete();
                    goto label_424;
                }
                catch(Exception exception0) {
                    goto label_420;
                }
                catch(Throwable throwable0) {
                    object1 = object0;
                    goto label_433;
                }
            }
            catch(Exception exception0) {
            label_420:
                object1 = object0;
                try {
                label_421:
                    LogU.e("DownloadableDcfController", "getDCFLyrics() " + exception0);
                    __monitor_exit(object1);
                    return null;
                }
                catch(Throwable throwable0) {
                    goto label_433;
                }
                try {
                label_424:
                    __monitor_exit(object0);
                    return null;
                label_426:
                    __monitor_exit(object0);
                    return null;
                }
                catch(Throwable throwable0) {
                    object1 = object0;
                    goto label_433;
                }
            }
            catch(Throwable throwable0) {
                object1 = object0;
                goto label_433;
            }
        }
        try {
            return null;
        label_433:
            __monitor_exit(object1);
        }
        catch(Throwable throwable0) {
            goto label_433;
        }
        throw throwable0;
    }

    @Override  // com.iloen.melon.drm.AbsDcfController
    public final DcfFile d(String s) {
        LogU.d("DownloadableDcfController", "path getDcfFile : " + s);
        if(StorageUtils.isScopedStorage()) {
            return this.j(Uri.parse(s));
        }
        DcfFile dcfFile0 = new DcfFile(s);  // 初始化器: Lcom/iloen/melon/drm/MelonFile;-><init>(Ljava/lang/String;)V
        synchronized(DownloadableDcfController.d) {
            try {
                int v1 = this.c.loadFile(s);
                this.l(v1, dcfFile0);
                if(dcfFile0.i < 0L) {
                    DcfLog.e("DownloadableDcfController", "path getDcfFile() error : " + dcfFile0);
                }
                if(v1 > 0) {
                    this.c.unloadFile(v1);
                }
            }
            catch(Exception exception0) {
                DcfLog.e("DownloadableDcfController", "getDcfFile() path : " + s + ", Exception : " + exception0);
            }
        }
        return dcfFile0;
    }

    @Override  // com.iloen.melon.drm.AbsDcfController
    public final LinkedList e() {
        LogU.d("DownloadableDcfController", "getDrmExpiredFiles");
        LinkedList linkedList0 = new LinkedList();
        g.a.m();
        List list0 = g.e();
        if(!list0.isEmpty()) {
            DcfLog.d("DownloadableDcfController", "getDrmExpiredFiles song size : " + list0.size());
            for(Object object0: list0) {
                String s = ((k)object0).b;
                String s1 = ((k)object0).c;
                DcfFile dcfFile0 = StorageUtils.isScopedStorage() ? this.d(s1) : this.d(s);
                if(dcfFile0.i == -101L) {
                    linkedList0.add(dcfFile0);
                }
            }
        }
        return linkedList0;
    }

    @Override  // com.iloen.melon.drm.AbsDcfController
    public final void f(String s) {
        this.b = s;
        LogU.i("DownloadableDcfController", "initialize : mdn : " + s);
        this.c.loadDRMLocalServer(this.a);
        String s1 = r.a(s);
        long v = this.c.setClientID(s1);
        if(v < 0L) {
            DcfLog.e("DownloadableDcfController", "initialize() invalid clientId clientId : " + s + ", result : " + v);
        }
    }

    public final byte[] i(String s) {
        int v3;
        int v2;
        b b0;
        Z.w("getAlbumArtData()", s, "DownloadableDcfController");
        byte[] arr_b = null;
        try {
            b0 = b.b("getAlbumArtData");
            long v = MelonDRMMetaInterface.DRMMetaSetClientID(r.a(this.b));
            int v1 = Long.compare(v, 0L);
            if(v1 < 0) {
                LogU.e("DownloadableDcfController", "getAlbumArtData() invalid clientId result: " + v);
            }
            v2 = FIN.finallyOpen$NT();
            if(v1 >= 0 && s != null) {
                goto label_9;
            }
            goto label_32;
        }
        catch(DrmInitException drmInitException0) {
            goto label_37;
        }
        try {
        label_9:
            if(StorageUtils.isScopedStorage()) {
                Uri uri0 = Uri.parse(s);
                if(uri0 == null) {
                    v3 = -1;
                }
                else {
                    LogU.d("DrmMetaWrapper", "uri open = " + uri0);
                    v3 = MelonDRMMetaInterface.DRMMetaOpen(this.a, uri0, 3, 1);
                }
            }
            else {
                byte[] arr_b1 = s.getBytes(StandardCharsets.UTF_8);
                v3 = arr_b1 == null ? -1 : b.c(arr_b1);
            }
            if(v3 > -1) {
                long v4 = MelonDRMMetaInterface.DRMMetaGetBufferSizeForAlbumArt(((short)v3));
                if(v4 > 0L) {
                    ByteBuffer byteBuffer0 = ByteBuffer.allocate(((int)v4));
                    if(v4 == MelonDRMMetaInterface.DRMMetaExtractAlbumArt(((short)v3), byteBuffer0)) {
                        arr_b = byteBuffer0.array();
                        LogU.d("DownloadableDcfController", "getAlbumArtData() Success for extraction of album art");
                    }
                }
                else {
                    LogU.e("DownloadableDcfController", "getAlbumArtData() imageSize: " + v4);
                }
                MelonDRMMetaInterface.DRMMetaClose(((short)v3));
            }
            goto label_32;
        }
        catch(Exception exception0) {
        }
        try {
            LogU.w("DownloadableDcfController", "getAlbumArtData() " + exception0);
        label_32:
            FIN.finallyCodeBegin$NT(v2);
            b0.e();
            FIN.finallyCodeEnd$NT(v2);
        }
        catch(DrmInitException drmInitException0) {
        label_37:
            drmInitException0.printStackTrace();
            LogU.e("DownloadableDcfController", drmInitException0.toString());
        }
        return arr_b;
    }

    public final DcfFile j(Uri uri0) {
        LogU.d("DownloadableDcfController", "uri getDcfFile : " + uri0);
        DcfFile dcfFile0 = Objects.equals(uri0.getScheme(), "file") ? new DcfFile(uri0.getPath()) : new DcfFile(this.a, uri0);  // 初始化器: Lcom/iloen/melon/drm/MelonFile;-><init>(Ljava/lang/String;)V / 初始化器: Lcom/iloen/melon/drm/MelonFile;-><init>(Landroid/content/Context;Landroid/net/Uri;)V
        synchronized(DownloadableDcfController.d) {
            try {
                int v1 = this.c.loadFile(uri0);
                this.l(v1, dcfFile0);
                if(dcfFile0.i < 0L) {
                    DcfLog.e("DownloadableDcfController", "uri getDcfFile() error : " + dcfFile0);
                }
                if(v1 > 0) {
                    this.c.unloadFile(v1);
                }
            }
            catch(Exception exception0) {
                DcfLog.e("DownloadableDcfController", "getDcfFile() path : " + uri0 + ", Exception : " + exception0);
            }
        }
        return dcfFile0;
    }

    public final String k(String s) {
        String s1 = null;
        a a0 = this.c;
        if(a0 != null) {
            try {
                String s2 = a0.getUrl();
                LogU.d("DownloadableDcfController", "getServiceUrl hostUrl : " + s2);
                if(!TextUtils.isEmpty(s2)) {
                    if(StorageUtils.isScopedStorage()) {
                        s1 = s2 + "/" + s;
                    }
                    else {
                        try {
                            s1 = s2 + "/" + URLEncoder.encode(s, "UTF-8");
                        }
                        catch(UnsupportedEncodingException unsupportedEncodingException0) {
                            unsupportedEncodingException0.printStackTrace();
                        }
                    }
                }
            }
            catch(DrmNotInitializedDrmException | DrmSocketNullDrmException drmNotInitializedDrmException0) {
                DcfLog.e("DownloadableDcfController", "getServiceUrl path : " + s + ", e : " + drmNotInitializedDrmException0);
            }
        }
        LogU.d("DownloadableDcfController", "getServiceUrl targetUrl : " + s1 + ", path : " + s);
        return s1;
    }

    public final void l(int v, DcfFile dcfFile0) {
        if(v <= 0) {
            DcfLog.e("DownloadableDcfController", "updateDcfFile error fd : " + v);
            dcfFile0.g(((long)v));
            return;
        }
        a a0 = this.c;
        long v1 = a0.getErrorCode(v);
        LogU.d("DownloadableDcfController", "updateDcfFile before errorCode : " + v1);
        if(!AndroidSettings.isAutoTimeChecked(this.a)) {
            v1 = -103L;
        }
        else if(v1 > 0L) {
            v1 = AbsDcfController.g(a0.getValidPeriod(v)) ? -101L : 0L;
        }
        LogU.d("DownloadableDcfController", "updateDcfFile after errorCode : " + v1);
        dcfFile0.g(v1);
        String s = a0.getContentDescription(v);
        String s1 = a0.getContentID(v);
        String s2 = SongMetaParser.parseDcfSongId(s);
        String s3 = SongMetaParser.parseLCode(s1);
        dcfFile0.e(s2);
        dcfFile0.f(s3);
    }
}

