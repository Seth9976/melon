package com.iloen.melon.net.v4x.common;

import U4.x;

public class NotificationActionTypeValue {
    public final String code;
    public final String name;

    public NotificationActionTypeValue(String s, String s1) {
        this.name = s;
        this.code = s1;
    }

    public char code() {
        return this.code.charAt(0);
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == null) {
            return false;
        }
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof NotificationActionTypeValue)) {
            return false;
        }
        String s = ((NotificationActionTypeValue)object0).name;
        if(s != null && s.equals(this.name)) {
            String s1 = ((NotificationActionTypeValue)object0).code;
            return s1 != null && s1.equals(this.code);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.name == null ? 0 : this.name.hashCode();
        String s = this.code;
        if(s != null) {
            v = s.hashCode();
        }
        return (v1 + 0x20F) * 0x1F + v;
    }

    public boolean isCodeEquals(char c) {
        return this.code() == c;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("{name[");
        stringBuilder0.append(this.name);
        stringBuilder0.append("] code[");
        return x.m(stringBuilder0, this.code, "]}");
    }
}

