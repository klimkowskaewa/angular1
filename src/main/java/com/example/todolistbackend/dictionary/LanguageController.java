package com.example.todolistbackend.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dictionary/entry")
public class LanguageController {

    @Autowired
    private LanguageRepository languageRepository;

    @GetMapping
    public List<Language> list() {
        return languageRepository.findAll();
    }

    @GetMapping("/property/count")
    public long count() {
        return languageRepository.count();
    }

    @GetMapping("/{id}")
    public Language get(@PathVariable Integer id){
        return languageRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        languageRepository.deleteById(id);
    }

    @PostMapping
    public Language create( @RequestBody Language language) {
        language.setId(null);
        return languageRepository.save(language);
    }

    @PutMapping
    public Language update(@RequestBody Language language) {
        Language updateLanguage = languageRepository.findById(language.getId()).get();
        updateLanguage.setName(language.getName());
        updateLanguage.setCode(language.getCode());
        return languageRepository.save(updateLanguage);
    }

}
