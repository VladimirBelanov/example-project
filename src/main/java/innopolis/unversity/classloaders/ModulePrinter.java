package innopolis.unversity.classloaders;

public class ModulePrinter implements Module {

    @Override
    public void load() {
        System.out.println("Loading ModulePrinter");
    }

    @Override
    public int run() {
        System.out.println("Running ModulePrinter");
        return 0;
    }

    @Override
    public void unload() {
        System.out.println("Unloadin ModulePrinter");
    }
}
