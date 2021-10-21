import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        inputArea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputArea.append(inputArea.getText() + "\n");
                inputArea.setText("");
            }
        });
        southPanel.add(inputArea, BorderLayout.CENTER);

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputArea.append(inputArea.getText() + "\n");
                inputArea.setText("");
            }
        });
        southPanel.add(sendButton, BorderLayout.EAST);
        window.add(southPanel, BorderLayout.SOUTH);

        window.setVisible(true);
    }
}
