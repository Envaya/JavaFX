package ch.fhnw.oop2.module13.undoredo.presentationmodels;

public class NameCommand implements Command {
    private CountryPM country;
    private String oldName;
    private String newName;

    public NameCommand(CountryPM country, String oldName, String newName) {
        this.country = country;
        this.oldName = oldName;
        this.newName = newName;
    }

    @Override
    public void undo() {
        country.setName(oldName);
    }

    @Override
    public void execute() {
        country.setName(newName);
    }
}
