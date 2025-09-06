package org.apache.http.impl.client;

import java.net.URI;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class RedirectLocationsHC4 extends AbstractList {
    private final List all;
    private final Set unique;

    public RedirectLocationsHC4() {
        this.unique = new HashSet();
        this.all = new ArrayList();
    }

    @Override
    public void add(int v, Object object0) {
        this.all.add(v, ((URI)object0));
        this.unique.add(((URI)object0));
    }

    public void add(URI uRI0) {
        this.unique.add(uRI0);
        this.all.add(uRI0);
    }

    @Override
    public boolean contains(Object object0) {
        return this.unique.contains(object0);
    }

    public boolean contains(URI uRI0) {
        return this.unique.contains(uRI0);
    }

    @Override
    public Object get(int v) {
        return this.get(v);
    }

    public URI get(int v) {
        return (URI)this.all.get(v);
    }

    public List getAll() {
        return new ArrayList(this.all);
    }

    @Override
    public Object remove(int v) {
        return this.remove(v);
    }

    public URI remove(int v) {
        URI uRI0 = (URI)this.all.remove(v);
        this.unique.remove(uRI0);
        if(this.all.size() != this.unique.size()) {
            this.unique.addAll(this.all);
        }
        return uRI0;
    }

    public boolean remove(URI uRI0) {
        boolean z = this.unique.remove(uRI0);
        if(z) {
            Iterator iterator0 = this.all.iterator();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                if(((URI)object0).equals(uRI0)) {
                    iterator0.remove();
                }
            }
        }
        return z;
    }

    @Override
    public Object set(int v, Object object0) {
        URI uRI0 = (URI)this.all.set(v, ((URI)object0));
        this.unique.remove(uRI0);
        this.unique.add(((URI)object0));
        if(this.all.size() != this.unique.size()) {
            this.unique.addAll(this.all);
        }
        return uRI0;
    }

    @Override
    public int size() {
        return this.all.size();
    }
}

