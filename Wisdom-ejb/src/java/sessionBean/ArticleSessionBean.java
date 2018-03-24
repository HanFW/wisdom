/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import entity.ArticleEntity;
import entity.AuthorEntity;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Yongxue
 */
@Stateless
public class ArticleSessionBean implements ArticleSessionBeanLocal {

    @EJB(name = "AuthorSessionBeanLocal")
    private AuthorSessionBeanLocal authorSessionBeanLocal;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long addNewArticle(String topic, String title, String description,
            String context, Long authorId) {

        AuthorEntity author = authorSessionBeanLocal.retrieveAuthorById(authorId);
        
        ArticleEntity article = new ArticleEntity(topic, title, description, context, author);

        entityManager.persist(article);
        entityManager.flush();

        return article.getArticleId();
    }
}
