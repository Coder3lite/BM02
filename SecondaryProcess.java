import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SecondaryProcess{

  private JTextField[] tfield = new JTextField[13];
  private JTextField total;
  private double[] price = {59.0, 61.0, 55.0, 28.0, 38.0, 40.0, 32.0, 42.0, 44.0, 33.0, 56.0, 44.0, 14.0};
  private String[] info = {"Beef Pizza", "Bacon Cheeze", "Black Pepper", "Regular Burger","Cheeze Burger", "Double Burger",
                           "Chicken Time", "Chicken Cheeze", "Double Chicken", "Cheezy Dog", "B Cheeze Franks", "New York Hotdog", "Drinks"};
  private JTextArea tArea;
  private JButton btnClear, btnOk;
  private JTextField tGross;
  private JTextField txtBill, txtChange;

  double grs = 0.0;

  public void headerLabel(JPanel pn, JLabel lb){
    lb.setFont(new Font("Serif", Font.BOLD, 40));
    lb.setForeground(Color.red);
    pn.add(lb);
  }

  public void onPanelDown(JPanel jp, JPanel pd){
    jp.setLayout(null);
    jp.setBackground(Color.darkGray);
    pd.add(jp);
  }

  public void forTextField(JPanel pn, JTextField tf, int x, int y, int w, int h){
    tf.setBounds(x, y, w, h);
    tf.setBackground(Color.gray);
    tf.setForeground(Color.black);
    tf.setFont(new Font("Serif", Font.BOLD, 20));
    tf.setEditable(false);
    pn.add(tf);
  }

  public void forTextEntry(JPanel pn, JTextField tf, int x, int y){
    tf.setBounds(x, y, 80, 30);
    tf.setBackground(Color.green);
    tf.setForeground(Color.black);
    tf.setFont(new Font("Serif", Font.BOLD, 20));
    pn.add(tf);
  }

  public void forJLabel(JPanel pn, JLabel lb, int x, int y, int w, int h){
    lb.setBounds(x, y, w, h);
    lb.setFont(new Font("Serif", Font.BOLD, 25));
    lb.setForeground(Color.yellow);
    pn.add(lb);
  }

  public void forDateFormat(JPanel pn, JLabel lb){
    lb.setBounds(20, 35, 400, 25);
    lb.setFont(new Font("Serif", Font.BOLD, 20));
    lb.setForeground(Color.red);
    pn.add(lb);
  }

  public void forButton(JPanel pn, JButton bt, int x, int y){
    bt.setBounds(x, y, 150, 35);
    bt.setForeground(Color.black);
    bt.setFont(new Font("Serif", Font.BOLD, 30));
    pn.add(bt);
  }

  public void forTextArea(JPanel pn, JTextArea jta){
    jta.setBounds(10, 75, 430, 405);
    jta.setFont(new Font("Miriam Fixed", Font.BOLD, 20));
    jta.setForeground(Color.black);
    jta.setBackground(Color.gray);
    pn.add(jta);
  }

  public void setTField(JTextField[] tf){
    tfield = tf;
  }

  public void setTotal(JTextField tl){
    total = tl;
  }

  public void setTextArea(JTextArea ta){
    tArea = ta;
  }

  public void setButtons(JButton bclear, JButton bok){
    btnClear = bclear;
    btnOk = bok;
  }

  public void setGross(JTextField tg){
    tGross = tg;
  }

  public void setBillAndChange(JTextField tbill, JTextField tchange){
    txtBill = tbill;
    txtChange = tchange;
  }

  public void processComputation(){

    ComputePrice cp = new ComputePrice();
    for(int x = 0; x < tfield.length; x++) tfield[x].addKeyListener(cp);

    ClearAll ca = new ClearAll();
    btnClear.addActionListener(ca);

    AddToGross atg = new AddToGross();
    btnOk.addActionListener(atg);

    ComputeBillAndChange cbac = new ComputeBillAndChange();
    txtBill.addKeyListener(cbac);
  }

  private class ComputeBillAndChange implements KeyListener{
    public void keyPressed(KeyEvent e){}

    public void keyReleased(KeyEvent e){
      double ttl = (total.getText().length() == 0) ? 0.0 : Double.parseDouble(total.getText());
      double bill = 0.0;
      try{
        bill = Double.parseDouble(txtBill.getText());
      } catch(Exception exc) {
        JOptionPane.showMessageDialog(null, "Please enter a number", "Error Message", JOptionPane.ERROR_MESSAGE);
      }
      double change = bill - ttl;
      txtChange.setText(String.format("%.2f", change));
    }

    public void keyTyped(KeyEvent e){}
  }

  private class AddToGross implements ActionListener{
    public void actionPerformed(ActionEvent e){
      String s = tArea.getText();
      double bill;
      Date dateNow = new Date();
      SimpleDateFormat simpleDate = new SimpleDateFormat("MM/dd/yyyy");
      SimpleDateFormat simpleTime = new SimpleDateFormat("hh:mm a");
      try{
        grs = (total.getText().length() == 0) ? Double.parseDouble(tGross.getText()) : grs + Double.parseDouble(total.getText());
        for(int x = 0; x < tfield.length; x++) tfield[x].setText("");
        bill = Double.parseDouble(txtBill.getText());
        s = String.format("%s\n\n%-5s %-5s %8s %7.2f\n%-5s %-5s %10s %7s\n%25s %7s", s,"DATE", simpleDate.format(dateNow), "BILL", bill, "TIME", simpleTime.format(dateNow), "TOTAL", total.getText(), "CHANGE", txtChange.getText());
      } catch(Exception x){
        grs = Double.parseDouble(tGross.getText());
        s = String.format("%s", "PRODUCT         PRICE QTY  AMOUNT");
        JOptionPane.showMessageDialog(null, "Please enter the bill!", "Error Message", JOptionPane.ERROR_MESSAGE);
      }
      tArea.setText(String.format("%s", s));
      tGross.setText(String.format("%.2f", grs));
      total.setText("");
      txtBill.setText("");
      txtChange.setText("");
    }
  }

  private class ClearAll implements ActionListener{
    public void actionPerformed(ActionEvent e){
      for(int x = 0; x < tfield.length; x++) tfield[x].setText("");
      total.setText("");
      tArea.setText(String.format("%s\n", "PRODUCT         PRICE QTY  AMOUNT"));
      txtBill.setText("");
      txtChange.setText("");
    }
  }

  private class ComputePrice implements KeyListener{
    public void keyPressed(KeyEvent e){}

    public void keyReleased(KeyEvent e){
      double ttl = 0.0;
      int num = 0;
      String sTotal = "";
      String s = String.format("%s\n", "PRODUCT         PRICE QTY  AMOUNT");
      tArea.setText(s);
      for(int x = 0; x < 13; x++){
        try{
          num = (tfield[x].getText().length() == 0) ? 0 : Integer.parseInt(tfield[x].getText());
          if(tfield[x].getText().length() != 0) s =  String.format("%s \n%-15s %-5.2f %3d %7.2f", s, info[x], price[x], num, ((double)num * price[x]));
        } catch (Exception xs) {
          JOptionPane.showMessageDialog(null, "Please enter a number", "Error Message", JOptionPane.ERROR_MESSAGE);
        }
        ttl = ttl + (num * price[x]);
        sTotal = String.format("%.2f", ttl);
        tArea.setText(s);
      }
      total.setText(sTotal);
    }
    public void keyTyped(KeyEvent e){}
  }
}
