package org.apache.http.impl;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import org.apache.http.config.ConnectionConfig;

public final class ConnSupport {
    public static CharsetDecoder createDecoder(ConnectionConfig connectionConfig0) {
        if(connectionConfig0 == null) {
            return null;
        }
        Charset charset0 = connectionConfig0.getCharset();
        CodingErrorAction codingErrorAction0 = connectionConfig0.getMalformedInputAction();
        CodingErrorAction codingErrorAction1 = connectionConfig0.getUnmappableInputAction();
        if(charset0 != null) {
            CharsetDecoder charsetDecoder0 = charset0.newDecoder();
            if(codingErrorAction0 == null) {
                codingErrorAction0 = CodingErrorAction.REPORT;
            }
            CharsetDecoder charsetDecoder1 = charsetDecoder0.onMalformedInput(codingErrorAction0);
            if(codingErrorAction1 == null) {
                codingErrorAction1 = CodingErrorAction.REPORT;
            }
            return charsetDecoder1.onUnmappableCharacter(codingErrorAction1);
        }
        return null;
    }

    public static CharsetEncoder createEncoder(ConnectionConfig connectionConfig0) {
        if(connectionConfig0 == null) {
            return null;
        }
        Charset charset0 = connectionConfig0.getCharset();
        if(charset0 != null) {
            CodingErrorAction codingErrorAction0 = connectionConfig0.getMalformedInputAction();
            CodingErrorAction codingErrorAction1 = connectionConfig0.getUnmappableInputAction();
            CharsetEncoder charsetEncoder0 = charset0.newEncoder();
            if(codingErrorAction0 == null) {
                codingErrorAction0 = CodingErrorAction.REPORT;
            }
            CharsetEncoder charsetEncoder1 = charsetEncoder0.onMalformedInput(codingErrorAction0);
            if(codingErrorAction1 == null) {
                codingErrorAction1 = CodingErrorAction.REPORT;
            }
            return charsetEncoder1.onUnmappableCharacter(codingErrorAction1);
        }
        return null;
    }
}

