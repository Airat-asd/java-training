import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    private MyHintTextField sendText;
    private JTextArea textArea;

    class MyHintTextField extends JTextField {
        private String hint;

        public MyHintTextField(String hint) {
            this.hint = hint;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (getText().isEmpty()) g.drawString(hint, 3,16);
        }
    }

    public MyWindow() throws HeadlessException {
        //grafic
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("My chat");
        setBounds(100,100,400,400);
        JButton buttonSend = new JButton("Send");
        sendText = new MyHintTextField("Enter your message");
        JPanel downPanel = new JPanel(new BorderLayout());
        downPanel.add(buttonSend, BorderLayout.WEST);
        downPanel.add(sendText, BorderLayout.CENTER);
        add(downPanel, BorderLayout.SOUTH);
        textArea = new JTextArea(10,20);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        JScrollPane pane = new JScrollPane(textArea);
        add(pane, BorderLayout.CENTER);
        //action
        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        sendText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        setVisible(true);
    }

    void sendMessage() {
        textArea.append(sendText.getText() + "\n");
        sendText.setText("");
        sendText.grabFocus();
    }
}
