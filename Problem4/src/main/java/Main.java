import classLoader.ClassInfo;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassInfo.printClassInfo(ElectricDevice.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "ElectricDevice.class");
    }
}
