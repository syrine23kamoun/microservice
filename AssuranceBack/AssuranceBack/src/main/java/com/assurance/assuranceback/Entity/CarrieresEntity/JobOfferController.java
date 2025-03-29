package com.assurance.assuranceback.Entity.CarrieresEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobOffers")
public class JobOfferController {
    @Autowired
    IJobOfferService JobOfferService;
    @GetMapping
    public List<JobOffer> getAllJobOffers(@RequestParam(required = false) String search) {
        if (search != null && !search.isEmpty()) {
            return JobOfferService.searchJobOffersByTitle(search);
        }
        return JobOfferService.retrieveallJobOffers();
    }


    @GetMapping("/{id}")
    public JobOffer getJobOffersById(@PathVariable Long id) {
        return JobOfferService. retrieveJobOfferById(id);
    }

    @PostMapping
    public JobOffer createJobOffer(@RequestBody JobOffer jobOffer) {
        return JobOfferService.addJobOffer(jobOffer);
    }

    @PutMapping("/{id}")
    public JobOffer updateJobOffer (@PathVariable Long id, @RequestBody JobOffer updatedJobOffer) {
        return JobOfferService.updateJobOffer(id, updatedJobOffer);
    }

    @DeleteMapping("/{id}")
    public void deleteJobOffer(@PathVariable Long id) {
        JobOfferService.removeJobOffer(id);
    }
}
