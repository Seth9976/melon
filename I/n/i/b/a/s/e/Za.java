package i.n.i.b.a.s.e;

import B3.N;
import Pe.z;
import U4.x;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class za extends Xa {
    public final wb g;
    public final N h;
    public int i;
    public final int j;
    public final ya[] k;
    public ya l;
    public List m;
    public List n;
    public N o;
    public int p;

    public za(int v, List list0) {
        this.g = new wb(1, false);
        this.h = new N(6);
        this.i = -1;
        if(v == -1) {
            v = 1;
        }
        this.j = v;
        if(list0 != null && list0.size() == 1 && ((byte[])list0.get(0)).length == 1) {
            int v1 = ((byte[])list0.get(0))[0];
        }
        this.k = new ya[8];
        for(int v2 = 0; v2 < 8; ++v2) {
            this.k[v2] = new ya();
        }
        this.l = this.k[0];
    }

    @Override  // i.n.i.b.a.s.e.Xa
    public final void b(Va va0) {
        ByteBuffer byteBuffer0 = va0.d;
        byteBuffer0.getClass();
        byte[] arr_b = byteBuffer0.array();
        wb wb0 = this.g;
        wb0.i(byteBuffer0.limit(), arr_b);
        while(wb0.d() >= 3) {
            int v = wb0.z();
            int v1 = v & 3;
            boolean z = false;
            byte b = (byte)wb0.z();
            byte b1 = (byte)wb0.z();
            if((v1 == 2 || v1 == 3) && (v & 4) == 4) {
                switch(v1) {
                    case 2: {
                        z = true;
                    label_15:
                        M7.u(z);
                        N n0 = this.o;
                        if(n0 == null) {
                            Log.e("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                            continue;
                        }
                        else {
                            byte[] arr_b1 = n0.d;
                            int v2 = n0.e;
                            n0.e = v2 + 1;
                            arr_b1[v2] = b;
                            n0.e = v2 + 2;
                            arr_b1[v2 + 1] = b1;
                            break;
                        }
                        goto label_27;
                    }
                    case 3: {
                    label_27:
                        this.g();
                        int v3 = (b & 0xC0) >> 6;
                        if(this.i != -1 && v3 != (this.i + 1) % 4) {
                            this.i();
                            Log.w("Cea708Decoder", "Sequence number discontinuity. previous=" + this.i + " current=" + v3);
                        }
                        this.i = v3;
                        N n1 = new N(v3, ((b & 0x3F) == 0 ? 0x40 : b & 0x3F), 5);
                        this.o = n1;
                        n1.e = 1;
                        n1.d[0] = b1;
                        break;
                    }
                    default: {
                        goto label_15;
                    }
                }
                if(this.o.e == this.o.c * 2 - 1) {
                    this.g();
                }
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.Xa
    public final z d() {
        List list0 = this.m;
        this.n = list0;
        list0.getClass();
        return new z(list0, 2);
    }

    @Override  // i.n.i.b.a.s.e.Xa
    public final boolean f() {
        return this.m != this.n;
    }

    @Override  // i.n.i.b.a.s.e.Xa
    public final void flush() {
        super.flush();
        this.m = null;
        this.n = null;
        this.p = 0;
        this.l = this.k[0];
        this.i();
        this.o = null;
    }

    public final void g() {
        N n0 = this.o;
        if(n0 == null) {
            return;
        }
        if(n0.e != n0.c * 2 - 1) {
            Log.d("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + (this.o.c * 2 - 1) + ", but current index is " + this.o.e + " (sequence number " + this.o.b + ");");
        }
        N n1 = this.h;
        n1.c(this.o.e, this.o.d);
        int v = n1.a(3);
        int v1 = n1.a(5);
        if(v == 7) {
            n1.v(2);
            v = n1.a(6);
            if(v < 7) {
                x.u(v, "Invalid extended service number: ", "Cea708Decoder");
            }
        }
        if(v1 != 0) {
            if(v == this.j) {
                boolean z = false;
                while(n1.h() > 0) {
                    int v2 = n1.a(8);
                    if(v2 != 16) {
                        if(v2 <= 0x1F) {
                            switch(v2) {
                                case 3: {
                                    this.m = this.h();
                                    continue;
                                }
                                case 8: {
                                    SpannableStringBuilder spannableStringBuilder0 = this.l.b;
                                    int v3 = spannableStringBuilder0.length();
                                    if(v3 <= 0) {
                                        continue;
                                    }
                                    spannableStringBuilder0.delete(v3 - 1, v3);
                                    continue;
                                }
                                case 12: {
                                    this.i();
                                    continue;
                                }
                                case 13: {
                                    this.l.b('\n');
                                    continue;
                                }
                                case 0: 
                                case 14: {
                                    continue;
                                }
                                default: {
                                    if(v2 >= 17 && v2 <= 23) {
                                        Log.w("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + v2);
                                        n1.v(8);
                                    }
                                    else if(v2 < 24 || v2 > 0x1F) {
                                        x.u(v2, "Invalid C0 command: ", "Cea708Decoder");
                                    }
                                    else {
                                        Log.w("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + v2);
                                        n1.v(16);
                                    }
                                    continue;
                                }
                            }
                        }
                        else if(v2 <= 0x7F) {
                            if(v2 == 0x7F) {
                                this.l.b('♫');
                            }
                            else {
                                this.l.b(((char)(v2 & 0xFF)));
                            }
                            z = true;
                            continue;
                        }
                        else if(v2 <= 0x9F) {
                            ya[] arr_ya = this.k;
                            switch(v2) {
                                case 0x80: 
                                case 0x81: 
                                case 130: 
                                case 0x83: 
                                case 0x84: 
                                case 0x85: 
                                case 0x86: 
                                case 0x87: {
                                    if(this.p != v2 - 0x80) {
                                        this.p = v2 - 0x80;
                                        this.l = arr_ya[v2 - 0x80];
                                    }
                                    z = true;
                                    continue;
                                }
                                case 0x88: {
                                    ya[] arr_ya1 = arr_ya;
                                    for(int v4 = 1; v4 <= 8; ++v4) {
                                        if(n1.y()) {
                                            ya ya0 = arr_ya1[8 - v4];
                                            ya0.a.clear();
                                            ya0.b.clear();
                                            ya0.p = -1;
                                            ya0.q = -1;
                                            ya0.r = -1;
                                            ya0.t = -1;
                                            ya0.v = 0;
                                        }
                                    }
                                    z = true;
                                    continue;
                                }
                                case 0x89: {
                                    ya[] arr_ya2 = arr_ya;
                                    for(int v5 = 1; v5 <= 8; ++v5) {
                                        if(n1.y()) {
                                            arr_ya2[8 - v5].d = true;
                                        }
                                    }
                                    z = true;
                                    continue;
                                }
                                case 0x8A: {
                                    ya[] arr_ya3 = arr_ya;
                                    for(int v6 = 1; v6 <= 8; ++v6) {
                                        if(n1.y()) {
                                            arr_ya3[8 - v6].d = false;
                                        }
                                    }
                                    z = true;
                                    continue;
                                }
                                case 0x8B: {
                                    ya[] arr_ya4 = arr_ya;
                                    for(int v7 = 1; v7 <= 8; ++v7) {
                                        if(n1.y()) {
                                            ya ya1 = arr_ya4[8 - v7];
                                            ya1.d = !ya1.d;
                                        }
                                    }
                                    z = true;
                                    continue;
                                }
                                case 140: {
                                    ya[] arr_ya5 = arr_ya;
                                    for(int v8 = 1; v8 <= 8; ++v8) {
                                        if(n1.y()) {
                                            arr_ya5[8 - v8].f();
                                        }
                                    }
                                    z = true;
                                    continue;
                                }
                                case 0x8D: {
                                    n1.v(8);
                                    z = true;
                                    continue;
                                }
                                case 0x8E: {
                                    z = true;
                                    continue;
                                }
                                case 0x8F: {
                                    this.i();
                                    z = true;
                                    continue;
                                }
                                case 0x90: {
                                    if(this.l.c) {
                                        n1.a(4);
                                        n1.a(2);
                                        n1.a(2);
                                        boolean z1 = n1.y();
                                        boolean z2 = n1.y();
                                        n1.a(3);
                                        n1.a(3);
                                        this.l.c(z1, z2);
                                    }
                                    else {
                                        n1.v(16);
                                    }
                                    z = true;
                                    continue;
                                }
                                case 0x91: {
                                    if(this.l.c) {
                                        int v9 = n1.a(2);
                                        int v10 = ya.a(n1.a(2), n1.a(2), n1.a(2), v9);
                                        int v11 = n1.a(2);
                                        int v12 = ya.a(n1.a(2), n1.a(2), n1.a(2), v11);
                                        n1.v(2);
                                        ya.a(n1.a(2), n1.a(2), n1.a(2), 0);
                                        this.l.d(v10, v12);
                                    }
                                    else {
                                        n1.v(24);
                                    }
                                    z = true;
                                    continue;
                                }
                                case 0x92: {
                                    if(this.l.c) {
                                        n1.v(4);
                                        int v13 = n1.a(4);
                                        n1.v(2);
                                        n1.a(6);
                                        ya ya2 = this.l;
                                        if(ya2.v != v13) {
                                            ya2.b('\n');
                                        }
                                        ya2.v = v13;
                                    }
                                    else {
                                        n1.v(16);
                                    }
                                    z = true;
                                    continue;
                                }
                                case 0x97: {
                                    if(this.l.c) {
                                        int v14 = n1.a(2);
                                        int v15 = ya.a(n1.a(2), n1.a(2), n1.a(2), v14);
                                        n1.a(2);
                                        ya.a(n1.a(2), n1.a(2), n1.a(2), 0);
                                        n1.y();
                                        n1.y();
                                        n1.a(2);
                                        n1.a(2);
                                        int v16 = n1.a(2);
                                        n1.v(8);
                                        this.l.o = v15;
                                        this.l.l = v16;
                                    }
                                    else {
                                        n1.v(0x20);
                                    }
                                    z = true;
                                    continue;
                                }
                                case 0x98: 
                                case 0x99: 
                                case 0x9A: 
                                case 0x9B: 
                                case 0x9C: 
                                case 0x9D: 
                                case 0x9E: 
                                case 0x9F: {
                                    ya ya3 = arr_ya[v2 - 0x98];
                                    n1.v(2);
                                    boolean z3 = n1.y();
                                    boolean z4 = n1.y();
                                    n1.y();
                                    int v17 = n1.a(3);
                                    boolean z5 = n1.y();
                                    int v18 = n1.a(7);
                                    int v19 = n1.a(8);
                                    int v20 = n1.a(4);
                                    int v21 = n1.a(4);
                                    n1.v(2);
                                    n1.a(6);
                                    n1.v(2);
                                    int v22 = n1.a(3);
                                    int v23 = n1.a(3);
                                    ArrayList arrayList0 = ya3.a;
                                    ya3.c = true;
                                    ya3.d = z3;
                                    ya3.k = z4;
                                    ya3.e = v17;
                                    ya3.f = z5;
                                    ya3.g = v18;
                                    ya3.h = v19;
                                    ya3.i = v20;
                                    int v24 = v21 + 1;
                                    if(ya3.j != v24) {
                                        ya3.j = v24;
                                        while(z4 && arrayList0.size() >= ya3.j || arrayList0.size() >= 15) {
                                            arrayList0.remove(0);
                                        }
                                    }
                                    if(v22 != 0 && ya3.m != v22) {
                                        ya3.m = v22;
                                        int v25 = ya.C[v22 - 1];
                                        boolean z6 = ya.B[v22 - 1];
                                        int v26 = ya.z[v22 - 1];
                                        int v27 = ya.A[v22 - 1];
                                        ya3.o = v25;
                                        ya3.l = ya.y[v22 - 1];
                                    }
                                    if(v23 != 0 && ya3.n != v23) {
                                        ya3.n = v23;
                                        int v28 = ya.E[v23 - 1];
                                        int v29 = ya.D[v23 - 1];
                                        ya3.c(false, false);
                                        ya3.d(ya.w, ya.F[v23 - 1]);
                                    }
                                    if(this.p != v2 - 0x98) {
                                        this.p = v2 - 0x98;
                                        this.l = arr_ya[v2 - 0x98];
                                    }
                                    z = true;
                                    continue;
                                }
                                default: {
                                    x.u(v2, "Invalid C1 command: ", "Cea708Decoder");
                                    z = true;
                                    continue;
                                }
                            }
                        }
                        else if(v2 <= 0xFF) {
                            this.l.b(((char)(v2 & 0xFF)));
                            z = true;
                            continue;
                        }
                        else {
                            x.u(v2, "Invalid base command: ", "Cea708Decoder");
                            continue;
                        }
                    }
                    int v30 = n1.a(8);
                    if(v30 <= 0x1F) {
                        if(v30 <= 7) {
                            continue;
                        }
                        if(v30 <= 15) {
                            n1.v(8);
                        }
                        else if(v30 <= 23) {
                            n1.v(16);
                        }
                        else {
                            n1.v(24);
                        }
                    }
                    else if(v30 <= 0x7F) {
                        switch(v30) {
                            case 0x20: {
                                this.l.b(' ');
                                break;
                            }
                            case 33: {
                                this.l.b(' ');
                                break;
                            }
                            case 37: {
                                this.l.b('…');
                                break;
                            }
                            case 42: {
                                this.l.b('Š');
                                break;
                            }
                            case 44: {
                                this.l.b('Œ');
                                break;
                            }
                            case 0x30: {
                                this.l.b('█');
                                break;
                            }
                            case 49: {
                                this.l.b('‘');
                                break;
                            }
                            case 50: {
                                this.l.b('’');
                                break;
                            }
                            case 51: {
                                this.l.b('“');
                                break;
                            }
                            case 52: {
                                this.l.b('”');
                                break;
                            }
                            case 53: {
                                this.l.b('•');
                                break;
                            }
                            case 57: {
                                this.l.b('™');
                                break;
                            }
                            case 58: {
                                this.l.b('š');
                                break;
                            }
                            case 60: {
                                this.l.b('œ');
                                break;
                            }
                            case 61: {
                                this.l.b('℠');
                                break;
                            }
                            case 0x3F: {
                                this.l.b('Ÿ');
                                break;
                            }
                            case 0x76: {
                                this.l.b('⅛');
                                break;
                            }
                            case 0x77: {
                                this.l.b('⅜');
                                break;
                            }
                            case 120: {
                                this.l.b('⅝');
                                break;
                            }
                            case 0x79: {
                                this.l.b('⅞');
                                break;
                            }
                            case 0x7A: {
                                this.l.b('│');
                                break;
                            }
                            case 0x7B: {
                                this.l.b('┐');
                                break;
                            }
                            case 0x7C: {
                                this.l.b('└');
                                break;
                            }
                            case 0x7D: {
                                this.l.b('─');
                                break;
                            }
                            case 0x7E: {
                                this.l.b('┘');
                                break;
                            }
                            case 0x7F: {
                                this.l.b('┌');
                                break;
                            }
                            default: {
                                x.u(v30, "Invalid G2 character: ", "Cea708Decoder");
                            }
                        }
                        z = true;
                    }
                    else if(v30 <= 0x9F) {
                        if(v30 <= 0x87) {
                            n1.v(0x20);
                        }
                        else if(v30 <= 0x8F) {
                            n1.v(40);
                        }
                        else {
                            n1.v(2);
                            n1.v(n1.a(6) * 8);
                        }
                    }
                    else if(v30 <= 0xFF) {
                        if(v30 == 0xA0) {
                            this.l.b('㏄');
                        }
                        else {
                            x.u(v30, "Invalid G3 character: ", "Cea708Decoder");
                            this.l.b('_');
                        }
                        z = true;
                    }
                    else {
                        x.u(v30, "Invalid extended command: ", "Cea708Decoder");
                    }
                }
                if(z) {
                    this.m = this.h();
                }
            }
        }
        else if(v != 0) {
            Log.w("Cea708Decoder", "serviceNumber is non-zero (" + v + ") when blockSize is 0");
        }
        this.o = null;
    }

    public final List h() {
        xa xa0;
        int v8;
        int v7;
        int v6;
        float f1;
        float f;
        Layout.Alignment layout$Alignment0;
        ArrayList arrayList0 = new ArrayList();
        for(int v1 = 0; v1 < 8; ++v1) {
            ya[] arr_ya = this.k;
            ya ya0 = arr_ya[v1];
            if(ya0.c && (!ya0.a.isEmpty() || ya0.b.length() != 0)) {
                ya ya1 = arr_ya[v1];
                if(ya1.d) {
                    ArrayList arrayList1 = ya1.a;
                    if(!ya1.c || arrayList1.isEmpty() && ya1.b.length() == 0) {
                        xa0 = null;
                    }
                    else {
                        SpannableStringBuilder spannableStringBuilder0 = new SpannableStringBuilder();
                        for(int v2 = 0; v2 < arrayList1.size(); ++v2) {
                            spannableStringBuilder0.append(((CharSequence)arrayList1.get(v2)));
                            spannableStringBuilder0.append('\n');
                        }
                        spannableStringBuilder0.append(ya1.e());
                        int v3 = ya1.l;
                        switch(v3) {
                            case 0: {
                                layout$Alignment0 = Layout.Alignment.ALIGN_NORMAL;
                                break;
                            }
                            case 1: {
                                layout$Alignment0 = Layout.Alignment.ALIGN_OPPOSITE;
                                break;
                            }
                            case 2: {
                                layout$Alignment0 = Layout.Alignment.ALIGN_CENTER;
                                break;
                            }
                            default: {
                                if(v3 != 3) {
                                    throw new IllegalArgumentException("Unexpected justification value: " + ya1.l);
                                }
                                layout$Alignment0 = Layout.Alignment.ALIGN_NORMAL;
                            }
                        }
                        if(ya1.f) {
                            f = ((float)ya1.h) / 99.0f;
                            f1 = ((float)ya1.g) / 99.0f;
                        }
                        else {
                            f = ((float)ya1.h) / 209.0f;
                            f1 = ((float)ya1.g) / 74.0f;
                        }
                        int v4 = ya1.i;
                        int v5 = v4 / 3;
                        if(v5 == 0) {
                            v6 = v4;
                            v7 = 0;
                        }
                        else if(v5 == 1) {
                            v6 = v4;
                            v7 = 1;
                        }
                        else {
                            v6 = v4;
                            v7 = 2;
                        }
                        switch(v6 % 3) {
                            case 0: {
                                v8 = 0;
                                break;
                            }
                            case 1: {
                                v8 = 1;
                                break;
                            }
                            default: {
                                v8 = 2;
                            }
                        }
                        xa0 = new xa(spannableStringBuilder0, layout$Alignment0, f1 * 0.9f + 0.05f, v7, f * 0.9f + 0.05f, v8, ya1.o != ya.x, ya1.o, ya1.e);
                    }
                    if(xa0 != null) {
                        arrayList0.add(xa0);
                    }
                }
            }
        }
        Collections.sort(arrayList0, xa.c);
        ArrayList arrayList2 = new ArrayList(arrayList0.size());
        for(int v = 0; v < arrayList0.size(); ++v) {
            arrayList2.add(((xa)arrayList0.get(v)).a);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    public final void i() {
        for(int v = 0; v < 8; ++v) {
            this.k[v].f();
        }
    }
}

