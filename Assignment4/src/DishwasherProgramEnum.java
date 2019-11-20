public enum DishwasherProgramEnum {
    GLASSSES(45),
    PLATES(60),
    PANS(90),
    MIXED(75),
    ECO(120);
    public int programTime;

    DishwasherProgramEnum(int proTime){
        this.programTime = proTime; }

        public int getProgramTime(){return this.programTime; }
    }

