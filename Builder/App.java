import javax.swing.JFrame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class App extends JFrame {

    private MyJPanel panel;
    private Image image;

    public App() {
        setSize(400, 300);                  // ustawienie rozmiaru okna aplikacji
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // standardowe zamknięcie aplikacji
        panel = new MyJPanel();                          // panel, na którym wyświetlamy narysowany labirynt
        JButton button = new JButton("Draw maze");  // przycisk odpowiedzialny za narysowanie labiryntu
        button.addActionListener(new ActionListener() {  
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = 10;
                int y = 10;
                
                image = panel.getImage();
                buildMaze(100, 100);
                panel.repaint();
            }
        });
        setLayout(new BorderLayout());     // ustawienie menadżera rozkładu
        add(panel, BorderLayout.CENTER);   // dodanie panelu w centralnej części
        add(button, "North");  // dodanie przycisku na górze panela
    }

    public void buildMaze(int x, int y) {
        int nr = 1;     // numer pierwszego pokoju
    
        Wall myWall11 = new Wall(x, y, Directions.East);
        Wall myWall12 = new Wall(x, y, Directions.North);
        Wall myWall13 = new Wall(x, y, Directions.South);
        Wall myWall14 = new Wall(x, y, Directions.West);

        Room room1 = new Room(x, y, nr++);
        room1.setSite(Directions.East, myWall11);
        room1.setSite(Directions.North, myWall12);
        room1.setSite(Directions.South, myWall13);
        room1.setSite(Directions.West, myWall14);

        Wall myWall21 = new Wall(x + MapSite.LENGTH, y, Directions.East);
        Wall myWall22 = new Wall(x + MapSite.LENGTH, y, Directions.North);
        Wall myWall23 = new Wall(x + MapSite.LENGTH, y, Directions.South);
        Wall myWall24 = new Wall(x + MapSite.LENGTH, y, Directions.West);
        
        Room room2 = new Room(x + MapSite.LENGTH, y, nr++);
        room2.setSite(Directions.East, myWall21);
        room2.setSite(Directions.North, myWall22);
        room2.setSite(Directions.South, myWall23);
        room2.setSite(Directions.West, myWall24);
    
        Door door1 = new Door(room1, room2);
        
        room1.setSite(Directions.East, door1);   
        room2.setSite(Directions.West, door1);

        room1.draw(image);
        room2.draw(image);

    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);  // uruchomienie i wyświetlenie okna aplikacji
            }
        });

    }
}
