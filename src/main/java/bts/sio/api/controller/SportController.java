package bts.sio.api.controller;

import bts.sio.api.model.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import bts.sio.api.service.SportService;

import java.util.Optional;

@RestController
public class SportController {

    @Autowired
    private SportService SportService;

    /**
     * Create - Add a new sport
     * @param sport An object sport
     * @return The sport object saved
     */
    @PostMapping("/Sport")
    public Sport createSport(@RequestBody Sport sport) {
        return SportService.saveSport(sport);
    }


    /**
     * Read - Get one sport
     * @param id The id of the sport
     * @return An Sport object fullfilled
     */
    @GetMapping("/Sport/{id}")
    public Sport getSport(@PathVariable("id") final Long id) {
        Optional<Sport> Sport = SportService.getSport(id);
        if(Sport.isPresent()) {
            return Sport.get();
        } else {
            return null;
        }
    }

    /**
     * Read - Get all Sports
     * @return - An Iterable object of Sport fullfilled
     */
    @GetMapping("/Sports")
    public Iterable<Sport> getSports() {
        return SportService.getSports();
    }

    /**
     * Update - Update an existing sport
     * @param id - The id of the sport to update
     * @param sport - The sport object updated
     * @return
     */
    @PutMapping("/Sport/{id}")
    public Sport updateSport(@PathVariable("id") final Long id, @RequestBody Sport sport) {
        Optional<Sport> e = SportService.getSport(id);
        if(e.isPresent()) {
            Sport currentSport = e.get();

            String nom = sport.getNom();
            if(nom != null) {
                currentSport.setNom(nom);
            }
            String descriptif = sport.getDescriptif();
            if(descriptif != null) {
                currentSport.setDescriptif(descriptif);;
            }

            SportService.saveSport(currentSport);
            return currentSport;
        } else {
            return null;
        }
    }


    /**
     * Delete - Delete an Sport
     * @param id - The id of the Sport to delete
     */
    @DeleteMapping("/Sport/{id}")
    public void deleteSport(@PathVariable("id") final Long id) {
        SportService.deleteSport(id);
    }

}
