package i.n.i.b.a.s.e;

public abstract class v9 implements b {
    public final String a;

    public v9(String s) {
        this.a = s;
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return this.a;
    }
}

