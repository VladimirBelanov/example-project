package innopolis.unversity.classloaders;

import java.io.*;

public class ModuleClassLoader extends ClassLoader {
    private String pathtobin;

    public ModuleClassLoader(ClassLoader classLoader, String pathtobin) {
        super(classLoader);
        this.pathtobin = pathtobin;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        try {
            byte[] byteClass = loadClassFromStorage(pathtobin + className + ".class");
            return defineClass(className, byteClass, 0, byteClass.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(className);
    }

    private byte[] loadClassFromStorage(String fullClassName) throws FileNotFoundException, IOException {

        InputStream is = new FileInputStream(new File(fullClassName));

        long length = new File(fullClassName).length();

        if (length > Integer.MAX_VALUE) {
            // File is too large
        }

        // Create the byte array to hold the data
        byte[] bytes = new byte[(int) length];

        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }

        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + fullClassName);
        }

        // Close the input stream and return bytes
        is.close();
        return bytes;

    }
}
