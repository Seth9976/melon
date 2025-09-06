package androidx.recyclerview.widget;

public final class p0 {
    public int a;
    public int b;

    public p0() {
        this.a = -1;
        this.b = 0;
    }

    public p0(int v, int v1) {
        this.a = v;
        this.b = v1;
        super();
    }

    public int a() {
        switch(this.b) {
            case 2: {
                return 10;
            }
            case 5: {
                return 11;
            }
            case 22: {
                return 0x40000000;
            }
            case 23: {
                return 15;
            }
            case 29: {
                return 12;
            }
            case 42: {
                return 16;
            }
            default: {
                return 0;
            }
        }
    }

    public void b(O0 o00) {
        this.a = o00.itemView.getLeft();
        this.b = o00.itemView.getTop();
        o00.itemView.getRight();
        o00.itemView.getBottom();
    }
}

