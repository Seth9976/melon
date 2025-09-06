package io.netty.util.internal;

import io.netty.util.AsciiString;
import java.nio.ByteBuffer;
import java.security.cert.Certificate;
import javax.security.cert.X509Certificate;

public final class EmptyArrays {
    public static final AsciiString[] EMPTY_ASCII_STRINGS;
    public static final byte[] EMPTY_BYTES;
    public static final ByteBuffer[] EMPTY_BYTE_BUFFERS;
    public static final Certificate[] EMPTY_CERTIFICATES;
    public static final char[] EMPTY_CHARS;
    public static final Class[] EMPTY_CLASSES;
    public static final int[] EMPTY_INTS;
    public static final X509Certificate[] EMPTY_JAVAX_X509_CERTIFICATES;
    public static final Object[] EMPTY_OBJECTS;
    public static final StackTraceElement[] EMPTY_STACK_TRACE;
    public static final String[] EMPTY_STRINGS;
    public static final Throwable[] EMPTY_THROWABLES;
    public static final java.security.cert.X509Certificate[] EMPTY_X509_CERTIFICATES;

    static {
        EmptyArrays.EMPTY_INTS = new int[0];
        EmptyArrays.EMPTY_BYTES = new byte[0];
        EmptyArrays.EMPTY_CHARS = new char[0];
        EmptyArrays.EMPTY_OBJECTS = new Object[0];
        EmptyArrays.EMPTY_CLASSES = new Class[0];
        EmptyArrays.EMPTY_STRINGS = new String[0];
        EmptyArrays.EMPTY_ASCII_STRINGS = new AsciiString[0];
        EmptyArrays.EMPTY_STACK_TRACE = new StackTraceElement[0];
        EmptyArrays.EMPTY_BYTE_BUFFERS = new ByteBuffer[0];
        EmptyArrays.EMPTY_CERTIFICATES = new Certificate[0];
        EmptyArrays.EMPTY_X509_CERTIFICATES = new java.security.cert.X509Certificate[0];
        EmptyArrays.EMPTY_JAVAX_X509_CERTIFICATES = new X509Certificate[0];
        EmptyArrays.EMPTY_THROWABLES = new Throwable[0];
    }
}

