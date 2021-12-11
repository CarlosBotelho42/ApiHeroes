package com.carlosb.herois.servicies;

import com.carlosb.herois.domain.Heroes;
import com.carlosb.herois.repositories.HeroesRepository;
import com.carlosb.herois.servicies.exceptions.DataIntegrityViolation;
import com.carlosb.herois.servicies.exceptions.ObjectNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeroesServicies {

    @Autowired
    private HeroesRepository repository;

    public Heroes findBy(Integer id){
        Optional<Heroes> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotfoundException(
                "Objeto não encontrado! Id: "
                        + id
                        + ", Tipo: "
                        + Heroes.class.getName()
        ));
    }

    public Heroes insert(Heroes obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Heroes update(Heroes obj){
        Heroes newObj = findBy(obj.getId());
        updateData(newObj, obj);
        return  repository.save(newObj);
    }

    private void updateData(Heroes newObj, Heroes obj) {
        newObj.setName(obj.getName());
    }

    public void delete(Integer id){
        findBy(id);
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolation("Não é possível excluir uma categoria que tenha produtos!");
        }
    }

    public List<Heroes> findAll(){
        return repository.findAll();
    }
    
}
