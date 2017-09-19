package es.upm.miw.apaw.theme.api.entities;

import java.util.Calendar;

public class Theme {

    private int id;

    private String name;
    
    private Calendar date;

    public Theme() {
    }

    public Theme(String name) {
        this.name = name;
        this.date = Calendar.getInstance();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
		this.id = id;
	}

	public String getName() {
        return name;
    }

	public Calendar getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Theme [id=" + id + ", name=" + name + ", date=" + date + "]";
	}

}
