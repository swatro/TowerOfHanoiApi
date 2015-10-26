package com.example.app.java;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize
public class Disk {

    private final int diskSize;
    private final String diskName;

    @JsonIgnore
    public static Disk EMPTY_DISK = new Disk(-1);

    public String getDiskName() {
        return diskName;
    }

    Disk(int diskSize) {
        this.diskSize = diskSize;
        this.diskName = String.valueOf(Character.toChars(65 + diskSize));
    }

    public boolean isDiskSmaller(Disk topDisk) {
        return this.diskSize < topDisk.diskSize;
    }

    @Override
    public String toString() {
        return diskName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Disk disk = (Disk) o;

        return diskSize == disk.diskSize;

    }

}
