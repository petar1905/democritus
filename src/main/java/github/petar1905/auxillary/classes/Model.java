package github.petar1905.auxillary.classes;

import lombok.Getter;

public abstract class Model {
    private @Getter boolean disabled;
    protected static String deletedMsg;
    protected void disable() {
        this.disabled = true;
    };

    protected boolean getDisabledStatus() {
        return disabled;
    }
}
