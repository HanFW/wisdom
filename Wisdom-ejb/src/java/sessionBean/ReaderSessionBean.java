/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import entity.ArticleEntity;
import entity.AuthorEntity;
import entity.ReaderEntity;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sherry
 */
@Stateless
public class ReaderSessionBean implements ReaderSessionBeanLocal {

    private static final Logger LOGGER = Logger.getLogger(ReaderSessionBean.class.getName()); // used to output info
    private static ConsoleHandler handler = null; // set logger's output to console

    @PersistenceContext(unitName = "Wisdom-ejbPU")
    private EntityManager em;

    public ReaderSessionBean() {
        handler = new ConsoleHandler();
        handler.setLevel(Level.FINEST);
        LOGGER.setLevel(Level.ALL);
        LOGGER.addHandler(handler);
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    //Testing Version - TBC..
    @Override
    public ReaderEntity readerSignUp(String name, String email, String pwd) {
        ReaderEntity newReader = new ReaderEntity(name, email, pwd);
        em.persist(newReader);
        em.flush();
        em.refresh(newReader);
        return newReader;
    }
    
        
    @Override
    public ReaderEntity followAuthor(Long authorId, Long readerId) throws Exception{
        ReaderEntity reader = em.find(ReaderEntity.class, readerId);
        AuthorEntity author = em.find(AuthorEntity.class, authorId);
        if (reader == null || author == null) {
            return null;
        }

        if (reader.getFollowing().contains(author)) {
            throw new Exception("Error! Author is already followed by this reader");
        }

        reader.getFollowing().add(author);
        em.merge(reader);
        author.getFollowers().add(reader);
        em.merge(author);
        
        return reader;
    }

    @Override
    public List<AuthorEntity> getAllFollowingAuthors(Long readerId) {
        ReaderEntity reader = em.find(ReaderEntity.class, readerId);
        if (reader == null) {
            return null;
        }
        
        return reader.getFollowing();
    }

    @Override
    public ReaderEntity topUpWallet(Long readerId, BigDecimal amount) {
        ReaderEntity reader = em.find(ReaderEntity.class, readerId);
        if (reader == null) {
            return null;
        }
        
        BigDecimal newBalance = reader.getBalance().add(amount);
        LOGGER.log(Level.FINEST, "the new balance is calculated as {0}", newBalance);
        reader.setBalance(newBalance);
        em.merge(reader);
        return reader;
    }

    @Override
    public ArticleEntity likeArticle(Long articleId) {
        ArticleEntity article = em.find(ArticleEntity.class, articleId);
        if (article == null ) {
            return null;
        }

        article.setNumOfLikes(article.getNumOfLikes()+1);
        return article;
    }

    @Override
    public ReaderEntity saveArticle(Long readerId, Long articleId) throws Exception{
        ReaderEntity reader = em.find(ReaderEntity.class, readerId);
        ArticleEntity article = em.find(ArticleEntity.class, articleId);
        if (reader == null || article == null) {
            return null;
        }

        if (reader.getSavedArticles().contains(article)) {
            throw new Exception("Error! Author is already followed by this reader");
        }
        
        reader.getSavedArticles().add(article);
        em.merge(reader);
        article.getReaders().add(reader);
        em.merge(article);
        
        return reader;
    }

    @Override
    public List<ArticleEntity> getAllSavedArticles(Long readerId) {
        ReaderEntity reader = em.find(ReaderEntity.class, readerId);
        if (reader == null) {
            return null;
        }
        
        return reader.getSavedArticles();
    }
    
    
    
    
    
    



    
}
