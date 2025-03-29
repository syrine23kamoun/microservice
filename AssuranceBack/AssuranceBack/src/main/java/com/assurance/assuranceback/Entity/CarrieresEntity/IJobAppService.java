package com.assurance.assuranceback.Entity.CarrieresEntity;

import com.assurance.assuranceback.Entity.CarrieresEntity.JobApplication;
import com.assurance.assuranceback.Entity.CarrieresEntity.StatutCandidature;

import java.util.List;

public interface IJobAppService {
    public List<JobApplication> retrieveallJobApplications();
    public JobApplication retrieveJobApplicationById(long id);
    public JobApplication addJobApplication(JobApplication JA);
    public void removeJobApplication(long id);
    public JobApplication updateJobApplication(Long id, JobApplication jobAppDetails);

    JobApplication addSpontaneousApplication(JobApplication jobApplication);
    // New method for updating status
    JobApplication updateStatus(Long id, StatutCandidature status);

}
