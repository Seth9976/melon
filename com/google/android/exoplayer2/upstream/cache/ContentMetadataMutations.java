package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;

public class ContentMetadataMutations {
    private final Map editedValues;
    private final List removedValues;

    public ContentMetadataMutations() {
        this.editedValues = new HashMap();
        this.removedValues = new ArrayList();
    }

    private ContentMetadataMutations checkAndSet(String s, Object object0) {
        String s1 = (String)Assertions.checkNotNull(s);
        Object object1 = Assertions.checkNotNull(object0);
        this.editedValues.put(s1, object1);
        this.removedValues.remove(s);
        return this;
    }

    public Map getEditedValues() {
        HashMap hashMap0 = new HashMap(this.editedValues);
        for(Object object0: hashMap0.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            Object object1 = map$Entry0.getValue();
            if(object1 instanceof byte[]) {
                map$Entry0.setValue(Arrays.copyOf(((byte[])object1), ((byte[])object1).length));
            }
        }
        return Collections.unmodifiableMap(hashMap0);
    }

    public List getRemovedValues() {
        return Collections.unmodifiableList(new ArrayList(this.removedValues));
    }

    public ContentMetadataMutations remove(String s) {
        this.removedValues.add(s);
        this.editedValues.remove(s);
        return this;
    }

    public ContentMetadataMutations set(String s, long v) {
        return this.checkAndSet(s, v);
    }

    public ContentMetadataMutations set(String s, String s1) {
        return this.checkAndSet(s, s1);
    }

    public ContentMetadataMutations set(String s, byte[] arr_b) {
        return this.checkAndSet(s, Arrays.copyOf(arr_b, arr_b.length));
    }

    public static ContentMetadataMutations setContentLength(ContentMetadataMutations contentMetadataMutations0, long v) {
        return contentMetadataMutations0.set("exo_len", v);
    }

    public static ContentMetadataMutations setRedirectedUri(ContentMetadataMutations contentMetadataMutations0, Uri uri0) {
        return uri0 == null ? contentMetadataMutations0.remove("exo_redir") : contentMetadataMutations0.set("exo_redir", uri0.toString());
    }
}

