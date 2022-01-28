package Strategy_Pattern;

//----------------------------------------------
interface WeaponBehavior {
    void useWeapon();
}

class SwordBehavior implements WeaponBehavior {
    public void useWeapon() {
        System.out.println("Sword");
    }
}

class BowAndArrowBehavior implements WeaponBehavior {
    public void useWeapon() {
        System.out.println("BowAndArrow");
    }
}

class KnifeBehavior implements WeaponBehavior {
    public void useWeapon() {
        System.out.println("Knife");
    }
}

class AxeBehavior implements WeaponBehavior {
    public void useWeapon() {
        System.out.println("Axe");
    }
}

// ----------------------------------------------

abstract class Character {
    WeaponBehavior weaponBehavior;

    static int numberCharacter = 0;

    public Character() {
        Character.numberCharacter++;
    }

    void setWeapon(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }

    public abstract void fight();
}

class King extends Character {
    public King() {
        this.weaponBehavior = new SwordBehavior();
    }

    public void fight() {
        System.out.println("I'm King");
        this.weaponBehavior.useWeapon();
    }
}

class Queen extends Character {
    public Queen() {
        this.weaponBehavior = new AxeBehavior();
    }

    public void fight() {
        System.out.println("I'm Queen");
        this.weaponBehavior.useWeapon();
    }
}

class Knight extends Character {
    public Knight() {
        this.weaponBehavior = new BowAndArrowBehavior();
    }

    public void fight() {
        System.out.println("I'm Knight");
        this.weaponBehavior.useWeapon();
    }
}

// ----------------------------------------------

public class Strategy2 {
    public static void main(String[] args) {
        Character[] character = new Character[9];

        for (int i = 0; i < 3; ++i) {
            character[i] = new King();
            character[i + 3] = new Queen();
            character[i + 6] = new Knight();
        }

        for (int i = 0; i < 9; ++i) {
            character[i].fight();
        }
    }
}
