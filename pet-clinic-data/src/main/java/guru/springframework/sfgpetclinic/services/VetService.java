package guru.springframework.sfgpetclinic.services;

import java.util.Set;

public interface VetService {
    VetService findbyId(Long id);

    VetService save(VetService owner);

    Set<VetService> findAll();
}
