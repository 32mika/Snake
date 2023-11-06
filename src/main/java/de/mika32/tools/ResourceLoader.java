package de.mika32.tools;

import java.io.IOException;
import java.io.InputStream;

public class ResourceLoader {
    public static InputStream loadResource(String resourceName) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(resourceName);

        if (inputStream == null) {
            throw new IOException("Resource not found: " + resourceName);
        }

        return inputStream;
    }
}
