package gsf.springframework.Controllers;

import gsf.springframework.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }


    @RequestMapping({"vetIndex"})
    public String vetIndex()
    {
        return "vets/vetIndex";
    }


    @RequestMapping({"vetList"})
    public String vetList(Model model)
    {
        model.addAttribute("vet",vetService.findAll());

        return "vets/vetList";
    }
}
