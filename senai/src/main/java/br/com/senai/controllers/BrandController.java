package br.com.senai.controllers;

import br.com.senai.models.Brand;
import br.com.senai.models.Coffee;
import br.com.senai.repositores.BrandRepositore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/brand")
public class BrandController {

        @Autowired
        BrandRepositore brandRepository;

        @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
        public List<Brand> getAllBrand() {
            return brandRepository.findAll();
        }

        @PostMapping(value = "/createBrand",
                produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
        public Brand crateBrand(@RequestBody Brand brand) {
            //Cria um novo objeto coffee
            Brand newBrand = new Brand();
            //Seta as prioridades do coffee
            newBrand.setName(brand.getName());
            newBrand.setDescription(brand.getDescription());
            //Chama o método save para salvar  objeto no banco de dados
            return brandRepository.save(newBrand);
    }
    @PutMapping(value = "/updateBrand",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Brand updateBrand(@RequestBody Brand brand){
        Brand getBrand = brandRepository.findById(brand.getId())
                .orElseThrow();
        Brand updateBrand=new Brand();

        updateBrand.setId(brand.getId());
        updateBrand.setName(brand.getName());
        updateBrand.setDescription(brand.getDescription());

        return brandRepository.save(updateBrand);
    }
    @DeleteMapping(value = "/deleteBrand/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Brand deleteBrand(@PathVariable Long id) {
        Brand getBrand = brandRepository.findById(id).orElseThrow();
        brandRepository.delete(getBrand);
        return getBrand;
    }
}
