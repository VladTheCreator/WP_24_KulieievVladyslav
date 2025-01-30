
/**
 *
 * @author artgo
 */
public interface MazeBuilder {
   void buildMaze();    // tworzy pusty labirynt
   void buildRoom(int room, int x, int y); // tworzy pokój
   void buildDoor(int roomFrom, int roomTo); // tworzy drzwi
   Maze getMaze();
}
