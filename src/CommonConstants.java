import java.awt.*;

public class CommonConstants {
    // frame
    public static final Dimension GUI_SIZE = new Dimension(500,700);

    // banner config
    public static final Dimension BANNER_SIZE = new Dimension(GUI_SIZE.width, 50);

    //task panel config
    public static final Dimension TASKPANEL_SIZE = new Dimension(GUI_SIZE.width - 30, GUI_SIZE.height - 175);

    // add task button config
    public static final Dimension ADDTASK_BTN_SIZE = new Dimension( GUI_SIZE.width, 40);

    // taskcomponent configs
    public static final Dimension TASKFIELD_SIZE = new Dimension((int)(TASKPANEL_SIZE.width * 0.60), 50);
    public static final Dimension CHECKBOX_SIZE = new Dimension((int)(TASKFIELD_SIZE.width * 0.20), 50);
    public static final Dimension DELETEBTN_SIZE = new Dimension((int)(TASKFIELD_SIZE.width * 0.20), 50);
}
