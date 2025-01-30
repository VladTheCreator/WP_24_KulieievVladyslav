import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Door extends MapSite 
{

   public Door(Room r1, Room r2) {
     super(-1, -1);
     roomOne = r1;
     roomTwo = r2;
   }

   @Override
   public void draw (Image image) {
      int x1 = roomOne.getX();
      int y1 = roomOne.getY();
      int x2 = roomTwo.getX();
      int y2 = roomTwo.getY();
      int x;
      int y;
      Graphics g = image.getGraphics();
      g.setColor(Color.black);
      if (x1 == x2) { // pokoje leżą w pionie, ściana z drzwiami jest pozioma
         y = (y1 > y2) ? y1 : y2;
         g.drawLine(x1, y, x1 + MapSite.LENGTH / 3, y);
         g.drawLine(x1 + 2 * MapSite.LENGTH / 3, y, x1 + MapSite.LENGTH, y);

      }
      else { // pokoje leżą w poziomie, ściana z drzwiami jest pionowa
         x = (x1 > x2) ? x1 : x2;
         g.drawLine(x, y1, x, y1 + MapSite.LENGTH / 3);
         g.drawLine(x, y1 + 2 * MapSite.LENGTH / 3, x, y1 + MapSite.LENGTH);
      }
    }
   
   private Room roomOne;
   private Room roomTwo;
   private boolean isOpen;
}
