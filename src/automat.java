import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class automat extends JFrame {

    private JPanel JPanel1;
    private JPanel JPanel2;
    private JLabel lable1;
    private JPanel JPanel3;
    private JPanel JPanel4;
    private JButton a50Button;
    private JButton a60Button;
    private JPanel JPanel5;
    private JPanel JPanel6;
    private JButton a30Button;
    private JButton a30Button1;
    private JButton a4zlButton;
    private JButton a5zlButton1;
    private JButton a2zlButton1;
    private JButton a2zlButton;
    private JButton a2zlButton2;
    private JButton a5zlButton3;
    private JButton a4zlButton1;
    private JButton a5zlButton2;
    protected JSpinner spinner1;
    protected JSpinner spinner2;
    private JSpinner spinner3;
    private JSpinner spinner4;
    private JSpinner spinner5;
    private JSpinner spinner6;
    private JSpinner spinner7;
    private JSpinner spinner8;
    private JSpinner spinner9;
    private JSpinner spinner10;
    private JSpinner spinner11;
    private JSpinner spinner12;
    private JPanel JPanel10;
    private JButton TOTALButton;
    private JButton WYJSCIEButton;
    private JButton RESETButton;
    private JPanel JPanel11;
    private JPanel JPanel13;
    private JPanel rachunek;

    private JTextField qwe;
    private JPanel JPanel15;
    protected JLabel JLabelpepsi;
    protected JCheckBox checkBox1;
    protected JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JCheckBox checkBox7;
    private JCheckBox checkBox8;
    private JCheckBox checkBox6;
    private JCheckBox checkBox5;
    private JCheckBox checkBox9;
    private JCheckBox checkBox10;
    private JCheckBox checkBox11;
    private JCheckBox checkBox12;
    protected JLabel Jlabeldata;
    protected JLabel JLabelczas;
    protected JTextArea textArea12;
    protected JLabel cola;
    private JLabel Rogalik;
    private JLabel KNOPERS;
    private JLabel WODANIGAZ;
    private JLabel WODAGAZ;
    private JLabel PALUSZKI;
    private JLabel SIEDEM;
    private JLabel KAWA;
    private JLabel HERBATA;
    private JLabel KANAPKA;
    private JLabel SNIKERS;
    protected JTextField textfield1;
    private JButton payment;

    protected double total = 0.0;

    protected int x = 0;




    public void init() {
        setImage();
    }


    public void setImage() {
        ImageIcon icon = new ImageIcon(getClass().getResource("src/zdj/7days1.jpg"));
        Image img = icon.getImage().getScaledInstance(JLabelpepsi.getWidth(), JLabelpepsi.getHeight(), Image.SCALE_SMOOTH);
        JLabelpepsi.setIcon(new ImageIcon(img));

    }

    public boolean qtyiszero(int qty) {
        if (qty == 0) {
            JOptionPane.showMessageDialog(null, "Prosze zwiekszyc ilosc przedmiotow");
            return false;
        }
        return true;
    }


    public void reset() {
        spinner1.setValue(0);
        spinner2.setValue(0);
        spinner3.setValue(0);
        spinner4.setValue(0);
        spinner5.setValue(0);
        spinner6.setValue(0);
        spinner7.setValue(0);
        spinner8.setValue(0);
        spinner9.setValue(0);
        spinner10.setValue(0);
        spinner11.setValue(0);
        spinner12.setValue(0);
        checkBox1.setSelected(false);
        checkBox2.setSelected(false);
        checkBox3.setSelected(false);
        checkBox4.setSelected(false);
        checkBox5.setSelected(false);
        checkBox6.setSelected(false);
        checkBox7.setSelected(false);
        checkBox8.setSelected(false);
        checkBox9.setSelected(false);
        checkBox10.setSelected(false);
        checkBox11.setSelected(false);
        checkBox12.setSelected(false);
        TOTALButton.setEnabled(true);
        total=0.0;
        x=0;
        textArea12.setText(null);
        textfield1.setText("0.00");



    }

    public void oplata()
    {
        textfield1.setText(String.valueOf(total));


    }



    public static void main(String[] args) {
        automat SwingExample = new automat();
        SwingExample.setVisible(true);


    }

    public void showData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(automat.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Date date = new Date();
                    SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa");
                    SimpleDateFormat df = new SimpleDateFormat("EEEE,dd-MM-yyyy");
                    String time = tf.format(date);
                    JLabelczas.setText(time.split(" ")[0] + " " + time.split(" ")[1]);
                    Jlabeldata.setText(df.format(date));
                }
            }
        }).start();

    }




    public automat() {
        super("AUTOMAT Z JEDZENIEM");
        this.setContentPane(this.JPanel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(750, 500);
        showData();
        //setImage();


        WYJSCIEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        RESETButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
                JOptionPane.showMessageDialog(null,"WYBIERZ PONOWNIE");
            }
        });


        checkBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int qty = Integer.parseInt(spinner1.getValue().toString());
                if (qtyiszero(qty) && checkBox1.isSelected()) {
                    x++;
                    if (x == 1) {
                        new Total();
                    }
                    double cena = qty * 5.0;
                    total += cena;
                    textArea12.setText(textArea12.getText() + x + ". " + JLabelpepsi.getText() + "\t\t" + cena);
                    oplata();
                } else {
                    checkBox1.setSelected(false);
                }


            }


        });
        checkBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int qty = Integer.parseInt(spinner2.getValue().toString());
                if (qtyiszero(qty) && checkBox2.isSelected()) {
                    x++;
                    if (x == 1) {
                        new Total();
                    }
                    double cena = qty * 6.0;
                    total += cena;
                    textArea12.setText(textArea12.getText() + x + ". " + cola.getText() + "\t\t" + cena + "\n");
                    oplata();
                } else {
                    checkBox2.setSelected(false);
                }


            }


        });
        checkBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int qty = Integer.parseInt(spinner3.getValue().toString());
                if (qtyiszero(qty) && checkBox3.isSelected()) {
                    x++;
                    if (x == 1) {
                        new Total();
                    }
                    double cena = qty * 3.0;
                    total += cena;
                    textArea12.setText(textArea12.getText() + x + ". " + Rogalik.getText() + "\t\t" + cena + "\n");
                    oplata();
                } else {
                    checkBox3.setSelected(false);
                }


            }

        });
        checkBox4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int qty = Integer.parseInt(spinner4.getValue().toString());
                if (qtyiszero(qty) && checkBox4.isSelected()) {
                    x++;
                    if (x == 1) {
                        new Total();
                    }
                    double cena = qty*3.0;
                    total += cena;
                    textArea12.setText(textArea12.getText() +x+ ". " + KNOPERS.getText() + "\t\t" + cena+"\n");
                    oplata();
                }else {
                    checkBox4.setSelected(false);
                }


            }

        });
        checkBox5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int qty = Integer.parseInt(spinner8.getValue().toString());
                if (qtyiszero(qty) && checkBox5.isSelected()) {
                    x++;
                    if (x == 1) {
                        new Total();
                    }
                    double cena = qty*2.0;
                    total += cena;
                    textArea12.setText(textArea12.getText() +x+ ". " + WODANIGAZ.getText() + "\t\t" + cena+"\n");
                    oplata();
                }else {
                    checkBox5.setSelected(false);
                }


            }

        });
        checkBox6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int qty = Integer.parseInt(spinner7.getValue().toString());
                if (qtyiszero(qty) && checkBox6.isSelected()) {
                    x++;
                    if (x == 1) {
                        new Total();
                    }
                    double cena = qty*2.0;
                    total += cena;
                    textArea12.setText(textArea12.getText() +x+ ". " + WODAGAZ.getText() + "\t\t" + cena+"\n");
                    oplata();
                }else {
                    checkBox6.setSelected(false);
                }


            }

        });
        checkBox7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int qty = Integer.parseInt(spinner6.getValue().toString());
                if (qtyiszero(qty) && checkBox7.isSelected()) {
                    x++;
                    if (x == 1) {
                        new Total();
                    }
                    double cena = qty*5.0;
                    total += cena;
                    textArea12.setText(textArea12.getText() +x+ ". " + PALUSZKI.getText() + "\t\t" + cena+"\n");
                    oplata();
                }else {
                    checkBox7.setSelected(false);
                }


            }

        });
        checkBox8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int qty = Integer.parseInt(spinner5.getValue().toString());
                if (qtyiszero(qty) && checkBox8.isSelected()) {
                    x++;
                    if (x == 1) {
                        new Total();
                    }
                    double cena = qty*4.0;
                    total += cena;
                    textArea12.setText(textArea12.getText() +x+ ". " + SIEDEM.getText() + "\t\t" + cena+"\n");
                    oplata();
                }else {
                    checkBox8.setSelected(false);
                }


            }

        });
        checkBox9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int qty = Integer.parseInt(spinner9.getValue().toString());
                if (qtyiszero(qty) && checkBox9.isSelected()) {
                    x++;
                    if (x == 1) {
                        new Total();
                    }
                    double cena = qty*5.0;
                    total += cena;
                    textArea12.setText(textArea12.getText() +x+ ". " + KAWA.getText() + "\t\t" + cena+"\n");
                    oplata();
                }else {
                    checkBox9.setSelected(false);
                }


            }

        });
        checkBox10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int qty = Integer.parseInt(spinner10.getValue().toString());
                if (qtyiszero(qty) && checkBox10.isSelected()) {
                    x++;
                    if (x == 1) {
                        new Total();
                    }
                    double cena = qty*4.0;
                    total += cena;
                    textArea12.setText(textArea12.getText() +x+ ". " + HERBATA.getText() + "\t\t" + cena+"\n");
                    oplata();
                }else {
                    checkBox10.setSelected(false);
                }


            }

        });
        checkBox11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int qty = Integer.parseInt(spinner11.getValue().toString());
                if (qtyiszero(qty) && checkBox11.isSelected()) {
                    x++;
                    if (x == 1) {
                        new Total();
                    }
                    double cena = qty*5.0;
                    total += cena;
                    textArea12.setText(textArea12.getText() +x+ ". " + KANAPKA.getText() + "\t\t" + cena+"\n");
                    oplata();
                }else {
                    checkBox11.setSelected(false);
                }


            }

        });
        checkBox12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int qty = Integer.parseInt(spinner12.getValue().toString());
                if (qtyiszero(qty) && checkBox12.isSelected()) {
                    x++;
                    if (x == 1) {
                        new Total();
                    }
                    double cena = qty*2.0;
                    total += cena;
                    textArea12.setText(textArea12.getText() +x+ ". " + SNIKERS.getText() + "\t\t" + cena+"\n");
                    oplata();
                }else {
                    checkBox12.setSelected(false);
                }


            }

        });
        TOTALButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (total==0.0)
                {
                    JOptionPane.showMessageDialog(null, "Nie wybrałeś ani jednego przedmiotu - proszę wybrać przedmiot");
                }else {
                    textArea12.setText(textArea12.getText() + "\n^^^^^\n" + " Calkowity rachunek wynosi: \t\t\t" + total+"\n"+ "^^^^^");
                    TOTALButton.setEnabled(false);
                }
            }
        });

        a50Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = 0;
                x = (int) spinner1.getValue();
                spinner1.setValue(x+1);

            }
        });
        a60Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = 0;
                x = (int) spinner2.getValue();
                spinner2.setValue(x+1);
            }
        });
        a30Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = 0;
                x = (int) spinner3.getValue();
                spinner3.setValue(x+1);
            }
        });
        a30Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = 0;
                x = (int) spinner4.getValue();
                spinner4.setValue(x+1);
            }
        });
        a2zlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = 0;
                x = (int) spinner8.getValue();
                spinner8.setValue(x+1);
            }
        });
        a2zlButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = 0;
                x = (int) spinner7.getValue();
                spinner7.setValue(x+1);
            }
        });
        a5zlButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = 0;
                x = (int) spinner6.getValue();
                spinner6.setValue(x+1);
            }
        });
        a4zlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = 0;
                x = (int) spinner5.getValue();
                spinner5.setValue(x+1);
            }
        });
        a5zlButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = 0;
                x = (int) spinner9.getValue();
                spinner9.setValue(x+1);
            }
        });
        a4zlButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = 0;
                x = (int) spinner10.getValue();
                spinner10.setValue(x+1);
            }
        });
        a5zlButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = 0;
                x = (int) spinner11.getValue();
                spinner11.setValue(x+1);
            }
        });
        a2zlButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = 0;
                x = (int) spinner12.getValue();
                spinner12.setValue(x+1);
            }
        });
        payment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                payment pay = new payment();
                pay.setVisible(true);


            }
        });

        ;
    }


}

