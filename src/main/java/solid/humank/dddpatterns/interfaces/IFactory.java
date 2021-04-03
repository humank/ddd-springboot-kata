package solid.humank.dddpatterns.interfaces;


import solid.humank.dddpatterns.baseclasses.AggregateRoot;
import solid.humank.dddpatterns.baseclasses.EntityId;

public interface IFactory<T extends AggregateRoot, U extends EntityId> {

    T create(Object param);
}
