package ac;

public final class e extends H0.e {
    public final String e;

    public e(String s) {
        this.e = s;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof e && this.e.equals(((e)object0).e);
    }

    @Override
    public final int hashCode() {
        return 0x4CF + this.e.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "Live(liveSeq=" + this.e + ", isOnAir=true)";
    }
}

