public class Container {
    private final String id;
    private final String shortName;

    private final String longName;

    Container(String id, String sN, String lN){
        this.id = id;
        this.shortName = sN;
        this.longName = lN;
    }

    public String getId() {
        return id;
    }

    public String getShortName() {
        return shortName;
    }


    public String getLongName() {
        return longName;
    }


}
