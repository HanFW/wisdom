/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import entity.Author;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Yongxue
 */
@Stateless
public class AuthorSessionBean implements AuthorSessionBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Author retrieveAuthorById(Long authorId) {
        Author author = new Author();

        try {
            Query query = entityManager.createQuery("Select a From Author a Where a.authorId=:authorId");
            query.setParameter("authorId", authorId);

            if (query.getResultList().isEmpty()) {
                return new Author();
            } else {
                author = (Author) query.getSingleResult();
            }
        } catch (EntityNotFoundException enfe) {
            return new Author();
        } catch (NonUniqueResultException nure) {
        }

        return author;
    }
}
