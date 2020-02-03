package com.sanchous.crello.user;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Alexandr S. Somov
 * Все права принадлежат автору. За использование без ведома и разрешения автора вам будет стыдно.
 */
public interface UserRepository extends CrudRepository<User, String> {

}
