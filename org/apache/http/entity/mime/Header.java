package org.apache.http.entity.mime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Header implements Iterable {
    private final Map fieldMap;
    private final List fields;

    public Header() {
        this.fields = new LinkedList();
        this.fieldMap = new HashMap();
    }

    public void addField(MinimalField minimalField0) {
        if(minimalField0 == null) {
            return;
        }
        String s = minimalField0.getName().toLowerCase(Locale.ENGLISH);
        List list0 = (List)this.fieldMap.get(s);
        if(list0 == null) {
            list0 = new LinkedList();
            this.fieldMap.put(s, list0);
        }
        list0.add(minimalField0);
        this.fields.add(minimalField0);
    }

    public MinimalField getField(String s) {
        if(s == null) {
            return null;
        }
        List list0 = (List)this.fieldMap.get(s.toLowerCase(Locale.ENGLISH));
        return list0 == null || list0.isEmpty() ? null : ((MinimalField)list0.get(0));
    }

    public List getFields() {
        return new ArrayList(this.fields);
    }

    public List getFields(String s) {
        if(s == null) {
            return null;
        }
        List list0 = (List)this.fieldMap.get(s.toLowerCase(Locale.ENGLISH));
        return list0 != null && !list0.isEmpty() ? new ArrayList(list0) : Collections.EMPTY_LIST;
    }

    @Override
    public Iterator iterator() {
        return Collections.unmodifiableList(this.fields).iterator();
    }

    public int removeFields(String s) {
        if(s == null) {
            return 0;
        }
        List list0 = (List)this.fieldMap.remove(s.toLowerCase(Locale.ENGLISH));
        if(list0 != null && !list0.isEmpty()) {
            this.fields.removeAll(list0);
            return list0.size();
        }
        return 0;
    }

    public void setField(MinimalField minimalField0) {
        if(minimalField0 == null) {
            return;
        }
        List list0 = (List)this.fieldMap.get(minimalField0.getName().toLowerCase(Locale.ENGLISH));
        if(list0 != null && !list0.isEmpty()) {
            list0.clear();
            list0.add(minimalField0);
            int v1 = -1;
            Iterator iterator0 = this.fields.iterator();
            for(int v = 0; iterator0.hasNext(); ++v) {
                Object object0 = iterator0.next();
                if(((MinimalField)object0).getName().equalsIgnoreCase(minimalField0.getName())) {
                    iterator0.remove();
                    if(v1 == -1) {
                        v1 = v;
                    }
                }
            }
            this.fields.add(v1, minimalField0);
            return;
        }
        this.addField(minimalField0);
    }

    @Override
    public String toString() {
        return this.fields.toString();
    }
}

