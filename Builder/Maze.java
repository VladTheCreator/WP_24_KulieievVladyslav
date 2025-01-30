import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author artgo
 * Klase reprezentuje labirynt
 */
class Maze {

  public void addRoom(Room room)   {
      rooms.add(room);
  }
  
  /**
   * Znajduje pomieszczenie o podanym numerze
   * @param nr - numer szukanego pomieszczenia
   * @return pokój o podanym numerze lub null w przypadku braku
   */
  public Room getRoomNo(int nr) {
      Iterator<Room> it = rooms.iterator();
      Room r;
      while (it.hasNext())
      {
          r = it.next();
          if (r.getRoomNumber() == nr)
              return r;
      }
      return null;
  }   

  /**
   * Rysuje labyrynt
   * @param image - obiekt, na którym jest rysowany labirynt
   * @return obiekt, na którym jest rysowany labirynt
   */ 
  public Image drawMaze(Image image) {
      Iterator<Room> it = rooms.iterator();
      Room r;
      while (it.hasNext())
      {
          r = it.next();
          r.draw(image);
      }  
      return image;
  }
  
  private ArrayList<Room> rooms = new ArrayList<>(); //  lista pokojów
};