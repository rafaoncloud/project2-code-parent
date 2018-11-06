package ejb;

import data.Manager;
import utils.Utils;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Stateless
@LocalBean
public class ManagerEJB
{

    @PersistenceContext
    private EntityManager em;

    @Inject
    CountryEJB countryEJB;

    @Inject
    GenericUserEJB genericUserEJB;

    public ManagerEJB() { }

    public void addManager() throws Exception {

        try
        {

            dto.Manager manager = new dto.Manager();
            manager.setAddress( "" );
            manager.setBirthDate(new Date(  ) );
            manager.setCountry(countryEJB.getCountry("", 172));
            manager.setCreateDate( new Date(  ) );
            manager.setEmail( "admin" );
            manager.setName( "admin" );
            manager.setPassword( "admin" );
            manager.setPhoneNumber( "43443423432" );

            data.Manager managerEntity = new data.Manager();
            Utils.getDozerBeanMapper().map(manager,managerEntity);

            addMamagerCRUD(managerEntity);

            Utils.getLogger().info("User " + manager.getEmail() + " created.");
        }
        catch(Exception ex)
        {
            Utils.getLogger().error(ex.getMessage());
            throw ex;
        }
    }

    public void addManager(dto.Manager manager) throws Exception {

        try
        {
            data.Manager managerEntity = new data.Manager();
            Utils.getDozerBeanMapper().map(manager,managerEntity);

            addMamagerCRUD(managerEntity);

            Utils.getLogger().info("User " + manager.getEmail() + " created.");
        }
        catch(Exception ex)
        {
            Utils.getLogger().error(ex.getMessage());
            throw ex;
        }
    }

    public List<Manager> getAllManagers(String token) {
        return null;
    }

    public Manager getManager(long id) {
        return null;
    }

    public void updateManager(String token, Manager manager) {

    }

    public void deleteManager(String token, long id) {

    }


    //
    // CRUD Operations
    //
    private void addMamagerCRUD(data.Manager manager) throws Exception {
        // CRUD Operation
        try
        {
            //Verificar se o email já existe na BD
            if(genericUserEJB.getGenericUserByEmail(manager.getEmail()) != null)
                throw new Exception("Account already exists!");

            em.persist(manager);

            Utils.getLogger().info(manager.getEmail() + " User Created.");
        }
        catch (Exception e)
        {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }
    private data.Manager getManagerCRUD(long id) throws Exception {
        // CRUD Operation
        data.Manager manager = null;
        try
        {
            manager = em.find(data.Manager.class, id);

            if (manager == null) {
                throw new Exception("Manager with " + id + " not found.");
            }

            return manager;
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }
    private List<Manager> getAllManagersCRUD() throws Exception {
        // CRUD Operation
        try
        {
            String queryText = "from Manager c";
            Query query = em.createQuery(queryText);

            return query.getResultList();
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }
    private void updateManagerCRUD(data.Manager manager) throws Exception {
        // CRUD Operation
        try
        {
            data.Manager managerEntity = getManagerCRUD(manager.getId());
            Utils.getDozerBeanMapper().map(manager,managerEntity);

            Utils.getLogger().info("ID " + managerEntity.getId() + " Manager was updated.");
        } catch (Exception ex) {
            Utils.getLogger().error(ex.getMessage());
            throw ex;
        }
    }
    private void deleteManagerCRUD(long id) throws Exception {
        // CRUD Operation
        try {
            try {
                em.remove(getManagerCRUD(id));

                Utils.getLogger().info(id + " ID multimedia content deleted.");
            } catch (Exception e) {
                Utils.getLogger().error(e.getMessage());
                throw e;
            }

            Utils.getLogger().info("Multimedia Content " + id + " deleted.");
        } catch (Exception e) {
            Utils.getLogger().error(e.getMessage());
            throw e;
        }
    }
}
