package net.azurewebsites.mypet.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * @author Krystian Katafoni
 * @since 07.11.2017
 * Author class which represents author of comment.
 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nickname;
}
