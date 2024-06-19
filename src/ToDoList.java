import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoList extends JFrame implements ActionListener {
    private JPanel taskPanel, taskCompPanel;

    public ToDoList(){
        super("To-Do List Recorder");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(CommonConstants.GUI_SIZE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        addGuiComp();
    }
    private void addGuiComp(){
        // Add the banner text
        JLabel bannerLabel = new JLabel("To-Do List");
        //bannerLabel.setFont(createFont("font/Montserrat-VariableFont_wght.ttf", 36f));
        bannerLabel.setBounds(
                (CommonConstants.GUI_SIZE.width - bannerLabel.getPreferredSize().width)/2,
                20,
                CommonConstants.BANNER_SIZE.width,
                CommonConstants.BANNER_SIZE.height
        );

        // add the task panel
        taskPanel = new JPanel();

        // task component panel
        taskCompPanel = new JPanel();
        taskCompPanel.setLayout(new BoxLayout(taskCompPanel, BoxLayout.Y_AXIS));
        taskPanel.add(taskCompPanel);

        // add scrolling to the task panel
        JScrollPane scrollPane = new JScrollPane(taskPanel);
        scrollPane.setBounds(8, 80, CommonConstants.TASKPANEL_SIZE.width, CommonConstants.TASKPANEL_SIZE.height);
        scrollPane.setMaximumSize(CommonConstants.TASKPANEL_SIZE);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // add task button
        JButton addTaskButton = new JButton("Add Task");
        addTaskButton.setBounds(-5, CommonConstants.GUI_SIZE.height - 85,
                CommonConstants.ADDTASK_BTN_SIZE.width,
                CommonConstants.ADDTASK_BTN_SIZE.height);
        addTaskButton.addActionListener(this);

        // add to frame
        this.getContentPane().add(bannerLabel);
        this.getContentPane().add(scrollPane);
        this.getContentPane().add(addTaskButton);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        if(command.equalsIgnoreCase("Add Task")){
            // create a task component
            TaskComponent taskComponent = new TaskComponent(taskCompPanel);
            taskCompPanel.add(taskComponent);

            // make the task field request focus after creation
            taskComponent.getTaskField().requestFocus();
            repaint();
            revalidate();
        }
    }
}