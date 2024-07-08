package TemperatureConverter.Command;

import TemperatureConverter.MVC.Model;

public class C2FCommand extends Command {
    private double celsius;

    public C2FCommand(Model model, double c) {
        super(model);
        this.celsius = c;
    }

    @Override
    public void execute() {
        model.c2f(celsius);
    }

}

