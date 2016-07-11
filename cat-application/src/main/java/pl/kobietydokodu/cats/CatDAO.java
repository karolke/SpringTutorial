package pl.kobietydokodu.cats;
import pl.kobietydokodu.cats.domain.Cat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karolke on 11.07.2016.
 */
 class CatDAO {
    List<Cat> cats;
    CatDAO(){
        cats = new ArrayList<Cat>();
    }

    void add(Cat cat){
        cats.add(cat);

    }
}
