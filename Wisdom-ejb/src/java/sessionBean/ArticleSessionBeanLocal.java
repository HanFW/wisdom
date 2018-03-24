/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import entity.Author;
import javax.ejb.Local;

/**
 *
 * @author Yongxue
 */
@Local
public interface ArticleSessionBeanLocal {

    public Long addNewArticle(String topic, String title, String description,
            String context, Author author);

}
