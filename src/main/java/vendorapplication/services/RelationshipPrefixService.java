package vendorapplication.services;


import vendorapplication.entities.RelationshipPrefix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vendorapplication.repositories.RelationshipPrefixRepository;

import java.util.List;

@Service
public class RelationshipPrefixService {

    @Autowired
    RelationshipPrefixRepository relationshipPrefixRepository;

    public RelationshipPrefixRepository getRelationshipPrefixRepository() {
        return relationshipPrefixRepository;
    }

    public void setRelationshipPrefixRepository(RelationshipPrefixRepository relationshipPrefixRepository) {
        this.relationshipPrefixRepository = relationshipPrefixRepository;
    }

    public List<RelationshipPrefix> getRelationshipPrefixes(){
        List<RelationshipPrefix> TypeList = null;
        try {
            TypeList = relationshipPrefixRepository.getRelationshipPrefixes();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error== getting the UserType");
        }
        return TypeList;
    }
}
