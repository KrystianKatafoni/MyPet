package net.azurewebsites.mypet.repositories;

import net.azurewebsites.mypet.domain.Comment;
import org.springframework.data.repository.CrudRepository;
/**
 * @author Krystian Katafoni
 * @since 05.11.2017
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
