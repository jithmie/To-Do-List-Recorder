import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskComponent extends JPanel implements ActionListener {
    private JCheckBox checkBox;
    private JTextPane taskField;
    private JButton deleteButton;

    JFrame window;
    JColorChooser cc;
    JPanel colorChooserPanel;

    public JTextPane getTaskField() {
        return taskField;
    }

    // this panel is used so that we can make updates to the task component panel when deleting task
    private JPanel parentPanel;

    public TaskComponent(JPanel parentPanel){
        this.parentPanel = parentPanel;

        // add the task field
        taskField = new JTextPane();
        taskField.setPreferredSize(CommonConstants.TASKFIELD_SIZE);
        taskField.setContentType("text/html");

        // add checkbox to window
        checkBox = new JCheckBox();
        checkBox.setPreferredSize(CommonConstants.CHECKBOX_SIZE);
        checkBox.addActionListener(this);

        // creating the delete button
        deleteButton = new JButton("X");
        deleteButton.setPreferredSize(CommonConstants.DELETEBTN_SIZE);
        deleteButton.addActionListener(this);

        // add to taskcomponent window
        add(checkBox);
        add(taskField);
        add(deleteButton);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(checkBox.isSelected()){
            // replaces all html tags to empty string to grab the maintext
            String taskText = taskField.getText().replaceAll("<[^>]*>","");

            // add strike through text
            taskField.setText("<html><s>"+ taskText +"</s></html>");
        }else if(!checkBox.isSelected()){
            String taskText = taskField.getText().replaceAll("<[^>]*>", "");

            taskField.setText(taskText);
        }
        if(e.getActionCommand().equalsIgnoreCase("X")){
            // delete this component from the parent panel
            parentPanel.remove(this);
            parentPanel.repaint();
            parentPanel.revalidate();
        }
    }
}
