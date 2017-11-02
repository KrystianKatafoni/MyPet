package net.azurewebsites.mypet.domain.units;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class UnitOfLength extends Unit {
}
