/**
 * Java level 1. Lesson 7. Home work - Cat and plate
 * @author Zagretdinov Airat
 * @version 1.0 date 21.02.2020
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.imageio.ImageIO;

class HWLesson7 {
    
    public static void main(String[] args) {
        Window window = new Window();
    }    
}

abstract class CatAbstract {

    abstract void eat(Plate plate);
}

class Cat extends CatAbstract {
    private String name;
    private int appetite, x, y;
    private boolean satiety = false;

    public Cat(String name, int appetite, int x, int y) {
        this.name = name;
        this.appetite = appetite;
        this.x = x;
        this.y = y;
    }

    @Override
    public void eat(Plate plate) {
        satiety = plate.decreaseFood(appetite); 
    }

    public boolean getSatiety() {
        return satiety;
    }

    public void setSatiety() {
        satiety = false;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    void paint(Graphics g) {
        Color oldColor = g.getColor();
        Color greenColor = new Color(0, 208, 55);
        g.drawImage(Window.getImgCat(), x, y, null);
        g.drawString(name, x + 19 - name.length() / 2, y - 9);
        if (satiety) {
            g.setColor(greenColor);
            g.fillRect(x + 36 - appetite, y + 120, appetite * 2, 10);
            g.setColor(oldColor);
        }
        g.drawRect(x + 36 - appetite, y + 120, appetite * 2, 10);
    }
}

class Plate {
    private int food, x, y;

    public Plate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void fillAPlate(int fill) {
        food += fill;
    }

    public boolean decreaseFood(int n) {
        if (n <= food) {
            food -= n;
            return true;
        }
        else {
            System.out.println("There is not enough food in the plate.");
            return false;
        }
    }

    public void resetPlate(Cat[] cats) {
        food = 0;
        for (Cat i : cats) i.setSatiety();

    }

    public void info() {
        System.out.println("In a plate of " + food + " units of food.");
    }

    void paint(Graphics g) {
        Color oldColor = g.getColor();
        Color greenColor = new Color(0, 208, 55);
        g.drawImage(Window.getImgPlate(), x, y, null);
        g.setColor(greenColor);
        if (food >= 500)
            g.fillRect(x - 50, y + 90, 250, 10);
        else g.fillRect(x - 50, y + 90, food/2, 10);

        g.setColor(oldColor);
        g.drawRect(x - 50, y + 90, 250, 10);

    }
}

class Window extends JFrame {
    private String TITLE_OF_PROGRAM = "Catch the gopher";
    private int WINDOW_POSITION_GORIZONT = 100;
    private int WINDOW_POSITION_VERTICAL = 100;
    private int WINDOW_WIDTH = 800;
    private int WINDOW_HEIGHT = 400;
    private String BTN_RESET = "Reset";
    private String BTN_FILL = "Fill the plate";
    private String BTN_FEED = "Feeding";
    private final int INITIAL_PLATE_FILL = 50;
    private static Image imgCat;
    private static Image imgPlate;
    private static Cat[] cats = {new Cat("Murzik", 20, 50, 50), new Cat("Barsik", 25, 250, 50), new Cat("Simka", 17, 450, 50), new Cat("Kiska", 21, 650, 50)};
    private static Plate plate = new Plate(330, 220);

    Window() {
        FrameField graphics_field = new FrameField();
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(WINDOW_POSITION_GORIZONT, WINDOW_POSITION_VERTICAL, WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        //button reset
        JButton reset = new JButton(BTN_RESET);
        add(reset);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plate.resetPlate(cats);
                plate.info();
                graphics_field.repaint();

            }
        });
        //button fill
        JButton fill = new JButton(BTN_FILL);
        add(fill);
        fill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plate.fillAPlate(INITIAL_PLATE_FILL);
                plate.info();
                graphics_field.repaint();
            }
        });
        //button feed
        JButton feed = new JButton(BTN_FEED);
        add(feed);
        feed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 4; i++) {
                    cats[i].eat(plate);
                    if (cats[i].getSatiety())
                        System.out.println(cats[i].getName() + " the cat is full.");
                    plate.info();
                    graphics_field.repaint();
                }

            }
        });
        //layout button
        JPanel panelBtn = new JPanel();
        panelBtn.setLayout(new GridLayout());
        panelBtn.add(feed);
        panelBtn.add(fill);
        panelBtn.add(reset);
        setLayout(new BorderLayout());
        add(panelBtn, BorderLayout.SOUTH);
        add(graphics_field, BorderLayout.CENTER);
        //add cats and plate
        try {
            imgCat = ImageIO.read(HWLesson7.class.getResourceAsStream("cat.png"));
            imgPlate = ImageIO.read(HWLesson7.class.getResourceAsStream("plate.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setVisible(true);

    }

    public static Image getImgCat() {
        return imgCat;
    }

    public static Image getImgPlate() {
        return imgPlate;
    }

    private static class FrameField extends JPanel{
        @Override
        public void paint(Graphics g){
            super.paint(g);
            plate.paint(g);
            for (Cat i : cats) i.paint(g);
        }
    }
}


