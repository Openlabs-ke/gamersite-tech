package org.xgamerstechnologies.com.abstractions;

import org.springframework.beans.factory.annotation.Autowired;
import org.xgamerstechnologies.com.entity.ComputerGame;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class GameRetrieval<T> {
    @Autowired
    private EntityManager entityManager;
    public abstract T retrieveGame(Long id);

    public List<T> retrievePagedList(int pageNumber, int pageSize, Class<T> clazz) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        countQuery.select(criteriaBuilder.count(countQuery.from(clazz)));
        Long count = entityManager.createQuery(countQuery).getSingleResult();

        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<T> from = criteriaQuery.from(clazz);
        CriteriaQuery<T> select = criteriaQuery.select(from);

        TypedQuery<T> typedQuery = entityManager.createQuery(select);

        while(pageNumber < count.intValue()) {
            typedQuery.setFirstResult(pageNumber - 1);
            typedQuery.setMaxResults(pageSize);
            pageNumber += pageSize;
        }

        return typedQuery.getResultList();
    }
}
