package innopolis.unversity.classloaders;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Integer i = -128;
        Integer i1 = -128;
        System.out.println(i == i1);

//        String modulePath = "/home/vladimir/InnopolisUniversityProject/modules/";
//        ModuleClassLoader classLoader = new ModuleClassLoader(ClassLoader.getSystemClassLoader(), modulePath);
//
//        File dir = new File(modulePath);
//        String[] files = dir.list();
//
//        for (String module: files) {
//            String moduleName = module.split(".class")[0];
//            try {
//                Class<?> clazz = classLoader.loadClass(moduleName);
//                Module moduleObject = (Module) clazz.newInstance();
//
//                moduleObject.load();
//                moduleObject.run();
//                moduleObject.unload();
//
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
