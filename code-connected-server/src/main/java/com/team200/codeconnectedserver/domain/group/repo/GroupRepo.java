package com.team200.codeconnectedserver.domain.group.repo;
import com.team200.codeconnectedserver.domain.group.model.Group;
import com.team200.codeconnectedserver.domain.profile.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;


public interface GroupRepo extends JpaRepository<Group,Long> {

    List<Profile> findByProfile();
    List<Profile>findAllAdmins();
    Optional<Group> findByOwner(Profile profile);
    List<Profile>findAllMembers();
    Optional<Group>findById();

}
