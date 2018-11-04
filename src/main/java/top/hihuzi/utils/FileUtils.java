package top.hihuzi.utils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * tips
 *
 * @author: hihuzi 2018/11/4 11:14
 */
public class FileUtils {

    /**
     * tips 以maven构建的项目
     **/
    private static String path = System.getProperty("user.dir").replaceAll("\\\\", "/") + "/src/main/java/";

    public static List<Class<?>> getAllClass(String packageName) {

        boolean recursive = true;
        List<Class<?>> clazzs = new ArrayList<>();
        try {
            Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(packageName);
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                if ("file".equals(url.getProtocol())) {
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    findClassInPackageByFile(packageName, filePath, recursive, clazzs);
                }
            }

        } catch (IOException e) {
        }
        return clazzs;
    }

    /**
     * tips 在package对应的路径下找到所有的class
     *
     * @parameter: String packageName
     * @parameter: String filePath
     * @parameter: final boolean recursive
     * @parameter: "List<Class<?>>" clazzs
     * @author:hihuzi 2018/9/26 14:03
     */
    private static void findClassInPackageByFile(String packageName, String filePath, final boolean recursive,
                                                List<Class<?>> clazzs) {

        File dir = new File(filePath);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }
        // 在给定的目录下找到所有的文件，并且进行条件过滤
        File[] dirFiles = dir.listFiles(new FileFilter() {

            @Override
            public boolean accept(File file) {

                boolean acceptDir = recursive && file.isDirectory();
                boolean acceptClass = file.getName().endsWith("class");
                return acceptDir || acceptClass;
            }
        });

        for (File file : dirFiles) {
            if (file.isDirectory()) {
                findClassInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, clazzs);
            } else {
                String className = file.getName().replaceAll(".class", "");
                try {
                    clazzs.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + "." + className));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
