package AMD_Util;

public class RandomObject {

    private String objName;
    private Double objValue;
    private boolean objBoolean;
    private final Object objObj;
    private final float prob;

    /**
     * Creates a RandomObject with random epic Name, random decimal Value, random Boolean and a random Object
     * @param objName Any String, left blank for random name
     * @param objValue Any number type, set null for random number
     * @param objObj Any object wanted to give, set null for a chance to spawn another RandomObject
     * @param objProb Spawn rate of a new RandomObject [0 - 100] (Decreases over spawns)
     */

    public RandomObject(String objName, Double objValue, boolean objBoolean, Object objObj,float objProb){
        if(objName.isBlank())
            this.objName = setDefaultName();
        else this.objName = objName;

        if(objValue == null)
            this.objValue = setDefaultValue();
        else this.objValue = objValue;

        this.prob = objProb;

        if(objObj == null)
            this.objObj = setRandomObject();
        else this.objObj = objObj;

        this.objBoolean = objBoolean;

        if(objProb < 0)
            objProb *= -1;

        while (objProb > 100)
            objProb /= 10;
    }

    //SET DEFAULT VALUES
    private String setDefaultName(){
        String[] objects = {
                "Table of the King", "Chair of Eternal Rest", "Lamp of Guiding Light", "Spoon of Endless Feasts",
                "Fork of the Mighty Banquet", "Knife of the Shadow Assassin", "Plate of the Golden Feast", "Cup of Infinite Refreshment",
                "Bottle of Eternal Potions", "Book of Forbidden Knowledge", "Pencil of Arcane Inscriptions", "Pen of Destiny",
                "Eraser of Past Mistakes", "Notebook of Ancient Secrets", "Backpack of the Wanderer", "Clock of Time Manipulation",
                "Mirror of Lost Souls", "Glasses of True Vision", "Phone of Infinite Calls", "Keyboard of the Code Master",
                "Mouse of Lightning Reflexes", "Monitor of Celestial Visions", "Television of Forgotten Legends", "Remote of Control Over Fate",
                "Speaker of Thunderous Echoes", "Headphones of Sonic Bliss", "Microphone of the Voice of Gods", "Camera of Captured Souls",
                "Battery of Unlimited Power", "Charger of Revitalization", "Pillow of Dream Weaving", "Blanket of Eternal Warmth",
                "Bed of Restful Slumber", "Couch of Royal Comfort", "Curtain of Hidden Mysteries", "Carpet of Flying Journeys",
                "Door of Dimensional Portals", "Window of Foresight", "Shelf of Sacred Tomes", "Cabinet of Sealed Relics",
                "Refrigerator of Frozen Time", "Microwave of Instant Concoctions", "Toaster of Fiery Awakening", "Oven of the Fire Titan",
                "Blender of Alchemical Mixtures", "Fan of the Northern Winds", "Washing Machine of Purity", "Iron of Unbreakable Armor",
                "Broom of the Witch's Flight", "Mop of the Cleansing Ritual", "Trashcan of Forgotten Dreams", "Scissors of Fate",
                "Stapler of Unbreakable Bonds", "Tape of the Timeless Fix", "Ruler of Precise Judgement", "Calculator of Infinite Equations",
                "Envelope of Secret Messages", "Brush of the Master Painter", "Comb of Regal Elegance", "Toothbrush of Radiant Smiles",
                "Towel of Sacred Drying", "Soap of Absolute Purity", "Shampoo of Celestial Fragrance", "Conditioner of Mystic Smoothness",
                "Lotion of Eternal Beauty", "Deodorant of Divine Scent", "Razor of the Shadow Duelist", "Mirror of Parallel Realities",
                "Sunglasses of the Midnight Wanderer", "Hat of the Wise Sage", "Jacket of the Storm Rider", "Shirt of the Noble Warrior",
                "Pants of the Swift Nomad", "Shoes of the Speedster", "Socks of the Cloud Walker", "Gloves of the Silent Assassin",
                "Umbrella of the Sky Guardian", "Bag of Holding", "Wallet of Endless Wealth", "Keys of the Forgotten Temple",
                "Lighter of Eternal Flame", "Matchbox of the Phoenix", "Candle of Everlasting Light", "Flashlight of the Shadow Hunter",
                "Helmet of the Ancient Warrior", "Ball of the Cosmic Champion", "Bat of the Grand Slugger", "Racket of the Thunderstriker",
                "Skateboard of the Street Phantom", "Bicycle of the Wind Chaser", "Motorcycle of the Steel Knight", "Car of the Road King",
                "Truck of the Titan Carrier", "Bus of the Nomadic Tribe", "Train of Endless Journeys", "Airplane of the Sky Sovereign",
                "Boat of the Ocean Explorer", "Ship of the Storm Conqueror", "Submarine of the Abyss", "Rocket of the Starborn Pioneer"
        };

        return objects[RandomGenerator.genRandomInt(0,101)];
    }

    private Double setDefaultValue(){
        return RandomGenerator.genRandomDouble(-99999999,99999999);
    }

    private RandomObject setRandomObject(){
        if(prob < 0.5) //Evitar que el programa entre en un bucle infinito
            return null;
        float prob2 = RandomGenerator.genRandomFloat(0,100);
        return prob2 <= prob ? new RandomObject("",null,RandomGenerator.genRandomBoolean(),null,prob/2) : null;
        //Utiliza la probabilidad declarada para intentar generar un nuevo objeto random
        // Esta probabilidad se reduce a la mitad cada que se crea un nuevo objeto
    }

    public String toString(boolean printAll) {
        if(printAll)
        return String.format("Name: %s\nValue: %s\nState: %s\nObject object%s",
                objName, objValue, objBoolean, objObj == null ? ": Nope!" : String.format("\n---------\n[%.2f[\n%s]%.2f]\n-------------\n", prob, objObj, prob));
        else return String.format("Name: %s\nValue: %s\nState: %s\nObject object: %s",
                objName, objValue, objBoolean, objObj == null ? "Yes!" : "No!");
    }

    //SETTERS/////////////////
    public void setObjName(String objName) {
        this.objName = objName;
    }
    public void setObjValue(Double objValue) {this.objValue = objValue;}
    public void setObjBoolean(boolean objBoolean) {
        this.objBoolean = objBoolean;
    }
    //.//////////////////////

    //GETTERS////////////////
    public String getObjName() {
        return objName;
    }
    /// Cast return value to desired type
    public Number getObjValue() {
        return objValue;
    }
    public boolean isObjBoolean() {
        return objBoolean;
    }
    public Object getObjObj() {
        return objObj;
    }
    //.///////////////////////
}
