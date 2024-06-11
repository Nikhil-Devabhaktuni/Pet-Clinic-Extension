package gsf.springframework.bootstrap;
import gsf.springframework.model.Owner;
import gsf.springframework.model.PetType;
import gsf.springframework.model.Vet;
import gsf.springframework.services.OwnerService;
import gsf.springframework.services.PetTypeService;
import gsf.springframework.services.VetService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner
{
    private  final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    //No need to use autowired annotation because spring will take care of rest. (Spring managed component without override annotation )
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {


        PetType dog = new PetType();
        dog.setName("Dog");
        PetType cat = new PetType();
        cat.setName("Cat");

        PetType saveDogPetType=petTypeService.save(dog);
        PetType saveCatPetType=petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Wick");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Dua");
        owner2.setLastName("Lipa");
        ownerService.save(owner2);

        System.out.println("owners..... loading");

        Vet vet1 = new Vet();
        vet1.setFirstName("Nikhil");
        vet1.setLastName("Devabhaktuni");
        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("Jane");
        vet2.setLastName("D");
        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Jesus");
        vet3.setLastName("God");
        vetService.save(vet3);

        System.out.println("vets..... loading");

    }
}
