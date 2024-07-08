package TemperatureConverter.MVC;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import TemperatureConverter.Command.CommandProcessor;

public class Controller implements ActionListener {
    private View view;
    private CommandProcessor commandProcessor;

    public Controller(View view, CommandProcessor commandProcessor) {
        this.view = view;
        this.commandProcessor = commandProcessor;
    }

    public Controller(View view, Model model) {
        this.view = view;
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("F2C")) {
            // Xử lý chuyển đổi từ Fahrenheit sang Celsius
            double fahrenheit = Double.parseDouble(view.getjTextFahrenheit().getText());
            double celsius = (fahrenheit - 32) * 5 / 9;
            view.getjTextCelsius().setText(String.format("%.2f", celsius));
        } else if (command.equals("C2F")) {
            // Xử lý chuyển đổi từ Celsius sang Fahrenheit
            double celsius = Double.parseDouble(view.getjTextCelsius().getText());
            double fahrenheit = celsius * 9 / 5 + 32;
            view.getjTextFahrenheit().setText(String.format("%.2f", fahrenheit));
        } else if (command.equals("Exit")) {
            System.exit(0);
        }
    }


    
}
