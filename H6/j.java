package H6;

import B7.b;
import i.n.i.b.a.s.e.Ga;
import i.n.i.b.a.s.e.M7;
import i.n.i.b.a.s.e.l7;
import i.n.i.b.a.s.e.l8;
import java.util.Iterator;
import java.util.NoSuchElementException;
import y5.a;

public final class j implements Iterator {
    public final int a;
    public int b;
    public String c;
    public final CharSequence d;
    public int e;
    public int f;
    public final Object g;
    public final Object h;

    public j(b b0, CharSequence charSequence0, c c0) {
        this.a = 0;
        super();
        this.h = c0;
        this.b = 2;
        this.e = 0;
        this.g = (H6.b)b0.b;
        this.f = b0.a;
        this.d = charSequence0;
    }

    public j(Ga ga0, b b0, CharSequence charSequence0) {
        this.a = 1;
        super();
        this.h = ga0;
        this.b = 2;
        this.e = 0;
        this.g = (M7)b0.b;
        this.f = b0.a;
        this.d = charSequence0;
    }

    @Override
    public final boolean hasNext() {
        CharSequence charSequence1;
        int v8;
        CharSequence charSequence0;
        int v2;
        if(this.a != 0) {
            int v = this.b;
            if(v == 4) {
                throw new IllegalStateException();
            }
            switch(l7.a[e0.b.b(v)]) {
                case 1: {
                    return true;
                label_6:
                    this.b = 4;
                    M7 m70 = (M7)this.g;
                    int v1 = this.e;
                    while(true) {
                        v2 = this.e;
                        if(v2 == -1) {
                            goto label_49;
                        }
                        l8 l80 = (l8)((Ga)this.h).b;
                        charSequence0 = this.d;
                        int v3 = charSequence0.length();
                        M7.E(v2, v3);
                        while(true) {
                            if(v2 < v3) {
                                if(l80.K(charSequence0.charAt(v2))) {
                                    break;
                                }
                                else {
                                    ++v2;
                                    continue;
                                }
                            }
                            v2 = -1;
                            break;
                        }
                        if(v2 == -1) {
                            v2 = charSequence0.length();
                            this.e = -1;
                        }
                        else {
                            this.e = v2 + 1;
                        }
                        int v4 = this.e;
                        if(v4 == v1) {
                            this.e = v4 + 1;
                            if(v4 + 1 <= charSequence0.length()) {
                                continue;
                            }
                            this.e = -1;
                            continue;
                        }
                        else {
                            break;
                        }
                        goto label_51;
                    }
                    while(v1 < v2 && m70.K(charSequence0.charAt(v1))) {
                        ++v1;
                    }
                    while(v2 > v1 && m70.K(charSequence0.charAt(v2 - 1))) {
                        --v2;
                    }
                    int v5 = this.f;
                    if(v5 == 1) {
                        v2 = charSequence0.length();
                        this.e = -1;
                        while(v2 > v1 && m70.K(charSequence0.charAt(v2 - 1))) {
                            --v2;
                        }
                    }
                    else {
                        this.f = v5 - 1;
                    }
                    String s = charSequence0.subSequence(v1, v2).toString();
                    goto label_51;
                label_49:
                    this.b = 3;
                    s = null;
                label_51:
                    this.c = s;
                    if(this.b != 3) {
                        this.b = 1;
                        return true;
                    }
                    break;
                }
                case 2: {
                    break;
                }
                default: {
                    goto label_6;
                }
            }
            return false;
        }
        int v6 = this.b;
        if(v6 == 4) {
            throw new IllegalStateException();
        }
        switch(e0.b.b(v6)) {
            case 0: {
                return true;
            label_62:
                this.b = 4;
                H6.b b0 = (H6.b)this.g;
                int v7 = this.e;
                while(true) {
                    v8 = this.e;
                    if(v8 == -1) {
                        goto label_105;
                    }
                    c c0 = (c)this.h;
                    charSequence1 = this.d;
                    int v9 = charSequence1.length();
                    a.p(v8, v9);
                    while(true) {
                        if(v8 < v9) {
                            if(c0.a(charSequence1.charAt(v8))) {
                                break;
                            }
                            else {
                                ++v8;
                                continue;
                            }
                        }
                        v8 = -1;
                        break;
                    }
                    if(v8 == -1) {
                        v8 = charSequence1.length();
                        this.e = -1;
                    }
                    else {
                        this.e = v8 + 1;
                    }
                    int v10 = this.e;
                    if(v10 == v7) {
                        this.e = v10 + 1;
                        if(v10 + 1 <= charSequence1.length()) {
                            continue;
                        }
                        this.e = -1;
                        continue;
                    }
                    else {
                        break;
                    }
                    goto label_107;
                }
                while(v7 < v8 && b0.a(charSequence1.charAt(v7))) {
                    ++v7;
                }
                while(v8 > v7 && b0.a(charSequence1.charAt(v8 - 1))) {
                    --v8;
                }
                int v11 = this.f;
                if(v11 == 1) {
                    v8 = charSequence1.length();
                    this.e = -1;
                    while(v8 > v7 && b0.a(charSequence1.charAt(v8 - 1))) {
                        --v8;
                    }
                }
                else {
                    this.f = v11 - 1;
                }
                String s1 = charSequence1.subSequence(v7, v8).toString();
                goto label_107;
            label_105:
                this.b = 3;
                s1 = null;
            label_107:
                this.c = s1;
                if(this.b != 3) {
                    this.b = 1;
                    return true;
                }
                break;
            }
            case 2: {
                break;
            }
            default: {
                goto label_62;
            }
        }
        return false;
    }

    @Override
    public final Object next() {
        if(this.a != 0) {
            if(!this.hasNext()) {
                throw new NoSuchElementException();
            }
            this.b = 2;
            String s = this.c;
            this.c = null;
            return s;
        }
        if(!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.b = 2;
        String s1 = this.c;
        this.c = null;
        return s1;
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

