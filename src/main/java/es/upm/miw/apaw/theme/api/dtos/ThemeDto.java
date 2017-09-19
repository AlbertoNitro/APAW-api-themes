package es.upm.miw.apaw.theme.api.dtos;

import es.upm.miw.apaw.theme.api.entities.Theme;

public class ThemeDto {
    private int id;

    private String name;

    public ThemeDto() {
    }

    public ThemeDto(int id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public ThemeDto(Theme theme) {
        this(theme.getId(), theme.getName());
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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + ",\"name\":\"" + name + "\"}";
    }

}
