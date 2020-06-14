package commands;

import exceptions.IllegalWarcraftTypeException;
import main.*;

import java.util.List;

public class AddPartCommand extends AbstractCommand {

    private List<Warcraft> warcrafts;
    private IDisplay displayHandler;
    private Input inputHandler;
    private String menuItems;
    private int playerNo;

    public AddPartCommand(IGameEngine gameEngine, List<Warcraft> warcrafts, IDisplay displayHandler, Input inputHandler, int playerNo) {
        super(gameEngine);
        this.warcrafts = getGameEngine().getPlayerLoadout(playerNo);
        this.inputHandler = inputHandler;
        this.displayHandler = displayHandler;
        this.playerNo = playerNo;
        initiateMenuText();
    }


    private void initiateMenuText(){
        StringBuilder warcrafts = new StringBuilder();
        int menuItemIndex = 1;
        for(Warcraft w : this.warcrafts){
            warcrafts.append(menuItemIndex + ". " + w.toString() + "\n");
            menuItemIndex++;
        }
        menuItems = warcrafts.toString();
    }


    public String toString(){ return "Add part"; }

    @Override
    public void execute() {
        initiateMenuText();
        displayHandler.displayMenu(menuItems, "Choose a warcraft: ");
        int id = inputHandler.readInt();

        Warcraft selectedWarcraft = warcrafts.get(id-1);
        System.out.println("selected warcraft : " + selectedWarcraft.getType());
        int partId;
        Addable partToAdd;

        if(selectedWarcraft.getClass() == Ship.class){
            menuItems = "1. Rocket\n" +
                        "2. Torpedo\n" +
                        "3. Cannon";

            displayHandler.displayMenu(menuItems, "Choose a part to add: ");
            partId = inputHandler.readInt();
            switch (partId){
                case 1:
                    partToAdd = Addable.ROCKET;
                    break;

                case 2:
                    partToAdd = Addable.TORPEDO;
                    break;

                case 3:
                    partToAdd = Addable.CANNON;
                    break;

                default:
                    //TODO
                    partToAdd = Addable.ROCKET;
                    break;
            }


        }else if(selectedWarcraft.getClass() == Plane.class ||
                selectedWarcraft.getType() instanceof PlaneType){

            menuItems = "1. Rocket\n" +
                        "2. Missile\n" +
                        "3. Machine gun\n" +
                        "4. Bomb";

            displayHandler.displayMenu(menuItems, "Choose a part to add: ");
            partId = inputHandler.readInt();

            switch (partId){
                case 1:
                    partToAdd = Addable.ROCKET;
                    break;

                case 2:
                    partToAdd = Addable.MISSILE;
                    break;

                case 3:
                    partToAdd = Addable.MACHINE_GUN;
                    break;

                case 4:
                    partToAdd = Addable.BOMB;
                    break;

                default:
                    //TODO
                    partToAdd = Addable.ROCKET;
                    break;
            }

        }else{
            return;
        }

        try {
            getGameEngine().addPart(playerNo, id-1, partToAdd);
        } catch (IllegalWarcraftTypeException e) {
            e.printStackTrace();
        }
    }
}