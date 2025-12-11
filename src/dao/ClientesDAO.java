/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.GaaClientes;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u05594757139
 */
public class ClientesDAO extends AbstractDAO{

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
        Criteria criteria = session.createCriteria(GaaClientes.class);
        criteria.add(Restrictions.eq("gaaIdClientes", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GaaClientes.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listCLientes(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GaaClientes.class);
        criteria.add(Restrictions.like("gaaNome", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    public Object listEstado(String estado) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GaaClientes.class);
        criteria.add(Restrictions.like("gaaEstado", "%" + estado + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listClienteEstado(String nome , String estado) {

        session.beginTransaction();
        Criteria criteria = session.createCriteria(GaaClientes.class);
        criteria.add(Restrictions.like("gaaNome", "%" + nome + "%"));
        criteria.add(Restrictions.like("gaaEstado", "%" + estado + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
}
