package ru.obydennov.authorization.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.obydennov.authorization.model.entity.Action;

@Repository
public interface ActionRepository extends CrudRepository<Action, Long> {
}
