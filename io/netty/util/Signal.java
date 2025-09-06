package io.netty.util;

public final class Signal extends Error implements Constant {
    static final class SignalConstant extends AbstractConstant {
        public SignalConstant(int v, String s) {
            super(v, s);
        }
    }

    private final SignalConstant constant;
    private static final ConstantPool pool = null;
    private static final long serialVersionUID = 0xFCEE55ACC7A37AB7L;

    static {
        Signal.pool = new ConstantPool() {
            @Override  // io.netty.util.ConstantPool
            public Constant newConstant(int v, String s) {
                return this.newConstant(v, s);
            }

            public Signal newConstant(int v, String s) {
                return new Signal(v, s, null);
            }
        };
    }

    private Signal(int v, String s) {
        this.constant = new SignalConstant(v, s);
    }

    public Signal(int v, String s, io.netty.util.Signal.1 signal$10) {
        this(v, s);
    }

    public int compareTo(Signal signal0) {
        return this == signal0 ? 0 : this.constant.compareTo(signal0.constant);
    }

    @Override
    public int compareTo(Object object0) {
        return this.compareTo(((Signal)object0));
    }

    @Override
    public boolean equals(Object object0) {
        return this == object0;
    }

    public void expect(Signal signal0) {
        if(this != signal0) {
            throw new IllegalStateException("unexpected signal: " + signal0);
        }
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(this);
    }

    @Override  // io.netty.util.Constant
    public int id() {
        return this.constant.id();
    }

    @Override
    public Throwable initCause(Throwable throwable0) {
        return this;
    }

    @Override  // io.netty.util.Constant
    public String name() {
        return this.constant.name();
    }

    @Override
    public String toString() {
        return this.name();
    }

    public static Signal valueOf(Class class0, String s) {
        return (Signal)Signal.pool.valueOf(class0, s);
    }

    public static Signal valueOf(String s) {
        return (Signal)Signal.pool.valueOf(s);
    }
}

