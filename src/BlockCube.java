import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by YSK on 2016/9/6.
 */
public class BlockCube extends Block {

    private int maxState;
    private int currentState;
    private LinkedList<Location> locations = new LinkedList<Location>();
    private Field field;

    public BlockCube(Field field){
        this.field = field;
        Color color = field.getColor();
        int tempx = field.getWidth() / 2;
        locations.add(0, new Location(tempx, 0, color));
        locations.add(1, new Location(tempx + 1, 0, color));
        locations.add(2, new Location(tempx, 1, color));
        locations.add(3, new Location(tempx + 1, 1, color));
    }

    @Override
    public LinkedList<Location> getLocations() {
        return locations;
    }

    @Override
    public boolean rotate(MyCube[][] allCubes) {
        return false;
    }

    @Override
    public boolean moveLeft(MyCube[][] allCubes) {
        if(locations.get(0).getX() > 0 && locations.get(1).getX() > 0 &&
                locations.get(2).getX() > 0 && locations.get(3).getX() > 0 &&
                allCubes[locations.get(0).getY()][locations.get(0).getX() - 1] == null &&
                allCubes[locations.get(1).getY()][locations.get(1).getX() - 1] == null &&
                allCubes[locations.get(2).getY()][locations.get(2).getX() - 1] == null &&
                allCubes[locations.get(3).getY()][locations.get(3).getX() - 1] == null){
            locations.get(0).setLocation(-1, 0);
            locations.get(1).setLocation(-1, 0);
            locations.get(2).setLocation(-1, 0);
            locations.get(3).setLocation(-1, 0);
            return true;
        }
        return false;
    }

    @Override
    public boolean moveRight(MyCube[][] allCubes) {
        if(locations.get(0).getX() < field.getWidth() - 1 && locations.get(1).getX() < field.getWidth() - 1 &&
                locations.get(2).getX() < field.getWidth() - 1 && locations.get(3).getX() < field.getWidth() - 1 &&
                allCubes[locations.get(0).getY()][locations.get(0).getX() + 1] == null &&
                allCubes[locations.get(1).getY()][locations.get(1).getX() + 1] == null &&
                allCubes[locations.get(2).getY()][locations.get(2).getX() + 1] == null &&
                allCubes[locations.get(3).getY()][locations.get(3).getX() + 1] == null){
            locations.get(0).setLocation(1, 0);
            locations.get(1).setLocation(1, 0);
            locations.get(2).setLocation(1, 0);
            locations.get(3).setLocation(1, 0);
            return true;
        }
        return false;
    }

    @Override
    public boolean moveDown(MyCube[][] allCubes) {
        if(locations.get(0).getY() < field.getHeight() - 1 && locations.get(1).getY() < field.getHeight() - 1 &&
                locations.get(2).getY() < field.getHeight() - 1 && locations.get(3).getY() < field.getHeight() - 1 &&
                allCubes[locations.get(0).getY() + 1][locations.get(0).getX()] == null &&
                allCubes[locations.get(1).getY() + 1][locations.get(1).getX()] == null &&
                allCubes[locations.get(2).getY() + 1][locations.get(2).getX()] == null &&
                allCubes[locations.get(3).getY() + 1][locations.get(3).getX()] == null){
            locations.get(0).setLocation(0, 1);
            locations.get(1).setLocation(0, 1);
            locations.get(2).setLocation(0, 1);
            locations.get(3).setLocation(0, 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean isBlockFinished(MyCube[][] allCubes) {
        if(locations.get(0).getY() < field.getHeight() - 1 && locations.get(1).getY() < field.getHeight() - 1 &&
                locations.get(2).getY() < field.getHeight() - 1 && locations.get(3).getY() < field.getHeight() - 1 &&
                allCubes[locations.get(0).getY() + 1][locations.get(0).getX()] == null &&
                allCubes[locations.get(1).getY() + 1][locations.get(1).getX()] == null &&
                allCubes[locations.get(2).getY() + 1][locations.get(2).getX()] == null &&
                allCubes[locations.get(3).getY() + 1][locations.get(3).getX()] == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isCreateSucess(MyCube[][] allCubes) {
        if (allCubes[locations.get(0).getY()][locations.get(0).getX()] == null &&
                allCubes[locations.get(1).getY()][locations.get(1).getX()] == null &&
                allCubes[locations.get(2).getY()][locations.get(2).getX()] == null &&
                allCubes[locations.get(3).getY()][locations.get(3).getX()] == null){
            return true;
        }
        return false;
    }

    @Override
    public void draw(Graphics g, int size) {
        g.setColor(locations.get(0).getColor());
        for (int i = 0; i < 4; i++) {
            g.fillRect(locations.get(i).getX() * size, locations.get(i).getY() * size, size, size);
        }
    }
}
