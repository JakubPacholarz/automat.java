import javax.swing.*;


public class payment extends automat {
    private JLabel jeden;
    private JLabel dwa;
    private JLabel trzy;
    private JPanel JPanel2;
    private JPanel JPanel1;
    private JPanel JPanel3;
    private JButton ZAPŁAĆButton;
    private JButton ZAPŁAĆButton1;
    private JTextField iledo;
    private JTextField textField1;

    private JTextField iledo2;

    protected JTextArea textArea12;


    public payment()  {
        this.setContentPane(this.JPanel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);



    }

    public void dozaplaty()
    {
        textfield1.getText();
        iledo.setText(textfield1.getText());
    }



}


