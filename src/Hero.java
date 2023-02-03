public class Hero {
    private String name;
    private int hitPoints;

    public Hero(String name) {
        this.name = name;
        hitPoints = 100;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() { return hitPoints; }

    public String toString() {
        return "Hero{name='" + name + "', hitPoints=" + hitPoints + "}";
    }

    public void attack(Hero opponent) {
        double n = Math.random();
        if(n >= 0.5){
            hitPoints = hitPoints - 10;
        }
        if(n < 0.5){
            opponent.hitPoints = hitPoints - 10;
        }
    }

    public void senzuBean() {
        hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent) {
        while(hitPoints>0 && opponent.getHitPoints()>0){
            attack(opponent);
        }
    }

    public String fightUntilTheDeath(Hero opponent) {
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return name + ":" + hitPoints + opponent.getName() + ":" + opponent.getHitPoints();
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n) throws ArrayIndexOutOfBoundsException{
        int[] win = new int[2];
        win[0] = 0;
        win[1] = 0;

        while(n > 0){
            fightUntilTheDeathHelper(opponent);
            if(hitPoints == 0){
                win[0] = win[0] + 1;
            }
            if(opponent.getHitPoints() == 0){
                win[1] = win[1] + 1;
            }
            n--;
        }
        return win;
    }

    public String nFightsToTheDeath(Hero opponent, int n){
        int[] win = nFightsToTheDeathHelper(opponent, n);
        if(win[0]>win[1]){
            return name + ":" + win[1] + "wins" + "\n" + opponent.getName() + ":" + win[0] + "wins" + "\n" + opponent.getName() + "wins!";
        }
        if(win[1]>win[0]){
            return name + ":" + win[1] + "wins" + "\n" + opponent.getName() + ":" + win[0] + "wins" + "\n" + name + "wins!";
        }
        else{
            return name + ":" + win[1] + "wins" + "\n" + opponent.getName() + ":" + win[0] + "wins" + "\n" + "OMG! It was actually a draw!";
        }
    }
}

