package com.example.app.java;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.schema.JsonSerializableSchema;

import java.util.List;

@JsonSerializableSchema
public class Tower {
    private final List<Disk> disks;

    public Tower(List<Disk> disks)  {
        this.disks = disks;
    }

    public List<Disk> getDisks() {
        return disks;
    }

    public void removeTopDisk() {
        disks.remove(0);
    }

    public void addDiskToTop(Disk disk) {
        disks.add(0, disk);
    }

    @JsonIgnore
    public Disk getTopDisk() {
        return (disks.size()==0) ? Disk.EMPTY_DISK : disks.get(0);
    }
}
