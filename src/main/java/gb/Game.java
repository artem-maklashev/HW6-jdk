package gb;

import java.util.AbstractList;
import java.util.List;

public class Game {
    private final List<Door> doors;


    private int selectedDoor;
    private boolean win;

    public Game(List<Door> doors) {
        this.doors = doors;
    }
    public void hivePrize(){
        int random = (int) (Math.random() * doors.size());
        doors.get(random).setHavePrize(true);
    }
    public void selectDoor() {
        selectedDoor = (int) (Math.random() * doors.size());
        doors.get(selectedDoor).setChosen(true);
    }

    public void openDoor(){
        for (Door door : doors) {
            if (!door.isChosen() && !door.isHavePrize()) {
                door.open();
                break;
            }
        }
    }

    public void changeDoor(){
        for (int i = 0; i < doors.size() ; i++) {
            if (i != selectedDoor && !doors.get(i).isOpen()) {
                doors.get(selectedDoor).setChosen(false);
                doors.get(i).setChosen(true);
                selectedDoor = i;
                break;
            }
        }
    }

    public void play() {
        if (doors.get(selectedDoor).isHavePrize()) {
            win = true;
        }
    }

    public void initDoors() {
        for (Door door : doors) {
            door.setChosen(false);
            door.setHavePrize(false);
            door.setOpen(false);
        }
    }

    public boolean isWin() {
        return win;
    }
}
