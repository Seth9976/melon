package Y6;

import i.n.i.b.a.s.e.M3;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import v7.b;

public final class u implements d {
    public final Set a;
    public final Set b;
    public final Set c;
    public final Set d;
    public final Set e;
    public final Set f;
    public final d g;

    public u(c c0, d d0) {
        HashSet hashSet0 = new HashSet();
        HashSet hashSet1 = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        Set set0 = c0.g;
        for(Object object0: c0.c) {
            int v = ((k)object0).c;
            int v1 = ((k)object0).b;
            s s0 = ((k)object0).a;
            if(v == 0) {
                if(v1 == 2) {
                    hashSet3.add(s0);
                }
                else {
                    hashSet0.add(s0);
                }
            }
            else if(v == 2) {
                hashSet2.add(s0);
            }
            else if(v1 == 2) {
                hashSet4.add(s0);
            }
            else {
                hashSet1.add(s0);
            }
        }
        if(!set0.isEmpty()) {
            hashSet0.add(s.a(b.class));
        }
        this.a = Collections.unmodifiableSet(hashSet0);
        this.b = Collections.unmodifiableSet(hashSet1);
        this.c = Collections.unmodifiableSet(hashSet2);
        this.d = Collections.unmodifiableSet(hashSet3);
        this.e = Collections.unmodifiableSet(hashSet4);
        this.f = set0;
        this.g = d0;
    }

    @Override  // Y6.d
    public final q a(s s0) {
        if(!this.c.contains(s0)) {
            throw new M3("Attempting to request an undeclared dependency Deferred<" + s0 + ">.");  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
        }
        return this.g.a(s0);
    }

    @Override  // Y6.d
    public final y7.b b(Class class0) {
        return this.c(s.a(class0));
    }

    @Override  // Y6.d
    public final y7.b c(s s0) {
        if(!this.b.contains(s0)) {
            throw new M3("Attempting to request an undeclared dependency Provider<" + s0 + ">.");  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
        }
        return this.g.c(s0);
    }

    @Override  // Y6.d
    public final Object d(s s0) {
        if(!this.a.contains(s0)) {
            throw new M3("Attempting to request an undeclared dependency " + s0 + ".");  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
        }
        return this.g.d(s0);
    }

    @Override  // Y6.d
    public final Set e(s s0) {
        if(!this.d.contains(s0)) {
            throw new M3("Attempting to request an undeclared dependency Set<" + s0 + ">.");  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
        }
        return this.g.e(s0);
    }

    @Override  // Y6.d
    public final y7.b f(s s0) {
        if(!this.e.contains(s0)) {
            throw new M3("Attempting to request an undeclared dependency Provider<Set<" + s0 + ">>.");  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
        }
        return this.g.f(s0);
    }

    public final q g(Class class0) {
        return this.a(s.a(class0));
    }

    @Override  // Y6.d
    public final Object get(Class class0) {
        s s0 = s.a(class0);
        if(!this.a.contains(s0)) {
            throw new M3("Attempting to request an undeclared dependency " + class0 + ".");  // 初始化器: Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
        }
        Object object0 = this.g.get(class0);
        if(!class0.equals(b.class)) {
            return object0;
        }
        b b0 = (b)object0;
        return new t(this.f);
    }
}

