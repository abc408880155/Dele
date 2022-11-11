package WindowManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Windows extends JFrame {
    JButton fileButton;
    public Windows(){
        super("Dele");
        Container c= getContentPane();
        c.setLayout(new BorderLayout());

        fileButton = new JButton("打开文件夹");
        fileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                int i = jFileChooser.showOpenDialog(getContentPane());
                if(i == jFileChooser.APPROVE_OPTION){
                    File selectedFile = jFileChooser.getSelectedFile();

                }
            }
        });
        c.add(fileButton);

    }

    public static void init(JFrame jFrame, int width, int height){
        jFrame.setSize(width,height);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        init(new Windows(), 400,300);
    }
}
