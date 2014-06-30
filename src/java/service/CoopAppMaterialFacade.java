/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.CoopAppMaterial;

/**
 *
 * @author mis
 */
@Stateless
public class CoopAppMaterialFacade extends AbstractFacade<CoopAppMaterial> {
	@PersistenceContext(unitName = "zoom09PU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public CoopAppMaterialFacade() {
		super(CoopAppMaterial.class);
	}
	
}
