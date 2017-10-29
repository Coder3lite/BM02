import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BurgerMachineProcess extends JFrame{

  private JPanel panelwest, panelcenter, paneleast;
  private JPanel panelup, paneldown, panel21;
  private JLabel label;
  private JTextField txtfield, txtgross, txttotal, txtchange, txtbill;
  private JTextField[] txtPrice = new JTextField[13];
  private JTextArea txtarea_result;
  private JButton btnok, btnclear;

  public BurgerMachineProcess(){

    super("Burger Machine");
    SecondaryProcess sp = new SecondaryProcess();

    panelup = new JPanel();
    panelup.setLayout(new FlowLayout());
    panelup.setBackground(Color.darkGray);

    paneldown = new JPanel();
    paneldown.setLayout(new GridLayout(1, 3, 5, 5));
    paneldown.setBackground(Color.RED);

    label = new JLabel("-=* BURGER MACHINE *=-");
    sp.headerLabel(panelup, label);

    panelwest = new JPanel();
    sp.onPanelDown(panelwest, paneldown);

    label = new JLabel("-=* BIG TIME *=-");
    sp.forJLabel(panelwest, label, 130, 0, 220, 30);

    txtfield = new JTextField("Beef Pizza Burger");
    sp.forTextField(panelwest, txtfield, 10, 75, 200, 30);

    txtfield = new JTextField(" P 59.00");
    sp.forTextField(panelwest, txtfield, 240, 75, 80, 30);

    txtPrice[0] = new JTextField();
    sp.forTextEntry(panelwest, txtPrice[0], 350, 75);

    txtfield = new JTextField("Bacon Cheeze Burger");
    sp.forTextField(panelwest, txtfield, 10, 150, 200, 30);

    txtfield = new JTextField(" P 61.00");
    sp.forTextField(panelwest, txtfield, 240, 150, 80, 30);

    txtPrice[1] = new JTextField();
    sp.forTextEntry(panelwest, txtPrice[1], 350, 150);

    txtfield = new JTextField("Black Pepper Burger");
    sp.forTextField(panelwest, txtfield, 10, 225, 200, 30);

    txtfield = new JTextField(" P 55.00");
    sp.forTextField(panelwest, txtfield, 240, 225, 80, 30);

    txtPrice[2] = new JTextField();
    sp.forTextEntry(panelwest, txtPrice[2], 350, 225);

    label = new JLabel("-=* SULIT *=-");
    sp.forJLabel(panelwest, label, 150, 300, 220, 30);

    txtfield = new JTextField("Regular Burger");
    sp.forTextField(panelwest, txtfield, 10, 375, 200, 30);

    txtfield = new JTextField(" P 28.00");
    sp.forTextField(panelwest, txtfield, 240, 375, 80, 30);

    txtPrice[3] = new JTextField();
    sp.forTextEntry(panelwest, txtPrice[3], 350, 375);

    txtfield = new JTextField("Cheeze Burger");
    sp.forTextField(panelwest, txtfield, 10, 450, 200, 30);

    txtfield = new JTextField(" P 38.00");
    sp.forTextField(panelwest, txtfield, 240, 450, 80, 30);

    txtPrice[4] = new JTextField();
    sp.forTextEntry(panelwest, txtPrice[4], 350, 450);

    txtfield = new JTextField("Double Regular Burger");
    sp.forTextField(panelwest, txtfield, 10, 525, 200, 30);

    txtfield = new JTextField(" P 40.00");
    sp.forTextField(panelwest, txtfield, 240, 525, 80, 30);

    txtPrice[5] = new JTextField();
    sp.forTextEntry(panelwest, txtPrice[5], 350, 525);

    panelcenter = new JPanel();
    sp.onPanelDown(panelcenter, paneldown);

    label = new JLabel("-=* CHICKEN TIME *=-");
    sp.forJLabel(panelcenter, label, 90, 0, 280, 30);

    txtfield = new JTextField("Chicken Time Burger");
    sp.forTextField(panelcenter, txtfield, 10, 75, 200, 30);

    txtfield = new JTextField(" P 32.00");
    sp.forTextField(panelcenter, txtfield, 240, 75, 80, 30);

    txtPrice[6] = new JTextField();
    sp.forTextEntry(panelcenter, txtPrice[6], 350, 75);

    txtfield = new JTextField("Chicken CheezeBurger");
    sp.forTextField(panelcenter, txtfield, 10, 150, 200, 30);

    txtfield = new JTextField(" P 42.00");
    sp.forTextField(panelcenter, txtfield, 240, 150, 80, 30);

    txtPrice[7] = new JTextField();
    sp.forTextEntry(panelcenter, txtPrice[7], 350, 150);

    txtfield = new JTextField("Double Chicken Burger");
    sp.forTextField(panelcenter, txtfield, 10, 225, 200, 30);

    txtfield = new JTextField(" P 44.00");
    sp.forTextField(panelcenter, txtfield, 240, 225, 80, 30);

    txtPrice[8] = new JTextField();
    sp.forTextEntry(panelcenter, txtPrice[8], 350, 225);

    label = new JLabel("-=* HOT DOGS *=-");
    sp.forJLabel(panelcenter, label, 115, 300, 220, 30);

    txtfield = new JTextField("Cheezy Dog");
    sp.forTextField(panelcenter, txtfield, 10, 375, 200, 30);

    txtfield = new JTextField(" P 33.00");
    sp.forTextField(panelcenter, txtfield, 240, 375, 80, 30);

    txtPrice[9] = new JTextField();
    sp.forTextEntry(panelcenter, txtPrice[9], 350, 375);

    txtfield = new JTextField("Bacon Cheezy Frank");
    sp.forTextField(panelcenter, txtfield, 10, 450, 200, 30);

    txtfield = new JTextField(" P 56.00");
    sp.forTextField(panelcenter, txtfield, 240, 450, 80, 30);

    txtPrice[10] = new JTextField();
    sp.forTextEntry(panelcenter, txtPrice[10], 350, 450);

    txtfield = new JTextField("New York Hotdog");
    sp.forTextField(panelcenter, txtfield, 10, 525, 200, 30);

    txtfield = new JTextField(" P 44.00");
    sp.forTextField(panelcenter, txtfield, 240, 525, 80, 30);

    txtPrice[11] = new JTextField();
    sp.forTextEntry(panelcenter, txtPrice[11], 350, 525);

    txtfield = new JTextField("Drinks");
    sp.forTextField(panelcenter, txtfield, 10, 595, 200, 30);

    txtfield = new JTextField(" P 14.00");
    sp.forTextField(panelcenter, txtfield, 240, 595, 80, 30);

    txtPrice[12] = new JTextField();
    sp.forTextEntry(panelcenter, txtPrice[12], 350, 595);

    paneleast = new JPanel();
    sp.onPanelDown(paneleast, paneldown);

    label = new JLabel("-=* I N F O R M A T I O N *=-", JLabel.CENTER);
    sp.forJLabel(paneleast, label, 0, 0, 480, 30);

    Date date = new Date();
    SimpleDateFormat simpleDate = new SimpleDateFormat("E MMMM dd, yyyy");

    label = new JLabel(String.format("%45s", simpleDate.format(date)));
    sp.forDateFormat(paneleast, label);

    txtarea_result = new JTextArea(String.format("%s\n", "PRODUCT         PRICE QTY  AMOUNT"));
    sp.forTextArea(paneleast, txtarea_result);

    txtfield = new JTextField("Change  =");
    sp.forTextField(paneleast, txtfield, 220, 510, 100, 30);

    txtchange = new JTextField();
    sp.forTextField(paneleast, txtchange, 330, 510, 100, 30);

    txtfield = new JTextField("Bill  =");
    sp.forTextField(paneleast, txtfield, 30, 510, 70, 30);

    txtbill = new JTextField();
    sp.forTextEntry(paneleast, txtbill, 110, 510);

    txtfield = new JTextField("Total   = ");
    sp.forTextField(paneleast, txtfield, 220, 550, 100, 30);

    txttotal = new JTextField();
    sp.forTextField(paneleast, txttotal, 330, 550, 100, 30);

    txtfield = new JTextField("Gross  =");
    sp.forTextField(paneleast, txtfield, 220, 590, 100, 30);

    txtgross = new JTextField("0.0");
    sp.forTextField(paneleast, txtgross, 330, 590, 100, 30);

    btnok = new JButton("OK");
    sp.forButton(paneleast, btnok, 30, 550);

    btnclear = new JButton("CLEAR");
    sp.forButton(paneleast, btnclear, 30, 590);

    sp.setTField(txtPrice);
    sp.setTotal(txttotal);
    sp.setTextArea(txtarea_result);
    sp.setButtons(btnclear, btnok);
    sp.setBillAndChange(txtbill, txtchange);
    sp.setGross(txtgross);
    sp.processComputation();

    add(panelup, BorderLayout.NORTH);
    add(paneldown, BorderLayout.CENTER);
  }
}
