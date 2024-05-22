package gsf.springframework.services;

import gsf.springframework.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(Long id);

    Owner findByLastName(long id);

    Owner save(Owner owner);

    Set<Owner> findAll();


}
