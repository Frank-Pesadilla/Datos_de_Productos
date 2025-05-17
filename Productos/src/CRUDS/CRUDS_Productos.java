/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDS;

import Hibernate_Util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import pojos.Productos;

/**
 *
 * @author Frank
 */
public class CRUDS_Productos {
    public static boolean insertar(String Nombre_Producto, Integer Cantidad, String Ubicacion){
        boolean     flag=false;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Productos.class);
        criteria.add(Restrictions.eq("nombre56", Nombre_Producto));
        Productos insrt = (Productos)criteria.uniqueResult();
        Transaction transactions = null;
         try{
             transactions = session.beginTransaction();
             if(insrt==null){
                 insrt = new Productos();
                 insrt.setNombre56(Nombre_Producto);
                 insrt.setCantidad56(Cantidad);
                 insrt.setUbicacion56(Ubicacion);
                 insrt.setEstado56(true);
                 
                 session.save(insrt);
                 flag=true;
                 
             }
             transactions.commit();
        }
        catch(Exception e){
             System.out.println("error "+e);
             transactions.rollback();
             
         }finally{
             session.close();
         }
        return flag;
    }
    
    public static boolean modificar(Integer Id_Producto, String Nombre_Producto, Integer Cantidad, String Ubicacion){
        boolean     flag=false;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Productos.class);
        criteria.add(Restrictions.eq("idProductos56", Id_Producto));
        Productos update = (Productos)criteria.uniqueResult();
        Transaction transactions = null;
         try{
             transactions = session.beginTransaction();
             if(update !=null){
                 
                 update.setNombre56(Nombre_Producto);
                 update.setCantidad56(Cantidad);
                 update.setUbicacion56(Ubicacion);
                 session.save(update);
                 flag=true;
                 
             }
             transactions.commit();
             
         }
         
         catch(Exception e){
             System.out.println("error "+e);
             transactions.rollback();
             
         }finally{
             session.close();
         }
        return flag;
    }
    
    public static boolean eliminar(Integer Id_Producto){
        boolean     flag=false;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Productos.class);
        criteria.add(Restrictions.eq("idProductos56", Id_Producto));
        Productos update = (Productos)criteria.uniqueResult();
        Transaction transactions = null;
         try{
             transactions = session.beginTransaction();
             if(update !=null){
                 
                 update.setEstado56(false);
                 flag=true;
                 
             }
             transactions.commit();
             
         }
         
         catch(Exception e){
             System.out.println("error "+e);
             transactions.rollback();
             
         }finally{
             session.close();
         }
        return flag;
    }
    
    public static List<Productos> universo(){
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    List<Productos> lst = null;
    try{
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Productos.class);
        criteria.add(Restrictions.eq("estado56",true));
            criteria.setProjection(Projections.projectionList()
            .add(Projections.property("idProductos56"))
            .add(Projections.property("nombre56"))
            .add(Projections.property("cantidad56"))
            .add(Projections.property("ubicacion56"))
            );
            criteria.addOrder(Order.desc("idProductos56"));
            lst = criteria.list();
           }catch(HibernateException e){
               System.out.println("error" + e);
           }finally{
                session.getTransaction().commit();
    }
    return lst;
    
    }
}
