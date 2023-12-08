package dao.model;

import jakarta.json.bind.annotation.JsonbPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonbPropertyOrder({"id", "name", "occupations", "state", "description", "image", "idMedia"})
public class Character {

    private int id;
    private String name;
    private List<String> occupations;
    private boolean state; //alive = true ; dead = false
    private String description;
    private String image;
    private int idMedia;
}
