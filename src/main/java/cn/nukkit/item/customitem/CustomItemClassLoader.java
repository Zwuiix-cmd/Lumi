package cn.nukkit.item.customitem;

import lombok.Getter;
import lombok.Setter;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomItemClassLoader extends ClassLoader {

    @Getter
    @Setter
    private List<ClassLoader> classLoaders = new ArrayList<>();

    HashMap<String, Class<?>> classes = new HashMap<>();

    public void addClassLoader(ClassLoader classLoader) {
        classLoaders.add(classLoader);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        for (ClassLoader classLoader : classLoaders) {
            try {
                return classLoader.loadClass(name);
            } catch (ClassNotFoundException ignored) {
            }
        }
        throw new ClassNotFoundException(name);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        try {
            return super.loadClass(name);
        } catch (ClassNotFoundException e) {
            return findClass(name);
        }
    }

    public Class<?> defineClass(String name, byte[] buffer) {
        Class<?> clazz = super.defineClass(name, buffer, 0, buffer.length);
        classes.put(name, clazz);
        return clazz;
    }

    public InputStream getResourceAsStream(String name) {
        for (ClassLoader classLoader: classLoaders) {
            try {
                InputStream stream = classLoader.getResourceAsStream(name);
                if (stream != null)
                    return stream;
            } catch (Exception ignored) {}
        }

        return super.getResourceAsStream(name);
    }

}