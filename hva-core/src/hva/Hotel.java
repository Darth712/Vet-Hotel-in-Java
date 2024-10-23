package hva;

import java.io.Serial;
import java.io.Serializable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import hva.exceptions.*;
import hva.Seasons.*;
import hva.Strategy.*;
import hva.animal.*;
import hva.employee.*;
import hva.habitat.*;
import hva.tree.Deciduous;
import hva.tree.Evergreen;
import hva.tree.Tree;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;


/**
 * This class represents a hotel that hosts animals and trees in various habitats. 
 * It manages animals, employees, habitats, species, vaccines, and trees.
 */
public class Hotel implements Serializable{

    @Serial
    private static final long serialVersionUID = 202407081733L;

    private Season _currentSeason = new Season();
    private Map<String, Habitat> _habitats = new TreeMap<String, Habitat>(String.CASE_INSENSITIVE_ORDER);  
    private Map<String, Animal> _animals = new TreeMap<String, Animal>(String.CASE_INSENSITIVE_ORDER);  
    private Map<String, Species> _species = new TreeMap<String, Species>(String.CASE_INSENSITIVE_ORDER);  
    private Map<String, Employee> _employees = new TreeMap<String, Employee>(String.CASE_INSENSITIVE_ORDER); 
    private Map<String, Vaccine> _vaccines = new TreeMap<String, Vaccine>(String.CASE_INSENSITIVE_ORDER); 
    private Map<String, Tree> _trees = new TreeMap<String, Tree>(String.CASE_INSENSITIVE_ORDER); 
    private List<Vaccination> _vaccinations = new ArrayList<Vaccination>();
    private boolean _changed;


    /**
     * Gets the current season
     * 
     * @return current season
     */
    public Season getSeason() {
        return _currentSeason;
    }

    /**
     * Gets the map of habitats.
     * 
     * @return the habitat's map
     */
    public Map<String, Habitat> getHabitats() {
        return _habitats;
    }

    public Tree getTree(String treeID) {
        return _trees.get(treeID);
    }

    /**
     * Gets the map of animals.
     * 
     * @return the animal's map
     */

    public Map<String, Animal> getAnimals() {
        return _animals;
    }

    /**
     * Gets the map of employees.
     * 
     * @return the employee's map
     */

     public Map<String, Employee> getEmployees() {
        return _employees;
    }

    /**
     * Gets the map of vaccines.
     * 
     * @return the vaccine's map
     */

     public Map<String, Vaccine> getVaccines() {
        return _vaccines;
    }

    /**
     * Gets the list of vaccinations.
     * 
     * @return the vaccination's list
     */
    public List<Vaccination> getVaccinations(){
        return _vaccinations;
    }


    /**
     * Sets the changed status of the hotel.
     * 
     * @param bool true if the data has changed
     */
    public void setChanged(boolean bool) { 
        _changed = bool;
    }

    /**
     * Marks the hotel data as changed.
     */
    public void changed() { 
        _changed = true;
    }

    /**
     * Checks if the hotel data has changed.
     * 
     * @return true if the data has changed
     */
    public boolean hasChanged() { 
        return _changed;
    }

    /**
     * Advances the season to the next one.
     * 
     */
    public void advanceSeason () {
        _currentSeason.nextSeason();
        for (String treeId : _trees.keySet()) {
            Tree tree = getTree(treeId);
            if(tree.getBornSeason().equals(_currentSeason)) {
                tree.newAge();
            }
        }
    }

    /**
     * Reads a text input file and creates corresponding domain entities.
     *
     * @param filename name of the text input file
     * @throws ImportFileException if there is an error importing the file
     */
    public void importFile(String filename) throws ImportFileException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");  // Splits the line into parts using '|' as a delimiter
                try{
                    registerEntry(parts);

                } catch(AnimalExistsException | HabitatExistsException | VaccineExistsException |
                UnknownHabitatException | UnknownSpeciesException | TreeExistsException | EmployeeExistsException e) {
                    e.printStackTrace();
                } 
            }
        } catch (IOException | UnrecognizedEntryException e) {
            throw new ImportFileException(filename, e);
        }
            
    }

    /**
     * It registers a new entry to the hotel.
     * 
     * @param parts String containing the info to register
     * @throws AnimalExistsException
     * @throws UnrecognizedEntryException
     * @throws UnknownHabitatException
     * @throws UnknownSpeciesException
     * @throws HabitatExistsException
     * @throws TreeExistsException
     * @throws EmployeeExistsException
     * @throws VaccineExistsException
     */
    public void registerEntry(String... parts) throws AnimalExistsException,
    UnrecognizedEntryException, UnknownHabitatException, UnknownSpeciesException, 
    HabitatExistsException, TreeExistsException, EmployeeExistsException, 
    VaccineExistsException{
        switch (parts[0].toUpperCase()) {  
            case "ESPÉCIE":
                parseSpecies(parts);
                break;
            case "ÁRVORE":
                parseTree(parts);
                break;
            case "HABITAT":
                parseHabitat(parts);
                break;
            case "ANIMAL":
                parseAnimal(parts);
                break;
            case "TRATADOR":
                parseHandler(parts);
                break;
            case "VETERINÁRIO":
                parseVet(parts);
                break;
            case "VACINA":
                parseVaccine(parts);
                break;
            default:
                throw new UnrecognizedEntryException("Unrecognized entry: " + parts[0]);
        }
    
    }


    /**
     * Parses the species entry and creates a species object.
     * 
     * @param parts array of strings representing the species data
     */
    private void parseSpecies(String[] parts) {
        String id = parts[1];
        String name = parts[2];
        
        registerSpecies(id, name);
    }

    /**
     * Parses the tree entry and creates a tree object.
     * 
     * @param parts array of strings representing the tree data
     */
    private void parseTree(String[] parts) throws TreeExistsException{
      String id = parts[1];
      String name = parts[2];
      int age = Integer.parseInt(parts[3]);
      int difficulty = Integer.parseInt(parts[4]);
      String type = parts[5].toUpperCase();
      
      registerTree(id, name, age, difficulty, type);

    }

    /**
     * Parses the habitat entry and creates a habitat object.
     * 
     * @param parts array of strings representing the habitat data
     */
    private void parseHabitat(String[] parts) throws HabitatExistsException{
        String id = parts[1];
        String name = parts[2];
        int area = Integer.parseInt(parts[3]);

        registerHabitat(id, name, area);

        if (parts.length > 4) {
            String[] treeIds = parts[4].split(",");
            for (String treeId : treeIds) {
                addTreeToHabitat(id, treeId);

            }
        }
    }

    /**
     * Parses the animal entry and creates an animal object.
     * 
     * @param parts array of strings representing the animal data
     * @throws UnrecognizedEntryException if species or habitat is not found
     */
    private void parseAnimal(String[] parts) throws UnrecognizedEntryException, 
    AnimalExistsException, UnknownHabitatException, UnknownSpeciesException{
        String id = parts[1];
        String name = parts[2];
        String species = parts[3];
        String habitat = parts[4];

        if (species == null || habitat == null) {
            throw new UnrecognizedEntryException("Species or Habitat not found for Animal: " + id);
        }

        registerAnimal(id, name, species, habitat);
    }

    /**
     * Parses the handler (employee) entry and creates a handler object.
     * 
     * @param parts array of strings representing the handler data
     */
    private void parseHandler(String[] parts) throws EmployeeExistsException{
        String id = parts[1];
        String name = parts[2];
    
        registerHandler(id, name);
    
        if (parts.length > 3) {
            String[] habitatIds = parts[3].split(",");
            for (String habitatId : habitatIds) {
                if (_habitats.containsKey(habitatId)) {
                    addEmployeeResponsability(id, habitatId);
                    _habitats.get(habitatId).addHandler((Handler) _employees.get(id));
                }
            }
        }
    }
    

    /**
     * Parses the vet (employee) entry and creates a vet object.
     * 
     * @param parts array of strings representing the vet data
     */
    private void parseVet(String[] parts) throws EmployeeExistsException{
        String id = parts[1];
        String name = parts[2];

        registerVet(id, name);
       
        if (parts.length > 3) {
            String[] speciesIds = parts[3].split(",");
            for (String speciesId : speciesIds) {
                if (_species.containsKey(speciesId)) {
                    addEmployeeResponsability(id, speciesId);  
                    _species.get(speciesId).addVet((Vet) _employees.get(id));
                }
            }
        }

    }

    /**
     * Parses the vaccine entry and creates a vaccine object.
     * 
     * @param parts array of strings representing the vaccine data
     */
    private void parseVaccine(String[] parts) throws VaccineExistsException, UnknownSpeciesException{
        String id = parts[1];
        String name = parts[2];
    
    
        String applicableSpecies = (parts.length > 3) ? parts[3] : null;
    
        registerVaccine(id, name, applicableSpecies);
    }


    /**
     * Registers a new habitat.
     * 
     * @param id    the habitat's ID
     * @param name  the habitat's name
     * @param area  the habitat's area
     * @throws HabitatExistsException in case the Habitat already exists
     */
    public void registerHabitat(String id, String name, int area) throws HabitatExistsException{ 
        assertHabitatExists(id);
        _habitats.put(id, new Habitat(id, name, area));  
        changed();  
    }

    public void assertHabitatExists(String id) throws HabitatExistsException {
        if (_habitats.containsKey(id)) {
            throw new HabitatExistsException(id);
        }
    }

   

    /**
     * Registers a new species and adds it to the species map.
     * 
     * @param id    The unique identifier for the species.
     * @param name  The name of the species.
     */
    public void registerSpecies(String id, String name) { 
        _species.put(id, new Species(id, name));  
        changed();  
    }    

    /**
     * Registers a new animal and adds it to the animals map.
     * Also associates the animal with its habitat and species.
     * 
     * @param id      The animal's ID
     * @param name    The animal'sname
     * @param species The species the animal belongs to.
     * @param habitat The habitat where the animal resides.
     */
    public void registerAnimal(String id, String name, String s, String h) throws AnimalExistsException, 
    UnknownHabitatException, UnknownSpeciesException, UnrecognizedEntryException{ 
        assertAnimalExists(id);
        assertUnknownSpecies(s);
        assertUnknownHabitat(h);
        Species species = _species.get(s);
        Habitat habitat = _habitats.get(h);
        Animal animal = new Animal(id, name, species, habitat);
        _animals.put(id, animal);
        habitat.addAnimal(animal); 
        species.addAnimal(animal);  
        changed();  
    }    

    /**
 * Checks if the animal already exists.
 * 
 * @param key The unique key representing the animal.
 * @throws AnimalExistsException if the animal already exists in the system.
 */
public void assertAnimalExists(String key) throws AnimalExistsException {
    if (_animals.containsKey(key))
        throw new AnimalExistsException(key);
}

/**
 * Checks if the animal is unknown.
 * 
 * @param key The unique key representing the animal.
 * @throws UnknownAnimalException if the animal is not found in the system.
 */
public void assertUnknownAnimal(String key) throws UnknownAnimalException {
    if (!_animals.containsKey(key))
        throw new UnknownAnimalException(key);
}

/**
 * Checks if the habitat is unknown.
 * 
 * @param key The unique key representing the habitat.
 * @throws UnknownHabitatException if the habitat is not found in the system.
 */
public void assertUnknownHabitat(String key) throws UnknownHabitatException {
    if (!_habitats.containsKey(key))
        throw new UnknownHabitatException(key);
}

/**
 * Checks if the employee is unknown.
 * 
 * @param key The unique key representing the employee.
 * @throws UnknownEmployeeException if the employee is not found in the system.
 */
public void assertUnknownEmployee(String key) throws UnknownEmployeeException {
    if (!_employees.containsKey(key))
        throw new UnknownEmployeeException(key);
}

/**
 * Checks if the tree already exists.
 * 
 * @param key The unique key representing the tree.
 * @throws TreeExistsException if the tree already exists in the system.
 */
public void assertTreeExists(String key) throws TreeExistsException {
    if (_trees.containsKey(key))
        throw new TreeExistsException(key);
}

/**
 * Checks if the species is unknown.
 * 
 * @param key The unique key representing the species.
 * @throws UnknownSpeciesException if the species is not found in the system.
 */
public void assertUnknownSpecies(String key) throws UnknownSpeciesException {
    if (!_species.containsKey(key))
        throw new UnknownSpeciesException(key);
}

/**
 * Checks if the employee already exists.
 * 
 * @param key The unique key representing the employee.
 * @throws EmployeeExistsException if the employee already exists in the system.
 */
public void assertEmployeeExists(String key) throws EmployeeExistsException {
    if (_employees.containsKey(key)) {
        throw new EmployeeExistsException(key);
    }
}

/**
 * Checks if the vaccine already exists.
 * 
 * @param key The unique key representing the vaccine.
 * @throws VaccineExistsException if the vaccine already exists in the system.
 */
public void assertVaccineExists(String key) throws VaccineExistsException {
    if (_vaccines.containsKey(key)) {
        throw new VaccineExistsException(key);
    }
}

/**
 * Checks if the vaccine is unknown.
 * 
 * @param key The unique key representing the vaccine.
 * @throws UnknownVaccineException if the vaccine is not found in the system.
 */
public void assertUnknownVaccine(String key) throws UnknownVaccineException {
    if (!_vaccines.containsKey(key)) {
        throw new UnknownVaccineException(key);
    }
}

/**
 * Checks if the employee is not a veterinarian.
 * 
 * @param employee The employee object to verify.
 * @throws UnknownVetException if the employee is not a veterinarian.
 */
public void assertUnknownVet(Employee employee) throws UnknownVetException {
    if (employee.getType() != "VET") {
        throw new UnknownVetException(employee.getId());
    }
}

/**
 * Checks if the veterinarian is not authorized to handle a specific species.
 * 
 * @param employee The veterinarian employee to verify.
 * @param speciesId The species ID the vet should be authorized to handle.
 * @throws VetNotAuthException if the vet is not authorized for the species.
 */
public void assertVetNotAuth(Employee employee, String speciesId) throws VetNotAuthException {
    Vet vet = (Vet) employee;
    if (!vet.getResponsibilities().containsKey(speciesId)) {
        throw new VetNotAuthException(vet.getId(), speciesId);
    }
}

    


    /**
     * Registers a new handler and adds them to the employees map.
     * 
     * @param id    The handler's ID
     * @param name  The handler's name
     */
    public void registerHandler(String id, String name) throws EmployeeExistsException{
        assertEmployeeExists(id);
        _employees.put(id, new Handler(id, name));
        changed();        
    }

    /**
     * Registers a new veterinarian and adds them to the employees map.
     * 
     * @param id    The vet's ID
     * @param name  The vet's name
     */
    public void registerVet(String id, String name) throws EmployeeExistsException{
        assertEmployeeExists(id);
        _employees.put(id, new Vet(id, name));
        changed();        
    }




    /**
     * Registers a new tree and adds it to the trees map.
     * Depending on the type ("CADUCA" or "PERENE"), it registers the tree as Deciduous or Evergreen.
     * 
     * @param id        The tree's ID
     * @param name      The tree's name
     * @param age       The tree' age
     * @param baseDiff  The base cleaning difficulty of the tree.
     * @param type      The type of tree 
     */
    public void registerTree(String id, String name, int age, int baseDiff, String type) throws
    TreeExistsException{
        assertTreeExists(id);
        if (type.equals("CADUCA"))
            _trees.put(id, new Deciduous(id, name, age, baseDiff, _currentSeason, type));
        if (type.equals("PERENE"))
            _trees.put(id, new Evergreen(id, name, age, baseDiff, _currentSeason, type));  
        changed();  
    }

    /**
     * Adds a tree to a specific habitat.
     * 
     * @param habitatId The ID of the habitat where the tree will be added.
     * @param treeId    The ID of the tree to add to the habitat.
     */
    public void addTreeToHabitat(String habitatId, String treeId) {
        Habitat habitat = _habitats.get(habitatId);

        if (_trees.containsKey(treeId)) {
            habitat.addTree(treeId, _trees.get(treeId));  
            changed();
        }
    }

    /**
     * Registers a new vaccine and associates it with applicable species.
     * Species are passed as a comma-separated string of species IDs.
     * 
     * @param id                The vaccine's ID
     * @param name              The vaccine's name
     * @param applicableSpecies A comma-separated string of species IDs the vaccine applies to.
     */
    public void registerVaccine(String id, String name, String applicableSpecies) throws VaccineExistsException,
                                UnknownSpeciesException{
        assertVaccineExists(id);
        Vaccine vaccine = new Vaccine(id, name);

        if (applicableSpecies != null) {
            String[] speciesIds = applicableSpecies.split(",");
            for (String speciesId : speciesIds) {
                assertUnknownSpecies(speciesId);
                vaccine.addSpecies(speciesId, _species.get(speciesId));  // Associates the vaccine with the species
            }
        }

        _vaccines.put(id, vaccine);
        changed();
    }

    public void vaccinateAnimal(String vaccineKey, String vetKey, String animalkey) throws UnknownAnimalException, 
                                UnknownEmployeeException, UnknownVaccineException , UnknownVetException, VetNotAuthException{
        assertUnknownEmployee(vetKey);
        assertUnknownVaccine(vaccineKey);
        assertUnknownAnimal(animalkey);

        
        Animal animal = _animals.get(animalkey);
        Species species = animal.getSpecies();
        Employee vet =  _employees.get(vetKey);
        Vaccine vaccine = _vaccines.get(vaccineKey);
        assertUnknownVet(vet);
        assertVetNotAuth(vet,species.getId());

        Vaccination vaccination = new Vaccination(vaccine, vetKey, animal);
        _vaccinations.add(vaccination);
    }

    /**
     * Gets the medical acts done by a specified Vet.
     * 
     * @param vetKey
     * @return Collection of medical acts
     * @throws UnknownVetException
     * @throws UnknownEmployeeException
     */
    public Collection<Vaccination> vetActs(String vetKey) throws UnknownVetException, UnknownEmployeeException {
        Employee vet = _employees.get(vetKey);
        List<Vaccination> acts = new ArrayList<>();
        assertUnknownEmployee(vetKey);
        assertUnknownVet(vet);
        for (Vaccination vaccination : _vaccinations) {
            if (vaccination.getVet().equals(vetKey)) {
                acts.add(vaccination);
            }
        }
        return acts;
    }

    /**
     * Gets the medical acts on a specified animal.
     * 
     * @param animalKey
     * @return Collection of medical acts
     * @throws UnknownAnimalException
     */
    public Collection<Vaccination> actsOnAnimal(String animalKey) throws UnknownAnimalException {
        assertUnknownAnimal(animalKey);
        Animal animal = getAnimals().get(animalKey);
        return animal.getVaccinations();
    }


    /**
     * Displays all habitats in an unmodifiable collection.
     * 
     * @return a collection of all habitats.
     */
    public Collection<Habitat> getAllHabitats() {
        return getHabitats().values();
    }


    /**
     * Displays all animals in an unmodifiable collection.
     * 
     * @return a collection of all animals
     */
    public Collection<Animal> getAllAnimals() {
        return getAnimals().values();
    }

    /**
     * Displays all employees in an unmodifiable collection.
     * 
     * @return a collection of all employees
     */
    public Collection<Employee> getAllEmployees() {
        return getEmployees().values();
    }

    /**
     * Displays all vaccines in an unmodifiable collection.
     * 
     * @return a collection of all vaccines
     */
    public Collection<Vaccine> getAllVaccines() {
        return getVaccines().values();
    }

    /**
     * Displays all vaccinations in an unmodifiable collection.
     * 
     * @return a collection of all vaccinations
     */
    public Collection<Vaccination> getAllVaccinations() {
        return getVaccinations();
    }

    /**
     * Transfers an animal to another habitat.
     * 
     * @param animalId
     * @param habitatId
     * @throws UnknownAnimalException
     * @throws UnknownHabitatException
     * @throws UnrecognizedEntryException
     */
    public void animalToHabitat(String animalId, String habitatId) throws 
    UnknownAnimalException, UnknownHabitatException, UnrecognizedEntryException{
        assertUnknownAnimal(animalId);
        assertUnknownHabitat(habitatId);
        Animal animal = _animals.get(animalId);
        Habitat currentHabitat = animal.getHabitat();  

        if (currentHabitat != null) {
            currentHabitat.getAnimals().remove(animalId);  
        }
        
        Habitat newHabitat = _habitats.get(habitatId);
        animal.setHabitat(newHabitat);
        
        
        newHabitat.addAnimal(animal);  
        changed();
    }


    /**
     * Changes the area of a habitat.
     * 
     * @param id
     * @param area
     * @throws UnknownHabitatException
     */
    public void changeHabitatArea(String id, int area) throws UnknownHabitatException{
        assertUnknownHabitat(id);
        _habitats.get(id).setArea(area);
        changed();

    }

    /**
     * Setter for the habitat influence according to the species in it.
     * 
     * @param habitatId
     * @param speciesId
     * @param influence
     */
    public void setHabitatInfluence(String habitatId, String speciesId, String influence) throws
    UnknownHabitatException, UnknownSpeciesException{
        
        assertUnknownHabitat(habitatId);
        assertUnknownSpecies(speciesId);
        _habitats.get(habitatId).addInfluence(speciesId,influence);
        changed();
    }

    /**
     * Shows the satisfaction from a specified Animal.
     * 
     * @param id
     * @return Animal's satisfaction
     */
    public int showAnimalSatisfaction(String id) {
        CalculateStrategy method = new AnimalSatisfaction(_animals.get(id));
        return (int) Math.round(method.calculate());

    }

    /**
     * Checks if the employee is a Handler.
     * 
     * @param id
     * @return boolean
     */
    public boolean isAHandler(String id) {
        return _employees.get(id).getType().equals("TRT");
    }

    /**
     * Checks if the employee is a Vet.
     * 
     * @param id
     * @return boolean
     */
    public boolean isAVet(String id) {
        return _employees.get(id).getType().equals("VET");
    }

    /**
     * Shows the satisfaction from a specified Employee.
     * 
     * @param id
     * @return Employee's satisfaction
     */
    public int showEmployeeSatisfaction(String id) {

        int satisfaction = 0;

        if(isAHandler(id)) {
            CalculateStrategy method = new HandlerSatisfaction((Handler) _employees.get(id));
            satisfaction = (int) Math.round(method.calculate());
        }
        if(isAVet(id)) {
            CalculateStrategy method = new VetSatisfaction((Vet) _employees.get(id));
            satisfaction = (int) Math.round(method.calculate());
        }
        
        return satisfaction;
    }

   // REFAZER ISTO TA MAL FEITO
   /**
    * Removes a certain responsability from an employee 
    *
    * @param employeeId 
    * @param resId responsability's ID
    * @throws UnknownEmployeeException
    * @throws ResponsabilityNotFoundException
    */
    public void removeResponsability(String employeeId, String resId) throws 
    UnknownEmployeeException, ResponsabilityNotFoundException{

        assertUnknownEmployee(employeeId);
        if(isAHandler(employeeId)) {
            assertResponsabilityNotFound(employeeId, resId);
            Handler handler = (Handler) _employees.get(employeeId);
            handler.getResponsibilities().remove(resId);
        }
        if(isAVet(employeeId)) {
            assertResponsabilityNotFound(employeeId, resId);
            Vet vet = (Vet) _employees.get(employeeId);
            vet.getResponsibilities().remove(resId);
        }

        changed();
      
    }

    /**
     * Adds a new responsibility to an employee by their ID.
     * 
     * @param employeeId        The ID of the employee to assign the responsibility to.
     * @param responsabilityId  The ID of the responsibility to be assigned.
     */
    public void addEmployeeResponsability(String employeeId, String resId) {
        if (isAHandler(employeeId)) {
            Handler handler = (Handler) _employees.get(employeeId);
            handler.addNewResponsibility(resId,_habitats.get(resId));
        }
        if (isAVet(employeeId)) {
            Vet vet = (Vet) _employees.get(employeeId);
            vet.addNewResponsibility(resId, _species.get(resId));
        }
        changed();
    }

    /**
     * Adds a certain resposability from an employee.
     * 
     * @param employeeId
     * @param resId responsability's ID
     * @throws UnknownEmployeeException
     * @throws UnknownResponsabilityException
     */
    public void addResponsability(String employeeId, String resId) throws 
    UnknownEmployeeException, UnknownResponsabilityException{
        
        assertUnknownEmployee(employeeId);
        addEmployeeResponsability(employeeId, resId);

        changed();
      
    }
    
    // REFAZER ESTE TAMBEM!!!
    /**
     * Checks if the responsability exists.
     * It depends whether it's a handler or a vet
     * 
     * @param employeeId
     * @param resId
     * @throws UnknownResponsabilityException
     */
    public void assertUnknownResponsability(String employeeId, String resId) throws UnknownResponsabilityException{
    
        if(isAHandler(employeeId)) {
            if (!_habitats.containsKey(resId) ) {
                throw new UnknownResponsabilityException(resId);
            }
        }

        if(isAVet(employeeId)) {
            if (!_species.containsKey(resId)) {
                throw new UnknownResponsabilityException(resId);
            }
        }

    }

    // REFAZER ESTE TAMBEM!!!
    /**
     * Checks if the employee contains the specified responsability.
     * 
     * @param employeeId
     * @param resId
     * @throws ResponsabilityNotFoundException
     */
    public void assertResponsabilityNotFound(String employeeId, String resId) throws ResponsabilityNotFoundException{
    
        if(isAHandler(employeeId)) {
            Handler handler = (Handler) _employees.get(employeeId);
            if (!handler.getResponsibilities().containsKey(resId)) {
                throw new ResponsabilityNotFoundException(resId);
            }
        }

        if(isAVet(employeeId)) {
            Vet vet = (Vet) _employees.get(employeeId);
            if (!vet.getResponsibilities().containsKey(resId)) {
                throw new ResponsabilityNotFoundException(resId);
            }
        }

    }


    /**
     * Sums up all the satisfaction from the animals and the employees.
     * 
     * @return global satisfaction of the hotel
     */
    public int showGlobalSatisfaction() {
        int totalSatisfaction = 0;
        for (String animalId : _animals.keySet()) {
        totalSatisfaction += showAnimalSatisfaction(animalId);   
        }

        for (String employeeId : _employees.keySet()) {
            totalSatisfaction += showEmployeeSatisfaction(employeeId);
        }    

        return totalSatisfaction;
    }  

    /**
     * Shows all the animals in a specified habitat.
     * 
     * @param habitatId The habitat's ID
     * @return Animal Collection
     */
    public Collection<Animal> showAnimalsInHabitat(String habitatId) throws UnknownHabitatException{
        Habitat habitat = _habitats.get(habitatId);
        return habitat.getAnimals().values();
    }
}