package com.spring.work.carservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.work.carservice.entity.User;
import com.spring.work.carservice.model.Filter;
import com.spring.work.carservice.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private EntityManager em;

    public User save(User user) {
	user.setPassword(encoder.encode(user.getPassword()));

	return repository.save(user);
    }

    public List<User> getAll() {
	return repository.findAll();
    }

    public User getByEmail(String email) {

	return repository.findByEmail(email);
    }

    public void deleteById(long id) {
	repository.deleteById(id);
    }

    public List<User> search(Filter filter) {
	StringBuilder sb = new StringBuilder("SELECT e FROM User e WHERE ");
	Map<Integer, String> params = new HashMap<Integer, String>();
	int index = 1;
	if (filter.getEmail() != null) {
	    sb.append("e.email = ?").append(index);
	    params.put(index, filter.getEmail());
	    index++;
	}
	if (filter.getFirstName() != null) {
	    if (index > 1)
		sb.append(" AND ");
	    sb.append("e.firstName = ?").append(index);
	    params.put(index, filter.getFirstName());
	    index++;
	}
	if (filter.getLastName() != null) {
	    if (index > 1)
		sb.append(" AND ");
	    sb.append("e.lastName = ?").append(index);
	    params.put(index, filter.getLastName());
	}

	TypedQuery<User> query = em.createQuery(sb.toString(), User.class);
	params.forEach((key, value) -> {
	    query.setParameter(key, value);
	});
	List<User> users = query.getResultList();
	return users;
    }

    public List<User> findByFirstName(String firstName) {
	return repository.findByFirstName(firstName);
    }

}
