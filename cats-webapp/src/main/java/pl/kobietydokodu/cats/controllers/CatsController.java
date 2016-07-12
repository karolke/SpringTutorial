package pl.kobietydokodu.cats.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kobietydokodu.cats.CatDAO;

/**
 * Created by Karolke on 11.07.2016.
 */
@Controller
public class CatsController {

    @Autowired
    private CatDAO catDAO;

    @RequestMapping("/")
    public String metoda(Model model){
        return "main";
    }
    @RequestMapping("/kot/{imie}")
    public String szczegolyKota(@PathVariable("imie") String imieKota) {
        return "main";
    }

    @RequestMapping("/lista")
    public String listaKotow(Model model) {
        //model.addAttribute("koty", catDAO.getKoty());
        return "lista";
    }
    @RequestMapping("/dodaj")
    public String dodajKota(Model model) {
        return "dodaj";
    }

    @RequestMapping("/kot-{id}")
    public String szczegolyKota(@PathVariable("id") Integer id, Model model) {
        //model.addAttribute("kot", dao.getKotById(id));
        return "szczegoly";
    }
}
