package com.iloen.melon.utils;

import com.iloen.melon.types.BasicNameValuePair;
import java.util.ArrayList;

public class NameValuePairList extends ArrayList {
    private static final long serialVersionUID = 0x3F5A8C99E2891FFAL;

    public void add(String s, String s1) {
        this.add(new BasicNameValuePair(s, s1));
    }

    public void remove(String s) {
        for(Object object0: this) {
            BasicNameValuePair basicNameValuePair0 = (BasicNameValuePair)object0;
            if(basicNameValuePair0.a.equals(s)) {
                this.remove(basicNameValuePair0);
                return;
            }
            if(false) {
                break;
            }
        }
    }
}

