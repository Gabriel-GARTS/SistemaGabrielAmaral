/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.GaaVendas;
import bean.GaaVendedor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u05594757139
 */
public class VendasDAO extends AbstractDAO{

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GaaVendas.class);
        criteria.add(Restrictions.eq("gaaIdVendas", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listVendedor(String nome) {
        session.beginTransaction();
        
        Criteria criteria = session.createCriteria(GaaVendas.class).createAlias("gaaVendedor", "vendedor"); 
        criteria.add(Restrictions.like("vendedor.gaaNome", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listTotal(double valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GaaVendas.class);
        criteria.add(Restrictions.ge("gaaTotal", valor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listVendedorTotal(String nome , double total) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GaaVendas.class).createAlias("gaaVendedor", "vendedor"); 
        criteria.add(Restrictions.like("vendedor.gaaNome", "%" + nome + "%"));
        criteria.add(Restrictions.ge("gaaTotal", total));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GaaVendas.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
}
