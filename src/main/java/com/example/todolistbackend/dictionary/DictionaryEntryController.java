package com.example.todolistbackend.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dictionary/entry")
public class DictionaryEntryController {

    @Autowired
    private DictionaryEntryRepository repository;

    @GetMapping
    public List<DictionaryEntry> list() {
        return repository.findAll();
    }

    @GetMapping("/property/code")
    public long count(@RequestParam(required = false) String code) {
        if (code == null) {
            return repository.count();
        }
        return repository.countByLanguageCode(code);
    }


    @GetMapping("/operation/search")
    public List<DictionaryEntry> search(@RequestParam String text) {
        return repository.findAllByWordContainingOrTranslationContainingOrDescriptionContaining(text, text, text);
    }

    @GetMapping("/{id}")
    public DictionaryEntry get(@PathVariable Integer id) {
        return repository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @PostMapping
    public DictionaryEntry create(@RequestBody DictionaryEntry dictionaryEntry) {
        dictionaryEntry.setId(null);
        return repository.save(dictionaryEntry);
    }

    @PutMapping
    public DictionaryEntry update(@RequestBody DictionaryEntry dictionaryEntry) {
        DictionaryEntry updateDictionaryEntry =get(dictionaryEntry.getId());
        updateDictionaryEntry.setDescription(dictionaryEntry.getDescription());
        updateDictionaryEntry.setWord(dictionaryEntry.getWord());
        updateDictionaryEntry.setTranslation(dictionaryEntry.getTranslation());
        return repository.save(updateDictionaryEntry);
    }
}