package TemperatureConverter.Command;


import TemperatureConverter.MVC.Model;

public class F2CCommand extends Command {
    private double fahrenheit;

    public F2CCommand(Model model, double f) {
        super(model);
        this.fahrenheit = f;
    }

    @Override
    public void execute() {
        model.f2c(fahrenheit);
    }

}
