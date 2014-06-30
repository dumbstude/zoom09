/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.CoopMember;

/**
 *
 * @author mis
 */
@Stateless
public class CoopMemberFacade extends AbstractFacade<CoopMember> {
	@PersistenceContext(unitName = "zoom09PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public CoopMemberFacade() {
		super(CoopMember.class);
	}
	
}
