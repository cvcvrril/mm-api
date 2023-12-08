package dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Character {

    private int id;
    private String name;
    private List<String> ocupations;
    private boolean state; //alive = true ; dead = false
    private String description;
    private String image;
    private int idMedia;
}
