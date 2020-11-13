package com.bytecode.rediscache.rediscache.api;

import com.bytecode.rediscache.rediscache.model.Libro;
import com.bytecode.rediscache.rediscache.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/libro")
public class LibroRestController {
    @Autowired
    private LibroRepository libroRepository;

    @GetMapping("/findAll")
    @Cacheable(cacheNames = {"libros"})
    public Page<Libro> findAll(Pageable pageable){
        return libroRepository.findAll(pageable);
    }

    @PutMapping
    @CacheEvict(value = {"libros"}, allEntries = true)
    public Libro insert(@RequestBody Libro libro){
        //Logica de actualizacion por aqui
        return libroRepository.save(libro);
    }

    @DeleteMapping
    @CacheEvict(value = {"libros"}, allEntries = true)
    public void deleteById(@RequestBody Libro libro){
        libroRepository.delete(libro);
    }

    @PostMapping
    @CacheEvict(value = {"libros"}, allEntries = true)
    public Libro update(@RequestBody Libro libro){
        //Logica de actualizacion por aqui
        return libroRepository.save(libro);
    }
}
