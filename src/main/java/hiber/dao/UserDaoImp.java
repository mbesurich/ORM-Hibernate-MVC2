package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User", User.class);
      List<?> results = (List<?>) query.getResultList();
      List<User> users = new ArrayList<>();
      return results.stream().map(e -> (User)e).collect(Collectors.toList());
//      Query query = sessionFactory.getCurrentSession().createQuery("from User u", User.class);
//      return Collections.checkedList(query.getResultList(), User.class);

   }

   public User getUserByCar(String model, int series){
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User user where user.car.model = :model and user.car.series = :series");
      query.setParameter("model", model);
      query.setParameter("series", series);
      return query.setMaxResults(1).getSingleResult();
   }

}
