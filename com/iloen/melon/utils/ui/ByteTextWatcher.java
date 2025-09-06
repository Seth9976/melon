package com.iloen.melon.utils.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.iloen.melon.utils.log.LogU;
import java.io.UnsupportedEncodingException;

public class ByteTextWatcher implements TextWatcher {
    public final int a;
    public String b;

    public ByteTextWatcher(int v) {
        this.b = "utf-8";
        this.a = v;
    }

    public ByteTextWatcher(int v, String s) {
        this.a = v;
        this.b = s;
    }

    @Override  // android.text.TextWatcher
    public void afterTextChanged(Editable editable0) {
        String s = editable0.toString();
        int v = this.a;
        if(v >= 1) {
            try {
                if(this.b == null) {
                    this.b = "utf-8";
                }
                if(s.getBytes(this.b).length > v) {
                    editable0.length();
                    int v1;
                    for(v1 = s.length(); v1 >= 0 && s.substring(0, v1).getBytes(this.b).length > v; --v1) {
                    }
                    editable0.delete(v1, editable0.length());
                    return;
                }
                return;
            }
            catch(UnsupportedEncodingException unsupportedEncodingException0) {
            }
            catch(Exception exception0) {
                LogU.e("ByteTextWatcher", exception0.toString());
                return;
            }
            LogU.e("ByteTextWatcher", unsupportedEncodingException0.toString());
        }
    }

    @Override  // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
    }

    @Override  // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
    }
}

