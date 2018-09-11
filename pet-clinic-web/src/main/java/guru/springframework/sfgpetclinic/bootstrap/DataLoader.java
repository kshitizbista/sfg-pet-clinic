package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Kshitiz");
        owner1.setLastName("Bista");
        owner1.setAddress(" Bhainsepati");
        owner1.setCity("Kathmandu");
        owner1.setTelephone("+911 67098");
        ownerService.save(owner1);

        Pet kshitizPet = new Pet();
        kshitizPet.setPetType(savedDogType);
        kshitizPet.setOwner(owner1);
        kshitizPet.setBirthDay(LocalDate.now());
        kshitizPet.setName("Rosco");

        owner1.getPets().add(kshitizPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ram");
        owner2.setLastName("Bista");
        owner2.setAddress(" Bhainsepati");
        owner2.setCity("Kathmandu");
        owner2.setTelephone("+911 67098");
        ownerService.save(owner2);

        Pet ramCat = new Pet();
        ramCat.setName("Just Cat");
        ramCat.setBirthDay(LocalDate.now());
        ramCat.setPetType(savedCatType);
        ramCat.setOwner(owner2);

        owner2.getPets().add(ramCat);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Turner");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet2);

        System.out.println("Loaded Vets");

    }
}
