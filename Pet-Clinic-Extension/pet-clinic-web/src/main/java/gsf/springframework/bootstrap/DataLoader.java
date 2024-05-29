package gsf.springframework.bootstrap;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.SyslogOutputStream;
import gsf.springframework.model.Owner;
import gsf.springframework.model.Vet;
import gsf.springframework.services.OwnerService;
import gsf.springframework.services.VetService;
import gsf.springframework.services.map.OwnerServiceMap;
import gsf.springframework.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner
{
    private  final OwnerService ownerService;
    private final VetService vetService;

    //No need to use autowired annotation because spring will take care of rest. (Spring managed component without override annotation )
    public DataLoader(OwnerService ownerService, VetService vetService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Wick");
        owner1.setId(1L);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Dua");
        owner2.setLastName("Lipa");
        owner2.setId(2L);
        ownerService.save(owner2);

        System.out.println("owners..... loading");

        Vet vet1 = new Vet();
        vet1.setFirstName("Nikhil");
        vet1.setLastName("Devabhaktuni");
        vet1.setId(1L);
        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("Jane");
        vet2.setLastName("D");
        vet2.setId(2L);
        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Jesus");
        vet3.setLastName("God");
        vet3.setId(3L);
        vetService.save(vet3);

        System.out.println("vets..... loading");

    }
}
