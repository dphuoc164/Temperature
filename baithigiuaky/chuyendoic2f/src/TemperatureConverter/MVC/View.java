package TemperatureConverter.MVC;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import TemperatureConverter.Observer.Subscriber;

public class View extends JFrame implements Subscriber {
    private String title;
    private JPanel jPanel;
    private JLabel jLabelCelsius, jLabelFahrenheit;
    private JTextField jTextCelsius, jTextFahrenheit;
    private JMenuBar menuBarRemote = null;
    private Controller controller;
    private Model model;

    public View() {
        this.model = new Model();
        controller = new Controller(this, model); // Sử dụng constructor của Controller với tham số là View và Model
        model.subscribe(this);
        buildMenu();
        build();
        add(jPanel);
        title = "CHUYỂN ĐỔI NHIỆT ĐỘ";
        setSize(400, 100);
        setTitle(title);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    

    public void build() {
        jPanel = new JPanel();
        jLabelCelsius = new JLabel("Celsius");
        jTextCelsius = new JTextField(10);
        jLabelFahrenheit = new JLabel("Fahrenheit");
        jTextFahrenheit = new JTextField(10);
        jTextCelsius.setText("");
        jTextFahrenheit.setText("");
        jPanel.add(jLabelCelsius);
        jPanel.add(jTextCelsius);
        jPanel.add(jLabelFahrenheit);
        jPanel.add(jTextFahrenheit);
    }

    public void buildMenu() {
        menuBarRemote = new JMenuBar();
        setJMenuBar(menuBarRemote);
        JMenu menu = new JMenu("Commands");
        menuBarRemote.add(menu);
        JMenuItem f2c = new JMenuItem("F2C");
        JMenuItem c2f = new JMenuItem("C2F");
        JMenuItem exit = new JMenuItem("Exit");
        f2c.addActionListener(controller);
        c2f.addActionListener(controller);
        exit.addActionListener(controller);
        menu.add(f2c);
        menu.add(c2f);
        menu.add(exit);
    }

    public JTextField getjTextCelsius() {
        return jTextCelsius;
    }

    public JTextField getjTextFahrenheit() {
        return jTextFahrenheit;
    }

    @Override
    public void updateFahrenheit() {
        double fahrenheit = model.getFahrenheit();
        jTextFahrenheit.setText(String.valueOf(fahrenheit)); //Hiển thị giá trị fahrenheit dạng String
    }

    @Override
    public void updateCelsius() {
        double celsius = model.getCelsius();
        jTextCelsius.setText(String.valueOf(Math.round(celsius))); //Hiển thị giá trị celsius dạng String
    }

}
