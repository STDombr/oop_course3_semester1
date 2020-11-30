package classLoader;

import java.io.*;

public class MyClassLoader extends ClassLoader{
    @Override
    public Class<?> findClass(String path) throws ClassNotFoundException {
        File file = new File(path);
        if (!file.isFile())
            throw new ClassNotFoundException("Error! File not exist.");

        InputStream inputStream = null;
        try{
            inputStream = new BufferedInputStream(new FileInputStream(path));
            byte[] b = new byte[(int) file.length()];
            int size = inputStream.read(b);

            String name =path.substring(path.lastIndexOf('/') + 1, path.lastIndexOf('.'));
            return defineClass(name, b, 0, size);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
