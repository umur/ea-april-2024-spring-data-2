package com.ea.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ObjectSizeEstimator {

    public static long estimateSize(Object obj) {
        try {
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
            objectStream.writeObject(obj);
            objectStream.flush();
            objectStream.close();
            return byteStream.size();
        } catch (IOException e) {
            log.error("Error occurred while estimating object size", e);
            return -1; // Error occurred, return -1 as a flag
        }
    }

}

