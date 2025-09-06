package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class PemReader {
    private static final Pattern BODY;
    private static final Pattern CERT_FOOTER;
    private static final Pattern CERT_HEADER;
    private static final Pattern KEY_FOOTER;
    private static final Pattern KEY_HEADER;
    private static final InternalLogger logger;

    static {
        PemReader.logger = InternalLoggerFactory.getInstance(PemReader.class);
        PemReader.CERT_HEADER = Pattern.compile("-+BEGIN\\s[^-\\r\\n]*CERTIFICATE[^-\\r\\n]*-+(?:\\s|\\r|\\n)+");
        PemReader.CERT_FOOTER = Pattern.compile("-+END\\s[^-\\r\\n]*CERTIFICATE[^-\\r\\n]*-+(?:\\s|\\r|\\n)*");
        PemReader.KEY_HEADER = Pattern.compile("-+BEGIN\\s[^-\\r\\n]*PRIVATE\\s+KEY[^-\\r\\n]*-+(?:\\s|\\r|\\n)+");
        PemReader.KEY_FOOTER = Pattern.compile("-+END\\s[^-\\r\\n]*PRIVATE\\s+KEY[^-\\r\\n]*-+(?:\\s|\\r|\\n)*");
        PemReader.BODY = Pattern.compile("[a-z0-9+/=][a-z0-9+/=\\r\\n]*", 2);
    }

    private static KeyException keyNotFoundException() {
        return new KeyException("could not find a PKCS #8 private key in input stream (see https://netty.io/wiki/sslcontextbuilder-and-private-key.html for more information)");
    }

    public static ByteBuf[] readCertificates(File file0) {
        try {
            FileInputStream fileInputStream0 = new FileInputStream(file0);
            try {
                return PemReader.readCertificates(fileInputStream0);
            }
            finally {
                PemReader.safeClose(fileInputStream0);
            }
        }
        catch(FileNotFoundException unused_ex) {
            throw new CertificateException("could not find certificate file: " + file0);
        }
    }

    public static ByteBuf[] readCertificates(InputStream inputStream0) {
        String s;
        try {
            s = PemReader.readContent(inputStream0);
        }
        catch(IOException iOException0) {
            throw new CertificateException("failed to read certificate input stream", iOException0);
        }
        ArrayList arrayList0 = new ArrayList();
        Matcher matcher0 = PemReader.CERT_HEADER.matcher(s);
        int v = 0;
        while(matcher0.find(v)) {
            int v1 = matcher0.end();
            matcher0.usePattern(PemReader.BODY);
            if(!matcher0.find(v1)) {
                break;
            }
            ByteBuf byteBuf0 = Unpooled.copiedBuffer(matcher0.group(0), CharsetUtil.US_ASCII);
            int v2 = matcher0.end();
            matcher0.usePattern(PemReader.CERT_FOOTER);
            if(!matcher0.find(v2)) {
                break;
            }
            ByteBuf byteBuf1 = Base64.decode(byteBuf0);
            byteBuf0.release();
            arrayList0.add(byteBuf1);
            v = matcher0.end();
            matcher0.usePattern(PemReader.CERT_HEADER);
        }
        if(arrayList0.isEmpty()) {
            throw new CertificateException("found no certificates in input stream");
        }
        return (ByteBuf[])arrayList0.toArray(new ByteBuf[0]);
    }

    private static String readContent(InputStream inputStream0) {
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        try {
            byte[] arr_b = new byte[0x2000];
            int v1;
            while((v1 = inputStream0.read(arr_b)) >= 0) {
                byteArrayOutputStream0.write(arr_b, 0, v1);
            }
            return byteArrayOutputStream0.toString("US-ASCII");
        }
        finally {
            PemReader.safeClose(byteArrayOutputStream0);
        }
    }

    public static ByteBuf readPrivateKey(File file0) {
        try {
            FileInputStream fileInputStream0 = new FileInputStream(file0);
            try {
                return PemReader.readPrivateKey(fileInputStream0);
            }
            finally {
                PemReader.safeClose(fileInputStream0);
            }
        }
        catch(FileNotFoundException unused_ex) {
            throw new KeyException("could not find key file: " + file0);
        }
    }

    public static ByteBuf readPrivateKey(InputStream inputStream0) {
        String s;
        try {
            s = PemReader.readContent(inputStream0);
        }
        catch(IOException iOException0) {
            throw new KeyException("failed to read key input stream", iOException0);
        }
        Matcher matcher0 = PemReader.KEY_HEADER.matcher(s);
        if(!matcher0.find(0)) {
            throw PemReader.keyNotFoundException();
        }
        int v = matcher0.end();
        matcher0.usePattern(PemReader.BODY);
        if(!matcher0.find(v)) {
            throw PemReader.keyNotFoundException();
        }
        ByteBuf byteBuf0 = Unpooled.copiedBuffer(matcher0.group(0), CharsetUtil.US_ASCII);
        int v1 = matcher0.end();
        matcher0.usePattern(PemReader.KEY_FOOTER);
        if(!matcher0.find(v1)) {
            throw PemReader.keyNotFoundException();
        }
        ByteBuf byteBuf1 = Base64.decode(byteBuf0);
        byteBuf0.release();
        return byteBuf1;
    }

    private static void safeClose(InputStream inputStream0) {
        try {
            inputStream0.close();
        }
        catch(IOException iOException0) {
            PemReader.logger.warn("Failed to close a stream.", iOException0);
        }
    }

    private static void safeClose(OutputStream outputStream0) {
        try {
            outputStream0.close();
        }
        catch(IOException iOException0) {
            PemReader.logger.warn("Failed to close a stream.", iOException0);
        }
    }
}

