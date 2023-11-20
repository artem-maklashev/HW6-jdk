package gb;

public class Door {
    private boolean isOpen;
    private boolean havePrize;
    private boolean isChosen;

    public Door() {

    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isHavePrize() {
        return havePrize;
    }

    public void setHavePrize(boolean havePrize) {
        this.havePrize = havePrize;
    }

    public boolean isChosen() {
        return isChosen;
    }

    public void setChosen(boolean chosen) {
        isChosen = chosen;
    }

    public void open(){
        isOpen = true;
    }
}
