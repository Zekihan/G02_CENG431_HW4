package commands;

import utilities.GameReport;
import io.IDisplay;
import gameengine.IGameEngine;

public class RunSimulationCommand extends AbstractCommand{

    private IDisplay displayHandler;

    public RunSimulationCommand(IGameEngine gameEngine, IDisplay displayHandler) {
        super(gameEngine);
        this.displayHandler = displayHandler;
    }


    public String toString(){
        return "Run Simulation";
    }

    @Override
    public void execute() {
        //Run the simulation, get the end game report and display it.
        GameReport simulationResults = getGameEngine().runSimulation();
        displayHandler.displayGameReport(simulationResults.toString());
    }
}
