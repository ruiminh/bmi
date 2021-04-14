package business.entities;

public class Sport {
    private int sport_id;
    private int name;

    public Sport(int sport_id, int name) {
        this.sport_id = sport_id;
        this.name = name;
    }

    public int getSport_id() {
        return sport_id;
    }

    public int getName() {
        return name;
    }
}
