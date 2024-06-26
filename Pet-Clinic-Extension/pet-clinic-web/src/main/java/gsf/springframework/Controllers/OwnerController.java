package gsf.springframework.Controllers;

import gsf.springframework.services.OwnerService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/owners"})
@Controller
public class OwnerController {


    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/index"})
    public String OwnerIndex() {
        return "owner/ownerIndex";
    }

    @RequestMapping({"/list"})
    public String listOwners(Model model)
    {
        model.addAttribute("owners",ownerService.findAll()); // sending attribute to the frontend

        return "owner/listOwners";
    }

    @RequestMapping({"/find"})
    public String findOwnerById(Model model) {

        return "notImplemented";
    }
}