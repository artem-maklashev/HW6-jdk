package gb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Door door1 = new Door();
        Door door2 = new Door();
        Door door3 = new Door();

        List<Door> doors = new ArrayList<>();
        doors.add(door1);
        doors.add(door2);
        doors.add(door3);

        Map<Integer, Boolean> winMap = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            Game game = new Game(doors);
            game.hivePrize();
            game.selectDoor();
            game.openDoor();
            game.changeDoor();
            game.play();
            winMap.put(i, game.isWin());
            game.initDoors();
        }
        System.out.println("Статистика игры с заменой двери" +
                           "\n===============================");
        getStatistic(winMap);

        winMap = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            Game game = new Game(doors);
            game.hivePrize();
            game.selectDoor();
            game.openDoor();
            game.play();
            winMap.put(i, game.isWin());
            game.initDoors();
        }
        System.out.println("\nСтатистика игры без замены двери"+
                "\n===============================");
        getStatistic(winMap);
    }

    public static void getStatistic(Map<Integer, Boolean> winMap) {
        int winCount = 0;
        int looseCount = 0;
        for (Map.Entry<Integer, Boolean> entry : winMap.entrySet()) {
            if (entry.getValue()) {
                winCount++;
            } else {
                looseCount++;
            }
        }
        System.out.printf("Выигрышей: %s, проигрышей: %s", winCount, looseCount);
        System.out.printf("\nПроцент выигрышей: %s %%\n", winCount*100/winMap.size());
    }
}