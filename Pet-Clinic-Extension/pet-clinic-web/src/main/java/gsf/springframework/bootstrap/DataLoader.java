package gsf.springframework.bootstrap;
import gsf.springframework.model.*;
import gsf.springframework.services.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner
{
    //Obj reference with Interface Loose Coupling
    //No need to use autowired annotation because spring will take care of rest. (Spring managed component without override annotation )
    private  final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    //No need to use autowired annotation because spring will take care of rest. (Spring managed component without override annotation )
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;

        this.specialityService = specialityService;
    }


    @Override
    public void run(String... args) throws Exception {
        int count=petTypeService.findAll().size();
        if(count ==0 )
        {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType cat = new PetType();
        cat.setName("Cat");

        PetType saveDogPetType=petTypeService.save(dog);
        PetType saveCatPetType=petTypeService.save(cat);

        Speciality radiology=new Speciality();
        radiology.setDescription("radiology");

        Speciality surgery=new Speciality();
        surgery.setDescription("surgery");

        Speciality dentistry=new Speciality();
        dentistry.setDescription("dentistry");

        Speciality saveRadiology=specialityService.save(radiology);
        Speciality saveSurgery=specialityService.save(surgery);
        Speciality saveDentistry=specialityService.save(dentistry);

        //Owner Details adding

        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Wick");
        owner1.setAddress("Dublin");
        owner1.setCity("San Francisco");
        owner1.setTelephone("5555555555");


        //Owner pet Details for Jhon Owner1.

        Pet John = new Pet();
        John.setPetType(saveDogPetType);
        John.setOwner(owner1);
        John.setBirthDate(LocalDate.now());
        John.setName("Srikanth");
        owner1.getPets().add(John);

        // saving owner1.
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Dua");
        owner2.setLastName("Lipa");
        owner2.setAddress("india");
        owner2.setCity("Francisco");
        owner2.setTelephone("4444444");


        Pet Dua = new Pet();
        Dua.setPetType(saveCatPetType);
        Dua.setOwner(owner2);
        Dua.setBirthDate(LocalDate.now());
        Dua.setName("Me");
        owner2.getPets().add(Dua);


        ownerService.save(owner2);


        System.out.println("owners..... loading");

        Vet vet1 = new Vet();
        vet1.setFirstName("Nikhil");
        vet1.setLastName("Devabhaktuni");
        vet1.getSpecialities().add(saveRadiology);
        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("Vamsi");
        vet2.setLastName("Devabhaktuni");
        vet2.getSpecialities().add(saveDentistry);
        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Hanuman");
        vet3.setLastName("God");
        vet3.getSpecialities().add(saveSurgery);
        vetService.save(vet3);

        System.out.println("vets..... loading");
    }
}
