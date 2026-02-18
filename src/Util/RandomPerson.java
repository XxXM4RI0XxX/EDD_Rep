package Util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RandomPerson {

    private final String name;
    private final String surnames;
    private final int age;
    private final float salary;
    private final Boolean sickness;
    private final Object item;
    private final RandomPerson child;
    private int prob = 0;

    /**
     * Creates a RandomPerson with random set attributes
     * @param name Any name (left blank for epic name)
     * @param surname Any surnames (left blank for epic surnames)
     * @param age Between 0 and 150 (set -1 for random)
     * @param salary Any decimal value (set -1 for random)
     * @param sickness Is the person sick? (set null for random)
     * @param item All person has a unique item (set null to give it a random one)
     * @param prob Random prob of the user has child. Value between 0 and 100 (age is a limit factor to generate children)
     * */

    public RandomPerson (String name, String surname, int age, float salary,
                         Boolean sickness, Object item, int prob) {
        if (name.isBlank())
            this.name = namesList[RandomGenerator.genRandomInt(0,100)];
        else this.name = name;

        if (surname.isBlank())
            this.surnames = surnamesList[RandomGenerator.genRandomInt(0,100)];
        else this.surnames = surname;

        if(age<0 || age > 150)
            this.age = defaultAge();
        else this.age = age;

        if(salary<0)
            this.salary = defaultSalary();
        else this.salary = salary;

        if(sickness==null)
            this.sickness = defaultSickness();
        else this.sickness = sickness;

        if(item==null)
            this.item = defaultItem();
        else this.item = item;

        if(prob > 100)
            prob = 100;
        else if(prob < 0)
            prob = 0;
        else this.prob = prob;

        this.child = defaultChildren();

    }

    //SET DEFAULT VALUES///////////////////////////////
    private final String[] namesList = {
            "John", "Emily", "Michael", "Sarah", "David", "Jessica", "Daniel", "Ashley", "James", "Amanda",
            "Robert", "Jennifer", "William", "Elizabeth", "Joseph", "Linda", "Charles", "Barbara", "Thomas", "Susan",
            "Christopher", "Margaret", "Matthew", "Karen", "Anthony", "Nancy", "Mark", "Lisa", "Donald", "Betty",
            "Steven", "Dorothy", "Paul", "Sandra", "Andrew", "Kimberly", "Joshua", "Donna", "Kevin", "Carol",
            "Brian", "Michelle", "George", "Emily", "Edward", "Helen", "Ronald", "Deborah", "Timothy", "Laura",
            "Jason", "Cynthia", "Jeffrey", "Kathleen", "Ryan", "Amy", "Jacob", "Shirley", "Gary", "Angela",
            "Nicholas", "Melissa", "Eric", "Brenda", "Stephen", "Pamela", "Jonathan", "Emma", "Larry", "Katherine",
            "Justin", "Nicole", "Scott", "Christine", "Brandon", "Marie", "Benjamin", "Janet", "Samuel", "Catherine",
            "Gregory", "Frances", "Frank", "Ann", "Raymond", "Diana", "Patrick", "Alice", "Jack", "Julie",
            "Dennis", "Heather", "Jerry", "Teresa", "Tyler", "Gloria", "Aaron", "Doris", "Jose", "Rose"
    };

    private final String[] surnamesList = {
            "the Flamebearer", "of the Starlit Forest", "the Iron Sentinel", "the Whispering Wind",
            "Slayer of Shadows", "of the Silver Moon", "the Rune Keeper", "Guardian of Light",
            "the Dragonheart", "of the Crystal Peaks", "the Stormforged", "Voice of the Ancients",
            "the Undaunted", "Enchantress of Time", "the Wandering Sage", "of the Frozen Vale",
            "the Flame Wielder", "Queen of Thorns", "the Eternal Watcher", "of the Emerald Glade",
            "the Void Walker", "Priestess of Dawn", "the Thunderblade", "of the Deep Waters",
            "the Starborn", "Mistress of Mirrors", "the Ironclad Knight", "Oracle of the Sun",
            "the Iceforged", "of the Sacred Grove", "the Shadow Dancer", "Keeper of Whispers",
            "the Celestial Herald", "of the Ashen Fields", "the Spellbound", "Archer of the Skies",
            "the Flame Reaver", "Spirit of the Wild", "the Moonhowler", "of the Hidden Flame",
            "the Time Jumper", "Blade of Harmony", "the Worldshaper", "Soul of the North",
            "the Firecaller", "of the Endless Sands", "the Lightbringer", "Mistress of Storms",
            "the Night Seeker", "of the Sapphire Isles", "the Unseen Blade", "Healer of Legends",
            "the Mountain Watcher", "of the Whispering Stones", "the Rune Warrior", "Serpent of Silence",
            "the Thunderfist", "of the Lunar Veil", "the Beast Tamer", "Sentinel of Stars",
            "the Frost Warden", "Herald of Dreams", "the Earthshaker", "Keeper of Flame",
            "the Arcane Trickster", "of the Shadowed Glade", "the Truthbearer", "Fire of Hope",
            "the Nightcaller", "of the Fading Light", "the Windsworn", "Blade of Serenity",
            "the Echo Mage", "of the Forgotten Realms", "the Rift Walker", "Chanter of Peace",
            "the Radiant Knight", "Lady of Frost", "the Embermind", "Stormtouched",
            "the Wanderer King", "Light of the Hills", "the Voidshaper", "of the Crimson Sky",
            "the Battle-Singer", "Shield of Aeons", "the Ironborn", "of the Starfall Fields",
            "the Last Sentinel", "Whisperer of Flames", "the Bloodthorn", "Dreamer of the Isles",
            "the Cliff Guardian", "of the Ancient Flame", "the Skyforged", "Weaver of Songs",
            "the Mooncaller", "of the Mirror Lake", "the Duskblade", "Queen of the Deep"
    };

    private int defaultAge(){
        return RandomGenerator.genRandomInt(0,151);
    }

    private @NotNull Float defaultSalary(){
        return RandomGenerator.genRandomFloat(0,1000000.0000f);
    }

    private @NotNull Boolean defaultSickness(){
        return RandomGenerator.genRandomBoolean();
    }

    @Contract(" -> new")
    private @NotNull RandomObject defaultItem(){
        return RandomGenerator.genRandomObject(0);
    }

    private @Nullable RandomPerson defaultChildren(){
        if(age > 15 && prob > RandomGenerator.genRandomInt(0,101))
            return new RandomPerson("","",-1,-1,null,null,this.prob/2);
        else return null;
    }

    @Override
    public String toString() {
        return String.format("""
                Name: %s %s
                Age: %d
                Salary: %.2f
                Sickness: %b
                Item: %s
                Children: %s""",
                this.name, this.surnames, this.age, this.salary,
                this.sickness, this.item,
                child != null ? child.getFullName() : null);
    }

    //GETTERS/////////////////////////
    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surnames;
    }

    public String getFullName(){
        return String.format("%s %s", name, surnames);
    }

    public int getAge() {
        return age;
    }

    public float getSalary() {
        return salary;
    }

    public Boolean getSickness() {
        return sickness;
    }

    public Object getItem() {
        return item;
    }

    public RandomPerson getChild() {
        return child;
    }
}
