import javax.swing.*;
import java.awt.*;

public class SimpleChatGUI {
    private final JFrame window;

    public SimpleChatGUI() {
        window = new JFrame();
        window.setTitle("Simple chat");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setBounds(300, 300, 400, 400);
        window.setMinimumSize(window.getSize());


        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        window.add(outputArea, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        JTextField inputArea = new JTextField();
        southPanel.add(inputArea, BorderLayout.CENTER);

        JButton sendButton = new JButton("Send");
        southPanel.add(sendButton, BorderLayout.EAST);
        window.add(southPanel, BorderLayout.SOUTH);

        window.setVisible(true);
    }
}
