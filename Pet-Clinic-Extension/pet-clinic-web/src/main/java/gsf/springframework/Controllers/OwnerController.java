package gsf.springframework.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"owners"})
@Controller
public class OwnerController {

    @RequestMapping({"index"})
    public String OwnerIndex() {
        return "owner/ownerIndex";
    }
}
