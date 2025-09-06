package i.n.i.b.a.s.e;

public abstract class ga implements b {
    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final String toString() {
        return "SCTE-35 splice command: type=" + this.getClass().getSimpleName();
    }
}

