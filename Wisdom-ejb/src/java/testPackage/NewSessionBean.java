/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testPackage;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hanfengwei
 */
@Stateless
@LocalBean
public class NewSessionBean {
    @PersistenceContext(unitName = "Wisdom-ejbPU")
    private EntityManager em;

}
