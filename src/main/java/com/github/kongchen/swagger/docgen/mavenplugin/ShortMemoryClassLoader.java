package com.github.kongchen.swagger.docgen.mavenplugin;

import edu.emory.mathcs.backport.java.util.Collections;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class ShortMemoryClassLoader extends URLClassLoader {

    private List<URL> classpath = new LinkedList<URL>();

    public ShortMemoryClassLoader(ClassLoader classLoader) {
        super(new URL[0], classLoader);
    }

    @Override
    public void addURL(URL url) {
        classpath.add(url);
        super.addURL(url);
    }

    @Override
    public Enumeration<URL> getResources(String name) throws IOException {
        return Collections.enumeration(classpath);
    }
}
