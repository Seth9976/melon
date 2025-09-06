package com.digicap.melon.service;

import DigiCAP.SKT.DRM.MelonDRMInterface;
import U4.x;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.digicap.melon.exception.DrmSocketNullDrmException;
import com.digicap.melon.exception.ServerSocketNullDrmException;
import com.digicap.melon.exception.UnsatisfiedLinkErrorDrmException;
import com.digicap.melon.log.DigicapLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

public class melonDRMService extends Service {
    public class SocketListener extends Thread {
        public volatile boolean a;
        public ServerSocket b;
        public TransmissionManager c;
        public final melonDRMService d;

        public SocketListener() {
            this.a = false;
            this.c = null;
            try {
                melonDRMService.e.D("Create ServerSocket object - S");
                this.b = new ServerSocket(0, 0, InetAddress.getByName("127.0.0.1"));
                melonDRMService.e.D("Create ServerSocket object - E");
            }
            catch(UnknownHostException unknownHostException0) {
                melonDRMService.e.D("Exception, Create ServerSocket(" + unknownHostException0.toString() + ")");
                this.b = null;
            }
            catch(IOException iOException0) {
                melonDRMService.e.D("Exception, Create ServerSocket(" + iOException0.toString() + ")");
                this.b = null;
            }
        }

        public int getLocalPort() {
            ServerSocket serverSocket0 = this.b;
            if(serverSocket0 == null) {
                throw new ServerSocketNullDrmException();
            }
            return serverSocket0.getLocalPort();
        }

        @Override
        public void run() {
            melonDRMService.e.D("SocketListener " + this.a);
            while(!this.a) {
                try {
                    if(this.b == null) {
                        melonDRMService.e.D("Failure, Create ServerSocket");
                        return;
                    }
                    melonDRMService.e.D("Start SocketListener");
                    Socket socket0 = this.b.accept();
                    if(this.a) {
                        this.b.close();
                        return;
                    }
                    this.c = new TransmissionManager(melonDRMService.this, socket0);
                    this.c.setDaemon(true);
                    this.c.start();
                }
                catch(SocketException unused_ex) {
                    melonDRMService.e.D("SocketListener3 " + this.a);
                }
                catch(IOException unused_ex) {
                    melonDRMService.e.D("SocketListener4 " + this.a);
                }
                catch(Exception unused_ex) {
                    melonDRMService.e.D("SocketListener5 " + this.a);
                }
            }
        }

        public void stopSocket() {
            try {
                this.a = true;
                ServerSocket serverSocket0 = this.b;
                if(serverSocket0 != null) {
                    serverSocket0.close();
                    this.b = null;
                }
            }
            catch(IOException iOException0) {
                iOException0.printStackTrace();
            }
        }
    }

    class TransmissionManager extends Thread {
        public final Socket a;
        public final melonDRMService b;

        public TransmissionManager(Socket socket0) {
            this.a = socket0;
        }

        @Override
        public void run() {
            String s8;
            String s7;
            DigicapLog digicapLog0;
            String s11;
            String s10;
            long v23;
            int v22;
            int v21;
            long v19;
            byte[] arr_b1;
            ByteBuffer byteBuffer0;
            long v17;
            int v15;
            RandomAccessFile randomAccessFile4;
            String s4;
            String s3;
            RandomAccessFile randomAccessFile3;
            long v9;
            byte[] arr_b;
            RandomAccessFile randomAccessFile2;
            File file0;
            long v8;
            boolean z;
            long v7;
            long v5;
            int v2;
            String s1;
            String s;
            RandomAccessFile randomAccessFile1;
            Throwable throwable1;
            InputStream inputStream1;
            RandomAccessFile randomAccessFile0;
            OutputStream outputStream0;
            int v1;
            InputStream inputStream0;
            Socket socket0 = this.a;
            melonDRMService melonDRMService0 = melonDRMService.this;
            URLParser uRLParser0 = new URLParser();
            int v = 0;
            try {
                melonDRMService.e.D("Start TransmissionManager");
                inputStream0 = socket0.getInputStream();
            }
            catch(Exception exception0) {
                v1 = 0;
                outputStream0 = null;
                randomAccessFile0 = null;
                inputStream1 = null;
                goto label_400;
            }
            catch(Throwable throwable0) {
                throwable1 = throwable0;
                randomAccessFile1 = null;
                outputStream0 = null;
                inputStream1 = null;
                goto label_435;
            }
            try {
                outputStream0 = socket0.getOutputStream();
            }
            catch(Exception exception0) {
                inputStream1 = inputStream0;
                v1 = 0;
                outputStream0 = null;
                goto label_399;
            }
            catch(Throwable throwable2) {
                inputStream1 = inputStream0;
                throwable1 = throwable2;
                randomAccessFile1 = null;
                outputStream0 = null;
                goto label_435;
            }
            try {
                melonDRMService.e.D("Parsing HTTP header of requested message");
                s = melonDRMService.b(melonDRMService0, inputStream0);
                if(s != null) {
                    melonDRMService.e.D("Requested message of media framework : \n\n" + s);
                    if(s.indexOf("GET", 0) == -1 && s.indexOf("HEAD", 0) == -1) {
                        goto label_56;
                    }
                    goto label_45;
                }
                goto label_383;
            }
            catch(Exception exception0) {
                inputStream1 = inputStream0;
                v1 = 0;
                goto label_399;
            }
            catch(Throwable throwable3) {
                inputStream1 = inputStream0;
                throwable1 = throwable3;
                randomAccessFile1 = null;
                goto label_435;
            }
            try {
            label_45:
                s1 = new String(s.substring(s.indexOf("/", 0), s.indexOf("HTTP", 0) - 1));
                while(true) {
                label_46:
                    if(!s1.contains("/content://")) {
                        melonDRMService.e.D("Requested file name : " + s1);
                        if(!s1.contains("content://")) {
                            uRLParser0.parseURL(URLDecoder.decode(s1));
                            goto label_52;
                        }
                        break;
                    }
                    s1 = s1.replace("/content://", "content://");
                }
            }
            catch(Exception exception0) {
                inputStream1 = inputStream0;
                v1 = 0;
                goto label_399;
            }
            catch(Throwable throwable4) {
                inputStream1 = inputStream0;
                goto label_390;
            }
            try {
                uRLParser0.parseURL(s1);
            }
            catch(Exception exception0) {
                inputStream1 = inputStream0;
                v1 = 0;
                goto label_399;
            }
            catch(Throwable throwable5) {
                throwable1 = throwable5;
                inputStream1 = inputStream0;
                randomAccessFile1 = null;
                goto label_435;
            }
            try {
            label_52:
                if(s.indexOf("HTTP/1.0") != -1) {
                    v2 = 1;
                }
                else if(s.indexOf("HTTP/1.1") != -1) {
                    v2 = 2;
                }
                else {
                label_56:
                    v2 = 0;
                }
            }
            catch(Exception exception0) {
                inputStream1 = inputStream0;
                v1 = 0;
                goto label_399;
            }
            catch(Throwable throwable4) {
                inputStream1 = inputStream0;
                goto label_390;
            }
            if(s.indexOf("Range", 0) == -1) {
                v7 = 0L;
                v5 = 0L;
                z = false;
            }
            else {
                try {
                    if(s.indexOf("bytes=", 0) == -1) {
                        v7 = 0L;
                        v5 = 0L;
                        z = false;
                    }
                    else {
                        int v3 = s.indexOf("bytes=", 0);
                        int v4 = s.indexOf("-", v3 + 6);
                        v5 = (long)Integer.parseInt(s.substring(v3 + 6, v4));
                        int v6 = s.indexOf("\r\n", v4 + 1);
                        v7 = v4 + 1 == v6 ? 0L : ((long)Integer.parseInt(s.substring(v4 + 1, v6)));
                        melonDRMService.e.D("Requested bytes range : " + v5 + "-" + v7);
                        z = true;
                    }
                }
                catch(Exception exception0) {
                    inputStream1 = inputStream0;
                    v1 = 0;
                    goto label_399;
                }
                catch(Throwable throwable6) {
                    throwable1 = throwable6;
                    inputStream1 = inputStream0;
                    randomAccessFile1 = null;
                    goto label_435;
                }
            }
            try {
                v8 = v7;
                melonDRMService.e.D("File name : " + uRLParser0.getContentURL());
                melonDRMService.e.D("File extention : " + uRLParser0.getContentExtension());
                inputStream1 = inputStream0;
                if(melonDRMService0.isDcfContent(uRLParser0)) {
                    goto label_172;
                }
                else {
                    goto label_96;
                }
                goto label_355;
            }
            catch(Exception exception0) {
                inputStream1 = inputStream0;
                v1 = 0;
                goto label_399;
                try {
                label_96:
                    file0 = new File(uRLParser0.getContentURL());
                    if(file0.exists()) {
                        melonDRMService.e.D("File exsit.");
                        randomAccessFile2 = new RandomAccessFile(file0, "r");
                        goto label_100;
                    }
                    else {
                        goto label_166;
                    }
                    goto label_170;
                }
                catch(Exception exception0) {
                    v1 = 0;
                    goto label_399;
                }
                catch(Throwable throwable7) {
                    throwable1 = throwable7;
                    randomAccessFile1 = null;
                    goto label_435;
                }
                try {
                label_100:
                    arr_b = new byte[0x2000];
                    v9 = file0.length();
                }
                catch(Exception exception0) {
                    randomAccessFile3 = randomAccessFile2;
                    randomAccessFile0 = randomAccessFile3;
                    v1 = 0;
                    goto label_400;
                }
                catch(Throwable throwable8) {
                    randomAccessFile3 = randomAccessFile2;
                    throwable1 = throwable8;
                    randomAccessFile1 = randomAccessFile3;
                    goto label_435;
                }
                if(Long.compare(v5, 0L) != 0 || v8 != 0L) {
                    if(v8 == 0L) {
                        v8 = v9 - 1L;
                    }
                    switch(v2) {
                        case 1: {
                            s4 = "200";
                            s3 = "HTTP/1.1 200 OK";
                            break;
                        }
                        case 2: {
                            s4 = "206";
                            s3 = "HTTP/1.1 206 Partial Content";
                            break;
                        }
                        default: {
                            s3 = null;
                            s4 = null;
                        }
                    }
                    try {
                        try {
                            String s5 = s3 + "\r\nhttp_code=" + s4 + "\r\nContent-Type: audio/mpeg\r\nServer: DigiCAP DRM Server\r\nAccept-Ranges: bytes\r\nContent-Length: " + (v8 - v5 + 1L) + "\r\nContent-Range: bytes " + v5 + "-" + v8 + "/" + v9 + "\r\n\r\n";
                            outputStream0.write(s5.getBytes());
                            outputStream0.flush();
                            randomAccessFile3 = randomAccessFile2;
                            melonDRMService.e.D("Header info : \n" + s5);
                            randomAccessFile3 = randomAccessFile2;
                            goto label_144;
                        }
                        catch(Exception exception0) {
                            try {
                                randomAccessFile3 = randomAccessFile2;
                                randomAccessFile0 = randomAccessFile3;
                                v1 = 0;
                                goto label_400;
                            label_144:
                                randomAccessFile3.seek(v5);
                                int v12 = 0;
                                int v13;
                                while((v13 = randomAccessFile3.read(arr_b, 0, 0x2000)) != -1) {
                                    outputStream0.write(arr_b, 0, v13);
                                    outputStream0.flush();
                                    v12 += v13;
                                    melonDRMService.e.D("read size " + v13 + "(" + v12 + ")");
                                    if(((long)v12) >= v8) {
                                        melonDRMService.e.D("readTotalSize >= e_bytes");
                                        break;
                                    }
                                }
                                try {
                                    randomAccessFile4 = randomAccessFile3;
                                    goto label_170;
                                }
                                catch(Exception exception0) {
                                    randomAccessFile0 = randomAccessFile3;
                                    v1 = 0;
                                    goto label_400;
                                }
                                catch(Throwable throwable8) {
                                    throwable1 = throwable8;
                                    randomAccessFile1 = randomAccessFile3;
                                    goto label_435;
                                }
                            }
                            catch(Exception exception0) {
                                randomAccessFile0 = randomAccessFile3;
                                v1 = 0;
                                goto label_400;
                            }
                        }
                    }
                    catch(Throwable throwable8) {
                        throwable1 = throwable8;
                        randomAccessFile1 = randomAccessFile3;
                        goto label_435;
                    }
                }
                else {
                    try {
                        randomAccessFile3 = randomAccessFile2;
                        String s2 = "HTTP/1.1 200 OK\r\nhttp_code=200\r\nContent-Type: audio/mpeg\r\nServer: DigiCAP DRM Server\r\nAccept-Ranges: bytes\r\nContent-Length: " + v9 + "\r\n\r\n";
                        outputStream0.write(s2.getBytes());
                        outputStream0.flush();
                        melonDRMService.e.D("Header info : \n" + s2);
                        int v10 = 0;
                        int v11;
                        while((v11 = randomAccessFile3.read(arr_b, 0, 0x2000)) != -1) {
                            outputStream0.write(arr_b, 0, v11);
                            outputStream0.flush();
                            v10 += v11;
                            melonDRMService.e.D("read size " + v11 + "(" + v10 + ")");
                        }
                    }
                    catch(Exception exception0) {
                        randomAccessFile0 = randomAccessFile3;
                        v1 = 0;
                        goto label_400;
                    }
                    catch(Throwable throwable8) {
                        throwable1 = throwable8;
                        randomAccessFile1 = randomAccessFile3;
                        goto label_435;
                    }
                }
                randomAccessFile4 = randomAccessFile3;
                goto label_170;
                try {
                label_166:
                    melonDRMService.e.D("File doesn\'t exsit.");
                    outputStream0.write("HTTP/1.0 503 Service Unavailable\r\nServer: DigiCAP DRM Server\r\n\r\n".getBytes());
                    outputStream0.flush();
                    randomAccessFile4 = null;
                }
                catch(Exception exception0) {
                    v1 = 0;
                    goto label_399;
                }
                catch(Throwable throwable7) {
                    throwable1 = throwable7;
                    randomAccessFile1 = null;
                    goto label_435;
                }
            label_170:
                int v14 = 0;
                goto label_355;
                try {
                label_172:
                    if(uRLParser0.getContentURL().contains("content://")) {
                        goto label_270;
                    }
                    else if(!new File(uRLParser0.getContentURL()).exists()) {
                        melonDRMService.e.D("HTTP/1.0 503 Service Unavailable\r\nServer: DigiCAP DRM Server\r\n\r\n");
                        outputStream0.write("HTTP/1.0 503 Service Unavailable\r\nServer: DigiCAP DRM Server\r\n\r\n".getBytes());
                        outputStream0.flush();
                        v14 = 0;
                    }
                    else {
                        if(!z) {
                            goto label_180;
                        }
                        goto label_181;
                    }
                    goto label_354;
                }
                catch(Exception exception0) {
                    v1 = 0;
                    goto label_399;
                }
                catch(Throwable throwable4) {
                    goto label_390;
                }
                try {
                label_180:
                    melonDRMService.e.D("Connect content");
                }
                catch(Exception exception0) {
                    v1 = 0;
                    goto label_399;
                }
                catch(Throwable throwable7) {
                    throwable1 = throwable7;
                    randomAccessFile1 = null;
                    goto label_435;
                }
                try {
                label_181:
                    v15 = melonDRMService0.b.open(uRLParser0.getContentURL().getBytes("UTF-8"), 3, 1);
                }
                catch(Exception exception0) {
                    v1 = 0;
                    goto label_399;
                }
                catch(Throwable throwable9) {
                    throwable1 = throwable9;
                    randomAccessFile1 = null;
                    goto label_435;
                }
                if(v15 <= 0) {
                    try {
                        melonDRMService.e.D("Failure, connect content(" + v15 + ")");
                    }
                    catch(Exception exception0) {
                        v1 = 0;
                        goto label_399;
                    }
                    catch(Throwable throwable7) {
                        throwable1 = throwable7;
                        randomAccessFile1 = null;
                        goto label_435;
                    }
                }
                try {
                    melonDRMService.e.D("Success, Content ID : " + melonDRMService0.drm_getContentID(v15));
                    melonDRMService.e.D("Success, Content Description : " + melonDRMService0.drm_getContentDescription(v15));
                    melonDRMService.e.D("Success, Valid Period : " + melonDRMService0.drm_getValidPeriod(v15));
                    melonDRMService.e.D("Success, Original File Size : " + melonDRMService0.drm_getOriginalFileSize(v15));
                    melonDRMService.e.D("Success, DCF File Size : " + melonDRMService0.drm_getFileSize(v15));
                    if(melonDRMService0.b.getErrorCode(v15) != 1L) {
                        long v16 = melonDRMService0.b.getErrorCode(v15);
                        if(v16 == -101L) {
                            melonDRMService.e.D("Content has expired");
                        }
                        else if(v16 == -102L) {
                            melonDRMService.e.D("MIN of content and MIN of Device isn\'t same");
                        }
                        else {
                            melonDRMService.e.D("Faulure, connect content(" + v16 + ")");
                        }
                        melonDRMService.e.D("HTTP/1.0 503 Service Unavailable\r\nServer: DigiCAP DRM Server\r\n\r\n");
                        outputStream0.write("HTTP/1.0 503 Service Unavailable\r\nServer: DigiCAP DRM Server\r\n\r\n".getBytes());
                        outputStream0.flush();
                        v14 = v15;
                        goto label_354;
                    }
                }
                catch(Exception exception0) {
                    v1 = v15;
                    goto label_399;
                }
                catch(Throwable throwable10) {
                    throwable1 = throwable10;
                    v = v15;
                    randomAccessFile1 = null;
                    goto label_435;
                }
                try {
                    try {
                        v17 = melonDRMService0.b.seek(((int)(((short)v15))), 0L, 2);
                        melonDRMService0.b.seek(((int)(((short)v15))), 0L, 3);
                        if(!z) {
                            goto label_219;
                        }
                        goto label_220;
                    }
                    catch(Exception exception0) {
                        v1 = v15;
                        goto label_399;
                    }
                    try {
                    label_219:
                        melonDRMService.e.D("Success, connect content");
                    }
                    catch(Exception exception0) {
                        v1 = v15;
                        goto label_399;
                    }
                    try {
                    label_220:
                        byteBuffer0 = ByteBuffer.allocate(0x2000);
                        arr_b1 = new byte[0x2000];
                        if(v5 != 0L || v8 != 0L) {
                            goto label_235;
                        }
                        else {
                            goto label_223;
                        }
                        v14 = v15;
                        goto label_354;
                    }
                    catch(Exception exception0) {
                        v1 = v15;
                        goto label_399;
                    }
                    try {
                    label_223:
                        String s6 = "HTTP/1.1 200 OK\r\nhttp_code=200\r\nContent-Type: audio/mpeg\r\nServer: DigiCAP DRM Server\r\nAccept-Ranges: bytes\r\nContent-Length: " + v17 + "\r\n\r\n";
                        outputStream0.write(s6.getBytes());
                        outputStream0.flush();
                        melonDRMService.e.D("httpHeader :\n" + s6);
                        while(true) {
                            long v18 = melonDRMService0.b.read(((int)(((short)v15))), byteBuffer0, 0x2000L);
                            if(v18 <= 0L) {
                                v14 = v15;
                                goto label_354;
                            }
                            byteBuffer0.flip();
                            byteBuffer0.get(arr_b1, 0, ((int)v18));
                            outputStream0.write(arr_b1, 0, ((int)v18));
                            outputStream0.flush();
                            byteBuffer0.flip();
                        }
                    label_235:
                        v19 = v8 == 0L ? v17 - 1L : v8;
                        switch(v2) {
                            case 1: {
                                s7 = "200";
                                s8 = "HTTP/1.1 200 OK";
                                goto label_245;
                            }
                            case 2: {
                                goto label_243;
                            }
                        }
                    }
                    catch(Exception exception0) {
                        v1 = v15;
                        goto label_399;
                    }
                }
                catch(Throwable throwable11) {
                    throwable1 = throwable11;
                    v = v15;
                    randomAccessFile1 = null;
                    goto label_435;
                }
                s7 = null;
                s8 = null;
                goto label_245;
            label_243:
                s7 = "206";
                s8 = "HTTP/1.1 206 Partial Content";
                try {
                label_245:
                    String s9 = s8 + "\r\nhttp_code=" + s7 + "\r\nContent-Type: audio/mpeg\r\nServer: DigiCAP DRM Server\r\nAccept-Ranges: bytes\r\nContent-Length: " + (v19 - v5 + 1L) + "\r\nContent-Range: bytes " + v5 + "-" + v19 + "/" + v17 + "\r\n\r\n";
                    outputStream0.write(s9.getBytes());
                    outputStream0.flush();
                    melonDRMService.e.D("httpHeader :\n" + s9);
                    melonDRMService0.b.seek(((int)(((short)v15))), v5, 1);
                    while(true) {
                        long v20 = melonDRMService0.b.read(((int)(((short)v15))), byteBuffer0, 0x2000L);
                        if(v20 <= 0L) {
                            v14 = v15;
                            goto label_354;
                        }
                        byteBuffer0.flip();
                        byteBuffer0.get(arr_b1, 0, ((int)v20));
                        outputStream0.write(arr_b1, 0, ((int)v20));
                        outputStream0.flush();
                        byteBuffer0.flip();
                    }
                }
                catch(Exception exception0) {
                    v1 = v15;
                    goto label_399;
                }
                catch(Throwable throwable11) {
                    throwable1 = throwable11;
                    v = v15;
                    randomAccessFile1 = null;
                    goto label_435;
                }
                try {
                label_270:
                    if(!z) {
                        melonDRMService.e.D("Connect content");
                    }
                    v21 = melonDRMService0.b.open(melonDRMService0.d, Uri.parse(uRLParser0.getContentURL()), 3, 1);
                    if(v21 <= 0) {
                        melonDRMService.e.D("Failure, connect content(" + v21 + ")");
                    }
                    goto label_279;
                }
                catch(Exception exception0) {
                    v1 = 0;
                    goto label_399;
                }
                catch(Throwable throwable7) {
                }
                throwable1 = throwable7;
                randomAccessFile1 = null;
                goto label_435;
                try {
                label_279:
                    if(melonDRMService0.b.getErrorCode(v21) == 1L) {
                        goto label_287;
                    }
                    else {
                        goto label_334;
                    }
                    goto label_353;
                }
                catch(Exception exception0) {
                    v1 = v21;
                    goto label_399;
                }
                catch(Throwable throwable12) {
                    v1 = v21;
                    throwable1 = throwable12;
                    v = v1;
                    randomAccessFile1 = null;
                    goto label_435;
                }
                try {
                    try {
                    label_287:
                        v1 = v21;
                        v22 = v1;
                        v23 = melonDRMService0.b.seek(((int)(((short)v21))), 0L, 2);
                        v22 = v1;
                    }
                    catch(Exception exception0) {
                        goto label_399;
                    }
                    try {
                        melonDRMService0.b.seek(((int)(((short)v21))), 0L, 3);
                        if(!z) {
                            melonDRMService.e.D("Success, connect content");
                        }
                        ByteBuffer byteBuffer1 = ByteBuffer.allocate(0x2000);
                        byte[] arr_b2 = new byte[0x2000];
                        if(v5 == 0L && v8 == 0L) {
                            String s13 = "HTTP/1.1 200 OK\r\nhttp_code=200\r\nContent-Type: audio/mpeg\r\nServer: DigiCAP DRM Server\r\nAccept-Ranges: bytes\r\nContent-Length: " + v23 + "\r\n\r\n";
                            outputStream0.write(s13.getBytes());
                            outputStream0.flush();
                            melonDRMService.e.D("httpHeader :\n" + s13);
                            long v26;
                            while((v26 = melonDRMService0.b.read(((int)(((short)v21))), byteBuffer1, 0x2000L)) > 0L) {
                                byteBuffer1.flip();
                                byteBuffer1.get(arr_b2, 0, ((int)v26));
                                outputStream0.write(arr_b2, 0, ((int)v26));
                                outputStream0.flush();
                                byteBuffer1.flip();
                            }
                        }
                        else {
                            long v24 = v8 == 0L ? v23 - 1L : v8;
                            switch(v2) {
                                case 1: {
                                    s10 = "200";
                                    s11 = "HTTP/1.1 200 OK";
                                    break;
                                }
                                case 2: {
                                    s10 = "206";
                                    s11 = "HTTP/1.1 206 Partial Content";
                                    break;
                                }
                                default: {
                                    s10 = null;
                                    s11 = null;
                                }
                            }
                            String s12 = s11 + "\r\nhttp_code=" + s10 + "\r\nContent-Type: audio/mpeg\r\nServer: DigiCAP DRM Server\r\nAccept-Ranges: bytes\r\nContent-Length: " + (v24 - v5 + 1L) + "\r\nContent-Range: bytes " + v5 + "-" + v24 + "/" + v23 + "\r\n\r\n";
                            outputStream0.write(s12.getBytes());
                            outputStream0.flush();
                            melonDRMService.e.D("httpHeader :\n" + s12);
                            melonDRMService0.b.seek(((int)(((short)v21))), v5, 1);
                            long v25;
                            while((v25 = melonDRMService0.b.read(((int)(((short)v21))), byteBuffer1, 0x2000L)) > 0L) {
                                byteBuffer1.flip();
                                byteBuffer1.get(arr_b2, 0, ((int)v25));
                                outputStream0.write(arr_b2, 0, ((int)v25));
                                outputStream0.flush();
                                byteBuffer1.flip();
                            }
                        }
                        v1 = v22;
                        goto label_353;
                    }
                    catch(Exception exception0) {
                        goto label_398;
                    }
                }
                catch(Throwable throwable13) {
                    goto label_394;
                }
                try {
                label_334:
                    v1 = v21;
                    long v27 = melonDRMService0.b.getErrorCode(v1);
                    if(v27 == -101L) {
                        melonDRMService.e.D("Content has expired");
                    }
                    else if(v27 == -102L) {
                        melonDRMService.e.D("MIN of content and MIN of Device isn\'t same");
                    }
                    else {
                        melonDRMService.e.D("Faulure, connect content(" + v27 + ")");
                    }
                    melonDRMService.e.D("HTTP/1.0 503 Service Unavailable\r\nServer: DigiCAP DRM Server\r\n\r\n");
                    outputStream0.write("HTTP/1.0 503 Service Unavailable\r\nServer: DigiCAP DRM Server\r\n\r\n".getBytes());
                    outputStream0.flush();
                    goto label_353;
                }
                catch(Exception exception0) {
                }
                catch(Throwable throwable12) {
                    throwable1 = throwable12;
                    v = v1;
                    randomAccessFile1 = null;
                    goto label_435;
                }
                goto label_399;
            label_353:
                v14 = v1;
            label_354:
                randomAccessFile4 = null;
                try {
                label_355:
                    melonDRMService.e.D("Socket Close Flow");
                    if(randomAccessFile4 != null) {
                        randomAccessFile4.close();
                    }
                    if(v14 > 0) {
                        goto label_359;
                    }
                    goto label_366;
                }
                catch(IOException unused_ex) {
                    digicapLog0 = melonDRMService.e;
                    digicapLog0.D("Catch Log");
                    return;
                }
                try {
                label_359:
                    melonDRMService0.b.close(v14);
                    goto label_366;
                }
                catch(UnsatisfiedLinkErrorDrmException unsatisfiedLinkErrorDrmException0) {
                }
                catch(Exception exception1) {
                    goto label_365;
                }
                try {
                    unsatisfiedLinkErrorDrmException0.printStackTrace();
                    goto label_366;
                label_365:
                    exception1.printStackTrace();
                label_366:
                    if(inputStream1 != null) {
                        inputStream1.close();
                    }
                    outputStream0.close();
                    socket0.close();
                }
                catch(IOException unused_ex) {
                    digicapLog0 = melonDRMService.e;
                    digicapLog0.D("Catch Log");
                }
                return;
                try {
                    s1 = s1.replace("/content://", "content://");
                    goto label_46;
                }
                catch(Exception exception0) {
                    inputStream1 = inputStream0;
                    v1 = 0;
                    goto label_399;
                }
                catch(Throwable throwable5) {
                    throwable1 = throwable5;
                    inputStream1 = inputStream0;
                }
                randomAccessFile1 = null;
                goto label_435;
                try {
                label_383:
                    inputStream1 = inputStream0;
                    melonDRMService.e.D("Failure, Parsing HTTP header of requested message");
                    throw new Exception("read_Header() returning null");
                }
                catch(Exception exception0) {
                }
                catch(Throwable throwable4) {
                    goto label_390;
                }
                v1 = 0;
                goto label_399;
            }
            catch(Throwable throwable4) {
            }
        label_390:
            throwable1 = throwable4;
            try {
                while(true) {
                    randomAccessFile1 = null;
                    goto label_435;
                label_394:
                    throwable1 = throwable13;
                    v = v22;
                }
            label_398:
                v1 = v22;
            }
            catch(Exception exception0) {
                goto label_398;
            }
            catch(Throwable throwable13) {
                goto label_394;
            }
        label_399:
            randomAccessFile0 = null;
            try {
            label_400:
                exception0.printStackTrace();
                melonDRMService.e.D("TransmissionManager exception : " + exception0.toString() + ":" + exception0.getCause());
                StackTraceElement[] arr_stackTraceElement = exception0.getStackTrace();
                for(int v28 = 0; v28 < arr_stackTraceElement.length; ++v28) {
                    melonDRMService.e.D("TransmissionManager exception : " + arr_stackTraceElement[v28]);
                }
            }
            catch(Throwable throwable14) {
                throwable1 = throwable14;
                v = v1;
                randomAccessFile1 = randomAccessFile0;
                goto label_435;
            }
            try {
                melonDRMService.e.D("Socket Close Flow");
                if(randomAccessFile0 != null) {
                    randomAccessFile0.close();
                }
                if(v1 > 0) {
                    goto label_417;
                }
                goto label_424;
            }
            catch(IOException unused_ex) {
                digicapLog0 = melonDRMService.e;
                digicapLog0.D("Catch Log");
                return;
            }
            try {
            label_417:
                melonDRMService0.b.close(v1);
                goto label_424;
            }
            catch(UnsatisfiedLinkErrorDrmException unsatisfiedLinkErrorDrmException1) {
            }
            catch(Exception exception2) {
                goto label_423;
            }
            try {
                unsatisfiedLinkErrorDrmException1.printStackTrace();
                goto label_424;
            label_423:
                exception2.printStackTrace();
            label_424:
                if(inputStream1 != null) {
                    inputStream1.close();
                }
                if(outputStream0 != null) {
                    outputStream0.close();
                }
                if(socket0 != null) {
                    socket0.close();
                    return;
                }
                return;
            }
            catch(IOException unused_ex) {
                digicapLog0 = melonDRMService.e;
            }
            digicapLog0.D("Catch Log");
            return;
            try {
            label_435:
                melonDRMService.e.D("Socket Close Flow");
                if(randomAccessFile1 != null) {
                    randomAccessFile1.close();
                }
                if(v > 0) {
                    goto label_439;
                }
                goto label_446;
            }
            catch(IOException unused_ex) {
                melonDRMService.e.D("Catch Log");
                throw throwable1;
            }
            try {
            label_439:
                melonDRMService0.b.close(v);
                goto label_446;
            }
            catch(UnsatisfiedLinkErrorDrmException unsatisfiedLinkErrorDrmException2) {
            }
            catch(Exception exception3) {
                goto label_445;
            }
            try {
                unsatisfiedLinkErrorDrmException2.printStackTrace();
                goto label_446;
            label_445:
                exception3.printStackTrace();
            label_446:
                if(inputStream1 != null) {
                    inputStream1.close();
                }
                if(outputStream0 != null) {
                    outputStream0.close();
                }
                if(socket0 != null) {
                    socket0.close();
                }
            }
            catch(IOException unused_ex) {
                melonDRMService.e.D("Catch Log");
            }
            throw throwable1;
        }
    }

    public SocketListener a;
    public MelonDRMInterface b;
    public String c;
    public final Context d;
    public static final DigicapLog e;

    static {
        melonDRMService.e = DigicapLog.getInstance();
    }

    public melonDRMService(Context context0) {
        this.d = context0;
    }

    public static String b(melonDRMService melonDRMService0, InputStream inputStream0) {
        melonDRMService0.getClass();
        try {
            byte[] arr_b = new byte[0x800];
            return inputStream0.read(arr_b) == -1 ? null : new String(arr_b, "EUC-KR");
        }
        catch(IOException unused_ex) {
        }
        return null;
    }

    public String drm_checkDCF(Uri uri0) {
        ParcelFileDescriptor parcelFileDescriptor0;
        melonDRMService.e.D("drm_checkDCF[" + uri0.toString() + "]");
        int v = 0;
        try {
            parcelFileDescriptor0 = null;
            parcelFileDescriptor0 = this.d.getContentResolver().openFileDescriptor(uri0, "r");
            v = parcelFileDescriptor0.getFd();
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
        }
        if(v > 0) {
            try {
                String s = this.b.checkDCF(v);
                parcelFileDescriptor0.close();
                return s;
            }
            catch(UnsatisfiedLinkErrorDrmException unsatisfiedLinkErrorDrmException0) {
                unsatisfiedLinkErrorDrmException0.printStackTrace();
            }
            catch(Exception exception1) {
                exception1.printStackTrace();
            }
        }
        try {
            parcelFileDescriptor0.close();
        }
        catch(Exception unused_ex) {
        }
        return null;
    }

    public String drm_checkDCF(String s) {
        melonDRMService.e.D("drm_checkDCF[" + s + "]");
        try {
            return this.b.checkDCF(s.getBytes());
        }
        catch(UnsatisfiedLinkErrorDrmException unsatisfiedLinkErrorDrmException0) {
            unsatisfiedLinkErrorDrmException0.printStackTrace();
            return null;
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            return null;
        }
    }

    public boolean drm_checkDrmSeverState() {
        return this.a == null ? false : this.a.isAlive();
    }

    public String drm_getContentDescription(int v) {
        melonDRMService.e.D("drm_getContentDescription(" + v + ")");
        try {
            return this.b.getContentDescription(v);
        }
        catch(UnsatisfiedLinkErrorDrmException unsatisfiedLinkErrorDrmException0) {
            unsatisfiedLinkErrorDrmException0.printStackTrace();
            return null;
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            return null;
        }
    }

    public String drm_getContentID(int v) {
        melonDRMService.e.D("drm_getContentID(" + v + ")");
        try {
            return this.b.getContentID(v);
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            return null;
        }
    }

    public long drm_getErrorCode(int v) {
        melonDRMService.e.D("drm_getErrorCode(" + v + ")");
        try {
            return this.b.getErrorCode(v);
        }
        catch(UnsatisfiedLinkErrorDrmException unsatisfiedLinkErrorDrmException0) {
            unsatisfiedLinkErrorDrmException0.printStackTrace();
            return -1L;
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            return -1L;
        }
    }

    public String drm_getErrorMsg() {
        try {
            return this.b.getErrorMsg();
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            return null;
        }
    }

    public long drm_getFileSize(int v) {
        melonDRMService.e.D("drm_getFileSize(" + v + ")");
        try {
            return this.b.getFileSize(v);
        }
        catch(UnsatisfiedLinkErrorDrmException unsatisfiedLinkErrorDrmException0) {
            unsatisfiedLinkErrorDrmException0.printStackTrace();
            return -1L;
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            return -1L;
        }
    }

    public ByteBuffer drm_getLyrics(int v) {
        long v3;
        long v2;
        long v1;
        String s = this.b.findKey(v);
        if(s == null) {
            v1 = -1L;
        }
        else {
            try {
                if(s.startsWith("content://")) {
                    MelonDRMInterface melonDRMInterface0 = this.b;
                    Uri uri0 = Uri.parse(s);
                    v1 = melonDRMInterface0.checkLyrics_uri(this.d, uri0);
                }
                else {
                    v1 = this.b.checkLyrics(s.getBytes());
                }
                goto label_17;
            }
            catch(UnsatisfiedLinkErrorDrmException unsatisfiedLinkErrorDrmException0) {
            }
            catch(Exception exception0) {
                exception0.printStackTrace();
                return null;
            }
            unsatisfiedLinkErrorDrmException0.printStackTrace();
            return null;
        }
    label_17:
        DigicapLog digicapLog0 = melonDRMService.e;
        if(Long.compare(v1, 0L) != 0) {
            digicapLog0.D("The content path : " + s + "\nIt isn\'t lyrics.");
            try {
                this.b.setErrorMsg("The content path : " + s + "\nIt isn\'t lyrics.");
            }
            catch(Exception exception1) {
                exception1.printStackTrace();
            }
            return null;
        }
        try {
            v2 = this.b.getOriginalFileSize(v);
        }
        catch(UnsatisfiedLinkErrorDrmException unsatisfiedLinkErrorDrmException1) {
            unsatisfiedLinkErrorDrmException1.printStackTrace();
            return null;
        }
        catch(Exception exception2) {
            exception2.printStackTrace();
            return null;
        }
        if(v2 <= 0L) {
            digicapLog0.D("Failure, DRMGetOriginalFileSize returning " + v2);
            try {
                this.b.setErrorMsg("Failure, DRMGetOriginalFileSize returning " + v2);
            }
            catch(Exception exception3) {
                exception3.printStackTrace();
            }
            return null;
        }
        ByteBuffer byteBuffer0 = ByteBuffer.allocate(((int)v2));
        try {
            v3 = this.b.read(v, byteBuffer0, v2);
        }
        catch(UnsatisfiedLinkErrorDrmException unsatisfiedLinkErrorDrmException2) {
            unsatisfiedLinkErrorDrmException2.printStackTrace();
            return null;
        }
        catch(Exception exception4) {
            exception4.printStackTrace();
            return null;
        }
        if(v3 <= 0L) {
            digicapLog0.D("Failure, DRMRead returning " + v3);
            try {
                this.b.setErrorMsg("Failure, DRMRead returning " + v3);
            }
            catch(Exception exception5) {
                exception5.printStackTrace();
            }
            return null;
        }
        byteBuffer0.flip();
        return byteBuffer0;
    }

    public int drm_getMetaDataCharacterSet(int v) {
        melonDRMService.e.D("drm_getMetaDataCharacterSet(" + v + ")");
        try {
            return this.b.getMetaDataCharacterSet(v);
        }
        catch(UnsatisfiedLinkErrorDrmException unsatisfiedLinkErrorDrmException0) {
            unsatisfiedLinkErrorDrmException0.printStackTrace();
            return -1;
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            return -1;
        }
    }

    public long drm_getOriginalFileSize(int v) {
        melonDRMService.e.D("drm_getOriginalFileSize(" + v + ")");
        try {
            return this.b.getOriginalFileSize(v);
        }
        catch(UnsatisfiedLinkErrorDrmException unsatisfiedLinkErrorDrmException0) {
            unsatisfiedLinkErrorDrmException0.printStackTrace();
            return -1L;
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            return -1L;
        }
    }

    public String drm_getUnsupportedValue(int v, String s) {
        DigicapLog digicapLog0 = melonDRMService.e;
        digicapLog0.D("drm_getUnsupportedValue(" + v + ", " + s + ")");
        try {
            byte[] arr_b = this.b.getUnsupportedValue(v, s);
            if(arr_b == null) {
                return null;
            }
            try {
                return new String(arr_b, "EUC-KR");
            }
            catch(UnsupportedEncodingException unsupportedEncodingException0) {
                digicapLog0.D("" + unsupportedEncodingException0.toString());
                return null;
            }
        }
        catch(UnsatisfiedLinkErrorDrmException unsatisfiedLinkErrorDrmException0) {
            unsatisfiedLinkErrorDrmException0.printStackTrace();
            return null;
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            return null;
        }
    }

    public String drm_getUnsupportedValueUTF8(int v, String s) {
        melonDRMService.e.D("drm_getUnsupportedValue(" + v + ", " + s + ")");
        try {
            String s1 = this.b.getUnsupportedValueUTF8(v, s);
            return s1.isEmpty() ? null : s1;
        }
        catch(UnsatisfiedLinkErrorDrmException unsatisfiedLinkErrorDrmException0) {
            unsatisfiedLinkErrorDrmException0.printStackTrace();
            return null;
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            return null;
        }
    }

    public String drm_getValidPeriod(int v) {
        melonDRMService.e.D("drm_getValidPeriod(" + v + ")");
        try {
            return this.b.getValidPeriod(v);
        }
        catch(UnsatisfiedLinkErrorDrmException unsatisfiedLinkErrorDrmException0) {
            unsatisfiedLinkErrorDrmException0.printStackTrace();
            return null;
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            return null;
        }
    }

    public int drm_loadFile(Uri uri0) {
        int v1;
        Context context0 = this.d;
        melonDRMService.e.D("drm_loadFile()::Content Uri : " + uri0);
        try {
            ParcelFileDescriptor parcelFileDescriptor0 = context0.getContentResolver().openFileDescriptor(uri0, "r");
            int v = parcelFileDescriptor0.getFd();
            Log.e("xxx", "int_pfd  : " + v);
            parcelFileDescriptor0.close();
        }
        catch(FileNotFoundException fileNotFoundException0) {
            fileNotFoundException0.printStackTrace();
            return -3001;
        }
        catch(IOException iOException0) {
            iOException0.printStackTrace();
            return -3001;
        }
        if(v <= 0) {
            return 3001;
        }
        try {
            v1 = this.b.open(context0, uri0, 3, 1);
        }
        catch(UnsatisfiedLinkErrorDrmException unsatisfiedLinkErrorDrmException0) {
            unsatisfiedLinkErrorDrmException0.printStackTrace();
            return -1;
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            return -1;
        }
        if(v1 <= 0) {
            try {
                this.b.setErrorMsg("Failure, load file ContentUri (" + uri0 + "). returning " + v1);
                return v1;
            }
            catch(Exception exception1) {
                exception1.printStackTrace();
                return -1;
            }
        }
        try {
            this.b.setErrorMsg("Success, load file ContentUri (" + uri0 + "). returning " + v1);
            return v1;
        }
        catch(Exception exception2) {
            exception2.printStackTrace();
            return -1;
        }
    }

    public int drm_loadFile(String s) {
        int v;
        melonDRMService.e.D("drm_loadFile()::File path : " + s);
        melonDRMService.e.D("drm_loadFile()::File path length : " + s.length());
        if(!new File(s).exists()) {
            try {
                this.b.setErrorMsg("Failure, load file(" + s + "). File doesn\'t exist at storage.");
            }
            catch(Exception exception0) {
                exception0.printStackTrace();
            }
            return -3001;
        }
        try {
            v = this.b.open(s.getBytes(), 3, 1);
        }
        catch(UnsatisfiedLinkErrorDrmException unsatisfiedLinkErrorDrmException0) {
            unsatisfiedLinkErrorDrmException0.printStackTrace();
            return -1;
        }
        catch(Exception exception1) {
            exception1.printStackTrace();
            return -1;
        }
        if(v <= 0) {
            try {
                this.b.setErrorMsg("Failure, load file(" + s + "). returning " + v);
                return v;
            }
            catch(Exception exception2) {
                exception2.printStackTrace();
                return -1;
            }
        }
        try {
            this.b.setErrorMsg("Success, load file(" + s + "). returning " + v);
            return v;
        }
        catch(Exception exception3) {
            exception3.printStackTrace();
            return -1;
        }
    }

    public long drm_setClientID(String s) {
        DigicapLog digicapLog0 = melonDRMService.e;
        if(s == null) {
            digicapLog0.D("clientID is null.");
            return -3001L;
        }
        if(this.b == null) {
            digicapLog0.D("DRM Interface is null.(DRM Library has not been initialized.)");
            return -3003L;
        }
        digicapLog0.D("Set Client ID(" + s + ")");
        try {
            this.b.setClientID(s);
            return 0L;
        }
        catch(UnsatisfiedLinkErrorDrmException unsatisfiedLinkErrorDrmException0) {
            unsatisfiedLinkErrorDrmException0.printStackTrace();
            return -1L;
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            return -1L;
        }
    }

    public void drm_unloadFile(int v) {
        melonDRMService.e.D("Unload file(" + v + ")");
        try {
            this.b.close(v);
        }
        catch(UnsatisfiedLinkErrorDrmException unsatisfiedLinkErrorDrmException0) {
            unsatisfiedLinkErrorDrmException0.printStackTrace();
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
        }
    }

    public String getDrmUrl() {
        SocketListener melonDRMService$SocketListener0 = this.a;
        if(melonDRMService$SocketListener0 != null) {
            try {
                return "http://127.0.0.1:" + melonDRMService$SocketListener0.getLocalPort();
            }
            catch(ServerSocketNullDrmException serverSocketNullDrmException0) {
                throw new DrmSocketNullDrmException(serverSocketNullDrmException0);
            }
        }
        throw new DrmSocketNullDrmException();
    }

    public boolean isDcfContent(URLParser uRLParser0) {
        new URLParser();
        DigicapLog digicapLog0 = melonDRMService.e;
        digicapLog0.D("requestUrl.getContentURL() : " + uRLParser0.getContentURL());
        if(uRLParser0.getContentURL().contains("content://")) {
            try {
                String s = this.drm_checkDCF(Uri.parse(uRLParser0.getContentURL()));
                if(s != null && !s.isEmpty()) {
                    return true;
                }
            }
            catch(Exception unused_ex) {
                digicapLog0.D("\ncall isDcfContent checkDCF err : " + this.b.getOpenFDByUri(Uri.parse(uRLParser0.getContentURL())));
            }
            return false;
        }
        if(uRLParser0.getContentExtension().compareToIgnoreCase("mp3") != 0 && uRLParser0.getContentExtension().compareToIgnoreCase("mp4") != 0) {
            uRLParser0.getContentExtension().compareToIgnoreCase("dcf");
            return true;
        }
        return false;
    }

    public boolean isDcfContent(String s) {
        URLParser uRLParser0 = new URLParser();
        x.w("", s, "requestUrl String : ");
        uRLParser0.parseURL(s);
        return this.isDcfContent(uRLParser0);
    }

    @Override  // android.app.Service
    public IBinder onBind(Intent intent0) {
        melonDRMService.e.D("onBind");
        return null;
    }

    @Override  // android.app.Service
    public void onCreate() {
        super.onCreate();
        melonDRMService.e.D("Create DRM Agent");
        try {
            MelonDRMInterface melonDRMInterface0 = MelonDRMInterface.getInstance();
            this.b = melonDRMInterface0;
            if(melonDRMInterface0.init() != 0) {
                return;
            }
        }
        catch(UnsatisfiedLinkErrorDrmException unsatisfiedLinkErrorDrmException0) {
            unsatisfiedLinkErrorDrmException0.printStackTrace();
            return;
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            return;
        }
        SocketListener melonDRMService$SocketListener0 = new SocketListener(this);
        this.a = melonDRMService$SocketListener0;
        melonDRMService$SocketListener0.start();
    }

    @Override  // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        melonDRMService.e.D("DRM Local Server - onDestroy()");
        SocketListener melonDRMService$SocketListener0 = this.a;
        if(melonDRMService$SocketListener0 != null) {
            melonDRMService$SocketListener0.stopSocket();
            this.a = null;
        }
        MelonDRMInterface melonDRMInterface0 = this.b;
        if(melonDRMInterface0 != null) {
            try {
                melonDRMInterface0.destroy();
                this.b = null;
            }
            catch(UnsatisfiedLinkErrorDrmException unsatisfiedLinkErrorDrmException0) {
                unsatisfiedLinkErrorDrmException0.printStackTrace();
            }
            catch(Exception exception0) {
                exception0.printStackTrace();
            }
        }
    }

    @Override  // android.app.Service
    public boolean onUnbind(Intent intent0) {
        melonDRMService.e.D("onUnbind");
        return false;
    }

    public boolean setAppPath(String s) {
        if(s == null) {
            return false;
        }
        this.c = s + "/files/stateInfo.dat";
        melonDRMService.e.D("setAppPath() : " + this.c);
        return true;
    }
}

