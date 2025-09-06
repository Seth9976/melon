package org.apache.http.impl.conn;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
public class WireHC4 {
    private static final String TAG = "Wire";
    private final String id;

    public WireHC4(String s) {
        this.id = s;
    }

    public boolean enabled() {
        return Log.isLoggable("Wire", 3);
    }

    public void input(int v) {
        this.input(new byte[]{((byte)v)});
    }

    public void input(InputStream inputStream0) {
        Args.notNull(inputStream0, "Input");
        this.wire("<< ", inputStream0);
    }

    public void input(String s) {
        Args.notNull(s, "Input");
        this.input(s.getBytes());
    }

    public void input(byte[] arr_b) {
        Args.notNull(arr_b, "Input");
        this.wire("<< ", new ByteArrayInputStream(arr_b));
    }

    public void input(byte[] arr_b, int v, int v1) {
        Args.notNull(arr_b, "Input");
        this.wire("<< ", new ByteArrayInputStream(arr_b, v, v1));
    }

    public void output(int v) {
        this.output(new byte[]{((byte)v)});
    }

    public void output(InputStream inputStream0) {
        Args.notNull(inputStream0, "Output");
        this.wire(">> ", inputStream0);
    }

    public void output(String s) {
        Args.notNull(s, "Output");
        this.output(s.getBytes());
    }

    public void output(byte[] arr_b) {
        Args.notNull(arr_b, "Output");
        this.wire(">> ", new ByteArrayInputStream(arr_b));
    }

    public void output(byte[] arr_b, int v, int v1) {
        Args.notNull(arr_b, "Output");
        this.wire(">> ", new ByteArrayInputStream(arr_b, v, v1));
    }

    private void wire(String s, InputStream inputStream0) {
        StringBuilder stringBuilder0 = new StringBuilder();
    alab1:
        while(true) {
            int v = inputStream0.read();
            switch(v) {
                case -1: {
                    break alab1;
                }
                case 10: {
                    stringBuilder0.append("[\\n]\"");
                    stringBuilder0.insert(0, "\"");
                    stringBuilder0.insert(0, s);
                    Log.d("Wire", this.id + " " + stringBuilder0.toString());
                    stringBuilder0.setLength(0);
                    break;
                }
                case 13: {
                    stringBuilder0.append("[\\r]");
                    break;
                }
                default: {
                    if(v < 0x20 || v > 0x7F) {
                        stringBuilder0.append("[0x");
                        stringBuilder0.append(Integer.toHexString(v));
                        stringBuilder0.append("]");
                    }
                    else {
                        stringBuilder0.append(((char)v));
                    }
                    break;
                }
            }
        }
        if(stringBuilder0.length() > 0) {
            stringBuilder0.append('\"');
            stringBuilder0.insert(0, '\"');
            stringBuilder0.insert(0, s);
            Log.d("Wire", this.id + " " + stringBuilder0.toString());
        }
    }
}

