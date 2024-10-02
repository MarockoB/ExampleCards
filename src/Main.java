import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Robot> robots = loadRobots("robots.txt");
        filterRobots(robots);
    }

    private static void filterRobots(List<Robot> robots) {
        List<Robot> southWatchers = robots.stream()
                .filter(robot -> robot.direction == SideWorld.SOUTH)
                .toList();
        System.out.println("southWatchers = " + southWatchers);

        Map<SideWorld, Long> directionCount = robots.stream()
                .collect(Collectors.groupingBy(Robot::getDirection, Collectors.counting()));

        directionCount.forEach((direction, count) ->
                System.out.println(direction + ": " + count));
    }

    public static List<Robot> loadRobots(String filePath) {
        List<Robot> robots = new LinkedList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                SideWorld direction = SideWorld.valueOf(parts[2].toUpperCase());
                robots.add(new Robot(x, y, direction));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        } return robots;
    }
}