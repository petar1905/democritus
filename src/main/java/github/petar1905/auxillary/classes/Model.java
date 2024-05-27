package github.petar1905.auxillary.classes;

public abstract class Model {
    private boolean disabled;
    protected static String deletedMsg;
    protected void disable() {
        this.disabled = true;
    };

    protected boolean getDisabledStatus() {
        return disabled;
    }
}
