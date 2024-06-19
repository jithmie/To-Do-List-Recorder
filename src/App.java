import javax.swing.*;

public class App {

    JColorChooser cc;
    JPanel colorChooserPanel;

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new ToDoList().setVisible(true);
            }
        });
    }
}
