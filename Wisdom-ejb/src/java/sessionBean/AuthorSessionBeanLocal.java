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
public interface AuthorSessionBeanLocal {

    public Author retrieveAuthorById(Long authorId);

}
