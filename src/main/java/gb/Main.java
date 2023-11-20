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

        Map<Integer, String> winMap = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            Game game = new Game(doors);
            game.hivePrize();
            game.selectDoor();
            game.openDoor();
            game.changeDoor();
            winMap.put(i, game.play());
            game.initDoors();
        }
        System.out.println("Статистика игры с заменой двери");
        getStatistic(winMap);

        winMap = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            Game game = new Game(doors);
            game.hivePrize();
            game.selectDoor();
            game.openDoor();
            winMap.put(i, game.play());
            game.initDoors();
        }
        System.out.println("Статистика игры без замены двери");
        getStatistic(winMap);
    }

    public static void getStatistic(Map<Integer, String> winMap) {
        int winCount = 0;
        int looseCount = 0;
        for (Map.Entry<Integer, String> entry : winMap.entrySet()) {
            if (entry.getValue().equals("win ")) {
                System.out.print("win");
                winCount++;
            } else {
                System.out.print("lose ");
                looseCount++;
            }
        }
        System.out.printf("Выигрышей: %s, проигрышей: %s", winCount, looseCount);
        System.out.printf("\nПроцент выигрышей: %s%%\n", winCount*100/1000);
    }
}