package com.airbnb.lottie.model;

import H0.b;
import b3.Z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyPath {
    public static final KeyPath COMPOSITION;
    private final List keys;
    private KeyPathElement resolvedElement;

    static {
        KeyPath.COMPOSITION = new KeyPath(new String[]{"COMPOSITION"});
    }

    private KeyPath(KeyPath keyPath0) {
        this.keys = new ArrayList(keyPath0.keys);
        this.resolvedElement = keyPath0.resolvedElement;
    }

    public KeyPath(String[] arr_s) {
        this.keys = Arrays.asList(arr_s);
    }

    public KeyPath addKey(String s) {
        KeyPath keyPath0 = new KeyPath(this);
        keyPath0.keys.add(s);
        return keyPath0;
    }

    private boolean endsWithGlobstar() {
        return ((String)Z.h(1, this.keys)).equals("**");
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 == null || this.getClass() != object0.getClass() || !this.keys.equals(((KeyPath)object0).keys)) {
            return false;
        }
        KeyPathElement keyPathElement0 = this.resolvedElement;
        KeyPathElement keyPathElement1 = ((KeyPath)object0).resolvedElement;
        return keyPathElement0 == null ? keyPathElement1 == null : keyPathElement0.equals(keyPathElement1);
    }

    public boolean fullyResolvesTo(String s, int v) {
        if(v >= this.keys.size()) {
            return false;
        }
        boolean z = v == this.keys.size() - 1;
        String s1 = (String)this.keys.get(v);
        if(!s1.equals("**")) {
            return (z || v == this.keys.size() - 2 && this.endsWithGlobstar()) && (s1.equals(s) || s1.equals("*"));
        }
        if(!z && ((String)this.keys.get(v + 1)).equals(s)) {
            return v == this.keys.size() - 2 || v == this.keys.size() - 3 && this.endsWithGlobstar();
        }
        if(z) {
            return true;
        }
        return v + 1 >= this.keys.size() - 1 ? ((String)this.keys.get(v + 1)).equals(s) : false;
    }

    public KeyPathElement getResolvedElement() {
        return this.resolvedElement;
    }

    @Override
    public int hashCode() {
        int v = this.keys.hashCode();
        return this.resolvedElement == null ? v * 0x1F : v * 0x1F + this.resolvedElement.hashCode();
    }

    public int incrementDepthBy(String s, int v) {
        if(this.isContainer(s)) {
            return 0;
        }
        if(!((String)this.keys.get(v)).equals("**")) {
            return 1;
        }
        if(v == this.keys.size() - 1) {
            return 0;
        }
        return ((String)this.keys.get(v + 1)).equals(s) ? 2 : 0;
    }

    private boolean isContainer(String s) {
        return "__container".equals(s);
    }

    public String keysToString() {
        return this.keys.toString();
    }

    public boolean matches(String s, int v) {
        if(this.isContainer(s)) {
            return true;
        }
        return v < this.keys.size() ? ((String)this.keys.get(v)).equals(s) || ((String)this.keys.get(v)).equals("**") || ((String)this.keys.get(v)).equals("*") : false;
    }

    // 去混淆评级： 低(30)
    public boolean propagateToChildren(String s, int v) {
        return "__container".equals(s) ? true : v < this.keys.size() - 1 || ((String)this.keys.get(v)).equals("**");
    }

    public KeyPath resolve(KeyPathElement keyPathElement0) {
        KeyPath keyPath0 = new KeyPath(this);
        keyPath0.resolvedElement = keyPathElement0;
        return keyPath0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("KeyPath{keys=");
        stringBuilder0.append(this.keys);
        stringBuilder0.append(",resolved=");
        return this.resolvedElement == null ? b.k(stringBuilder0, false, '}') : b.k(stringBuilder0, true, '}');
    }
}

