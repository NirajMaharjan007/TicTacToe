import javax.swing.UIManager;

import resources.MainFrame;

public class MainActivity {
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        System.out.println("MainActivity.main()");
        new MainFrame();
    }
}
