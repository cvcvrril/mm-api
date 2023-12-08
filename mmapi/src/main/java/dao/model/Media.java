package dao.model;


import jakarta.json.bind.annotation.JsonbPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonbPropertyOrder({"id", "name", "type", "description", "year"})
public class Media {

    private int id;
    private String name;
    private String type;
    private String description;
    private int year;
}
