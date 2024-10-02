public class Robot {
    SideWorld direction;
    int x;
    int y;

    public Robot(int x, int y, SideWorld direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Robot{" + "direction=" + direction + ", x=" + x + ", y=" + y + '}';
    }

    public void moveForward(){
        switch (direction){
            case NORTH -> y++;
            case EAST -> x++;
            case SOUTH -> y--;
            case WEST -> x--;
        }
    }

    public void moveRight(){
        switch (direction){
            case SideWorld.EAST: direction = SideWorld.SOUTH; break;
            case SideWorld.WEST: direction = SideWorld.NORTH; break;
            case SideWorld.NORTH: direction = SideWorld.EAST; break;
            case SideWorld.SOUTH: direction = SideWorld.WEST; break;
        }
    }

    public void moveLeft(){
        switch (direction){
            case SideWorld.EAST: direction = SideWorld.NORTH; break;
            case SideWorld.WEST: direction = SideWorld.SOUTH; break;
            case SideWorld.NORTH: direction = SideWorld.WEST; break;
            case SideWorld.SOUTH: direction = SideWorld.EAST; break;
        }
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public SideWorld getDirection(){
        return direction;
    }
}