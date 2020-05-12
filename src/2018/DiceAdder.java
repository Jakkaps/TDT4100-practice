public class DiceAdder {
    private Dice dice1;
    private Dice dice2;

    public DiceAdder(Dice dice1, Dice dice2) {
        this.dice1 = dice1;
        this.dice2 = dice2;
    }

    public int getDieValue(int dieNum) {
        if (dieNum >= dice1.getDieCount()){
            return dice2.getDieValue(dieNum - dice1.getDieCount()); // Assume dieValue is a legal argument (not too big)
        }

        return dice1.getDieValue(dieNum);
    }

    public int getValueCount(int value) {
        return dice1.getValueCount(value) + dice2.getValueCount(value);
    }

    public boolean contains(Dice dice){
        return dice1.contains(dice) || dice2.contains(dice);
    }

   /* public Dice add(Dice dice){
        return new DiceAdder(this, dice);
    }*/

 /*   public Dice remove(Dice dice){
        return new DiceAdder(dice1.remove(dice), dice2.remove(dice));
    }*/
}
