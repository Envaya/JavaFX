package ch.fhnw.oop2.module13.undoredo.presentationmodels;

public interface Command {

    public void undo();
    //execute is our redo function
    public void execute();
}
