public class Rock {
    private int[][] locations;
    private int type;

    public Rock() {
    }

    public Rock(int[][] locations, int type) {
        this.locations = locations;
        this.type = type;
    }

    public int[][] getLocations() {
        return this.locations;
    }

    public void setLocations(int[][] locations) {
        this.locations = locations;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Rock locations(int[][] locations) {
        setLocations(locations);
        return this;
    }

    public Rock type(int type) {
        setType(type);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " locations='" + getLocations() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }
}
