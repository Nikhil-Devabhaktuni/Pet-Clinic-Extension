package gsf.springframework.services;

import gsf.springframework.model.Vet;

import java.util.Set;

public interface VetService extends CrudService<Vet, Long> {

    Vet findById(Long id);


}
