public class Total extends automat {


    public String rachunek() {

        textArea12.setText("^^^^^RACHUNEK^^^^^\n"
                + "CZAS:" + JLabelczas.getText() + "DATA:" + Jlabeldata.getText() + "\n" + "^^^^^RACHUNEK^^^^^\n" + " nazwa przedmiotu:\t\t\t" + "Cena(zl)\n");
        return String.valueOf(textfield1);
    }

    public void obliczenia() {
        int qty = Integer.parseInt(spinner1.getValue().toString());
        if (qtyiszero(qty) && checkBox1.isSelected()) {
            x++;
            if (x == 1) {
                new Total();
            }
            double cena;
            cena = qty * 5.0;
            total += cena;
            textArea12.setText(textArea12.getText() + x + ". " + JLabelpepsi.getText() + "\t\t" + cena);
            oplata();
        } else {
            checkBox1.setSelected(false);
        }

        {
            qty = Integer.parseInt(spinner2.getValue().toString());
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
    }
}



