public enum DishwasherProgramEnum {
    GLASSSES(10),
    PLATES(30),
    PANS(40),
    MIXED(20),
    ECO(60);
    public int programTime;

    DishwasherProgramEnum(int proTime){
        this.programTime = proTime; }

    public int getProgramTime(){return this.programTime; }
    }

