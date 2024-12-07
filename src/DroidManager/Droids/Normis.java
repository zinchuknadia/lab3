package DroidManager.Droids;

public class Normis extends Droid {
    static boolean canHealItself = true;

    public Normis(String name) {
        super("Normis", name, 80, 50, 0.5);
    }

    @Override
    public boolean canHealItself() {
        return canHealItself;
    }
}