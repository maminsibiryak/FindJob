import com.classforparse.*;
import org.jsoup.nodes.Document;

import java.awt.EventQueue;

import javax.print.Doc;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class ParseLauncher {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ParseLauncher window = new ParseLauncher();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public ParseLauncher() throws IOException {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() throws IOException {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        final JTextArea textArea = new JTextArea();
        frame.getContentPane().add(textArea, BorderLayout.CENTER);


        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        frame.add(scrollPane);

        JMenu mnNewMenu = new JMenu("Menu");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("Parse HeadHunter");
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {



                try {
                    String result = HeadHunter.setResult();
                    HeadHunter.setResult(result);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                textArea.setText(HeadHunter.getResult());



            }
        });
        mnNewMenu.add(mntmNewMenuItem);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("День рождения");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aTimer timer = new aTimer();
                //System.out.println(timer.getFinal());
                try {
                    LocalDate localDate =  LocalDate.now();

                    String textField = "2018/04/28 00:00:00";
                    String str = timer.getFinal(textField);
                    textArea.setText("Today"+localDate+"\n"+"Осталось "+str);
                }
                catch (Exception e1){

                }


            }
        });
        mnNewMenu.add(mntmNewMenuItem_1);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
        mnNewMenu.add(mntmNewMenuItem_2);

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
        mnNewMenu.add(mntmNewMenuItem_3);

        JMenuItem mntmNewMenuItem_4 = new JMenuItem("SuperJob");
        mntmNewMenuItem_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    textArea.setText(SuperJob.getResult());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }


            }
        });
        mnNewMenu.add(mntmNewMenuItem_4);


    }

}
