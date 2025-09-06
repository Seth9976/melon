package M6;

public final class F extends g implements Runnable {
    public final Runnable h;

    public F(Runnable runnable0) {
        runnable0.getClass();
        this.h = runnable0;
    }

    @Override  // M6.h
    public final String j() {
        return "task=[" + this.h + "]";
    }

    @Override
    public final void run() {
        try {
            this.h.run();
        }
        catch(Throwable throwable0) {
            this.l(throwable0);
            throw throwable0;
        }
    }
}

