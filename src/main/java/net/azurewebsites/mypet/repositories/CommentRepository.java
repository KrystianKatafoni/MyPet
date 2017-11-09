package net.azurewebsites.mypet.repositories;

import net.azurewebsites.mypet.domain.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
