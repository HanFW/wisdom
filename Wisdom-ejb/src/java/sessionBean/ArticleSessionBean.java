/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import entity.Article;
import entity.Author;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Yongxue
 */
@Stateless
public class ArticleSessionBean implements ArticleSessionBeanLocal {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Long addNewArticle(String topic, String title, String description, 
            String context, Author author) {
        
        Article article = new Article(topic, title, description, context, author);
        
        entityManager.persist(article);
        entityManager.flush();
        
        return article.getArticleId();
    }
}
