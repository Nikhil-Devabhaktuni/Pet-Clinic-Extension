package gsf.springframework.services;

import gsf.springframework.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(Long id);

    


}
