package main;

public class ResetCommand extends AbstractCommand{

    public ResetCommand(IGameEngine gameEngine) {
        super(gameEngine);
    }

    @Override
    public void execute() {
        getGameEngine().resetItems();
    }
}
