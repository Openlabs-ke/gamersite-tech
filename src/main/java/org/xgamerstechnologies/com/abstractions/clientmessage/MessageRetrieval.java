package org.xgamerstechnologies.com.abstractions.clientmessage;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class MessageRetrieval<ClientMessage> {
    @Autowired
    private EntityManager entityManager;

    public abstract ClientMessage retrieveMessage(Long id);

    public List<ClientMessage> retrievePagedList(int pageNumber, int pageSize, Class<ClientMessage> clazz) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        countQuery.select(criteriaBuilder.count(countQuery.from(clazz)));
        Long count = entityManager.createQuery(countQuery).getSingleResult();

        CriteriaQuery<ClientMessage> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<ClientMessage> from = criteriaQuery.from(clazz);
        CriteriaQuery<ClientMessage> select = criteriaQuery.select(from);

        TypedQuery<ClientMessage> typedQuery = entityManager.createQuery(select);

        while(pageNumber < count.intValue()) {
            typedQuery.setFirstResult(pageNumber - 1);
            typedQuery.setMaxResults(pageSize);
            pageNumber += pageSize;
        }

        return typedQuery.getResultList();
    }
}
