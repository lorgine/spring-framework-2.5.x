package org.springframework.samples.petclinic.jpa;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.samples.petclinic.Clinic;
import org.springframework.samples.petclinic.Owner;
import org.springframework.samples.petclinic.Pet;
import org.springframework.samples.petclinic.Visit;

/**
 * JPA implementation of the Clinic interface.
 *
 * <p>The mappings are defined in "orm.xml"
 * located in the META-INF dir.
 *
 * @author Mike Keith
 * @since 22.04.2006
 */
public class JpaTemplateClinic extends JpaDaoSupport implements Clinic {
	
	public Collection getVets() throws DataAccessException {
		return getJpaTemplate().find("SELECT vet FROM Vet vet ORDER BY vet.lastName, vet.firstName");
	}

	public Collection getPetTypes() throws DataAccessException {
		return getJpaTemplate().find("SELECT pt FROM PetType pt ORDER BY pt.name");
	}

	public Collection findOwners(String lastName) throws DataAccessException {
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("lastName", lastName + "%");
		return getJpaTemplate().findByNamedParams("SELECT owner FROM Owner owner WHERE owner.lastName LIKE :lastName", map);
	}

	public Owner loadOwner(int id) throws DataAccessException {
		return getJpaTemplate().find(Owner.class, new Integer(id));
	}

	public Pet loadPet(int id) throws DataAccessException {
		return getJpaTemplate().find(Pet.class, id);
	}

	public void storeOwner(Owner owner) throws DataAccessException {
		getJpaTemplate().merge(owner);
	}

	public void storePet(Pet pet) throws DataAccessException {
		getJpaTemplate().merge(pet);
	}

	public void storeVisit(Visit visit) throws DataAccessException {
		getJpaTemplate().merge(visit);
	}

}
