package main;

public class Bomb extends WarcraftDecorator{

    public Bomb(Warcraft warcraft) {
        super(warcraft);
        warcraft.addAddables(Addable.BOMB);
    }

    @Override
    public int getPoint() {
        return Addable.BOMB.getPoint() + warcraft.getPoint();
    }
}
