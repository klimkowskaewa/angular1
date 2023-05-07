# Models

## Language

Model representing Language defined in the file language.ts

### Fields

- id -> type : number -> identifier of entity
- code -> type : string -> iso2 code of the Language (should be unique on the database)
- name -> type : string -> human readable name of the entity

## DictionaryEntry

Model reproesenting entry in the dictionary for given Language defined in the file dictionaryEntry.ts

### Fields

- id -> type : number -> identifier of entity
- word -> type : string -> name of the word represented by the entity
- translation -> type : string -> transalation value of the word for your native language (you can assume it is Polish)
- description -> type : string -> short description of the word
- language -> type : Language -> entity representing Language for given entry

## Language - DictionaryEntry relationship
For 1 Language you can have many Entries, so relation between them is OneToMany

# Requests

## Language

All requests executions can be found in file language.service.ts

### GET /api/dictionary/language

- Request Type : GET
- Input : void
- Output : List of Language entities

### GET /api/dictionary/language/property/count

- Request Type : GET
- Input : void
- Output : Number value representing amount of Languages saved in the system

### GET /api/dictionary/language/{id}

- Request Type : GET
- Input : Number value of id for Language entity
- Output : Language entity for given id

### DELETE /api/dictionary/language/{id}

- Request Type : DELETE
- Input : Number value of id for Language entity
- Output : void

### POST /api/dictionary/language

- Request Type : POST
- Input : Language entity to be created
- Output : Language entity created in the system

### PUT /api/dictionary/language

- Request Type : PUT
- Input : Language entity to be updated
- Output : Language entity updated in the system

## DictionaryEntry

### GET /api/dictionary/entry

- Request Type : GET
- Input : void
- Output : List of DictionaryEntry entities in the system

### GET /api/dictionary/entry

- Request Type : GET
- Input : void
- Output : List of DictionaryEntry entities in the system

### GET /api/dictionary/entry/property/count

- Request Type : GET
- Input : Optional Request Parameter `code` of string type
- Output : number of Entries for given language `code` value if none provided we should return number of all entries

### GET /api/dictionary/entry/operation/search

- Request Type : GET
- Input : Request Parameter `text` of string type
- Output : list of Entries matching given `text` value, you can match text value agains : `word`, `translation`, `description` properties of entry

### GET /api/dictionary/entry/{id}

- Request Type : GET
- Input : Number value of id for Entry entity
- Output : Entry entity for given id

### DELETE /api/dictionary/entry/{id}

- Request Type : DELETE
- Input : Number value of id for Entry entity
- Output : void

### POST /api/dictionary/entry

- Request Type : POST
- Input : Entry entity to be created
- Output : Entry entity created in the system

### PUT /api/dictionary/entry

- Request Type : PUT
- Input : Entry entity to be updated
- Output : Entry entity updated in the system