package TemperatureConverter.Command;
import TemperatureConverter.MVC.Model;

public abstract class Command {
    protected Model model;

    public Command(Model model) {
        this.model = model;
    }

    public abstract void execute();
}
