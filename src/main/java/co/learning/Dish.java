package co.learning;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Dish {
    private int id;
    private String name;
    private double price;
    private List<String> ingredients;
    private int prepTime;
    private DishType type;
    enum DishType{
        VEG, NONVEG,VEGAN
    }

}
