package gsf.springframework.services.map;

import gsf.springframework.model.Owner;
import gsf.springframework.model.Pet;
import gsf.springframework.services.OwnerService;

import gsf.springframework.services.PetService;
import gsf.springframework.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService
{
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeServiceService, PetService petService) {
        this.petTypeService = petTypeServiceService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
         super.deleteById(id);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

       // Owner saved = null;
        if(object !=null)
        {
            if(object.getPets()!=null)
            {
                object.getPets().forEach(pet ->{
                    if(pet.getPetType()!=null)
                    {
                        if (pet.getPetType().getId() ==null)
                        {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }
                    else
                    {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if (pet.getId() ==null)
                    {
                        Pet savePet = petService.save(pet);
                        pet.setId(savePet.getId());
                    }
                });
            }
            return super.save(object);
        }
        return null;
    }


    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
