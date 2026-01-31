package com.nexus;

public enum ReadingStatus {
    NEW, // just detectd in folder
    WANT_TO_READ, // user flagged it as interesting
    READING, // currently active
    COMPLEATED, // done
    ABANDONED // started but stopped
}
