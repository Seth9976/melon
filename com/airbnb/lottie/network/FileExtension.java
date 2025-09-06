package com.airbnb.lottie.network;

public enum FileExtension {
    JSON(".json"),
    ZIP(".zip"),
    GZIP(".gz");

    public final String extension;

    private static FileExtension[] $values() [...] // Inlined contents

    private FileExtension(String s1) {
        this.extension = s1;
    }

    public String tempExtension() {
        return ".temp" + this.extension;
    }

    @Override
    public String toString() {
        return this.extension;
    }
}

