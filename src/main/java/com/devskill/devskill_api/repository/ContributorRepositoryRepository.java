package com.devskill.devskill_api.repository;

import com.devskill.devskill_api.models.Contributor;
import com.devskill.devskill_api.models.ContributorRepositoryEntity;
import com.devskill.devskill_api.models.RepositoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContributorRepositoryRepository extends JpaRepository<ContributorRepositoryEntity, Long> {

    // Find all repositories for a specific contributor
    List<ContributorRepositoryEntity> findByContributor(Contributor contributor);

    // Find all contributors for a specific repository
    List<ContributorRepositoryEntity> findByRepository(RepositoryEntity repository);

    // Check if a specific contributor-repository association exists
    Optional<ContributorRepositoryEntity> findByContributorAndRepository(Contributor contributor, RepositoryEntity repository);
}