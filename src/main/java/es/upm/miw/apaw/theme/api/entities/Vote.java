package es.upm.miw.apaw.theme.api.entities;

public class Vote {

    private int id;

    private int value;

    private Theme theme;

    public Vote() {
    }

    public Vote(int value, Theme theme) {
        this.value = value;
        this.theme = theme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Theme getTheme() {
        return theme;
    }

    @Override
    public String toString() {
        return "Vote [id=" + id + ", value=" + value + ", theme=" + theme + "]";
    }

}
